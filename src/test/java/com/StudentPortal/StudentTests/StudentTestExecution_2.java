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

public class StudentTestExecution_2 extends AutomationTestPlan {
	
	public StudentTestExecution_2() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}

//Test 24
		@Test(enabled = true, dataProvider = "getData", priority = 23,alwaysRun = true, description ="Test Script to post enter transfer credits", testName = "TC835_Enter Transfer Credits")
		@TestCaseFields(testCaseName = "TC835_Enter Transfer Credits")
		public void TC835_TransferCredits(StringHash data) throws Exception {

			StudentTestFlow.TransferCredits(data);
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
	@Test(enabled = true, dataProvider = "getData", priority = 17,alwaysRun = true, description ="Test Script to post attendance in a batch", testName = "TC839_Record batch attendance for a course")
	@TestCaseFields(testCaseName = "TC839_Record batch attendance for a course")
	public void TC839_RecordBatchAttendanceForCourse  (StringHash data) throws Exception {

		StudentTestFlow.RecordBatchAttendance(data);
	}

//Test 19
	@Test(enabled = true, dataProvider = "getData", priority = 18,alwaysRun = true, description ="Test Script to post final grades in a batch", testName = "TC837_Record batch Final Grades for a course")
	@TestCaseFields(testCaseName = "TC837_Record batch Final Grades for a course")
	public void TC837_RecordBatchFinalGradesForCourse(StringHash data) throws Exception {

		StudentTestFlow.RecordBatchFinalGrades(data);
	}
	
//Test 20
		@Test(enabled = true, dataProvider = "getData", priority = 19,alwaysRun = true, description ="Test Script to change student status", testName = "TC240_Perform Status Changes")
		@TestCaseFields(testCaseName = "TC240_Perform Status Changes")
		public void TC240_StudentStatusChange(StringHash data) throws Exception {

			StudentTestFlow.PerformStatusChanges(data);
		}
//Test 25
			@Test(enabled = true, dataProvider = "getData", priority = 24,alwaysRun = true, description ="Test Script to verify SAP calculation", testName = "TC841_Verify SAP")
			@TestCaseFields(testCaseName = "TC841_Verify SAP")
			public void TC841_VerifySAPCalculation(StringHash data) throws Exception {

				StudentTestFlow.VerifySAP(data);
			}		
//Test 23
   			@Test(enabled = true, dataProvider = "getData", priority = 22,alwaysRun = true, description ="Test Script to post a refund directly to Ledger Card", testName = "TC844_Ledger Card - Post a Refund (directly to Ledger Card)")
   			@TestCaseFields(testCaseName = "TC844_Ledger Card - Post a Refund (directly to Ledger Card)")
   			public void TC844_PostRefundToStudentLedger(StringHash data) throws Exception {

   				StudentTestFlow.PostRefundforStudent(data);
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
   			
//Test 29
   			@Test(enabled = true, dataProvider = "getData", priority = 28,alwaysRun = true, description ="Test Script to schedule a stipend ", testName = "TC846_Schedule a Stipend for a student")
   			@TestCaseFields(testCaseName = "TC846_Schedule a Stipend for a student")
   			public void TC846_ScheduleStipendForStudent(StringHash data) throws Exception {

   				StudentTestFlow.StipedSchedule(data);
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
}