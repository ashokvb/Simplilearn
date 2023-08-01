package com.framework.filedrop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.google.gson.Gson;
import com.relevantcodes.extentreports.LogStatus;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.config.HttpClientConfig.Builder;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

public class KibanaLogSearch {

	private String userName;
	private String password;
	private String url;

	public KibanaLogSearch(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public JestClient createClient() {
		TestReportsLog.log(LogStatus.INFO, "Creating HttpClient");

		JestClient client = null;
		try {
			JestClientFactory factory = new JestClientFactory();

			Builder httpClientConfig = new HttpClientConfig.Builder(this.url).multiThreaded(true);
			httpClientConfig.defaultCredentials(this.userName, this.password);

			// Per Sarguna, the readTimeout should be here with default 20000
			httpClientConfig.readTimeout(20000);

			factory.setHttpClientConfig(httpClientConfig.build());
			client = factory.getObject();

			TestReportsLog.log(LogStatus.INFO, "HttpClient Created successfully!!");
		} catch (Exception e) {
			TestReportsLog.log(LogStatus.ERROR, e.getMessage());
		}

		return client;
	}

	@SuppressWarnings("unchecked")
	public int getDataCountFromJason(SearchResult result) {
		int count = -1;
		if (result != null) {
			TestReportsLog.log(LogStatus.INFO, "Retriving data from Json");

			result.setJsonMap(new Gson().fromJson(result.getJsonString(), Map.class));
			result.setPathToResult("hits/hits/_source");

			TestReportsLog.log(LogStatus.INFO, "Retrieved data from Json successfully!!");

			count = result.getSourceAsObjectList(DataFields.class, false).size();
		}
		return count;
	}

	public Search dynamicQueryBuilder(Map<String, Object> queryFields, String queryType) {
		Search search = null;
		if (queryFields.size() > 0) {
			TestReportsLog.log(LogStatus.INFO, "Building Kibana search query");

			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

			if (queryType.isEmpty() || queryType.equals("Match")) {
				for (Map.Entry<String, Object> entry : queryFields.entrySet()) {
					boolQuery.must(QueryBuilders.matchQuery(entry.getKey(), entry.getValue()).operator(Operator.AND));
				}
			} else if (queryType.equals("Phrase")) {
				for (Map.Entry<String, Object> entry : queryFields.entrySet()) {
					boolQuery.must(QueryBuilders.matchPhraseQuery(entry.getKey(), entry.getValue()));
				}
			}

			searchSourceBuilder.query(boolQuery);
			search = new Search.Builder(searchSourceBuilder.toString()).build();

			TestReportsLog.log(LogStatus.INFO, "Kibana search query built successfully!!");
		} else {
			TestReportsLog.log(LogStatus.ERROR,
					"KibanaLogSearch ::- dynamicQueryBuilder insufficient data to build search query!!");
		}

		return search;
	}

	public SearchResult execute(Search search) {
		SearchResult result = null;

		TestReportsLog.log(LogStatus.INFO, "Executing Kibana Search Query...");

		if (search != null) {
			try {
				result = createClient().execute(search);

				TestReportsLog.log(LogStatus.INFO, "Query executed successfully!!");
			}

			catch (IOException e) {

				TestReportsLog.log(LogStatus.ERROR, "KibanaLogSearch ::- SearchResult " + e.getMessage());

			}
		}
		return result;
	}

	public Map<String, Object> prepareAuditKibanaHashData(StringHash Data, String fileName) {
		Map<String, Object> queryFields = new HashMap<String, Object>();

		String expectedResult = Data.get("ExpectedResult").toString();
		String fieldComponent = Data.get("FieldComponent").toString();

		if (!expectedResult.isEmpty() && !fileName.isEmpty()) {
			TestReportsLog.log(LogStatus.INFO,
					"Preparing data for AuditKibana query. Expected Result is:- " + expectedResult);

			queryFields.put("filename", fileName);
			queryFields.put("message", expectedResult);

			if (!fieldComponent.isEmpty()) {
				queryFields.put("fields.component", fieldComponent);
			}

			TestReportsLog.log(LogStatus.INFO, "Data ready for AuditKibana query");
		}
		return queryFields;
	}

	public Map<String, Object> prepareLogKibanaHashData(StringHash Data, String fileName) {
		Map<String, Object> queryFields = new HashMap<String, Object>();
		String expectedLogResult = Data.get("ExpectedResult").toString();
		String fieldComponent = Data.get("FieldComponent").toString();

		if (!expectedLogResult.isEmpty()) {
			expectedLogResult = expectedLogResult.replaceAll("%FILENAME%", fileName);// FileTransfer.getFileName());
			TestReportsLog.log(LogStatus.INFO,
					"Preparing data for LogKibana query. Expected Result is:- " + expectedLogResult);

			queryFields.put("message", expectedLogResult);

			if (!fieldComponent.isEmpty()) {
				queryFields.put("fields.component", fieldComponent);
			}

			TestReportsLog.log(LogStatus.INFO, "Data ready for LogKibana query");
		}

		return queryFields;
	}
}
