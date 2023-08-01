package com.framework.elements;

import org.openqa.selenium.By;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
public class Image extends BaseElement {

  
	/* intializes the parent class(Base Element) variables */
	public Image(final String label, final By by) {
        super(label, by);
    }

	
	/* This method is used to find the required element and gets the Height of the underlying WebElement
	 * @return-Height of the element
	 */
	 
	
    public int getHeight() {
        return super.getSize().getHeight();
    }

    /* This method is used to find the required element and gets the Width of the underlying WebElement 
     * @return-Width of the element
     */
    
    public int getWidth() {
        return super.getSize().getWidth();
    }

    /* This method is used to find the required element and gets the "src" attribute value of the underlying WebElement  
     * @return -src attribute value 
     */
    public String getUrl() {
        return super.getAttribute("src");
    }
   
    /*This method is used to find and click on element specified*/ 
    public void click() {
    	TestReportsLog.log(LogStatus.INFO,"Clicking on image" + toHTML());
        //TestLogging.logWebStep("Clicking on image" + toHTML(), false);
        findElement();
        element.click();
    }
}
