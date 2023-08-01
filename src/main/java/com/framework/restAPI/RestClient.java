package com.framework.restAPI;

import java.util.HashMap;

import org.testng.ITestContext;

import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.framework.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
	private StringHash Data;
	private Xls_Reader xls;
	private ITestContext context;
	private String access_token;

	public RestClient() {
	}

	public RestClient(StringHash Data, Xls_Reader xls, ITestContext context) {
		this.Data = Data;
		this.xls = xls;
		this.context = context;

		this.access_token = getTokenFromContext();
	}

	public Response get(String url) {
		if (url.isEmpty()) {
			return null;
		}
		RequestSpecification request = RestAssured.given();

		if (!access_token.isEmpty()) {
			request.header("Authorization", formatAccessToken());
		}

		return request.get(url);
	}

	public int getResponseCode(Response resp) {
		if (resp == null) {
			return -1;
		}

		return resp.getStatusCode();
	}

	public Response post(StringHash Data, String url) {
		if (url.isEmpty()) {
			return null;
		}

		return prepareRequest(Data).post(url);
	}

	public Response put(StringHash Data, String url) {
		if (url.isEmpty()) {
			return null;
		}

		return prepareRequest(Data).put(url);
	}

	public Response delete(StringHash Data, String url) {
		if (url.isEmpty()) {
			return null;
		}

		return prepareRequest(Data).delete(url);
	}

	@SuppressWarnings("unchecked")
	private RequestSpecification prepareRequest(StringHash Data) {

		String contentType = Data.get("ContentType");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", contentType);
		request.header("Authorization", formatAccessToken());

		if (!contentType.isEmpty()) {
			if (contentType.equalsIgnoreCase("application/x-www-form-urlencoded")) {
				request.formParams(
						DataUtil.getDataAsHashMap(DataUtil.getDataFromSheet(xls, Data.get("RequestBodyFields"))));
			} else if (contentType.equalsIgnoreCase("application/json")) {

				request.body(Data.get("JSONStructure").toString());
			}

			if (!this.access_token.isEmpty()) {
				request.auth().oauth2(this.access_token);
			}
		} else {
			TestReportsLog.log(LogStatus.ERROR,
					"prepareRequest ::- ContentType is Empty. Can't create a RestAPI Request.");
		}
		return request;
	}

	public String getFieldValueFromResponse(Response resp, String field) {
		if (field.isEmpty()) {
			return "";
		}

		JsonPath jsonPathEvaluator = resp.jsonPath();

		return jsonPathEvaluator.get(field);
	}

	public String getValueFromResponse(Response resp, String field) {
		if (field.isEmpty()) {
			return "";
		}

		// JsonPath jsonPathEvaluator = resp.jsonPath();
		String rbody = resp.getBody().asString();
		JsonPath jp = new JsonPath(rbody);

		// JsonPath jsonPathEvaluator = resp.getBody().asString();

		// return jsonPathEvaluator.get(field).toString();
		return jp.getString(field);
	}

	public String getFirstFieldValueFromResponseList(Response resp, String field) {
		if (field.isEmpty()) {
			return "";
		}

		JsonPath jsonPathEvaluator = resp.jsonPath();

		return jsonPathEvaluator.getList(field).get(0).toString();
	}

	private String formatAccessToken() {

		return "Bearer " + this.access_token;
	}

	@SuppressWarnings({ "unchecked" })
	public HashMap<String, Object> getFieldsAsHash(StringHash Data, Xls_Reader xls, String field) {

		TestReportsLog.log(LogStatus.INFO, "getFieldsAsHash ::- Formatting Data fields in to HashMap");

		HashMap<String, Object> param = new HashMap<String, Object>();

		if (!field.isEmpty()) {
			param = DataUtil.getDataAsHashMap(DataUtil.getDataFromSheet(xls, field));
		}

		TestReportsLog.log(LogStatus.INFO, "getFieldsAsHash ::- Formatting Data fields in to HashMap completed!!");

		return param;
	}

	public Response callApi() {

		Response resp = null;
		String apiCallType = Data.get("APICall");
		URL url = new URL(Data.get("URL"), "");

		if (apiCallType.compareToIgnoreCase("GET") == 0) {
			resp = get(url.getURL());
		} else if (apiCallType.compareToIgnoreCase("POST") == 0) {
			resp = post(Data, url.getURL());
		} else if (apiCallType.compareToIgnoreCase("PUT") == 0) {
			resp = put(Data, url.getURL());
		} else if (apiCallType.compareToIgnoreCase("DELETE") == 0) {
			resp = delete(Data, url.getURL());
		}

		if (resp != null) {
			fetchAccessTokenFromResponse(resp);
		}

		return resp;
	}

	public void fetchAccessTokenFromResponse(Response resp) {

		if (this.Data.get("TokenAction").compareToIgnoreCase("Fetch") == 0) {
			String access_token = getFieldValueFromResponse(resp, this.Data.get("TokenField"));

			context.setAttribute(this.Data.get("TokenField"), access_token);
		}
	}

	public void fetchBondNumberFromResponse(Response resp) {
		String bondNumber = getFirstFieldValueFromResponseList(resp, "BondNumber");
		context.setAttribute("BondNumber", bondNumber);
	}

	public void fetchAnchorBondKeyFromResponse(Response resp) {
		String bondNumber = getFieldValueFromResponse(resp, "BondNumber");
		context.setAttribute("BondNumber", bondNumber);
	}

	private String getTokenFromContext() {
		String token = "";
		if (this.Data.get("TokenAction").compareToIgnoreCase("Use") == 0) {
			Object obj = context.getAttribute(Data.get("TokenField"));
			if (obj != null) {
				token = obj.toString();
			}
		}
		return token;
	}
}
