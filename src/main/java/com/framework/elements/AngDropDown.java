package com.framework.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import com.framework.base.constants.BrowserType;
import com.framework.driver.WebUIDriver;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class AngDropDown extends BaseElement {

	protected List<WebElement> options = null;
	
	/* intializes the parent class(Base Element) variables */
	public AngDropDown(final String text, final By by) {
		super(text, by);
	}

	 /* This method is used to click on element using  keyboard if the browser type is IE
     * @click - will click the identified element
     */
   
   @Override
   public void click() {
   	//should be logged using ExtentManager
   	TestReportsLog.log(LogStatus.INFO, "click on "+toHTML());
       //TestLogging.logWebStep("click on " + toHTML(), false);

//       BrowserType browser = WebUIDriver.getWebUIDriver().getConfig().getBrowser();
//       if (browser == BrowserType.InternetExplore) {
//           super.sendKeys(Keys.ENTER);
//       } else {
           super.click();
//       }
   }
	
	/**
	 * Select standard select by attribute text, and select fake select with ul and
	 * li by attribute title.
	 *
	 * @param text
	 */

	/*
	 * 
	 */
	public void selectByText(final String text) {
		boolean valueSelected = false;
		driver = WebUIDriver.getWebDriver();
		options = driver.findElements(this.getBy());

		for (WebElement option : options) {
			String selectedText = option.getText();
		
			if (selectedText.equals(text)) {
				option.click();
				valueSelected = true;
				TestReportsLog.log(LogStatus.INFO, "Selected dropdown value as \"" + text + "\" on " + toHTML());
				break;
			}
		}

		if (!valueSelected) {
			TestReportsLog.log(LogStatus.FAIL, "Unable to find value in the dropdown \"" + text + "\" on " + toHTML());
		}

	}

}
