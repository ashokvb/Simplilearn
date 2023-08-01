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

public class StudentTests_Batch1 extends AutomationTestPlan {
	
	public StudentTests_Batch1() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  
//Test 1	
	@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Create a term", testName = "TC22_Create a new term")
	@TestCaseFields(testCaseName = "TC22_Create a new term")
	public void TC22Createanewterm(StringHash data) throws Exception {

		StudentFlows.CreateTerm(data);
	  }
	
//Test 2
	@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC33_Create a Class Schedule for a term")
	@TestCaseFields(testCaseName = "TC33_Create a Class Schedule for a term")
	public void TC33CreateaClassScheduleforaterm(StringHash data) throws Exception {

		StudentFlows.ScheduleClass(data);
	   }
	
//Test 3
		@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC32_Register a course to the enrolled student")
		@TestCaseFields(testCaseName = "TC32_Register a course to the enrolled student")
		public void TC32Registeracoursetotheenrolledstudent(StringHash data) throws Exception {

		StudentFlows.RegisterCourseToStudent(data);
		}
			
//Test 4
		@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC34_Drop the course from the student")
		@TestCaseFields(testCaseName = "TC34_Drop the course from the student")
		public void TC34Dropthecoursefromthestudent(StringHash data) throws Exception {

		StudentFlows.DropCourseFromStudent(data);
		}
				
//Test 5
		@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC31_Reinstate the course to the student")
		@TestCaseFields(testCaseName = "TC31_Reinstate the course to the student")
		public void TC31Reinstatethecoursetothestudent(StringHash data) throws Exception {

		StudentFlows.ReinstateCourseToTheStudent(data);
		}
		
//Test 6
		@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC35_Unregister the course from the student")
		@TestCaseFields(testCaseName = "TC35_Unregister the course from the student")
		public void TC35Unregisterthecoursefromthestudent(StringHash data) throws Exception {

		StudentFlows.UnregisterCourseFromStudent(data);
		}
		
//Test 7
		@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC37_Add a letter grade to a particular course under a student")
		@TestCaseFields(testCaseName = "TC37_Add a letter grade to a particular course under a student")
		public void TC37Addalettergradetoaparticularcourseunderastudent(StringHash data) throws Exception {

		StudentFlows.AddLetterGradeToStudent(data);
		}
			
//Test 8
		@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC36_Add letter Grades from the Grade scale under the configuration")
		@TestCaseFields(testCaseName = "TC36_Add letter Grades from the Grade scale under the configuration")
		public void TC36AddletterGradesfromtheGradescaleundertheconfiguration(StringHash data) throws Exception {

		StudentFlows.AddLetterGradeFromGradeScale(data);
		 }
				
//Test 9
		@Test(enabled = true, dataProvider = "getData", priority = 100,alwaysRun = true, description ="Test Script to Schedule a class section for a term", testName = "TC30_Create a new enrollment for a student")
		@TestCaseFields(testCaseName = "TC30_Create a new enrollment for a student")
		public void TC30Createanewenrollmentforastudent(StringHash data) throws Exception {

		StudentFlows.CreateEnrollmentForStudent(data);
		 }
			
//Test 10
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to add tasks to student", testName = "Add tasks to a student")
		@TestCaseFields(testCaseName = "Add tasks to a student")
		public void TC879_Addtaskstoastudent(StringHash data) throws Exception {

		StudentFlows.AddTasksToAStudent(data);
		  }
			
//Test 11
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Test Script to confirm pending tasks", testName = "Confirm pending Tasks exist in Contact Manager for student")
		@TestCaseFields(testCaseName = "Confirm pending Tasks exist in Contact Manager for student")
		public void TC882_ConfirmpendingTasksexistinContactManagerforstudent(StringHash data) throws Exception {

		StudentFlows.ConfirmPendingTasksToAStudent(data);
		   }
			
//Test 12
		@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="Test Script to confirm pending tasks", testName = "Confirm pending Tasks exist for Staff")
		@TestCaseFields(testCaseName = "Confirm pending Tasks exist for Staff")
		public void TC882_ConfirmpendingTasksexistforStaff(StringHash data) throws Exception {

		StudentFlows.ConfirmPendingTasksForStaff(data);
		    }
		
		
//Test 13
		@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Test Script to edit tasks", testName = "Confirm that pending Tasks in Contact Manager can be edited by Student")
		@TestCaseFields(testCaseName = "Confirm that pending Tasks in Contact Manager can be edited by Student")
		public void TC883_ConfirmthatpendingTasksinContactManagercanbeeditedbyStudent(StringHash data) throws Exception {

		StudentFlows.EditPendingTasksByStudent(data);
		     }
		
		
//Test 14
		@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Test Script to edit tasks", testName = "Confirm that pending Tasks can be edited by Staff")
		@TestCaseFields(testCaseName = "Confirm that pending Tasks can be edited by Staff")
		public void TC883_ConfirmthatpendingTaskscanbeeditedbyStaff(StringHash data) throws Exception {

		StudentFlows.EditPendingTasksByStaff(data);
		     }
		

//Test 15
		@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Test Script to close tasks from Staff", testName = "Closing the tasks from the Contact Manager by Staff")
		@TestCaseFields(testCaseName = "Closing the tasks from the Contact Manager by Staff")
		public void TC880_ClosingthetasksfromtheContactManagerbyStaff(StringHash data) throws Exception {

		StudentFlows.CloseTheTasksFromStaff(data);
		     }
				
//Test 16
		@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Test Script to update admin rep for a student", testName = "Update Admissions Rep for a student")
		@TestCaseFields(testCaseName = "Update Admissions Rep for a student")
		public void TC876_UpdateAdmissionsRepforastudent(StringHash data) throws Exception {

		StudentFlows.UpdateAdminRepForStudent(data);
		      }
		
	
//Test 17
		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to perform batch rep assignment", testName = "Perform Batch Admissions Rep Reassignment")
		@TestCaseFields(testCaseName = "Perform Batch Admissions Rep Reassignment")
		public void TC876_PerformBatchAdmissionsRepReassignment(StringHash data) throws Exception {

		 StudentFlows.UpdateAdminRepInBatch(data);
				}
			
//Test 18
		@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Test Script to perform revenue recognition", testName = "Perform Revenue Recognition")
		@TestCaseFields(testCaseName = "Perform Revenue Recognition")
		public void TC854_PerformRevenueRecognition(StringHash data) throws Exception {

		StudentFlows.PerformRevenueRecognition(data);
				}
			
//Test 19
		@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Test Script to add SMS Service Provider", testName = "Add SMS Service providers under configuration")
		@TestCaseFields(testCaseName = "Add SMS Service providers under configuration")
		public void TC875_AddSMSServiceprovidersunderconfiguration(StringHash data) throws Exception {

		StudentFlows.AddSMSServiceProvider(data);
				}
			
//Test 20
		@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Test Script to send SMS to students", testName = "Verify appropriate configuration enables the ability to send SMS (text messages) to students")
		@TestCaseFields(testCaseName = "Verify appropriate configuration enables the ability to send SMS (text messages) to students")
		public void TC875_VerifyappropriateconfigurationenablestheabilitytosendSMStostudents(StringHash data) throws Exception {

		StudentFlows.VerifySMSConfiguration(data);
				}
			
//Test 21
		@Test(enabled = true, dataProvider = "getData", priority = 12,alwaysRun = true, description ="Test Script to add new information to school fields", testName = "Confirm new information can be added to field(s)")
		@TestCaseFields(testCaseName = "Confirm new information can be added to field(s)")
		public void TC891_Confirmnewinformationcanbeaddedtofields(StringHash data) throws Exception {

		StudentFlows.AddSchoolFields(data);
				}
			
//Test 22
		@Test(enabled = true, dataProvider = "getData", priority = 13,alwaysRun = true, description ="Test Script to Add new employers", testName = "Validate the ability to add new employers")
		@TestCaseFields(testCaseName = "Validate the ability to add new employers")
		public void TC894_Validatetheabilitytoaddnewemployers(StringHash data) throws Exception {

		StudentFlows.AddNewEmployers(data);
				}
			
//Test 23
		@Test(enabled = true, dataProvider = "getData", priority = 14,alwaysRun = true, description ="Test Script to place students in Externship position", testName = "Place students into an externship Position")
		@TestCaseFields(testCaseName = "Place students into an externship Position")
		public void TC893_PlacestudentsintoanexternshipPosition(StringHash data) throws Exception {

		 StudentFlows.PlaceStudentsIntoExternshipPosition(data);
				}
			
//Test 24
		@Test(enabled = true, dataProvider = "getData", priority = 15,alwaysRun = true, description ="Test Script to approove Un approved Aid", testName = "Verify unapproved aid can be batched and approved for disbursement")
		@TestCaseFields(testCaseName = "Verify unapproved aid can be batched and approved for disbursement")
		public void TC874_Verifyunapprovedaidcanbebatchedandapprovedfordisbursement(StringHash data) throws Exception {

		StudentFlows.ApproveUnapprovedAid(data);
				}
				
//Test 25
		@Test(enabled = true, dataProvider = "getData", priority = 16,alwaysRun = true, description ="Test Script to Configure a Promissory Note", testName = "Configuring  printing of Prom Notes from FA module")
		@TestCaseFields(testCaseName = "Configuring  printing of Prom Notes from FA module")
		public void TC878_ConfiguringprintingofPromNotesfromFAmodule(StringHash data) throws Exception {

		StudentFlows.ConfigurePromissoryNote(data);
				}
			
//Test 26
		@Test(enabled = true, dataProvider = "getData", priority = 17,alwaysRun = true, description ="Test Script to Schedule a Student Payment Plan", testName = "Schedule a student payment plan")
		@TestCaseFields(testCaseName = "Schedule a student payment plan")
		public void TC849_Scheduleastudentpaymentplan(StringHash data) throws Exception {

		StudentFlows.ScheduleStudentPaymentPlan(data);
				}
		
		
//Test 27
		@Test(enabled = true, dataProvider = "getData", priority = 18,alwaysRun = true, description ="Test Script to Schedule add promissory note", testName = "Adding  printing of Prom Notes to a student")
		@TestCaseFields(testCaseName = "Adding  printing of Prom Notes to a student")
		public void TC878_AddingprintingofPromNotestoastudent(StringHash data) throws Exception {

		StudentFlows.AddPromissoryNoteToAStudent(data);
				}
				
//Test 28
		@Test(enabled = true, dataProvider = "getData", priority = 19,alwaysRun = true, description ="Test Script to Perform Refund calculation", testName = "Perform a Refund Calculation")
		@TestCaseFields(testCaseName = "Perform a Refund Calculation")
		public void TC850_PerformaRefundCalculation(StringHash data) throws Exception {

		StudentFlows.PerformRefundCalculation(data);
				}
				
//Test 29
		@Test(enabled = true, dataProvider = "getData", priority = 20,alwaysRun = true, description ="Test Script to add estimated FA Packaging", testName = "Ability to add Estimated FA Packaging prior to Enrollment in a program of study to a student")
		@TestCaseFields(testCaseName = "Ability to add Estimated FA Packaging prior to Enrollment in a program of study to a student")
		public void TC884_AbilitytoaddEstimatedFAPackagingpriortoEnrollment(StringHash data) throws Exception {

		StudentFlows.AddEstimatedFAPackaging(data);
				}
							
//Test 30
		@Test(enabled = true, dataProvider = "getData", priority = 21,alwaysRun = true, description ="Test Script to verify academic years information", testName = "Verify Academic Years information is correct in awards tab")
		@TestCaseFields(testCaseName = "Verify Academic Years information is correct in awards tab")
		public void TC884_VerifyAcademicYearsinformationiscorrectinawardstab(StringHash data) throws Exception {

		 StudentFlows.VerifyAcademicYearsInformation(data);
				}
			
//Test 31
		@Test(enabled = true, dataProvider = "getData", priority = 22,alwaysRun = true, description ="Test Script to post Federal work study Disbursements", testName = "Validate the ability to post Federal Work Study disbursements")
		@TestCaseFields(testCaseName = "Validate the ability to post Federal Work Study disbursements")
		public void TC888_ValidatetheabilitytopostFederalWorkStudydisbursements(StringHash data) throws Exception {

		StudentFlows.PostFederalWorkStudyDisbursements(data);
				}
			
//Test 32
		@Test(enabled = true, dataProvider = "getData", priority = 23,alwaysRun = true, description ="Test Script to Edit the award information", testName = "Edit award information")
		@TestCaseFields(testCaseName = "Edit award information")
		public void TC892_Editawardinformation(StringHash data) throws Exception {

		StudentFlows.EditAwardInformation(data);
				}
										
//Test 33
		@Test(enabled = true, dataProvider = "getData", priority = 24,alwaysRun = true, description ="Test Script to Verify award Update has ben captured", testName = "verify  the award update was captured")
		@TestCaseFields(testCaseName = "verify  the award update was captured")
		public void TC892_verifytheawardupdatewascaptured(StringHash data) throws Exception {

		 StudentFlows.VerifyAwardUpdate(data);
				}
			
//Test 34
		@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="Test Script for release to General Ledger", testName = "Release to General Ledger")
		@TestCaseFields(testCaseName = "Release to General Ledger")
		public void TC855_ReleaseToGeneralLedger(StringHash data) throws Exception {

		StudentFlows.ReleaseToGL(data);
				}
			
//Test 35
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
