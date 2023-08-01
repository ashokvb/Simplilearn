package com.framework.testrail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.framework.util.ReadProperties;
import com.relevantcodes.extentreports.model.Log;
/**
 * Class is used to do invoke Test rail through the APIClient
 * @author Dhandapani
 *
 */
public class TestrailAPI {
	
	private static TestrailAPI instance;
	private static String runId;
    
    public static String getRunId() {
		return runId;
	}

	public static void setRunId(String runId) {
		TestrailAPI.runId = runId;
	}

	private TestrailAPI(){}
    
	public static TestrailAPI getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (TestrailAPI.class) {
	            if(instance == null){
	                instance = new TestrailAPI();
	            }
	        }
	    }
	    return instance;
	}
	
	/**
	 * The method initialize the APIClient and used to connect the Test Rail
	 * @return APIClient
	 * @param Test Run URL, Username, Password
	 */
	public APIClient getAPIClient()
	{
	    Properties prop;
		APIClient client = null;
		try {
			client = new APIClient(ReadProperties.getTestRailProp().getProperty("url"));
			client.setUser(ReadProperties.getTestRailProp().getProperty("username"));
			client.setPassword(ReadProperties.getTestRailProp().getProperty("password"));
			return client;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return client;
	}
	/*
	 * The method get the list of projects from Test Rail
	 */
	public String getProjects(String projectName) throws MalformedURLException, IOException, APIException
	{
		JSONArray c = (JSONArray) getAPIClient().sendGet("get_projects");
		System.out.println(c.size());
		System.out.println(c.get(0));
		
		for(int i=0; i < c.size();i++)
		{
			JSONObject project = (JSONObject) c.get(i);
			JSONObject a = (JSONObject) getAPIClient().sendGet("get_project/"+project.get("id"));
			if(projectName.equals(a.get("name"))){
				
				return a.get("id").toString();
			}
		}
		return "";
	}
	public String addSetion(String projId) throws MalformedURLException, IOException, APIException
	{
		Map<String,Object> run = new HashMap<String,Object>();
		run.put("name", " Test cases ");
		
		JSONObject a = (JSONObject) getAPIClient().sendPost("add_section/"+projId,run);
		//System.out.println("Section Added"+a);	
		return a.get("id").toString();
	}
	/*
	 * The method get list of test cases from Test Rail
	 */
	public String createTestCases(String testName,String projId,String sectionId) throws MalformedURLException, IOException, APIException
	{
		
			Map<String,Object> run = new HashMap<String,Object>();
			run.put("title", testName);
			
			JSONObject a = (JSONObject) getAPIClient().sendPost("add_case/"+sectionId,run);
			//System.out.println("Testcase created "+a);
			String testCaseId= a.get("id").toString();
			
		return testCaseId;
	}
	/*
	 * The method get list of test cases from Test Rail
	 */
	public JSONArray getTestCases(String projectId) throws MalformedURLException, IOException, APIException
	{
			JSONArray testCasesRes = (JSONArray) getAPIClient().sendGet("get_cases/"+projectId);
			
			//System.out.println(" getTestCases:----------"+testCasesRes);
		return testCasesRes;
			
	}
	
	public JSONArray getTestIds(String testRunId) throws MalformedURLException, IOException, APIException
	{
			JSONArray testIdsRes = (JSONArray) getAPIClient().sendGet("get_tests/"+testRunId);
			
			//System.out.println(" TestrailAPI :: getTestIds:----------"+testIdsRes);
		return testIdsRes;
			
	}
	/*
	 * The method create the test run with the name of Test Run with Current date
	 */
	public String createTestRun(String projectId) throws MalformedURLException, IOException, APIException
	{
		final DateFormat sdf = new SimpleDateFormat(ReadProperties.getTestRailProp().getProperty("dateFormat"));
		Date currentDate = new Date();
		String testRun = new String("Test Run " + sdf.format(currentDate));
		Map<String,Object> run = new HashMap<String,Object>();
		run.put("status_id", new Integer(1));
		run.put("name", testRun);
		
		JSONObject runTest = (JSONObject) getAPIClient().sendPost("add_run/"+projectId,run);
		runId = runTest.get("id").toString();
		
		//System.out.println(" Test Run Created" +runTest);
		return runId;
	}
	/*
	 * 
	 */
	/*public void updateTestStatus(String testRunId,String testCaseId ) throws MalformedURLException, IOException, APIException
	{
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("status_id", new Integer(1));
		data.put("comment", "This test worked fine!");
		
		JSONObject r = (JSONObject) getAPIClient().sendPost("add_result_for_case/"+testRunId+"/"+testCaseId, data);
	}*/
	
	public void updateTestResultsStatus(String testRunId,String testId,String testCaseId,List<Log> logSubLst ) throws MalformedURLException, IOException, APIException
	{
		//System.out.println(" TestRaiAPI :- "+testCaseId + "testId :-"+testId);
		JSONObject obj=new JSONObject();
		JSONArray results=new JSONArray();
		
		for(int i=0;i<logSubLst.size();i++){
			int status_id=1;
			//System.out.println(logSubLst.get(i).getLogStatus().toString()+" LogStatus");
				if("error".equalsIgnoreCase(logSubLst.get(i).getLogStatus().toString()) ||
					"fail".equalsIgnoreCase(logSubLst.get(i).getLogStatus().toString())){
					status_id=5;
				}
			JSONObject js=new JSONObject();
			js.put("case_id", testCaseId);
			js.put("status_id", new Integer(status_id));
			js.put("test_id", testId);
			js.put("comment", logSubLst.get(i).getDetails());
			results.add(js);
			
			obj.put("test_id", testId);
			obj.put("results", results);
		}
		//System.out.println("results :-"+obj.toJSONString());
		JSONArray result = (JSONArray) getAPIClient().sendPost("add_results_for_cases/"+testRunId, obj);
		
		//System.out.println(" TestRaiAPI :- updateTestResultsStatus()"+result);

		for(int i=0;i<results.size();i++){
			JSONObject js=(JSONObject)results.get(i);
			if(js.get("status_id").toString().equals("5")){
				updateTestCaseStatus(js.get("test_id").toString(),Integer.parseInt(js.get("status_id").toString()));
			}
		}
	}
	
	public void updateTestCaseStatus(String testId,int status) throws MalformedURLException, IOException, APIException{
		
		JSONObject obj=new JSONObject();
		obj.put("test_id", testId);
		obj.put("status_id", new Integer(status));
	
		JSONObject result = (JSONObject) getAPIClient().sendPost("add_result/"+testId, obj);
		
	}

}
