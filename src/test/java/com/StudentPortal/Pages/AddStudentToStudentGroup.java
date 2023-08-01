package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
//import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byXPath;

//byXPath

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class AddStudentToStudentGroup extends BasePage{ 
	//Login Page Web Elements
	static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    //static Link TESTAPI = new Link("API TEST", byXPath("//span[text()=\"TEST, API\"]"));
    static Link ContactManager = new Link("Contact Manager", byXPath("(//cns-panel-bar/ul/li/span)[1]"));
	static Link GroupMemberships  = new Link("Student Group Membership ", byXPath("//span[text()=\"Group Memberships\"]"));
	static Button ClickAdd = new Button("Click Add", byId("studentGroupsAddButton"));
	static Link SearchGroup = new Link("Group Add", byXPath("//div[@id=\"search_display_studentGroup\"]"));
	static TextField EnterGroup = new TextField("Search Group Name", byXPath("//input[@placeholder=\"Search Name\"]"));
	//static Checkbox GroupName = new Checkbox("Student Group Name", byXPath("//input[@aria-label='Is Instructure Create User']"));
	static Button Select = new Button("Select Button", byXPath("//button[text()=\"Select\"]"));
	static Button SaveAndClose = new Button("Save and Close", byId("studentGroupSaveAnCloseButton"));	
	//Method Implementation
	//Enter Login Credential to Get into the Student's or Any Home Page
	public AddStudentToStudentGroup AddStudentGroup(StringHash data) throws Exception{
		Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Checkbox ClickStudentGroup = new Checkbox("Click on Student Group", byXPath("//input[@aria-label='"+data.get("StudentGroup")+"']"));
		waitForPageToLoad();
		wait(20);
		MenuButton.click();
		wait(5);
		Students.click();
		//waitForPageToLoad();
		wait(15);
		FilterDropDwon.click();
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
		waitForPageToLoad();
		wait(2);
		FilterButton.click();
		waitForPageToLoad();
		wait(5);
		//TESTAPI.click();
		//waitForPageToLoad();
		//wait(5);
		ClickStudentName.click();
		waitForPageToLoad();
		wait(5);
		ContactManager.click();
		waitForPageToLoad();
		wait(2);
		GroupMemberships.click();
		waitForPageToLoad();
		wait(2);
		ClickAdd.click();
		waitForPageToLoad();
		wait(2);
		SearchGroup.click();
		wait(2);
		EnterGroup.clearAndType(data.get("Search Group").toString());
		wait(2);
		//GroupName.click();
		//wait(2);
		ClickStudentGroup.click();
		wait(5);
		Select.click();
		wait(2);
		SaveAndClose.click();
		waitForPageToLoad();
		wait(2);
		return this;
    }

}




