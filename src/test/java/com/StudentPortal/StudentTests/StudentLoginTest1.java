package com.StudentPortal.StudentTests;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.StudentPortal.Businessflow.StudentConfigurationFlow;
import com.StudentPortal.Businessflow.StudentLoginTest1Flow;
import com.framework.base.constants.FrameworkConstants;
import com.framework.core.AutomationTestPlan;
import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestCaseFields;
import com.framework.util.Xls_Reader;

public class StudentLoginTest1 extends AutomationTestPlan {
	
	public StudentLoginTest1() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  
//Test 1	
	@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Create a school status", testName = "CreateSchoolStatus")
	@TestCaseFields(testCaseName = "CreateSchoolStatus")
	public void CreateSchoolStatusTest(StringHash data) throws Exception {

		StudentLoginTest1Flow.SchoolStatusCreation(data);
	}
	
//Test 2
	@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Create a prospect", testName = "CreateProspect")
	@TestCaseFields(testCaseName = "CreateProspect")
	public void CreateProspectTest(StringHash data) throws Exception {

		StudentLoginTest1Flow.PSStudentLogin(data);
	}

	
//Test 3
	@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="Create a Task Template", testName = "CreateTaskTemplate")
	@TestCaseFields(testCaseName = "CreateTaskTemplate")
	public void CreateTaskTemplateTest(StringHash data) throws Exception {

		StudentLoginTest1Flow.TaskTemplateCreation(data);
	} 

//Test 4
	@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Create a Task Schedule", testName = "CreateTaskSchedule")
	@TestCaseFields(testCaseName = "CreateTaskSchedule")
	public void CreateTaskSchedule(StringHash data) throws Exception {

		StudentLoginTest1Flow.TaskScheduleCreation(data);
	} 
	
//Test 5

		@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Create a Document type", testName = "CreateDocumentType")
		@TestCaseFields(testCaseName = "CreateDocumentType")
		public void CreateDocumentType(StringHash data) throws Exception {

			StudentLoginTest1Flow.DocumentTypeCreation(data);
		}
		
//Test 6

		@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Add Task to a Student", testName = "AddTaskToStudent")
		@TestCaseFields(testCaseName = "AddTaskToStudent")
		public void AddTaskToStudent(StringHash data) throws Exception {

			StudentLoginTest1Flow.AddingTasktoStudent(data);
		}
		
//Test 7

		@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Add document to a Student", testName = "AddDocumentToStudent")
		@TestCaseFields(testCaseName = "AddDocumentToStudent")
				public void AddDocumentToStudent(StringHash data) throws Exception {

			StudentLoginTest1Flow.AddingDocumenttoStudent(data);
		}
		
//Test 8

		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Create a Document Schedule", testName = "CreateDocumentSchedule")
		@TestCaseFields(testCaseName = "CreateDocumentSchedule")
				public void CreateDocumentSchedule(StringHash data) throws Exception {

			StudentLoginTest1Flow.DocumentScheduleCreation(data);

		}
		
//Test 01 ---Create subsidiaries
		@Test(enabled = true, dataProvider = "getData", priority = 01,alwaysRun = true, description ="Create subsidiaries", testName = "Createsubsidiaries")
				@TestCaseFields(testCaseName = "Createsubsidiaries")
				public void TC935_1Createsubsidiaries(StringHash data) throws Exception {
				StudentLoginTest1Flow.SubsidiaryCreation(data);
				
		}
		
//Test 02 --Subsidiary Ledger Add
		@Test(enabled = true, dataProvider = "getData", priority = 02,alwaysRun = true, description ="SubsidiaryLedgerAdd", testName = "SubsidiaryLedgerAdd")
				@TestCaseFields(testCaseName = "SubsidiaryLedgerAdd")
				public void TC935_2AddNewSubsidiary(StringHash data) throws Exception {
				StudentLoginTest1Flow.AddingNewSubsidiary(data);
		}
		
//Test 03 --Subsidiary Ledger Post a charge
		@Test(enabled = true, dataProvider = "getData", priority = 03,alwaysRun = true, description ="SubsidiaryLedgerPostaCharge", testName = "Subsidiary Ledger Post a Charge")
				@TestCaseFields(testCaseName = "Subsidiary Ledger Post a Charge")
				public void TC933_1SubsidiaryPostingCharge(StringHash data) throws Exception {
				StudentLoginTest1Flow.SubLedgerPostCharge(data);
		}
		
//Test 04 ---Subsidiary Ledger Adjust Transaction
		@Test(enabled = true, dataProvider = "getData", priority = 04,alwaysRun = true, description ="SubsidiaryLedgerAdjustTransaction", testName = "SubsidiaryLedgerAdjustTransaction")
				@TestCaseFields(testCaseName = "SubsidiaryLedgerAdjustTransaction")
				public void TC933_2SubsidiaryLedgerAdjustTransaction(StringHash data) throws Exception {
				StudentLoginTest1Flow.AdjustingSubsidiaryTransaction(data);
		}
		
//Test 05 ---Subsidiary Ledger Print
		@Test(enabled = true, dataProvider = "getData", priority = 05,alwaysRun = true, description ="Subsidiary Ledger Print", testName = "SubsidiaryLedgerPrint")
				@TestCaseFields(testCaseName = "SubsidiaryLedgerPrint")
				public void TC934_SubsidiaryLedgerPrint(StringHash data) throws Exception {
				StudentLoginTest1Flow.PrintingSubsidiaryLedger(data);
		}

//Test 07 ---Ledger Card Adjust Transaction
		@Test(enabled = true, dataProvider = "getData", priority = 07,alwaysRun = true, description ="LedgerCardAdjustTransaction", testName = "LedgerCardAdjustTransaction")
				@TestCaseFields(testCaseName = "LedgerCardAdjustTransaction")
				public void TC939_LedgerAdjustTransaction(StringHash data) throws Exception {
				StudentLoginTest1Flow.AdjustingLedgerTransaction(data);
		}
		
//Test 08 ---Ledger Adjust Transaction-Void
		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="LedgerAdjustTransactionVoid", testName = "TC936_LedgerAdjustTransactionVoid")
				@TestCaseFields(testCaseName = "TC936_LedgerAdjustTransactionVoid")
				public void TC936_LedgerAdjustTransactionVoid(StringHash data) throws Exception {
				StudentLoginTest1Flow.AdjustingLedgerTransactionVoid(data);
		}
		
//Test 09 ---Ledger Card - Print
		@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Ledger Card - Print", testName = "Ledger Card - Print")
				@TestCaseFields(testCaseName = "Ledger Card - Print")
				public void TC940_1LedgerCardPrint(StringHash data) throws Exception {
				StudentLoginTest1Flow.PrintingLedgerCard(data);
		}
		
//Test 10 ---Ledger Card - Print Detail
		@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "Ledger Card - Print Detail")
				@TestCaseFields(testCaseName = "Ledger Card - Print Detail")
				public void TC940_2LedgerCardPrintDetail(StringHash data) throws Exception {
				StudentLoginTest1Flow.PrintingLedgerCardDetail(data);
		}
		
//Test 11 ---Configuration of manual or automated apply payment
		@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Configuration of manual or automated apply payment", testName = "Configuration of manual or automated apply payment")
				@TestCaseFields(testCaseName = "Configuration of manual or automated apply payment")
				public void TC941_1ConfigPaymentFlag(StringHash data) throws Exception {
				StudentLoginTest1Flow.ConfiguringApplyPaymentFlag(data);
		}
		
//Test 12 ---Ledger Card - Apply Payment or Credits
		@Test(enabled = true, dataProvider = "getData", priority = 12,alwaysRun = true, description ="Ledger Card - Apply Payment or Credits", testName = "Ledger Card - Apply Payment or Credits")
				@TestCaseFields(testCaseName = "Ledger Card - Apply Payment or Credits")
				public void TC941_2LedgerCardApplyCredit(StringHash data) throws Exception {
				StudentLoginTest1Flow.LedgerCardApplyingCredit(data);
		}
		
//Test 06 ---Ledger Card Post a Charge
				@Test(enabled = true, dataProvider = "getData", priority = 06,alwaysRun = true, description ="Ledger Card Post a Charge", testName = "Ledger Card Post a Charge")
				@TestCaseFields(testCaseName = "Ledger Card Post a Charge")
				public void TC938_1LedgerCardPostCharge(StringHash data) throws Exception {
				StudentLoginTest1Flow.LedgerCardPostingCharge(data);
		}
				
//Test 13 ---Ledger Card - Adjust Transaction - Delete
				@Test(enabled = true, dataProvider = "getData", priority = 13,alwaysRun = true, description ="Ledger Card - Adjust Transaction - Delete", testName = "Ledger Card - Adjust Transaction - Delete")
				@TestCaseFields(testCaseName = "Ledger Card - Adjust Transaction - Delete")
				public void TC938_2LedgerCardAdjustTransactionDelete(StringHash data) throws Exception {
				StudentLoginTest1Flow.AdjustingLedgerTransactionDelete(data);
		}
				
//Test 15 ---Ledger Card - Schedule a Refund
				@Test(enabled = true, dataProvider = "getData", priority = 15,alwaysRun = true, description ="Ledger Card - Schedule a Refund", testName = "Ledger Card - Schedule a Refund")
				@TestCaseFields(testCaseName = "Ledger Card - Schedule a Refund")
				public void TC945_2LedgerCardScheduleaRefund(StringHash data) throws Exception {
				StudentLoginTest1Flow.SchedulingLedgerCardRefund(data);
		}

//Test 16 ---Ledger Card - Schedule a Stipend
				@Test(enabled = true, dataProvider = "getData", priority = 16,alwaysRun = true, description ="Ledger Card - Schedule a Stipend", testName = "Ledger Card - Schedule a Stipend")
				@TestCaseFields(testCaseName = "Ledger Card - Schedule a Stipend")
				public void TC945_4LedgerCardScheduleaStipend(StringHash data) throws Exception {
				StudentLoginTest1Flow.SchedulingStipend(data);
		}
				
//Test 15 ---Process Scheduled Refunds
				@Test(enabled = true, dataProvider = "getData", priority = 15,alwaysRun = true, description ="Process Scheduled Refunds", testName = "Process Scheduled Refunds")
				@TestCaseFields(testCaseName = "Process Scheduled Refunds")
				public void TC946_ProcessScheduledRefunds(StringHash data) throws Exception {
				StudentLoginTest1Flow.ProcessingScheduledRefund(data);
		}
				
//Test 18 ---Process Scheduled Stipends
				@Test(enabled = true, dataProvider = "getData", priority = 18,alwaysRun = true, description ="Process Scheduled Stipends", testName = "Process Scheduled Stipends")
				@TestCaseFields(testCaseName = "Process Scheduled Stipends")
				public void TC947_ProcessScheduledStipends(StringHash data) throws Exception {
				StudentLoginTest1Flow.ProcessingScheduledStipend(data);
		}		
				
//Test 19 ---School Fields - Confirm new information can be added to field for Student Accounts
		@Test(enabled = true, dataProvider = "getData", priority = 19,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Student Accounts", testName = "School Fields - Confirm new information can be added to field for Student Accounts")
				@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Student Accounts")
				public void TC1747_SchooldefinedFieldStdAcct(StringHash data) throws Exception {
				StudentLoginTest1Flow.SchoolDefinedFiledStudentAccounts(data);
		}
		
//Test 20 ---School Fields - Confirm new information can be added to field for Admissions
		@Test(enabled = true, dataProvider = "getData", priority = 20,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Admissions", testName = "School Fields - Confirm new information can be added to field for Admissions")
				@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Admissions")
				public void TC1748_SchooldefinedFieldAdmission(StringHash data) throws Exception {
				StudentLoginTest1Flow.SchoolDefinedFieldAdmission(data);
		}
		
//Test 21 ---School Fields - Confirm new information can be added to field for Student Services
		@Test(enabled = true, dataProvider = "getData", priority = 21,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Student Services", testName = "School Fields - Confirm new information can be added to field for Student Services")
				@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Student Services")
				public void TC1749_SchooldefinedFieldStudServ(StringHash data) throws Exception {
				StudentLoginTest1Flow.SchoolDefinedFieldStudentServices(data);
		}
		
//Test 22 ---School Fields - Confirm new information can be added to field for Career Services
		@Test(enabled = true, dataProvider = "getData", priority = 22,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Career Services", testName = "School Fields - Confirm new information can be added to field for Career Services")
				@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Career Services")
				public void TC1750_SchooldefinedFieldCarServ(StringHash data) throws Exception {
				StudentLoginTest1Flow.SchoolDefinedFieldCareerServices(data);
		}
		
//Test 23 ---School Fields - Confirm new information can be added to field for Housing School Fields
		@Test(enabled = true, dataProvider = "getData", priority = 23,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Housing School Fields", testName = "School Fields - Confirm new information can be added to field for Housing School Fields")
				@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Housing School Fields")
				public void TC1751_SchooldefinedFieldHousingStdServ(StringHash data) throws Exception {
				StudentLoginTest1Flow.SchoolDefinedFieldHousingStudentServices(data);
				
		}
		
//Test 24 ---Configure Documents associated with the FA module
		@Test(enabled = true, dataProvider = "getData", priority = 24,alwaysRun = true, description ="Configure Documents associated with the FA module", testName = "Configure Documents associated with the FA module")
				@TestCaseFields(testCaseName = "Configure Documents associated with the FA module")
				public void TC1739_1ConfigureDocumentsassociatedwiththeFAmodule(StringHash data) throws Exception {
				StudentLoginTest1Flow.DocumentTypeCreation(data);
				
		}
		
//Test 25 ---Configure Document Schedules
		@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="Configure Document Schedules", testName = "Configure Document Schedules")
				@TestCaseFields(testCaseName = "Configure Document Schedules")
				public void TC1739_2ConfigureDocumentSchedules(StringHash data) throws Exception {
				StudentLoginTest1Flow.DocumentScheduleCreation(data);
				
		}
		
//Test 26 ---Ability to add documents to individual Student record from the Financial Aid module
		@Test(enabled = true, dataProvider = "getData", priority = 26,alwaysRun = true, description ="Ability to add documents to individual Student record from the Financial Aid module", testName = "Ability to add documents to individual Student record from the Financial Aid module")
				@TestCaseFields(testCaseName = "Ability to add documents to individual Student record from the Financial Aid module")
				public void TC1739_3AbilitytoadddocumentstoindividualStudentrecordfromtheFinancialAidmodule(StringHash data) throws Exception {
				StudentLoginTest1Flow.AddingDocumenttoStudent(data);
				
		}
		
//Test 27 ---Ability to add document lists to individual Student record from the Financial Aid module
		@Test(enabled = true, dataProvider = "getData", priority = 27,alwaysRun = true, description ="Ability to add document lists to individual Student record from the Financial Aid module", testName = "Ability to add document lists to individual Student record from the Financial Aid module")
				@TestCaseFields(testCaseName = "Ability to add document lists to individual Student record from the Financial Aid module")
				public void TC1739_4AbilitytoadddocumentliststoindividualStudentrecordfromtheFinancialAidmodule(StringHash data) throws Exception {
				StudentLoginTest1Flow.AddingDocumentListtoStudent(data);
		}
//Test 28 ---Configure Document Policies
		@Test(enabled = true, dataProvider = "getData", priority = 28,alwaysRun = true, description ="Configure Document Policies", testName = "Configure Document Policies")
				@TestCaseFields(testCaseName = "Configure Document Policies")
				public void TC1739_5ConfigureDocumentPolicies(StringHash data) throws Exception {
				StudentLoginTest1Flow.DocumentPolicyCreation(data);
		}
		
//Test 29 ---Ledger Card - Print Summary
		@Test(enabled = true, dataProvider = "getData", priority = 29,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "TC940_3LedgerCardPrintSummary")
				@TestCaseFields(testCaseName = "TC940_3LedgerCardPrintSummary")
				public void TC940_3LedgerCardPrintDSummary(StringHash data) throws Exception {
				StudentLoginTest1Flow.PrintingLedgerCardSummary(data);
		}
		
//Test 30 ---Letters should be created for employers
		@Test(enabled = true, dataProvider = "getData", priority = 30,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "Letters should be created for employers")
				@TestCaseFields(testCaseName = "Letters should be created for employers")
				public void TC943_1LetterCreationForEmployer(StringHash data) throws Exception {
				StudentLoginTest1Flow.CreatingLetterForEmployer(data);
		}
		
//Test 31 ---Letters configured for employers should be available for printing
		@Test(enabled = true, dataProvider = "getData", priority = 31,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "Letters configured for employers should be available for printing")
				@TestCaseFields(testCaseName = "Letters configured for employers should be available for printing")
				public void TC943_2LetterPrintingForEmployer(StringHash data) throws Exception {
				StudentLoginTest1Flow.PrintingEmployerLetter(data);
		}
//Test 17
		@Test(enabled = true, dataProvider = "getData", priority = 17,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "CreateFundSource")
				@TestCaseFields(testCaseName = "CreateFundSource")
				public void TC945_1CreateFundSource(StringHash data) throws Exception {
				StudentLoginTest1Flow.FundSourceCreation(data);
}
//Test 14
		@Test(enabled = true, dataProvider = "getData", priority = 14,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "PostAPayment")
				@TestCaseFields(testCaseName = "PostAPayment")
				public void TC945_3PostingPayment(StringHash data) throws Exception {
				StudentLoginTest1Flow.PostAPayment(data);
}
	@DataProvider
	public Object[][] getData(Method method) {

		return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
	}
}
