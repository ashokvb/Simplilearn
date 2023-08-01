package com.StudentPortal.StudentTests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StudentPortal.Businessflow.StudentLoginTest1Flow;
import com.framework.base.constants.FrameworkConstants;
import com.framework.core.AutomationTestPlan;
import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestCaseFields;
import com.framework.util.Xls_Reader;

public class StudentLoginTest1_Batch1 extends AutomationTestPlan {
		
		public StudentLoginTest1_Batch1() {
			xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
		}
		
//Test 17 -- *Prerequisite script*
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "CreateFundSource")
			@TestCaseFields(testCaseName = "CreateFundSource")
			public void TC945_1CreateFundSource(StringHash data) throws Exception {
			StudentLoginTest1Flow.FundSourceCreation(data);
		}
//Test 14 -- *Prerequisite script*
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "PostAPayment")
			@TestCaseFields(testCaseName = "PostAPayment")
			public void TC945_3PostingPayment(StringHash data) throws Exception {
			StudentLoginTest1Flow.PostAPayment(data);
		}
			
//Test 06 ---Ledger Adjust Transaction-Void
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="LedgerAdjustTransactionVoid", testName = "LedgerAdjustTransactionVoid")
			@TestCaseFields(testCaseName = "LedgerAdjustTransactionVoid")
			public void TC936_LedgerAdjustTransactionVoid(StringHash data) throws Exception {
			StudentLoginTest1Flow.AdjustingLedgerTransactionVoid(data);
		}
		
//Test 11 ---Ledger Card Post a Charge
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Ledger Card Post a Charge", testName = "Ledger Card Post a Charge")
			@TestCaseFields(testCaseName = "Ledger Card Post a Charge")
			public void TC938_1LedgerCardPostCharge(StringHash data) throws Exception {
			StudentLoginTest1Flow.LedgerCardPostingCharge(data);
		}		
		
//Test 05 ---Ledger Card Adjust Transaction
		@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="LedgerCardAdjustTransaction", testName = "LedgerCardAdjustTransaction")
			@TestCaseFields(testCaseName = "LedgerCardAdjustTransaction")
			public void TC939_LedgerAdjustTransaction(StringHash data) throws Exception {
			StudentLoginTest1Flow.AdjustingLedgerTransaction(data);
		}		
		
//Test 07 ---Ledger Card - Print
		@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Ledger Card - Print", testName = "Ledger Card - Print")
			@TestCaseFields(testCaseName = "Ledger Card - Print")
			public void TC940_1LedgerCardPrint(StringHash data) throws Exception {
			StudentLoginTest1Flow.PrintingLedgerCard(data);
		}
		
//Test 08 ---Ledger Card - Print Detail
		@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "Ledger Card - Print Detail")
			@TestCaseFields(testCaseName = "Ledger Card - Print Detail")
			public void TC940_2LedgerCardPrintDetail(StringHash data) throws Exception {
			StudentLoginTest1Flow.PrintingLedgerCardDetail(data);
		}		
		
//Test 27 ---Ledger Card - Print Summary
		@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "TC940_3LedgerCardPrintSummary")
			@TestCaseFields(testCaseName = "TC940_3LedgerCardPrintSummary")
			public void TC940_3LedgerCardPrintDSummary(StringHash data) throws Exception {
			StudentLoginTest1Flow.PrintingLedgerCardSummary(data);
		}
		
//Test 09 ---Configuration of manual or automated apply payment
		@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Configuration of manual or automated apply payment", testName = "Configuration of manual or automated apply payment")
			@TestCaseFields(testCaseName = "Configuration of manual or automated apply payment")
			public void TC941_1ConfigPaymentFlag(StringHash data) throws Exception {
			StudentLoginTest1Flow.ConfiguringApplyPaymentFlag(data);
		}
		
//Test 10 ---Ledger Card - Apply Payment or Credits
		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Ledger Card - Apply Payment or Credits", testName = "Ledger Card - Apply Payment or Credits")
			@TestCaseFields(testCaseName = "Ledger Card - Apply Payment or Credits")
			public void TC941_2LedgerCardApplyCredit(StringHash data) throws Exception {
			StudentLoginTest1Flow.LedgerCardApplyingCredit(data);
		}
		
//Test 28 ---Letters should be created for employers
		@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "Letters should be created for employers")
			@TestCaseFields(testCaseName = "Letters should be created for employers")
			public void TC943_1LetterCreationForEmployer(StringHash data) throws Exception {
			StudentLoginTest1Flow.CreatingLetterForEmployer(data);
		}
		
//Test 29 ---Letters configured for employers should be available for printing
		@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Ledger Card - Print Detail", testName = "Letters configured for employers should be available for printing")
			@TestCaseFields(testCaseName = "Letters configured for employers should be available for printing")
			public void TC943_2LetterPrintingForEmployer(StringHash data) throws Exception {
			StudentLoginTest1Flow.PrintingEmployerLetter(data);
		}
		
//Test 13 ---Ledger Card - Schedule a Refund
		@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Ledger Card - Schedule a Refund", testName = "Ledger Card - Schedule a Refund")
			@TestCaseFields(testCaseName = "Ledger Card - Schedule a Refund")
			public void TC945_1LedgerCardScheduleaRefund(StringHash data) throws Exception {
			StudentLoginTest1Flow.SchedulingLedgerCardRefund(data);
		}
		
//Test 14 ---Ledger Card - Schedule a Stipend
		@Test(enabled = true, dataProvider = "getData", priority = 12,alwaysRun = true, description ="Ledger Card - Schedule a Stipend", testName = "Ledger Card - Schedule a Stipend")
			@TestCaseFields(testCaseName = "Ledger Card - Schedule a Stipend")
			public void TC945_2LedgerCardScheduleaStipend(StringHash data) throws Exception {
			StudentLoginTest1Flow.SchedulingStipend(data);
		}
		
//Test 15 ---Process Scheduled Refunds
		@Test(enabled = true, dataProvider = "getData", priority = 13,alwaysRun = true, description ="Process Scheduled Refunds", testName = "Process Scheduled Refunds")
			@TestCaseFields(testCaseName = "Process Scheduled Refunds")
			public void TC946_ProcessScheduledRefunds(StringHash data) throws Exception {
			StudentLoginTest1Flow.ProcessingScheduledRefund(data);
		}
		
//Test 16 ---Process Scheduled Stipends
		@Test(enabled = true, dataProvider = "getData", priority = 14,alwaysRun = true, description ="Process Scheduled Stipends", testName = "Process Scheduled Stipends")
			@TestCaseFields(testCaseName = "Process Scheduled Stipends")
			public void TC947_ProcessScheduledStipends(StringHash data) throws Exception {
			StudentLoginTest1Flow.ProcessingScheduledStipend(data);
		}	
		
		@DataProvider
		public Object[][] getData(Method method) {

			return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
		}
}
