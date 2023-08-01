package com.framework.elements;

import org.openqa.selenium.By;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class Link  extends BaseElement {

  
	/* intializes the parent class(Base Element) variables */
	
	public Link(final String label, final By by) {
        super(label, by);
    }

   
	/*This method is used to find the element and click on it */
	
	@Override
    public void click() {
		TestReportsLog.log(LogStatus.INFO,"click on " + toHTML());
        //TestLogging.logWebStep("click on " + toHTML(), false);
        super.click();
    }

   
    /*This method is used to get path of link using "href" attribute
     * @getAttribute-method will invoke and return value of the "href" attribute 
     * @return-Value of href attribute 
     */
    
    public String getUrl() {
        return super.getAttribute("href");
    }

}
