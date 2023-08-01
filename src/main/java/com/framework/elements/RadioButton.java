package com.framework.elements;

import org.openqa.selenium.By;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class RadioButton extends BaseElement {

    public RadioButton(final String label, final By by) {
        super(label, by);
    }

   
    /*This method is used to find and select the required element     */
    
    public void check() {
    	TestReportsLog.log(LogStatus.INFO,"check " + toHTML());
        //TestLogging.logWebStep("check " + toHTML(), false);
        super.click();
    }

  
    /*Repeated Method*/
    /*
    
    @Override
    public void click() {
        TestLogging.logWebStep("click on " + toHTML(), false);
        super.click();
    }*/
    
    
    
    /*This method is used to find he required element
     * Verify whether element already selected or not
     * @return-true(if element selected); false(if element didn't selected)
     */

    public boolean isSelected() {
        findElement();
        return element.isSelected();
    }


}
