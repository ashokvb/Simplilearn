package com.StudentPortal.Pages;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

//import static com.framework.elements.Locator.byXPath


import static com.framework.elements.Locator.byName;
import com.codepine.api.testrail.model.Field.Config.DropdownOptions;

public class StudentAdmissionsPage extends BasePage {
	
	//Student Application Web Elements
	static Button FilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
	static Button ClearFiltersButton = new Button("Click Filter Button", byId("listClearFiltersButton"));
	static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
	static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
	static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
	static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
	//static Link ClickStudent = new Link("Click Student Name",byXPath("//span[.=\"Harris, Colette\"]"));
    static Button Admissons = new Button("Click Admissions", byXPath("(//span[@class=\"k-link k-header\"])[2]"));
    static Link StudentApplications =  new Link("Click Student Application", byXPath("//span[. = \"Student Applications\"]"));
    static Link NewButton = new Link("Click New", byId("newButton"));
    static TextField ApplicantType = new TextField("Enter Applicant Type", byXPath("//input[@name=\"applicantTypeId_input\"]"));
    static TextField ProgramCode = new TextField("Enter Program Code", byName("programIdCode_input"));
    static TextField SchoolStatus = new TextField("Enter School Status", byXPath("//span/span/input[@aria-label=\"schoolStatusId\"]"));
    static Button SelectSchoolStatus = new Button("Select the School Status",byXPath("//span[text()=\"Applicant\"]"));
    static TextField AdminRep = new TextField("Enter Admin Rep", byName("assignedAdmissionsRepId_input"));
    static Button SelectAdminRep = new Button("Select Admin Rep",byXPath("//li[text()=\"Andrew Yates\"]"));
    static Button SaveAndClose = new Button("Click Save & Close", byXPath("(//button[@aria-label=\"Save & Close\"])[2]"));
    static Button EnrolNum = new Button("Click Enrollment Num", byId("enrollmentNumber"));
    static Link ClickFilter = new Link("Click Filter", byXPath("//a[text()=\"Clear Filters\"]"));
    static Link CourseCodeDropdown = new Link("Click Course Code dropdown", byXPath("(//a[@aria-label=\"Column Settings\"])[1]"));
    static Button CClFilterDropDown = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
    static TextField Value = new TextField("Click Filter", byXPath("//input[@title=\"Value\"]"));
    static Button Filter = new Button("Filter Button", byXPath("//button[text()=\"Filter\"]"));
	static TextField Notes = new TextField("Enter Notes", byXPath("//textarea[@aria-label=\"Notes\"]"));
    static Button StatusReason = new Button("Click Status Reason", byXPath("//span[@aria-label=\"Status Reason: Dropdown\"]"));
  
    public StudentAdmissionsPage CreateStudentApplication(StringHash data) throws Exception {
    	
    	Link ClickStudent = new Link("Click Student Name",byXPath("//span[.='"+data.get("StudentName")+"']"));
    	Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Student Application records were successfully saved.']"));
    	Link SelectAdmRep = new Link("Select AdmRep", byXPath("//li[.='"+data.get("AdmRep")+"']"));
    	waitForPageToComplete();
    	wait(5);
    	FilterDropDwon.click();
    	wait(2);
    	ClearFiltersButton.click();
    	wait(2);
    	StuNumDropDown.click();
    	wait(2);
    	StuNumFilter.click();
    	wait(2);
    	value.clearAndType(data.get("StudentNumber"));
    	wait(2);
    	FilterButton.click();
    	wait(2);
    	ClickStudent.click();
    	wait(2);
    	waitForPageToLoad();
    	Admissons.click();
    	wait(2);
    	StudentApplications.click();
    	waitForPageToLoad();
    	wait(2);
    	NewButton.click();
    	wait(5);
    	waitForPageToLoad();
    	scrollPage(0, 500);
    	wait(2);
    	ApplicantType.clearAndType(data.get("ApplicantType"));
    	wait(3);
    	ProgramCode.clearAndType(data.get("ProgramCode"));
    	wait(2);
    	scrollPage(0, 700);
    	wait(2);
    	StatusReason.click();
    	wait(2);
    	SchoolStatus.sendKeys(data.get("StudentStatus"));
    	wait(5);
    	AdminRep.clearAndType(data.get("AdmRep"));
    	wait(2);
    	SelectAdmRep.click();
    	wait(5);
    	/*    	SelectAdminRep.click();
     	Thread.sleep(1000);
    	 */      
    	//EnrolNum.click();
    	scrollPage(0, -1000);
    	wait(5);
    	SaveAndClose.click();
    	wait(10);
    	CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(5);
		return this;	   	
    }
}
