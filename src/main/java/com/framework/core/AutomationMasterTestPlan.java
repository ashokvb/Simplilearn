package com.framework.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.framework.base.constants.FrameworkConstants;
import com.framework.driver.WebUIDriver;
//import com.framework.testrail.APIException;
//import com.framework.testrail.TestrailAPI;
import com.framework.util.ReadProperties;
import com.framework.util.TestReportsLog;
import com.framework.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

public abstract class AutomationMasterTestPlan {

	public Xls_Reader xls;
	public WebDriver driver;
	public String testRunId;
	public String sectionId;
	public String projId;
	//public TestrailAPI testRailObj;
	public boolean skipTestCase = false;
	
	public AutomationMasterTestPlan() {
		xls = new Xls_Reader(FrameworkConstants.DATA_XLS_RESTAPI);
	}

	@BeforeSuite(alwaysRun = false)
	public void beforeTestSuite(final ITestContext testContext) throws IOException//, APIException
	{
//		testRailObj = TestrailAPI.getInstanceUsingDoubleLocking();
//		testRailObj.getAPIClient();
//		projId = testRailObj.getProjects(ReadProperties.getTestRailProp().getProperty("projectName"));
//		sectionId = testRailObj.addSetion(projId);
//		testRunId = testRailObj.createTestRun(projId);
	}
	
	@BeforeMethod
	public void beforeTestMethod(final Object[] parameters, final Method method, final ITestContext testContex,
			final XmlTest xmlTest) {

		String testName = parameters[0].toString();
		TestReportsLog.startTest(testName);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTestMethod(final Object[] parameters, final Method method, final ITestContext testContex,
			final XmlTest xmlTest) throws MalformedURLException, IOException //, APIException 
	{

		String testName = parameters[0].toString();

		TestReportsLog.log(LogStatus.INFO, " Finish method " + testName);
		int startIndex = 0;
		int endIndex = 0;

		System.out.println("Inside afterTestMethod");

		/*
		if (skipTestCase == false) {
			String testCaseId = "";
			JSONArray a = testRailObj.getTestCases(projId);
			List<Log> logLst = null;
			List<Log> logSubLst = null;

			if (null != TestReportsLog.getTest()) {
				logLst = TestReportsLog.getTest().getTest().getLogList();

				int i = 0;
				for (Log log : logLst) {
					i++;
					if (null != log && log.getDetails().equals("Start method " + testName)) {
						System.out.println("Start method " + testName);
						startIndex = i;
					}
					if (null != log && log.getDetails().equals("Finish method " + testName)) {
						System.out.println("Finish method " + testName);
						endIndex = i - 1;
					}
				}
				System.out.println("Setting logSubLst");
				logSubLst = TestReportsLog.getTest().getTest().getLogList().subList(startIndex, endIndex);
			}

			JSONArray testIdsRes = testRailObj.getTestIds(TestrailAPI.getRunId());
			String testId = getTestId(testIdsRes, testName);

			testCaseId = testNameExist(a, testName);
			if (testCaseId != "") {
				testRailObj.updateTestResultsStatus(TestrailAPI.getRunId(), testId, testCaseId, logSubLst);
			} else {
				testCaseId = testRailObj.createTestCases(testName, projId, sectionId);
				testRailObj.updateTestResultsStatus(TestrailAPI.getRunId(), testId, testCaseId, logSubLst);
			}
		}
		*/

		if (TestReportsLog.getInstance() != null) {
			try {
				TestReportsLog.endTest();
				TestReportsLog.getInstance().flush();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public String getTestId(JSONArray a, String testName) {
		String id = getId(a, testName);
		return id;
	}

	public String getId(JSONArray a, String testName) {
		String id = "";
		for (int i = 0; i < a.size(); i++) {
			JSONObject obj1 = (JSONObject) a.get(i);
			// System.out.println(" title "+obj1.get("title")+" testName :-"+testName);
			if (obj1.get("title").equals(testName))
				id = obj1.get("id").toString();
		}
		return id;
	}
}
