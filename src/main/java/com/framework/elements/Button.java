package com.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.framework.base.constants.BrowserType;
import com.framework.driver.WebUIDriver;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class Button extends BaseElement {
	/* intializes the parent class(Base Element) variables */
	
    public Button(final String label, final By by) {
        super(label, by);
    }

    
    
     /* This method is used to click on element using  keyboard if the browser type is IE
      * @click - will click the identified element
      */
    
    @Override
    public void click() {
    	//should be logged using ExtentManager
    	TestReportsLog.log(LogStatus.INFO, "click on "+toHTML());
        //TestLogging.logWebStep("click on " + toHTML(), false);

        BrowserType browser = WebUIDriver.getWebUIDriver().getConfig().getBrowser();
        if (browser == BrowserType.InternetExplore) {
            super.sendKeys(Keys.ENTER);
        } else {
            super.click();
        }
    }

    
    /* This method is to identify the element and click on it */
    
    public void submit() {
    	TestReportsLog.log(LogStatus.INFO,"Submit form by clicking on " + toHTML());
    	//TestLogging.logWebStep("Submit form by clicking on " + toHTML(), false);
        findElement();
        element.submit();
    }
}
