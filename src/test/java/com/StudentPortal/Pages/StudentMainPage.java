package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byLinkText;
import static com.framework.elements.Locator.byCSSSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Dropbox;
import com.framework.elements.Label;
import com.framework.elements.Link;
import com.framework.elements.Table;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

import groovy.time.Duration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentMainPage extends BasePage {
	
	static String TermNameValueForRegister = StudentTermsPage.TermNameValue;
	static String SMSServiceProviderValue = StudentConfigurationPage.SMSNameValue;
	static String EmployerNameActualValue = StudentConfigurationPage.EmployerNameValue;
	static Link AcademicRecords = new Link("Click on Academic Records span", byXPath("//li[3]/span"));
	static Link StudentCourses = new Link("Click on Student Courses span", byXPath("//li[3]/div/div[3]/div"));
	static Link Add = new Link("Click on Add link", byCSSSelector("#addCourseButton"));
	static Button Override = new Button("Override button", byCSSSelector("#studentOnHoldWindowOkButton"));
	static TextField Course = new TextField("Course Field", byCSSSelector("#search_display_courseId"));
	static TextField SearchBox = new TextField("SearchBox", byCSSSelector("#search"));
	static Checkbox Input = new Checkbox("Input", byXPath("//td/input"));
	static Button Select = new Button("Select button", byXPath("//button[. = 'Select']"));
	static TextField Term = new TextField("Course Field", byCSSSelector("#search_display_termId"));
	static Button SaveAndRegister = new Button("Save and Register", byXPath("//cmc-toolbar-button-save-new[2]//button"));
	static Button AddCourseWithoutCategory = new Button("Add course without category", byCSSSelector("#courseTakenNotAppliedDialogOkButton"));
	static Button Next = new Button("Next", byCSSSelector("#courseInformationProceedButton"));
	//static Link InstructorTableCell = new Link("InstructorTableCell", byCSSSelector("#classSectionGrid_cmcGrid_active_cell"));		
	static Link Register = new Link("Click on register link", byXPath("//cmc-common-toolbar[2]//a[. = 'Register']"));
	static Button RegisterButton = new Button("Register", byCSSSelector("#schedueCourseDialogOkButton"));
	//static Link Drop = new Link("Drop Link", byCSSSelector("#courseDropButton"));
	static Link Drop = new Link("Drop Link", byXPath("//a[8][. = 'Drop']"));	
	static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Link StudentAccounts = new Link("Click on StudentAccounts", byXPath("//span[@class='k-link k-header k-state-selected']"));    
	static Link SchoolFields = new Link("Click on SchoolFields", byXPath("//ul[@id='studentTilesPanelBar']/li[3]/div/div[12]/div"));
    static Link Sexbirth = new Link("Click on Sexbirth", byXPath("//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div/div/div/div/cmc-drop-down-list-classic/div/div/span/span/span"));
    static Link SelSexbirth = new Link("Click on SelSexbirth", byXPath("//ul[@id='SEXATBIRTH_listbox']/li[2]"));
    static Link Pronouns = new Link("Click on Pronouns", byXPath("//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div/div[2]/div/div/cmc-drop-down-list-classic/div/div/span/span/span"));
    static Link SelPronouns = new Link("Click on SelPronouns", byXPath("//li[@id='e0fb8a94-81e1-4b2a-add8-18d7f908e96e']"));
    static Link FirstGenarationStudent = new Link("Click on FirstGenarationStudent", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[2]/div/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelFirstGenarationStudent = new Link("Click on SelFirstGenarationStudent", byXPath("//li[@id='6f7170c4-f614-4e8c-b821-938a0d636aa8']"));
    static Link OrigonResident = new Link("Click on OrigonResident", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[2]/div/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelOrigonResident = new Link("Click on SelOrigonResident", byXPath("//li[@id='3c20f9c8-e684-43d8-9140-3fa306a52343']"));
    static Link GenderIdentity = new Link("Click on GenderIdentity", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[3]/div/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelGenderIdentity = new Link("Click on SelGenderIdentity", byXPath("//li[@id='a3e728e3-597e-4a13-8a4d-596a25651627']"));
    static Link Tribe = new Link("Click on Tribe", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[3]/div[2]/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelTribe = new Link("Click on SelTribe", byXPath("//li[@id='ff5adab5-6cb1-40a6-90af-a61848c3df1b']"));
    static Link ImmunaizationConfirmation = new Link("Click on ImmunaizationConfirmation", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[4]/div/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelImmunaizationConfirmation = new Link("Click on SelImmunaizationConfirmation", byXPath("//li[@id='4cebb8ab-8d65-4002-bbb8-9efbd803a683']"));
    static Link ELL = new Link("Click on ELL", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[3]/div[2]/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelELL = new Link("Click on SelELL", byXPath("//li[@id='a6cd6337-07de-4d9b-afe0-80f4bbe0d9e6']"));
    static Link DisebillityRequest = new Link("Click on DisebillityRequest", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[5]/div/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelDisebillityRequest = new Link("Click on SelDisebillityRequest", byXPath("//li[@id='d701844c-6fbd-4247-b165-0b4227754d6a']"));
    static Link VeternFamilyDependent = new Link("Click on VeternFamilyDependent", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[5]/div[2]/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelVeternFamilyDependent = new Link("Click on SelVeternFamilyDependent", byXPath("//li[@id='c055fb2f-9c7d-4f08-965d-9887658ce590']"));
    static Link VeteneryTypePreferance = new Link("Click on VeteneryTypePreferance", byXPath("(//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-school-field/section/div/div[3]/div/div[7]/div[2]/div/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static Link SelVeteneryTypePreferance = new Link("Click on SelVeteneryTypePreferance", byXPath("//li[@id='3d5b1bba-9082-4fa2-8da6-0575481b7253']"));
	static Button Save = new Button("Save", byXPath("(//button[@aria-label='Save'])[2]"));
	static Button use = new Button("Use", byXPath("//button[@id='applicantRecordDialogOkButton']"));
	static Button ClsFilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class='k-button k-split-button-arrow'])[1]"));
	static Link ClsClearFiltersButton = new Link("Click Filter Button", byXPath("//div//a[. = 'Clear Filters']"));
	static Link ClsClearFiltersButton1 = new Link("Click Filter Button", byXPath("//div//a[. = 'Clear Filters']"));
	static Link TermDropDown = new Link("Click Term Number Dropdown", byXPath("(//th[1]//span)[1]"));
    static Button TerNumFilter = new Button("Click Term Num Filter", byXPath("//span[.='Filter']"));
    static TextField value1 = new TextField("Enter Value", byXPath("//input[@title='Value']"));
    static Button FilterButton1 = new Button("Click Filter Button", byXPath("//button[text()='Filter']"));
    static Link SelectPrograme = new Link("SelectPrograme", byXPath("//td[text()='Any']"));
    static Link More = new Link("More", byXPath("//div[@id='moreEnrollmentButton_wrapper']/a[2]"));
    static Link Transfer = new Link("Transfer", byXPath("//a[@id='transferButton']"));
    static Link TransferType = new Link("TransferType", byXPath("(//div[@id='divfirstrow_transfer']/cmc-drop-down-list-classic/div/div/span/span/span)[2]"));
    static Link SelTransferType = new Link("SelTransferType", byXPath("//li[text()='To Enrollment']"));
    static Button Proceed = new Button("Click Proceed", byXPath("(//button[text()='Proceed'])[2]"));
	static Checkbox NewPgmVer = new Checkbox("NewPgmVer", byXPath("//div[@id='transferWindow']/ng-transclude/div/div[3]/div/div/ng-transclude/section/div[3]/cmc-radio-button-group/div/div[2]/cmc-radio-button[2]/div/div/label"));
    static Link ProgrameVersion = new Link("ProgrameVersion", byXPath("(//div[@id='transferWindow']/ng-transclude/div/div[3]/div/div/ng-transclude/section/div[3]/cmc-drop-down-list-classic/div/div/span/span/span)[2]"));
    static TextField EnterProgrameVersion = new TextField("Enter EnterProgrameVersion", byXPath("//input[@aria-owns=\"transferToProgramVersionId_listbox\"]"));
	static Button Next3 = new Button("Next3", byXPath("//button[@id='transferInformationProceedButton']"));
	static Button Next4 = new Button("Next4", byXPath("//button[@id='studentCourseProceedButton']"));
	static Button Next5 = new Button("Next5", byXPath("//button[@id='feeProceedButton']"));
    static Link Transfer2 = new Link("Transfer2", byXPath("(//a[@id='transferSaveButton'])[2]"));
    static Link SelPrgver = new Link("SelPrgver", byXPath("//span[text()='AP Associate 2 Semester']"));
    static Link Transfer3 = new Link("Transfer3", byXPath("//button[@id='enrollAcademicYearDialogOkButton']"));   
    static String TstTypName = AppendValue.apendString();
	static String TstTypCode = AppendValue.apendString();	
	//static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Processes = new Link("Processes tile", byXPath("//a[text()='Processes']"));
	static TextField SearchProcesses = new TextField("Search Process", byXPath("//input[@placeholder='Search Processes']"));
	static Link Registration = new Link("Registration Type", byXPath("//span[text()='Registration']"));
	static Button Track = new Button("Click on Track", byXPath("//div[@id='navigationSplitter']/div[3]/div[2]/cns-batch-registration/section/div/div/div[2]/cmc-tabs/div/div/ul/li[2]/button"));
	static TextField StudentGroup = new TextField("Enter Student Group", byXPath("//input[@name='studentGroupDropDown_input']"));
	static Link SelectSG = new Link("Select Student Group", byXPath("//ul/li[text()='2020 Winter SAP Probation (Aid)']"));
	static Link SelectTrack = new Link("Select Track", byXPath("//tr/td[text()='Rudy_Track']"));
	static TextField Next1 = new TextField("Click on Next", byXPath("//div[@id='navigationSplitter']/div[3]/div[2]/cns-batch-registration/section/div/div/div[2]/cmc-tabs/div/div/div/div/cns-batch-registration-track/div/section/div/div[2]/div[5]/div/button"));
	static Checkbox Checkall = new Checkbox("Click on Checkbox", byXPath("//input[@aria-label='Select All StudentId']"));
	static Link Queureg = new Link("Click on Queu Reg", byXPath("//a[@id='queueRegistrationButton']"));
	static Link Queue = new Link("Click on Queue ", byXPath("//button[text()='Queue']"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("//button[@aria-label= \"Save & Close\"]"));	
	static Button Unregister = new Button("Click on Unregister", byXPath("//div[@id='navigationSplitter']/div[3]/div[2]/cns-batch-registration/section/div/div/div[2]/cmc-tabs/div/div/ul/li[3]/button"));
	static Link Term1 = new Link("Click on Term1", byXPath("//div[@aria-label=\"Term\"]"));
	static TextField SearchTerm = new TextField("Enter Term", byXPath("//input[@id='search']"));
	static Checkbox SelectTerm = new Checkbox("Select Term", byXPath("//input[@aria-label='2022 Winter']"));
	static Button Select1 = new Button("Select Button", byXPath("//button[text()='Select']"));
	static TextField Instructor = new TextField("Click Instructor", byXPath("//input[@name=\"InstructorId_input\"]"));
	static Link SelInstructor = new Link("Click on selctIns", byXPath("//span[@title=\"Administrator, System\"]"));
	static TextField Next2 = new TextField("Click on Next", byXPath("//div[@id='navigationSplitter']/div[3]/div[2]/cns-batch-registration/section/div/div/div[2]/cmc-tabs/div/div/div/div/cns-batch-registration-unregister/section/div/div[2]/div[7]/div/button"));
	static Checkbox allstd = new Checkbox("Select all student", byXPath("//input[@aria-label='Select all']"));
	static TextField Reason = new TextField("Enter Reason", byXPath("//input[@name='ReasonId_input']"));
	static Link SelReas = new Link("Click on Reason", byXPath("//span[@title='CANCELLED SECTION']"));
	static Link Queureg2 = new Link("Click on Queu Reg", byXPath("//a[@id='queueUnregistrationButton']"));	
	static TextField Shift = new TextField("Enter on shift", byXPath("//input[@name='shiftId_input']"));
    static Link SelShift = new Link("Click on Selshift", byXPath("//span[@title='Any']"));
	static TextField VersionStartDateDropBox1 = new TextField("VersionStartDateDropBox", byXPath("//input[@name='startDateId_input']"));

public StudentMainPage RegisterCourse(StringHash data) throws Exception{
	
	Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));	
	waitForPageToLoad();
	AcademicRecords.waitTillElementClickable();
	AcademicRecords.click();
	StudentCourses.waitTillElementClickable();
	StudentCourses.click();
	waitForPageToLoad();
	Add.waitTillElementClickable();
	Add.click();
	 if (Override.isElementPresent()) {
		 Override.click();       
     }
	waitForPageToLoad();
	scrollPage(0, -200);
	Course.waitTillElementFound();
	Course.waitTillElementClickable();
	Course.click();
	wait(3);
	SearchBox.clearAndType(data.get("Course").toString());
	wait(3);
	Input.click();
	Select.click();
	wait(3);
	Term.click();
	wait(3);
	SearchBox.clearAndType(TermNameValueForRegister.toString());
	wait(2);
	Input.click();
	Select.click();
	SaveAndRegister.waitTillElementClickable();
	SaveAndRegister.click();
	AddCourseWithoutCategory.waitTillElementClickable();
	AddCourseWithoutCategory.click();
	waitForPageToLoad();
	scrollPage(0, 500);
	Next.waitTillElementClickable();
	Next.click();
	wait(4);
	InstructorTableCell.waitTillElementClickable();
	InstructorTableCell.click();
	scrollPage(0, 200);
	Register.click();
	wait(2);
	RegisterButton.click();
	scrollPage(0, -500);
	return this;

}

public StudentMainPage DropCourse(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link CourseTableCell = new Link("CourseTableCell", byXPath("//td[. = '"+data.get("Course")+"']"));
	Link CourseStatusTableCell = new Link("CourseStatusTableCell", byXPath("//td[8]"));
	//Link LetterGradeSpan = new Link("LetterGradeSpan", byXPath("//div[5]/cmc-drop-down-list[1]/div/div/span/span/span/span"));
	Link LetterGradeSpan = new Link("LetterGradeSpan", byXPath("//div[53]/div/ng-transclude/div/div[3]/div/div/ng-transclude/div/div[2]/cmc-drop-down-list-classic[1]/div/div/span//span[2]"));
	Dropbox LetterGrade = new Dropbox("LetterGrade", byXPath("//li[. = '"+data.get("LetterGrade")+"']"));
	Link ReasonSpan = new Link("ReasonSpan", byXPath("//cmc-drop-down-list-classic[2]/div/div/span//span[2]"));
	Dropbox DropReason = new Dropbox("DropReason", byXPath("//li[text()='"+data.get("DropReason")+"']"));
	Button DropButton = new Button("Drop", byCSSSelector("#dropCourse"));
	
	waitForPageToLoad();
	AcademicRecords.waitTillElementClickable();
	AcademicRecords.click();
	StudentCourses.waitTillElementClickable();
	StudentCourses.click();
	waitForPageToLoad();
	CustomAsserts.containsString(CourseTableCell.getText(), data.get("Course").toString());
	CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatus").toString());
	Input.click();
	wait(3);
	Drop.waitTillElementClickable();
	Drop.click();
	wait(3);
	LetterGradeSpan.waitTillElementClickable();
	LetterGradeSpan.click();
	wait(2);
	LetterGrade.click();
	ReasonSpan.waitTillElementFound();
	ReasonSpan.click();
	wait(2);
	DropReason.click();
	DropButton.waitTillElementClickable();
	DropButton.click();
	waitForPageToLoad();
	CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatusAfterDropping").toString());	
	return this;

}


public StudentMainPage ReinstateCourse(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link CourseTableCell = new Link("CourseTableCell", byXPath("//td[. = '"+data.get("Course")+"']"));
	Link CourseStatusTableCell = new Link("CourseStatusTableCell", byXPath("//td[8]"));
	//Link LetterGradeSpan = new Link("LetterGradeSpan", byXPath("//div[5]/cmc-drop-down-list[1]/div/div/span/span/span/span"));	
	Button Reinstate = new Button("Reinstate", byXPath("//a[text()='Reinstate']"));
	Button ReinstatePopUpButton = new Button("ReinstatePopUpButton", byXPath("//button[@id='confirmReinstateCourseWindowOkButton']"));
	Button Override1 = new Button("Override button", byXPath("//button[@id='confirmOverrideRegistrationHoldWindowOkButton']"));
	
	
	waitForPageToLoad();
	AcademicRecords.waitTillElementClickable();
	AcademicRecords.click();
	StudentCourses.waitTillElementClickable();
	StudentCourses.click();
	waitForPageToLoad();
	CustomAsserts.containsString(CourseTableCell.getText(), data.get("Course").toString());
	CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatus").toString());
	Input.click();
	wait(3);
	Reinstate.waitTillElementClickable();
	Reinstate.click();
	wait(3);
	if (ReinstatePopUpButton.isElementPresent()) {
		ReinstatePopUpButton.click();       
    }
	wait(2);
	 if (Override1.isElementPresent()) {
		 Override1.click();       
     }
	
	waitForPageToLoad();
	CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatusAfterReinstating").toString());	
	return this;

}

public StudentMainPage UnregisterCourse(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link CourseTableCell = new Link("CourseTableCell", byXPath("//td[. = '"+data.get("Course")+"']"));
	Link CourseStatusTableCell = new Link("CourseStatusTableCell", byXPath("//td[8]"));
	//Link LetterGradeSpan = new Link("LetterGradeSpan", byXPath("//div[5]/cmc-drop-down-list[1]/div/div/span/span/span/span"));
	Link Unregister = new Link("Unregister", byCSSSelector("#courseUnRegisterButton"));
	Link ReasonSpan = new Link("ReasonSpan", byXPath("//ng-transclude/div[2]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Dropbox UnregisterDropDown = new Dropbox("Unregister", byXPath("//li[. = '"+data.get("UnregisterReason")+"']"));
	Button OverrideAndUnregister = new Button("OverrideAndUnregister", byXPath("//button[. = 'Override & Unregister']"));
	Link MessageSpan = new Link("Unregister message success", byXPath("/span[. = 'The Student Course records were successfully unregistered.']"));
		
	
	waitForPageToLoad();
	AcademicRecords.waitTillElementClickable();
	AcademicRecords.click();
	StudentCourses.waitTillElementClickable();
	StudentCourses.click();
	waitForPageToLoad();
	CustomAsserts.containsString(CourseTableCell.getText(), data.get("Course").toString());
	CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatus").toString());
	Input.click();
	wait(3);
	Unregister.click();
	wait(8);
	ReasonSpan.waitTillElementClickable();
	ReasonSpan.click();
	wait(2);
	UnregisterDropDown.click();
	OverrideAndUnregister.click();
	waitForPageToLoad();
	CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatusAfterUnregistering").toString());
	//MessageSpan.waitTillElementFound();
	//MessageSpan.isDisplayed();	
	return this;

}

public StudentMainPage AddLetterGrade(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link CourseTableCell = new Link("CourseTableCell", byXPath("//td[. = '"+data.get("Course")+"']"));
	Link CourseStatusTableCell = new Link("CourseStatusTableCell", byXPath("//td[8]"));
	Link LetterGradeSpan = new Link("LetterGradeSpan", byXPath("//div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Link CourseSpan = new Link("CourseSpan", byXPath("//span[. = '"+data.get("Course")+"']"));
	Button FinalGrades = new Button("FinalGrades", byXPath("//button[. = 'Final Grades']"));
	Dropbox LetterGradeDropBox = new Dropbox("LetterGradeDropBox", byXPath("//li[. = '"+data.get("LetterGrade")+"']"));
	Button Save = new Button("Save", byXPath("//ng-transclude/cmc-toolbar/section/cmc-toolbar-button-save//button"));
	Button PostGrade = new Button("PostGrade", byXPath("//button[@id='confirmPostGradeWindowOkButton']"));
	
			
	waitForPageToLoad();
	AcademicRecords.waitTillElementClickable();
	AcademicRecords.click();
	StudentCourses.waitTillElementClickable();
	StudentCourses.click();
	waitForPageToLoad();
	CustomAsserts.containsString(CourseTableCell.getText(), data.get("Course").toString());
	//CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatus").toString());
	Input.click();
	CourseSpan.click();
	waitForPageToLoad();
	scrollPage(0, -200);
	FinalGrades.waitTillElementClickable();
	FinalGrades.click();
	wait(6);
	scrollPage(0, 200);
	LetterGradeSpan.waitTillElementClickable();
	LetterGradeSpan.click();
	wait(2);
	LetterGradeDropBox.click();
	scrollPage(0, -200);
	Save.click();
	wait(3);
	if (PostGrade.isElementPresent()) {
		PostGrade.click();       
     } 
	waitForPageToLoad();
	scrollPage(0, -400);
	CustomAsserts.containsString(CourseStatusTableCell.getText(), data.get("CourseStatusAfterAddingLetterGrade").toString());	
	return this;

}

public StudentMainPage CreateStudentAndEnrollment(StringHash data) throws Exception{
	
	int PhoneNumber = AppendValue.apendNumber();	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	TextField FirstName = new TextField("FirstName", byCSSSelector("#firstName"));
	TextField LastName = new TextField("LastName", byCSSSelector("#lastName"));
	TextField TitleSpan = new TextField("TitleSpan", byXPath("//cmc-collapse/div/div[2]/div[3]/cmc-drop-down-list/div/div/span/span/span/span"));
	Dropbox Title = new Dropbox("Title", byXPath("//li[. = '"+data.get("Title")+"']"));
	TextField GenderSPan = new TextField("GenderSPan", byXPath("//div[3]/div[3]/cmc-drop-down-list/div/div/span/span/span/span"));
	Dropbox Gender = new Dropbox("Gender", byXPath("//span[. = '"+data.get("Gender")+"']"));
	TextField MaritalStatusSpan = new TextField("MaritalStatusSpan", byXPath("//div[5]/div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox MaritalStatus = new Dropbox("MaritalStatus", byXPath("//span[. = '"+data.get("MaritalStatus")+"']"));
	TextField DateOfBirth = new TextField("DateOfBirth", byCSSSelector("#dateOfBirth"));
	TextField Nationality = new TextField("Nationality", byCSSSelector("[name='nationality_input']"));
	TextField Citizenship = new TextField("Citizenship", byXPath("(//input[@aria-label='citizen'])[1]"));
	TextField HomeCampusSpan = new TextField("HomeCampusSpan", byXPath("//div[4]/cmc-multi-select/div/div/div[1]/div"));
	Dropbox HomeCampus = new Dropbox("HomeCampus", byXPath("//li[. = '"+data.get("HomeCampus")+"']"));
	Dropbox ContactInformation = new Dropbox("ContactInformation", byXPath("//cns-student-contact-information/section/div/cmc-collapse/div/div[1]/div//div"));
	TextField PhoneNum = new TextField("PhoneNum", byCSSSelector("#phoneNumber"));
	TextField EmailAddress = new TextField("EmailAddress", byCSSSelector("#emailAddress"));
	TextField StreetAddress = new TextField("StreetAddress", byCSSSelector("#streetAddress"));
	TextField City = new TextField("City", byCSSSelector("#city"));
	TextField StateSpan = new TextField("StateSpan", byXPath("//div/div/div[7]/cmc-drop-down-list[1]/div/div/span/span/span/span"));
	Dropbox State = new Dropbox("State", byXPath("//div/div/div//span[. = '"+data.get("State")+"']"));
	TextField ZipCode = new TextField("ZipCode", byCSSSelector("[name='zipCode_input']"));
	TextField SectionSpan = new TextField("SectionSpan", byXPath("//section/div/div/div[2]/div"));
	Dropbox RecruitInformation = new Dropbox("RecruitInformation", byXPath("//cns-student-recruiting/section/div/cmc-collapse/div/div[1]/div//div"));
	TextField ProspectSourceSpan = new TextField("ProspectSourceSpan", byXPath("//cns-student-recruiting/section/div/cmc-collapse/div/div[2]/div/div[2]/cmc-multi-select/div/div/div[1]/div"));
	Checkbox ProspectSource = new Checkbox("ProspectSource", byXPath("//li[3]//input"));
	Button Select = new Button("Select", byCSSSelector("#leadVendorSubVendorOkButton"));
	TextField ProspectTypeSpan = new TextField("ProspectTypeSpan", byXPath("//cns-student-recruiting/section/div/cmc-collapse/div/div[2]/div/div[2]/cmc-drop-down-list/div/div/span/span/span/span"));
	Dropbox ProspectType = new Dropbox("ProspectType", byXPath("//span[1][. = '"+data.get("ProspectType")+"']"));
	Button AdminRep = new Button("AdminRep", byCSSSelector("#search_display_recruitAssignedAdmissionsRep"));
	TextField SearchNameAdminRep = new TextField("SearchNameAdminRep", byXPath("//input[@placeholder = 'Search Name']"));
	Checkbox Input = new Checkbox("Input", byXPath("//td/input"));
	Button Select1 = new Button("Select1", byXPath("//div/button[. = 'Select']"));
	TextField ProgramSpan = new TextField("ProgramSpan", byXPath("//cns-student-recruiting/section/div/cmc-collapse/div/div[2]/div/div[4]/cmc-multi-select/div/div/div[1]/div"));
	Dropbox Program = new Dropbox("Program", byXPath("//li[. = '"+data.get("Program")+"']"));
	TextField ExpectedStartDate = new TextField("ExpectedStartDate", byCSSSelector("#recruitExpectedStartDate"));
	Button Save = new Button("Save", byXPath("//cmc-toolbar-button-save//button"));
	Link AdmissionsSpan = new Link("AdmissionsSpan", byXPath("//cns-panel-bar/ul/li[2]/span"));
	Link StudentApplications = new Link("StudentApplications", byXPath("//span[. = 'Student Applications']"));
	Link New = new Link("New", byXPath("//a[5][. = 'New']"));
	Link ApplicationTypeSpan = new Link("ApplicationTypeSpan", byXPath("//div[1]/cmc-drop-down-list[2]/div/div/span/span/span/span"));
	Dropbox ApplicationType = new Dropbox("ApplicationType", byXPath("//span[. = '"+data.get("ApplicationType")+"']"));
	Link ProgramCodeSpan = new Link("ProgramCodeSpan", byXPath("//div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox ProgramCode = new Dropbox("ProgramCode", byXPath("//span[. = '"+data.get("ProgramCode")+"']"));
	Link ProgramVersionCodeSpan = new Link("ProgramVersionCodeSpan", byXPath("//cns-student-applicant-pending-enrollment-information-detail/section/div/cmc-collapse/div/div[2]/div/div[3]/cmc-drop-down-list/div/div/span/span/span/span"));
	Dropbox ProgramVersionCode = new Dropbox("ProgramVersionCode", byXPath("//span[. = '"+data.get("ProgramVersionCode")+"']"));
	Link VersionStartDate = new Link("VersionStartDate", byXPath("//cns-student-applicant-pending-enrollment-information-detail/section/div/cmc-collapse/div/div[2]/div/div[5]/cmc-drop-down-list[1]/div/div/span/span/span/span"));
	Dropbox VersionStartDateDropBox = new Dropbox("VersionStartDateDropBox", byXPath("//span[2][. = '"+data.get("VersionStartDate")+"']"));
	Link StudentStatusSpan = new Link("StudentStatusSpan", byXPath("//cns-student-applicant-date-and-student-status-detail/section/div/cmc-collapse/div/div[2]/div/div[3]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox StudentStatus = new Dropbox("StudentStatus", byXPath("//span[. = '"+data.get("StudentStatus")+"']"));
	Button Save1 = new Button("Save1", byXPath("//div[2]/cmc-toolbar/section/cmc-toolbar-button-save//button"));
	Link EnrollmentSpan = new Link("EnrollmentSpan", byXPath("//li[3]/div/div[1]/div"));
	Button Use = new Button("Use", byCSSSelector("#applicantRecordDialogOkButton"));
	Button Next = new Button("Next", byXPath("//div[2]/button[. = 'Next']"));
	Link StudentStatusSpan1 = new Link("StudentStatusSpan1", byXPath("//cns-new-student-enrollment-period-program-selection-detail/section/div/cmc-collapse/div/div[2]/div[1]/cmc-drop-down-list-classic[2]/div/div/span/span/span/span"));
	Dropbox StudentStatus1 = new Dropbox("StudentStatus1", byXPath("//span[. = '"+data.get("StudentStatus1")+"']"));
	Link ProgramLanguage = new Link("ProgramLanguage", byXPath("//cmc-drop-down-list-classic[7]/div/div/span/span/span/span"));
	Dropbox ProgramLanguageDropbox = new Dropbox("ProgramLanguageDropbox", byXPath("//span[. = '"+data.get("ProgramLanguage")+"']"));
	Link GradeLevelSpan = new Link("GradeLevelSpan", byXPath("//cmc-drop-down-list-classic[8]/div/div/span//span[2]"));
	Dropbox GradeLevel = new Dropbox("GradeLevel", byXPath("//span[. = '"+data.get("GradeLevel")+"']"));
	Link BillingMethodSpan = new Link("BillingMethodSpan", byXPath("//cmc-drop-down-list[2]/div/div/span//span[2]"));
	Dropbox BillingMethod = new Dropbox("BillingMethod", byXPath("//span[. = '"+data.get("BillingMethod")+"']"));
	TextField EnrollmentDate = new TextField("EnrollmentDate", byXPath("//cmc-date-picker[2]//input[@placeholder = 'MM/DD/YYYY']"));
	Button Next1 = new Button("Next1", byXPath("//div[5]/button[. = 'Next']"));
	Button Next2 = new Button("Next2", byXPath("//div[2]/button[. = 'Next']"));
	Button Next3 = new Button("Next3", byXPath("//button[. = 'Next']"));
	Link Enroll = new Link("Enroll", byXPath("//cmc-common-toolbar[2]//a[. = 'Enroll']"));
	TextField StudentFinalStatus = new TextField("StudentFinalStatus", byXPath("//td[text()='"+data.get("StudentStatus1")+"']"));
	
	
	
	waitForPageToLoad();
	FirstName.click();
	FirstName.clearAndType(AppendValue.apendString().toString());
	//FirstName.clearAndType(data.get("FirstName").toString());
	LastName.click();
	wait(3);
	//LastName.clearAndType(data.get("LastName").toString());
	LastName.clearAndType(AppendValue.apendString().toString());
	TitleSpan.click();
	wait(2);
	Title.click();
	GenderSPan.click();
	wait(2);
	Gender.click();
	MaritalStatusSpan.click();
	wait(2);
	MaritalStatus.click();
	DateOfBirth.click();
	DateOfBirth.clearAndType(data.get("DateOfBirth").toString());
	Nationality.click();
	Nationality.clearAndType(data.get("Nationality").toString());
	Citizenship.click();
	Citizenship.clearAndType(data.get("Citizenship").toString());
	HomeCampusSpan.click();
	wait(2);
	HomeCampus.click();
	scrollPage(0, 350);
	ContactInformation.click();
	wait(2);
	scrollPage(0, 100);
	PhoneNum.click();
	//PhoneNum.sendKeys(PhoneNumber);
	//PhoneNum.e
	//PhoneNum.sendKeys(PhoneNumber)
	//PhoneNum.type(PhoneNumber.toInt());
	PhoneNum.type(data.get("PhoneNum").toString());
	//PhoneNum.typeNum(AppendValue.apendNumber();
	//PhoneNum.sendKeys(AppendValue.apendNumber());
	EmailAddress.click();
	wait(6);
	EmailAddress.clearAndType(data.get("EmailAddress").toString());
	scrollPage(0, 250);
	StreetAddress.click();
	wait(2);
	StreetAddress.clearAndType(data.get("StreetAddress").toString());
	City.click();
	City.clearAndType(data.get("City").toString());
	StateSpan.click();
	wait(2);
	State.click();
	wait(3);
	ZipCode.click();
	ZipCode.clearAndType(data.get("ZipCode").toString());
	SectionSpan.click();
	RecruitInformation.click();
	scrollPage(0, 400);
	wait(2);
	ProspectSourceSpan.click();
	wait(2);
	ProspectSource.click();
	wait(2);
	Select.click();
	wait(2);
	ProspectTypeSpan.click();
	wait(1);
	ProspectType.click();
	wait(1);
	AdminRep.click();
	wait(3);
	SearchNameAdminRep.click();
	SearchNameAdminRep.clearAndType(data.get("SearchNameAdminRep").toString());
	wait(2);
	Input.click();
	wait(1);
	Select1.click();
	wait(1);
	ProgramSpan.click();
	wait(1);
	Program.click();
	ExpectedStartDate.click();
	ExpectedStartDate.clearAndType(data.get("ExpectedStartDate").toString());
	wait(2);
	Save.click();
	waitForPageToLoad();
	AdmissionsSpan.click();
	StudentApplications.click();
	wait(5);
	New.click();
	waitForPageToLoad();
	scrollPage(0, 400);
	ApplicationTypeSpan.click();
	wait(1);
	ApplicationType.click();
	ProgramCodeSpan.click();
	wait(1);
	ProgramCode.click();
	ProgramVersionCodeSpan.click();
	wait(1);
	ProgramVersionCode.click();
	wait(3);
	scrollPage(0, 200);
	VersionStartDate.click();
	wait(1);
	VersionStartDateDropBox.click();
	wait(3);
	scrollPage(0, 400);
	StudentStatusSpan.click();
	wait(2);
	StudentStatus.click();
	wait(2);
	scrollPage(0, -500);
	Save1.click();
	waitForPageToLoad();
	AcademicRecords.click();
	EnrollmentSpan.click();
	waitForPageToLoad();
	New.click();
	waitForPageToLoad();
	Use.click();
	wait(3);
	Next.click();
	wait(5);
	StudentStatusSpan1.click();
	wait(1);
	StudentStatus1.click();
	ProgramLanguage.click();
	wait(1);
	ProgramLanguageDropbox.click();
	GradeLevelSpan.click();
	wait(1);
	GradeLevel.click();
	scrollPage(0, 200);
	BillingMethodSpan.click();
	wait(1);
	BillingMethod.click();
	EnrollmentDate.click();
	EnrollmentDate.clearAndType(data.get("EnrollmentDate").toString());
	Next1.click();
	wait(4);
	Next2.click();
	wait(2);
	Next3.click();
	wait(2);
	Enroll.click();
	waitForPageToLoad();
	CustomAsserts.containsString(StudentFinalStatus.getText(), data.get("StudentStatus1").toString());	
	return this;

}


public StudentMainPage AddTasks(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link ContactManager = new Link("ContactManager", byXPath("(//li[1]/span)[5]"));
	Link TasksSpan = new Link("TasksSpan", byXPath("//li[1]/div/div[1]/div"));
	Button New = new Button("New", byXPath("//a[5][. = 'New']"));
	Button TaskTemplateSpan = new Button("TaskTemplateSpan", byXPath("//cns-student-task-form/div/div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox TaskTemplateDropDown = new Dropbox("TaskTemplateDropDown", byXPath("//span[. = '"+data.get("TaskTemplate")+"']"));
	TextField Subject = new TextField("Subject", byCSSSelector("[name='subject']"));
	Button StatusSpan = new Button("StatusSpan", byXPath("//div[8]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Dropbox Status = new Dropbox("Status", byXPath("//div/span[. = '"+data.get("Status")+"']"));
	Button SaveAndClose = new Button("SaveAndClose", byXPath("//div[2]/cmc-toolbar/section/cmc-toolbar-button-save-close//button"));
	Link TaskSubjectTableCell = new Link("TaskSubjectTableCell", byXPath("//td[1][. = '"+data.get("TaskTemplate")+"']"));
		
	waitForPageToLoad();
	ContactManager.click();
	wait(2);
	TasksSpan.click();
	wait(6);
	New.click();
	waitForPageToLoad();
	TaskTemplateSpan.click();
	wait(2);
	TaskTemplateDropDown.click();
	wait(5);
	Subject.click();
	scrollPage(0, 300);
	StatusSpan.click();
	wait(2);
	Status.click();
	scrollPage(0, -400);
	SaveAndClose.click();
	waitForPageToLoad();
	scrollPage(0, -300);
	CustomAsserts.containsString(TaskSubjectTableCell.getText(), data.get("TaskTemplate").toString());
	return this;
}


public StudentMainPage ConfirmPendingTasks(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link ContactManager = new Link("ContactManager", byXPath("(//li[1]/span)[5]"));
	Link TasksSpan = new Link("TasksSpan", byXPath("//li[1]/div/div[1]/div"));
	Button New = new Button("New", byXPath("//a[5][. = 'New']"));
	Button TaskTemplateSpan = new Button("TaskTemplateSpan", byXPath("//cns-student-task-form/div/div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox TaskTemplateDropDown = new Dropbox("TaskTemplateDropDown", byXPath("//span[. = '"+data.get("TaskTemplate")+"']"));
	TextField Subject = new TextField("Subject", byCSSSelector("[name='subject']"));
	Button StatusSpan = new Button("StatusSpan", byXPath("//div[8]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Dropbox Status = new Dropbox("Status", byXPath("//div/span[. = '"+data.get("Status")+"']"));
	Button SaveAndClose = new Button("SaveAndClose", byXPath("//div[2]/cmc-toolbar/section/cmc-toolbar-button-save-close//button"));
	Link TaskSubjectTableCell = new Link("TaskSubjectTableCell", byXPath("//td[1][. = '"+data.get("TaskTemplate")+"']"));
	Link TaskStatusTableCell = new Link("TaskStatusTableCell", byXPath("(//td/span[text()='"+data.get("Status")+"'])[1]"));
	
	waitForPageToLoad();
	ContactManager.click();
	wait(2);
	TasksSpan.click();
	wait(6);
	CustomAsserts.containsString(TaskSubjectTableCell.getText(), data.get("TaskTemplate").toString());
	CustomAsserts.containsString(TaskStatusTableCell.getText(), data.get("Status").toString());
	return this;

}

public StudentMainPage EditTasks(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link ContactManager = new Link("ContactManager", byXPath("(//li[1]/span)[5]"));
	Link TasksSpan = new Link("TasksSpan", byXPath("//li[1]/div/div[1]/div"));
	Button New = new Button("New", byXPath("//a[5][. = 'New']"));
	Button TaskTemplateSpan = new Button("TaskTemplateSpan", byXPath("//cns-student-task-form/div/div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox TaskTemplateDropDown = new Dropbox("TaskTemplateDropDown", byXPath("//span[. = '"+data.get("TaskTemplate")+"']"));
	TextField Subject = new TextField("Subject", byCSSSelector("[name='subject']"));
	Button StatusSpan = new Button("StatusSpan", byXPath("//div[8]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Dropbox Status = new Dropbox("Status", byXPath("//div/span[. = '"+data.get("Status")+"']"));
	Button SaveAndClose = new Button("SaveAndClose", byXPath("//div[2]/cmc-toolbar/section/cmc-toolbar-button-save-close//button"));
	Link TaskSubjectTableCell = new Link("TaskSubjectTableCell", byXPath("//td[1][. = '"+data.get("TaskTemplate")+"']"));
	Link TaskLink = new Link("TaskLink", byXPath("//a[. = '"+data.get("TaskTemplate")+"']"));
	TextField Note = new TextField("Note", byCSSSelector("[name='noteTextArea']"));
	Link TaskStatusTableCell1 = new Link("TaskStatusTableCell", byXPath("//td[. = '"+data.get("Status")+"']"));
	
	
	
	waitForPageToLoad();
	ContactManager.click();
	wait(2);
	TasksSpan.click();
	wait(6);
	TaskLink.waitTillElementClickable();
	TaskLink.click();
	waitForPageToLoad();
	scrollPage(0, 500);
	StatusSpan.click();
	wait(2);
	Status.click();
	wait(2);
	Note.click();
	Note.clearAndType(data.get("Note").toString());
	scrollPage(0, -500);
	SaveAndClose.click();
	waitForPageToLoad();
	scrollPage(0, -500);	
	CustomAsserts.containsString(TaskStatusTableCell1.getText(), data.get("Status").toString());
	return this;

}

public StudentMainPage CloseTask(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link ContactManager = new Link("ContactManager", byXPath("(//li[1]/span)[5]"));
	Link TasksSpan = new Link("TasksSpan", byXPath("//li[1]/div/div[1]/div"));
	Button New = new Button("New", byXPath("//a[5][. = 'New']"));
	Button TaskTemplateSpan = new Button("TaskTemplateSpan", byXPath("//cns-student-task-form/div/div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox TaskTemplateDropDown = new Dropbox("TaskTemplateDropDown", byXPath("//span[. = '"+data.get("TaskTemplate")+"']"));
	TextField Subject = new TextField("Subject", byCSSSelector("[name='subject']"));
	Button StatusSpan = new Button("StatusSpan", byXPath("//div[8]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Dropbox Status = new Dropbox("Status", byXPath("//div/span[. = '"+data.get("Status")+"']"));
	Button SaveAndClose = new Button("SaveAndClose", byXPath("//div[2]/cmc-toolbar/section/cmc-toolbar-button-save-close//button"));
	Link TaskSubjectTableCell = new Link("TaskSubjectTableCell", byXPath("//td[1][. = '"+data.get("TaskTemplate")+"']"));
	Link TaskLink = new Link("TaskLink", byXPath("//a[. = '"+data.get("TaskTemplate")+"']"));
	Button ActivityResultSpan = new Button("ActivityResultSpan", byXPath("//div[9]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Dropbox ActivityResultDropDown = new Dropbox("ActivityResultDropDown", byXPath("//span[. = '"+data.get("ActivityResult")+"']"));
	Link StatusTableCell = new Link("StatusTableCell", byXPath("//td[. = '"+data.get("StatusAfterClosing")+"']"));
	
		
	waitForPageToLoad();
	ContactManager.click();
	wait(2);
	TasksSpan.click();
	wait(6);
	TaskLink.waitTillElementClickable();
	TaskLink.click();
	waitForPageToLoad();
	scrollPage(0, 500);
	StatusSpan.click();
	wait(2);
	Status.click();
	wait(2);
	ActivityResultSpan.click();
	wait(2);
	ActivityResultDropDown.click();
	scrollPage(0, -400);
	SaveAndClose.click();
	waitForPageToLoad();
	scrollPage(0, -400);	
	CustomAsserts.containsString(StatusTableCell.getText(), data.get("StatusAfterClosing").toString());
	return this;

}



public StudentMainPage UpdatingAdminRep(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));	
	Link RecruitInformationSpan = new Link("RecruitInformationSpan", byXPath("//cns-student-recruiting/section/div/cmc-collapse/div/div[1]/div//div"));
	TextField AdminRepSpan = new TextField("AdminRepSpan", byXPath("//cns-student-recruiting/section/div/cmc-collapse/div/div[2]/div/div[3]/cmc-search/dl/dd[1]/cmc-search-display/div/div"));
	TextField SearchBox = new TextField("AdminRepSpan", byCSSSelector("#search"));
	Link AdminRepCheckBox = new Link("AdminRepCheckBox", byXPath("//div/cmc-grid/div/div/div[2]//input"));
	Button Select = new Button("Select", byXPath("//div/button[. = 'Select']"));
	Button Save = new Button("Save", byXPath("//button[@aria-label='Save']"));
	Button SaveAgain = new Button("SaveAgain", byXPath("//button[@id='reassignLeadSaveButton']"));
	

	waitForPageToLoad();
	scrollPage(0, 600);
	RecruitInformationSpan.waitTillElementClickable();
	RecruitInformationSpan.click();
	wait(2);
	scrollPage(0, 300);	
	AdminRepSpan.click();
	wait(6);
	SearchBox.click();
	SearchBox.clearAndType(data.get("AdminRep").toString());
	wait(5);
	if(AdminRepCheckBox.isSelected()){
		wait(2);
		SearchBox.click();
		SearchBox.clearAndType(data.get("AdminRep1").toString());
		wait(4);
		AdminRepCheckBox.click();
		wait(2);
		Select.click();
		//Cancel.click();
		TestReportsLog.log(LogStatus.INFO, "Admin Rep is selected as "+data.get("AdminRep1").toString());
	}
	else {
		wait(3);
		AdminRepCheckBox.click();
		wait(2);
		Select.click();
		TestReportsLog.log(LogStatus.INFO, "Admin Rep is selected as "+data.get("AdminRep").toString());
	}
	wait(6);
	scrollPage(0, -600);
	Save.click();
	wait(8);
	//SaveAgain.click();
	SaveAgain.click();
	//CustomAsserts.containsString(StatusTableCell.getText(), data.get("StatusAfterClosing").toString());
	return this;

}



public StudentMainPage VerifySMSConfiguration(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	Link ContactInformationSpan = new Link("ContactInformationSpan", byXPath("//cns-student-contact-information/section/div/cmc-collapse/div/div[1]/div//div"));
	//Link SubscribeToSMSCheckBox = new Link("SubscribeToSMS", byXPath("(//div[3]/cmc-checkbox//label)[1]"));
	Link SubscribeToSMSCheckBox = new Link("SubscribeToSMS", byXPath("//label[@for='subscribeToSms']"));
	TextField SMSServiceProvider = new TextField("SMSServiceProvider", byCSSSelector("[name='smsProvider_input']"));
	Link SMSServiceProviderList = new Link("SMSServiceProviderList", byXPath("//li[. = '"+SMSServiceProviderValue+"']"));
	Button Save = new Button("Save", byXPath("//cmc-toolbar-button-save//button"));
	Link SuccessMessageSpan = new Link("SuccessMessageSpan", byXPath("//span[. = 'The Student records were successfully saved.']"));
	TextField MobileNum = new TextField("MobileNum", byXPath("//input[@id='mobileNumber']"));
	Button SaveAgain = new Button("SaveAgain", byXPath("//button[@id='oldAddressSaveButton']"));
	TextField AddressType = new TextField("AddressType", byXPath("//input[@name='oldAddrAddressType_input']"));
	Link AddressTypeValue = new Link("AddressTypeValue", byXPath("//span[text()='"+data.get("AddressType")+"']"));
	
	
	waitForPageToLoad();
	scrollPage(0, 600);
	ContactInformationSpan.click();
	wait(3);
	scrollPage(0, 300);
	wait(3);
	if(SubscribeToSMSCheckBox.isSelected()) {
		wait(2);
		SMSServiceProvider.click();
		wait(2);
		SMSServiceProvider.clearAndType(SMSServiceProviderValue.toString());
		wait(2);
		SMSServiceProviderList.click();
		wait(3);
	}
	else
	{
		SubscribeToSMSCheckBox.clickUsingJavaScriptExecutor();
		wait(2);
		SMSServiceProvider.click();
		wait(2);
		SMSServiceProvider.clearAndType(SMSServiceProviderValue.toString());
		wait(2);
		SMSServiceProviderList.click();
		wait(3);	
	}
		wait(2);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementById('mobileNumber').value='4567890123'");
		wait(3);
		Save.click();
		wait(10);
		if(AddressType.isDisplayed()){
		AddressType.click();
		wait(2);
		AddressType.clearAndType(data.get("AddressType").toString());
		wait(2);
		AddressTypeValue.click();
		wait(2);
		wait(8);
		CustomAsserts.containsString(SuccessMessageSpan.getText(), data.get("SuccessMessageSpan").toString());
		}
		CustomAsserts.containsString(SuccessMessageSpan.getText(), data.get("SuccessMessageSpan").toString());
	return this;

}


public StudentMainPage AddSchoolFields(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	
	Link FinancialAidSpan = new Link("FinancialAidSpan", byXPath("//li[5]/span"));
	Link SchoolFieldsSpan = new Link("SchoolFieldsSpan", byXPath("//li[5]/div/div[8]/div"));
	Link VeterinarianTypePrefereranceSpan = new Link("VeterinarianTypePrefereranceSpan", byXPath("//div[5]/div[1]/div/div/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Link VeterinarianTypePrefereranceDropDown = new Link("VeterinarianTypePrefereranceDropDown", byXPath("//li[. = '"+data.get("VeterinarianTypePrefererance")+" ']"));
	Link LeftHandedSpan = new Link("LeftHandedSpan", byXPath("//cmc-multi-select/div/div/div[1]/div"));
	Link LeftHandedDropDown = new Link("LeftHandedDropDown", byXPath("//div[2]//li[. = '"+data.get("LeftHanded")+"']"));
	TextField FavoriteBrewPub = new TextField("FavoriteBrewPub", byCSSSelector("#BREWPUB"));
	TextField NYTAP = new TextField("NYTAP", byCSSSelector("#NYTP"));
	Button Save = new Button("Save", byXPath("//div[3]/cmc-toolbar/section/cmc-toolbar-button-save//button"));
	Link SuccessMessageSpan = new Link("SuccessMessageSpan", byXPath("//span[. = 'The Student records were successfully saved.']"));
	

	waitForPageToLoad();
	FinancialAidSpan.click();
	wait(2);
	scrollPage(0, 200);
	SchoolFieldsSpan.click();
	waitForPageToLoad();
	VeterinarianTypePrefereranceSpan.click();
	wait(2);
	VeterinarianTypePrefereranceDropDown.click();
	wait(2);
	LeftHandedSpan.click();
	wait(2);
	LeftHandedDropDown.click();
	wait(2);	
	FavoriteBrewPub.click();
	FavoriteBrewPub.clearAndType(data.get("FavoriteBrewPub").toString());
	wait(2);
	NYTAP.click();
	NYTAP.clearAndType(data.get("NYTAP").toString());
	wait(2);
	scrollPage(0, -500);
	Save.click();
	wait(6);
	CustomAsserts.containsString(SuccessMessageSpan.getText(), data.get("SuccessMessageSpan").toString());	
	//CustomAsserts.containsString(StatusTableCell.getText(), data.get("StatusAfterClosing").toString());
	return this;

}



public StudentMainPage ScheduleStudentPaymentPlan(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	
	Link StudentAccountsSpan = new Link("StudentAccountsSpan", byXPath("//li[6]/span"));
	Link PaymentScheduleSpan = new Link("PaymentScheduleSpan", byXPath("//span[. = 'Payment Schedule']"));
	Link New = new Link("New", byXPath("//a[5][. = 'New']"));
	Button AwardYearSpan = new Button("AwardYearSpan", byXPath("//div[1]/cmc-drop-down-list-classic/div/div/span/span/span[. = ' ']"));
	TextField AwardYear = new TextField("AwardYear", byXPath("//div[45]//input"));
	Link AwardYearDropDown = new Link("AwardYearDropDown", byXPath("//li[. = '"+data.get("AwardYear")+"']"));
	Link FundSourceSpan = new Link("FundSourceSpan", byXPath("//div[4]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	TextField FundSource = new TextField("FundSource", byXPath("//div[48]//input"));
	Link FundSourceDropDown = new Link("FundSourceDropDown", byXPath("//span[. = '"+data.get("FundSource")+"    ']"));
	TextField GrossAmountSpan = new TextField("GrossAmount", byXPath("//cmc-numeric-input-text/div/div/span/span"));
	TextField GrossAmount = new TextField("GrossAmount", byCSSSelector("[name='grossAmount']"));
	Link StatusSpan = new Link("StatusSpan", byXPath("//div[6]/cmc-drop-down-list-classic/div/div/span/span/span/span"));
	Link StatusDropDown = new Link("StatusDropDown", byXPath("//li[. = '"+data.get("Status")+"']"));
	Button Proceed = new Button("Proceed", byXPath("//button[. = 'Proceed']"));
	Link Calculate = new Link("Calculate", byXPath("//a[3][. = 'Calculate']"));
	Link Save = new Link("Save", byXPath("//a[. = 'Save']"));
	Link PaymentScheduleCollapse = new Link("PaymentScheduleCollapse", byXPath("//div/section/div/cmc-collapse/div/div[1]/div//div"));
	Link FundSourceTableCell = new Link("FundSourceTableCell", byXPath("//a[. = '"+data.get("FundSourceFullName")+"']"));
	Link StatusTableCell = new Link("StatusTableCell", byXPath("//td[. = '"+data.get("Status")+"']"));
	Link BilledToTableCell = new Link("BilledToTableCell", byXPath("//td[. = '"+data.get("StudentName")+"']"));
	
	
	
	waitForPageToLoad();
	StudentAccountsSpan.click();
	wait(2);
	scrollPage(0, 200);
	PaymentScheduleSpan.click();
	waitForPageToLoad();
	New.click();
	waitForPageToLoad();
	AwardYearSpan.click();
	wait(2);
	AwardYear.click();
	AwardYear.clearAndType(data.get("AwardYear").toString());
	wait(2);
	AwardYearDropDown.click();
	wait(5);
	FundSourceSpan.click();
	wait(2);
	FundSource.click();
	FundSource.clearAndType(data.get("FundSource").toString());
	wait(2);
	FundSourceDropDown.click();
	wait(6);
	GrossAmountSpan.click();
	wait(2);
	//GrossAmount.Type(data.get("GrossAmount").toString());
	GrossAmount.type(data.get("GrossAmount").toString());
	wait(2);
	StatusSpan.click();
	wait(2);
	StatusDropDown.click();
	scrollPage(0, 100);
	Proceed.click();
	waitForPageToLoad();
	wait(10);
	scrollPage(0, 300);
	wait(2);
	Calculate.click();
	wait(6);
	scrollPage(0, -400);
	Save.click();
	waitForPageToLoad();
	wait(10);
	PaymentScheduleCollapse.click();
	wait(2);
	CustomAsserts.containsString(FundSourceTableCell.getText(), data.get("FundSourceFullName").toString());
	CustomAsserts.containsString(StatusTableCell.getText(), data.get("Status").toString());
	CustomAsserts.containsString(BilledToTableCell.getText(), data.get("StudentName").toString());	
	//CustomAsserts.containsString(StatusTableCell.getText(), data.get("StatusAfterClosing").toString());
	return this;

}

public StudentMainPage PerformRefundCalculation(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
		
	Link StudentAccountsSpan = new Link("StudentAccountsSpan", byXPath("//li[6]/span"));
	Link RefundCalculationsSpan = new Link("RefundCalculationsSpan", byXPath("//span[. = 'Refund Calculations']"));
	Link New = new Link("New", byXPath("//a[5][. = 'New']"));
	TextField CalculationName = new TextField("CalculationName", byCSSSelector("[name='refundCalcDescription']"));
	Button Calculate = new Button("Calculate", byXPath("//button[. = 'Calculate']"));	
	//String CalculationNameValue = "NewRefundCalculation"+AppendValue.apendString();
	String CalculationNameValue = "NewRefundCalculation"+AppendValue.apendString();
	Link CalculationTableCell = new Link("CalculationTableCell", byXPath("//a[. = '"+CalculationNameValue+"']"));
	Link Next = new Link("Next", byXPath("//button[text()='Next']"));
	Button Next1 = new Button("Next", byXPath("(//button[@id='advisorSelectionProceedButton'])[2]"));
	Button Next2 = new Button("Next", byXPath("(//button[@id='advisorSelectionProceedButton'])[3]"));
	Button Next3 = new Button("Next", byXPath("(//button[@id='advisorSelectionProceedButton'])[4]"));
	Button SaveAndClose = new Button("SaveAndClose", byXPath("(//a[@id='saveCloseButton'])[2]"));
	
	waitForPageToLoad();
	StudentAccountsSpan.click();
	wait(2);
	RefundCalculationsSpan.click();
	waitForPageToLoad();
	wait(10);
	New.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(5);
	CalculationName.click();
	CalculationName.clear();
	CalculationName.type(CalculationNameValue);
	wait(2);
	scrollPage(0, 300);
	wait(2);
	Calculate.click();
	waitForPageToLoad();
	scrollPage(0, 500);
//	Next1.clickUsingJavaScriptExecutor();
//	waitForPageToLoad();
//	wait(10);
//	scrollPage(0, -200);
//	Next2.clickUsingJavaScriptExecutor();
//	waitForPageToLoad();
//	scrollPage(0, -200);
//	Next3.clickUsingJavaScriptExecutor();
//	wait(10);
//	scrollPage(0, 500);
//	SaveAndClose.clickUsingJavaScriptExecutor();	
//	if(Next1.isElementDisplayed()) {
//	   Next1.click();
//	   //Next.clickUsingJavaScriptExecutor();
//	   waitForPageToLoad();
//	   wait(10);
//	   scrollPage(0, -200);
//	}
//	
//	if(Next2.isElementDisplayed()) {
//	   Next2.click();
//	   waitForPageToLoad();
//	   scrollPage(0, -200);
//	}
//	
//	if(Next3.isElementDisplayed()) {
//	   Next3.click();
//	   wait(10);
//	   scrollPage(0, 500);
//	}
//		
//	if(SaveAndClose.isElementDisplayed()) {
//	   //if(SaveAndClose.isElementEnabled()) {
//		SaveAndClose.click();
//	}
	waitForPageToLoad();
	scrollPage(0, 900);	
	CustomAsserts.containsString(CalculationTableCell.getText(), CalculationNameValue.toString());
	return this;
}

public StudentMainPage AddingEnrollmentToStudent(StringHash data) throws Exception{
	
	int PhoneNumber = AppendValue.apendNumber();	
	Link AdmissionsSpan = new Link("AdmissionsSpan", byXPath("//cns-panel-bar/ul/li[2]/span"));
	Link StudentApplications = new Link("StudentApplications", byXPath("//span[. = 'Student Applications']"));
	Link New = new Link("New", byXPath("//a[5][. = 'New']"));
	Link ApplicationTypeSpan = new Link("ApplicationTypeSpan", byXPath("//div[1]/cmc-drop-down-list[2]/div/div/span/span/span/span"));
	Dropbox ApplicationType = new Dropbox("ApplicationType", byXPath("//span[. = '"+data.get("ApplicationType")+"']"));
	Link ProgramCodeSpan = new Link("ProgramCodeSpan", byXPath("//div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox ProgramCode = new Dropbox("ProgramCode", byXPath("//span[. = '"+data.get("ProgramCode")+"']"));
	Link ProgramVersionCodeSpan = new Link("ProgramVersionCodeSpan", byXPath("//cns-student-applicant-pending-enrollment-information-detail/section/div/cmc-collapse/div/div[2]/div/div[3]/cmc-drop-down-list/div/div/span/span/span/span"));
	Dropbox ProgramVersionCode = new Dropbox("ProgramVersionCode", byXPath("//span[. = '"+data.get("ProgramVersionCode")+"']"));
	Link VersionStartDate = new Link("VersionStartDate", byXPath("//cns-student-applicant-pending-enrollment-information-detail/section/div/cmc-collapse/div/div[2]/div/div[5]/cmc-drop-down-list[1]/div/div/span/span/span/span"));
	Dropbox VersionStartDateDropBox = new Dropbox("VersionStartDateDropBox", byXPath("//span[2][. = '"+data.get("VersionStartDate")+"']"));
	Link StudentStatusSpan = new Link("StudentStatusSpan", byXPath("//cns-student-applicant-date-and-student-status-detail/section/div/cmc-collapse/div/div[2]/div/div[3]/cmc-drop-down-list/div/div/span//span[2]"));
	Dropbox StudentStatus = new Dropbox("StudentStatus", byXPath("//span[. = '"+data.get("StudentStatus")+"']"));
	Button Save1 = new Button("Save1", byXPath("//div[2]/cmc-toolbar/section/cmc-toolbar-button-save//button"));
	Link EnrollmentSpan = new Link("EnrollmentSpan", byXPath("//li[3]/div/div[1]/div"));
	Button Use = new Button("Use", byCSSSelector("#applicantRecordDialogOkButton"));
	Button Next = new Button("Next", byXPath("//div[2]/button[. = 'Next']"));
	Link StudentStatusSpan1 = new Link("StudentStatusSpan1", byXPath("//cns-new-student-enrollment-period-program-selection-detail/section/div/cmc-collapse/div/div[2]/div[1]/cmc-drop-down-list-classic[2]/div/div/span/span/span/span"));
	Dropbox StudentStatus1 = new Dropbox("StudentStatus1", byXPath("//span[. = '"+data.get("StudentStatus1")+"']"));
	Link ProgramLanguage = new Link("ProgramLanguage", byXPath("//cmc-drop-down-list-classic[7]/div/div/span/span/span/span"));
	Dropbox ProgramLanguageDropbox = new Dropbox("ProgramLanguageDropbox", byXPath("//span[. = '"+data.get("ProgramLanguage")+"']"));
	Link GradeLevelSpan = new Link("GradeLevelSpan", byXPath("//cmc-drop-down-list-classic[8]/div/div/span//span[2]"));
	Dropbox GradeLevel = new Dropbox("GradeLevel", byXPath("//span[. = '"+data.get("GradeLevel")+"']"));
	Link BillingMethodSpan = new Link("BillingMethodSpan", byXPath("//cmc-drop-down-list[2]/div/div/span//span[2]"));
	Dropbox BillingMethod = new Dropbox("BillingMethod", byXPath("//span[. = '"+data.get("BillingMethod")+"']"));
	TextField EnrollmentDate = new TextField("EnrollmentDate", byXPath("//cmc-date-picker[2]//input[@placeholder = 'MM/DD/YYYY']"));
	Button Next1 = new Button("Next1", byXPath("//div[5]/button[. = 'Next']"));
	Button Next2 = new Button("Next2", byXPath("//div[2]/button[. = 'Next']"));
	Button Next3 = new Button("Next3", byXPath("//button[. = 'Next']"));
	Link Enroll = new Link("Enroll", byXPath("//cmc-common-toolbar[2]//a[. = 'Enroll']"));
	TextField StudentFinalStatus = new TextField("StudentFinalStatus", byXPath("//td[text()='"+data.get("StudentStatus1")+"']"));	
	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	
			waitForPageToLoad();
			//wait(10);
			FilterDropDwon.click();
			wait(2);
			ClearFiltersButton.click();
			//waitForPageToLoad();
			wait(10);
			StuNumDropDown.click();
			//waitForPageToLoad();
			wait(2);
			StuNumFilter.click();
			//waitForPageToLoad();
			wait(2);
			value.clearAndType(data.get("Student Number"));
			//waitForPageToLoad();
			wait(2);
			FilterButton.click();
			//waitForPageToLoad();
			wait(15);
			ClickStudentName.click();
			waitForPageToLoad();
			wait(5);
			AdmissionsSpan.click();
			wait(2);
			StudentApplications.click();
			wait(10);
			New.click();
			waitForPageToLoad();
			wait(3);
			scrollPage(0, 300);
			wait(3);
			ApplicationTypeSpan.click();
			wait(5);
			ApplicationType.click();
			wait(5);
			ProgramCodeSpan.click();
			wait(2);
			ProgramCode.click();
			wait(5);
			ProgramVersionCodeSpan.click();
			wait(2);
			ProgramVersionCode.click();
			wait(3);
			scrollPage(0, 400);
			wait(3);
			Shift.clearAndType(data.get("Shift").toString());
			wait(2);
			SelShift.click();
			wait(2);
			VersionStartDateDropBox1.clearAndType(data.get("VersionStartDate").toString());
			wait(3);
			VersionStartDate.click();
			wait(3);
			scrollPage(0, 400);
			wait(5);
			StudentStatusSpan.click();
			wait(2);
			StudentStatus.click();
			wait(2);
			scrollPage(0, -500);
			Save1.clickUsingJavaScriptExecutor();
			waitForPageToLoad();
			wait(2);
			AcademicRecords.click();
			wait(2);
			EnrollmentSpan.click();
			waitForPageToLoad();
			wait(2);
			New.click();
			wait(30);
			use.clickUsingJavaScriptExecutor();
			wait(5);
			Next.click();
			wait(5);
			StudentStatusSpan1.click();
			wait(2);
			StudentStatus1.click();
			wait(2);
			GradeLevelSpan.click();
			wait(1);
			GradeLevel.click();
			scrollPage(0, 200);
			wait(2);
			BillingMethodSpan.click();
			wait(2);
			BillingMethod.click();
			wait(2);
			EnrollmentDate.click();
			wait(2);
			EnrollmentDate.clearAndType(data.get("EnrollmentDate").toString());
			wait(2);
			Next1.click();
			wait(4);
			Next2.click();
			wait(2);
			Next3.click();
			wait(2);
			Enroll.click();
			waitForPageToLoad();
			CustomAsserts.containsString(StudentFinalStatus.getText(), data.get("StudentStatus1").toString());
			return this;
}

public StudentMainPage Batcunr(StringHash data) throws Exception{
	
	Link SelInstructor = new Link("Click on selctIns", byXPath("//span[@title='"+data.get("Instructor Name")+"']"));
	waitForPageToLoad();
	wait(10);
	/*MenuButton.click();
	waitForPageToLoad();
	wait(2);
	Processes.click();
	waitForPageToLoad();
	wait(2);*/
	SearchProcesses.clearAndType(data.get("Search Name").toString());
	waitForPageToLoad();
	wait(2);
	Registration.click();
	waitForPageToLoad();
	wait(5);
	Unregister.click();
	waitForPageToLoad();
	wait(3);
	Term1.click();
	wait(3);
	//Name.clearAndType(data.get("Name").toString());
	SearchTerm.clearAndType(data.get("Term Name").toString());
	//waitForPageToLoad();
	wait(2);
	//SelectSG.click();
	//wait(2);
	SelectTerm.click();
	wait(3);
	Select1.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(2);
	//scrollPage(0, 200);
	//wait(2);
	Instructor.clearAndType(data.get("Instructor Name").toString());
	wait(5);
	SelInstructor.clickUsingJavaScriptExecutor();
	wait(1);
	Next2.clickUsingJavaScriptExecutor();
	wait(2);
	allstd.clickUsingJavaScriptExecutor();
	allstd.clickUsingJavaScriptExecutor();
	wait(2);
	scrollPage(0, 300);
	wait(2);
	Reason.clearAndType(data.get("Reason Name").toString());
	wait(3);
	SelReas.clickUsingJavaScriptExecutor();
	wait(1);
	Queureg2.clickUsingJavaScriptExecutor();
	wait(2);
	Queue.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(2);
	return this;
   }

public StudentMainPage RegTrack(StringHash data) throws Exception{
	waitForPageToLoad();
	wait(10);
	/*MenuButton.click();
	waitForPageToLoad();
	wait(2);
	Processes.click();
	waitForPageToLoad();
	wait(2);*/
	SearchProcesses.clearAndType(data.get("Search Name").toString());
	waitForPageToLoad();
	wait(2);
	Registration.click();
	waitForPageToLoad();
	wait(5);
	Track.click();
	waitForPageToLoad();
	wait(3);
	StudentGroup.clearAndType(data.get("Student Group Name").toString());
	wait(2);
	SelectSG.clickUsingJavaScriptExecutor();
	wait(5);
	SelectTrack.clickUsingJavaScriptExecutor();
	wait(3);
	Next1.clickUsingJavaScriptExecutor();
	wait(3);
	Checkall.clickUsingJavaScriptExecutor();
	wait(2);
	scrollPage(0, 200);
	Queureg.clickUsingJavaScriptExecutor();
	wait(2);
	Queue.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(2);
	return this;
   }


public StudentMainPage PlaceStudentsIntoExternship(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	
	
	Link CareerServices = new Link("Click on Career Services", byXPath("//cns-panel-bar/ul[1]/li[4]/span"));
	Link PlacementsInternships = new Link("Click on Placements&Internships", byXPath("//*[@id='studentTilesPanelBar']/li[4]/div/div[2]/div/span"));
	Button New = new Button("Click New", byXPath("//a[@id='studentPlacementNewButton']"));
	Link Employer = new Link("Select Employer", byXPath("//*[@id='search_display_employerSearch']"));
	TextField SearchEmployer = new TextField("Search Employer Name", byXPath("//*[@id='search']"));
	Checkbox EmployerButton = new Checkbox("Select Employer Button", byXPath("(//input[@type='checkbox'])[2]"));
	Button Select = new Button("Select Button", byXPath("//button[text()='Select']"));
	TextField JobType = new TextField("Enter Job Type", byXPath("//input[@name='jobType_input']"));
	Link SelJobType = new Link("Select Job Type", byXPath("//span[. ='Internship/Externship']"));
	//static TextField PlacementStatus = new TextField("Enter Job Status", byXPath("//input[@name='placementStatus_input']"));
	//static Link SelPlacementStatus = new Link("Select Job Status", byXPath("//*[@id='0884bfb5-865a-4e2f-ab5a-efd249df6840']/div/span[1]"));
	TextField jobTitle_input = new TextField("Enter jobTitle_input'", byXPath("//input[@name='jobTitle_input']"));
	Link SeljobTitle_input = new Link("Select jobTitle_input'", byXPath("//span[. ='Administrative']"));
	TextField InFieldofStudy = new TextField("Enter Field od Study'", byXPath("//input[@name='inFieldOfStudy_input']"));
	Link SelInFieldofStudy = new Link("Select Field od Study'", byXPath("//span[. ='Related']"));
	TextField HowPlaced = new TextField("Enter HowPlaced Value'", byXPath("//input[@name='howPlaced_input']"));
	Link SelHowPlaced = new Link("Sel HowPlaced Value'", byXPath("//span[. ='College']"));
	TextField SalaryAmount = new TextField("Enter Salary Amount'", byXPath("(//input[@aria-label='Salary Amount'])[1]"));
	//static Link SelSalaryAmount = new Link("Select Salary Amount'", byXPath("//*[@id='salary']/.."));
	TextField SalaryStatus = new TextField("Enter Salary Status'", byXPath("//input[@name='salaryOption_input']"));
	Link SelSalaryStatus = new Link("Select Salary Status'", byXPath("//span[. ='Actual']"));
	TextField SalaryType = new TextField("Enter Salary Type'", byXPath("//input[@name='salaryType_input']"));
	Link SelSalaryType = new Link("Select Salary Type'", byXPath("//span[. ='Flat Rate']"));
	TextField DatePlaced = new TextField("Enter Date Placed'", byXPath("//*[@id='datePlaced']"));
	TextField StartDate = new TextField("Enter Start Date'", byXPath("//*[@id='startDate']"));
	Button SaveAndClose = new Button("Save and Close", byXPath("(//button[@aria-label='Save & Close'])[2]"));
	Link EmployerAddedSuccessMessage = new Link("EmployerAddedSuccessMessage", byXPath("//a[. = '"+EmployerNameActualValue+"']"));
	
	
	
	waitForPageToLoad();	
	CareerServices.click();
	wait(3);
	PlacementsInternships.click();
	wait(6);
	New.click();
	wait(8);
	scrollPage(0, 300);	
	Employer.click();
	wait(4);
	SearchEmployer.clearAndType(EmployerNameActualValue.toString());
	wait(3);
	EmployerButton.click();
	wait(3);
	Select.click();
	wait(6);
	JobType.clearAndType(data.get("JobType Name").toString());
	wait(2);
	SelJobType.click();	
	//JobStatus.clearAndType(data.get("JobStatus Name").toString());
	//wait(2);
	//SelPlacementStatus.click();
	//wait(2);
	scrollPage(0,200);
	wait(2);
	jobTitle_input.clearAndType(data.get("jobTitle_input Name").toString());
	wait(1);
	SeljobTitle_input.click();
	scrollPage(0, 350);
	wait(2);
	SalaryAmount.sendKeys(data.get("SalaryAmount Name"));
	wait(2);
	InFieldofStudy.clearAndType(data.get("InFieldofStudy Name").toString());
	wait(2);
	SelInFieldofStudy.click();
	wait(2);
	HowPlaced.clearAndType(data.get("HowPlaced Name").toString());
	wait(2);
	SelHowPlaced.click();	
	scrollPage(0,200);
	wait(3);
	SalaryStatus.clearAndType(data.get("SalaryStatus Name").toString());
	wait(2);
	SelSalaryStatus.click();
	wait(2);
	SalaryType.clearAndType(data.get("SalaryType Name").toString());
	wait(2);
	SelSalaryType.click();
	wait(2);
	DatePlaced.clearAndType(data.get("Date Placed"));
	wait(2);
	StartDate.clearAndType(data.get("Start Date"));
	wait(5);
	scrollPage(0, -700);
	wait(2);
	SaveAndClose.waitTillElementClickable();
	SaveAndClose.click();
	waitForPageToLoad();
	scrollPage(0, -200);	
	CustomAsserts.containsString(EmployerAddedSuccessMessage.getText(), EmployerNameActualValue.toString());
	return this;

}


public StudentMainPage AddEstimatedFAPackaging(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));		
	Link FinancialAidSpan = new Link("FinancialAidSpan", byXPath("//li[5]/span"));
	Link EstimatesSpan = new Link("EstimatesSpan", byXPath("//li[5]/div/div[3]/div"));
	TextField BeginningAwardYear = new TextField("BeginningAwardYear", byXPath("//div[1]/cmc-drop-down-list-classic[2]/div/div/span//span[2]"));
	TextField EnterBeginningAwardYear = new TextField("EnterBeginningAwardYear", byXPath("//div[40]//input"));
	Link BeginningAwardYearDropDown = new Link("BeginningAwardYearDropDown", byXPath("//li[. = '"+data.get("BeginningAwardYear")+"']"));
	TextField TotalProgramCOA = new TextField("TotalProgramCOA", byXPath("//div[2]/cmc-numeric-input-text/div/div/span/span"));
	TextField TotalProgramCOAValue = new TextField("TotalProgramCOAValue", byCSSSelector("[name='estimateTotalCoa']"));
	TextField StartDate = new TextField("StartDate", byCSSSelector("[name='estimateStartDate']"));
	Button Save = new Button("Save", byXPath("//a[. = 'Save']"));
	Link EstimateRecordsSuccessMessage = new Link("EstimateRecordsSuccessMessage", byXPath("//span[. = '"+data.get("EstimateRecordsSuccessMessage")+"']"));
	Button CalculateEFC = new Button("CalculateEFC", byCSSSelector("#calculateEfcBtn"));
	Button CalculatePell = new Button("CalculatePell", byCSSSelector("#calculatePellBtn"));	
	Button ProgramVersionSpan = new Button("ProgramVersionSpan", byXPath("//cns-student-estimate-program-information/div/div/div[1]/cmc-drop-down-list-classic[1]/div/div/span//span[2]"));
	TextField ProgramVersionInputBox = new TextField("ProgramVersionInputBox", byXPath("//div[39]//input"));
	Link ProgramVersionDropDown = new Link("ProgramVersionDropDown", byXPath("//span[. = '"+data.get("ProgramVersion")+"']"));	
	Button Recalculate = new Button("Recalculate", byXPath("//button[@id='estimateCoaChangeConfirmationDialogOkButton']"));
		
	waitForPageToLoad();
	FinancialAidSpan.click();
	wait(2);	
	EstimatesSpan.click();
	waitForPageToLoad();
	wait(8);	
	ProgramVersionSpan.click();
	wait(2);
	ProgramVersionInputBox.click();
	ProgramVersionInputBox.clearAndType(data.get("ProgramVersion").toString());
	wait(2);
	ProgramVersionDropDown.click();
	wait(4);	
	BeginningAwardYear.click();
	wait(2);
	EnterBeginningAwardYear.click();
	wait(2);
	EnterBeginningAwardYear.clearAndType(data.get("BeginningAwardYear").toString());
	wait(2);
	BeginningAwardYearDropDown.click();
	wait(5);
	TotalProgramCOA.click();
	wait(2);
	TotalProgramCOAValue.type(data.get("COAValue").toString());
	wait(2);
	StartDate.click();
	wait(2);
	StartDate.clearAndType(data.get("StartDate").toString());
	wait(2);	
	if(Recalculate.isDisplayed()) {
		Recalculate.click();
		wait(10);
	}
	Save.click();
	wait(10);	
	CustomAsserts.containsString(EstimateRecordsSuccessMessage.getText(), data.get("EstimateRecordsSuccessMessage").toString());
	scrollPage(0, 550);
	wait(2);
	CalculateEFC.click();
	wait(5);
	CalculatePell.click();
	wait(5);
	scrollPage(0, -550);
	Save.click();
	wait(10);
	CustomAsserts.containsString(EstimateRecordsSuccessMessage.getText(), data.get("EstimateRecordsSuccessMessage").toString());	
	return this;
}

public StudentMainPage VerifyAcademicYearsInformation(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));	
	Link FinancialAidSpan = new Link("FinancialAidSpan", byXPath("//li[5]/span"));
	Link EstimatesSpan = new Link("EstimatesSpan", byXPath("//li[5]/div/div[3]/div"));
	Button EstimatedAwards = new Button("EstimatedAwards", byXPath("//button[. = 'Estimated Awards']"));
	TextField AwardYearTableCell = new TextField("AwardYear", byXPath("//td[. = '"+data.get("BeginningAwardYear")+"']"));
	TextField COATableCell = new TextField("COA", byXPath("//td[. = '"+data.get("COAValue")+"']"));
	
	
	waitForPageToLoad();
	FinancialAidSpan.click();
	wait(2);
	EstimatesSpan.click();
	waitForPageToLoad();
	wait(8);
	EstimatedAwards.click();
	waitForPageToLoad();	
	CustomAsserts.containsString(AwardYearTableCell.getText(), data.get("BeginningAwardYear").toString());
	//CustomAsserts.containsString(COATableCell.getText(), data.get("COAValue").toString());
	return this;

}

public StudentMainPage AddPromissoryNote(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	
	Link StudentAccountsSpan = new Link("StudentAccountsSpan", byXPath("//li[6]/span"));
	Link PaymentScheduleSpan = new Link("PaymentScheduleSpan", byXPath("//span[. = 'Payment Schedule']"));
	Link FundSourceType = new Link("FundType", byXPath("//a[. = '"+data.get("FundSourceFullName")+"']"));
	Link PromissoryNote = new Link("PromissoryNote", byXPath("//a[. = 'Promissory Note']"));
	//TextField StudentName = new TextField("StudentName", byXPath("//div/div[. = '"+data.get("StudentName")+"']"));
	TextField StudentName = new TextField("StudentName", byXPath("//div[text()='"+data.get("StudentName")+"']"));
	TextField PromissoryNotePoint = new TextField("PromissoryNotePoint", byXPath("//span[. = 'A. PROMISE TO PAY.']"));
	Button Cancel = new Button("Cancel", byXPath("//button[@id='cancelPromissoryNoteLetterPrint']"));
	
	waitForPageToLoad();
	StudentAccountsSpan.click();
	wait(2);
	scrollPage(0, 200);
	PaymentScheduleSpan.click();
	waitForPageToLoad();
	FundSourceType.click();
	waitForPageToLoad();
	wait(15);
	PromissoryNote.click();
	waitForPageToLoad();
	wait(5);
	//CustomAsserts.containsString(StudentName.getText(), data.get("StudentName").toString());	
	//CustomAsserts.containsString(PromissoryNotePoint.getText(), "A. PROMISE TO PAY.".toString());
	scrollPage(0, 300);
	Cancel.click();
	return this;

}

public StudentMainPage EditAwardInformation(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	
	Link FinancialAidSpan = new Link("FinancialAidSpan", byXPath("//li[5]/span"));
	Link AwardingSpan = new Link("AwardingSpan", byXPath("//span[. = 'Awarding']"));
	Button Awards = new Button("Awards", byXPath("//button[. = 'Awards']"));
	//TextField AwardYearTableCell = new TextField("AwardYear", byXPath("//td[. = '"+data.get("BeginningAwardYear")+"']"));
	//TextField COATableCell = new TextField("COA", byXPath("//td[. = '"+data.get("COAValue")+"']"));
	Link New = new Link("New", byXPath("//a[5][. = 'New']"));
	Link AcademicYears = new Link("AcademicYears", byXPath("//button[. = 'Academic Years']"));
	Button ManualEntry = new Button("ManualEntry", byCSSSelector("#autoAwardingYearDialogNotOkButton"));
	TextField StartDate = new TextField("StartDate", byCSSSelector("[name='startDate']"));
	TextField EndDate = new TextField("EndDate", byCSSSelector("[name='endDate']"));
	Button AwardYear1Span = new Button("AwardYear1Span", byXPath("//div[2]/cmc-drop-down-list-classic[1]/div/div/span/span/span[. = ' ']"));
	TextField AwardYear1 = new TextField("AwardYear1", byXPath("//div[63]//input"));
	Link AwardYear1DropDown = new Link("AwardYear1DropDown", byXPath("//div/div/div//li[. = '"+data.get("AwardYear1")+"']"));
	Button GradeLevelSpan = new Button("GradeLevelSpan", byXPath("//cmc-drop-down-list-classic[3]/div/div/span//span[2]"));
	Link GradeLevelDropDown = new Link("GradeLevelDropDown", byXPath("//span[. = '"+data.get("GradeLevel")+"']"));
	Button HousingSpan = new Button("HousingSpan", byXPath("//div[3]/cmc-drop-down-list-classic/div/div/span/span/span/span"));
	Link HousingDropDown = new Link("HousingDropDown", byXPath("//span[. = '"+data.get("Housing")+"']"));
	Button AwardYear1PackagingStatus = new Button("AwardYear1PackagingStatus", byXPath("//div[9]/cmc-drop-down-list-classic[1]/div/div/span//span[2]"));
	Link AwardYear1PackagingStatusDropDown = new Link("AwardYear1PackagingStatusDropDown", byXPath("//div/div/div//span[. = '"+data.get("AwardYear1PackagingStatus")+"']"));
	Button BudgetDefinitionSpan = new Button("BudgetDefinitionSpan", byXPath("//div/div[1]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Link BudgetDefinitionDropDown = new Link("BudgetDefinitionDropDown", byXPath("//span[. = '"+data.get("BudgetDefinition")+"']"));
	Button Calculate = new Button("Calculate", byXPath("//button[. = 'Calculate']"));
	Button Save = new Button("Save", byXPath("(//button[@aria-label='Save'])[2]"));
	Button Proceed = new Button("Proceed", byCSSSelector("#weeksEnrolledInAcademicYearDialogOkButton"));
	Link AcademicYearSuccessMessage = new Link("AcademicYearSuccessMessage", byXPath("//span[. = 'The Student Academic Year records were successfully saved.']"));
	Button PackagingMethodSpan = new Button("PackagingMethodSpan", byXPath("//cmc-drop-down-list-classic[2]/div/div/span//span[2]"));
	Link PackagingMethodDropDown = new Link("PackagingMethodDropDown", byXPath("//span[. = '"+data.get("PackagingMethod")+"']"));
	//Button New = new Button("New", byXPath("//a[5][. = 'New']"));
	Button TypeOfAidSpan = new Button("TypeOfAidSpan", byXPath("//section/div[3]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Link TypeOfAidDropDown = new Link("TypeOfAidDropDown", byXPath("//li[. = '"+data.get("TypeOfAid")+"']"));
	Button SourceSpan = new Button("SourceSpan", byXPath("//div[4]/cmc-drop-down-list-classic/div/div/span/span/span/span"));
	Link SourceDropDown = new Link("SourceDropDown", byXPath("//span[. = '"+data.get("Source")+"']"));
	Button GrossAmountSpan = new Button("GrossAmountSpan", byXPath("//div[5]/cmc-numeric-input-text/div/div/span/span"));
	TextField GrossAmount = new TextField("GrossAmount", byCSSSelector("[name='grossAmount']"));
	Button StatusSpan = new Button("StatusSpan", byXPath("//div[5]/cmc-drop-down-list-classic/div/div/span/span/span/span"));
	Link StatusDropDown = new Link("StatusDropDown", byXPath("//li[. = 'Approved']"));
	Button Proceed1 = new Button("Proceed1", byXPath("//button[. = 'Proceed']"));
	Button SaveAndClose = new Button("SaveAndClose", byXPath("//div[2]/cmc-toolbar/section/cmc-toolbar-button-save-close//button"));
	Link FundSourceValue = new Link("FundSourceValue", byXPath("//a[. = '"+data.get("Source")+"']"));
	TextField AmountPackagedSpan = new TextField("AmountPackagedSpan", byXPath("//div[1]/cmc-numeric-input-text/div/div/span/span"));
	TextField AmountPackaged = new TextField("AmountPackaged", byCSSSelector("[name='amount']"));
	Button Recalculate = new Button("Recalculate", byXPath("//button[@id='studentGrantDialogOkButton']"));
	Link StudentRecordsGrantSuccessMessage = new Link("StudentRecordsGrantSuccessMessage", byXPath("//span[. = 'The Student Grant records were successfully saved.']"));	
	Button SaveBudgetCalculation = new Button("SaveBudgetCalculation", byXPath("(//button[@class='cmc-toolbar-button ng-binding'])[8]"));	
	Button AcademicYearSpan = new Button("AcademicYearSpan", byXPath("//div[1]/cmc-drop-down-list-classic[1]/div/div/span//span[2]"));
	Link AcademicYearValue = new Link("AcademicYearValue", byXPath("//span[. = '"+data.get("StartDate")+"']"));
	
	
		
	waitForPageToLoad();
	FinancialAidSpan.click();
	wait(2);
	AwardingSpan.click();
	waitForPageToLoad();
	AcademicYears.click();
	waitForPageToLoad();
	wait(12);
	scrollPage(0, -100);
	New.click();
	wait(2);
	if(ManualEntry.isDisplayed())
    {
		ManualEntry.click();
    }
	waitForPageToLoad();
	scrollPage(0, 400);
	StartDate.click();
	wait(2);
	StartDate.clearAndType(data.get("StartDate").toString());
	wait(2);
	EndDate.click();
	EndDate.clearAndType(data.get("EndDate").toString());
	wait(2);
	AwardYear1Span.click();
	wait(2);
	AwardYear1.click();
	wait(1);
	AwardYear1.clearAndType(data.get("AwardYear1").toString());
	wait(1);
	AwardYear1DropDown.click();
	wait(2);
	GradeLevelSpan.click();
	wait(2);
	GradeLevelDropDown.click();
	wait(2);
	HousingSpan.click();
	wait(2);
	HousingDropDown.click();
	wait(2);
	scrollPage(0, 400);
	AwardYear1PackagingStatus.click();
	wait(2);
	AwardYear1PackagingStatusDropDown.click();
	wait(2);
	scrollPage(0, 500);
	BudgetDefinitionSpan.click();
	wait(2);
	BudgetDefinitionDropDown.click();
	wait(5);
	Calculate.click();
	wait(7);
	SaveBudgetCalculation.click();
	wait(2);
	if(Proceed.isDisplayed())
    {
		Proceed.click();
    }
	waitForPageToLoad();
	//CustomAsserts.containsString(AcademicYearSuccessMessage.getText(), "The Student Academic Year records were successfully saved.".toString());
	Awards.click();
	waitForPageToLoad();
	AcademicYearSpan.click();
	wait(2);
	AcademicYearValue.click();
	wait(6);
	PackagingMethodSpan.click();
	wait(2);
	PackagingMethodDropDown.click();
	wait(6);
	New.click();
	wait(5);
	TypeOfAidSpan.click();
	wait(2);
	TypeOfAidDropDown.click();
	wait(2);
	SourceSpan.click();
	wait(2);
	SourceDropDown.click();
	wait(5);
	GrossAmountSpan.click();
	wait(2);
	GrossAmount.type(data.get("GrossAmount").toString());
	wait(2);
	StatusSpan.click();
	wait(2);
	StatusDropDown.click();
	wait(2);
	Proceed1.click();
	waitForPageToLoad();
	SaveAndClose.click();
	waitForPageToLoad();
	FundSourceValue.click();
	waitForPageToLoad();
	scrollPage(0, -100);
	AmountPackagedSpan.click();
	wait(2);
	AmountPackaged.type(data.get("GrossAmountUpdated").toString());
	wait(2);
	SaveAndClose.click();
	waitForPageToLoad();
	Recalculate.click();
	wait(10);	
	CustomAsserts.containsString(StudentRecordsGrantSuccessMessage.getText(), "The Student Grant records were successfully saved.".toString());
	return this;
}


public StudentMainPage VerifyAwardUpdate(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));	
	Link FinancialAidSpan = new Link("FinancialAidSpan", byXPath("//li[5]/span"));	
	Link Audit = new Link("Audit", byXPath("//li[5]/div/div[9]/div"));
	Link ModifiedByCellValue = new Link("ModifiedByCellValue", byXPath("//tr[1]/td[. = '"+data.get("ModifiedBy")+"']"));
	Link NoteCellValue = new Link("NoteCellValue", byXPath("//tr[1]/td[. = '"+data.get("Note")+"']"));
	Link FieldCellValue = new Link("FieldCellValue", byXPath("//tr[1]/td[. = '"+data.get("Field")+"']"));
	
	
	waitForPageToLoad();
	FinancialAidSpan.click();
	wait(2);
	scrollPage(0, -100);
	Audit.click();
	waitForPageToLoad();
	CustomAsserts.containsString(ModifiedByCellValue.getText(), data.get("ModifiedBy").toString());
	CustomAsserts.containsString(NoteCellValue.getText(), data.get("Note").toString());
	CustomAsserts.containsString(FieldCellValue.getText(), data.get("Field").toString());
	return this;
}

public StudentMainPage Confsch(StringHash data) throws Exception{
	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	
	//Login Page Web Elements
	waitForPageToLoad();
	wait(15);
	FilterDropDwon.click();
	wait(2);
	ClearFiltersButton.click();
	waitForPageToLoad();
	wait(15);
	StuNumDropDown.click();
	//waitForPageToLoad();
	wait(2);
	StuNumFilter.click();
	//waitForPageToLoad();
	wait(2);
	value.clearAndType(data.get("Student Number"));
	//waitForPageToLoad();
	wait(2);
	FilterButton.click();
	//waitForPageToLoad();
	wait(10);
	ClickStudentName.click();
	//waitForPageToLoad();
	wait(5);
	AcademicRecords.click();
	wait(3);
	SchoolFields.click();
	wait(5);
	scrollPage(0, -200);
	wait(2);
	Sexbirth.click();
	wait(2);
	SelSexbirth.click();
	wait(2);
	/*Pronouns.click();
	wait(2);
	SelPronouns.click();
	wait(2);
	FirstGenarationStudent.click();
	wait(2);
	SelFirstGenarationStudent.click();
	wait(2);
	OrigonResident.click();
	wait(2);
	SelOrigonResident.click();
	wait(2);
	GenderIdentity.click();
	wait(2);
	SelGenderIdentity.click();
	wait(2);
	Tribe.click();
	wait(2);
	SelTribe.click();
	wait(2);
	ImmunaizationConfirmation.click();
	wait(2);
	SelImmunaizationConfirmation.click();
	wait(2);
	ELL.click();
	wait(2);
	SelELL.click();
	wait(2);
	DisebillityRequest.click();
	wait(2);
	SelDisebillityRequest.click();
	wait(2);
	VeternFamilyDependent.click();
	wait(2);
	SelVeternFamilyDependent.click();
	wait(2);
	scrollPage(0, 200);
	VeteneryTypePreferance.click();
	wait(2);
	SelVeteneryTypePreferance.click();
	wait(2);
	scrollPage(0, -300);
	wait(2);*/
	Save.click();	
	waitForPageToLoad();
	wait(2);
	return this;
   }


public StudentMainPage BatchOfStudentRegestrationTrack(StringHash data) throws Exception{

	//X-path Parameterization
		Link SelectSG = new Link("Select Student Group", byXPath("//ul/li[text()='"+data.get("Student Group Name")+"']"));
		Link BatchRegTrackSaveMessage = new Link("BatchRegTrackSaveMessage", byXPath("//span[. = 'The Track Registration records were successfully queued.']"));

	//Method Implementation
		waitForPageToLoad();
		wait(10);
		SearchProcesses.clearAndType(data.get("Search Name").toString());
		wait(3);
		Registration.click();
		wait(5);
		Track.click();
		wait(3);
		StudentGroup.clearAndType(data.get("Student Group Name").toString());
		wait(2);
		SelectSG.clickUsingJavaScriptExecutor();
		wait(5);
		SelectTrack.clickUsingJavaScriptExecutor();
		wait(3);
		Next1.clickUsingJavaScriptExecutor();
		wait(3);
		Checkall.clickUsingJavaScriptExecutor();
		wait(2);
		scrollPage(0, 200);
		Queureg.clickUsingJavaScriptExecutor();
		wait(2);
		Queue.clickUsingJavaScriptExecutor();
		wait(5);
		CustomAsserts.containsString(BatchRegTrackSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
	   }

public StudentMainPage BatchOfStudentUnRegestrationTrack(StringHash data) throws Exception{

	//X-path Parameterization
		Checkbox SelectTerm = new Checkbox("Select Term", byXPath("//input[@aria-label='"+data.get("Term Name")+"']"));
		Link SelInstructor = new Link("Click on selctIns", byXPath("//span[@title='"+data.get("Instructor Name")+"']"));
		Link BatchStudentUnRegSaveMessage = new Link("BatchStudentUnRegSaveMessage", byXPath("//span[. = 'The Unregister records were successfully queued.']"));

	//Method Implementation
		waitForPageToLoad();
		wait(10);
		SearchProcesses.clearAndType(data.get("Search Name").toString());
		wait(2);
		Registration.click();
		wait(5);
		Unregister.click();
		wait(3);
		Term1.click();
		wait(3);
		SearchTerm.clearAndType(data.get("Term Name").toString());
		wait(2);
		SelectTerm.click();
		wait(3);
		Select1.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(2);
		Instructor.clearAndType(data.get("Instructor Name").toString());
		wait(5);
		SelInstructor.clickUsingJavaScriptExecutor();
		wait(1);
		Next2.clickUsingJavaScriptExecutor();
		wait(2);
		allstd.clickUsingJavaScriptExecutor();
		allstd.clickUsingJavaScriptExecutor();
		wait(2);
		scrollPage(0, 300);
		wait(2);
		Reason.clearAndType(data.get("Reason Name").toString());
		wait(3);
		SelReas.clickUsingJavaScriptExecutor();
		wait(1);
		Queureg2.clickUsingJavaScriptExecutor();
		wait(2);
		Queue.clickUsingJavaScriptExecutor();
		wait(5);
		CustomAsserts.containsString(BatchStudentUnRegSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
	   }

public StudentMainPage ConfirmInformationSchoolFields(StringHash data) throws Exception{

	//X-path Parameterization
		Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Link SelSexbirth = new Link("Click on SelSexbirth", byXPath("//li[text()='Male']"));
		Link ConfirmInfoSchoolFieldSaveMessage = new Link("ConfirmInfoSchoolFieldSaveMessage", byXPath("//span[. = 'The Student records were successfully saved.']"));

	//Method Implementation
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
		wait(5);
		ClickStudentName.click();
		wait(5);
		AcademicRecords.click();
		wait(3);
		SchoolFields.click();
		wait(5);
		scrollPage(0, -200);
		wait(2);
		Sexbirth.click();
		wait(2);
		SelSexbirth.click();
		wait(2);
		/*Pronouns.click();
		wait(2);
		SelPronouns.click();
		wait(2);
		FirstGenarationStudent.click();
		wait(2);
		SelFirstGenarationStudent.click();
		wait(2);
		OrigonResident.click();
		wait(2);
		SelOrigonResident.click();
		wait(2);
		GenderIdentity.click();
		wait(2);
		SelGenderIdentity.click();
		wait(2);
		Tribe.click();
		wait(2);
		SelTribe.click();
		wait(2);
		ImmunaizationConfirmation.click();
		wait(2);
		SelImmunaizationConfirmation.click();
		wait(2);
		ELL.click();
		wait(2);
		SelELL.click();
		wait(2);
		DisebillityRequest.click();
		wait(2);
		SelDisebillityRequest.click();
		wait(2);
		VeternFamilyDependent.click();
		wait(2);
		SelVeternFamilyDependent.click();
		wait(2);
		scrollPage(0, 200);
		VeteneryTypePreferance.click();
		wait(2);
		SelVeteneryTypePreferance.click();
		wait(2);
		scrollPage(0, -300);
		wait(2);*/
		Save.click();	
		wait(5);
		CustomAsserts.containsString(ConfirmInfoSchoolFieldSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
	   }

 
public StudentMainPage ProgrameTransferToStudent(StringHash data) throws Exception{
	
	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	Link EnrollmentSpan = new Link("EnrollmentSpan", byXPath("//li[3]/div/div[1]/div"));
    Link SelTransferType = new Link("SelTransferType", byXPath("//li[text()='To Enrollment']"));
	Link TransStudentSaveMessage = new Link("TransStudentSaveMessage", byXPath("//span[. = 'The Transfer Enrollment records were successfully saved.']"));
	Link SelPrgver = new Link("SelPrgver", byXPath("//span[text()='"+data.get("Enter Programe Ver")+"']"));
	
	waitForPageToLoad();
	wait(10);
	FilterDropDwon.click();
	wait(2);
	ClearFiltersButton.click();
	wait(10);
	StuNumDropDown.click();
	wait(2);
	StuNumFilter.click();
	wait(2);
	value.clearAndType(data.get("Student Number"));
	wait(2);
	FilterButton.click();
	wait(5);
	ClickStudentName.click();
	waitForPageToLoad();
	wait(5);
	AcademicRecords.click();
	wait(2);
	EnrollmentSpan.click();
	wait(3);
	ClsFilterDropDwon.click();
	wait(2);
	ClsClearFiltersButton.click();
	wait(5);
	TermDropDown.click();
	wait(2);
	TerNumFilter.click();
	wait(2);
	value.clearAndType(data.get("Program Version"));
	wait(2);
	FilterButton.click();
	wait(5);
	SelectPrograme.click();
	wait(5);
	More.click();
	wait(3);
	Transfer.click();
	wait(3);
	TransferType.click();
	wait(3);
	SelTransferType.click();
	wait(3);
	ProgrameVersion.click();
	wait(5);
	EnterProgrameVersion.clearAndType(data.get("Enter Programe Ver").toString());
	wait(3);
	SelPrgver.click();
	wait(3);
	Proceed.click();
	wait(3);
	Next3.click();
	wait(3);
	Next4.click();
	wait(3);
	Next5.click();
	wait(3);
	Transfer2.click();
	wait(3);
	Transfer3.click();
	wait(3);
	CustomAsserts.containsString(TransStudentSaveMessage.getText(), data.get("SuccessMessage").toString());
	wait(2);
	return this;

}

}

 

