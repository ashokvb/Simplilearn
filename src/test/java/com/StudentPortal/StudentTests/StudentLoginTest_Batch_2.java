package com.StudentPortal.StudentTests;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.StudentPortal.Businessflow.StudentLoginFlow;
import com.framework.base.constants.FrameworkConstants;
import com.framework.core.AutomationTestPlan;
import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestCaseFields;
import com.framework.util.Xls_Reader;

public class StudentLoginTest_Batch_2 extends AutomationTestPlan {
	
	public StudentLoginTest_Batch_2() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  
//Test 1 - Tasks need to be configured to allow associating events with Students and validate the same task in the Dropdown

		@Test(enabled = true, dataProvider = "getData", priority = 12,alwaysRun = true, description ="Test Script to TasksneedtobeconfiguredtoallowassociatingeventswithStudents and validate the same task in the Dropdown", testName = "TC75_TasksneedtobeconfiguredtoallowassociatingeventswithStudentsandvalidatethesametaskintheDropdown")
		@TestCaseFields(testCaseName = "TC75_TasksneedtobeconfiguredtoallowassociatingeventswithStudentsandvalidatethesametaskintheDropdown")
		public void TC919_1_TasktoconftoallassoevewithStudents(StringHash data) throws Exception {

				StudentLoginFlow.StudentTaskConfiguration(data);
													
			    }
		
//Test 2 - Confirm tasks are available in the dropdown when working with an employer record. 

  	    @Test(enabled = true, dataProvider = "getData", priority = 13,alwaysRun = true, description ="Test Script to Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord", testName = "TC76_Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord")
  		@TestCaseFields(testCaseName = "TC76_Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord")
  		public void TC919_2_Conftaskdropdownemployerrecord(StringHash data) throws Exception {

  				StudentLoginFlow.ConfirmTaskConfigurationEmployeeDropdown(data);
  															
  				}
  	    
//Test 3 - Subsidiary Ledger - Post a Charge.

  			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaCharge", testName = "TC77_SubsidiaryLedgerPostaCharge")
  			@TestCaseFields(testCaseName = "TC77_SubsidiaryLedgerPostaCharge")
  			public void TC927_SubsidiaryLedgerPostaCharge(StringHash data) throws Exception {

  					StudentLoginFlow.SubLedgerPostaCharge(data);
  																		
  				}
  			
//Test 4 - Subsidiary Ledger - Adjust Transaction - Delete  

  			@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Test Script to SubsidiaryLedgerAdjustTransactionDelete", testName = "TC81_SubsidiaryLedgerAdjustTransactionDelete")
  			@TestCaseFields(testCaseName = "TC81_SubsidiaryLedgerAdjustTransactionDelete")
  			public void TC930_SubsidiaryLedgerAdjustTransactionDelete(StringHash data) throws Exception {

  					StudentLoginFlow.SubLedgerDelete(data);
  																		
  				}
//Test 5 - Ability to add a course section
 
		@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Test Script to Ability to add a course section", testName = "TC57_Abilitytoaddacoursesection")
		@TestCaseFields(testCaseName = "TC57_Abilitytoaddacoursesection")
		public void TC895_1_Abilitytoaddacoursesection(StringHash data) throws Exception {

				StudentLoginFlow.AddCourseSec(data);
																	
				}
				
//Test 6 - Edit existing course sections on the Master Schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Test Script to Edit existing course sections on the Master Schedule", testName = "TC58_EditexistingcoursesectionsontheMasterSchedule")
		@TestCaseFields(testCaseName = "TC58_EditexistingcoursesectionsontheMasterSchedule")
		public void TC895_2_EditexistingcoursesectionsontheMasterSchedule(StringHash data) throws Exception {

				StudentLoginFlow.EditExistingCourseSec(data);
																			
				}

//Test 7 - Batch Register students in a track

		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to Batch Register students in a track", testName = "TC70_BatchRegisterstudentsinatrack")
		@TestCaseFields(testCaseName = "TC70_BatchRegisterstudentsinatrack")
		public void TC909_BatchRegisterstudentsinatrack(StringHash data) throws Exception {

				StudentLoginFlow.BatchStudentRegestrationTrack(data);
															
				}
		
//Test 8 - Ability to batch unregister courses

		@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Test Script to Ability to batch unregister courses", testName = "TC71_Abilitytobatchunregistercourses")
		@TestCaseFields(testCaseName = "TC71_Abilitytobatchunregistercourses")
		public void TC918_Abilitytobatchunregistercourses(StringHash data) throws Exception {

				StudentLoginFlow.BatchStudentUnRegestrationTrack(data);
																	
				}
		
//Test 9 - Record batch Midterm Grades for a course. 

		@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Test Script to RecordbatchMidtermGradesforacourse", testName = "TC73_RecordbatchMidtermGradesforacourse")
		@TestCaseFields(testCaseName = "TC73_RecordbatchMidtermGradesforacourse")
		public void TC921_RecordbatchMidtermGradesforacourse(StringHash data) throws Exception {

				StudentLoginFlow.RecordMidTermGrades(data);
																		
				}
		
//Test 10 - Confirm documents have been created and associated with the Career Services module.

		@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="Test Script to ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule", testName = "TC74_ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule")
		@TestCaseFields(testCaseName = "TC74_ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule")
		public void TC922_ConfdoccreateassowithCarServmodule(StringHash data) throws Exception {

				StudentLoginFlow.ConfirmDocumentSchedule(data);
																		
				}
		
//Test 11 - Subsidiary Ledger - Post a Payment. 

		@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaPayment", testName = "TC78_SubsidiaryLedgerPostaPayment")
		@TestCaseFields(testCaseName = "TC78_SubsidiaryLedgerPostaPayment")
		public void TC928_SubsidiaryLedgerPostaPayment(StringHash data) throws Exception {

				StudentLoginFlow.SubLedgerPostPayment(data);
																					
				}
		
//Test 12 - Subsidiary Ledger Adjust Transaction - Void    
		
  		@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaRefund", testName = "TC82_SubsidiaryLedgerAdjustTransactionVoid")
  		@TestCaseFields(testCaseName = "TC82_SubsidiaryLedgerAdjustTransactionVoid")
  		public void TC931_SubsidiaryLedgerAdjustTransactionVoid(StringHash data) throws Exception {

  				StudentLoginFlow.SubTransactionsVoid(data);
														
				}
		
//Test 13 - Subsidiary Ledger Post a Refund    

  		@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaRefund   ", testName = "TC80_SubsidiaryLedgerPostaRefund")
  		@TestCaseFields(testCaseName = "TC80_SubsidiaryLedgerPostaRefund")
  		public void TC929_SubsidiaryLedgerPostaRefund(StringHash data) throws Exception {

  				StudentLoginFlow.SubPostRefund(data);
														
				}
    @DataProvider
	public Object[][] getData(Method method) {

	return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
	
	}
}
