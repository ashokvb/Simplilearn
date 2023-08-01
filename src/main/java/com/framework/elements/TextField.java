package com.framework.elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.framework.driver.WebUIDriver;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class TextField extends BaseElement {
	// public ExtentTest reportLog = TestReportsLog.getReportLogSession();

	/* intializes the parent class(Base Element) variables */

	public TextField(final String label, final By by) {
		super(label, by);
	}

	/*
	 * This method is to identify the element(textfield) and clear the text in
	 * the text field.
	 */

	public void clear() {

		TestReportsLog.log(LogStatus.INFO, "Remove data From " + toHTML());
		// TestLogging.logWebStep("Remove data From " + toHTML(), false);
		findElement();
		if (!element.getAttribute("type").equalsIgnoreCase("file")) {
			element.clear();
		}
	}

	/*
	 * This method is to identify the element. This method is to enter some text
	 * in to the text field.
	 * 
	 * @parm-KeysToSend(Required input to enter)
	 */

	public void enterTextRichTextEditor(final String keysToSend) {
		findElement();
		element = getElement();
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("/html/body")).sendKeys(keysToSend);
		driver.switchTo().parentFrame();
	}

	public void type(final String keysToSend) {
		findElement();

		TestReportsLog.log(LogStatus.INFO, "Enter data: \"" + keysToSend + "\" on " + toHTML());
		// TestLogging.logWebStep("Enter data: \"" + keysToSend + "\" on " +
		// toHTML(), false);
		// findElement();

		element.sendKeys(keysToSend);
	}

	public void typeUandPwd(final String keysToSend) {
		findElement();

		TestReportsLog.log(LogStatus.INFO, "Enter data: \"" + "XXXXXXXX" + "\" on " + toHTML());
		// TestLogging.logWebStep("Enter data: \"" + keysToSend + "\" on " +
		// toHTML(), false);
		// findElement();

		element.sendKeys(keysToSend);
	}
	
	public void typeNum1(int num) {
		findElement();

		TestReportsLog.log(LogStatus.INFO, "Enter data: \"" + num + "\" on " + toHTML());
		// TestLogging.logWebStep("Enter data: \"" + keysToSend + "\" on " +
		// toHTML(), false);
		// findElement();
		//element.type
		//element.sendKeys(num);
	}
	
	public void textarea(final String keysToSend) {
		findElement();
		TestReportsLog.log(LogStatus.INFO, "Enter data: \"" + keysToSend + "\" on " + toHTML());
		element = getElement();
		moveTo(element);
		element.sendKeys(keysToSend);
	}

	public void moveTo(WebElement element) {
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		WebDriver driver = getDriver();
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public void enterSpace(final String keyValue) {

		findElement();

		TestReportsLog.log(LogStatus.INFO, "Enter data: \"" + keyValue + "Spaces" + "\" on " + toHTML());
		// TestLogging.logWebStep("Enter data: \"" + keysToSend + "\" on " +
		// toHTML(), false);
		// findElement();
		int count = Integer.parseInt(keyValue);
		for (int i = 0; i < count; i++) {
			element.sendKeys(Keys.SPACE);
		}
	}
	
	public void ClearExistingText() {

		findElement();
		element.sendKeys("Keys.SHIFT" + "Keys.HOME");
		//element.sendKeys(Keys.HOME);
		element.sendKeys(Keys.BACK_SPACE);

		TestReportsLog.log(LogStatus.INFO, "Clearing existing data" + toHTML());	
	}

	/* This method is not required */

	/*
	 * public void type(final String keysToSend) { sendKeys(keysToSend); }
	 */

	/*
	 * This method is to invoke 'clear' and 'type'
	 * 
	 * @clear - used to clear the existing text in the field
	 * 
	 * @type - used to enter input data into the text field
	 * 
	 * @param-KeysToSend
	 */
	public void clearAndType(final String keysToSend) {
		clear();
		type(keysToSend);
	}
	
	public void clearAndTypeUandPwd(final String keysToSend) {
		clear();
		typeUandPwd(keysToSend);
	}

	public void deleteAndType(final String keysToSend) {
		sendKeys(Keys.chord(Keys.CONTROL, "a"));
		sendKeys(Keys.BACK_SPACE);
		type(keysToSend);
	}

	// This method is to type date in the date fields

	public void typeDate(final String keysToSend) throws ParseException {

		findElement();
		String newDateString;

		String browser = WebUIDriver.getWebUIDriver().getBrowser();

			newDateString = keysToSend;

			element.sendKeys(newDateString);
			// element.sendKeys(Keys.TAB);
			TestReportsLog.log(LogStatus.INFO, "Enter date: \"" + newDateString + "\" on " + toHTML());

	}

	public void typeNum(int phoneNumber) {
		
		clear();
		//sendKeys(phoneNumber);
		// TODO Auto-generated method stub
		
	}

}
