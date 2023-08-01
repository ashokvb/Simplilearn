package com.framework.util;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.base.constants.FrameworkConstants;
import com.framework.driver.WebUIDriver;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestReportsLog {
	private static ExtentReports extent;// = getInstance();
	private static ExtentTest reportLogSession;
	private static ExtentTest extentTest;
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

		
	public static ExtentTest getReportLogSession() {
		return reportLogSession;
	}

	public static void setReportLogSession(ExtentTest reportLogSession) {
		TestReportsLog.reportLogSession = reportLogSession;
	}
	
	public static synchronized void log(LogStatus logStatus, String details){
		//reportLogSession.log(logStatus, details);
		if(logStatus == LogStatus.FAIL || logStatus == LogStatus.ERROR){
			takeScreenShot();
		}
		getTest().log(logStatus, details);
	}
	public static synchronized void logpass(LogStatus logStatus, String details){
		//reportLogSession.log(logStatus, details);
		if(logStatus == LogStatus.PASS || logStatus == LogStatus.ERROR){
			takeScreenShot();
		}
		getTest().log(logStatus, details);
	}
	
	public static synchronized void logfail(LogStatus logStatus, String details){
		//reportLogSession.log(logStatus, details);
		if(logStatus == LogStatus.FAIL || logStatus == LogStatus.ERROR){
		}
		getTest().log(logStatus, details);
	}
//	public static synchronized ExtentTest startTest(String testName) {
//	 ExtentTest test = getInstance().startTest(testName);
//       extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);            
//   return test;
//}
//public static synchronized ExtentTest startTest1(String description) {
//	ExtentTest test = getInstance().startTest(description);
//   extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);            
//return test;
//}

   public static synchronized ExtentTest startTest(String testName, String desc) {
	 ExtentTest test = getInstance().startTest(testName, desc);
       extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);            
   return test;
   }

	public static synchronized ExtentTest startTest(String testName) {
		 ExtentTest test = getInstance().startTest(testName);
	        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        
        return test;
	}
	
	public static synchronized void endTest() {
        getInstance().endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
	
	public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
	
	/*This method is used to create new extent report in html format
	 * To create new extent report name dynamically on every execution include current date and time in report name
	 * Get path where the report need to be create
	 * Configure ReportsConfig.xml file into html format
	 * @return:extent
	 */
	public synchronized static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			String reportPath = FrameworkConstants.REPORTS_PATH + fileName;
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional - TODO
		//	extent.addSystemInfo("Selenium Version", "3.5.3").addSystemInfo(
		//			"Environment", "QA");
		}
		return extent;
	}
	
	public static void takeScreenShot(){
		  Date d=new Date();
		  String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		  String filePath=FrameworkConstants.REPORTS_PATH+"screenshots\\"+screenshotFile;
		  // store screenshot in that file
		  File scrFile = ((TakesScreenshot)WebUIDriver.getWebDriver()).getScreenshotAs(OutputType.FILE);
		  
		  try {
		   FileUtils.copyFile(scrFile, new File(filePath));
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  //TestReportsLog.getReportLogSession().log(LogStatus.INFO,reportLogSession.addScreenCapture(filePath));
		  TestReportsLog.log(LogStatus.INFO, getTest().addScreenCapture(filePath));
	}
	
	
}