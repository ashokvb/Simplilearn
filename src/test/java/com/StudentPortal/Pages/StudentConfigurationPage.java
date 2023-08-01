package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;


import static com.framework.elements.Locator.byCSSSelector;



import static com.framework.elements.Locator.byCSSSelector;


import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.base.BasePage;
import com.framework.elements.Button;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
import com.framework.elements.AngDropDown;
import com.framework.elements.Checkbox;


import com.framework.elements.CustomAsserts;




import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class StudentConfigurationPage extends BasePage{ 
	//Login Page Web Elements	
	static String TaskTempNameValue = AppendValue.apendString();
	static String TaskTempCodeValue = AppendValue.apendString();
	static String TaskSchNameValue = AppendValue.apendString();
	static String DocNameValue = AppendValue.apendString();
	static String DocCodeValue = AppendValue.apendString();
	static String DocSchNameValue = AppendValue.apendString();
	static String RstName = AppendValue.apendString();
	static String RstCode = AppendValue.apendString();
	static String SMSNameValue = AppendValue.apendString();
	static String SMSCodeValue = AppendValue.apendString();	
	static String EmployerNameValue = AppendValue.apendString();
	static String EmailAddressValue = AppendValue.apendString();	
	static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Configuration = new Link("Configuration tile", byXPath("//a[text()='Configuration']"));
	static TextField SearchConfiguration = new TextField("Search Configuration", byXPath("//input[@placeholder='Search Configuration']"));
	static Link ResidencyTypes = new Link("Residency Types", byXPath("//span[text()='Residency Types']"));
	static Button NewButton = new Button("New Residency Types ", byXPath("//a[@id='newButton']"));
	static TextField Name = new TextField("Residency Type Name", byXPath("//input[@id='name']"));
	static TextField Code = new TextField("Residency Type Code", byXPath("//input[@id='code']"));
	static Link TaskTemplates = new Link("Tak Templates", byXPath("//span[text()='Task Templates']"));																						
	static TextField EventType = new TextField("EventType", byXPath("//input[@name='taskTypeId_input']"));
	static Link SelectingEventType = new Link("Selecting Event Type", byXPath("//span[. = 'Meeting']"));																								  
	static Button SaveAndClose = new Button("Save and Close", byXPath("//button[@aria-label= 'Save & Close']"));
	static Link TaskSchedules = new Link("Task schedules", byXPath("//span[text()='Task Schedules']"));
	static TextField ScheduleTaskFor = new TextField("Schedule Task For", byXPath("//input[@name='basisForTask_input']"));
	static Link SelectingScheduleFor = new Link("Selecting schedule for", byXPath("//span[. = 'Prospective Student']"));
	//static TextField DocumentsList = new TextField("Document list", byXPath("//div[@aria-label='Documents']"));
	//static Link SelectingDocumentList = new Link("Selecting document list", byXPath("//li[. = 'Medical Certificate']"));
	static TextField TriggerWhen = new TextField("Trigger When", byXPath("//input[@name='triggerWhen_input']"));
	static Link SelectingTriggerWhen= new Link("Selecting trigger when", byXPath("//span[. = 'Lead Type']"));
	static TextField TriggerChangesTo = new TextField("Trigger changes to", byXPath("//div[@id='search_display_triggerChnagesTo']"));
	static Link SelectingChangesTo= new Link("Selecting Changes To", byXPath("//span[. = 'Lead Type']"));
	static TextField SearchName = new TextField("Search Name", byXPath("//input[@placeholder='Search Name']"));
	static Checkbox ChangestoName = new Checkbox("Selecting changes to status", byXPath("//input[@aria-label='CRM']"));
	static Button SelectButton = new Button("Select button", byXPath("//button[text()='Select']"));
	static TextField TaskEventType = new TextField("Task EventType", byXPath("//input[@name='taskType_input']"));
	static Link SelectingType= new Link("Selecting EventType", byXPath("//span[. = 'Other']"));
	static TextField TaskTemplate = new TextField("Task Template", byXPath("//input[@name='taskTemplate_input']"));
	static Link SelectingTaskTemplate= new Link("Selecting TaskTemplate", byXPath("//div/div/div//span[. = 'Duplicate Lead']"));
	static Link AssignTo= new Link("Assign To", byXPath("//span[text()='Assign To']"));
	static TextField AssignedTo = new TextField("Assigned To", byXPath("//input[@name='taskAssignTo_input']"));
	static Link SelectingAssignedTo= new Link("Selecting AssignedTo", byXPath("//span[. = 'Student']"));
	static Link Units = new Link("Units", byXPath("//span/span/span[. = ' ']"));
	static Link SelectingUnits= new Link("Selecting Units", byXPath("//li[. = 'Days']"));
	static TextField Event = new TextField("Event", byXPath("//input[@name='whenTime_input']"));
	static Link SelectingEvent= new Link("Selecting Event", byXPath("//span[. = 'Event Occurred']"));
	static Link Documents = new Link("Documents", byXPath("//span[text()='Documents']"));
	static TextField Module = new TextField("Module", byXPath("//input[@name='moduleId_input']"));
	static Link SelectingModule = new Link("Selecting Module", byXPath("//li[text()='Career Services']"));
	static TextField DocumentType = new TextField("DocumentType", byXPath("//input[@name='directionType_input']"));
	static Link SelectingDocumentType = new Link("Selecting Module", byXPath("//li[text()='FERPA']"));
	static TextField Campuses = new TextField("Campuses", byXPath("//div[@aria-label='Campuses']"));
	static TextField CampusesGroup = new TextField("Campuses DCRC", byXPath("//div[@aria-label='Campus Group']"));
	static Checkbox SelectingCampus = new Checkbox("Selecting campus", byXPath("//input[@aria-label='DTS']"));
	static Link DocumentSchedules = new Link("Document schedules", byXPath("//span[text()='Document Schedules']"));
	static Link ScheduleCriteria = new Link("Schedule Criteria", byXPath("//a[contains(text(),'Schedule Criteria')]"));
	static TextField SearchCriteria = new TextField("Search Criteria", byXPath("//input[@id='schedDocSchedCriteriaItem-filter']"));
	static Link SelectingSearchCriteria = new Link("Selecting Search Criteria", byXPath("//span[. = 'Dependency Status']"));
	static Link Arrowmark = new Link("Arrow mark", byXPath("//span/i[2]"));
	static TextField Value = new TextField("Value", byXPath("//div[@id='search_display_MODEL']"));
	static Checkbox DependentStatus = new Checkbox("Dependent status", byXPath("//input[@aria-label='Dependent']"));
	static Link DocumentCriteria = new Link("Document Criteria", byXPath("//div/a[contains(text(),'Documents')]"));
	static Link AddDocument= new Link("Add document", byXPath("//a[text()='Document']"));
	//static Link AddDocument= new Link("Add document", byXPath("(//a[@id='addDocumentButton']"));
	static Checkbox SelectingDocument = new Checkbox("Selecting document", byXPath("//input[@aria-label='Medical Certificate']"));
	static Button Filtericon = new Button("Filter icon", byXPath("//div[2]/a[2]"));
	static Button Filtericon1 = new Button("Filter icon", byXPath("(//div[2]/a[2])[2]"));
	static Link ClearFilters= new Link("Clear Filters", byXPath("//a[text()='Clear Filters']"));
	static Link ClearFilters1= new Link("Clear Filters", byXPath("(//a[@id=\"n.courseDetail.gridId_cnsToolbar_kendoToolBar_clearFiltersButton\"])[1]"));
	static AngDropDown Listdrpdwn= new AngDropDown("Task template dropdown", byXPath("(//th[2]/a/span)[1]"));
	static Button Filteroption= new Button("Filteroption", byXPath("//span[text()='Filter']"));
	static TextField FilterValue = new TextField("Filter Value",byXPath("//input[@title='Value']"));
	static Button Filterbutton = new Button("Filter icon", byXPath("//button[. = 'Filter']"));
	static Link Tablevalue= new Link("Table value", byXPath("//td/a"));
	static Link ClearFiltersFordocsch= new Link("Clear Filters for document schedule", byXPath("(//a[text()='Clear Filters'])[2]"));
	static Link Subsidiaries = new Link("Task schedules", byXPath("//span[text()='Subsidiaries']"));
	static Link TransactionCodes = new Link("Transaction codes", byXPath("//div[@id='search_display_transactionCode']"));
	static TextField SearchCode = new TextField("Search Code",byXPath("//input[@placeholder='Search Code']"));
	static Button SelectCode = new Button("Select code", byXPath("//div/button[text()='Select']"));
	static AngDropDown Namedrpdwn= new AngDropDown("Name dropdown", byXPath("(//th[1]/a/span)[1]"));	
	//static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Link StudentAccounts = new Link("Click on StudentAccounts", byXPath("//span[@class='k-link k-header k-state-selected']"));
	static Link ContactManager = new Link("Contact Manager", byXPath("//cns-panel-bar/ul/li[1]/span"));
	static Link Documents1 = new Link("Documents", byXPath("//span[text()='Documents']"));	
	static Link NewDocument = new Link("Click on NewDocuments", byXPath("//a[@id='studentDocumentsAddButton']"));
	static TextField Entermodule = new TextField("Click on ClickMadule", byXPath("//input[@name='studentDocModule_input']"));
	static Link SelectModule = new Link("select module", byXPath("(//span[text()='Admissions'])[1]"));
	static TextField EnterDocument = new TextField("Click on Document", byXPath("//input[@name=\"studentDocName_input\"]"));
	static Link SelectDocument = new Link("select module", byXPath("//span[@title='AATestOL']"));
	static Link SelectDocument1 = new Link("select module", byXPath("//span[@title='Admissions Document List']"));
	static TextField DocumentStatus = new TextField("Click on DocumentStatus", byXPath("//input[@name='studentDocStatus_input']"));
	static Link SelectDocumentStatus = new Link("select DocumentStatus", byXPath("//span[@title='CMC Sig Req']"));
	static Button SaveAndClose1 = new Button("Save and Close", byXPath("//a[@id='studentDocumentSaveAnCloseButton']"));
	static Link NewDocumentList = new Link("Click on NewDocumentsList", byXPath("(//a[@id=\"studentDocumentsAddButton\"])[2]"));	
	static Button SaveAndClose3 = new Button("Save and Close", byXPath("//a[@id='studentDocumentListSaveAnCloseButton']"));
	static TextField SearchContactManager = new TextField("Search SearchContactManager", byXPath("//input[@placeholder='Search Configuration']"));
	static Link TaskTemplets = new Link("TaskTemplets", byXPath("//div[@id='lists-treeview']/div[2]/ul/li/ul/li/div/span"));
	static Button NewButton1 = new Button("New Residency Types ", byXPath("//a[@id='newButton']"));
	static TextField Description = new TextField("Search Description", byXPath("//input[@name=\"name\"]"));
	static TextField Code1 = new TextField("Search Code", byXPath("//input[@name=\"code\"]"));
	static TextField Catogery = new TextField("Search Catogery", byXPath("//input[@name=\"taskCategoryId_input\"]"));
	static Link SelCatogery = new Link("Select SelCatogery", byXPath("//span[@title='Career Services']"));
	static TextField EventType1 = new TextField("Search EventType1", byXPath("//input[@name='taskTypeId_input']"));
	static TextField SelEventType1 = new TextField("Select SelEventType1", byXPath("//span[@title='E-Mail To Employer']"));
	static TextField EmailSubject = new TextField("Select EmailSubject", byXPath("//input[@name='emailSubject']"));
	static Button SaveAndClose2 = new Button("Save and Close", byXPath("//button[@aria-label=\"Save & Close\"]"));
	static Link Employeer = new Link("Employeer", byXPath("//div[@id='lists-treeview']/div[2]/ul/li/ul/li/div/span"));
	static AngDropDown TeDropDown = new AngDropDown("Click Term Number Dropdown", byXPath("(//span[@class='k-icon k-i-more-vertical'])[2]"));  
	static Button TerNumFilter = new Button("Click Term Num Filter", byXPath("//span[.='Filter']"));
    static TextField Cvalue = new TextField("Enter Value", byXPath("(//input[@title='Value'])[3]"));
    static Button CFilterButton = new Button("Click Filter Button", byXPath("//button[@type='submit']"));
    static Link ClkEmpName = new Link("Click ClkEmpName", byXPath("//a[text()='Bookstore']"));
    static Link Task = new Link("Click Task", byXPath("//div[@id='maincontent']/div/ui-view/cns-employer-detail/div/div/div[2]/aside/cns-tile-set/div/cns-tile[5]/div/div/div[2]"));
    static TextField TaskTemplet = new TextField("Enter TaskTemplet", byXPath("//input[@name='taskTemplateId_input']"));
    static Link SelTask = new Link("Click SelTask", byXPath("//span[@title='TASK1']"));
    static Link Student = new Link("Click on Student", byXPath("//div[@id='search_display_studentId']"));
	static TextField EnterStudent = new TextField("Enter Term", byXPath("//input[@id='search']"));
	static Checkbox SelectStudent = new Checkbox("Select Term", byXPath("//input[@aria-label='AAMODT, JAMIE']"));
	static Button Select = new Button("Select Button", byXPath("//button[text()='Select']"));
	static Link AcademicRecords = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[3]/span"));
	static Link DegreeProgressAudit = new Link("DegreeProgressAudit", byXPath("//span[text()='Degree Progress Audit']"));
	static Link Communication = new Link("Click Communication ", byXPath("(//li[@id='RequiredCoursePanelItem0']/span/span)[1]"));
	static AngDropDown DegDropDown = new AngDropDown("Click DegDropDown", byXPath("(//a[@title=\"Column Settings\"])[13]"));
    static TextField Cvalue1 = new TextField("Enter Value", byXPath("//input[@title='Value']"));
	static Link ClikCourseCode = new Link("Click ClikCourseCode ", byXPath("//td[text()='COM111']"));
	static Link Clikwaive = new Link("Click Clikwaive ", byXPath("(//a[text()='Waive'])[1]"));
	static Link Clikwaive1 = new Link("Click Clikwaive1 ", byXPath("//button[text()=' Waive ']"));
	static Link FilterDropDwon1 = new Link("Click Filter Drop Down", byXPath("//div[@id='listSettingsButton_wrapper']/a[2]"));
	static Link ClsFilterDropDwon = new Link("Click Filter Drop Down", byXPath("(//a[@class='k-button k-split-button-arrow'])[1]"));
	static Link ClsClearFiltersButton = new Link("Click Filter Button", byXPath("//a[. = 'Clear Filters']"));	
	//--------Validation Message----
	Link DocScheduleMsg= new Link("Document Schedule Msg", byXPath("//span[text()='The Document Schedule records were successfully saved.']"));
	Link DocTypeMsg= new Link("Document Type Msg", byXPath("//span[text()='The Document Type records were successfully saved.']"));
	Link SubsidiaryMsg= new Link("Subsidiary Msg", byXPath("//span[text()='The Subsidiary records were successfully saved.']"));
	
	//Add Colleges Web elements
	static Link ClickColleges = new Link("Click Colleges", byXPath("//span[.=\"Colleges\"]"));
	static Link newButton = new Link("Click New", byXPath("//a[@id=\"newButton\"]"));
	static TextField CollegeName = new TextField("Enter College Name", byXPath("//input[@id=\"name\"]"));
	static TextField CollegeCode = new TextField("Enter College Code", byXPath("//input[@id=\"code\"]"));
	static TextField CollegeAddress = new TextField("Enter College Address", byXPath("//input[@id=\"streetAddress\"]"));
	static TextField CollegeCity = new TextField("Enter College City", byXPath("//input[@id=\"city\"]"));
	static TextField CollegeState = new TextField("Enter College State", byXPath("//input[@name=\"state_input\"]"));
	static TextField CollegeCountry = new TextField("Enter College Country", byXPath("//input[@name=\"countryId_input\"]"));
	static TextField CollegePhoneNumber = new TextField("Enter College Phone Number", byXPath("//input[@id=\"phoneNumber\"]"));
	static TextField CollegeZipCode = new TextField("Enter College Zip Code", byXPath("//input[@name=\"postalCode_input\"]"));
			
	//Add Course to a College
	static Button FilterDropDown = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
	static Link ClearFilter = new Link("Click Clear Filter", byXPath("//li[.=\"Clear Filters\"]"));
	static AngDropDown CollegeNameDropDown = new AngDropDown("Click College Name Drop Down", byXPath("//th[2]/a[1]/span"));
	static Link Filter = new Link("Click Filter", byXPath("//span[.=\"Filter\"]"));
	static TextField Collegevalue = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
	static Button Filter1 = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
	static Link ClickCollege = new Link("Click College Name", byXPath("//a[.=\"New1\"]"));
	static Link NewCollegeCourse = new Link("Click New", byId("newButton_CollegeCourse"));
	static TextField CourseName = new TextField("CourseName", byId("courseName"));
	static TextField CourseCode = new TextField("CourseName", byId("courseCode"));
	static TextField CourseStartDate = new TextField("Course Start Date", byId("creditAcceptedBeginDate"));
	static TextField CourseEndDate = new TextField("Course End Date", byId("minGradeRequired"));
	static TextField CourseCredits = new TextField("Course Credits",byXPath("//input[1][@aria-label=\"Credits\"]"));
	static Button CourseSaveClose = new Button("Course Save and Close", byXPath("//button[.=\"Save & Close\"]"));
	//Method Implementation
	
	//Enter Login Credential to Get into the Student's or Any Home Page
	public StudentConfigurationPage CreateResidencyType(StringHash data) throws Exception {
		waitForPageToLoad();
		wait(30);
		MenuButton.click();
		wait(2);
		Configuration.click();
		wait(2);
		SearchConfiguration.clearAndType(data.get("Search Name").toString());
		wait(2);
		ResidencyTypes.click();
		waitForPageToLoad();
		wait(2);
		NewButton.click();
		waitForPageToLoad();
		wait(2);
		//Name.clearAndType(data.get("Name").toString());
		Name.clearAndType(RstName);
		waitForPageToLoad();
		wait(2);
		//Code.clearAndType(data.get("Code").toString());
		Code.clearAndType(RstCode);
		waitForPageToLoad();
		wait(2);
		SaveAndClose.click();
		waitForPageToLoad();
		wait(3);
		return this;
    }
	
public StudentConfigurationPage CreateTaskTemplate(StringHash data) throws Exception{
		Link SelectingEventType1 = new Link("Selecting Event Type", byXPath("//span[. = '"+data.get("EventType")+"']"));
		//Campuses.sendKeys(StudentStudentPage.LastNameValue);
		
		waitForPageToLoad();
		SearchConfiguration.clearAndType(data.get("Component").toString());
		TaskTemplates.waitTillElementClickable();
		TaskTemplates.click();
		waitForPageToLoad();
		NewButton.click();
		waitForPageToLoad();
		wait(5);
		//Name.clearAndType(data.get("TaskTemplateName").toString());
		Name.clearAndType(TaskTempNameValue);
		wait(2);
		//Code.clearAndType(data.get("TaskTemplateCode").toString());
		Code.clearAndType(TaskTempCodeValue);
		wait(2);
		EventType.clearAndType(data.get("EventType").toString());;
		wait(2);
		SelectingEventType1.click();
		wait(2);
		SaveAndClose.waitTillElementClickable();
		SaveAndClose.clickUsingJavaScriptExecutor();
		wait(5);
		waitForPageToLoad();
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		Listdrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(TaskTempNameValue);
		wait(2);
		Filterbutton.click();
		wait(2);
		String TaskTemplateName = Tablevalue.getText();
		System.out.println(TaskTemplateName);
		if(TaskTemplateName.equalsIgnoreCase(TaskTempNameValue))
		{
			System.out.println("Task template is matching");
		}else {
			System.out.println("Task template is not matching");
		}
		wait(1);
		
		return this;
	}
	
	public StudentConfigurationPage CreateTaskSchedule(StringHash data) throws Exception{
		Link SelectingScheduleFor1 = new Link("Selecting schedule for", byXPath("//span[. = '"+data.get("ScheduleFor")+"']"));
		Link SelectingTriggerWhen1= new Link("Selecting trigger when", byXPath("//span[. = '"+data.get("TriggerWhen")+"']"));
		Checkbox ChangestoName1 = new Checkbox("Selecting changes to status", byXPath("//input[@aria-label='"+data.get("TriggerChangesTo")+"']"));
		Link SelectingType1 = new Link("Selecting EventType", byXPath("//span[. = '"+data.get("Events")+"']"));
		Link SelectingTaskTemplate1 = new Link("Selecting TaskTemplate", byXPath("//div/div/div//span[. = '"+data.get("TaskTemplate")+"']"));
		Link SelectingAssignedTo1 = new Link("Selecting AssignedTo", byXPath("//span[. = '"+data.get("AssignedTo")+"']"));
		Link SelectingUnits1 = new Link("Selecting Units", byXPath("//li[. = '"+data.get("Units")+"']"));
		Link SelectingEvent1 = new Link("Selecting Event", byXPath("//span[. = '"+data.get("Event")+"']"));
		
		waitForPageToLoad();
		SearchConfiguration.clearAndType(data.get("Component").toString());
		TaskSchedules.waitTillElementClickable();
		TaskSchedules.click();
		wait(5);
		NewButton.waitTillElementClickable();
		NewButton.click();
		wait(10);
		//Name.clearAndType(data.get("TaskScheduleName").toString());
		Name.clearAndType(TaskSchNameValue);
		ScheduleTaskFor.clearAndType(data.get("ScheduleFor"));
		wait(3);
		//SelectingScheduleFor.waitTillElementFound();
		SelectingScheduleFor1.clickUsingJavaScriptExecutor();
		wait(2);
		//DocumentsList.clearAndType(data.get("DocumentsList"));
		//wait(3);
		//SelectingDocumentList.clickUsingJavaScriptExecutor();
		TriggerWhen.clearAndType(data.get("TriggerWhen").toString());
		wait(3);
		SelectingTriggerWhen1.clickUsingJavaScriptExecutor();
		TriggerChangesTo.click();
		SearchName.clearAndType(data.get("TriggerChangesTo"));
		wait(2);
		ChangestoName1.clickUsingJavaScriptExecutor();
		SelectButton.click();
		wait(2);
		//scrollPage(0, 300);
		TaskEventType.clearAndType(data.get("Events").toString());
		wait(1);
		SelectingType1.clickUsingJavaScriptExecutor();
		TaskTemplate.clearAndType(data.get("TaskTemplate").toString());
		wait(1);
		SelectingTaskTemplate1.clickUsingJavaScriptExecutor();
		//AssignTo.clickUsingJavaScriptExecutor();
		AssignedTo.clearAndType(data.get("AssignedTo").toString());
		wait(1);
		SelectingAssignedTo1.clickUsingJavaScriptExecutor();
		//wait(2);
		//AssignTo.clickUsingJavaScriptExecutor();
		//wait(1);
		scrollPage(0,500);
		wait(1);
		Units.clickUsingJavaScriptExecutor();
		//Units.sendKeys(data.get("Units").toString());
		wait(1);
		SelectingUnits1.clickUsingJavaScriptExecutor();
		Event.clearAndType(data.get("Event").toString());
		wait(1);
		SelectingEvent1.clickUsingJavaScriptExecutor();
		Thread.sleep(2000);
		SaveAndClose.click();
		waitForPageToLoad();
		wait(2);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		Listdrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(TaskSchNameValue);
		wait(2);
		Filterbutton.click();
		wait(2);
		String TaskScheduleName = Tablevalue.getText();
		System.out.println(TaskScheduleName);
		if(TaskScheduleName.equalsIgnoreCase(TaskSchNameValue))
		{
			System.out.println("Task schedule is matching");
		}else {
			System.out.println("Task schedule is not matching");
		}
		wait(1);
		return null;
		
	}
	
	public StudentConfigurationPage CreateDocumetType(StringHash data) throws Exception{
	    Link SelectingModule1 = new Link("Selecting Module", byXPath("//li[text()='"+data.get("ModuleName")+"']"));
	    Link SelectingDocumentType1 = new Link("Selecting Module", byXPath("//li[text()='"+data.get("DocumentType")+"']"));
	    Checkbox SelectingCampus1 = new Checkbox("Selecting campus", byXPath("//input[@aria-label='"+data.get("CampusGroup")+"']"));
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	    
		wait(10);
		SearchConfiguration.clearAndType(data.get("Component").toString());
		Documents.waitTillElementClickable();
		Documents.click();
		wait(3);
		NewButton.click();
		//waitForPageToLoad();
		wait(15);
		Name.waitTillElementClickable();
		Name.clearAndType(data.get("DocumentName").toString());
		//Name.clearAndType(DocNameValue);
		wait(1);
		Code.clearAndType(data.get("DocumentCode").toString());
		//Code.clearAndType(DocCodeValue);
		wait(1);
		Module.clearAndType(data.get("ModuleName").toString());
		wait(3);
		SelectingModule1.click();
		DocumentType.clearAndType(data.get("DocumentType").toString());
		SelectingDocumentType1.clickUsingJavaScriptExecutor();
		//Campuses.clickUsingJavaScriptExecutor();---this is used for DTS
		CampusesGroup.clickUsingJavaScriptExecutor();
		wait(2);
		SearchName.clearAndType(data.get("CampusGroup").toString());
		wait(2);
		SelectingCampus1.clickUsingJavaScriptExecutor();
		SelectButton.clickUsingJavaScriptExecutor();
		Thread.sleep(2000);
		SaveAndClose.clickUsingJavaScriptExecutor();
		wait(5);
		CustomAsserts.containsString(DocTypeMsg.getText(), data.get("DocTypeMsg").toString());
		waitForPageToLoad();
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		Listdrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(data.get("DocumentName"));
		wait(2);
		Filterbutton.click();
		wait(2);
		String DocumentTypeName = Tablevalue.getText();
		System.out.println(DocumentTypeName);
		if(DocumentTypeName.equalsIgnoreCase(data.get("DocumentName")))
		{
			System.out.println("Document type is matching");
		}else {
			System.out.println("Document type is not matching");
		}
		wait(1);
		return this;
	}
   
   public StudentConfigurationPage CreateDocumetSchedule(StringHash data) throws Exception{
	    Link SelectingSearchCriteria1 = new Link("Selecting Search Criteria", byXPath("//span[. = '"+data.get("Status")+"']"));
	    Checkbox DependentStatus1 = new Checkbox("Dependent status", byXPath("//input[@aria-label='"+data.get("DependentStatus")+"']"));
	    Checkbox SelectingDocument1 = new Checkbox("Selecting document", byXPath("//input[@aria-label='"+data.get("DocumentType")+"']"));
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	   
		wait(10);
		SearchConfiguration.clearAndType(data.get("Component").toString());
		DocumentSchedules.waitTillElementClickable();
		DocumentSchedules.click();
		wait(3);
		NewButton.click();
		waitForPageToLoad();
		wait(2);
		Name.clearAndType(data.get("DocumentName").toString());
		//Name.clearAndType(DocSchNameValue);
		wait(2);
		ScheduleCriteria.clickUsingJavaScriptExecutor();
		SearchCriteria.clearAndType(data.get("Status").toString());
		SelectingSearchCriteria1.clickUsingJavaScriptExecutor();
		Arrowmark.clickUsingJavaScriptExecutor();
		Value.clickUsingJavaScriptExecutor();
		SearchName.clearAndType(data.get("DependentStatus").toString());
		DependentStatus1.clickUsingJavaScriptExecutor();
		SelectButton.clickUsingJavaScriptExecutor();
		//wait(2);
		ScheduleCriteria.clickUsingJavaScriptExecutor();
		//wait(2);
		DocumentCriteria.clickUsingJavaScriptExecutor();
		//wait(3);
		AddDocument.clickUsingJavaScriptExecutor();
		SearchName.clearAndType(data.get("DocumentType").toString());
		wait(2);
		SelectingDocument1.clickUsingJavaScriptExecutor();
		wait(2);
		SelectButton.clickUsingJavaScriptExecutor();
		wait(2);
		SaveAndClose.clickUsingJavaScriptExecutor();
		//waitForPageToLoad();
		wait(5);
		CustomAsserts.containsString(DocScheduleMsg.getText(), data.get("DocScheduleMsg").toString());
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(2);
		Listdrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(data.get("DocumentName"));
		wait(2);
		Filterbutton.click();
		wait(2);
		String DocumentschName = Tablevalue.getText();
		System.out.println(DocumentschName);
		if(DocumentschName.equalsIgnoreCase(data.get("DocumentName")))
		{
			System.out.println("Document schedule is matching");
		}else {
			System.out.println("Document schedule is not matching");
		}
		wait(1);
		
		return this;
	}	

   public StudentConfigurationPage CreateSubsidiary(StringHash data) throws Exception {
	    Checkbox SelectingCode = new Checkbox("Selecting code", byXPath("//input[@aria-label= '"+data.get("TransactionCode")+"']"));
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	   
	    wait(10);
		SearchConfiguration.clearAndType(data.get("Component").toString());
		wait(2);
		Subsidiaries.click();
		//waitForPageToLoad();
		wait(3);
		NewButton.click();
		//waitForPageToLoad();
		wait(22);
		//Name.clearAndType(data.get("Name").toString());
		Name.waitTillElementClickable();
		Name.clearAndType(data.get("SubsidiaryName").toString());
		wait(2);
		Code.clearAndType(data.get("SubsidiaryCode"));
		wait(2);
		scrollPage(0, 300);
		wait(2);
		TransactionCodes.click();
		wait(2);
		SearchCode.clearAndType(data.get("TransactionCode"));
		wait(2);
		SelectingCode.click();
		wait(1);
		SelectCode.click();
		wait(2);
		scrollPage(0, -300);
		wait(2);
		SaveAndClose.click();
		wait(3);
		CustomAsserts.containsString(SubsidiaryMsg.getText(), data.get("SubsidiaryMsg").toString());
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(2);
		Namedrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(data.get("SubsidiaryName"));
		wait(2);
		Filterbutton.click();
		wait(2);
		String SubName = Tablevalue.getText();
		System.out.println(SubName);
		if(SubName.equalsIgnoreCase(data.get("SubsidiaryName")))
		{
			System.out.println("Subsidiary name is matching");
		}else {
			System.out.println("Subsidiary name is not matching");
		}
		wait(1);
		return this;
   }
  
public StudentConfigurationPage AddSMSServiceProvider(StringHash data) throws Exception{
	   
	   Link SMSProvidersSpan = new Link("SMSProvidersSpan", byXPath("//span[. = 'SMS Service Providers']"));
	   Link New = new Link("New", byCSSSelector("#newButton")); 
	   TextField Name = new TextField("Name", byCSSSelector("#name"));
	   TextField Code = new TextField("Code", byCSSSelector("#code"));
	   TextField DomainName = new TextField("DomainName", byCSSSelector("#domainName"));
	   TextField MaxLength = new TextField("MaxLength", byCSSSelector("#maximumMessageLength"));
	   Button Save = new Button("Save", byXPath("//cmc-toolbar-button-save//button"));
	   Link SMSProvidersSaveMessage = new Link("SMSProvidersSaveMessage", byXPath("//span[. = 'The Sms Service Provider records were successfully saved.']"));
	   
	    
		
		waitForPageToLoad();
		SearchConfiguration.click();
		SearchConfiguration.clearAndType("SMS Service Providers");
		wait(3);
		SMSProvidersSpan.click();
		waitForPageToLoad();
		New.click();
		waitForPageToLoad();
		scrollPage(0,300);
		Name.click();
		wait(2);
		Name.clearAndType(SMSNameValue.toString());
		wait(2);
		Code.click();
		wait(2);
		Code.clearAndType(SMSCodeValue.toString());
		wait(2);
		DomainName.click();
		wait(2);
		DomainName.clearAndType(data.get("DomainName").toString());
		wait(2);
		MaxLength.click();
		wait(2);
		MaxLength.clearAndType(data.get("MaxLength").toString());
		wait(2);
		Save.click();
		wait(8);
		CustomAsserts.containsString(SMSProvidersSaveMessage.getText(), data.get("SuccessMessage").toString());
		
		return this;
	}	
   
  
 public StudentConfigurationPage AddNewEmployer(StringHash data) throws Exception{

	   
	   Link EmployersSpan = new Link("EmployersSpan", byXPath("//span[. = 'Employers']"));
	   Link New = new Link("New", byCSSSelector("#newButton")); 
	   TextField EmployerName = new TextField("EmployerName", byCSSSelector("#employerName"));
	   TextField EMailAddress = new TextField("EMailAddress", byCSSSelector("#employerEmailAddress"));
	   TextField StreetAdress = new TextField("StreetAdress", byCSSSelector("#streetAddress"));
	   TextField City = new TextField("City", byCSSSelector("#city"));
	   TextField PIN = new TextField("PIN", byXPath("(//input[@aria-label='Postal Index Number'])[1]"));
	   TextField PhoneNum = new TextField("PhoneNum", byCSSSelector("#phoneNumber"));
	   TextField EmployeeExtension = new TextField("EmployeeExtension", byCSSSelector("#employeExtension"));
	   Button Save = new Button("Save", byXPath("//cmc-toolbar-button-save//button"));
	   Link EmployerSuccessMessage = new Link("EmployerSuccessMessage", byXPath("//span[. = 'The Employer records were successfully saved.']"));
	   //String EmployerNameValue = AppendValue.apendString();
	   //String EmailAddressValue = AppendValue.apendString();
	  // String EmployerNameValue = AppendValue.apendString();
	  // String EmailAddressValue = AppendValue.apendString();

	   
		waitForPageToLoad();
		SearchConfiguration.click();
		SearchConfiguration.clearAndType("Employers");
		wait(3);
		EmployersSpan.click();
		waitForPageToLoad();
		New.click();
		waitForPageToLoad();
		EmployerName.click();
		EmployerName.clearAndType(EmployerNameValue.toString());
		scrollPage(0,300);
		EMailAddress.click();
		wait(3);
		EMailAddress.clearAndType(EmailAddressValue+"SIS.com".toString());
		StreetAdress.click();
		wait(2);
		StreetAdress.clearAndType(data.get("StreetAdress").toString());
		wait(2);
		City.click();
		wait(3);
		City.clearAndType(data.get("City").toString());
		//wait(2);
		//PIN.click();
		wait(4);
		//PIN.
		//PIN.type("12345");
		//PIN.clearAndType(data.get("PIN").toString());
		//wait(2);
		scrollPage(0,100);
		PhoneNum.click();
		wait(3);
		PhoneNum.type(data.get("PhoneNum").toString());
		//PhoneNum.clearAndType(data.get("PhoneNum").toString());
		scrollPage(0,200);
		EmployeeExtension.click();
		wait(3);
		EmployeeExtension.clearAndType(data.get("EmployeeExtension").toString());
		scrollPage(0,-500);
		Save.click();
		wait(7);
		CustomAsserts.containsString(EmployerSuccessMessage.getText(), data.get("EmployerSuccessMessage").toString());		
		return this;
	}	


 public StudentConfigurationPage ConfigurePromissoryNote(StringHash data) throws Exception{
	   
	   
	   Link FundSourcesSpan = new Link("FundSourcesSpan", byXPath("//span[. = 'Fund Sources']"));
	   Link CodeSpan = new Link("CodeSpan", byXPath("//th[2]/a/span"));
	   Button FilterOptions = new Button("FilterOptions", byXPath("//li[@class='k-item k-filter-item k-state-default k-last']"));
	   TextField Value = new TextField("Value", byXPath("//form//input[1]"));
	   Button Filter = new Button("Filter", byXPath("//button[. = 'Filter']"));
	   Link PaymentTypeLink = new Link("PaymentTypeLink", byXPath("//a[. = '"+data.get("PaymentType")+"']"));
	   Link RulesAndAttributesCollapse = new Link("RulesAndAttributesCollapse", byXPath("//cns-fund-source-rules-and-attributes/section/div/cmc-collapse/div/div[1]/div//div"));
	   Link PromissoryNote = new Link("PromissoryNote", byXPath("//input[@id='isPromissoryNoteAllowed']"));
	   Button Save = new Button("Save", byXPath("//cmc-toolbar-button-save//button"));
	   Link FundSourceSuccessMessage = new Link("FundSourceSuccessMessage", byXPath("//span[. = 'The Fund Source records were successfully saved.']"));
	   
 
		waitForPageToLoad();
		SearchConfiguration.click();
		SearchConfiguration.clearAndType("Fund Sources");
		wait(3);
		FundSourcesSpan.click();
		waitForPageToLoad();
		CodeSpan.click();
		wait(2);
		FilterOptions.click();
		wait(2);
		Value.click();
		Value.clearAndType(data.get("FundSource").toString());
		wait(2);
		Filter.click();
		wait(5);
		PaymentTypeLink.click();
		waitForPageToLoad();
		scrollPage(0,1000);
		wait(2);
		RulesAndAttributesCollapse.click();
		scrollPage(0,400);
		wait(5);
		if(PromissoryNote.isSelected())			
		{
			System.out.println("Promissory Note is already selected");
		}else {
			PromissoryNote.clickUsingJavaScriptExecutor();
			//System.out.println("Task template is not matching");
		}
		wait(3);
		scrollPage(0,-900);
		Save.click();
		wait(10);
		CustomAsserts.containsString(FundSourceSuccessMessage.getText(), data.get("FundSourceSuccessMessage").toString());	
		return this;
	}	

   
 public StudentConfigurationPage ConfdocsschedCorrierService(StringHash data) throws Exception{
	    
	    
	 	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	 	Link SelectModule = new Link("select module", byXPath("(//span[text()='"+data.get("Module Name")+"'])[1]"));
	 	Link SelectDocument = new Link("select module", byXPath("//span[@title='"+data.get("Document Name")+"']"));
	 	Link SelectDocumentStatus = new Link("select DocumentStatus", byXPath("//span[@title='"+data.get("Document Status")+"']"));
	 	Link SelectDocument1 = new Link("select module", byXPath("//span[@title='"+data.get("Document List")+"']"));
		//Login Page Web Elements
		//waitForPageToLoad();
		//MenuButton.click();
		//wait(5);
		//Students.click();
		waitForPageToLoad();
		wait(15);
		FilterDropDwon.click();
		wait(2);
		ClearFiltersButton.click();
		waitForPageToLoad();
		wait(10);
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
		ClickStudentName.click();
		waitForPageToLoad();
		wait(5);
		ContactManager.clickUsingJavaScriptExecutor();
		wait(5);
		Documents1.clickUsingJavaScriptExecutor();
		wait(5);
		NewDocument.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(5);
		Entermodule.clearAndType(data.get("Module Name").toString());
		wait(5);
		SelectModule.clickUsingJavaScriptExecutor();
		wait(5);
		EnterDocument.clearAndType(data.get("Document Name").toString());
		wait(5);
		SelectDocument.clickUsingJavaScriptExecutor();
		wait(5);
		DocumentStatus.clearAndType(data.get("Document Status").toString());
		wait(5);
		SelectDocumentStatus.clickUsingJavaScriptExecutor();
		wait(5);
		SaveAndClose1.clickUsingJavaScriptExecutor();
		wait(5);
		NewDocumentList.clickUsingJavaScriptExecutor();
		wait(2);
		scrollPage(0, 500);
		wait(5);
		/*Entermodule.clearAndType(data.get("Module Name").toString());
		wait(5);
		SelectModule.clickUsingJavaScriptExecutor();
		wait(5);*/
		EnterDocument.clearAndType(data.get("Document List").toString());
		wait(5);
		SelectDocument1.clickUsingJavaScriptExecutor();
		wait(5);
		DocumentStatus.clearAndType(data.get("Document Status").toString());
		wait(5);
		SelectDocumentStatus.clickUsingJavaScriptExecutor();
		wait(5);
		SaveAndClose3.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(5);
		return this;
}	
 
 
 public StudentConfigurationPage TskConfEmp(StringHash data) throws Exception{
	   
		//Login Page Web Elements
		waitForPageToLoad();
		wait(15);
		SearchContactManager.clearAndType(data.get("Search Name").toString());
		wait(3);
		TaskTemplets.clickUsingJavaScriptExecutor();
		wait(10);
		NewButton1.clickUsingJavaScriptExecutor();
		wait(10);
		Description.clearAndType(data.get("Description").toString());
		wait(5);
		Code1.clearAndType(data.get("Code").toString());
		wait(3);
		Catogery.clearAndType(data.get("Catogery").toString());
		wait(3);
		SelCatogery.clickUsingJavaScriptExecutor();
		wait(3);
		scrollPage(0, 200);
		wait(2);
		EventType1.clearAndType(data.get("Select EventType").toString());
		wait(3);
		SelEventType1.clickUsingJavaScriptExecutor();
		wait(3);
		EmailSubject.clearAndType(data.get("Email Subject").toString());
        wait(3);
		scrollPage(0, -200);
		wait(2);
		SaveAndClose2.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(7);
		return this;
	}
 
 
 public StudentConfigurationPage ConTskConfEmp(StringHash data) throws Exception{
	 
	//Login Page Web Elements
			waitForPageToLoad();
			wait(15);
			SearchContactManager.clearAndType(data.get("Search Name").toString());
			wait(3);
			Employeer.clickUsingJavaScriptExecutor();
			wait(10);
			Filtericon.clickUsingJavaScriptExecutor();
			wait(2);
			ClearFilters.clickUsingJavaScriptExecutor();
			wait(15);
			TeDropDown.click();
			wait(2);
			TerNumFilter.click();
			wait(2);
			value.clearAndType(data.get("Employer Name"));
			wait(3);
			CFilterButton.clickUsingJavaScriptExecutor();
			wait(5);
			ClkEmpName.clickUsingJavaScriptExecutor();
			wait(7);
			Task.clickUsingJavaScriptExecutor();
			wait(5);
			NewButton1.clickUsingJavaScriptExecutor();
			wait(5);
			TaskTemplet.clearAndType(data.get("Search TaskTemplet").toString());
			wait(5);
			SelTask.clickUsingJavaScriptExecutor();
			wait(5);
			Student.click();
			wait(5);
			EnterStudent.clearAndType(data.get("Student Name").toString());
			wait(5);
			SelectStudent.click();
			wait(5);	
			Select.click();
			wait(2);
			SaveAndClose2.clickUsingJavaScriptExecutor();
			waitForPageToLoad();
			wait(7);
		    return this;
	}	
 
 public StudentConfigurationPage DegreeProgressAudit(StringHash data) throws Exception{
	 
	 	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Link ClikCourseCode = new Link("Click ClikCourseCode ", byXPath("//td[text()='"+data.get("Course Code")+"']"));

		waitForPageToLoad();
		wait(20);
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
		wait(15);
		AcademicRecords.click();
		wait(3);
		DegreeProgressAudit.click();
		wait(30);
		scrollPage(0, 500);
		wait(7);
		Communication.click();
		wait(5);
		ClsFilterDropDwon.clickUsingJavaScriptExecutor();
		wait(2);
		ClsClearFiltersButton.clickUsingJavaScriptExecutor();
		wait(5);
		scrollPage(0, 300);
		wait(7);
		DegDropDown.click();
		wait(2);
		TerNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Course Code"));
		wait(3);
		FilterButton.click();
		wait(5);
		ClikCourseCode.clickUsingJavaScriptExecutor();
		wait(5);
		Clikwaive.clickUsingJavaScriptExecutor();
		wait(5);
		Clikwaive1.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(5);
		return this;
	}
 
 
 
 public StudentConfigurationPage ConfirmDocumentCarrierServices(StringHash data) throws Exception{
	    
		//X-path Parameterization	    
		Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Link SelectModule = new Link("select module", byXPath("(//span[text()='"+data.get("Module Name")+"'])[1]"));
		Link SelectDocument = new Link("select module", byXPath("//span[@title='"+data.get("Document Name")+"']"));
		Link SelectDocumentStatus = new Link("select DocumentStatus", byXPath("//span[@title='"+data.get("Document Status")+"']"));
		Link SelectDocument1 = new Link("select module", byXPath("//span[@title='"+data.get("Document List")+"']"));
		Link ConfirmDocsSchedCorrierServiceSaveMessage = new Link("ConfirmDocsSchedCorrierServiceSaveMessage", byXPath("//span[. = 'The Document records were successfully saved.']"));			

		//Method Implementation
		waitForPageToLoad();
		wait(15);
		FilterDropDwon.click();
		wait(2);
		ClearFiltersButton.click();
		wait(10);
		StuNumDropDown.click();
		wait(2);
		StuNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Student Number"));
		wait(5);
		FilterButton.click();
		wait(5);
		ClickStudentName.click();
		wait(10);
		ContactManager.clickUsingJavaScriptExecutor();
		wait(5);
		Documents1.clickUsingJavaScriptExecutor();
		wait(5);
		NewDocument.clickUsingJavaScriptExecutor();
		wait(10);
		Entermodule.clearAndType(data.get("Module Name").toString());
		wait(5);
		SelectModule.clickUsingJavaScriptExecutor();
		wait(5);
		EnterDocument.clearAndType(data.get("Document Name").toString());
		wait(5);
		SelectDocument.clickUsingJavaScriptExecutor();
		wait(5);
		DocumentStatus.clearAndType(data.get("Document Status").toString());
		wait(5);
		SelectDocumentStatus.clickUsingJavaScriptExecutor();
		wait(5);
		SaveAndClose1.clickUsingJavaScriptExecutor();
		wait(5);
		NewDocumentList.clickUsingJavaScriptExecutor();
		wait(2);
		scrollPage(0, 500);
		wait(5);
		Entermodule.clearAndType(data.get("Module Name").toString());
		wait(5);
		SelectModule.clickUsingJavaScriptExecutor();
		wait(5);
		DocumentStatus.clearAndType(data.get("Document Status").toString());
		wait(5);
		SelectDocumentStatus.clickUsingJavaScriptExecutor();
		wait(5);
		SaveAndClose3.clickUsingJavaScriptExecutor();
		wait(5);
		CustomAsserts.containsString(ConfirmDocsSchedCorrierServiceSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
		}
 
 
 public StudentConfigurationPage ConfirmTaskConfigurationForEmployee(StringHash data) throws Exception{

		//X-path Parameterization
		Link SelCatogery = new Link("Select SelCatogery", byXPath("//span[@title='"+data.get("Catogery")+"']"));
		Link SelEventType1 = new Link("Select SelEventType1", byXPath("//span[@title='"+data.get("Select EventType")+"']"));
		Link TaskConfigEmployeeSaveMessage = new Link("TaskConfigEmployeeSaveMessage", byXPath("//span[. = 'The Task Template records were successfully saved.']"));			

		//Method Implementation
        waitForPageToLoad();
		wait(10);
		SearchContactManager.clearAndType(data.get("Search Name").toString());
		wait(3);
		TaskTemplets.clickUsingJavaScriptExecutor();
		wait(10);
		NewButton1.clickUsingJavaScriptExecutor();
		wait(10);
		Description.clearAndType(data.get("Description").toString());
		wait(5);
		Code1.clearAndType(data.get("Code").toString());
		wait(3);
		Catogery.clearAndType(data.get("Catogery").toString());
		wait(3);
		SelCatogery.clickUsingJavaScriptExecutor();
		wait(3);
		scrollPage(0, 200);
		wait(2);
		EventType1.clearAndType(data.get("Select EventType").toString());
		wait(3);
		SelEventType1.clickUsingJavaScriptExecutor();
		wait(3);
		EmailSubject.clearAndType(data.get("Email Subject").toString());
		wait(3);
		scrollPage(0, -200);
		wait(2);
		SaveAndClose2.clickUsingJavaScriptExecutor();
		wait(7);
		CustomAsserts.containsString(TaskConfigEmployeeSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
			}
      
 public StudentConfigurationPage ConfirmTaskConfigurationForEmployeeDropdown(StringHash data) throws Exception{

	//X-path Parameterization
		Link SelTask = new Link("Click SelTask", byXPath("//span[@title='"+data.get("Search TaskTemplet")+"']"));
		Checkbox SelectStudent = new Checkbox("Select Term", byXPath("//input[@aria-label='"+data.get("Student Name")+"']"));
		Link ConfirmTskConfEmployeeDropdownSaveMessage = new Link("ConfirmTskConfEmployeeDropdownSaveMessage", byXPath("//span[. = 'The Task records were successfully saved.']"));			
				
	//Method Implementation
		waitForPageToLoad();
		wait(15);
		SearchContactManager.clearAndType(data.get("Search Name").toString());
		wait(3);
		Employeer.clickUsingJavaScriptExecutor();
		wait(10);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
	    wait(15);
		TeDropDown.click();
		wait(2);
		TerNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Employer Name"));
		wait(3);
		CFilterButton.clickUsingJavaScriptExecutor();
		wait(5);
		ClkEmpName.clickUsingJavaScriptExecutor();
		wait(7);
		Task.clickUsingJavaScriptExecutor();
		wait(5);
		NewButton1.clickUsingJavaScriptExecutor();
		wait(5);
		TaskTemplet.clearAndType(data.get("Search TaskTemplet").toString());
		wait(5);
		SelTask.clickUsingJavaScriptExecutor();
		wait(5);
		Student.click();
		wait(5);
		EnterStudent.clearAndType(data.get("Student Name").toString());
		wait(5);
		SelectStudent.click();
		wait(5);	
		Select.click();
		wait(2);
		SaveAndClose2.clickUsingJavaScriptExecutor();
		wait(7);
		CustomAsserts.containsString(ConfirmTskConfEmployeeDropdownSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
		}	
 
 
public StudentConfigurationPage AddCollegePage(StringHash data) throws Exception{
	 
	 Link SuccessMessage = new Link("Validation Message", byXPath("//span[. = 'The College records were successfully saved.']"));
		
		SearchConfiguration.sendKeys("Colleges");
		ClickColleges.click();
		wait(10);
		newButton.click();
		CollegeName.clearAndType(data.get("CollegeName"));
		CollegeCode.clearAndType(data.get("CollegeCode"));
		scrollPage(0, 300);
		wait(2);
		CollegeAddress.clearAndType(data.get("CollegeAddress"));
		wait(2);
		CollegeCity.clearAndType(data.get("CollegeCity"));
		wait(2);
		//CollegeState.clearAndType(data.get("CollegeState"));
		//CollegeCountry.clearAndType(data.get("CollegeCountry"));
		CollegePhoneNumber.clearAndType(data.get("CollegePhoneNumber"));
		wait(2);
		//CollegeZipCode.clearAndType(data.get("CollegeZipCode"));
		scrollPage(0, -300);
		wait(2);
		SaveAndClose.click();
		wait(5);
		CustomAsserts.containsString(SuccessMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
		
	}
public StudentConfigurationPage AddCollegeCoursePage(StringHash data) throws Exception{
	 
	Link SuccessMessage = new Link("Validation Message", byXPath("//span[. = 'The College Course records were successfully saved.']"));
	 Link ClickCollege = new Link("Click College Name", byXPath("//a[.='"+data.get("CollegeName")+"']"));
	  
		SearchConfiguration.sendKeys("Colleges");
		ClickColleges.click();
		wait(10);
		FilterDropDown.click();
		ClearFilter.click();
		wait(5);
		CollegeNameDropDown.click();
		Filter.click();
		Collegevalue.clearAndType(data.get("CollegeName"));
		Filter1.click();
		wait(5);
		ClickCollege.click();
		wait(10);
		//CollegeZipCode.clearAndType(data.get("CollegeZipCode"));
		scrollPage(0, 1000);
		wait(2);
		NewCollegeCourse.click();
		wait(5);
		CourseName.clearAndType(data.get("CourseName"));
		CourseCode.clearAndType(data.get("CourseCode"));
		CourseStartDate.clearAndType(data.get("CourseStartDate"));
		CourseEndDate.clearAndType(data.get("CourseEndDate"));
		CourseCredits.clearAndType(data.get("CourseCredits"));
		CourseSaveClose.click();
		wait(2);
		scrollPage(0, -1000);
		wait(5);
		CustomAsserts.containsString(SuccessMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		SaveAndClose.click();
		wait(2);
		return this;
		
	}

}
