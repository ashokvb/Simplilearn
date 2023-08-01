package com.StudentPortal.Pages;


import static com.framework.elements.Locator.byId;


import static com.framework.elements.Locator.byXPath;

import java.util.concurrent.TimeUnit;


import static com.framework.elements.Locator.byXPath;


import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class StudentSubsidiaryPage extends BasePage{
	
	static Link Subsidiary = new Link("Subsidiary", byXPath("//div/span[. = 'Subsidiary']"));
	static TextField Amount = new TextField("Amount subsidiary", byXPath("(//input[@aria-label='Amount'])[1]"));
	static TextField SubsidiaryNote = new TextField("Transaction note", byXPath("(//div/textarea[@aria-label='Note'])[1]"));
	static Link FectingAmount = new Link("Fetching amount", byXPath("//tr[1]/td[9]"));
	static TextField SubsidiaryVoidNote = new TextField("Subsidiary Void note", byXPath("//textarea[@id='studentTransactionVoidPaymentNote']"));
	static Link ExporttoExcelorPDF = new Link("Export to excel or pdf", byXPath("//a[@title='Export to Excel or PDF']"));
	static Link PDFExport = new Link("Export to pdf", byXPath("//a[text()='PDF (All Results)']"));
	static Link addcharge = new Link("Click on Add charge", byXPath("//a[@id='newChargeButton']"));
	static Link AcademicYear = new Link("Enter Academic Year", byXPath("//span[@aria-label='Academic Year: Dropdown']"));
	static TextField Billcode = new TextField("Enter Billcode", byXPath("//span[@aria-label='Bill Code: Dropdown']"));
	static Link SelAcademicyear = new Link("Click on AcademicYear", byXPath("//span[@title=\"1\"]"));
	static Link SelBillcode = new Link("Click on BC", byXPath("//span[text()='REG']"));
	static Button AddSubsidiary = new Button("Add subsidiary", byXPath("//div/div[1]/button"));
	static AngDropDown SubsidiaryList = new AngDropDown("Subsidiary List", byXPath("(//div/cmc-drop-down-list-classic/div/div/span/span)[2]"));
	static TextField SubsidiarySearch = new TextField("Subsidiary Search", byXPath("/html/body/div[47]/div/span/input"));  
	static Link SelectingSubsidiary = new Link("Selecting Subsidiary", byXPath("//span[. = ' LAPTOPDE ']")); 
	static TextField MaintainedBalance = new TextField("Maintained Balance", byXPath("(//input[@aria-label='Maintained Balance'])[1]"));
	static Button Save = new Button("Save button", byXPath("//button[@id='maintainedBalanceSaveButton']"));
	static Link GettingSubsidiaryName = new Link("Getting subsidiary Name", byXPath("//div/cmc-drop-down-list-classic/div/div/span/span/span[2]/span"));
	static Link FetchingSubsidiaryName = new Link("Fetching subsidiary name", byXPath("//div/cmc-drop-down-list-classic/div/div/span/span"));
	static Link Filtericon = new Link("Filter icon", byXPath("(//div[2]/a[2])[1]"));
	static Link ClearFilters= new Link("Clear Filters", byXPath("//div//a[. = 'Clear Filters']"));
	static AngDropDown Transactionlist = new AngDropDown("Transaction list", byXPath("//th[7]//span"));
	static Link FilterOptions = new Link("Filter options", byXPath("//span[text()='Filter']"));
	static Link Operator = new Link("Operator dropdown", byXPath("//form/div[1]/span[1]/span"));
	static Link SelectingOperator = new Link("Selecting operator", byXPath("//div/div/div//li[. = 'Contains']"));
	static TextField Value = new TextField("Enter filter value", byXPath("(//input[@title='Value'])[2]"));
	//static TextField Value = new TextField("Enter filter value", byXPath("//form/div/input[1]"));
	static Button Filterbutton = new Button("Filter icon", byXPath("(//button[text()='Filter'])[2]"));
	static Link Tablevalue= new Link("Table value", byXPath("(//tr[1]/td[1])[1]"));
	static Link TermList= new Link("Term list", byXPath("//div[@id='search_display_termId']"));
	static TextField SearchCode = new TextField("Search code", byXPath("//input[@placeholder='Search Code']"));
	static Link SelectingTransaction = new Link("Selecting Transaction", byXPath("//span[. = 'Student Payment on SL ']"));
	static Checkbox Term = new Checkbox("Selecting Term", byXPath("//input[@aria-label='2022FAR']"));
	static Button SelectButton = new Button("Select button", byXPath("//button[text()='Select']"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("(//button[@aria-label= 'Save & Close'])[2]"));
	static Link TermValue= new Link("Term value", byXPath("//tr[1]/td[12]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Link StudentAccounts = new Link("Click on StudentAccounts", byXPath("//span[@class='k-link k-header k-state-selected']"));
    static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link SelSubsidery = new Link("Select Subsidery", byXPath("//span[@aria-label='Subsidiary: Dropdown']"));
	static Link ClkSubsidery = new Link("Click Subsidery", byXPath("//span[@title=' NewTestSub2 ']"));
	static TextField EntMaintainedBalance = new TextField("Enter Maintained Balance", byXPath("//span[@class='k-numeric-wrap k-state-default k-expand-padding']"));
	static TextField SubSave = new TextField("click Save", byXPath("//button[@id='maintainedBalanceSaveButton']"));
	static TextField SearchBillcode = new TextField("Enter Billcode", byXPath("//span[@class='k-list-filter']"));
	static Button ClsFilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class='k-button k-split-button-arrow'])[1]"));
	static Link ClsClearFiltersButton = new Link("Click Filter Button", byXPath("//div//a[. = 'Clear Filters']"));
	static AngDropDown TeDropDown = new AngDropDown("Click Term Number Dropdown", byXPath("(//span[@class='k-icon k-i-more-vertical'])[2]"));
	static AngDropDown TrDropDown = new AngDropDown("Click Term Number Dropdown", byXPath("(//span[@class='k-icon k-i-more-vertical'])[8]"));
    static Button TerNumFilter = new Button("Click Term Num Filter", byXPath("//span[.='Filter']"));
    static TextField Cvalue = new TextField("Enter Value", byXPath("(//input[@title='Value'])[3]"));
    static Button CFilterButton = new Button("Click Filter Button", byXPath("//button[text()='Filter']"));
    static Checkbox SelCharge = new Checkbox("Click Term Button", byXPath("//tr/td[6]"));
    static Link More= new Link("More", byXPath("//a[text()='More']"));
    static Button Delete = new Button("Delete icon", byXPath("//a[text()='Delete']"));
    static TextField DeleteNote = new TextField("Delete note", byXPath("(//div/textarea[@aria-label='Note'])[1]"));
    static Button Deletebutton = new Button("Delete button", byXPath("//button[@id='okDelete']"));
    static TextField VoidNote = new TextField("VoidNote", byXPath("(//div/textarea[@id=\"studentTransactionVoidPaymentNote\"])[1]"));
    static Button VoidButton = new Button("Void button", byXPath("//button[@id='okVoidPayment']"));
    static Button Void = new Button("Void icon", byXPath("//a[text()='Void']"));
    static TextField PaymentName = new TextField("PaymentName", byXPath("//input[@name='paymentName']"));
    static Link PaymentMethod = new Link("PaymentMethod", byXPath("//span/span/span[. = 'Check']"));
    static Link SelPaymentMethod = new Link("SelPaymentMethod", byXPath("//li[. = 'Cash']"));
    static Link CashDrawer = new Link("CashDrawer", byXPath("//cmc-drop-down-list-classic[3]/div/div/span/span/span/span"));
    static Link SelCashDrawer = new Link("SelCashDrawer", byXPath("//span[. = 'NANDA']"));
    static TextField Amount1 = new TextField("Amount", byXPath("(//input[@aria-label='Amount'])[1]"));
    static Checkbox printreciept = new Checkbox("Click printreciept", byXPath("//cmc-checkbox[3]//label"));
    static Link Payment = new Link("Payment", byXPath("//a[6][. = 'Payment']"));
    static TextField Password = new TextField("Password", byXPath("//input[@id='password']"));
    static Button Ok = new Button("ok", byXPath("//button[text()='OK']"));
    static Button Refund = new Button("Refund", byXPath("//button[. = 'Refunds']"));
    static Link RefundSource = new Link("RefundSource", byXPath("//td[. = 'NewTestSub1']"));
    static Button Nextt = new Button("Nextt", byXPath("//button[. = 'Next']"));
    static Link TermField = new Link("TermField", byXPath("//div/cmc-drop-down-list/div/div/span/span/span/span"));
    static Link SelTermField = new Link("SelTermField", byXPath("//span[. = '010322']"));
    static TextField DueDate = new TextField("DueDate", byXPath("(//input[@placeholder=\"MM/DD/YYYY\"])[2]"));
    static Button PostSchedule = new Button("PostSchedule", byXPath("(//button[@aria-label=\"Post/Schedule\"])[2]"));
    
	public StudentSubsidiaryPage AdjustSubTransaction(StringHash data) throws Exception {
		Link AdjustSubMsg= new Link("Adjust Subsidiary Msg", byXPath("//span[text()='The Transaction records were successfully saved.']"));
		
		//Login Page Web Elements
		waitForPageToLoad();
		setImplicitWaitTimeout(implicitWaitTimeout);
		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		Subsidiary.clickUsingJavaScriptExecutor();
		wait(25);
		GettingSubsidiaryName.click();
		wait(2);
		SelectingSubsidiary.click();
		wait(3);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(2);
		//Transactionlist.clickUsingJavaScriptExecutor();
		//wait(2);
		//FilterOptions.clickUsingJavaScriptExecutor();
		//wait(1);
		//Operator.clickUsingJavaScriptExecutor();
		//wait(1);
		//SelectingOperator.clickUsingJavaScriptExecutor();
		//wait(2);
		//Value.type("Student");
		//wait(2);
		//Filterbutton.clickUsingJavaScriptExecutor();
		//wait(2);
		SelectingTransaction.clickUsingJavaScriptExecutor();
		wait(5);
		TermList.clickUsingJavaScriptExecutor();
		wait(4);
		SearchCode.clearAndType(data.get("TermCode"));
		wait(3);
		Term.clickUsingJavaScriptExecutor();
		wait(1);
		SelectButton.click();
		wait(2);
		SubsidiaryNote.clearAndType("updated changes");
		wait(2);
		SaveAndClose.clickUsingJavaScriptExecutor();
		wait(2);
		CustomAsserts.containsString(AdjustSubMsg.getText(), data.get("AdjustSubMsg").toString());
		String TermName = TermValue.getText();
		if(TermName.equalsIgnoreCase(data.get("TermCode")))
		{
			System.out.println("Subsidiary Changes are reflecting");
		}else {
			System.out.println("Subsidiary Changes are not reflecting");
		}
		return this;
	}
		
	public StudentSubsidiaryPage PrintSubsidiaryLedger(StringHash data) throws Exception {
			
			Link SelectingSubsidiary = new Link("Selecting Subsidiary", byXPath("//span[. = '"+data.get("Subsidiary")+"']"));
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			//Login Page Web Elements
			waitForPageToLoad();
			setImplicitWaitTimeout(implicitWaitTimeout);
			StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
			Subsidiary.clickUsingJavaScriptExecutor();
			wait(25);
			GettingSubsidiaryName.click();
			wait(2);
			SelectingSubsidiary.click();
			wait(3);
			ExporttoExcelorPDF.clickUsingJavaScriptExecutor();
			wait(1);
			PDFExport.clickUsingJavaScriptExecutor();
			System.out.println("Subsidiary ledger is printed successfully");
			return this;
	}
       	
        public StudentSubsidiaryPage AddSubsidiary(StringHash data) throws Exception {
        	Link AddSubMsg= new Link("Add Subsidiary Msg", byXPath("//span[text()='The Student Subsidiary records were successfully saved.']"));

        	Link SelectingNewSubsidiary = new Link("Selecting Subsidiary", byXPath("//span[. = '"+data.get("NewSubName")+"']")); 
        	Link SelectingNewSubsidiaryCode = new Link("Selecting Subsidiary", byXPath("//span[. = '"+data.get("NewSubCode")+"']")); 
			//Login Page Web Elements
			waitForPageToLoad();
			setImplicitWaitTimeout(implicitWaitTimeout);
			StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
			Subsidiary.clickUsingJavaScriptExecutor();
			wait(25);
			AddSubsidiary.clickUsingJavaScriptExecutor();
			wait(3);
			SubsidiaryList.clickUsingJavaScriptExecutor();
			wait(2);
			SelectingNewSubsidiary.clickUsingJavaScriptExecutor();
			wait(2);
			MaintainedBalance.sendKeys(data.get("MaintainedBalance"));
			wait(2);
			Save.clickUsingJavaScriptExecutor();
			wait(5);
			CustomAsserts.containsString(AddSubMsg.getText(), data.get("AddSubMsg").toString());
			GettingSubsidiaryName.click();
			wait(2);
			SelectingNewSubsidiaryCode.click();
			wait(1);
			String NewSubName = FetchingSubsidiaryName.getText();
			System.out.println(NewSubName);
			if(NewSubName.contains(data.get("NewSubName")))
			{
				System.out.println("New subsidiary is added successfully");
			}else {
				System.out.println("New subsidiary is not added");
			}
			return this;
	}
      
     public StudentSubsidiaryPage PostCharge(StringHash data) throws Exception {


    	 Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
 		
 		//Login Page Web Elements
 		waitForPageToLoad();
 		MenuButton.click();
 		wait(5);
 		Students.click();
 		//waitForPageToLoad();
 		wait(20);
 		FilterDropDwon.click();
 		wait(1);
 		ClearFiltersButton.click();
 		waitForPageToLoad();
 		wait(15);
 		StuNumDropDown.click();
 		waitForPageToLoad();
 		wait(1);
 		StuNumFilter.click();
 		waitForPageToLoad();
 		wait(1);
 		value.clearAndType(data.get("Student Number"));
 		waitForPageToLoad();
 		wait(1);
 		FilterButton.click();
 		wait(10);
 		ClickStudentName.click();
 		wait(15);
 		//StudentAccounts.click();
 		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
 		wait(2);
 		Subsidiary.clickUsingJavaScriptExecutor();
 		wait(15);
 		SelSubsidery.clickUsingJavaScriptExecutor();
 		wait(3);
 		ClkSubsidery.clickUsingJavaScriptExecutor();
 		wait(3);
 		addcharge.clickUsingJavaScriptExecutor();
 		wait(10);
 		/*AddSubsidery.click();
 		wait(2);
 		Subsidery.click();
 		wait(2);
 		SerachSubsidery.clearAndType(data.get("Subsidery Name").toString());
 		wait(2);
 		SelSubsidery.click();
 		wait(2);
 		EntMaintainedBalance.sendKeys("Balance Value");
 		wait(2);
 		SubSave.click();
 		wait(2);*/
 		AcademicYear.click();
 		wait(2);
 		SelAcademicyear.clickUsingJavaScriptExecutor();
 		wait(2);
 		TermList.clickUsingJavaScriptExecutor();
 		wait(2);
 		SearchCode.clearAndType(data.get("Enter Term").toString());
 		wait(3);
 		Term.clickUsingJavaScriptExecutor();
 		wait(2);
 		SelectButton.click();
 		wait(2);
 		Billcode.click();
 		wait(10);
 		//SearchBillcode.sendKeys(data.get("Bill Code Name"));
 		//wait(5);
 		SelBillcode.clickUsingJavaScriptExecutor();
 		wait(5);
 		Amount.sendKeys(data.get("Amount Value"));
 		wait(7);
 		SaveAndClose.clickUsingJavaScriptExecutor();
 		waitForPageToLoad();
 		wait(10);
 		return this;
	}
        
   public StudentSubsidiaryPage PostChargeDel(StringHash data) throws Exception {
	   Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		
		//Login Page Web Elements
		waitForPageToLoad();
		//wait(20);
		//MenuButton.click();
		//wait(5);
		//Students.click();
		//waitForPageToLoad();
		wait(15);
		FilterDropDwon.click();
		wait(1);
		ClearFiltersButton.click();
		waitForPageToLoad();
		wait(15);
		StuNumDropDown.click();
		waitForPageToLoad();
		wait(1);
		StuNumFilter.click();
		waitForPageToLoad();
		wait(1);
		value.clearAndType(data.get("Student Number"));
		waitForPageToLoad();
		wait(1);
		FilterButton.click();
		wait(20);
		ClickStudentName.click();
		wait(15);
		//StudentAccounts.click();
		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		wait(2);
		Subsidiary.clickUsingJavaScriptExecutor();
		wait(15);
		SelSubsidery.clickUsingJavaScriptExecutor();
		wait(3);
		ClkSubsidery.clickUsingJavaScriptExecutor();
		wait(5);
		ClsFilterDropDwon.click();
		wait(2);
		ClsClearFiltersButton.click();
		wait(15);
		TeDropDown.click();
		wait(2);
		TerNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Code"));
		wait(3);
		CFilterButton.clickUsingJavaScriptExecutor();
		wait(5);
		SelCharge.click();
		wait(3);
		More.click();
		wait(2);
		Delete.click();
		wait(2);
		DeleteNote.clearAndType(data.get("Delete Note").toString());
		wait(3);
		Deletebutton.click();
		wait(5);
		return this;
	}
   
   public StudentSubsidiaryPage SubsidiaryPostCharge(StringHash data) throws Exception {
		Link AdjustSubMsg= new Link("Post charge Subsidiary Msg", byXPath("//span[text()='The Transaction records were successfully saved.']"));
		Link SelectSubsidiary = new Link("Selecting Subsidiary", byXPath("//span[. = ' LAPTOPDE ']"));
		
		//Login Page Web Elements
		waitForPageToLoad();
		setImplicitWaitTimeout(implicitWaitTimeout);
		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		Subsidiary.clickUsingJavaScriptExecutor();
		wait(25);
		GettingSubsidiaryName.click();
		wait(2);
		SelectingSubsidiary.click();
		wait(3);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(2);
		StudentLedgerAccountPage.AddCharge.click();
       wait(6);
       TermList.clickUsingJavaScriptExecutor();
       wait(3);
       SearchCode.clearAndType(data.get("TermCode"));
       wait(3);
       if(Term.isSelected())
       {
           System.out.println("Term is already selected");
           StudentLedgerAccountPage.CancelButton.clickUsingJavaScriptExecutor();
       }else {
           Term.clickUsingJavaScriptExecutor();
           wait(2);
           SelectButton.clickUsingJavaScriptExecutor();
           //System.out.println("Task template is not matching");
       }
       wait(2);
       StudentLedgerAccountPage.BillCode.click();
       wait(2);
       StudentLedgerAccountPage.SearchBillCode.waitTillElementClickable();
       StudentLedgerAccountPage.SearchBillCode.sendKeys(data.get("BillCode"));
       wait(2);
       StudentLedgerAccountPage.SelectingBillCode.click();
       wait(3);
       Amount.sendKeys(data.get("Amount"));
       wait(5);
       scrollPage(0, -300);
       wait(1);
       SaveAndClose.click();
       wait(5);
       CustomAsserts.containsString(StudentLedgerAccountPage.PostingChargeMsg.getText(), data.get("PostingChargeMsg").toString());
		return this;
	}
   
   public StudentSubsidiaryPage SubsidiaryLedgerPostCharge(StringHash data) throws Exception {

		 //X-path Parameterization	
		     	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		     	//Link SelAcademicyear = new Link("Click on AcademicYear", byXPath("//span[@title='"+data.get("EmployerName")+"']"));
		     	Checkbox Term = new Checkbox("Selecting Term", byXPath("//input[@aria-label='"+data.get("Enter Term")+"']"));
		 		Link SubsideryPostChargeSaveMessage = new Link("SubsideryPostChargeSaveMessage", byXPath("//span[. = 'The Charge records were successfully saved.']"));			
		 		Link ClkSubsidery = new Link("Click Subsidery", byXPath("//span[@title='"+data.get("Subsidery")+"']"));
		 //Method Implementation
		     	waitForPageToLoad();
		  		wait(10);
		  		FilterDropDwon.click();
		  		wait(1);
		  		ClearFiltersButton.click();
		  		wait(10);
		  		StuNumDropDown.click();
		  		wait(1);
		  		StuNumFilter.click();
		  		wait(1);
		  		value.clearAndType(data.get("Student Number"));
		  		wait(1);
		  		FilterButton.click();
		  		wait(5);
		  		ClickStudentName.click();
		  		wait(15);
		  		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		  		wait(2);
		  		Subsidiary.clickUsingJavaScriptExecutor();
		  		wait(15);
		  		SelSubsidery.clickUsingJavaScriptExecutor();
		  		wait(3);
		  		ClkSubsidery.clickUsingJavaScriptExecutor();
		  		wait(3);
		  		addcharge.clickUsingJavaScriptExecutor();
		  		wait(10);
		  		AcademicYear.click();
		  		wait(2);
		  		SelAcademicyear.clickUsingJavaScriptExecutor();
		  		wait(2);
		  		TermList.clickUsingJavaScriptExecutor();
		  		wait(2);
		  		SearchCode.clearAndType(data.get("Enter Term").toString());
		  		wait(3);
		  		Term.clickUsingJavaScriptExecutor();
		  		wait(4);
		  		SelectButton.click();
		  		wait(5);
		  		Billcode.click();
		  		wait(2);
		  		//SearchBillcode.sendKeys(data.get("Bill Code Name"));
		  		//wait(5);
		  		SelBillcode.clickUsingJavaScriptExecutor();
		  		wait(5);
		  		Amount.sendKeys(data.get("Amount Value"));
		  		wait(3);
		  		SaveAndClose.clickUsingJavaScriptExecutor();
		  		wait(3);
		 		CustomAsserts.containsString(SubsideryPostChargeSaveMessage.getText(), data.get("SuccessMessage").toString());
		 		wait(2);
		  		return this;
		 	}
   
   public StudentSubsidiaryPage SubLedgerPostChargeDelete(StringHash data) throws Exception {

	 //X-path Parameterization
	 	 	   Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	 	 	   Link SubLedgerPostChargeDeleteSaveMessage = new Link("SubLedgerPostChargeDeleteSaveMessage", byXPath("//span[. = 'The Student Subsidiary records were successfully deleted.']"));			
	 	 	   Link ClkSubsidery = new Link("Click Subsidery", byXPath("//span[@title='"+data.get("Subsidery")+"']"));
	 	 	   Link SelCharge = new Link("Click Term Button", byXPath("(//span[text()='"+data.get("SelCharge")+"'])[1]"));
	 //Method Implementation
	 	 		waitForPageToLoad();
	 	 		wait(10);
	 	 		FilterDropDwon.click();
	 	  		wait(1);
	 	  		ClearFiltersButton.click();
	 	  		wait(10);
	 	  		StuNumDropDown.click();
	 	  		wait(1);
	 	  		StuNumFilter.click();
	 	  		wait(1);
	 	  		value.clearAndType(data.get("Student Number"));
	 	  		wait(1);
	 	  		FilterButton.click();
	 	  		wait(5);
	 	  		ClickStudentName.click();
	 	  		wait(15);
	 	  		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	 	  		wait(2);
	 	  		Subsidiary.clickUsingJavaScriptExecutor();
	 	 		wait(15);
	 	 		SelSubsidery.clickUsingJavaScriptExecutor();
	 	 		wait(3);
	 	 		ClkSubsidery.clickUsingJavaScriptExecutor();
	 	 		wait(5);
	 	 		ClsFilterDropDwon.click();
	 	 		wait(2);
	 	 		ClsClearFiltersButton.click();
	 	 		wait(5);
	 	 		/*TeDropDown1.click();
	 	 		wait(2);
	 	 		TerNumFilter.click();
	 	 		wait(2);
	 	 		value.clearAndType(data.get("Code"));
	 	 		wait(3);
	 	 		FilterButton.click();*/
	 	 		wait(5);
	 	 		SelCharge.click();
	 	 		wait(3);
	 	 		More.click();
	 	 		wait(2);
	 	 		Delete.click();
	 	 		wait(2);
	 	 		DeleteNote.clearAndType(data.get("Delete Note").toString());
	 	 		wait(3);
	 	 		Deletebutton.click();
	 	 		wait(5);
	 	 		CustomAsserts.containsString(SubLedgerPostChargeDeleteSaveMessage.getText(), data.get("SuccessMessage").toString());
	 	 		wait(2);
	 	 		return this;
	 	 	}
    
   public StudentSubsidiaryPage SubTransactionVoid(StringHash data) throws Exception {

	 //X-path Parameterization
	 	 	   Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	 	 	   Link SubTransVoidSaveMessage = new Link("SubTransVoidSaveMessage", byXPath("//span[. = 'The Student Subsidiary records were successfully voided.']"));			
	 	 	   Link ClkSubsidery = new Link("Click Subsidery", byXPath("//span[@title='"+data.get("Subsidery")+"']"));

	 //Method Implementation
	 	 		waitForPageToLoad();
	 	 		wait(10);
	 	 		FilterDropDwon.click();
	 	 		wait(1);
	 	 		ClearFiltersButton.click();
	 	 		wait(10);
	 	 		StuNumDropDown.click();
	 	 		wait(1);
	 	 		StuNumFilter.click();
	 	 		wait(1);
	 	 		value.clearAndType(data.get("Student Number"));
	 	 		wait(1);
	 	 		FilterButton.click();
	 	 		wait(10);
	 	 		ClickStudentName.click();
	 	 		wait(15);
	 	 		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	 	 		wait(2);
	 	 		Subsidiary.clickUsingJavaScriptExecutor();
	 	 		wait(15);
	 	 		SelSubsidery.clickUsingJavaScriptExecutor();
	 	 		wait(3);
	 	 		ClkSubsidery.clickUsingJavaScriptExecutor();
	 	 		wait(5);
	 	 		ClsFilterDropDwon.click();
	 	 		wait(2);
	 	 		ClsClearFiltersButton.click();
	 	 		wait(10);
	 	 		TeDropDown.click();
	 	 		wait(2);
	 	 		TrDropDown.click();
	 	 		wait(2);
	 	 		value.clearAndType(data.get("Code"));
	 	 		wait(4);
	 	 		FilterButton.click();
	 	 		wait(5);
	 	 		SelCharge.click();
	 	 		wait(3);
	 	 		More.click();
	 	 		wait(2);
	 	 		Void.click();
	 	 		wait(2);
	 	 		VoidNote.clearAndType(data.get("Void Note").toString());
	 	 		wait(3);
	 	 		VoidButton.click();
	 	 		wait(7);
	 	 		CustomAsserts.containsString(SubTransVoidSaveMessage.getText(), data.get("SuccessMessage").toString());
	 	 		wait(2);
	 	 		return this;
	 	 	}
   
   public StudentSubsidiaryPage SubLedgerPostPayment(StringHash data) throws Exception {

	 //X-path Parameterization
	 	    	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	 	    	//Link SelAcademicyear = new Link("Click on AcademicYear", byXPath("//span[@title='"+data.get("EmployerName")+"']"));
	 	    	Checkbox Term = new Checkbox("Selecting Term", byXPath("//input[@aria-label='"+data.get("Enter Term")+"']"));
	 	    	Link SubsideryPostPaymentSaveMessage = new Link("SubsideryPostPaymentSaveMessage", byXPath("//span[. = 'The Transaction records were successfully saved.']"));			
	 	    	Link ClkSubsidery = new Link("Click Subsidery", byXPath("//span[@title='"+data.get("Subsidery")+"']"));
	 	    	
	 //Method Implementation
	 	    	waitForPageToLoad();
	 	 		wait(10);
	 	 		FilterDropDwon.click();
	 	 		wait(1);
	 	 		ClearFiltersButton.click();
	 	 		wait(10);
	 	 		StuNumDropDown.click();
	 	 		wait(1);
	 	 		StuNumFilter.click();
	 	 		wait(1);
	 	 		value.clearAndType(data.get("Student Number"));
	 	 		wait(1);
	 	 		FilterButton.click();
	 	 		wait(10);
	 	 		ClickStudentName.click();
	 	 		wait(15);
	 	 		StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
	 	 		wait(2);
	 	 		Subsidiary.clickUsingJavaScriptExecutor();
	 	 		wait(15);
	 	 		SelSubsidery.clickUsingJavaScriptExecutor();
	 	 		wait(3);
	 	 		ClkSubsidery.clickUsingJavaScriptExecutor();
	 	 		wait(3);
	 	 		Payment.clickUsingJavaScriptExecutor();
	 	 		wait(10);
	 	 		Password.clearAndType(data.get("Password").toString());
	 	 		wait(3);
	 	 		Ok.clickUsingJavaScriptExecutor();
	 	 		wait(2);
	 	 		TermList.clickUsingJavaScriptExecutor();
	 	 		wait(2);
	 	 		SearchCode.clearAndType(data.get("Enter Term").toString());
	 	 		wait(3);
	 	 		Term.clickUsingJavaScriptExecutor();
	 	 		wait(2);
	 	 		SelectButton.click();
	 	 		wait(2);
	 	 		PaymentName.clearAndType(data.get("Payment Name").toString());
	 	 		wait(3);
	 	 		PaymentMethod.click();
	 	 		wait(3);
	 	 		SelPaymentMethod.click();
	 	 		wait(5);
	 	 		CashDrawer.click();
	 	 		wait(3);
	 	 		SelCashDrawer.click();
	 	 		wait(3);
	 	 		Amount1.sendKeys(data.get("Amount Value"));
	 	 		wait(7);
	 	 		printreciept.click();
	 	 		wait(3);
	 	 		SaveAndClose.clickUsingJavaScriptExecutor();
	 	 		wait(7);
	 	 		CustomAsserts.containsString(SubsideryPostPaymentSaveMessage.getText(), data.get("SuccessMessage").toString());
	 	 		wait(2);
	 	 		return this;
	 	 	}
    
   public StudentSubsidiaryPage SubPostRefundForStudent(StringHash data) throws Exception {

		 //X-path Parameterization
		 	   	Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		 	   	//Link SelAcademicyear = new Link("Click on AcademicYear", byXPath("//span[@title='"+data.get("EmployerName")+"']"));
		 	   	//Checkbox Term = new Checkbox("Selecting Term", byXPath("//input[@aria-label='"+data.get("Enter Term")+"']"));
		 		Link SubPostRefundSaveMessage = new Link("SubPostRefundSaveMessage", byXPath("//span[. = 'The Refund records were successfully saved.']"));			
		 		Link RefundSource = new Link("RefundSource", byXPath("//td[. = '"+data.get("RefundSource")+"']"));
		 		Link SelTermField = new Link("SelTermField", byXPath("//span[. = '"+data.get("Enter Term")+"']"));
		 		
		 //Method Implementation
		 	   		waitForPageToLoad();
		 			wait(10);
		 			FilterDropDwon.click();
		 			wait(1);
		 			ClearFiltersButton.click();
		 			wait(10);
		 			StuNumDropDown.click();
		 			wait(1);
		 			StuNumFilter.click();
		 			wait(1);
		 			value.clearAndType(data.get("Student Number"));
		 			wait(1);
		 			FilterButton.click();
		 			wait(10);
		 			ClickStudentName.click();
		 			wait(15);
		 			StudentStudentPage.StudentAccounts.clickUsingJavaScriptExecutor();
		 			wait(2);
		 			Subsidiary.clickUsingJavaScriptExecutor();
		 			wait(17);
		 			Refund.clickUsingJavaScriptExecutor();
		 			wait(3);
		 			RefundSource.click();
		 			wait(3);
		 			Nextt.click();
		 			wait(3);
		 			scrollPage(0, 600);
		 			wait(2);
		 			TermField.click();
		 			wait(3);
		 			SelTermField.click();
		 			wait(3);
		 			DueDate.clearAndType(data.get("Due Date").toString());
		 			wait(3);
		 			Amount1.sendKeys(data.get("Amount"));
		 			wait(3);
		 			PostSchedule.click();
		 			wait(7);
		 			CustomAsserts.containsString(SubPostRefundSaveMessage.getText(), data.get("SuccessMessage").toString());
		 			wait(2);
		 			return this;
		 		}

}





