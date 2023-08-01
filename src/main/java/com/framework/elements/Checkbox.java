package com.framework.elements;

import org.openqa.selenium.By;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class Checkbox extends BaseElement {

    
	/* intializes the parent class(Base Element) variables */
	public Checkbox(final String label, final By by) {
        super(label, by);
    }

   
	
	/* This method will check if the element is already checked or not,if not checked
	  then the element will be checked using click method */
	
	public void check() {
		TestReportsLog.log(LogStatus.INFO,"check " + toHTML());
		//TestLogging.logWebStep("check " + toHTML(), false);
        if (!isSelected()) {
            super.click();
        }
    }
  
	
	   /* This method is to identify the element and click on it */
    @Override
    public void click() {
    	TestReportsLog.log(LogStatus.INFO,"check " + toHTML());
    	//TestLogging.logWebStep("click on " + toHTML(), false);
        super.click();
    }

    
    /*This method is to identify the element and verify whether the element is selected or not
     * @return-true(if element is selected); false(if element didn't select)
     * */
    public boolean isSelected() {
        findElement();
       
       return element.isSelected();
    }
    
    
    /* This method check if the element is already checked or not,if checked
	  then the element will be unchecked using click method */
    
    public void uncheck() {
    	TestReportsLog.log(LogStatus.INFO,"uncheck " + toHTML());
    	//TestLogging.logWebStep("uncheck " + toHTML(), false);
        if (isSelected()) {
            super.click();
        }
    }
    
    

}
