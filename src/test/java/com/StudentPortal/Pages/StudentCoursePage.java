package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byCSSSelector;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import org.openqa.selenium.By;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class StudentCoursePage extends BasePage{ 
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
	static Link AcademicRecords = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[3]/span"));
	static Link StudentCourse = new Link("Click on Student Course", byXPath("//span[. = 'Student Courses']"));
	static Link add = new Link("Click add", byXPath("//a[@id=\"addCourseButton\"]"));
	static Link ClickCourse = new Link("Click on Course", byXPath("//div[@aria-label='Course']"));
    static TextField Course = new TextField("Enter Course", byXPath("//input[@placeholder = 'Search Code or Name']"));
	static Link SelCourse = new Link("select Course", byXPath("(//td[1]/input)[1]"));
	static Button Select = new Button("Select Button", byXPath("//button[text()='Select']"));
	static Link ClickTerm = new Link("Click on Term", byXPath("//div[@aria-label=\"Term\"]"));
    static TextField Term = new TextField("Enter Term", byXPath("//input[@placeholder = 'Search Name']"));
	static Link SelTerm = new Link("select Term", byXPath("//input[@aria-label='2020 Fall']"));
	static Button SaveandRegister = new Button("Click on SaveandReg", byXPath("//button[@aria-label=\"Save & Register\"]"));
	static Button addcoursewithoutCatogery = new Button("Click on addcoursewithoutCatogery", byXPath("//button[@id=\"courseTakenNotAppliedDialogOkButton\"]"));
	static TextField ConfirmTerm = new TextField("Click on ConfirmTerm", byXPath("//input[@name=\"termId_input\"]"));
	static Link SelConfirmTerm = new Link("Click on SelConfirmTerm", byXPath("//span[@title='201011-3P']"));
	static Button Next = new Button("Click on Next", byXPath("//div/button[. = 'Next']"));
	static Link Selcls = new Link("Click on Selcls", byXPath("//div/div[1]/div/cns-grid//td[4]"));
	static Button Register = new Button("Click on Reg", byXPath("(//a[@id=\"registerSaveButton\"])[2]"));
	static Link SelRegister = new Link("Click on SelReg", byXPath("//button[@id=\"schedueCourseDialogOkButton\"]"));
	static Button ClsFilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class='k-button k-split-button-arrow'])[1]"));
	static Link ClsClearFiltersButton = new Link("Click Filter Button", byXPath("//div//a[. = 'Clear Filters']"));
	static Link ClsClearFiltersButton1 = new Link("Click Filter Button", byXPath("//div//a[. = 'Clear Filters']"));
	static Link TermDropDown = new Link("Click Term Number Dropdown", byXPath("(//th[3]//span)[1]"));
    static Button TerNumFilter = new Button("Click Term Num Filter", byXPath("//span[.='Filter']"));
    static TextField value1 = new TextField("Enter Value", byXPath("//input[@title='Value']"));
    static Button FilterButton1 = new Button("Click Filter Button", byXPath("//button[text()='Filter']"));
    static Checkbox SelectallCheckbox = new Checkbox("Click SelectallCheckbox", byXPath("//th/input"));
    static Link Unregister = new Link("Click on Unregister", byXPath("//a[7][. = 'Unregister']"));
    static Link Clickreasonspan = new Link("Click on Clickreasonspan", byXPath("//ng-transclude/div[2]/cmc-drop-down-list-classic/div/div/span/span/span/span"));
    static TextField ReasonName = new TextField("Enter Reason Value", byXPath("//div[@id='reason-list']/span/input"));
    static Link SelReasonName = new Link("Click on SelReasonName", byXPath("(//li[. = 'Non Attendance'])[1]"));
    static Link Unregister1 = new Link("Click on Unregister1", byXPath("(//button[@id='okUnRegister'])[3]"));
    static Link ClickCourse2 = new Link("Click on Course", byXPath("//span[text()='BI231']"));
    static Button Attendance = new Button("Click on Attendance", byXPath("//button[. = 'Attendance']"));
    static Link CourseCodeDropDown = new Link("Click Term Number CourseCodeDropDown", byXPath("//th[1]//span"));
    static Link SelectAttendance = new Link("Click SelectAttendance", byXPath("(//tr[1]/td[3])[2]"));
    static Button PostRecord = new Button("Click PostRecord", byXPath("//a[6][. = 'Post Makeup Time']"));
	//static TextField Course = new TextField("Click on course input box", byCSSSelector("[name='courseId_input']"));
    static TextField Date = new TextField("Enter Date", byXPath("(//input[@placeholder='MM/DD/YYYY'])[3]"));
    static TextField Hours = new TextField("Enter Hours", byXPath("(//input[@aria-label='Hours'])[6]"));
	static Button Save = new Button("Click on Save", byXPath("(//button[text()='Save'])[7]"));
    static Link SelectHourse = new Link("Click SelectHourse", byXPath("(//div[@id='postMakeupHrDialog']/ng-transclude/div/div[3]/div/div/ng-transclude/div/div[2]/cmc-numeric-input-text/div/div/span/span/span[2]/span/span)[1]"));

    public StudentCoursePage RecordMakeupHourForStudent(StringHash data) throws Exception{

    	//X-path Parameterization
    	    	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
    	    	Link RecordmakeupStdSaveMessage = new Link("RecordmakeupStdSaveMessage", byXPath("//span[. = 'The Attendance records were successfully saved.']"));
    	    	Link ClickCourse2 = new Link("Click on Course", byXPath("//span[text()='"+data.get("Course")+"']"));
    	    	Link SelectAttendance = new Link("Click SelectAttendance", byXPath("(//span[text()='"+data.get("Record")+"'])[1]"));
    	//Method Implementation
    	    	waitForPageToLoad();
    	   		wait(10);
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
    	    	ClickStudentName.click();
    	    	waitForPageToLoad();
    	    	wait(2);
    	    	AcademicRecords.click();
    	    	wait(3);
    	    	StudentCourse.clickUsingJavaScriptExecutor();
    	    	wait(5);
    	    	ClsFilterDropDwon.click();
    	    	wait(2);
    	    	ClsClearFiltersButton.click();
    	    	wait(15);
    	    	TermDropDown.click();
    	    	wait(2);
    	    	TerNumFilter.click();
    	    	wait(2);
    	    	value.clearAndType(data.get("Course"));
    	    	wait(2);
    	    	FilterButton.click();
    	    	wait(5);
    	    	SelectallCheckbox.click();
    	    	wait(5);
    	    	ClickCourse2.click();
    	    	wait(7);
    	    	scrollPage(0, -200);
    	    	wait(2);
    	    	Attendance.clickUsingJavaScriptExecutor();
    	    	wait(3);
    	    	scrollPage(0, 500);
    	    	wait(2);
    	    	SelectAttendance.click();
    	    	wait(2);
    	    	PostRecord.click();
    	    	wait(2);
    	    	Date.clearAndType(data.get("Date").toString());
    	    	wait(3);
    	    	Hours.sendKeys(data.get("Hours"));
    	    	wait(5);
    	    	Save.click();
    	    	wait(7);
    	    	CustomAsserts.containsString(RecordmakeupStdSaveMessage.getText(), data.get("SuccessMessage").toString());
    	    	wait(2);
    	    	return this;
    	    	    }
	
    public StudentCoursePage AddStudentCourse(StringHash data) throws Exception{
    	
    	//X-path Parameterization
    			Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
    			Link SelCourse = new Link("select Course", byXPath("(//input[@aria-label='"+data.get("Course")+"'])[1]"));
    			Checkbox SelTerm = new Checkbox("select Term", byXPath("//input[@aria-label='"+data.get("Term")+"']"));
    			Link SelConfirmTerm = new Link("Click on SelConfirmTerm", byXPath("//span[@title='"+data.get("Confirm Term")+"']"));
    			Link StdCourSaveMessage = new Link("StdCourSaveMessage", byXPath("//span[. = 'The Student Course records were successfully registered.']"));
    			Link Register1 = new Link("Click on SelReg", byXPath("//button[@id='schedueCourseDialogOkButton']"));
    			Link AddCourse = new Link("Click on AddCourse", byXPath("//button[@id='schedueCourseDialogOkButton']"));

    	//Method Implementation
    			waitForPageToLoad();
    			wait(10);
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
    			wait(10);
    			ClickStudentName.click();
    			wait(5);
    			AcademicRecords.clickUsingJavaScriptExecutor();
    			wait(2);
    			StudentCourse.clickUsingJavaScriptExecutor();
    			wait(5);
    			add.click();
    			wait(2);
    			ClickCourse.clickUsingJavaScriptExecutor();
    			wait(2);
    			Course.clearAndType(data.get("Course").toString());
    			wait(2);
    			SelCourse.clickUsingJavaScriptExecutor();
    			wait(2);
    			Select.clickUsingJavaScriptExecutor();
    			wait(2);
    			ClickTerm.clickUsingJavaScriptExecutor();
    			wait(2);
    			Term.clearAndType(data.get("Term").toString());
    			wait(2);
    			SelTerm.clickUsingJavaScriptExecutor();
    			wait(2);
    			Select.clickUsingJavaScriptExecutor();
    			wait(2);
    			SaveandRegister.clickUsingJavaScriptExecutor();
    			wait(2);
    			addcoursewithoutCatogery.clickUsingJavaScriptExecutor();
    			wait(7);
    			/*if(AddCourse.isDisplayed()) {
    				AddCourse.click();
    				wait(5);
    			}*/
    			scrollPage(0, 300);
    			wait(7);
    			ConfirmTerm.clearAndType(data.get("Confirm Term").toString());
    			wait(2);
    			SelConfirmTerm.clickUsingJavaScriptExecutor();
    			wait(2);
    			Next.clickUsingJavaScriptExecutor();
    			wait(2);
    			Selcls.clickUsingJavaScriptExecutor();
    			wait(2);
    			scrollPage(0, 300);
    			Register.clickUsingJavaScriptExecutor();
    			wait(2);
    			SelRegister.clickUsingJavaScriptExecutor();
    			/*if(Register1.isDisplayed()) {
    				Register1.click();
    				wait(5);
    			}*/
    			wait(3);
    			CustomAsserts.containsString(StdCourSaveMessage.getText(), data.get("SuccessMessage").toString());
    			wait(2);
    			return this;
    	    }    
	
    public StudentCoursePage CourseUnRegistrationForStudent(StringHash data) throws Exception{
    	
    	//X-path Parameterization
    			Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
    			Link CourseUnRegSaveMessage = new Link("CourseUnRegSaveMessage", byXPath("//span[. = 'The Student Course records were successfully unregistered.']"));

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
    			wait(10);
    			ClickStudentName.click();
    			waitForPageToLoad();
    			wait(5);
    			AcademicRecords.clickUsingJavaScriptExecutor();
    			wait(2);
    			StudentCourse.clickUsingJavaScriptExecutor();
    			wait(5);
    			ClsFilterDropDwon.click();
    			wait(2);
    			ClsClearFiltersButton.click();
    			wait(15);
    			TermDropDown.click();
    			wait(2);
    			TerNumFilter.click();
    			wait(2);
    			value.clearAndType(data.get("Course"));
    			wait(2);
    			FilterButton.click();
    			wait(5);
    			SelectallCheckbox.click();
    			wait(2);
    			Unregister.click();
    			wait(5);
    			Clickreasonspan.click();
    			wait(2);
    			ReasonName.clearAndType(data.get("Reason").toString());
    			wait(2);
    			SelReasonName.click();
    			wait(2);
    			Unregister1.click();
    			wait(3);
    			CustomAsserts.containsString(CourseUnRegSaveMessage.getText(), data.get("SuccessMessage").toString());
    			wait(2);
    			return this;
    	    }
}