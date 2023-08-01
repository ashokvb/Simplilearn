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

public class RemoveStudentFromGroupPage extends BasePage{ 
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
    static Link ContactManager = new Link("Contact Manager", byXPath("//cns-panel-bar/ul/li/span"));
	static Link GroupMemberships  = new Link("Student Group Membership ", byXPath("//span[text()=\"Group Memberships\"]"));
	static Button GrpFilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
	static Button GrpClearFiltersButton = new Button("Click Filter Button", byId("studentGroupsGrid_cnsToolbar_kendoToolBar_clearPreferencesButton"));
	static AngDropDown StuGrpDropDown = new AngDropDown("Click Student Group Dropdown", byXPath("(//span[@class=\"k-icon k-i-more-vertical\"])[2]"));
	static Link SelectIsInstructureCreateUser  = new Link("click Is Instructor Create User", byXPath("//a[@class=\"cmc-link-column\"]"));
	static Link Remove = new Link("Click on Remove Button ", byXPath("//a[@id=\"studentGroupsRemoveButton\"]"));
	static Link ClickToRemove = new Link("Click on To Remove Button ", byId("confirmRemoveStudentGroupsFromGroupWindowOkButton"));
	//Method Implementation
	
	//Enter Login Credential to Get into the Student's or Any Home Page
	public RemoveStudentFromGroupPage RemoveStudentGroup(StringHash data) throws Exception{
		waitForPageToLoad();
		wait(3);
		MenuButton.click();
		wait(3);
		Students.click();
		waitForPageToLoad();
		wait(15);
		FilterDropDwon.click();
		wait(2);
		ClearFiltersButton.click();
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
		wait(3);
		ContactManager.click();
		wait(2);
		GroupMemberships.click();
		wait(2);
		//GrpFilterDropDwon.click();
		//wait(2);
		//GrpClearFiltersButton.click();
		//wait(2);
		StuGrpDropDown.click();
		wait(2);
		StuNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Search Group"));
		wait(2);
		FilterButton.click();
		wait(2);
		SelectIsInstructureCreateUser.click();
		waitForPageToLoad();
		wait(15);
		scrollPage(0, -500);
		Remove.click();
		waitForPageToLoad();
		ClickToRemove.click();
		waitForPageToLoad();
		wait(5);
		return this;
    }

}





