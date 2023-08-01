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

public class StudentTestExecution extends AutomationTestPlan {
	
	public StudentTestExecution() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  
//Test 1	
			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to Verify the Degree Creation", testName = "TC28_Create a new Degree under configuration")
			@TestCaseFields(testCaseName = "TC28_Create a new Degree under configuration")
			public void TC28_CreateNewDegreeUnderConfiguration(StringHash data) throws Exception {

				StudentTestFlow.DegreeCreation(data);
			}

//Test 2
			@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Test Script to Verify Program Group Creation", testName = "TC29_Create a new program group")
			@TestCaseFields(testCaseName = "TC29_Create a new program group")
			public void TC29_CreateProgramGroup(StringHash data) throws Exception {

				StudentTestFlow.CreatePG(data);
			}

//Test 3
			@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="Test Script to Verify Program Creation", testName = "TC26_Create a new program")
			@TestCaseFields(testCaseName = "TC26_Create a new program")
			public void TC26_CreateNewProgram(StringHash data) throws Exception {

				StudentTestFlow.CreateProgramFlow(data);
			} 
	
 //Test 4
   			@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Test Script to Verify Tranfer Types Creation", testName = "TC21_Create And Verify The New Transfer Type")
   			@TestCaseFields(testCaseName = "TC21_Create And Verify The New Transfer Type")
   			public void TC21_CreateTransferType(StringHash data) throws Exception {

   				StudentTestFlow.CreateAndVerifyTheNewTransferType(data);
   			} 
//Test 5
   			@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Test Script to Verify Parent and Child Terms Creation", testName = "TC23_Create Parent and child term")
   			@TestCaseFields(testCaseName = "TC23_Create Parent and child term")
   			public void TC23_CreateParentAndChildTerm(StringHash data) throws Exception {

   				StudentTestFlow.CreateParentAndChildTerm(data);
   			}    
   
//Test 6
   			@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Test Script to Verify Student Application Creation", testName = "TC24_Add new application to a student")
   			@TestCaseFields(testCaseName = "TC24_Add new application to a student")
   			public void TC24_AddNewApplicationToStudent(StringHash data) throws Exception {

   				StudentTestFlow.StudentApplicationFlow(data);
   			}   

//Test 7
   			@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Test Script to update Student Application", testName = "TC25_Update/Edit the application of a student")
   			@TestCaseFields(testCaseName = "TC25_Update/Edit the application of a student")
   			public void TC25_UpdatetheApplicationOfStudent(StringHash data) throws Exception {

   				StudentTestFlow.UpdateStudentApplication(data);
   			}

 //Test 8
   			@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to update Student Application", testName = "TC27_Create a new program version")
   			@TestCaseFields(testCaseName = "TC27_Create a new program version")
   			public void TC27_CreateNewProgramVersion(StringHash data) throws Exception {

   				StudentTestFlow.CreateProgramVersion(data);
   			}

 //Test 9
   			@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to place students into job", testName = "TC163_Use the Placement wizard to place students into a job")
   			@TestCaseFields(testCaseName = "TC163_Use the Placement wizard to place students into a job")
   			public void TC163_PlaceStudentsIntoJob(StringHash data) throws Exception {

   				StudentTestFlow.PlacementsInternships(data);
   			}

//Test 10
   			@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Test Script to Enroll a student", testName = "TC248_Place Graduate Student into Internship")
   			@TestCaseFields(testCaseName = "TC248_Place Graduate Student into Internship")
   			public void TC248_PlaceGraduateStudentIntoInternship(StringHash data) throws Exception {

   				StudentTestFlow.GraduateInternship(data);
   			}

//Test 11
   			@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Test Script to Enroll a student", testName = "TC267_Place Graduate Student into Externship")
   			@TestCaseFields(testCaseName = "TC267_Place Graduate Student into Externship")
   			public void TC267_PlaceGraduateStudentIntoExternship(StringHash data) throws Exception {

   				StudentTestFlow.GraduateExternship(data);
   			}

//Test 12
   			@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Test Script to Verify Student Application Creation", testName = "TC831_Student Application Creation")
   			@TestCaseFields(testCaseName = "TC831_Student Application Creation")
   			public void TC831_StudentApplicationCreation(StringHash data) throws Exception {

   				StudentTestFlow.StudentApplicationFlow(data);
   			} 
//Test 13
   			@Test(enabled = true, dataProvider = "getData", priority = 32,alwaysRun = true, description ="Test Script to reassign FA to other Academic year", testName = "TC194_Reassignment of FA to Other Academic year")
   			@TestCaseFields(testCaseName = "TC194_Reassignment of FA to Other Academic year")
   			public void TC194_ReassignmentofFAToOtherAcademicYear(StringHash data) throws Exception {

   				StudentTestFlow.FAReassignment(data);
   			} 

//Test 14
   			@Test(enabled = true, dataProvider = "getData", priority = 13,alwaysRun = true, description ="Test Script to register a course", testName = "TC833_Register a course to the enrolled student")
   			@TestCaseFields(testCaseName = "TC833_Register a course to the enrolled student")
   			public void TC832_Registeracoursetotheenrolledstudent(StringHash data) throws Exception {

   				StudentTestFlow.RegisterCourseToStudent(data);
   			}

//Test 15
   			@Test(enabled = true, dataProvider = "getData", priority = 14,alwaysRun = true, description ="Test Script to drop a course", testName = "TC834_Drop a course from the student schedule")
   			@TestCaseFields(testCaseName = "TC834_Drop a course from the student schedule")
   			public void TC834_DropCoursefromtheStudent(StringHash data) throws Exception {

   				StudentTestFlow.DropCourseFromStudentSchedule(data);
   			}

//Test 16
   			@Test(enabled = true, dataProvider = "getData", priority = 15,alwaysRun = true, description ="Test Script to post Individual Attendence for Students", testName = "TC838_Record individual attendance for students")
   			@TestCaseFields(testCaseName = "TC838_Record individual attendance for students")
   			public void TC838_RecordIndividualAttendanceForStudents  (StringHash data) throws Exception {

   				StudentTestFlow.RecordIndividualAttendence(data);
   			}

//Test 17
   			@Test(enabled = true, dataProvider = "getData", priority = 16,alwaysRun = true, description ="Test Script to post Individual Final Grades for Students", testName = "TC836_Record individual final grades for a student")
   			@TestCaseFields(testCaseName = "TC836_Record individual final grades for a student")
   			public void TC836_RecordIndividualFinalGradesForStudents  (StringHash data) throws Exception {

   				StudentTestFlow.RecordIndividualFinalGrades(data);
   			}

//Test 18
   			@Test(enabled = true, dataProvider = "getData", priority = 17,alwaysRun = true, description ="Test Script to print Awards Summary", testName = "TC209_Summary document can be printed for individual students")
   			@TestCaseFields(testCaseName = "TC209_Summary document can be printed for individual students")
   			public void TC848_PrintAwardSummary(StringHash data) throws Exception {

   				StudentTestFlow.PrintAwardSummary(data);
   			}

//Test 19
   			@Test(enabled = true, dataProvider = "getData", priority = 18,alwaysRun = true, description ="Test Script to perform Program Change", testName = "TC223_Perform a Program Change for a Student")
   			@TestCaseFields(testCaseName = "TC223_Perform a Program Change for a Student")
   			public void TC223_PerformProgramChangeForStudent(StringHash data) throws Exception {

   				StudentTestFlow.PerformProgramChange(data);
   			}


//Test 20
   			@Test(enabled = true, dataProvider = "getData", priority = 19,alwaysRun = true, description ="Test Script to change student status", testName = "TC240_Perform Status Changes")
   			@TestCaseFields(testCaseName = "TC240_Perform Status Changes")
   			public void TC240_StudentStatusChange(StringHash data) throws Exception {

   				StudentTestFlow.PerformStatusChanges(data);
   			}

//Test 21
   			@Test(enabled = true, dataProvider = "getData", priority = 20,alwaysRun = true, description ="Test Script to close the task", testName = "TC203_Contact Manager Task Close")
   			@TestCaseFields(testCaseName = "TC203_Contact Manager Task Close")
   			public void TC203_StudentTaskClose(StringHash data) throws Exception {

   				StudentTestFlow.CloseTaskContactManager(data);
   			}

//Test 22
   			@Test(enabled = true, dataProvider = "getData", priority = 21,alwaysRun = true, description ="Test Script to post a charge", testName = "TC845_Post a Charge to Student Ledger card")
   			@TestCaseFields(testCaseName = "TC845_Post a Charge to Student Ledger card")
   			public void TC845_PostChargeToStudentLedger(StringHash data) throws Exception {

   				StudentTestFlow.PostChargeforStudent(data);
   			}

//Test 23
   			@Test(enabled = true, dataProvider = "getData", priority = 22,alwaysRun = true, description ="Test Script to post a refund directly to Ledger Card", testName = "TC844_Ledger Card - Post a Refund (directly to Ledger Card)")
   			@TestCaseFields(testCaseName = "TC844_Ledger Card - Post a Refund (directly to Ledger Card)")
   			public void TC844_PostRefundToStudentLedger(StringHash data) throws Exception {

   				StudentTestFlow.PostRefundforStudent(data);
   			}

//Test 24
   			@Test(enabled = true, dataProvider = "getData", priority = 23,alwaysRun = true, description ="Test Script to post enter transfer credits", testName = "TC835_Enter Transfer Credits")
   			@TestCaseFields(testCaseName = "TC835_Enter Transfer Credits")
   			public void TC835_TransferCredits(StringHash data) throws Exception {

   				StudentTestFlow.TransferCredits(data);
   			}

//Test 25
   			@Test(enabled = true, dataProvider = "getData", priority = 24,alwaysRun = true, description ="Test Script to verify SAP calculation", testName = "TC841_Verify SAP")
   			@TestCaseFields(testCaseName = "TC841_Verify SAP")
   			public void TC841_VerifySAPCalculation(StringHash data) throws Exception {

   				StudentTestFlow.VerifySAP(data);
   			}

//Test 26
   			@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="Test Script to add FA document", testName = "TC216_FA Documents to Individual Students")
   			@TestCaseFields(testCaseName = "TC216_FA Documents to Individual Students")
   			public void TC216_FADocumentsToIndividualStudents(StringHash data) throws Exception {

   				StudentTestFlow.FADocument(data);
   			}

//Test 27
   			@Test(enabled = true, dataProvider = "getData", priority = 26,alwaysRun = true, description ="Test Script to add FA document List", testName = "TC216_FA Document List to Individual Students")
   			@TestCaseFields(testCaseName = "TC216_FA Document List to Individual Students")
   			public void TC216_FADocumentListToIndividualStudents(StringHash data) throws Exception {

   				StudentTestFlow.FADocumentList(data);
   			}

//Test 28
   			@Test(enabled = true, dataProvider = "getData", priority = 27,alwaysRun = true, description ="Test Script to verufy Disbursement Approval Criteria ", testName = "TC843_Verify Disbursement Approval Criteria is configured accurately")
   			@TestCaseFields(testCaseName = "TC843_Verify Disbursement Approval Criteria is configured accurately")
   			public void TC843_VerifyDisbursementApprovalCriteria(StringHash data) throws Exception {

   				StudentTestFlow.ApproveDisbursementToPay(data);
   			}	 		

//Test 29
   			@Test(enabled = true, dataProvider = "getData", priority = 28,alwaysRun = true, description ="Test Script to schedule a stipend ", testName = "TC846_Schedule a Stipend for a student")
   			@TestCaseFields(testCaseName = "TC846_Schedule a Stipend for a student")
   			public void TC846_ScheduleStipendForStudent(StringHash data) throws Exception {

   				StudentTestFlow.StipedSchedule(data);
   			}

//Test 30
   			@Test(enabled = true, dataProvider = "getData", priority = 32,alwaysRun = true, description ="Test Script to create a student group ", testName = "TC234_1_Verify Registration Locks_Create a Student Group")
   			@TestCaseFields(testCaseName = "TC234_1_Verify Registration Locks_Create a Student Group")
   			public void TC234_1_CreateStudentGroup(StringHash data) throws Exception {

   				StudentTestFlow.StudentGroupCreation(data);
   			}

//Test 31
   			@Test(enabled = true, dataProvider = "getData", priority = 33,alwaysRun = true, description ="Test Script to add Student to a Group ", testName = "TC234_2_Add Student to a Group")
   			@TestCaseFields(testCaseName = "TC234_2_Add Student to a Group")
   			public void TC234_2_AddStudentToGroup(StringHash data) throws Exception {

   				StudentTestFlow.AddStudentToStudentGroup(data);
   			}

//Test 32
   			@Test(enabled = true, dataProvider = "getData", priority = 34,alwaysRun = true, description ="Test Script to create Registration locks ", testName = "TC234_3_Create Registration locks for a Student Group")
   			@TestCaseFields(testCaseName = "TC234_3_Create Registration locks for a Student Group")
   			public void TC234_3_CreateRegistrationLocks(StringHash data) throws Exception {

   				StudentTestFlow.RegistrationLocksCreation(data);
   			}

//Test 33
   			@Test(enabled = true, dataProvider = "getData", priority = 29,alwaysRun = true, description ="Test Script to post a payment ", testName = "TC847_Post a Payment for a Student")
   			@TestCaseFields(testCaseName = "TC847_Post a Payment for a Student")
   			public void TC847_PostLedgerPaymentForStudent(StringHash data) throws Exception {

   				StudentTestFlow.LedgerPayment(data);
   			}

//Test 34
   			@Test(enabled = true, dataProvider = "getData", priority = 30,alwaysRun = true, description ="Test Script to post an FA Disburdement", testName = "TC848_Post an FA Disbursement for a Student")
   			@TestCaseFields(testCaseName = "TC848_Post an FA Disbursement for a Student")
   			public void TC848_PostFADisbursementForStudent(StringHash data) throws Exception {

   				StudentTestFlow.LedgerFADisbursement(data);
   			}

//Test 35
   			@Test(enabled = true, dataProvider = "getData", priority = 31,alwaysRun = true, description ="Test Script to verify the disbursement data", testName = "TC848_1_Verify Disbursement Data")
   			@TestCaseFields(testCaseName = "TC848_1_Verify Disbursement Data")
   			public void TC848_1_VerifyDisbursementData(StringHash data) throws Exception {

   				StudentTestFlow.VerifyDisbursementData(data);
   			}

//Test 36
   			@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="Test Script to post attendance in a batch", testName = "TC839_Record batch attendance for a course")
   			@TestCaseFields(testCaseName = "TC839_Record batch attendance for a course")
   			public void TC839_RecordBatchAttendanceForCourse  (StringHash data) throws Exception {

   				StudentTestFlow.RecordBatchAttendance(data);
   			}

//Test 37
   			@Test(enabled = true, dataProvider = "getData", priority = 26,alwaysRun = true, description ="Test Script to post final grades in a batch", testName = "TC837_Record batch Final Grades for a course")
   			@TestCaseFields(testCaseName = "TC837_Record batch Final Grades for a course")
   			public void TC837_RecordBatchFinalGradesForCourse(StringHash data) throws Exception {

   				StudentTestFlow.RecordBatchFinalGrades(data);
   			}

//Test 38
   			@Test(enabled = true, dataProvider = "getData", priority = 35,alwaysRun = true, description ="Test Script to verify minimum limit", testName = "TC234_5_Verify Minimum Limit Registration Lock")
   			@TestCaseFields(testCaseName = "TC234_5_Verify Minimum Limit Registration Lock")
   			public void TC234_5_VerifyMinimumLimitRegistrationLock(StringHash data) throws Exception {

   				StudentTestFlow.VerifyMinimumRegistrationLimit(data);
   			}

//Test 39
   			@Test(enabled = true, dataProvider = "getData", priority = 36,alwaysRun = true, description ="Test Script to verify maximum limit", testName = "TC234_4_Verify Maximum Limit Registration Lock")
   			@TestCaseFields(testCaseName = "TC234_4_Verify Maximum Limit Registration Lock")
   			public void TC234_4_VerifyMaximumLimitRegistrationLock(StringHash data) throws Exception {

   				StudentTestFlow.VerifyMaximumRegistrationLimit(data);
   			}

//Test 40
   			@Test(enabled = true, dataProvider = "getData", priority = 37,alwaysRun = true, description ="Test Script to verify schedule limit", testName = "TC234_6_Verify Schedule Registration Lock")
   			@TestCaseFields(testCaseName = "TC234_6_Verify Schedule Registration Lock")
   			public void TC234_6_VerifyScheduleRegistrationLock(StringHash data) throws Exception {

   				StudentTestFlow.VerifyScheduleRegistrationLock(data);
   			}
   			
//Test 41 -- *Prerequisite script*
   			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to create Academic Year", testName = "Creation of Academic Year")
   			@TestCaseFields(testCaseName = "Creation of Academic Year")
   			public void CreationOfAcademicYear(StringHash data) throws Exception {

   				StudentTestFlow.AcademicYear(data);
   			}
   			
//Test 42 -- CleanUp script
   			@Test(enabled = true, dataProvider = "getData", priority = 38,alwaysRun = true, description ="Test Script to Delete Course from Student Courses", testName = "Delete Course from Student Courses")
   			@TestCaseFields(testCaseName = "Delete Course from Student Courses")
   			public void DeleteCourseFromStudentCourses(StringHash data) throws Exception {

   				StudentTestFlow.DeleteCourse(data);
   			}
   			
//Test 43	-- *Prerequisite script*
   			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to add colleges", testName = "Add College")
   			@TestCaseFields(testCaseName = "Add College")
   			public void AddCollege(StringHash data) throws Exception {

   				StudentTestFlow.AddCollegeFlow(data);
   			}
   			
//Test 44-- *Prerequisite script*
   			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to add college course", testName = "Add College Course")
   			@TestCaseFields(testCaseName = "Add College Course")
   			public void AddCollegeCourse(StringHash data) throws Exception {

   				StudentTestFlow.AddCollegeCourseFlow(data);
   			}
   			
//Test 45-- *Prerequisite script*
   			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to add Course To Student Schedule", testName = "Add Course To Student Schedule")
   			@TestCaseFields(testCaseName = "Add Course To Student Schedule")
   			public void AddCourseToStudentSchedule(StringHash data) throws Exception {

   				StudentTestFlow.AddCourseToStudent(data);
   			}
			
   			@DataProvider
   			public Object[][] getData(Method method) {

   				return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
   			}
}
