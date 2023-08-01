package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;


import static com.framework.elements.Locator.byCSSSelector;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byName;


public class StudentFinancialAidPage extends BasePage{

	//WebElements of financial Aid 
	static Link FinancialAid = new Link("Click Financial Aid", byXPath("(//li[@role=\"menuitem\"])[5]"));
	static Link Awarding = new Link("Clicl Tasks", byXPath("//li[5]/div/div[1]/div"));
	static AngDropDown Awarddropdown = new AngDropDown("Click Awards Drop Down", byXPath("//div[2]/cns-grid/div[1]/cns-grid-toolbar/cmc-common-toolbar/div/div[2]/a[2]"));
	static Button AwardClearFilter = new Button("Click Clear Filter", byXPath("//div//a[. = 'Clear Filters']"));
	static AngDropDown FSdropdown = new AngDropDown("Click Fund Source drop down", byXPath("(//a[@title=\"Column Settings\"])[1]"));
	static Button FSFilter = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
	static AngDropDown ClickEqualsTo = new AngDropDown("Click Equals To", byXPath("//div/span[1]/span/span[. = 'Is equal to']"));
	static Button ClickContains = new Button("Click Contains", byXPath("//div/div/div//li[. = 'Contains']"));
	static TextField FSValue = new TextField("Enter value", byXPath("//input[@title=\"Value\"]"));
	static Button FSFilterButton = new Button("Click Filter Button", byXPath("//button[.=\"Filter\"]"));
	//static Button HighlightFundSource = new Button("HighLight Fund Source", byXPath("//td[.=\"Cash Payment from Student\"]"));	
	static Button Awards = new Button("Click Awards", byXPath("//button[.=\"Awards\"]"));
	//FAReassignment Web Elements
	//Checkbox CheckFundSource = new Checkbox("Check Fund Source", byXpath("//input[@aria-label="PELL"]"));
	static Link Reassign = new Link("Click Reassign", byId("awardReassignButton"));
	//static Button HighlightAcademicYear = new Button("Highlight Academic Year", byXPath("//td[. = '01/08/2018']"));
	static Button OkReassign = new Button("Click Reassign", byId("okTransferSectionr"));
	static Button ConfirmReassign = new Button("Confirm Reassign", byId("reassignConfirmDialogOkButton"));
	static Button AYSpan = new Button("Click Academic Year Span", byXPath("//span[@aria-label=\"Academic Year: Dropdown\"]"));	
	//Award Summary Print Web Elements
	static Button PrintButton = new Button("Click Print Button", byId("printButton"));
	//Verify Disbursement Data Web Elements
	Button PaymentReceived = new Button("Click Payment Received tab", byXPath("//button[.=\"Payments Received\"]"));
	//Creation of Academic Year
	static Button AcademicYear = new Button("Click Academic Year", byXPath("//button[.=\"Academic Years\"]"));
	static Link NewAY = new Link("Click New AY", byId("newButton"));
	static Button Manual = new Button("Click Manual", byId("autoAwardingYearDialogNotOkButton"));
	static TextField AYStartdate = new TextField("Enter AY startdate", byId("startDate"));
	static TextField AYEnddate = new TextField("Enter AY Enddate", byId("endDate"));
	static Button AwardYearSpan = new Button("Award Year Span", byXPath("//span[@aria-label=\"Award Year1: Dropdown\"]"));
	static TextField EnterAwardYear = new TextField("Enter Award Year", byXPath("//input[@aria-owns=\"firstAwardYear_listbox\"]"));
	//static Button SelectAwardYear = new Button("Select Award Year", byXPath("(//li[text()=\"2022-23\"])[1]"));
	static Button GradeLevelSpan = new Button("Click Grade Level Span", byXPath("//span[@aria-label=\"Grade Level: Dropdown\"]"));
	static TextField EnterGradeLevel = new TextField("Enter Grade Level", byXPath("//input[@aria-owns=\"gradeLevelId_listbox\"]"));
	//static Button SelectGradeLevel = new Button("Select Grade Level", byXPath("//span[.=\"1st Year Freshman\"]"));
	static TextField WeeksinAY = new TextField("Enter Weeks in AY", byId("weeksInAcademicYear"));
	static TextField MonthsinAY = new TextField("Enter Months in AY", byId("monthsIncademicYear"));
	static Button HousingSpan = new Button("Click Housing Span", byXPath("//span[@aria-label=\"Housing: Dropdown\"]"));
	static TextField EnterHousing = new TextField("Enter Housing", byXPath("//input[@aria-owns=\"housingStatusCode_listbox\"]"));
	//static Button SelectHousing = new Button("Select Housing", byXPath("//div/span[.=\"Off Campus\"]"));
	static Button FAAdvisorSpan = new Button("FAAdvisor", byXPath("//span[@aria-label=\"Financial Aid Advisor: Dropdown\"]"));
	static TextField EnterAdvisor = new TextField("Enter Advisor", byXPath("//input[@aria-owns=\"financialAidAdvisor_listbox\"]"));
	//static Button SelectAdvisor = new Button("Select Advisor", byXPath("(//div/span[.=\"R P, Nandakumara\"])[1]"));
	static Button PackagingStatus = new Button("Click Packing Status", byXPath("aria-label=\"Award Year 1 Packaging Status: Dropdown\""));
	static TextField EnterPackagingStatus = new TextField("Enter Packaging Status", byXPath("//input[@aria-owns=\"awardYear1PackageStatus_listbox\"]"));
	//static Button SelectPackagingStatus = new Button("Select Packaging Status", byXPath("(//span[.=\"04 - Ready to Package\"])[1]"));
	static Button BudgetSpan = new Button("Click Budget Span", byXPath("//span[@aria-owns=\"budgetId_listbox\"]"));
	static TextField EnterBudget = new TextField("Enter Budget", byXPath("//input[@aria-owns=\"budgetId_listbox\"]"));
	//static Button SelectBudget = new Button("Select Budget", byXPath("//div/span[.=\"2022_Tuition\"]"));
	static Button Calculate = new Button("Calculate", byXPath("//button[.=\"Calculate\"]"));
	static Button AYSave = new Button("Click Save", byXPath("(//button[@aria-label=\"Save\"])[2]"));
	

public StudentFinancialAidPage FinancialAidReassignment(StringHash data) throws Exception{
		
		
		Checkbox CheckFundSource = new Checkbox("Check Fund Source", byXPath("//input[@aria-label='"+data.get("FundSource")+"']"));
		// Button HighlightAcademicYear = new Button("Highlight Academic Year", byXPath("//td[. = '"+data.get("StartDate")+"']"));
		Button HighlightStartDate = new Button("Highlight Academic Year", byXPath("//td[. = '"+data.get("ReassignAYStartDate")+"']"));
		Button SelectAcademicYear = new Button("Select Academic Year", byXPath("//span[.='"+data.get("AYStartDate")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Reassign records were successfully saved.']"));
		
		waitForPageToLoad();
		FinancialAid.click();
		wait(2);
		Awarding.click();
		waitForPageToLoad();
		wait(10);
		Awards.click();
		wait(15);
		AYSpan.click();
		wait(2);
		SelectAcademicYear.click();
		wait(5);
		Awarddropdown.click();
		wait(2);
		AwardClearFilter.click();
		wait(4);
		FSdropdown.click();
		wait(2);
		FSFilter.click();
		wait(2);
		ClickEqualsTo.click();
		wait(2);
		ClickContains.click();
		wait(2);
		FSValue.clearAndType(data.get("FundSource"));
		wait(2);
		FSFilterButton.click();
		wait(4);
		CheckFundSource.check();
		wait(5);
		Reassign.click();
		waitForPageToLoad();
		wait(10);
		HighlightStartDate.click();
		wait(10);
		OkReassign.click();
		wait(10);
		ConfirmReassign.click();
		wait(10);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;
	}

	public StudentFinancialAidPage PrintAwardSummaryPage(StringHash data) throws Exception{
		
		Checkbox CheckFundSource = new Checkbox("Check Fund Source", byXPath("//input[@aria-label='"+data.get("FundSource")+"']"));
		Button HighlightAcademicYear = new Button("Select Academic Year", byXPath("//span[@title='"+data.get("AYStartDate")+"']"));
		
		waitForPageToLoad();
		FinancialAid.click();
		wait(2);
		Awarding.click();
		waitForPageToLoad();
		wait(10);
		Awards.click();
		wait(15);
		AYSpan.clickUsingJavaScriptExecutor();
		wait(4);
		HighlightAcademicYear.clickUsingJavaScriptExecutor();
		wait(5);
		Awarddropdown.click();
		wait(2);
		AwardClearFilter.click();
		wait(4);
		FSdropdown.click();
		wait(2);
		FSFilter.click();
		wait(2);
		ClickEqualsTo.click();
		wait(2);
		ClickContains.click();
		wait(2);
		FSValue.clearAndType(data.get("FundSource"));
		wait(2);
		FSFilterButton.click();
		wait(4);
		CheckFundSource.check();
		wait(5);
		PrintButton.click();
		wait(10);
		return this;
}
	public StudentFinancialAidPage VerifyDisbursementDataPage(StringHash data) throws Exception{
		
		Checkbox ClickFundSource = new Checkbox("Click Fund Source", byXPath("//a[.='"+data.get("SelectFundSource")+"']"));
		Button HighlightAcademicYear = new Button("Select Academic Year", byXPath("//span[@title='"+data.get("AYStartDate")+"']"));
		TextField CheckTransactionDate = new TextField("Check Transaction Date", byXPath("//td[text()=\"08/08/2022\"]"));
		
		waitForPageToLoad();
		FinancialAid.click();
		wait(2);
		Awarding.click();
		waitForPageToLoad();
		wait(10);
		Awards.click();
		wait(15);
		AYSpan.clickUsingJavaScriptExecutor();
		wait(4);
		HighlightAcademicYear.clickUsingJavaScriptExecutor();
		wait(5);
		Awarddropdown.click();
		wait(2);
		AwardClearFilter.click();
		wait(4);
		FSdropdown.click();
		wait(2);
		FSFilter.click();
		wait(2);
		ClickEqualsTo.click();
		wait(2);
		ClickContains.click();
		wait(2);
		FSValue.clearAndType(data.get("FundSource"));
		wait(2);
		FSFilterButton.click();
		wait(4);
		ClickFundSource.check();
		wait(10);
		scrollPage(0, 1000);
		wait(2);
		PaymentReceived.click();
		wait(10);
		scrollPage(0, 300);
		if (CheckTransactionDate.isElementPresent()) {
			System.out.print("Disbursement Data Verification is successful");  
		}  
		else
			System.out.print("Disbursement data is not found");  
		wait(5);
		return this;	
	}
	
public StudentFinancialAidPage AcademicYearPage(StringHash data) throws Exception{
		
		Button SelectAwardYear = new Button("Select Award Year", byXPath("(//li[text()='"+data.get("AwardYear")+"'[1]"));
		Button SelectGradeLevel = new Button("Select Grade Level", byXPath("//span[.='"+data.get("GradeLevel")+"']"));
		Button SelectHousing = new Button("Select Housing", byXPath("//div/span[.='"+data.get("Housing")+"']"));
		Button SelectAdvisor = new Button("Select Advisor", byXPath("(//div/span[.='"+data.get("FAAdvisor")+"'[1]"));
		Button SelectPackagingStatus = new Button("Select Packaging Status", byXPath("(//span[.='"+data.get("PackagingStatus")+"'[1]"));
		Button SelectBudget = new Button("Select Budget", byXPath("//div/span[.='"+data.get("SelectBudget")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Student Academic Year records were successfully saved.']"));
		
		
		waitForPageToLoad();
		FinancialAid.click();
		wait(2);
		Awarding.click();
		waitForPageToLoad();
		AcademicYear.click();
		wait(10);
		NewAY.click();
		Manual.click();
		wait(10);
		AYStartdate.clearAndType(data.get("AYStartDate"));
		AYEnddate.clearAndType(data.get("AYEndDate"));
		scrollPage(0, 500);
		AwardYearSpan.click();
		EnterAwardYear.clearAndType(data.get("AwardYear"));
		GradeLevelSpan.click();
		EnterGradeLevel.clearAndType(data.get("GradeLevel"));
		SelectGradeLevel.click();
		WeeksinAY.clearAndType(data.get("WeeksinAY"));
		MonthsinAY.clearAndType(data.get("MonthsinAY"));
		HousingSpan.click();
		EnterHousing.clearAndType(data.get("Housing"));
		FAAdvisorSpan.click();
		EnterAdvisor.clearAndType(data.get("FAAdvisor"));
		scrollPage(0, 500);
		PackagingStatus.click();
		EnterPackagingStatus.clearAndType(data.get("PackagingStatus"));
		SelectPackagingStatus.click();
		BudgetSpan.click();
		EnterBudget.clearAndType(data.get("Budget"));
		SelectBudget.click();
		Calculate.click();
		wait(5);
		scrollPage(0, -1000);
		wait(5);
		AYSave.click();
		wait(10);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;
	}

public StudentFinancialAidPage CreatingFundSource(StringHash data) throws Exception{

	Link Awarding = new Link("Awarding", byXPath("//span[text()='Awarding']"));
	Button Awards = new Button("Awards", byXPath("//button[text()='Awards']"));
	Link PackagingMethod = new Link("Packaging Method", byXPath("//span[@aria-label='Packaging Method: Dropdown']"));
	TextField SearchPackingMethod = new TextField("Search Packing Method", byXPath("//input[@aria-owns='packageMethod_listbox']"));
	Link SelectingPackingMethod = new Link("Selecting Packaging Method", byXPath("//span[text()='"+data.get("PackagingMethod")+"']"));
	Link TypeOfAid = new Link("Type of Aid", byXPath("//span[@aria-label='Type of Aid: Dropdown']"));
	TextField SearchTypeOfAid = new TextField("Search Type of Aid", byXPath("//input[@aria-owns='typeOfAidId_listbox']"));
	Link SelectingTypeOfAid = new Link("Selecting Type of Aid", byXPath("//li[text()='"+data.get("TypeofAid")+"']"));
	Link Source = new Link("Source", byXPath("//span[@aria-label='Source: Dropdown']"));
	TextField SearchSource = new TextField("Search Source", byXPath("//input[@aria-owns='sourceId_listbox']"));
	Link SelectingSource = new Link("Selecting Source", byXPath("//span[text()='"+data.get("Source")+"']"));
	TextField GrossAmount = new TextField("Gross Amount", byXPath("(//input[@aria-label='Gross Amount'])[1]"));
	Button Proceed = new Button("Proceed", byXPath("//button[text()='Proceed']"));
	Link Status = new Link("Status", byXPath("//span[@aria-label='Status: Dropdown']"));
	TextField SearchStatus = new TextField("Search Source", byXPath("//input[@aria-owns='statusNewAid_listbox']"));
	Link SelectingStatus = new Link("Selecting Source", byXPath("//li[text()='"+data.get("Status")+"']"));
	Button SaveAndClose = new Button("Save And CLose", byXPath("//a[@id= 'cashOthersSaveCloseButton']"));
	Button UpdateSave = new Button("Update and Save", byXPath("//button[@id='commonValidationDialogCashOtherOkButton']"));
	Button DontSave = new Button("Dont update and Save", byXPath("//button[@id='commonValidationDialogCashOtherNotOkButton']"));
	Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Cash/Other fund source records were successfully saved.']"));
	TextField Number = new TextField("Number", byXPath("(//input[@aria-label='Number'])[1]"));
	Button Calculate = new Button("Calculate", byXPath("//a[@id='calculateButton']"));
	TextField SearchStatus1 = new TextField("Search Status", byXPath("//input[@aria-owns='Status_listbox']"));
	Link SelectingStatus1 = new Link("Selecting Source", byXPath("//span[text()='"+data.get("Status")+"']"));

	waitForPageToLoad();
	StudentStudentPage.FinancialAid.click();
	wait(2);
	Awarding.click();
	//waitForPageToLoad();
	wait(10);
	Awards.click();
	wait(15);
	PackagingMethod.click();
	wait(2);
	SearchPackingMethod.sendKeys(data.get("PackagingMethod"));
	wait(1);
	SelectingPackingMethod.click();
	wait(2);
	StudentStudentPage.NewButton.click();
	waitForPageToLoad();
	TypeOfAid.click();
	wait(1);
	SearchTypeOfAid.sendKeys(data.get("TypeofAid"));
	wait(2);
	SelectingTypeOfAid.click();
	wait(2);
	Source.click();
	wait(1);
	SearchSource.sendKeys(data.get("Source"));
	wait(2);
	SelectingSource.click();
	wait(2);
	Status.click();
	wait(2);
	SearchStatus.sendKeys(data.get("Status"));
	wait(2);
	SelectingStatus.click();
	wait(2);
	GrossAmount.sendKeys(data.get("GrossAmount"));
	wait(2);
	Proceed.click();
	wait(25);
	Status.click();
	wait(2);
	SearchStatus1.sendKeys(data.get("Status"));
	wait(2);
	SelectingStatus1.click();
	wait(2);
	Number.sendKeys(data.get("Number"));
	wait(2);
	Calculate.click();
	wait(2);
	scrollPage(0, -300);
	wait(2);
	SaveAndClose.click();
	wait(2);
	//DontSave.click();
	wait(2);
	CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());

	return this;
}
}
