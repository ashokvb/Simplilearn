package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
      
public class CreateResidencyTypeForStudentPage extends BasePage{ 
	//Login Page Web Elements
	//AppendValue Apage = new AppendValue();
	static String ResTypName = AppendValue.apendString();
	static String ResstsinName = AppendValue.apendString();	
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
	static Button New = new Button("Click New", byId("newButton"));
	static TextField ResidencyType = new TextField("Enter Residency Type", byXPath("//input[@name=\"residencyType_input\"]"));
	static TextField SelResidencyType = new TextField("Select Residency Type", byXPath("(//span[@class=\"student-label-container\"])[1]"));
	static TextField ResidencyStatusInput = new TextField("Enter Residency Type Input", byXPath("//input[@name=\"residencyStatus_input\"]"));
	static TextField SelResidencyStatusInput = new TextField("Select Residency Type Input", byXPath("(//span[@class=\"student-label-container\"])[2]"));
	static TextField EffectiveDate = new TextField("Enter Effective Date", byXPath("//input[@placeholder=\"MM/DD/YYYY\"]"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("(//button[@class=\"cmc-toolbar-button ng-binding\"])[7]"));	
	//Method Implementation	
	//Enter Login Credential to Get into the Student's or Any Home Page
	public CreateResidencyTypeForStudentPage CreatingResidencyTypeStudent(StringHash data) throws Exception{
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
		waitForPageToLoad();
		wait(2);
		StuNumFilter.click();
		waitForPageToLoad();
		wait(2);
		value.clearAndType(data.get("Student Number"));
		wait(2);
		FilterButton.click();
		wait(2);
		TESTAPI.click();
		waitForPageToLoad();
		wait(5);
		ContactManager.click();
		wait(2);
		Residencies.click();
		waitForPageToLoad();
		wait(2);
		New.click();
		waitForPageToLoad();
		ResidencyType.clearAndType(data.get("ResidencyType Name").toString());
		wait(2);
		SelResidencyType.click();
		wait(2);
		ResidencyStatusInput.clearAndType(data.get("ResidencyStatusInput Name").toString());
		wait(2);
		//SelResidencyStatusInput.click();
		//waitForPageToLoad();
		//wait(3);
		EffectiveDate.clearAndType("07/04/2022");
		wait(3);
		SaveAndClose.click();
		waitForPageToLoad();
		wait(2);
		return this;
    }

}



