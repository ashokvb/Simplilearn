package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byLinkText;
import static com.framework.elements.Locator.byCSSSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.framework.base.BasePage;
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


public class StudentProcessessPage extends BasePage{
		
	static TextField SearchProcessess = new TextField("SearchProcessess", byCSSSelector("#daily-processes-treeview-filter"));
	
public StudentProcessessPage UpdateAdminRepInABatch(StringHash data) throws Exception{
	
	
	Link ReassignProspectsSpan = new Link("ReassignProspectsSpan", byXPath("//span[. = 'Reassign Prospects']"));
	TextField StartDate = new TextField("StartDate", byCSSSelector("#prospectStartDate"));
	TextField EndDate = new TextField("EndDate", byCSSSelector("#prospectEndDate"));
	TextField CurrentAdminRep = new TextField("CurrentAdminRep", byCSSSelector("#search_display_currentAdmissionsRepresentatives"));
	TextField SearchName = new TextField("SearchName", byCSSSelector("#search"));
	Checkbox Input = new Checkbox("Input", byXPath("//div/div[2]/cmc-grid/div/div/div[2]//input"));
	Button Select = new Button("Select button", byXPath("//div/button[. = 'Select']"));
	Button NewAdministrativeTaskSpan = new Button("NewAdministrativeTaskSpan", byXPath("//cmc-drop-down-list/div/div/span//span[2]"));
	Link NewAdministrativeTaskDropDown = new Link("NewAdministrativeTaskDropDown", byXPath("//span[. = '"+data.get("NewAdministrativeTask")+"']"));
	Button Next = new Button("Next", byXPath("//button[. = 'Next']"));
	Link QueueReassignProspects = new Link("QueueReassignProspects", byCSSSelector("#queueApproveButton"));
	Button Queue = new Button("Queue button", byXPath("//button[@id='saveSubmitBatchPackingJob']"));
	Link ReassignProspectsMessage = new Link("ReassignProspectsMessage", byXPath("//span[text()='The Reassign Prospect records were successfully queued.']"));
	
	
	
	SearchProcessess.waitTillElementClickable();
	SearchProcessess.click();
	SearchProcessess.clearAndType(data.get("SearchProcesses").toString());
	wait(3);
	ReassignProspectsSpan.click();
	wait(8);
	StartDate.click();
	StartDate.clearAndType(data.get("StartDate").toString());
	EndDate.click();
	EndDate.clearAndType(data.get("EndDate").toString());
	CurrentAdminRep.click();
	wait(5);
	SearchName.click();
	SearchName.clearAndType(data.get("AdminRep").toString());
	wait(3);
	Input.click();
	wait(2);
	Select.click();
	wait(3);
	scrollPage(0, 500);
	NewAdministrativeTaskSpan.click();
	wait(2);
	NewAdministrativeTaskDropDown.click();
	scrollPage(0, 200);
	Next.click();
	wait(7);
	QueueReassignProspects.click();
	wait(3);
	Queue.click();
	wait(6);
	CustomAsserts.containsString(ReassignProspectsMessage.getText(), data.get("ReassignProspectsMessage").toString());
	return this;
	
}


public StudentProcessessPage QueueRevenueRecognition(StringHash data) throws Exception{
	
	Link RevenueRecognitionSpan = new Link("RevenueRecognitionSpan", byXPath("//span[. = 'Revenue Recognition']"));
	TextField StartDateTableCell = new TextField("StartDateTableCell", byXPath("//td[3]"));
	TextField StartDate = new TextField("StartDateTableCell", byXPath("//span/input"));
	TextField EndDateTableCell = new TextField("EndDateTableCell", byXPath("//td[4]"));
	TextField EndDate = new TextField("EndDate", byXPath("//span/span/input"));
	Link QueueBatches = new Link("QueueBatches", byCSSSelector("#queueButton"));
	Button OpenBatches = new Button("OpenBatches", byXPath("//button[. = 'Open Batches']"));
	//Checkbox Input = new Checkbox("Input", byXPath("//td/label[. = '​']"));
	Checkbox Input = new Checkbox("Input", byXPath("(//label[@class='k-checkbox-label k-no-text'])[2]"));
	Link QueuePost = new Link("QueuePost", byXPath("//a[@id='queuePostButton']"));
	Button Queue = new Button("Queue", byXPath("//button[@id='openBatchNameJob']"));
	Link PostRevenueMessage = new Link("PostRevenueMessage", byXPath("//span[text()='Post Revenue were successfully queued.']"));
	
	
	SearchProcessess.waitTillElementClickable();
	SearchProcessess.click();
	SearchProcessess.clearAndType(data.get("SearchProcesses").toString());
	wait(3);
	RevenueRecognitionSpan.click();
	wait(8);
	StartDateTableCell.click();
	wait(3);
	StartDate.clearAndType(data.get("StartDate").toString());
	EndDateTableCell.click();
	wait(2);
	EndDate.clearAndType(data.get("EndDate").toString());
	wait(2);
	scrollPage(0, 500);
	QueueBatches.click();
	wait(10);
	OpenBatches.click();
	wait(7);
	Input.clickUsingJavaScriptExecutor();
	wait(2);
	QueuePost.click();
	wait(3);
	Queue.click();
	wait(5);
	CustomAsserts.containsString(PostRevenueMessage.getText(), data.get("PostRevenueMessage").toString());
	return this;
	
}

public StudentProcessessPage ApproveUnapprovedAid(StringHash data) throws Exception{
	
	
	Link ApprovePackagedAidSpan = new Link("ApprovePackagedAidSpan", byXPath("//span[. = 'Approve Packaged Aid']"));
	Button Next = new Button("Next", byXPath("//button[. = 'Next']"));
	Checkbox CheckAll = new Checkbox("CheckAll", byCSSSelector("#checkAll"));
	Checkbox StudentSelection1 = new Checkbox("StudentSelection1", byXPath("//tr[1]/td/input"));
	Checkbox StudentSelection2 = new Checkbox("StudentSelection2", byXPath("//tr[2]//input"));
	Checkbox StudentSelection3 = new Checkbox("StudentSelection3", byXPath("//tr[3]//input"));
	Checkbox StudentSelection4 = new Checkbox("StudentSelection4", byXPath("//tr[4]//input"));
	Checkbox StudentSelection5 = new Checkbox("StudentSelection5", byXPath("//tr[5]//input"));
	Link QueueApproveAid = new Link("QueueReassignProspects", byXPath("//a[@id='queueApproveButton']"));
	Button Queue = new Button("Queue", byXPath("//button[. = 'Queue']"));
	Link ApprovePackageSuccessMessageSpan = new Link("ApprovePackageSuccessMessageSpan", byXPath("//span[. = 'The Approve Packaged Aid records were successfully queued.']"));
	Button History = new Button("History", byXPath("//button[. = 'History']"));
	Link Reload = new Link("Reload", byXPath("//a[@title='Reload']"));
	Link BatchStatus = new Link("BatchStatus", byXPath("//tr[1]/td[12][. = ' Succeeded']"));
	Link ResultsArrowCollapse = new Link("ResultsArrowCollapse", byXPath("//div[@class='cmc-icons-arrow-right cmc-icons-md rotate up']"));
	
	
	
	SearchProcessess.waitTillElementClickable();
	SearchProcessess.click();
	SearchProcessess.clearAndType(data.get("SearchProcesses").toString());
	wait(3);
	ApprovePackagedAidSpan.click();
	waitForPageToLoad();
	scrollPage(0,600);
	Next.click();
	wait(7);
	scrollPage(0,400);
	wait(2);
	CheckAll.click();
	wait(3);
	StudentSelection1.click();
	wait(2);
	StudentSelection2.click();
	//wait(2);
	//StudentSelection3.click();
	//wait(2);
	//StudentSelection4.click();
	//wait(2);
	//StudentSelection5.click();
    //StudentSelection3.click();
	//wait(2);
	//StudentSelection4.click();
	//wait(2);
	//StudentSelection5.click();
	wait(2);
	ResultsArrowCollapse.click();
	wait(3);
	QueueApproveAid.click();
	wait(3);
	Queue.click();
	wait(10);
	CustomAsserts.containsString(ApprovePackageSuccessMessageSpan.getText(), data.get("ApprovePackageSuccessMessageSpan").toString());
	History.click();
	wait(6);
	Reload.click();
	wait(5);
	Reload.click();
	wait(2);
	Reload.click();
	CustomAsserts.containsString(BatchStatus.getText(), data.get("BatchStatus").toString());	
	return this;
	
}


public StudentProcessessPage PostFederalWorkDisbursements(StringHash data) throws Exception{
	

	Link PostWorkStudyDisbursements = new Link("PostWorkStudyDisbursements", byXPath("//span[. = 'Post Work Study Disbursements']"));
	Button ApplyFilters = new Button("ApplyFilters", byXPath("//button[. = 'Apply Filters']"));
	Link StudentName = new Link("StudentName", byXPath("//a[. = '"+data.get("StudentNameForWorkStudyDisbursements")+"']"));
	TextField HoursSpan = new TextField("HoursSpan", byXPath("//cmc-numeric-input-text[1]/div/div/span/span"));
	TextField HoursWorked = new TextField("HoursWorked", byCSSSelector("[name='hoursWorked']"));
	TextField AmountPaidSpan = new TextField("AmountPaidSpan", byXPath("//cmc-numeric-input-text[2]/div/div/span/span"));
	TextField AmountPaid = new TextField("AmountPaid", byCSSSelector("[name='amountPaid']"));
	Button Update = new Button("Update", byXPath("//button[. = 'Update']"));
	Link GrossAmountPaidValueAfterUpdate = new Link("GrossAmountPaidValueAfterUpdate", byXPath("//td[9][. = '"+data.get("GrossAmountPaid")+"']"));
	Button Save = new Button("Save", byXPath("//a[5][. = 'Save']"));
	Link DisbursementSuccessMessage = new Link("DisbursementSuccessMessage", byXPath("//span[. = 'The Post Work Study Disbursement records were successfully saved.']"));
	Button CampusSpan = new Button("CampusSpan", byXPath("//div[1]/cmc-drop-down-list/div/div/span//span[2]"));
	Link CampusValue = new Link("CampusValue", byXPath("//span[. = '"+data.get("Campus")+"']"));
	Button FundSourceSpan = new Button("FundSourceSpan", byXPath("//div[2]/cmc-drop-down-list/div/div/span//span[2]"));
	Link FundSourceValue = new Link("FundSourceValue", byXPath("//span[text()='"+data.get("FundSourceForDisbursements")+"']"));
	
	
	
	SearchProcessess.waitTillElementClickable();
	SearchProcessess.click();
	SearchProcessess.clearAndType(data.get("SearchProcesses").toString());
	wait(3);
	PostWorkStudyDisbursements.click();
	waitForPageToLoad();
	CampusSpan.click();
	wait(2);
	CampusValue.click();
	wait(2);
	FundSourceSpan.click();
	wait(2);
	FundSourceValue.click();
	wait(2);
	ApplyFilters.click();
	wait(5);
	StudentName.click();
	wait(5);
	HoursSpan.click();
	wait(2);
	HoursWorked.type(data.get("HoursWorked").toString());
	wait(2);
	AmountPaidSpan.click();
	wait(2);
	AmountPaid.type(data.get("GrossAmountPaid").toString());
	wait(2);
	Update.click();
	wait(5);
	scrollPage(200,0);
	CustomAsserts.containsString(GrossAmountPaidValueAfterUpdate.getText(), data.get("GrossAmountPaid").toString());
	Save.click();
	wait(10);
	CustomAsserts.containsString(DisbursementSuccessMessage.getText(), "The Post Work Study Disbursement records were successfully saved.".toString());
		
	return this;
	
}

public StudentProcessessPage ReleaseToGeneralLedger(StringHash data) throws Exception{
	
    
	Link ReleaseToGeneralLedger = new Link("ReleaseToGeneralLedger", byXPath("//span[. = 'Release to General Ledger']"));
	TextField CampusGroupSearch = new TextField("CampusGroupSearch", byXPath("//cmc-search-display/div/div"));
	TextField CampusGroup = new TextField("CampusGroup", byXPath("//input[@placeholder = 'Search Name']"));
	Checkbox Campus = new Checkbox("Campus", byXPath("//td/input"));
	Button Select = new Button("Select", byXPath("//button[. = 'Select']"));
	Button Cancel = new Button("Cancel", byXPath("(//button[text()='Cancel'])[1]"));
	TextField FromDate = new TextField("FromDate", byXPath("//input[@id='releaseToGLstartDate']"));
	TextField ToDate = new TextField("ToDate", byXPath("//input[@id='releaseToGLEndDate']"));
	Link QueueBatch = new Link("QueueBatch", byXPath("//a[. = 'Queue Batch']"));
	Button OpenBatches = new Button("OpenBatches", byXPath("//button[. = 'Open Batches']"));
	TextField SubmittedBy = new TextField("SubmittedBy", byXPath("//tr[1]/td[. = '"+data.get("SubmittedBy")+"']"));
	Link QueueRelease = new Link("QueueRelease", byXPath("//a[. = 'Queue Release']"));
	Button Submit = new Button("Submit", byXPath("//button[text()='Submit']"));
	Link ReleaseToGeneralLedgerMessage = new Link("ReleaseToGeneralLedgerMessage", byXPath("//u[contains(text(),'Release to General Ledger')]"));
	
	
	
	
	SearchProcessess.waitTillElementClickable();
	SearchProcessess.click();
	SearchProcessess.clearAndType(data.get("SearchProcesses").toString());
	wait(3);
	ReleaseToGeneralLedger.click();
	waitForPageToLoad();
	CampusGroupSearch.click();
	wait(5);
	CampusGroup.click();
	wait(2);
	CampusGroup.clearAndType(data.get("Campus").toString());
	wait(2);
	if(Campus.isSelected()){
		Cancel.click();
		TestReportsLog.log(LogStatus.INFO, "Campus group is already selected");
	}
	else {
		Campus.click();
		wait(2);
		Select.click();
	}
	wait(4);
	FromDate.click();
	wait(2);
	FromDate.clearAndType(data.get("FromDate").toString());
	wait(2);
	ToDate.click();
	wait(2);
	ToDate.clearAndType(data.get("ToDate").toString());
	wait(2);
	QueueBatch.click();
	waitForPageToLoad();
	OpenBatches.click();
	wait(10);
	CustomAsserts.containsString(SubmittedBy.getText(), data.get("SubmittedBy").toString());
	wait(2);
	QueueRelease.click();
	wait(3);
	Submit.click();
	wait(10);
	CustomAsserts.containsString(ReleaseToGeneralLedgerMessage.getText(), "Release to General Ledger".toString());
		
	return this;
	
}
public StudentProcessessPage ApproveFADisbursements(StringHash data) throws Exception{
	
    
	Link ApproveDisbursementsToPay = new Link("ApproveDisbursementsToPay", byXPath("//span[. = 'Approve Disbursements to Pay']"));
	Button CampusDropDown = new Button("CampusDropDown", byXPath("//div[1]/cmc-drop-down-list/div/div/span//span[2]"));
	Link CampusList = new Link("CampusList", byXPath("//span[. = '"+data.get("Campus")+"']"));
	TextField DisbursementFromDate = new TextField("DisbursementFromDate", byXPath("//input[@id='disbursementFromDateDatePicker']"));
	TextField DisbursementToDate = new TextField("DisbursementToDate", byXPath("//input[@id='disbursementToDateDatePicker']"));
	Link AwardYear = new Link("AwardYear", byXPath("//div[2]/cmc-multi-select[1]/div/div/div[1]/div[1]"));
	Link AwardYear1Value = new Link("AwardYear1Value", byXPath("//li[. = '"+data.get("AwardYear1")+"']"));
	Link AwardYear2Value = new Link("AwardYear2Value", byXPath("//li[. = '"+data.get("AwardYear2")+"']"));
	Link AwardYear3Value = new Link("AwardYear3Value", byXPath("//li[. = '"+data.get("AwardYear3")+"']"));
	TextField AwardLabel = new TextField("AwardLabel", byXPath("//div[2]/cmc-multi-select[1]//label"));
	Button FundTypeDropDown = new Button("FundTypeDropDown", byXPath("//div[3]/cmc-drop-down-list/div/div/span/span/span/span"));
	Link FundTypeValue = new Link("FundTypeValue", byXPath("//span[. = 'All Fund Sources']"));
	Button Next = new Button("Next", byXPath("//div[9]/div/button"));
	Link CheckBoxAll = new Link("CheckBoxAll", byXPath("//input[@id='checkAll']"));
	Link CheckBoxforDisburse = new Link("CheckBoxforDisburse", byXPath("//td/input"));
	Button ApproveToPost = new Button("ApproveToPost", byXPath("//a[@id='approveBatchButton']"));
	Button ApproveAll = new Button("ApproveAll", byXPath("//a[@id='approveAllButton']"));
	Button ApproveToPostConfirmation = new Button("ApproveToPostConfirmation", byXPath("//button[@id='approveBatchConfirmationOkButton']"));
	Link FADisbursementsSuccessMessage = new Link("FADisbursementsSuccessMessage", byXPath("//span[. = 'The approve disbursement were successfully Approved to Post.']"));
	
	
	SearchProcessess.waitTillElementClickable();
	SearchProcessess.click();
	SearchProcessess.clearAndType(data.get("SearchProcesses").toString());
	wait(3);
	ApproveDisbursementsToPay.click();
	waitForPageToLoad();
	CampusDropDown.click();
	wait(2);
	CampusList.click();
	wait(2);
	DisbursementFromDate.click();
	wait(2);
	DisbursementFromDate.clearAndType(data.get("FromDate").toString());
	wait(2);
	DisbursementToDate.click();
	wait(2);
	DisbursementToDate.clearAndType(data.get("ToDate").toString());
	wait(2);
	AwardYear.click();
	wait(2);
	AwardYear1Value.click();
	wait(1);
	AwardYear2Value.click();
	wait(1);
	AwardYear3Value.click();
	wait(1);
	AwardLabel.click();
	wait(1);
	FundTypeDropDown.click();
	wait(2);
	FundTypeValue.click();
	wait(7);
	scrollPage(0,300);
	wait(2);
	Next.click();
	waitForPageToLoad();
	CheckBoxAll.click();
	wait(2);
	CheckBoxforDisburse.click();
	wait(2);
	ApproveAll.click();
	wait(7);
	ApproveToPost.click();
	wait(5);
	ApproveToPostConfirmation.click();
	wait(10);
	CustomAsserts.containsString(FADisbursementsSuccessMessage.getText(), "The approve disbursement were successfully Approved to Post.".toString());		
	return this;
	
}	
}
