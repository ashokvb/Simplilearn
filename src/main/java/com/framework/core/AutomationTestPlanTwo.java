package com.framework.core;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.framework.base.constants.BrowserType;
import com.framework.base.constants.FrameworkConstants;
import com.framework.driver.WebUIDriver;
import com.framework.testrail.APIException;
//import com.framework.testrail.APIException;
import com.framework.util.ReadProperties;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.framework.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;


public class AutomationTestPlanTwo {

	public Xls_Reader xls;
	public WebDriver driver;
	public boolean skipTestCase = false;

	public AutomationTestPlanTwo() {
		this.xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);

	}

	public AutomationTestPlanTwo(Xls_Reader xls) {
		this.xls = xls;
	}

	@BeforeSuite(alwaysRun = false)
	public void beforeTestSuite(final ITestContext testContext) throws IOException {
		SeleniumTestsContextManager.initGlobalContext(testContext);
		SeleniumTestsContextManager.initThreadContext(testContext, null);
	}

	/**
	 * Configure Test Params setting.
	 *
	 * @param xmlTest
	 * @throws APIException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	@BeforeTest(alwaysRun = true)
	public void beforeTest(final ITestContext testContext, final XmlTest xmlTest)
			throws MalformedURLException, IOException {
		SeleniumTestsContextManager.initTestLevelContext(testContext, xmlTest);
	}

	@BeforeMethod
	public void beforeTestMethod(final Object[] parameters, final Method method, final ITestContext testContex,
			final XmlTest xmlTest) {
		SeleniumTestsContextManager.initThreadContext(testContex, xmlTest);
		if (method != null) {
			SeleniumTestsContextManager.getThreadContext().setAttribute(SeleniumTestsContext.TEST_METHOD_SIGNATURE,
					buildMethodSignature(method, parameters));

			Test test = method.getAnnotation(Test.class);
//			TestReportsLog.startTest(test.testName());
//		    TestReportsLog.startTest(test.testName(), test.description());
		    TestReportsLog.startTest(method.getName(), test.description());
			String browser = "";
			Object value = parameters[0];
			System.out.println(test.testName());
			if (value instanceof StringHash) {
				browser = ((StringHash) value).get("Browser").toString();
			}
			if (!browser.contentEquals("Null")) {
				TestReportsLog.getTest().log(LogStatus.INFO, " Start method " + method.getName());
				if (!browser.isEmpty()) {
					WebUIDriver.getWebUIDriver().setBrowser(browser);
					
			//		driver = WebUIDriver.getWebDriver(true);
					
				/*	WebUIDriver.getWebUIDriver().setImplicitlyWaitTimeout(
							Double.valueOf(ReadProperties.getConfigProp().getProperty("implicitWaitTimeout")));
					WebUIDriver.getWebUIDriver()
					.setExplicitTimeout(Integer.valueOf(ReadProperties.getConfigProp().getProperty("timeout")));
					*/WebUIDriver.getWebUIDriver().maximizeWindow();
		//			driver.manage().window().setPosition(new Point(0, -2000));
		//			driver.manage().window().setSize(new Dimension(1024,500));
		//			JavascriptExecutor js = (JavascriptExecutor) driver;
		//		    ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='60%';");
				    //Zoom Out
		//		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		//		    executor.executeScript("document.body.style.zoom = '0.6'");
					driver.get(ReadProperties.getConfigProp().getProperty("url2"));
					
					TestReportsLog.getTest().log(LogStatus.INFO,
							"Opening browser " + BrowserType.getBrowserType(WebUIDriver.getWebUIDriver().getBrowser()));
				}
			}
		}
	}
	/**
	 * clean up.
	 * 
	 * @param parameters
	 * @param method
	 * @param testContex
	 * @param xmlTest
	 * @throws APIException
	 * @throws IOException
	 * @throws MalformedURLException
	 */

	@AfterMethod(alwaysRun = true)
	public void afterTestMethod(final Object[] parameters, final Method method, final ITestContext testContex,
			final XmlTest xmlTest) throws MalformedURLException, IOException, InterruptedException {

		final List<TearDownService> serviceList = SeleniumTestsContextManager.getThreadContext().getTearDownServices();
		if (serviceList != null && !serviceList.isEmpty()) {
			for (final TearDownService service : serviceList) {
				service.tearDown();
			}
		}

		TestReportsLog.log(LogStatus.INFO, " Finish method " + method.getName());

		if (TestReportsLog.getInstance() != null) {
			try {
				TestReportsLog.endTest();
				TestReportsLog.getInstance().flush();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		WebUIDriver.cleanUp();
	}

	/*
	 * @AfterTest public void afterTest(final Object[] parameters, final Method
	 * method, final ITestContext testContex, final XmlTest xmlTest) throws
	 * MalformedURLException, IOException, APIException {
	 * 
	 * WebUIDriver.cleanUp(); if(TestReportsLog.getInstance() != null) { try {
	 * TestReportsLog.endTest(); TestReportsLog.getInstance().flush(); }catch
	 * (Exception e) { System.out.println(e.getMessage()); } }
	 * 
	 * }
	 */

	// To find the testID
	public String getTestId(JSONArray a, String testName) {
		String id = getId(a, testName);
		return id;
	}

	public String getId(JSONArray a, String testName) {
		String id = "";
		for (int i = 0; i < a.size(); i++) {
			JSONObject obj1 = (JSONObject) a.get(i);
			// System.out.println(" title "+obj1.get("title")+" testName
			// :-"+testName);
			if (obj1.get("title").equals(testName))
				id = obj1.get("id").toString();
		}
		return id;
	}

	@AfterSuite(alwaysRun = false)
	public void afterTestSuite() {
		System.out.println("afterTestSuite...............cleanUp");
	}

	private String buildMethodSignature(final Method method, final Object[] parameters) {
		return method.getDeclaringClass().getCanonicalName() + "." + method.getName() + "("
				+ buildParameterString(parameters) + ")";
	}

	/**
	 * Remove name space from parameters.
	 *
	 * @param parameters
	 *
	 * @return
	 */
	private String buildParameterString(final Object[] parameters) {
		final StringBuffer parameter = new StringBuffer();

		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				if (parameters[i] == null) {
					parameter.append("null, ");
				} else if (parameters[i] instanceof java.lang.String) {
					parameter.append("\"").append(parameters[i]).append("\", ");
				} else {
					parameter.append(parameters[i]).append(", ");
				}
			}
		}

		if (parameter.length() > 0) {
			parameter.delete(parameter.length() - 2, parameter.length() - 1);
		}

		return parameter.toString();
	}
	
}
