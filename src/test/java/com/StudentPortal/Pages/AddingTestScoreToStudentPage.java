package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class AddingTestScoreToStudentPage extends BasePage{ 
	//Login Page Web Elements
	static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.='Filter']"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Link TESTAPI = new Link("API TEST", byXPath("//span[text()=\"TEST, API\"]"));
	static Link Admissions = new Link("Click on Admissions", byXPath("(//span[@class=\"k-link k-header\"])[2]"));
	static Link TestScores = new Link("Click on TestScores", byXPath("(//span[@class=\"tile-label text-left ng-binding\"])[16]"));
	static Button New = new Button("Click New", byId("studentEntranceTestScoresAddButton"));
	static TextField Test = new TextField("Enter Test", byXPath("//input[@name=\"test_input\"]"));
	static TextField SelTest = new TextField("Enter Test", byXPath("(//span[@class=\"student-label-container\"])[1]"));
	static Button SaveAndClose = new Button("Save and Close", byId("studentEntranceTestScoreSaveAndCloseButton"));	
	//Method Implementation
	//Enter Login Credential to Get into the Student's or Any Home Page
	public AddingTestScoreToStudentPage AddtestscoreStudent(StringHash data) throws Exception{
		waitForPageToLoad();
		wait(20);
		MenuButton.click();
		wait(3);
		Students.click();
		waitForPageToLoad();
		wait(15);
		FilterDropDwon.click();
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
		Admissions.click();
		waitForPageToLoad();
		wait(3);
		TestScores.click();
		waitForPageToLoad();
		wait(2);
		New.click();
		waitForPageToLoad();
		wait(10);
		Test.clearAndType(data.get("Test Name").toString());
		waitForPageToLoad();
		wait(3);
		SelTest.click();
		waitForPageToLoad();
		wait(3);
		SaveAndClose.click();
		waitForPageToLoad();
		return this;
    }
}