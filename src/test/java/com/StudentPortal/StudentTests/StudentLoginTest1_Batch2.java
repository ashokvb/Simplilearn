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

public class StudentLoginTest1_Batch2 extends AutomationTestPlan {

		public StudentLoginTest1_Batch2() {
			xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
		}
//Test 01 ---Create subsidiaries
@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Create subsidiaries", testName = "Create subsidiaries")
		@TestCaseFields(testCaseName = "Create subsidiaries")
		public void TC935_1Createsubsidiaries(StringHash data) throws Exception {
		StudentLoginTest1Flow.SubsidiaryCreation(data);
		}

//Test 02 --Subsidiary Ledger Add
@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="SubsidiaryLedgerAdd", testName = "SubsidiaryLedgerAdd")
		@TestCaseFields(testCaseName = "SubsidiaryLedgerAdd")
		public void TC935_2AddNewSubsidiary(StringHash data) throws Exception {
		StudentLoginTest1Flow.AddingNewSubsidiary(data);
        }

//Test 02 --Subsidiary Ledger Add
@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="SubsidiaryLedgerAdd", testName = "Subsidiary Ledger Post a Charge")
		@TestCaseFields(testCaseName = "Subsidiary Ledger Post a Charge")
		public void SubsidiaryPostingCharge(StringHash data) throws Exception {
		StudentLoginTest1Flow.SubLedgerPostCharge(data);
        }

//Test 03 ---Subsidiary Ledger Adjust Transaction
@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="SubsidiaryLedgerAdjustTransaction", testName = "SubsidiaryLedgerAdjustTransaction")
		@TestCaseFields(testCaseName = "SubsidiaryLedgerAdjustTransaction")
		public void TC933_SubsidiaryLedgerAdjustTransaction(StringHash data) throws Exception {
		StudentLoginTest1Flow.AdjustingSubsidiaryTransaction(data);
        }

//Test 04 ---Subsidiary Ledger Print
@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Subsidiary Ledger Print", testName = "SubsidiaryLedgerPrint")
		@TestCaseFields(testCaseName = "SubsidiaryLedgerPrint")
		public void TC934_SubsidiaryLedgerPrint(StringHash data) throws Exception {
		StudentLoginTest1Flow.PrintingSubsidiaryLedger(data);
        }		

//Test 05 ---Configure Documents associated with the FA module
@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Configure Documents associated with the FA module", testName = "Configure Documents associated with the FA module")
		@TestCaseFields(testCaseName = "Configure Documents associated with the FA module")
		public void TC1739_1ConfigureDocumentsassociatedwiththeFAmodule(StringHash data) throws Exception {
		StudentLoginTest1Flow.DocumentTypeCreation(data);
		}

//Test 06 ---Configure Document Schedules
@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Configure Document Schedules", testName = "Configure Document Schedules")
		@TestCaseFields(testCaseName = "Configure Document Schedules")
		public void TC1739_2ConfigureDocumentSchedules(StringHash data) throws Exception {
		StudentLoginTest1Flow.DocumentScheduleCreation(data);
		}		

//Test 26 ---Configure Document Policies
@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Configure Document Policies", testName = "Configure Document Policies")
		@TestCaseFields(testCaseName = "Configure Document Policies")
		public void TC1739_5ConfigureDocumentPolicies(StringHash data) throws Exception {
		StudentLoginTest1Flow.DocumentPolicyCreation(data);
		}		

//Test 24 ---Ability to add documents to individual Student record from the Financial Aid module
@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Ability to add documents to individual Student record from the Financial Aid module", testName = "Ability to add documents to individual Student record from the Financial Aid module")
		@TestCaseFields(testCaseName = "Ability to add documents to individual Student record from the Financial Aid module")
		public void TC1739_3AbilitytoadddocumentstoindividualStudentrecordfromtheFinancialAidmodule(StringHash data) throws Exception {
		StudentLoginTest1Flow.AddingDocumenttoStudent(data);
		}

//Test 25 ---Ability to add document lists to individual Student record from the Financial Aid module
@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Ability to add document lists to individual Student record from the Financial Aid module", testName = "Ability to add document lists to individual Student record from the Financial Aid module")
		@TestCaseFields(testCaseName = "Ability to add document lists to individual Student record from the Financial Aid module")
		public void TC1739_4AbilitytoadddocumentliststoindividualStudentrecordfromtheFinancialAidmodule(StringHash data) throws Exception {
		StudentLoginTest1Flow.AddingDocumentListtoStudent(data);
		}
		@DataProvider
		public Object[][] getData(Method method) {

			return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
		}
}
