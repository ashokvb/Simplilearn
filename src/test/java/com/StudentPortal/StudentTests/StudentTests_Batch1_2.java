package com.StudentPortal.StudentTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StudentPortal.Businessflow.StudentFlows;
//import com.StudentPortal.Businessflow.StudentLoginFlow;
import com.framework.base.constants.FrameworkConstants;
import com.framework.core.AutomationTestPlan;
import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestCaseFields;
import com.framework.util.Xls_Reader;

public class StudentTests_Batch1_2 extends AutomationTestPlan {
	
	public StudentTests_Batch1_2() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  

//Test 1
		@Test(enabled = true, dataProvider = "getData", priority = 15,alwaysRun = true, description ="Test Script to approove Un approved Aid", testName = "Verify unapproved aid can be batched and approved for disbursement")
		@TestCaseFields(testCaseName = "Verify unapproved aid can be batched and approved for disbursement")
		public void TC874_Verifyunapprovedaidcanbebatchedandapprovedfordisbursement(StringHash data) throws Exception {

						StudentFlows.ApproveUnapprovedAid(data);
					}
					
//Test 2
		@Test(enabled = true, dataProvider = "getData", priority = 16,alwaysRun = true, description ="Test Script to Configure a Promissory Note", testName = "Configuring  printing of Prom Notes from FA module")
		@TestCaseFields(testCaseName = "Configuring  printing of Prom Notes from FA module")
		public void TC878_ConfiguringprintingofPromNotesfromFAmodule(StringHash data) throws Exception {

						StudentFlows.ConfigurePromissoryNote(data);
					}
					
//Test 3
		@Test(enabled = true, dataProvider = "getData", priority = 17,alwaysRun = true, description ="Test Script to Schedule a Student Payment Plan", testName = "Schedule a student payment plan")
		@TestCaseFields(testCaseName = "Schedule a student payment plan")
		public void TC849_Scheduleastudentpaymentplan(StringHash data) throws Exception {

						StudentFlows.ScheduleStudentPaymentPlan(data);
					}
					
//Test 4
		@Test(enabled = true, dataProvider = "getData", priority = 18,alwaysRun = true, description ="Test Script to Schedule add promissory note", testName = "Adding  printing of Prom Notes to a student")
		@TestCaseFields(testCaseName = "Adding  printing of Prom Notes to a student")
		public void TC878_AddingprintingofPromNotestoastudent(StringHash data) throws Exception {

						StudentFlows.AddPromissoryNoteToAStudent(data);
					}
						
//Test 5
		@Test(enabled = true, dataProvider = "getData", priority = 19,alwaysRun = true, description ="Test Script to Perform Refund calculation", testName = "Perform a Refund Calculation")
		@TestCaseFields(testCaseName = "Perform a Refund Calculation")
		public void TC850_PerformaRefundCalculation(StringHash data) throws Exception {

						StudentFlows.PerformRefundCalculation(data);
					}
					
//Test 6
		@Test(enabled = true, dataProvider = "getData", priority = 20,alwaysRun = true, description ="Test Script to add estimated FA Packaging", testName = "Ability to add Estimated FA Packaging prior to Enrollment in a program of study to a student")
		@TestCaseFields(testCaseName = "Ability to add Estimated FA Packaging prior to Enrollment in a program of study to a student")
		public void TC884_AbilitytoaddEstimatedFAPackagingpriortoEnrollment(StringHash data) throws Exception {

						 StudentFlows.AddEstimatedFAPackaging(data);
					}
								
//Test 7
		@Test(enabled = true, dataProvider = "getData", priority = 21,alwaysRun = true, description ="Test Script to verify academic years information", testName = "Verify Academic Years information is correct in awards tab")
		@TestCaseFields(testCaseName = "Verify Academic Years information is correct in awards tab")
		public void TC884_VerifyAcademicYearsinformationiscorrectinawardstab(StringHash data) throws Exception {

						 StudentFlows.VerifyAcademicYearsInformation(data);
					}
				
//Test 8
		@Test(enabled = true, dataProvider = "getData", priority = 22,alwaysRun = true, description ="Test Script to post Federal work study Disbursements", testName = "Validate the ability to post Federal Work Study disbursements")
		@TestCaseFields(testCaseName = "Validate the ability to post Federal Work Study disbursements")
		public void TC888_ValidatetheabilitytopostFederalWorkStudydisbursements(StringHash data) throws Exception {

						  StudentFlows.PostFederalWorkStudyDisbursements(data);
					}
					
//Test 9
		@Test(enabled = true, dataProvider = "getData", priority = 23,alwaysRun = true, description ="Test Script to Edit the award information", testName = "Edit award information")
		@TestCaseFields(testCaseName = "Edit award information")
		public void TC892_Editawardinformation(StringHash data) throws Exception {

							StudentFlows.EditAwardInformation(data);
					}
											
//Test 10
		@Test(enabled = true, dataProvider = "getData", priority = 24,alwaysRun = true, description ="Test Script to Verify award Update has ben captured", testName = "verify  the award update was captured")
		@TestCaseFields(testCaseName = "verify  the award update was captured")
		public void TC892_verifytheawardupdatewascaptured(StringHash data) throws Exception {

							StudentFlows.VerifyAwardUpdate(data);
					}
					
//Test 11
		@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="Test Script for release to General Ledger", testName = "Release to General Ledger")
		@TestCaseFields(testCaseName = "Release to General Ledger")
		public void TC855_ReleaseToGeneralLedger(StringHash data) throws Exception {

							StudentFlows.ReleaseToGL(data);
					}		
//Test 12
		@Test(enabled = true, dataProvider = "getData", priority = 26,alwaysRun = true, description ="Test Script to approve FA Disbursements", testName = "Approving FA Disbursements to Pay in Batch form")
		@TestCaseFields(testCaseName = "Approving FA Disbursements to Pay in Batch form")
		public void TC887_ApprovingFADisbursementstoPayinBatchform(StringHash data) throws Exception {

							StudentFlows.ApproveFADisbursements(data);
					}
			
	@DataProvider
	public Object[][] getData(Method method) {

		return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
	}
}
