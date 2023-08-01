package com.framework.elements;

import org.openqa.selenium.By;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class Label extends BaseElement {
   
	
	/* intializes the parent class(Base Element) variables */
	
	public Label(final String label, final By by) {
        super(label, by);
    }

  /* This method is used to get the text body of underlying element
   * @return-text of the specified element
  */
	
	@Override
    public String getText() {
		TestReportsLog.log(LogStatus.INFO,"get text from " + toHTML());
        //TestLogging.logWebStep("get text from " + toHTML(), false);
        return super.getText();
    }

 
	/*This method is used to get the innertext of element using gettext method and to verify existed text presented or not
	 * @param-pattern(text need to verify)
	 * @return-true(if text matched); False(if text didn't match)
	 */
	
	public boolean isTextPresent(final String pattern) {
        String text = getText();
        return (text != null && (text.contains(pattern) || text.matches(pattern)));
    }

   /*This method is used to verify expected and actual results same or not
    * soft assert - test case continues when validation fails. soft assert is enabled only if context softAssertEnabled is set to true.
    */
	
	/*@Deprecated
    public String getExpectedText() {
        CustomAssertion.assertTrue(false, "NOT supported!");
        return null;
    }*/

}
