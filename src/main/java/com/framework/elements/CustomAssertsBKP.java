package com.framework.elements;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class CustomAssertsBKP {
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

}
