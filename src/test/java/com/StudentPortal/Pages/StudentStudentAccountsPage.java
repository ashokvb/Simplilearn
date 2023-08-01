package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byName;

import java.util.concurrent.TimeUnit;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class StudentStudentAccountsPage extends BasePage{
	
	//New Ledger Payment Elements
	
	static Button FilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
	static Button ClearFiltersButton = new Button("Click Filter Button", byId("listClearFiltersButton"));
	static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
	static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
	static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
	static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
	static Link StudentAccounts = new Link("Click Student Accounts", byXPath("(//li[@role=\"menuitem\"])[6]"));
	static Link LedgerCard = new Link("Click Ledger Card", byXPath("//li[6]/div/div[1]/div"));
	static Link NewPaymentButton = new Link("Click New", byId("newPaymentButton"));
	static TextField Password = new TextField("Enter Password", byId("password"));
	static Button OkCashier = new Button("Click OK", byId("cashierIDCheckAuthenticate"));
	static AngDropDown PaymentType = new AngDropDown("Enter Payment Type", byXPath("//span[@aria-owns=\"paymentMethod_listbox\"]"));
	//static Button SelectCashPaymentType = new Button("Select Cash Payment Type", byXPath("//li[.=\"Cash Payment\"]"));
	//static Button ScheduledFA = new Button("Select Scheduled FA Payment Type", byXPath("//li[.=\"Scheduled FA Disbursements/Student Cash Payments\"]"));
	//static Button UnscheduledPayment = new Button("Select Unscheduled Payment Payment Type", byXPath("//li[.=\"Unscheduled Payment\"]"));
	static Link ClickTermList = new Link("Click New", byId("search_display_termId"));
	static TextField EnterTerm = new TextField("Enter Term", byId("search"));
    //Checkbox checkboxTerm = new Checkbox("Check the term", byXPath("//input[@aria-label='"+data.get("Term Code")+"']"));
	static TextField SelectPaymentMethod = new TextField("Select Payment Method", byXPath("//li[@class=\"k-item k-state-focused k-state-hover\"]"));
	static Button SelectButton = new Button("Click Select", byXPath("//button[.=\"Select\"]"));
	static TextField PaymentName = new TextField("Enter Payment Name", byId("transactionName"));
	static Button PaymentMethod = new Button("Enter Payment Method", byXPath("//span[@aria-label=\"Payment Method: Dropdown\"]"));
	static TextField EnterPaymentMethod = new TextField("Enter Payment Method", byXPath("//input[@aria-owns=\"paymentType_listbox\"]"));
	//static Button ClickPaymentMethod =  new Button("Click Payment Method", byXPath("//li[.='"+data.get("Payment Method")+"']"));
	static Button BankAccount = new Button("Click Bank Account", byXPath("//span[@aria-owns=\"bankAccountId_listbox\"]"));
	static TextField SelectBankAccount = new TextField("Select Bank Account", byXPath("//input[@aria-owns=\"bankAccountId_listbox\"]"));
	//static Button SelectBankAccount = new Button("Select Bank Account", byXPath("//span[.='"+data.get("Bank Name")+"']"));
	static Link ClickTermSpan = new Link("Click Term Span",byId("search_display_termId"));
	static TextField EnterTermCode = new TextField("Enter Term Code", byId("search"));
	static Link SelectTerm = new Link("Select Term Code", byXPath("//input[@aria-label=\"NANDA\"]"));	
	static Button Selecttab = new Button("Click Select", byXPath("//button[.=\"Select\"]"));
	static Button CashPaymentCode = new Button("Click Cash Payment Code", byXPath("//span[@aria-label=\"Cash Payment Code: Dropdown\"]"));
	static TextField EnterCashPaymentCode = new TextField("Enter Cash Payment Code", byXPath("//input[@aria-owns=\"transactionNameDropDown_listbox\"]"));
	//static TextField SelectCashPaymentCode = new TextField("Select Cash Payment Code", byXPath("//span[.=\"STUDENT\"]"));
	static Button CashDrawerSession = new Button("Cash Drawer Session", byXPath("//span[@aria-label=\"Cash Drawer Session: Dropdown\"]"));
	//static TextField SelectCashDrawerSession = new TextField("Select Cash Drawer Session", byXPath("//span[.="KHARRISON"]"));
	static TextField PaymentAmount = new TextField("Enter Payment Amount", byXPath("//input[1][@aria-label=\"Amount\"]"));
	static TextField TransactionDate = new TextField("Enter Transaction Amount", byId("transactionDate"));
	static Button PVDropDown = new Button("Click Program Drop down", byXPath("(//span[@class=\"caret\"])[1]"));
	//  New Ledger Charge Web elements	
	static Link charge = new Link("Click Charge Button", byId("newChargeButton"));
	static Button ChargeAYSpan = new Button("Click Academic Year Span", byXPath("//span[@aria-label=\"Academic Year: Dropdown\"]"));	
	static Link BillCodeSpan = new Link("Click Bill Code Span", byXPath("//span[@aria-owns=\"billingTransactionCode_listbox\"]"));
	static TextField EnterBillCode = new TextField("Enter Bill Code", byXPath("//input[@aria-owns=\"billingTransactionCode_listbox\"]"));
	static TextField EnterAmount = new TextField("Enter Charge Amount", byXPath("//input[1][@aria-label=\"Amount\"]"));
	static TextField TransDate = new TextField("Enter Trnasaction date", byId("transactionDate"));
	static Button SaveClose = new Button("Click Save and Close", byXPath("(//button[@aria-label=\"Save & Close\"])[2]"));	
	// New Ledger Refund Web elements	
	static Link ButtonRefundTab = new Link("Click Refund tab",byXPath("//li[@aria-controls=\"Refunds\"]"));
	static Button RefundDropdown = new Button("Click Refund drop down", byXPath("//div[2]/a[@class=\"k-button k-split-button-arrow\"]"));
	static Button RefundFilter = new Button("Click Refund Filter", byXPath("//a[.=\"Clear Filters\"]"));
	static AngDropDown FSdropdown = new AngDropDown("Click Fund Source drop down", byXPath("(//a[@title=\"Column Settings\"])[1]"));
	static Button FSFilter = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
	static TextField FSValue = new TextField("Enter value", byXPath("//input[@title=\"Value\"]"));
	static Button FSFilterButton = new Button("Click Filter Button", byXPath("//button[.=\"Filter\"]"));
	//static Button HighlightFundSource = new Button("HighLight Fund Source", byXPath("//td[.=\"Cash Payment from Student\"]"));
	static Button FSNext = new Button("Click Next",byXPath("//button[text()=\"Next\"]"));
	static Button RefundOption = new Button("Click Refund Option", byXPath("(//span[@class=\"k-dropdown-wrap k-state-default\"])[6]"));
	static Button SelectRefundOption = new Button("Select Refund Option", byXPath("//li[.=\"Post Directly to Ledger Card (No Check Required)\"]"));
	static Button AYSpan = new Button("Click Academic Year", byXPath("//span[@aria-label=\"Academic Year: Dropdown\"]"));
	static Button SelectAYSpan = new Button("Select AY Start Date", byXPath("//span[.=\"07/01/2022\"]"));
	static TextField EnterrefundTerm = new TextField("Enter Term", byXPath("//input[@aria-label=\"termId\" and @aria-owns=\"termId_listbox\"]"));
	static TextField RefundDateSent = new TextField("Enter Due Date", byName("dateSend"));
	static TextField RefundName = new TextField("Enter Refund Name", byXPath("//input[@aria-label=\"Refund Name\"]"));
	static Button ReturnMethod = new Button("Click Return Method", byXPath("//span[@aria-label=\"Return Method: Dropdown\"]"));
	static TextField EnterReturnMethod = new TextField("Enter Return Method", byXPath("//input[@aria-owns=\"returnMethod_listbox\"]"));
	static TextField RefundAmount = new TextField("Enter Refund", byXPath("//input[1][@aria-label=\"Amount\"]"));
	static Button RefundSaveClose = new Button("Click Save and Close", byXPath("(//button[@aria-label=\"Post/Schedule\"])[2]"));
	static Button RefundBankAccount = new Button("Click Bank Account", byXPath("//span[@aria-label=\"Bank Account: Dropdown\"]"));
	static TextField EnterRefundBankAccount = new TextField("Enter Refund Bank Account", byXPath("//input[@aria-owns=\"bankAccountId_listbox\"]"));
	static TextField RefundTransactionDate = new TextField("Enter Refund Transaction Date", byName("transactionDate"));
	
	//Stipend Schedule Web Elements
	static Link StipendSchedule = new Link("Click Stipend Schedule", byXPath("//li[6]/div/div[8]/div"));
	static Button FAStudentAY = new Button("Click FA Student AY", byXPath("//span[@aria-label=\"FA Student AY: Dropdown\"]"));
	static TextField TotalAmount = new TextField("Enter Total Amount", byXPath("//input[1][@aria-label=\"Total Amount\"]"));
	static Button Status = new Button("Click Status", byXPath("//span[@aria-label=\"Status: Dropdown\"]"));
	//static Button SelectApproved = new Button("Select Status", byXPath("//li[.=\"Approved\"]"));
	static TextField NoOfStipends = new TextField("Enter Number of Stipends", byXPath("//input[1][@aria-label=\"Number of Stipends\"]"));
	static TextField FirstScheduledDate = new TextField("Enter First Scheduled Date", byId("firstPaymentDate"));
	static Button Calculate = new Button("Click Calculate Button", byId("calculateScheduledStipendButton"));
	static Link SelectLinkFundSource = new Link("Click Select Fund Source", byXPath("//a[.=\"<Select>\"]"));
	static Button FundSourceSpan = new Button("Click Fund Source Span", byXPath("//span[@aria-label=\"Fund Source: Dropdown\"]"));
	static TextField EnterFundSource = new TextField("Enter Fund Source", byXPath("//input[@aria-owns=\"fundSourceId_listbox\"]"));
	//static TextField EnterFundSource = new TextField("Enter Fund Source", byXPath("//input[@aria-owns=\"fundSourceId_listbox\"]"));
	//static Button SelectFundSource = new Button("Select Fund source", byXPath("//span[.=\"Direct PLUS Loan\"]"));
	static TextField DateScheduled = new TextField("Enter Date Scheduled", byName("scheduledDate"));
	static Button Ok = new Button("Click Ok", byId("scheduledStipendSaveButton"));
	static Button Save = new Button("Click Save", byXPath("(//button[@aria-label=\"Save\"])[2]"));
	static TextField StipendAmount = new TextField("Enter Stipend Amount", byXPath("//input[1][@aria-label=\"Net Amount\"]"));
	
	//TC848_Post an FA Disbursement for a Student Web Elements
	static Button ScheduledDisburdementSpan = new Button("Click Scheduled Disbursement", byId("search_display_scheduledPaymentId"));
	static TextField EnterFundSourceName = new TextField("Enter Fund Source", byId("search"));

	public StudentStudentAccountsPage newLedgerCharge (StringHash data) throws Exception {
		
		//Checkbox CheckTerm = new Checkbox("Check the term", byXPath("//input[@aria-label='"+data.get("TermCode")+"']"));
		Button SelectBillCode = new Button("Select Bill Code", byXPath("//span[@title='"+data.get("BillCode")+"']"));
		Button AcademicYear = new Button("Select Academic Year", byXPath("//span[@title='"+data.get("AYStartDate")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Charge records were successfully saved.']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		waitForPageToLoad();
		StudentAccounts.waitTillElementClickable();
		StudentAccounts.click();
		wait(3);
		LedgerCard.waitTillElementClickable();
		LedgerCard.click();
		waitForPageToLoad();
		wait(5);
		charge.waitTillElementClickable();
		charge.click();
		waitForPageToLoad();
		ChargeAYSpan.click();
		wait(2);
		AcademicYear.click();
		wait(2);
		ClickTermSpan.click();
		wait(10);
		EnterTermCode.clearAndType(data.get("TermCode"));
		wait(5);
		SelectTerm.click();
		wait(2);
		Selecttab.waitTillElementClickable();
		Selecttab.click();
		wait(2);
		BillCodeSpan.waitTillElementClickable();
		BillCodeSpan.click();
		wait(2);
		EnterBillCode.waitTillElementFound();
		EnterBillCode.sendKeys(data.get("BillCode"));
		wait(4);
		SelectBillCode.click();
		wait(2);
		EnterAmount.sendKeys(data.get("ChargeAmount"));
		wait(4);
		TransDate.clearAndType(data.get("TransactionDate"));
		wait(2);
		scrollPage(0, -300);
		wait(2);
		SaveClose.waitTillElementClickable();
		SaveClose.click();
		wait(10);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;
	}
	public StudentStudentAccountsPage NewLedgerRefund(StringHash data) throws Exception {
		
		Button HighlightFundSource = new Button("HighLight Fund Source", byXPath("//td[.='"+data.get("FundSourceName")+"']"));
		Button SelectAYSpan = new Button("Select AY Start Date", byXPath("//span[.='"+data.get("AYStartDate")+"']"));
		Button SelectTermCode = new Button("Select Term Code", byXPath("//span[.='"+data.get("TermCode")+"']"));
		Button SelectReturnMethod = new Button("Select Return Method", byXPath("//li[.='"+data.get("ReturnMethod")+"']"));
		Button SelectRefundBA = new Button("Select Refund Bank Account", byXPath("//li/div/span[.='"+data.get("BankAccount")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Refund records were successfully saved.']"));
		
		waitForPageToLoad();
		StudentAccounts.waitTillElementClickable();
		StudentAccounts.click();
		wait(3);
		LedgerCard.waitTillElementClickable();
		LedgerCard.click();
		wait(20);
		waitForPageToComplete();
		ButtonRefundTab.waitTillElementClickable();
		ButtonRefundTab.click();
	    wait(5);
	    /*	RefundDropdown.waitTillElementClickable();
		RefundDropdown.click();
		wait(4);
		RefundFilter.click();
		wait(2);
	    */
		FSdropdown.waitTillElementClickable();
		FSdropdown.click();
		wait(2);
		FSFilter.click();
		wait(2);
		FSValue.clearAndType(data.get("FundSourceName"));
		wait(2);
		FSFilterButton.click();
		wait(5);
		HighlightFundSource.waitTillElementFound();
		HighlightFundSource.click();
		wait(5);
		scrollPage(0, 200);
		wait(2);
		FSNext.waitTillElementClickable();
		FSNext.click();
		wait(2);
		scrollPage(0, 300);
		wait(2);
		RefundOption.click();
		wait(2);
		SelectRefundOption.click();
		wait(2);
		EnterrefundTerm.sendKeys(data.get("TermCode"));
		wait(5);
		SelectTermCode.click();
		wait(2);
		RefundDateSent.sendKeys(data.get("RefundDateSent"));
		wait(2);
		scrollPage(0, 300);
		wait(2);
		RefundName.clearAndType(data.get("RefundName").toString());
		wait(4);
		ReturnMethod.click();
		wait(2);
		EnterReturnMethod.clearAndType(data.get("ReturnMethod"));
		wait(2);
		SelectReturnMethod.click();
		wait(2);
		RefundBankAccount.click();
		wait(2);
		EnterRefundBankAccount.clearAndType(data.get("BankAccount"));
		wait(2);
		SelectRefundBA.click();
		wait(2);
		RefundTransactionDate.clearAndType(data.get("RefundTransactionDate"));
		wait(2);
		RefundAmount.sendKeys(data.get("RefundAmount"));
		wait(2);
		RefundSaveClose.waitTillElementClickable();
		RefundSaveClose.click();
		wait(5);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;
	}
	
	public StudentStudentAccountsPage ScheduleStipendPage(StringHash data) throws Exception {
		
		Button SelectAwardYear = new Button("Select Bill Code", byXPath("//span[.='"+data.get("AcademicYearStartDate")+"']"));
		Button SelectStatus = new Button("Select Status", byXPath("//li[.='"+data.get("Status")+"']"));
		Button SelectFundSource = new Button("Select Fund source", byXPath("//span[.='"+data.get("FundSource")+"']"));
		Button SelectReturnMethod = new Button("Select Return Method", byXPath("//li[.='"+data.get("ReturnMethod")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Stipend records were successfully saved.']"));
		
		waitForPageToLoad();
		StudentAccounts.click();
		wait(2);
		StipendSchedule.click();
		waitForPageToLoad();
		wait(5);
		scrollPage(0, -300);
		wait(2);
		FAStudentAY.click();
		wait(2);
		SelectAwardYear.click();
		wait(5);
		TotalAmount.sendKeys(data.get("TotalAmount"));
		wait(2);
		Status.click();
		wait(2);
		SelectStatus.click();
		wait(2);
		NoOfStipends.sendKeys(data.get("NoOfStipends"));
		wait(2);
		FirstScheduledDate.clearAndType(data.get("FirstScheduledDate"));
		wait(2);
		scrollPage(0, 500);
		Calculate.click();
		wait(4);
		SelectLinkFundSource.click();
		waitForPageToLoad();
		wait(2);
		FundSourceSpan.click();
		wait(4);
		EnterFundSource.clearAndType(data.get("FundSource"));
		wait(4);
		SelectFundSource.click();
		wait(4);
		DateScheduled.clearAndType(data.get("DateScheduled"));
		wait(2);
		ReturnMethod.click();
		wait(2);
		EnterReturnMethod.clearAndType(data.get("ReturnMethod"));
		wait(2);
		SelectReturnMethod.click();
		wait(2);
		StipendAmount.sendKeys(data.get("StipendAmount"));
		wait(2);
		Ok.click();
		wait(2);
		scrollPage(0, -500);
		wait(2);
		Save.click();
		wait(10);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;
	}
	
public StudentStudentAccountsPage LedgerPaymentPage(StringHash data) throws Exception {
		
		Checkbox ReceiptPrint = new Checkbox("Print Checkbox", byXPath("//input[@id='isPrinted']"));
		Button SelectCashPaymentType = new Button("Select Cash Payment Type", byXPath("//li[.='"+data.get("PaymentType")+"']"));
		Checkbox SelectTerm = new Checkbox("Check Term Code", byXPath("//input[@aria-label='"+data.get("TermCode")+"']"));
		TextField SelectCashPaymentCode = new TextField("Select Cash Payment Code", byXPath("//span[.='"+data.get("CashPaymentCode")+"']"));
		Button ClickPaymentMethod =  new Button("Click Payment Method", byXPath("//li[.='"+data.get("PaymentMethod")+"']"));
		TextField SelectCashDrawerSession = new TextField("Select Cash Drawer Session", byXPath("//span[.='"+data.get("CashDrawerSession")+"']"));
		Button PaymentAYSpan = new Button("Click AY Span", byXPath("//span[@aria-label=\"Academic Year: Dropdown\"]"));
		Button AcademicYear = new Button("Select Academic Year", byXPath("//span[@title='"+data.get("AYStartDate")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Transaction records were successfully saved.']"));
		TextField CashierNo = new TextField("Cashier Number", byXPath("//input[@id='checkNumber']"));
		
		wait(10);
		StudentAccounts.click();
		wait(2);
		LedgerCard.click();
		waitForPageToLoad();
		wait(10);
		NewPaymentButton.clickUsingJavaScriptExecutor();
		wait(2);
		Password.clearAndType(data.get("Password"));
		wait(2);
		OkCashier.click();
		waitForPageToLoad();
		PaymentType.click();
		wait(2);
		SelectCashPaymentType.click();
		wait(2);
		PaymentAYSpan.click();
		wait(2);
		AcademicYear.click();
		wait(2);
		//scrollPage(0, 500);
		ClickTermList.click();
		wait(2);
		EnterTerm.clearAndType(data.get("TermCode"));
		wait(2);
		SelectTerm.check();
		wait(2);
		Selecttab.click();
		wait(2);
		CashPaymentCode.click();
		wait(2);
		EnterCashPaymentCode.clearAndType(data.get("CashPaymentCode"));
		wait(2);
		SelectCashPaymentCode.click();
		wait(2);
		PaymentMethod.click();
		wait(2);
		EnterPaymentMethod.clearAndType(data.get("PaymentMethod"));
		wait(2);
		ClickPaymentMethod.click();
		wait(2);
		CashDrawerSession.click();
		wait(2);
		SelectCashDrawerSession.click();
		wait(2);
		PaymentAmount.sendKeys(data.get("PaymentAmount"));
		wait(2);
		CashierNo.sendKeys(data.get("CashierNo"));
		wait(2);
		TransactionDate.clearAndType(data.get("TransactionDate"));
		wait(2);
		if (ReceiptPrint.isSelected()) {
			ReceiptPrint.uncheck();
//		}else {
//			ReceiptPrint.check();
		}
		wait(2);
		scrollPage(0, -500);
		SaveClose.click();
		wait(10);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(5);
		return this;
		
	}
	
public StudentStudentAccountsPage LedgerFADisbursementPage(StringHash data) throws Exception {
		
		Checkbox PrintReceipt = new Checkbox("Print Checkbox", byXPath("//input[@aria-label=\"Print Receipt\"]"));
		Button SelectCashPaymentType = new Button("Select Cash Payment Type", byXPath("//li[.=\"Scheduled FA Disbursements/Student Cash Payments\"]"));
		Checkbox SelectTerm = new Checkbox("Check Term Code", byXPath("//input[@aria-label='"+data.get("TermCode")+"']"));
		Button ClickPaymentMethod =  new Button("Click Payment Method", byXPath("//li[.='"+data.get("PaymentMethod")+"']"));
		TextField SelectCashDrawerSession = new TextField("Select Cash Drawer Session", byXPath("//span[.='"+data.get("CashDrawerSession")+"']"));
		Checkbox SelectFundSource = new Checkbox("Check Term Code", byXPath("(//input[@aria-label='"+data.get("FundSource")+"'])[1]"));
		Button AcademicYear = new Button("Select Academic Year", byXPath("//span[@title='"+data.get("AYStartDate")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Transaction records were successfully saved.']"));
		
		wait(10);
		StudentAccounts.click();
		wait(2);
		LedgerCard.click();
		waitForPageToLoad();
		wait(10);
		NewPaymentButton.clickUsingJavaScriptExecutor();
		wait(4);
		Password.clearAndType(data.get("Password"));
		wait(2);
		OkCashier.click();
		waitForPageToLoad();
		ChargeAYSpan.click();
		wait(2);
		AcademicYear.click();
		wait(2);
		PaymentType.click();
		wait(2);
		SelectCashPaymentType.click();
		wait(2);
		ScheduledDisburdementSpan.click();
		wait(10);
		EnterFundSourceName.clearAndType(data.get("FundSource"));
		wait(5);
		SelectFundSource.check();
		wait(5);
		Selecttab.click();
		wait(5);
		scrollPage(0, 300);
		wait(2);
		ClickTermList.click();
		wait(2);
		EnterTerm.clearAndType(data.get("TermCode"));
		wait(2);
		SelectTerm.check();
		wait(2);
		Selecttab.click();
		wait(2);
		PaymentMethod.click();
		wait(2);
		EnterPaymentMethod.clearAndType(data.get("PaymentMethod"));
		wait(2);
		ClickPaymentMethod.click();
		wait(2);
		CashDrawerSession.click();
		wait(2);
		SelectCashDrawerSession.click();
		wait(2);
		scrollPage(0, 300);
		wait(2);
		TransactionDate.clearAndType(data.get("TransactionDate"));
		wait(2);
		if (PrintReceipt.isSelected()) {
			PrintReceipt.check();
		}
		else
			wait(2);
		scrollPage(0, -500);
		wait(2);
		SaveClose.click();
		wait(10);
		//CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		//wait(5);
		return this;	
	}
}	
	

	
	

