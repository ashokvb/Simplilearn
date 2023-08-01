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

public class StudentTests_Batch1_1 extends AutomationTestPlan {
	
	public StudentTests_Batch1_1() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  

//Test 1
			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to add tasks to student", testName = "Add tasks to a student")
			@TestCaseFields(testCaseName = "Add tasks to a student")
			public void TC879_Addtaskstoastudent(StringHash data) throws Exception {

				StudentFlows.AddTasksToAStudent(data);
			}
			
						
//Test 2
			@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Test Script to confirm pending tasks", testName = "Confirm pending Tasks exist in Contact Manager for student")
			@TestCaseFields(testCaseName = "Confirm pending Tasks exist in Contact Manager for student")
			public void TC882_ConfirmpendingTasksexistinContactManagerforstudent(StringHash data) throws Exception {

				StudentFlows.ConfirmPendingTasksToAStudent(data);
			}
			
					
//Test 3
			@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="Test Script to confirm pending tasks", testName = "Confirm pending Tasks exist for Staff")
			@TestCaseFields(testCaseName = "Confirm pending Tasks exist for Staff")
			public void TC882_ConfirmpendingTasksexistforStaff(StringHash data) throws Exception {

				StudentFlows.ConfirmPendingTasksForStaff(data);
			}
						
//Test 4
			@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Test Script to edit tasks", testName = "Confirm that pending Tasks in Contact Manager can be edited by Student")
			@TestCaseFields(testCaseName = "Confirm that pending Tasks in Contact Manager can be edited by Student")
			public void TC883_ConfirmthatpendingTasksinContactManagercanbeeditedbyStudent(StringHash data) throws Exception {

				 StudentFlows.EditPendingTasksByStudent(data);
			}
						
//Test 5
			@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Test Script to edit tasks", testName = "Confirm that pending Tasks can be edited by Staff")
			@TestCaseFields(testCaseName = "Confirm that pending Tasks can be edited by Staff")
			public void TC883_ConfirmthatpendingTaskscanbeeditedbyStaff(StringHash data) throws Exception {

				  StudentFlows.EditPendingTasksByStaff(data);
			}
			
//Test 6
			@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Test Script to close tasks from Staff", testName = "Closing the tasks from the Contact Manager by Staff")
			@TestCaseFields(testCaseName = "Closing the tasks from the Contact Manager by Staff")
			public void TC880_ClosingthetasksfromtheContactManagerbyStaff(StringHash data) throws Exception {

				   StudentFlows.CloseTheTasksFromStaff(data);
			}
						
//Test 7
			@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Test Script to update admin rep for a student", testName = "Update Admissions Rep for a student")
			@TestCaseFields(testCaseName = "Update Admissions Rep for a student")
			public void TC876_UpdateAdmissionsRepforastudent(StringHash data) throws Exception {

					StudentFlows.UpdateAdminRepForStudent(data);
			}
					
//Test 8
			@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to perform batch rep assignment", testName = "Perform Batch Admissions Rep Reassignment")
			@TestCaseFields(testCaseName = "Perform Batch Admissions Rep Reassignment")
			public void TC876_PerformBatchAdmissionsRepReassignment(StringHash data) throws Exception {

					 StudentFlows.UpdateAdminRepInBatch(data);
			}
					
//Test 9
			@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Test Script to perform revenue recognition", testName = "Perform Revenue Recognition")
			@TestCaseFields(testCaseName = "Perform Revenue Recognition")
			public void TC854_PerformRevenueRecognition(StringHash data) throws Exception {

						StudentFlows.PerformRevenueRecognition(data);
			}
					
//Test 10
			@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Test Script to add SMS Service Provider", testName = "Add SMS Service providers under configuration")
			@TestCaseFields(testCaseName = "Add SMS Service providers under configuration")
			public void TC875_AddSMSServiceprovidersunderconfiguration(StringHash data) throws Exception {

						StudentFlows.AddSMSServiceProvider(data);
			}
					
//Test 11
			@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Test Script to send SMS to students", testName = "Verify appropriate configuration enables the ability to send SMS (text messages) to students")
			@TestCaseFields(testCaseName = "Verify appropriate configuration enables the ability to send SMS (text messages) to students")
			public void TC875_VerifyappropriateconfigurationenablestheabilitytosendSMStostudents(StringHash data) throws Exception {

						StudentFlows.VerifySMSConfiguration(data);
			}
					
//Test 12
			@Test(enabled = true, dataProvider = "getData", priority = 12,alwaysRun = true, description ="Test Script to add new information to school fields", testName = "Confirm new information can be added to field(s)")
			@TestCaseFields(testCaseName = "Confirm new information can be added to field(s)")
			public void TC891_Confirmnewinformationcanbeaddedtofields(StringHash data) throws Exception {

						 StudentFlows.AddSchoolFields(data);
			}
				
//Test 13
			@Test(enabled = true, dataProvider = "getData", priority = 13,alwaysRun = true, description ="Test Script to Add new employers", testName = "Validate the ability to add new employers")
			@TestCaseFields(testCaseName = "Validate the ability to add new employers")
			public void TC894_Validatetheabilitytoaddnewemployers(StringHash data) throws Exception {

						  StudentFlows.AddNewEmployers(data);
			}
					
//Test 14
			@Test(enabled = true, dataProvider = "getData", priority = 14,alwaysRun = true, description ="Test Script to place students in Externship position", testName = "Place students into an externship Position")
			@TestCaseFields(testCaseName = "Place students into an externship Position")
			public void TC893_PlacestudentsintoanexternshipPosition(StringHash data) throws Exception {

						  StudentFlows.PlaceStudentsIntoExternshipPosition(data);
			}
				
	@DataProvider
	public Object[][] getData(Method method) {

		return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
	}
}
