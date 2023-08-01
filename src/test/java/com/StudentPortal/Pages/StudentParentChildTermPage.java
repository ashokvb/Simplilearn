package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;


import static com.framework.elements.Locator.byId;

public class StudentParentChildTermPage extends BasePage{
	
	//Parent and Child Term Web Elements
	static Link configuration = new Link("Click Configuration", byXPath("//a[.=\"Configuration\"]"));
	static TextField SearchInConfiguration = new TextField("Search in Configuration" , byXPath("//input[@placeholder=\"Search Configuration\"]"));
	static Link ClickTerms = new Link("Click Terms", byXPath("//span[.=\"Terms\"]"));
	static Button FilterDropDownButton = new Button("Click Filter Drop Down Button", byXPath("//div[2]/a[2]"));
	static Link ClearFilter = new Link("Clear Filter", byXPath("//a[.=\"Clear Filters\"]"));
	static AngDropDown CodeDropDown = new AngDropDown("Click Code Drop Down", byXPath("//th[3]/a/span"));
	static Button CodeFilterButton  =  new Button("Code Filter Button", byXPath("//span[.=\"Filter\"]"));
	static TextField CodeValue = new TextField("Enter Code Value", byXPath("//input[@title=\"Value\"]"));
	static Button ClickFilter = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
//    static Link ClickParentTermName = new Link("Click Parent Term Name", byXPath("//a[text() = '"+data.get("ParenTermName")+"']"));
    static Link AddChildTerm = new Link("Click Add Child Term", byId("addChildTermButton"));
    static TextField SearchChildTerm = new TextField("Search Child Term", byId("search"));
    static Checkbox CheckChildTerm = new Checkbox("Check Child Term", byXPath("//input[@aria-label=\"CHILD\"]"));
    static Button ClickSelect = new Button("Click Select", byXPath("//button[.=\"Select\"]"));
    static Button SaveAndClose = new Button("Click Save & Close", byXPath("//button[@aria-label=\"Save & Close\"]"));
    static Link ClickParentTermName = new Link("Chick the Term", byXPath("//a[.=\"Parent Term\"]"));
    
    
    public StudentParentChildTermPage ParentAndChildTerm(StringHash data) throws Exception {
    	   
       
         waitForPageToLoad();
    	SearchInConfiguration.sendKeys("Terms");
    	ClickTerms.click();
    	waitForPageToLoad();
    	FilterDropDownButton.click();
    	wait(2);
    	ClearFilter.click();
    	waitForPageToLoad();
    	CodeDropDown.click();
    	wait(2);
    	CodeFilterButton.click();
    	wait(2);
    	CodeValue.sendKeys(data.get("ParentTermCode"));
    	wait(2);
    	ClickFilter.click();
    	wait(2);
    	ClickParentTermName.click();
    	wait(5);
    	waitForPageToLoad();
    	scrollPage(0, 1200);
    	wait(2);
    	AddChildTerm.click();
    	wait(2);
    	SearchChildTerm.clearAndType(data.get("ChildTermCode").toString());
    	Thread.sleep(4000);
    	CheckChildTerm.click();
    	wait(3);
    	ClickSelect.click();
    	wait(2);
    	scrollPage(0, -1200);
    	SaveAndClose.click();
    	wait(10);   	
    	return this;
    	
    }

}   
