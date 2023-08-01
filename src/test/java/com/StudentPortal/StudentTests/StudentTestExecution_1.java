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

public class StudentTestExecution_1 extends AutomationTestPlan {
	
	public StudentTestExecution_1() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
	
//Test 1
		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to place students into job", testName = "TC163_Use the Placement wizard to place students into a job")
		@TestCaseFields(testCaseName = "TC163_Use the Placement wizard to place students into a job")
		public void TC163_PlaceStudentsIntoJob(StringHash data) throws Exception {

			StudentTestFlow.PlacementsInternships(data);
		}

//Test 2
		@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Test Script to Enroll a student", testName = "TC248_Place Graduate Student into Internship")
		@TestCaseFields(testCaseName = "TC248_Place Graduate Student into Internship")
		public void TC248_PlaceGraduateStudentIntoInternship(StringHash data) throws Exception {

			StudentTestFlow.GraduateInternship(data);
		}

//Test 3
		@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Test Script to Enroll a student", testName = "TC267_Place Graduate Student into Externship")
		@TestCaseFields(testCaseName = "TC267_Place Graduate Student into Externship")
		public void TC267_PlaceGraduateStudentIntoExternship(StringHash data) throws Exception {

			StudentTestFlow.GraduateExternship(data);
		}
		
//Test 4
		@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="Test Script to add FA document", testName = "TC216_FA Documents to Individual Students")
		@TestCaseFields(testCaseName = "TC216_FA Documents to Individual Students")
		public void TC216_FADocumentsToIndividualStudents(StringHash data) throws Exception {

			StudentTestFlow.FADocument(data);
		}

//Test 5
		@Test(enabled = true, dataProvider = "getData", priority = 26,alwaysRun = true, description ="Test Script to add FA document List", testName = "TC216_FA Document List to Individual Students")
		@TestCaseFields(testCaseName = "TC216_FA Document List to Individual Students")
		public void TC216_FADocumentListToIndividualStudents(StringHash data) throws Exception {

				StudentTestFlow.FADocumentList(data);
		}
//Test 6
   		@Test(enabled = true, dataProvider = "getData", priority = 35,alwaysRun = true, description ="Test Script to print Awards Summary", testName = "TC209_Summary document can be printed for individual students")
   		@TestCaseFields(testCaseName = "TC209_Summary document can be printed for individual students")
   		public void TC848_PrintAwardSummary(StringHash data) throws Exception {

   				StudentTestFlow.PrintAwardSummary(data);
   		}
//Test 7
   		@Test(enabled = true, dataProvider = "getData", priority = 27,alwaysRun = true, description ="Test Script to verufy Disbursement Approval Criteria ", testName = "TC843_Verify Disbursement Approval Criteria is configured accurately")
   		@TestCaseFields(testCaseName = "TC843_Verify Disbursement Approval Criteria is configured accurately")
   		public void TC843_VerifyDisbursementApprovalCriteria(StringHash data) throws Exception {

   				StudentTestFlow.ApproveDisbursementToPay(data);
   		}
//Test 8
   		@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Test Script to Verify Student Application Creation", testName = "TC831_Student Application Creation")
   		@TestCaseFields(testCaseName = "TC831_Student Application Creation")
   		public void TC831_StudentApplicationCreation(StringHash data) throws Exception {

   				StudentTestFlow.StudentApplicationFlow(data);
   		} 
//Test 9
   		@Test(enabled = true, dataProvider = "getData", priority = 13,alwaysRun = true, description ="Test Script to register a course", testName = "TC833_Register a course to the enrolled student")
   		@TestCaseFields(testCaseName = "TC833_Register a course to the enrolled student")
   		public void TC832_Registeracoursetotheenrolledstudent(StringHash data) throws Exception {

   				StudentTestFlow.RegisterCourseToStudent(data);
   		}

//Test 10
   		@Test(enabled = true, dataProvider = "getData", priority = 14,alwaysRun = true, description ="Test Script to drop a course", testName = "TC834_Drop a course from the student schedule")
   		@TestCaseFields(testCaseName = "TC834_Drop a course from the student schedule")
   		public void TC834_DropCoursefromtheStudent(StringHash data) throws Exception {

   				StudentTestFlow.DropCourseFromStudentSchedule(data);
   		}
   		
//Test 42
		@Test(enabled = true, dataProvider = "getData", priority = 38,alwaysRun = true, description ="Test Script to Delete Course from Student Courses", testName = "Delete Course from Student Courses")
		@TestCaseFields(testCaseName = "Delete Course from Student Courses")
		public void DeleteCourseFromStudentCourses(StringHash data) throws Exception {

				StudentTestFlow.DeleteCourse(data);
		}
		
//Test 45-- *Prerequisite script*
			@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to add Course To Student Schedule", testName = "Add Course To Student Schedule")
			@TestCaseFields(testCaseName = "Add Course To Student Schedule")
			public void AddCourseToStudentSchedule(StringHash data) throws Exception {

				StudentTestFlow.AddCourseToStudent(data);
		}
}
	