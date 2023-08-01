package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byCSSSelector;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byName;

import org.openqa.selenium.By.ByName;



import java.util.concurrent.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.framework.base.BasePage;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

import groovy.json.internal.Exceptions;

public class StudentProcessesPage extends BasePage{
	
//	Processes Page Web Elements
	static TextField EnterTextInProcesses = new TextField("Enter Text", byId("daily-processes-treeview-filter"));
	static Link Attendance = new Link("Click Attendance", byXPath("//span[.=\"Attendance\"]"));
	static TextField EnterTermCode = new TextField("Enter Term Code", byId("search"));
	static TextField AttTermCode = new TextField("Enter Term Code", byName("termId_input"));
	static Button ATTSelectTerm = new Button("Check Term", byXPath("//span[@title=\"NANDA\"]"));
	static Button ClickCourseCode = new Button("Click Course Code", byXPath("//span[.=\"Course Code:\"]"));
	static Link ClickCourseSpan = new Link("Click Course Span", byId("search_display_courseSearch"));
    static TextField EnterCourseCode = new TextField("Enter Course Code", byId("search"));
  //Xpath Parameter		static Checkbox CheckCourse = new Checkbox("Select the course", byXPath("//input[@aria-label=\"MTH111 - COLLEGE ALGEBRA\"]"));
	static Button Select = new Button("Click Select", byXPath("//button[.=\"Select\"]"));
	static TextField AttendanceStartDate = new TextField("Enter Attendance Start Date", byId("attendenceStartDate"));
	static TextField AttendanceEndDate = new TextField("Enter Attendance End Date", byId("attendenceEndtDate"));
	static Button ApplyFilter = new Button("Click Apply Filter", byXPath("//button[.=\"Apply Filters\"]"));
	static Button Save = new Button("Click Save", byXPath("(//a[@id=\"saveButton\"])[2]"));
	static Link Gradebook = new Link("Click Attendance", byXPath("//span[.=\"Gradebook\"]"));
	static TextField Campus = new TextField("Enter Campus", byXPath("//input[@name=\"campusDropDown_input\"]"));
	static Link TermSpan = new Link("Click Term Span", byId("search_display_termId"));
	static TextField EnterTermName = new TextField("Enter Term Name", byId("search"));
	static TextField LetterGrade = new TextField("Enter Letter Grade", byXPath("(//span[@class=\"k-dropdown-wrap k-state-default\"])[3]"));
	static Button ClickAttendanceField = new Button("Click Attendance field", byId("attendanceGrid_cmcGrid_active_cell"));
	static TextField EnterAttendance = new TextField("Enter Attendance in Minutes", byName("OptionID0"));
//SAP Calculation Web Elements
	static Link SAPCalculation = new Link("Click SAP calculation", byXPath("//span[.=\"SAP Calculation\"]"));
	static Link SAPTermSpan = new Link("Click Term Span", byId("search_display_termId"));
	static TextField SAPTermName = new TextField("Enter Term Code", byId("search"));
	static Checkbox CheckTerm = new Checkbox("Check Term", byXPath("//input[@aria-label=\"NANDA\"]"));
	static Button SAPSelect = new Button("Click Select", byXPath("//button[.=\"Select\"]"));
	static Button SAPQueue = new Button("Click Queue Batch", byId("queueButton"));
	static Link SAPOpenBatches = new Link("Click Open Batches", byXPath("//li[@aria-controls=\"Open Batches\"]"));
	static Link SubmittedByDropdown = new Link("Click drop down", byXPath("(//a[@aria-label=\"Column Settings\"])[3]"));
    static Button SubmittedByFilterDropDown = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
    static TextField SubmittedByValue = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button SubmittedByFilter = new Button("Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Button SAPConfirmqueue = new Button("Confirm Queue", byId("saveSubmitBatchPackingJob"));
    static Button SAPQueueOpenBatch = new Button("Click Queue Open Batch", byId("queueButton"));   
//Approve Disbursements to Pay Web Elements
    static Link ApproveDisbursementsToPay = new Link("Click Approve Disbursements to Pay", byXPath("//span[.=\"Approve Disbursements to Pay\"]"));
    static TextField ADCampus = new TextField("Enter Campus", byName("campusDropDown_input"));
    static TextField DisDateFrom = new TextField("Enter Disbursement Date from", byId("disbursementFromDateDatePicker"));
    static TextField DisDateTo = new TextField("Enter Disbursement Date to", byId("disbursementToDateDatePicker"));
    static TextField ADAwardYear = new TextField("Enter Disbursement Award year", byXPath("//div[@aria-label=\"Award Year\"]"));
    static TextField ADFundType = new TextField("Enter Fund Source", byName("fundTypeDropDown_input"));
	static TextField SearchField = new TextField("Search Processes", byXPath("//input[@placeholder='Search Processes']"));
	static Link RefundsStipends = new Link("Refunds/Stipends", byXPath("//span[text()='Refunds/Stipends']"));
	static Link Process = new Link("Process", byXPath("//span[@aria-label='Process: Dropdown']"));
	static Link ReturnMethod = new Link("Return Method", byXPath("//span[@aria-label='Return Method: Dropdown']"));
	static Link PrintChecks = new Link("Print Checks", byXPath("//span[@aria-label='Print Checks: Dropdown']"));
	static Link RecordSelection = new Link("Record selection", byXPath("//span[@aria-label='Record Selection: Dropdown']"));
	static Link BankAccount = new Link("Bank Account", byXPath("//div[@aria-label='Bank Account']"));
	static TextField SearchBankAccount = new TextField("Search Bank Account", byXPath("//input[@placeholder='Search Bank Account Name']"));
	static Button Next = new Button("Next", byXPath("//cmc-collapse/div[1]/div[2]/div[10]/div/button"));
	static Button QueuePost = new Button("Queue Post", byXPath("//a[@id='queueProcessButton']"));
	static Link StipendSelection = new Link("Stipend selection", byXPath("//span[@aria-label='Stipend Selection: Dropdown']"));
	static Button Queue = new Button("Queue", byXPath("//button[text()='Queue']"));
	//Print employer letters Web Elements
	static Link Letters = new Link("Letters", byXPath("//span[text()='Letters']"));
	static Link Type = new Link("Type", byXPath("//span[@aria-label='Type: Dropdown']"));
	static Button NextButton = new Button("Next", byXPath("//button[text()='Next']"));
	static Link ClearLetters = new Link("Clear Letters", byXPath("//span[@aria-label='Clear Letter Request after Generating: Dropdown']"));
	static Checkbox CheckLetters = new Checkbox("Check Letters", byXPath("//input[@id='checkAll']"));
	static Button QueueLetters = new Button("Queue Letters", byXPath("//a[@id='queueLetterButton']"));
	
	public StudentProcessesPage BatchAttendancePage(StringHash data) throws Exception {
		
		Checkbox CheckCourse = new Checkbox("Select the course", byXPath("//input[@aria-label='"+data.get("CourseNameCode")+"']"));
		//	 Button SelectTerm = new Button("Select Term", byXPath("//span[.='"+data.get("TermCode")+"']"));
		TextField Campus = new TextField("Enter Campus", byName("campusDropDown_input"));
		Link SelectCampus = new Link("Select Campus", byXPath("//span[.='"+data.get("CampusName")+"']"));
		Button ATTSelectTerm = new Button("Check Term", byXPath("//span[.='"+data.get("TermCode")+"']"));
		Button Refresh = new Button("Click Refresh Button", byId("attendanceGrid_cnsToolbar_kendoToolBar_reloadButton"));
		
	    waitForPageToLoad();
		wait(5);
		EnterTextInProcesses.clearAndType("Attendance");
		Attendance.waitTillElementFound();
		Attendance.click();
		waitForPageToLoad();
		Campus.clearAndType(data.get("CampusName"));
		wait(2);
		SelectCampus.click();
		wait(2);
		AttTermCode.clearAndType(data.get("TermCode"));
		wait(5);
		ATTSelectTerm.click();
		wait(2);
		ClickCourseSpan.click();
		wait(4);
		EnterCourseCode.clearAndType(data.get("CourseCode"));
		wait(5);
		CheckCourse.check();
		wait(2);
		Select.click();
		wait(2);
		AttendanceEndDate.clearAndType(data.get("AttendanceEndDate"));
		wait(2);
		AttendanceStartDate.clearAndType(data.get("AttendanceStartDate"));
		wait(2);
		ApplyFilter.clickUsingJavaScriptExecutor();
		wait(10);	
		//ClickAttendanceField.clickUsingJavaScriptExecutor();
		//wait(2);
		Refresh.click();
		wait(5);
		EnterAttendance.clearAndType(data.get("AttendanceInMinutes"));
		wait(4);
		Save.click();
		wait(5);	
		return this;
	
}
	
public StudentProcessesPage BatchFinalGradesPage(StringHash data) throws Exception {
		
		Checkbox TermName = new Checkbox("Select the course", byXPath("//input[@aria-label='"+data.get("TermName")+"']"));
		Checkbox CheckCourse = new Checkbox("Select the course", byXPath("//input[@aria-label='"+data.get("CourseNameCode")+"']"));
		Link SelectCampus = new Link("Select Campus", byXPath("//span[.='"+data.get("CampusName")+"']"));
		
		    waitForPageToLoad();
			EnterTextInProcesses.clearAndType("Gradebook");
			Gradebook.waitTillElementFound();
			Gradebook.click();
			wait(10);
			Campus.clearAndType(data.get("CampusName"));
			wait(2);
			SelectCampus.click();
			wait(2);
			TermSpan.click();
			wait(4);
			EnterTermCode.clearAndType(data.get("TermCode"));
			wait(4);
			TermName.check();
			wait(2);
			Select.click();
			wait(5);
			ClickCourseSpan.click();
			wait(4);
			EnterCourseCode.clearAndType(data.get("CourseCode"));
			wait(8);
			CheckCourse.check();
			wait(2);
			Select.click();
			wait(4);
			ApplyFilter.waitTillElementClickable();
			ApplyFilter.click();
			wait(5);
			LetterGrade.click();
			wait(2);
			LetterGrade.click();
			wait(5);
			//NumericGrade.deleteAndType(data.get("NumericdataGrade"));
			LetterGrade.sendKeys(data.get("LetterGrade"));
			wait(5);
			Save.click();
			wait(5);
			return this;
		
	}
	
	public StudentProcessesPage ProcessRefund(StringHash data) throws Exception {
		 Link SelectingProcess= new Link("Selecting Process", byXPath("//li[text()='"+data.get("Process")+"']"));
		 Link SelectingReturnMethod= new Link("Selecting Return Method", byXPath("//li[text()='"+data.get("ReturnMethod")+"']"));
		 Link SelectingRecordSelection= new Link("Selecting Record Selection", byXPath("//li[text()='"+data.get("RecordSelection")+"']"));
		 Link SelectingPrintChecks= new Link("Selecting Print Checks", byXPath("//li[text()='"+data.get("PrintChecks")+"']"));
		 Checkbox SelectingBankAccount= new Checkbox("Selecting Record Selection", byXPath("//input[@aria-label='"+data.get("BankAccount")+"']"));
		
		 waitForPageToLoad();
		 SearchField.clearAndType(data.get("Component"));
		 wait(2);
		 RefundsStipends.click();
		 wait(5);
		 Process.click();
		 wait(1);
		 SelectingProcess.click();
		 wait(1);
		 ReturnMethod.click();
		 wait(1);
		 SelectingReturnMethod.click();
		 wait(1);
		 RecordSelection.click();
		 wait(1);
		 SelectingRecordSelection.click();
		 wait(1);
		 PrintChecks.click();
		 wait(1);
		 SelectingPrintChecks.click();
		 wait(2);
		 BankAccount.click();
		 wait(2);
		 SearchBankAccount.clearAndType(data.get("BankAccount"));
		 wait(2);
		 SelectingBankAccount.click();
		 wait(2);
		 Select.click();
		 wait(2);
		 Next.click();
		 wait(3);
		 scrollPage(0, 300);
		 wait(1);
		 QueuePost.click();
		 wait(2);
		 Queue.click();
		 wait(2);
		 System.out.println("Processes refunds are scheduled");
		return this;
		
	}
	
	public StudentProcessesPage ProcessStipend(StringHash data) throws Exception {
		 Link SelectingProcess= new Link("Selecting Process", byXPath("//li[text()='"+data.get("Process")+"']"));
		 Link SelectingReturnMethod= new Link("Selecting Return Method", byXPath("//li[text()='"+data.get("ReturnMethod")+"']"));
		 Link SelectingRecordSelection= new Link("Selecting Record Selection", byXPath("//li[text()='"+data.get("RecordSelection")+"']"));
		 Link SelectingPrintChecks= new Link("Selecting Print Checks", byXPath("//li[text()='"+data.get("PrintChecks")+"']"));
		 Checkbox SelectingBankAccount= new Checkbox("Selecting Record Selection", byXPath("//input[@aria-label='"+data.get("BankAccount")+"']"));
		 Link SelectingStipendSelection= new Link("Selecting Stipend Selection", byXPath("//li[text()='"+data.get("StipendSelection")+"']"));
		
		 waitForPageToLoad();
		 SearchField.clearAndType(data.get("Component"));
		 wait(2);
		 RefundsStipends.click();
		 wait(5);
		 Process.click();
		 wait(1);
		 SelectingProcess.click();
		 wait(2);
		 StipendSelection.click();
		 wait(2);
		 SelectingStipendSelection.click();
		 wait(1);
		 ReturnMethod.click();
		 wait(1);
		 SelectingReturnMethod.click();
		 wait(1);
		 RecordSelection.click();
		 wait(1);
		 SelectingRecordSelection.click();
		 wait(1);
		 PrintChecks.click();
		 wait(1);
		 SelectingPrintChecks.click();
		 wait(2);
		 BankAccount.click();
		 wait(2);
		 SearchBankAccount.clearAndType(data.get("BankAccount"));
		 wait(2);
		 SelectingBankAccount.click();
		 wait(2);
		 Select.click();
		 wait(2);
		 Next.click();
		 wait(2);
		 QueuePost.click();
		 wait(2);
		 Queue.click();
		 wait(2);
		 System.out.println("Processes Stipends are scheduled");
		return this;
		
	}

	
	public StudentProcessesPage SAPCalculationPage(StringHash data) throws Exception {
		
		Checkbox CheckTerm = new Checkbox("Check Term", byXPath("//input[@aria-label='"+data.get("TermCode")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The SAP Calculation records were successfully queued.']"));
		EnterTextInProcesses.clearAndType("SAP Calculation");
		SAPCalculation.waitTillElementFound();
		SAPCalculation.click();
		wait(5);
		SAPTermSpan.click();
		wait(4);
		SAPTermName.clearAndType(data.get("TermCode"));
		wait(5);
		CheckTerm.check();
		wait(2);
		SAPSelect.click();
		wait(3);
		SAPQueue.click();
		wait(4);
		SAPConfirmqueue.click();
		wait(4);
		SAPOpenBatches.click();
		wait(4);
		scrollPage(0, 500);
		wait(2);
		SAPQueueOpenBatch.click();
		wait(5);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;
	}
	
	public StudentProcessesPage ApproveDisbursementPage(StringHash data) throws Exception {
		
		
		Button SelectADCampus = new Button("Select AD Campus", byXPath("//span[.='"+data.get("Campus")+"']"));
		Button SelectAwardYear = new Button("Select Award Year",byXPath("//li[.='"+data.get("AwardYear")+"']"));
		Button SelectADFundSource = new Button("Select AD Fund Source", byXPath("//span[.='"+data.get("FundSource")+"']"));
		
		waitForPageToLoad();
		wait(5);
		EnterTextInProcesses.sendKeys("Approve Disbursements to Pay");
		wait(2);
		ApproveDisbursementsToPay.click();
		waitForPageToLoad();
		wait(5);
		ADCampus.clearAndType(data.get("Campus"));
		wait(2);
		SelectADCampus.click();
		wait(2);
		DisDateFrom.clearAndType(data.get("DisDateFrom"));
		wait(2);
		DisDateTo.clearAndType(data.get("DisDateTo"));
		wait(4);
	//	ADAwardYear.sendKeys(data.get("AwardYear"));
	//	wait(4);
		ADAwardYear.click();
		wait(2);
		SelectAwardYear.click();
		wait(2);
		ADFundType.clearAndType(data.get("FundSource"));
		wait(2);
		SelectADFundSource.click();
		wait(5);		
		return this;
	}
	
	
	public StudentProcessesPage ProcessLetters(StringHash data) throws Exception {
		 Link SelectingType = new Link("Selecting Type", byXPath("//li[text()='"+data.get("Type")+"']")); 
		 Link SelectingCLr = new Link("Selecting Type", byXPath("//li[text()='"+data.get("ClearLetter")+"']"));
		 Checkbox SelectingLetter = new Checkbox("Selecting Letter", byXPath("//input[@aria-label = '"+data.get("TaskTemplate")+"']"));
		 Link QueLetterMsg= new Link("Queue Letter Msg", byXPath("//span[text()='The Letters were successfully queued']"));
		
		 waitForPageToLoad();
		 SearchField.clearAndType(data.get("Component"));
		 wait(2);
		 Letters.click();
		 wait(5);
		 Type.click();
		 wait(2);
		 SelectingType.click();
		 wait(2);
		 ClearLetters.click();
		 wait(2);
		 SelectingCLr.click();
		 wait(2);
		 NextButton.click();
		 wait(3);
		 CheckLetters.click();
		 wait(2);
		 SelectingLetter.click();
		 wait(2);
		 QueueLetters.click();
		 wait(2);
		 Queue.click();
		 wait(2);
		 CustomAsserts.containsString(QueLetterMsg.getText(), data.get("QueLetterMsg").toString());
		return this;
	}

}
