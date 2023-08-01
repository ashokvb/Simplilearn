package com.StudentPortal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.framework.elements.Locator.byXPath;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.framework.base.BasePage;
import com.framework.driver.DriverConfig;

import com.framework.base.BasePage;

import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class StudentLedgerAccountPage extends BasePage{
	
	static Link LedgerCard = new Link("Leadger card", byXPath("//span[text()='Ledger Card']"));
	static Link StipendSchedule = new Link("Leadger card", byXPath("//span[text()='Stipend Schedule']"));
	static Link Filtericon = new Link("Filter icon", byXPath("(//div[2]/a[2])[1]"));
	static Link ClearFilters= new Link("Clear Filters", byXPath("//div//a[. = 'Clear Filters']"));
	static AngDropDown Transaction = new AngDropDown("Transaction Date", byXPath("(//th[7]//span)[1]"));
	static AngDropDown TransactionDate = new AngDropDown("Transaction Date", byXPath("(//th[2]//span)[1]"));
	static AngDropDown Code = new AngDropDown("Code", byXPath("(//th[6]//span)[1]"));
	static Button FilterOptions = new Button("Filter options", byXPath("//span[text()='Filter']"));
	static AngDropDown Operator = new AngDropDown("Operator dropdown", byXPath("(//form/div/span[1]/span/span/span)[2]"));
	static Link SelectingOperator = new Link("Selecting operator", byXPath("//div/div/div//li[. = 'Contains']"));
	static TextField Value = new TextField("Enter filter value", byXPath("//input[@title='Value']"));
	//static TextField Value = new TextField("Enter filter value", byXPath("//form/div/input[1]"));
	static Button Filterbutton = new Button("Filter icon", byXPath("//button[text()='Filter']"));
	static Link Tablevalue= new Link("Table value", byXPath("(//tr[1]/td[1])[1]"));
	static Link Highligthing1= new Link("Highlighting record", byXPath("(//tr[1]/td[2])[1]"));
	static Link Highligthing= new Link("Highlighting record", byXPath("//tr[1]/td[2][text()='06/27/2022']"));
	static Link More= new Link("More", byXPath("//a[text()='More']"));
	static Link Void= new Link("Void", byXPath("//a[text()='Void']"));
	static TextField VoidNote = new TextField("Void note", byXPath("(//div/textarea[@aria-label='Note'])[4]"));
	static Button Voidbutton = new Button("Void button", byXPath("//button[@id='okVoidPayment']"));
	static Button Delete = new Button("Delete icon", byXPath("//a[text()='Delete']"));
	static TextField DeleteNote = new TextField("Delete note", byXPath("(//div/textarea[@aria-label='Note'])[1]"));
	static Button Deletebutton = new Button("Delete button", byXPath("//button[@id='okDelete']"));
	static Link SelectingTransaction = new Link("Selecting Student", byXPath("//td/a"));
	static Link TermList= new Link("Term list", byXPath("//div[@id='search_display_termId']"));
	static TextField SearchCode = new TextField("Search code", byXPath("//input[@placeholder='Search Code']"));
	static Button SelectButton = new Button("Select button", byXPath("//button[text()='Select']"));
	static Button CancelButton = new Button("Cancel button", byXPath("(//button[text()='Cancel'])[1]"));
	static Checkbox Term = new Checkbox("Selecting Term", byXPath("//input[@aria-label='2022FAR']"));
	static TextField TransactionAmount = new TextField("Transaction Amount", byXPath("//input[@id='transactionAmount']"));
	static TextField TransactionNote = new TextField("Transaction note", byXPath("(//div/textarea[@aria-label='Note'])[1]"));
	static Button SaveAndClose = new Button("Save & Close", byXPath("(//button[@aria-label='Save & Close'])[2]"));
	static Link TermValue= new Link("Term value", byXPath("//tr[1]/td[12]"));
	static Link PrintLedger = new Link("PrintLedger", byXPath("//a[@id='printLedgerButton']"));
	static TextField IncludeCourseDetail = new TextField("Include Course Detail", byXPath("//span[@aria-label='Include Course Detail: Dropdown']"));
	static Link SelectingIncCorDet= new Link("Selecting Include Course Detail", byXPath("(//li[text()='Yes'])[1]"));
	static Button PrintButton = new Button("Print button", byXPath("(//button[@id='okVoid'])[2]"));
	static Link PrintRegistrationBill = new Link("Print Registration Bill", byXPath("//a[@id='printRegistrationBillButton']"));
	static Button PrintDetail = new Button("Print Detail", byXPath("//button[@id='printRegBillDetail']"));
	static Button PrintSummary = new Button("Print Summary", byXPath("//button[@id='printRegBillSummary']"));
	static Button Cancel = new Button("Cancel", byXPath("(//button[text()='Cancel'])[16]"));
	static Link Printicon = new Link("Print icon", byXPath("//div[6]/table/tbody/tr/td/div/div[1]//span"));
	static Button PrintOK = new Button("Print Ok", byXPath("(//p[text()='Print'])[2]"));
	static Link PDFdownload = new Link("PDF download", byXPath("//a[text()='Click here to view the PDF of your report.']"));
	static Button Done = new Button("Done", byXPath("//p[text()='Done']"));
	static Button ApplyCreditsButton = new Button("Apply credits button", byXPath("//button[text()='Apply Credits']"));
	static Link TransatcionList = new Link("Transaction List", byXPath("//div/cmc-drop-down-list-classic/div/div/span/span/span[2]/span"));
	static Link TransatcionList1 = new Link("Transaction List", byXPath("//span[@aria-label='Transaction: Dropdown']"));
	static Link SelectingTransactionlist= new Link("Selecting transaction list", byXPath("//li[text()='Only Credits']"));
	static AngDropDown AmountappliedDrp = new AngDropDown("Amount applied dropdown", byXPath("//th[7]/a[1]"));
	static TextField Value1 = new TextField("Enter filter value1", byXPath("//input[@title='Value'][1]"));
	static Link HighlightingTransaction= new Link("Highlighting transaction", byXPath("(//tr/td[5])[1]"));
	static Link HighlightingCode= new Link("Highlighting Code", byXPath("(//tr/td[6])[1]"));
	static Button ApplyCredit= new Button("Apply credit button", byXPath("//a[@id='applyCredit']"));
	static Button ApplyAmountAll= new Button("Apply amount all", byXPath("//a[@id='applyAmountToAll']"));
	static Button ApplyButton= new Button("Apply Button", byXPath("//button[@id='autoApplySaveButton']"));
	static Button AddCharge= new Button("Add charger", byXPath("//a[@id='newChargeButton']"));
	static AngDropDown BillCode = new AngDropDown("Bill code", byXPath("//span[@aria-label='Bill Code: Dropdown']"));
	static TextField SearchBillCode = new TextField("Search Bill code", byXPath("//div[@id='billingTransactionCode-list']/span/input"));
	static Link SelectingBillCode= new Link("Selecting Bill Code", byXPath("//span[text()='100COURS']"));
	static TextField Amount = new TextField("Amount", byXPath("(//input[@aria-label='Amount'])[1]"));
	static Button Refunds = new Button("Refunds", byXPath("//button[text()='Refunds']"));
	static AngDropDown FundSource = new AngDropDown("Fund Source", byXPath("(//th[1]//span)[1]"));
	static AngDropDown AmountReceived = new AngDropDown("Fund Source", byXPath("(//th[4]//span)"));
	static Link SortDescending= new Link("Sort descending", byXPath("//span[. = 'Sort Descending']"));
	static AngDropDown AmountRefunded = new AngDropDown("Amount Refunded", byXPath("//th[5]/a/span"));
	static Button Next = new Button("Next button", byXPath("//button[text()='Next']"));
	static Link RefundOption = new Link("Refund option", byXPath("//span[@aria-label='Refund Option: Dropdown']"));
	static TextField TermId= new TextField("Term Id", byXPath("//input[@name='termId_input']"));
	static TextField DueDate= new TextField("Due Date", byXPath("//input[@id='dueDate']"));
	static Button PostSchedule = new Button("Post schedule", byXPath("(//button[@aria-label='Post/Schedule'])[2]"));
	static Link NewStipend = new Link("New Stipend", byXPath("//a[@id='newScheduledStipendButton']"));
	static Link FundSourceDrp = new Link("Refund option", byXPath("//span[@aria-label='Fund Source: Dropdown']"));
	static TextField SearchFundSource= new TextField("Due Date", byXPath("//input[@aria-owns='fundSourceId_listbox']"));
	//static Link SelectingFundSourceST= new Link("Selecting Term", byXPath("//span[text()='Cash Payment']"));
	static Link SelectingFundSourceST= new Link("Selecting Term", byXPath("/html[1]/body[1]/div[49]/div[1]/div[4]/ul[1]/li[1]/div[1]/span[1]"));
	static Link ReturnMethod = new Link("Return Method", byXPath("//span[@aria-label='Return Method: Dropdown']"));
	static TextField NetAmount= new TextField("Net Amount", byXPath("(//input[@aria-label='Net Amount'])[1]"));
	static TextField Datescheduled= new TextField("Date scheduled", byXPath("//input[@name='scheduledDate']"));
	static Button ScheduleOk = new Button("Schedule Ok", byXPath("//button[@id='scheduledStipendSaveButton']"));
	static AngDropDown ScheduledDate = new AngDropDown("Scheduled Date", byXPath("//th[3]/a[1]"));
	static Link HighlightingSchedule= new Link("Highlighting Schedule", byXPath("//td[3]"));
	static TextField SearchReturnMethod= new TextField("Search Return Method", byXPath("//input[@aria-owns='returnMethod_listbox']"));
	static Link Status = new Link("Status", byXPath("//span[@aria-label='Status: Dropdown']"));
	static Button Save = new Button("Save", byXPath("(//button[@aria-label='Save'])[2]"));
	static Button Override = new Button("Override", byXPath("//button[@id='AwardAmountWindowOkButton']"));
	static Button OverrideCancel = new Button("Override cancel", byXPath("//button[@id='AwardAmountWindowCancelButton']"));
	static Link SelectingReundOption= new Link("Selecting Refund Option", byXPath("//li[text()='Schedule Refund']"));
	static Link SelectingTerm= new Link("Selecting Term", byXPath("//span[text()='2022FAR']"));
	//--------Validation message-----
	static Link UpdatingTransactionMsg= new Link("Updating Ledger Transaction Msg", byXPath("//span[text()='The Transaction records were successfully saved.']"));
	static Link AlreadyVoidedMsg= new Link("Already Voided Msg", byXPath("//span[text()='The transaction cannot be voided because it is already voided.']"));
	static Link UpdatingVoidMsg= new Link("Updating Void Msg", byXPath("//span[text()='The Student Transaction records were successfully voided.']"));
	static Link DeletingTranMsg= new Link("DeletingvTransaction Msg", byXPath("//span[text()='The Student Transaction records were successfully deleted.']"));
	static Link PostingChargeMsg= new Link("Posting Charge Msg", byXPath("//span[text()='The Charge records were successfully saved.']"));
	static Link ApplyCreditMsg= new Link("Apply Credit Msg", byXPath("//span[text()='The Transaction records were successfully saved.']"));
	static Link SchldRefundMsg= new Link("Schedule Refund Msg", byXPath("//span[text()='The Refund records were successfully saved.']"));
	static Link SchlStipendMsg= new Link("Schedule Stipend Msg", byXPath("//span[text()='The Stipend records were successfully saved.']"));
	//
	static Button Filter1 = new Button("Click Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField SettingsValue = new TextField("Enter value", byXPath("(//input[@title=\"Value\"])[1]"));
    static Button SettingsFilterButton = new Button("Click Settings Filter", byXPath("//button[.=\"Filter\"]"));
    static Link HighlightingFundSource= new Link("Highlighting Fund Source", byXPath("(//tr[1]/td[1])[1]"));
    static Link HighlightingFundSource1= new Link("Highlighting Fund Source", byXPath("//td[6]/span[text()='0.00 ']"));

	
public StudentLedgerAccountPage AdjustLedgerTransaction(StringHash data) throws Exception {
		
		//Login Page Web Elements
		waitForPageToLoad();
		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		LedgerCard.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(10);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(10);
		Transaction.click();
		wait(2);
		Filter1.click();
		wait(2);
		SettingsValue.clearAndType(data.get("TransactionName"));
		//SettingsValue.clearAndType("Tuition");
		wait(2);
		Filterbutton.click();
		wait(2);
		SelectingTransaction.click();
		wait(4);
		TermList.click();
		wait(3);
		SearchCode.clearAndType(data.get("TermCode"));
		wait(4);
		if(Term.isSelected())
        {
            System.out.println("Term is already selected");
            CancelButton.clickUsingJavaScriptExecutor();
        }else {
            Term.clickUsingJavaScriptExecutor();
            wait(2);
            SelectButton.clickUsingJavaScriptExecutor();
        }
		wait(2);
		scrollPage(0, 300);
		TransactionNote.clearAndType(data.get("Note"));
		wait(2);
		scrollPage(0, -600);
		wait(2);
		SaveAndClose.click();
		wait(2);
		CustomAsserts.containsString(UpdatingTransactionMsg.getText(), data.get("UpdatingTransactionMsg").toString());
//		String TermName = TermValue.getText();
//		if(TermName.equalsIgnoreCase(data.get("TermCode")))
//		{
//			System.out.println("Changes are reflecting");
//		}else {
//			System.out.println("Changes are not reflecting");
//		}
		wait(2);
		return this;
		
	}
public StudentLedgerAccountPage AdjustLedgerTransactionVoid(StringHash data) throws Exception {

	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	//Login Page Web Elements
	waitForPageToLoad();
	setImplicitWaitTimeout(implicitWaitTimeout);
	//wait(20);
	StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	wait(1);
	LedgerCard.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(10);
	Filtericon.clickUsingJavaScriptExecutor();
	wait(1);
	ClearFilters.clickUsingJavaScriptExecutor();
	wait(5);
	scrollPage(0, 200);
	TransactionDate.click();
	wait(2);
	FilterOptions.click();
	wait(2);
	//Operator.clickUsingJavaScriptExecutor();
	//wait(1);
	//SelectingOperator.clickUsingJavaScriptExecutor();
	//wait(2);
	Value.clearAndType(data.get("TransactionDate"));
	wait(2);
	Filterbutton.click();
	wait(2);
	Highligthing1.click();
	wait(2);
	More.click();
	wait(2);
	Void.click();
	wait(2);
	VoidNote.sendKeys(data.get("VoidNotes"));
	wait(2);
	Voidbutton.clickUsingJavaScriptExecutor();
	//System.out.println("Void changes are updated");
	wait(2);
		//CustomAsserts.containsString(UpdatingVoidMsg.getText(), data.get("UpdatingVoidMsg").toString());
		CustomAsserts.containsString(AlreadyVoidedMsg.getText(), data.get("AlreadyVoidedMsg").toString());
	return this;
	
}

	public StudentLedgerAccountPage LedgerCardPrinting(StringHash data) throws Exception {

	Link SelectingIncCorDet= new Link("Selecting Include Course Detail", byXPath("(//li[text()='"+data.get("IncludeCourseDetail")+"'])[1]"));
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;	

	//Login Page Web Elements
	waitForPageToLoad();
	StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	wait(1);
	LedgerCard.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(10);
	Filtericon.clickUsingJavaScriptExecutor();
	wait(1);
	ClearFilters.clickUsingJavaScriptExecutor();
	wait(2);
	More.clickUsingJavaScriptExecutor();
	wait(1);
	PrintLedger.clickUsingJavaScriptExecutor();
	wait(2);
	IncludeCourseDetail.clickUsingJavaScriptExecutor();
	wait(1);
	SelectingIncCorDet.clickUsingJavaScriptExecutor();
	wait(2);
	PrintButton.clickUsingJavaScriptExecutor();
	wait(20);
	driver.switchTo().frame("reportViewer");
	Printicon.clickUsingJavaScriptExecutor();
	wait(2);
	PrintOK.click();
	wait(1);
	PDFdownload.click();
	wait(1);
	Done.click();
	wait(2);
	driver.switchTo().parentFrame();
	Cancel.clickUsingJavaScriptExecutor();
	wait(2);
	System.out.println("Ledger card detail print is successfull");
	return this;
}

	public StudentLedgerAccountPage LedgerCardPrintDetail(StringHash data) throws Exception {

	//Login Page Web Elements
	waitForPageToLoad();
	StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	wait(1);
	LedgerCard.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(10);
	Filtericon.clickUsingJavaScriptExecutor();
	wait(1);
	ClearFilters.clickUsingJavaScriptExecutor();
	wait(2);
	More.clickUsingJavaScriptExecutor();
	wait(2);
	PrintRegistrationBill.clickUsingJavaScriptExecutor();
	wait(1);
	PrintDetail.clickUsingJavaScriptExecutor();
	wait(18);
	driver.switchTo().frame("reportViewer");
	Printicon.clickUsingJavaScriptExecutor();
	wait(2);
	PrintOK.click();
	wait(1);
	PDFdownload.click();
	wait(1);
	Done.click();
	wait(2);
	driver.switchTo().parentFrame();
	Cancel.clickUsingJavaScriptExecutor();
	System.out.println("Ledger card detail printing is successfull");
	return this;
}
	
	public StudentLedgerAccountPage LedgerCardPrintSummary(StringHash data) throws Exception {

		//Login Page Web Elements
		waitForPageToLoad();
		wait(5);
		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		wait(1);
		LedgerCard.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(10);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(2);
		More.clickUsingJavaScriptExecutor();
		wait(2);
		PrintRegistrationBill.clickUsingJavaScriptExecutor();
		wait(1);
		PrintSummary.clickUsingJavaScriptExecutor();
		wait(20);
		driver.switchTo().frame("reportViewer");
		/*WebElement PrintIcon = driver.findElement(byXPath("//span[@id='ReportViewer1_ctl09_ctl06_ctl00_ctl00_ctl00']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(PrintIcon);
		actions.click();*/
		Printicon.clickUsingJavaScriptExecutor();
		wait(2);
		PrintOK.click();
		wait(1);
		PDFdownload.click();
		wait(1);
		Done.click();
		wait(2);
		driver.switchTo().parentFrame();
		Cancel.clickUsingJavaScriptExecutor();
		wait(2);
		System.out.println("Ledger card summary printing is successfull");
		return this;
	}
	
	public StudentLedgerAccountPage ApplyCreditLedger(StringHash data) throws Exception {

	Link SelectingTransactionlist= new Link("Selecting transaction list", byXPath("//li[text()='"+data.get("TransactionList")+"']"));
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;	
	waitForPageToLoad();
	StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	wait(1);
	LedgerCard.clickUsingJavaScriptExecutor();
	waitForPageToLoad();
	wait(10);
	ApplyCreditsButton.clickUsingJavaScriptExecutor();
	wait(5);
	TransatcionList1.clickUsingJavaScriptExecutor();
	wait(1);
	SelectingTransactionlist.clickUsingJavaScriptExecutor();
	wait(5);
	Filtericon.clickUsingJavaScriptExecutor();
	wait(1);
	ClearFilters.clickUsingJavaScriptExecutor();
	wait(2);
	AmountappliedDrp.click();
	wait(2);
	Filter1.click();
	wait(2);
	Value1.clearAndType("0");
	wait(2);
	Filterbutton.click();
	wait(2);
	HighlightingTransaction.click();
	wait(2);
	ApplyCredit.click();
	waitForPageToLoad();
	ApplyAmountAll.click();
	wait(1);
	ApplyButton.clickUsingJavaScriptExecutor();
	wait(2);
	CustomAsserts.containsString(ApplyCreditMsg.getText(), data.get("ApplyCreditMsg").toString());
	System.out.println("Credit applied successfully");

	return this;
}
	public StudentLedgerAccountPage LedgerCardPostCharge(StringHash data) throws Exception {
        Checkbox Term = new Checkbox("Selecting Term", byXPath("//input[@aria-label='"+data.get("TermCode")+"']"));
        Link SelectingBillCode= new Link("Selecting Bill Code", byXPath("//span[text()='"+data.get("BillCode")+"']"));
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
        //Login Page Web Elements
        waitForPageToLoad();
        //setImplicitWaitTimeout(implicitWaitTimeout);
        //wait(20);
        StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
        wait(1);
        LedgerCard.clickUsingJavaScriptExecutor();
        //setImplicitWaitTimeout(implicitWaitTimeout);
        wait(35);
        Filtericon.clickUsingJavaScriptExecutor();
        wait(1);
        ClearFilters.clickUsingJavaScriptExecutor();
        wait(2);
        AddCharge.click();
        wait(6);
        TermList.clickUsingJavaScriptExecutor();
        wait(3);
        SearchCode.clearAndType(data.get("TermCode"));
        wait(3);
        if(Term.isSelected())
        {
            System.out.println("Term is already selected");
            CancelButton.clickUsingJavaScriptExecutor();
        }else {
            Term.clickUsingJavaScriptExecutor();
            wait(2);
            SelectButton.clickUsingJavaScriptExecutor();
            //System.out.println("Task template is not matching");
        }
        wait(2);
        BillCode.click();
        wait(2);
        SearchBillCode.waitTillElementClickable();
        SearchBillCode.sendKeys(data.get("BillCode"));
        wait(2);
        SelectingBillCode.click();
        wait(3);
        Amount.sendKeys(data.get("Amount"));
        wait(5);
        scrollPage(0, -300);
        wait(1);
        SaveAndClose.click();
        wait(5);
        CustomAsserts.containsString(PostingChargeMsg.getText(), data.get("PostingChargeMsg").toString());
        Filtericon.clickUsingJavaScriptExecutor();
        wait(1);
        ClearFilters.clickUsingJavaScriptExecutor();
        wait(3);
        Code.click();
        wait(2);
        Filter1.click();
        wait(2);
        Value1.clearAndType(data.get("BillCode"));
        wait(2);
        Filterbutton.click();
        wait(2);
        String Code = HighlightingCode.getText();
        CustomAsserts.assertString(HighlightingCode.getText(), data.get("BillCode"));
        if(Code.equalsIgnoreCase(data.get("BillCode")))
        {
            System.out.println("Charge is posted successfully");
        }else {
            System.out.println("Charge is not posted successfully");
        }
        return this;

    }
	
	public StudentLedgerAccountPage AdjustLedgerTransactionDelete(StringHash data) throws Exception {

		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;

		//Login Page Web Elements
		waitForPageToLoad();
		//wait(20);
		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		wait(1);
		LedgerCard.clickUsingJavaScriptExecutor();
		//setImplicitWaitTimeout(implicitWaitTimeout);
		waitForPageToLoad();
		wait(10);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(6);
		Code.click();
		wait(2);
		Filter1.click();
		wait(2);
		Value1.clearAndType(data.get("BillCode"));
		wait(2);
		Filterbutton.click();
		wait(2);
		HighlightingCode.click();
		wait(2);
		More.click();
		wait(2);
		Delete.click();
		wait(2);
		DeleteNote.clearAndType(data.get("DeleteNote"));
		wait(2);
		Deletebutton.click();
		wait(2);
		CustomAsserts.containsString(DeletingTranMsg.getText(), data.get("DeletingTranMsg").toString());
		System.out.println("Charge is deleted successfully");
		return this;
		
	}
	
public StudentLedgerAccountPage ScheduleRefundLedgerCard(StringHash data) throws Exception {

		Link SelectingReundOption= new Link("Selecting Refund Option", byXPath("//li[text()='"+data.get("RefundOption")+"']"));
		Link SelectingTerm= new Link("Selecting Term", byXPath("//span[text()='"+data.get("TermCode")+"']"));
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		

		//Login Page Web Elements
		waitForPageToLoad();
		//wait(20);
		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		wait(1);
		LedgerCard.clickUsingJavaScriptExecutor();
		//setImplicitWaitTimeout(implicitWaitTimeout);
		waitForPageToLoad();
		wait(10);
		Refunds.click();
		wait(8);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(2);
		scrollPage(0, 300);
		//scrollPage(0, 200);
		FundSource.click();
		wait(2);
		Filter1.click();
		wait(2);
		Value1.clearAndType(data.get("FundSource"));
		wait(2);
		Filterbutton.click();
		wait(2);
		//AmountReceived.click();
		//wait(2);
		//SortDescending.click();
		//wait(2);
		String sRowValue = "0.00";
		WebElement mytable = driver.findElement(By.xpath("//table/tbody[@role='rowgroup']"));
		List< WebElement > rows_table = mytable.findElements(By.xpath("//table/tbody[@role='rowgroup']/tr"));
		int rows_count = rows_table.size();
		System.out.println(rows_count);
		List< WebElement > columnss_table = mytable.findElements(By.xpath("//table/tbody[@role='rowgroup']/tr[1]/td"));
		int columns_count = columnss_table.size();
		System.out.println(columns_count);
		for (int i = 1; i <= rows_count; i++) {
			String sValue = null;
			sValue = driver.findElement(By.xpath("//table/tbody[@role='rowgroup']/tr["+ i +"]/td[4]")).getText();
			System.out.println(sValue);
			NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
			Number number = format.parse(sValue);
			System.out.println(number);
			double value = number.doubleValue();
			System.out.println(value);
			if(value>0){
		    for(int column = 1; column <= columns_count; column++) {
		    	String sColumnValue= driver.findElement(By.xpath("//table/tbody[@role='rowgroup']/tr["+ column +"]/td[5]")).getText();
				System.out.println(sColumnValue);
				double Cvalue = Double.parseDouble(sColumnValue);
				if(Cvalue<value) {
				driver.findElement(By.xpath("//table/tbody[@role='rowgroup']/tr[" + i + "]/td["+ column +"]")).click();	
				break;
		    }
		}break;
			}
			}
		//System.out.println(columns_count);
//		HighlightingFundSource.click();
		wait(2);
		Next.click();
		wait(2);
		RefundOption.click();
		wait(1);
		SelectingReundOption.click();
		wait(3);
		TermId.clearAndType(data.get("TermCode"));
		wait(2);
		SelectingTerm.click();
		wait(1);
		DueDate.sendKeys(data.get("DueDate"));
		wait(2);
		Amount.sendKeys(data.get("Amount"));
		wait(2);
		PostSchedule.click();
		//wait(4);
		//Override.click();
		wait(2);
		CustomAsserts.containsString(SchldRefundMsg.getText(), data.get("SchldRefundMsg").toString());
		//OverrideCancel.click();
		//wait(2);
		System.out.println("Schedule refund is successfully");
		return this;
		
	}


public StudentLedgerAccountPage ScheduleStipend(StringHash data) throws Exception {
	Link SelectingTerm= new Link("Selecting Term", byXPath("//span[text()='"+data.get("TermCode")+"']"));
	Link SelectingReturnMethod= new Link("Selecting Return Method", byXPath("//li[text()='"+data.get("ReturnMethod")+"']"));
	Link SelectingStatus= new Link("Selecting Status", byXPath("//li[text()='"+data.get("Status")+"']"));
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	
	//Login Page Web Elements
	waitForPageToLoad();
	//wait(20);
	StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	wait(1);
	StipendSchedule.clickUsingJavaScriptExecutor();
	//setImplicitWaitTimeout(implicitWaitTimeout);
	wait(35);
	NewStipend.click();
	wait(2);
	FundSourceDrp.click();
	wait(1);
	//SearchFundSource.clearAndType(data.get("FundSource"));
	SearchFundSource.click();
	wait(2);
	SelectingFundSourceST.click();
	wait(2);
	TermId.clearAndType(data.get("TermCode"));
	wait(1);
	SelectingTerm.click();
	wait(2);
	ReturnMethod.click();
	wait(1);
	SearchReturnMethod.clearAndType(data.get("ReturnMethod"));
	wait(2);
	SelectingReturnMethod.click();
	wait(2);
	Datescheduled.clearAndType(data.get("DateScheduled"));
	wait(2);
	NetAmount.sendKeys(data.get("Amount"));
	wait(3);
	ScheduleOk.click();
	wait(2);
	Status.clickUsingJavaScriptExecutor();
	wait(1);
	SelectingStatus.click();
	wait(2);
	scrollPage(0, -200);
	wait(1);
	Save.click();
	wait(2);
	CustomAsserts.containsString(SchlStipendMsg.getText(), data.get("SchlStipendMsg").toString());
	System.out.println("Schedule stipend is successfully");
	scrollPage(0, 300);
	wait(10);
	ScheduledDate.click();
	wait(1);
	Filter1.click();
	wait(2);
	Value.sendKeys(data.get("DateScheduled"));
	wait(2);
	Filterbutton.click();
	wait(2);
	String DateScheduled = HighlightingSchedule.getText();
	System.out.println(DateScheduled);
	if(DateScheduled.equalsIgnoreCase(data.get("DateScheduled")))
	{
		System.out.println("Schedule stipend is save successfully");
	}else {
		System.out.println("Schedule stipend is not saved");
	}
	return this;
}

}
