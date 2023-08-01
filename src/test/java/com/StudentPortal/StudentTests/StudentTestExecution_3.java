package com.StudentPortal.StudentTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StudentPortal.Businessflow.StudentFlows;
import com.StudentPortal.Businessflow.StudentTestFlow;
import com.StudentPortal.Pages.StudentProgramGroupCreation;
import com.StudentPortal.Pages.StudentProgramPage;
import com.framework.base.constants.FrameworkConstants;
import com.framework.core.AutomationTestPlan;
import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestCaseFields;
import com.framework.util.Xls_Reader;

public class StudentTestExecution_3 extends AutomationTestPlan {
	
	public StudentTestExecution_3() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
//Test 1
		@Test(enabled = true, dataProvider = "getData", priority = 32,alwaysRun = true, description ="Test Script to post a payment ", testName = "TC847_Post a Payment for a Student")
		@TestCaseFields(testCaseName = "TC847_Post a Payment for a Student")
		public void TC847_PostLedgerPaymentForStudent(StringHash data) throws Exception {

			StudentTestFlow.LedgerPayment(data);
		   }
		
		
//Test 41 -- *Prerequisite script*
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to create Academic Year", testName = "Creation of Academic Year")
		@TestCaseFields(testCaseName = "Creation of Academic Year")
		public void CreationOfAcademicYear(StringHash data) throws Exception {

			StudentTestFlow.AcademicYear(data);
		}
		
//Test 2
			@Test(enabled = true, dataProvider = "getData", priority = 33,alwaysRun = true, description ="Test Script to post an FA Disburdement", testName = "TC848_Post an FA Disbursement for a Student")
			@TestCaseFields(testCaseName = "TC848_Post an FA Disbursement for a Student")
			public void TC848_PostFADisbursementForStudent(StringHash data) throws Exception {

				StudentTestFlow.LedgerFADisbursement(data);
			}
			
//Test 3
   			@Test(enabled = true, dataProvider = "getData", priority = 34,alwaysRun = true, description ="Test Script to verify the disbursement data", testName = "TC848_1_Verify Disbursement Data")
   			@TestCaseFields(testCaseName = "TC848_1_Verify Disbursement Data")
   			public void TC848_1_VerifyDisbursementData(StringHash data) throws Exception {

   				StudentTestFlow.VerifyDisbursementData(data);
   			}
//Test 4
   			@Test(enabled = true, dataProvider = "getData", priority = 29,alwaysRun = true, description ="Test Script to create a student group ", testName = "TC234_1_Verify Registration Locks_Create a Student Group")
   			@TestCaseFields(testCaseName = "TC234_1_Verify Registration Locks_Create a Student Group")
   			public void TC234_1_CreateStudentGroup(StringHash data) throws Exception {

   				StudentTestFlow.StudentGroupCreation(data);
   			}

//Test 5
   			@Test(enabled = true, dataProvider = "getData", priority = 30,alwaysRun = true, description ="Test Script to add Student to a Group ", testName = "TC234_2_Add Student to a Group")
   			@TestCaseFields(testCaseName = "TC234_2_Add Student to a Group")
   			public void TC234_2_AddStudentToGroup(StringHash data) throws Exception {

   				StudentTestFlow.AddStudentToStudentGroup(data);
   			}
 
//Test 6
   			@Test(enabled = true, dataProvider = "getData", priority = 31,alwaysRun = true, description ="Test Script to create Registration locks ", testName = "TC234_3_Create Registration locks for a Student Group")
   			@TestCaseFields(testCaseName = "TC234_3_Create Registration locks for a Student Group")
   			public void TC234_3_CreateRegistrationLocks(StringHash data) throws Exception {

   				StudentTestFlow.RegistrationLocksCreation(data);
   			}			
//Test 7
   			@Test(enabled = true, dataProvider = "getData", priority = 37,alwaysRun = true, description ="Test Script to verify minimum limit", testName = "TC234_5_Verify Minimum Limit Registration Lock")
   			@TestCaseFields(testCaseName = "TC234_5_Verify Minimum Limit Registration Lock")
   			public void TC234_5_VerifyMinimumLimitRegistrationLock(StringHash data) throws Exception {

   				StudentTestFlow.VerifyMinimumRegistrationLimit(data);
   			}

//Test 8
   			@Test(enabled = true, dataProvider = "getData", priority = 38,alwaysRun = true, description ="Test Script to verify maximum limit", testName = "TC234_4_Verify Maximum Limit Registration Lock")
   			@TestCaseFields(testCaseName = "TC234_4_Verify Maximum Limit Registration Lock")
   			public void TC234_4_VerifyMaximumLimitRegistrationLock(StringHash data) throws Exception {

   				StudentTestFlow.VerifyMaximumRegistrationLimit(data);
   			}

//Test 9
   			@Test(enabled = true, dataProvider = "getData", priority = 39,alwaysRun = true, description ="Test Script to verify schedule limit", testName = "TC234_6_Verify Schedule Registration Lock")
   			@TestCaseFields(testCaseName = "TC234_6_Verify Schedule Registration Lock")
   			public void TC234_6_VerifyScheduleRegistrationLock(StringHash data) throws Exception {

   				StudentTestFlow.VerifyScheduleRegistrationLock(data);
   			}
   			
//Test 10
   			@Test(enabled = true, dataProvider = "getData", priority = 36,alwaysRun = true, description ="Test Script to perform Program Change", testName = "TC223_Perform a Program Change for a Student")
   			@TestCaseFields(testCaseName = "TC223_Perform a Program Change for a Student")
   			public void TC223_PerformProgramChangeForStudent(StringHash data) throws Exception {

   				StudentTestFlow.PerformProgramChange(data);
   			}
   			
//Test 11
   			@Test(enabled = true, dataProvider = "getData", priority = 12,alwaysRun = true, description ="Test Script to reassign FA to other Academic year", testName = "TC194_Reassignment of FA to Other Academic year")
   			@TestCaseFields(testCaseName = "TC194_Reassignment of FA to Other Academic year")
   			public void TC194_ReassignmentofFAToOtherAcademicYear(StringHash data) throws Exception {

   				StudentTestFlow.FAReassignment(data);
   			}
	
}