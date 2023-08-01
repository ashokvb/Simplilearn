package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byName;
import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class StudentUpdateStudentApplication extends BasePage{

	//Student Application Web Elements
	
		static Button FilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
		static Button ClearFiltersButton = new Button("Click Filter Button", byId("listClearFiltersButton"));
		static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
		static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
		static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
		static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
		static Link ClickStudent = new Link("Click Student Name",byXPath("//span[.=\"Harris, Colette\"]"));
	    static Button Admissons = new Button("Click Admissions", byXPath("(//span[@class=\"k-link k-header\"])[2]"));
	    static Link StudentApplications =  new Link("Click Student Application", byXPath("//span[. = \"Student Applications\"]"));
	    static AngDropDown ClickFilterDropdwon = new AngDropDown("Click New", byId("(//span[@class=\"k-icon k-i-arrow-60-down\"])[3]"));
	    static Link ClickFilter = new Link("Click Filter", byXPath("//a[text()=\"Clear Filters\"]"));
	    static Link ApplDropdown = new Link("Click PV dropdown", byXPath("//th[4]/a/span[@class=\"k-icon k-i-more-vertical\"]"));
	    static Button ApplFilterDropDown = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
	    static TextField Value = new TextField("Click Filter", byXPath("//input[@title=\"Value\"]"));
	    static Button Filter = new Button("Filter Button", byXPath("//button[text()=\"Filter\"]"));
/*	    static Button SelectApplication = new Button("Select Application", byXPath("//tr[@class=\"k-state-selected\"]"));
	    static Button Delete = new Button("Click Delete", byXPath("(//a[.=\"Delete\"])[1]"));
	    static Button ConfirmDelete = new Button("Confirm Delete", byId("deleteConfirmationDialog1656924687179OkButton"));
*/      static Link SelectApplication = new Link("Select Application", byXPath("//a[.=\"DTS\"]"));
        static Button ClickDropDown = new Button("Click Drop Down", byXPath("(//div[@class=\"cmc-icons-arrow-right cmc-icons-md down rotate\"])[1]"));
	    static TextField SchoolStatus = new TextField("Enter School Status", byName("schoolStatusId_input"));
	    static Button SelectSchoolStatus = new Button("Select the School Status",byXPath("//span[text()=\"Applicant\"]"));
	    static TextField AdminRep = new TextField("Enter Admin Rep", byName("assignedAdmissionsRepId_input"));
	    static Button SelectAdminRep = new Button("Select Admin Rep",byXPath("//li[text()=\"Andrew Yates\"]"));
	    static Button SaveAndClose = new Button("Click Save & Close", byXPath("(//button[@aria-label=\"Save & Close\"])[2]"));
	    static Button EnrolNum = new Button("Click Enrollment Num", byId("enrollmentNumber"));
	    static Button change = new Button("Click Enrollment Num", byId("statusChangeDialogOkButton"));
	    static TextField Comment = new TextField("Click Enrollment Num", byId("note"));
	  
	    public StudentUpdateStudentApplication UpdateStudentApplicationPage(StringHash data) throws Exception {
	    	
	    	waitForPageToLoad();
	    	wait(10);
	    	FilterDropDwon.click();
	    	wait(2);
	    	ClearFiltersButton.click();
	    	wait(2);
	    	StuNumDropDown.click();
	    	wait(2);
	    	StuNumFilter.click();
	    	wait(2);
	    	value.clearAndType(data.get("Student Number"));
	    	wait(2);
	    	FilterButton.click();
	    	waitForPageToLoad();
	    	ClickStudent.click();
	    	wait(10);
	    	waitForPageToLoad();
	    	Admissons.click();
	    	wait(2);
	    	StudentApplications.click();
	    	waitForPageToLoad();
	    	wait(4);
/*	    	ClickFilterDropdwon.click();
	    	wait(3);
	    	ClickFilter.click();
	    	wait(3);
*/
	    	ApplDropdown.click();
	    	wait(2);
	    	ApplFilterDropDown.click();
	    	wait(2);
	    	Value.clearAndType(data.get("Student Status"));
	    	wait(2);
	    	Filter.click();
	    	wait(2);
	    	SelectApplication.click();
	    	waitForPageToLoad();
	    	scrollPage(0, 1000);
	    	ClickDropDown.click();
	    	wait(2);
	    	SchoolStatus.clearAndType(data.get("Update Student Status"));
	     	Thread.sleep(1000);
/*	    	SelectSchoolStatus.click();
	     	Thread.sleep(1000);
*/
	     	scrollPage(0, 300);
//	    	AdminRep.clearAndType(data.get("Update Adm Rep"));	    	
/*	    	SelectAdminRep.click();
	     	Thread.sleep(1000);
*/
	     	EnrolNum.click();
	     	wait(2);
	    	scrollPage(0, -1000);
	    	SaveAndClose.click();
	    	wait(1);
	    	Comment.sendKeys("Change Student Status");
	    	wait(2);
	    	change.click();
	    	wait(10);	    	
			return this;
	    	   	
	    }

	}
