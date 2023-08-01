package com.framework.elements;

import org.testng.Assert;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class CustomAsserts {
	public static void assertString(String locatorText, String text) {
		if (locatorText.contentEquals(text)) {
			TestReportsLog.log(LogStatus.PASS,
					"Element Text Matched locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
		} else {
			TestReportsLog.log(LogStatus.ERROR,
					"Element Text Does not Match.locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
		}
	}

	public static void verifyStringNotMatch(String locatorText, String text) {
		if (!locatorText.contentEquals(text)) {
			TestReportsLog.log(LogStatus.PASS,
					"Element TextDoes Not Matched.locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
		} else {
			TestReportsLog.log(LogStatus.ERROR,
					"Element Text Matched.locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
		}

	}

	public static void containsString(String locatorText, String text) {
		if (locatorText.contains(text)) {
			TestReportsLog.log(LogStatus.PASS,
					"Element Text Matched.locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
		} else {
			TestReportsLog.log(LogStatus.ERROR,
					"Element Text Does not Match.locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
		}
	}

	public static void containsValue(String locatorText, int text) {
		if (locatorText.equals(text)) {
			TestReportsLog.log(LogStatus.PASS,
					"Element Text Matched.locatorText - '" + locatorText + "' value to Compare - '" + text + "'");
		} else {
			TestReportsLog.log(LogStatus.ERROR,
					"Element Text Does not Match.locatorText - '" + locatorText + "' value to Compare - '" + text + "'");
		}
	}
	
	public static void assertStringCaptureScreen(String locatorText, String text) {
		if (locatorText.contentEquals(text)) {
		TestReportsLog.logpass(LogStatus.PASS,
		"Element Text Matched locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
	
		} else {
		TestReportsLog.log(LogStatus.ERROR,
		"Element Text Does not Match.locatorText - '" + locatorText + "' Text to Compare - '" + text + "'");
		}
	
	}

	public static void assertString(boolean contains) {
		// TODO Auto-generated method stub
		if (contains=contains) {
			TestReportsLog.log(LogStatus.PASS,
					"Element Text Matched locatorText - '" + contains + "' Text to Compare - '" + contains + "'");
		} else {
			TestReportsLog.logfail(LogStatus.ERROR,
					"Element Text Does not Match.locatorText - '" + contains + "' Text to Compare - '" + contains + "'");
		}
	
	}

	public static void assertStringPassStatus(String string) {
		// TODO Auto-generated method stub
		if (string.contains(string)) {
			TestReportsLog.log(LogStatus.PASS,
					"Print Results _'" + string + "" + "" + "'");
		} else {
			TestReportsLog.logfail(LogStatus.ERROR,
					"Print Results _'" + string + "" + "" + "'");
		}
		
	}
	public static void assertStringFailStatus(String string) {
		// TODO Auto-generated method stub
		if (string.contains(string)) {
			TestReportsLog.logfail(LogStatus.ERROR,
					"Print Results _'" + string + "" + "" + "'");
		} else {
			TestReportsLog.logfail(LogStatus.ERROR,
					"Print Results _'" + string + "" + "" + "'");
		}
		
	}

	public static void assertStringPrinttext(String ocr_text) {
		// TODO Auto-generated method stub
		if (ocr_text.isEmpty()) {
			TestReportsLog.log(LogStatus.PASS,
					"Element Text Extracted from PDF Documnet - '" + ocr_text + "' Text to Compare - '" + "" + "'");
		} else {
			TestReportsLog.logfail(LogStatus.PASS,
					"Element Text Extracted from PDF Documnet - '" + ocr_text + "' Text to Compare - '" + "" + "'");
		}
		
	}
	

}
