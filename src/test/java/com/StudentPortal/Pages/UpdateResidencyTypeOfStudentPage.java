package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

//import com.StudentPortal.Businessflow.StudentFlow_API;
import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class UpdateResidencyTypeOfStudentPage extends BasePage{ 
	//Login Page Web Elements
	static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Link TESTAPI = new Link("API TEST", byXPath("//span[text()=\"TEST, API\"]"));
    static Link ContactManager = new Link("Contact Manager", byXPath("(//cns-panel-bar/ul/li/span)[1]"));
	static Link Residencies  = new Link("Student RecidencyType ", byXPath("(//span[@class=\"tile-label text-left ng-binding\"])[10]"));
	static Button ResFilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
	static Button ResClearFiltersButton = new Button("Click Filter Button", byId("cnsGrid_cnsToolbar_kendoToolBar_clearPreferencesButton"));
	static AngDropDown StuResDropDown = new AngDropDown("Click Student Group Dropdown", byXPath("(//span[@class=\"k-icon k-i-more-vertical\"])[2]"));
	static TextField ResidencyTypeName = new TextField(" Enter ResidencyTypeName", byXPath("//input[@title=\"Value\"]"));
	static Link BillingResidencyType  = new Link("click on BillingResidencyType", byXPath("//a[@class=\"cmc-link-column\"]"));
	static TextField UpdResidencyStatusInput = new TextField("Enter Residency Type Input", byXPath("//input[@name=\"residencyStatus_input\"]"));
	static TextField SelUpdResidencyStatusInput = new TextField("Select Residency Type Input", byXPath("//span[. = \"Ministry Partner\"]"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("(//Button[@class=\"cmc-toolbar-button ng-binding\"])[7]"));
	
	//Method Implementation
	
	//Enter Login Credential to Get into the Student's or Any Home Page
	public UpdateResidencyTypeOfStudentPage UpdatingResidencyTypeStudent(StringHash data) throws Exception{
		waitForPageToLoad();
		wait(20);
		MenuButton.click();
		wait(5);
		Students.click();
		waitForPageToLoad();
		wait(15);
		FilterDropDwon.click();
		waitForPageToLoad();
		wait(2);
		ClearFiltersButton.click();
		waitForPageToLoad();
		wait(15);
		StuNumDropDown.click();
		wait(2);
		StuNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Student Number"));
		wait(2);
		FilterButton.click();
		wait(2);
		TESTAPI.click();
		waitForPageToLoad();
		wait(2);
		ContactManager.click();
		waitForPageToLoad();
		wait(2);
		Residencies.click();
		wait(2);
		ResFilterDropDwon.click();
		wait(2);
		ResClearFiltersButton.click();
		wait(2);
		StuResDropDown.click();
		wait(2);
		StuNumFilter.click();
		wait(2);
		ResidencyTypeName.clearAndType(data.get("ResidencyType Name").toString());
		wait(2);
		FilterButton.click();
		wait(3);
		BillingResidencyType.click();
		wait(15);
		scrollPage(0, 300);
		UpdResidencyStatusInput.clearAndType(data.get("UpdResidencyStatus Input").toString());
		wait(2);
		SelUpdResidencyStatusInput.click();
		wait(3);
		SaveAndClose.click();
		waitForPageToLoad();
		wait(2);
		return this;
    }

}



