package com.StudentPortal.StudentTests;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StudentPortal.Pages.APIAutomationPage;
import com.framework.base.constants.FrameworkConstants;
import com.framework.core.AutomationTestPlan;
import com.framework.core.AutomationTestPlanThree;
import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestCaseFields;
import com.framework.util.Xls_Reader;

public class StudentsDCRCAPITests extends AutomationTestPlanThree {

		
		public StudentsDCRCAPITests() {
			xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH_API);
		}
	  
//Test 1	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Place Students into a Job", testName = "TC163_Place Students into a Job")
		@TestCaseFields(testCaseName = "TC163_Place Students into a Job")
		public void TC163_PlaceStudentsIntoJob(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.PlaceStudentsintoJob(data);
		}

//Test 2	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Place Students into Internship", testName = "TC248_1_Placement Students into Internship")
		@TestCaseFields(testCaseName = "TC248_1_Placement Students into Internship")
		public void TC248_1_PlacementStudentsIntoInternship(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.PlacementStudentsintoInternship(data);
		}
				
//Test 3	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Place Students into Externship", testName = "TC248_2_Placement Students into Externship")
		@TestCaseFields(testCaseName = "TC248_2_Placement Students into Externship")
		public void TC248_2_PlacementStudentsIntoExternship(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.PlacementStudentsintoInternship(data);
		}
		
//Test 4
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Add FA Documents to Students", testName = "TC216_1_Ability to add FA Document to Individual Students")
		@TestCaseFields(testCaseName = "TC216_1_Ability to add FA Document to Individual Students")
		public void TC216_1_AddFADocumentToIndividualStudents(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddFADocuments(data);
		}
//Test 5
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Add FA Document List to Students", testName = "TC216_2_Add FA Document List to Individual Students")
		@TestCaseFields(testCaseName = "TC216_2_Add FA Document List to Individual Students")
		public void TC216_2_AddFADocumentListToStudents(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddFADocumentList(data);
		}
		
//Test 6
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Student Application Creation", testName = "TC831_Student Application Creation")
		@TestCaseFields(testCaseName = "TC831_Student Application Creation")
		public void TC831_StudentApplicationCreation(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.StudentApplicationCreation(data);
		}

//Test 7
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Enter Transfer Credits", testName = "TC835_Enter Transfer Credits")
		@TestCaseFields(testCaseName = "TC835_Enter Transfer Credits")
		public void TC835_TransferCredits(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.TransferCredits(data);
		}
		
//Test 18 --*Prerequisite script*
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Creation of Academic Year", testName = "Creation of Academic Year")
		@TestCaseFields(testCaseName = "Creation of Academic Year")

		public void AcademicYearCreation(StringHash data) throws Exception {
			 APIAutomationPage Spage = new APIAutomationPage();
			 Spage.AcademicYear(data);
					
		}
				
//Test 8
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Post a Charge to Student Ledger card", testName = "TC845_Post a Charge to Student Ledger card")
		@TestCaseFields(testCaseName = "TC845_Post a Charge to Student Ledger card")
		public void TC845_PostChargeToStudentLedgerCard(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.PostCharge(data);
		}
//Test 9
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Post a payment to Student Ledger card", testName = "TC847_Post a Payment for a student")
		@TestCaseFields(testCaseName = "TC847_Post a Payment for a student")
		public void TC847_PostPaymentForStudent(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.PostPayment(data);
		}
				
//Test 10
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Perform Status Changes", testName = "TC840_Perform Status Changes")
		@TestCaseFields(testCaseName = "TC840_Perform Status Changes")
		public void TC840_PerformStatusChanges(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.StatusChange(data);
		}

//Test 11
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Create a Student Group", testName = "TC234_1_Create a Student Group")
		@TestCaseFields(testCaseName = "TC234_1_Create a Student Group")
		public void TC234_1_CreateStudentGroup(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.CreateStudentGroup(data);
		}

//Test 12
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Add Student to a group", testName = "TC234_2_Add Student to a group")
		@TestCaseFields(testCaseName = "TC234_2_Add Student to a group")
		public void TC234_2_AddStudentToGroup(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddStudentToGroup(data);
		}

//Test 13 --*Prerequisite script*
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Add Course to Student Courses", testName = "TC833_1_Add Course to Student Courses")
		@TestCaseFields(testCaseName = "TC833_1_Add Course to Student Courses")
		public void TC833_1_AddCourseToStudentCourses(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddCourseToStudentCourses(data);
		}

//Test 14
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Register a student for a course", testName = "TC833_2_Register a student for a course")
		@TestCaseFields(testCaseName = "TC833_2_Register a student for a course")
		public void TC833_2_RegisterstudentforACourse(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.RegisterStudent(data);
		}

//Test 15
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Drop a course from a students schedule", testName = "TC834_Drop a course from a students schedule")
		@TestCaseFields(testCaseName = "TC834_Drop a course from a students schedule")
		public void TC834_DropCourseFromStudentSchedule(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.DropCourseFromStudentSchedule(data);
		}	
		
//Test 16 --*Prerequisite script*
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Delete a course from students schedule", testName = "Delete course from students schedule")
		@TestCaseFields(testCaseName = "Delete course from students schedule")
		public void DeleteCourse(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.DeleteCoursefromStudentCourses(data);
		}

//Test 17
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Create Registration locks", testName = "TC234_3_Create Registration locks")
		@TestCaseFields(testCaseName = "TC234_3_Create Registration locks")

		public void TC234_3_CreateRegistrationlocks(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.CreateRegistrationlocks(data);
		}


		
//Test 19 -- *Prerequisite script*
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Creation of Fund Source Award", testName = "Creation of Fund Source Award")
		@TestCaseFields(testCaseName = "Creation of Fund Source Award")

		public void FundCourseCreation(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.FundSource(data);
		}	
//Test 20
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="FA Reassignment To other AY", testName = "TC194_FA Reassignment To AY")
		@TestCaseFields(testCaseName = "TC194_FA Reassignment To AY")

		public void TC194_FAReassignmentToAY(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.FAReassignmentToAY(data);
		}	

//Test 21
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Record individual final grades", testName = "TC836_Record individual final grades")
		@TestCaseFields(testCaseName = "TC836_Record individual final grades")

		public void TC836_RecordIndividualFinalGrades(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.RecordIndividualFinalGrades(data);
		}	
//Test 22
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Post an FA Disbursement for a student", testName = "TC848_Post an FA Disbursement for a student")
		@TestCaseFields(testCaseName = "TC848_Post an FA Disbursement for a student")

		public void TC848_PostFADisbursement(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.PostFADisbursement(data);
		}				
//Test 23
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Post Refund - Directly to Ledger Card", testName = "TC844_Post Refund - Directly to Ledger Card")
		@TestCaseFields(testCaseName = "TC844_Post Refund - Directly to Ledger Card")

		public void TC844_PostRefund(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.PostRefund(data);
		}
		
//Test 24
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Program Change", testName = "TC223_Program Change")
		@TestCaseFields(testCaseName = "TC223_Program Change")

		public void TC223_ProgramChange(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.ProgramChange(data);
		}	
		
		
//Test 23
		@Test(enabled = true, dataProvider = "getData", priority = 23,alwaysRun = true, description ="Test Script to add tasks to student", testName = "Add tasks to a student")
		@TestCaseFields(testCaseName = "Add tasks to a student")
		public void TC879_Addtaskstoastudent(StringHash data) throws Exception {
			APIAutomationPage APage = new APIAutomationPage();
			APage.AddTasksToAStudent_API(data);
		}


//Test 24
		@Test(enabled = true, dataProvider = "getData", priority = 24,alwaysRun = true, description ="Test Script to confirm pending tasks", testName = "Confirm pending Tasks exist in Contact Manager for student")
		@TestCaseFields(testCaseName = "Confirm pending Tasks exist in Contact Manager for student")
		public void TC882_ConfirmpendingTasksexistinContactManagerforstudent(StringHash data) throws Exception {
			APIAutomationPage APage = new APIAutomationPage();
			APage.ConfirmPendingTasksToAStudent_API(data);
		}


//Test 25
		@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="Test Script to confirm pending tasks", testName = "Confirm pending Tasks exist for Staff")
		@TestCaseFields(testCaseName = "Confirm pending Tasks exist for Staff")
		public void TC882_ConfirmpendingTasksexistforStaff(StringHash data) throws Exception {
			APIAutomationPage APage = new APIAutomationPage();
			APage.ConfirmPendingTasksForStaff_API(data);
		}

//Test 26
		@Test(enabled = true, dataProvider = "getData", priority = 26,alwaysRun = true, description ="Test Script to edit tasks", testName = "Confirm that pending Tasks in Contact Manager can be edited by Student")
		@TestCaseFields(testCaseName = "Confirm that pending Tasks in Contact Manager can be edited by Student")
		public void TC883_ConfirmthatpendingTasksinContactManagercanbeeditedbyStudent(StringHash data) throws Exception {
			APIAutomationPage APage = new APIAutomationPage();
			APage.EditPendingTasksByStudent_API(data);
		}

//Test 27
		@Test(enabled = true, dataProvider = "getData", priority = 27,alwaysRun = true, description ="Test Script to edit tasks", testName = "Confirm that pending Tasks can be edited by Staff")
		@TestCaseFields(testCaseName = "Confirm that pending Tasks can be edited by Staff")
		public void TC883_ConfirmthatpendingTaskscanbeeditedbyStaff(StringHash data) throws Exception {
			APIAutomationPage APage = new APIAutomationPage();
			APage.EditPendingTasksByStaff_API(data);
		}


//Test 28
		@Test(enabled = true, dataProvider = "getData", priority = 28,alwaysRun = true, description ="Test Script for release to General Ledger", testName = "Release to General Ledger")
		@TestCaseFields(testCaseName = "Release to General Ledger")
		public void TC855_ReleaseToGeneralLedger(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.ReleaseToGeneralLedger_API(data);
		}

//Test 29
		@Test(enabled = true, dataProvider = "getData", priority = 29,alwaysRun = true, description ="Test Script to perform revenue recognition", testName = "Perform Revenue Recognition")
		@TestCaseFields(testCaseName = "Perform Revenue Recognition")
		public void TC854_PerformRevenueRecognition(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.PerformRevenueRecognition_API(data);
		}


//Test 30
		@Test(enabled = true, dataProvider = "getData", priority = 30,alwaysRun = true, description ="Test Script to Add new employers", testName = "Validate the ability to add new employers")
		@TestCaseFields(testCaseName = "Validate the ability to add new employers")
		public void TC894_Validatetheabilitytoaddnewemployers(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.AddNewEmployers_API(data);
		}


//Test 31
		@Test(enabled = true, dataProvider = "getData", priority = 31,alwaysRun = true, description ="Test Script to place students in Externship position", testName = "Place students into an externship Position")
		@TestCaseFields(testCaseName = "Place students into an externship Position")
		public void TC893_PlacestudentsintoanexternshipPosition(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.PlaceStudentsIntoExternship_API(data);
		}


//Test 32
		@Test(enabled = true, dataProvider = "getData", priority = 32,alwaysRun = true, description ="Test Script to Schedule a Student Payment Plan", testName = "Schedule a student payment plan")
		@TestCaseFields(testCaseName = "Schedule a student payment plan")
		public void TC849_Scheduleastudentpaymentplan(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.ScheduleStudentPaymentPlan_API(data);
		}


//Test 33
		@Test(enabled = true, dataProvider = "getData", priority = 33,alwaysRun = true, description ="Test Script to post Federal work study Disbursements", testName = "Validate the ability to post Federal Work Study disbursements")
		@TestCaseFields(testCaseName = "Validate the ability to post Federal Work Study disbursements")
		public void TC888_ValidatetheabilitytopostFederalWorkStudydisbursements(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.PostFederalWorkStudyDisbursements_API(data);
		}


//Test 34
		@Test(enabled = true, dataProvider = "getData", priority = 34,alwaysRun = true, description ="Test Script to approve FA Disbursements", testName = "Approving FA Disbursements to Pay in Batch form")
		@TestCaseFields(testCaseName = "Approving FA Disbursements to Pay in Batch form")
		public void TC887_ApprovingFADisbursementstoPayinBatchform(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.ApprovingFADisbursements_API(data);
		}


//Test 35
		@Test(enabled = true, dataProvider = "getData", priority = 35,alwaysRun = true, description ="Test Script to add estimated FA Packaging", testName = "Ability to add Estimated FA Packaging prior to Enrollment in a program of study to a student")
		@TestCaseFields(testCaseName = "Ability to add Estimated FA Packaging prior to Enrollment in a program of study to a student")
		public void TC884_AbilitytoaddEstimatedFAPackagingpriortoEnrollment(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.AddEstimatedFAPackaging_API(data);
		}

//Test 36
		@Test(enabled = true, dataProvider = "getData", priority = 36,alwaysRun = true, description ="Test Script to close tasks from Staff", testName = "Closing the tasks from the Contact Manager by Staff")
		@TestCaseFields(testCaseName = "Closing the tasks from the Contact Manager by Staff")
		public void TC880_ClosingthetasksfromtheContactManagerbyStaff(StringHash data) throws Exception {

			APIAutomationPage APage = new APIAutomationPage();
			APage.CloseTasksByStaff_API(data);
		}
		
		
//Test 37 - Place students into an intern ship Position.

		@Test(enabled = true, dataProvider = "getData", priority = 37,alwaysRun = true, description ="Test Script to Place students intoaninternship Position", testName = "PlacestudentsintoaninternshipPosition")
		@TestCaseFields(testCaseName = "PlacestudentsintoaninternshipPosition")
		public void PlacestudentsintointernshipPosition(StringHash data) throws Exception {

			APIAutomationPage Dpage = new APIAutomationPage();
			Dpage.PlacestudentsintoanexternshipPosition(data);

		}

//Test 38 - Ability to add a course section

		@Test(enabled = true, dataProvider = "getData", priority = 38,alwaysRun = true, description ="Test Script to Ability to add a course section", testName = "Abilitytoaddacoursesection")
		@TestCaseFields(testCaseName = "Abilitytoaddacoursesection")
		public void Abilitytoaddacoursesection(StringHash data) throws Exception {

			APIAutomationPage Apage = new APIAutomationPage();
			Apage.Abilitytoaddacoursesection(data);

		}



//Test 40 - Copy Class Schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 40,alwaysRun = true, description ="Test Script to Copy Class Schedule", testName = "CopyClassSchedule")
		@TestCaseFields(testCaseName = "CopyClassSchedule")
		public void CopyClassSchedule(StringHash data) throws Exception {

			APIAutomationPage Cpage = new APIAutomationPage();
			Cpage.CopyClassSchedule(data);

		}

//Test 41 - Add an enrollment for a student

		@Test(enabled = true, dataProvider = "getData", priority = 41,alwaysRun = true, description ="Test Script to Add an enrollment for a student", testName = "Addanenrollmentforastudent")
		@TestCaseFields(testCaseName = "Addanenrollmentforastudent")
		public void TC898_Addanenrollmenttoastudent(StringHash data) throws Exception {

			APIAutomationPage ENpage = new APIAutomationPage();
			ENpage.Addanenrollmentforastudent(data);

		}

//Test 42 - Add a course to a student's schedule_Save
		@Test(enabled = true, dataProvider = "getData", priority = 42,alwaysRun = true, description ="Test Script to Add a course to a students schedule", testName = "AddacoursetoastudentsscheduleSave")
		@TestCaseFields(testCaseName = "AddacoursetoastudentsscheduleSave")
		public void AddacoursetoastudentsscheduleSave(StringHash data) throws Exception {

			APIAutomationPage ENpage = new APIAutomationPage();
			ENpage.AddacoursetoastudentsscheduleSave(data);

		}

//Test 43 - Add a course to a student's schedule_Register
		@Test(enabled = true, dataProvider = "getData", priority = 43,alwaysRun = true, description ="Test Script to Add a course to a students schedule", testName = "AddacoursetoastudentsscheduleRegister")
		@TestCaseFields(testCaseName = "AddacoursetoastudentsscheduleRegister")
		public void AddacoursetoastudentsscheduleRegister(StringHash data) throws Exception {

			APIAutomationPage ENpage = new APIAutomationPage();
			ENpage.AddacoursetoastudentsscheduleRegister(data);

		}

//Test 44 - Record makeup hours for a student

		@Test(enabled = true, dataProvider = "getData", priority = 44,alwaysRun = true, description ="Test Script to Record makeup hours for a student", testName = "Recordmakeuphoursforastudent")
		@TestCaseFields(testCaseName = "Recordmakeuphoursforastudent")
		public void Recordmakeuphoursforastudent(StringHash data) throws Exception {

			APIAutomationPage RNpage = new APIAutomationPage();
			RNpage.Recordmakeuphoursforastudent(data);

		}

//Test 45 - Unregister a course from a student's schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 45,alwaysRun = true, description ="Test Script to Unregister a course from a students schedule", testName = "Unregisteracoursefromastudentsschedule")
		@TestCaseFields(testCaseName = "Unregisteracoursefromastudentsschedule")
		public void Unregisteracoursefromastudentsschedule(StringHash data) throws Exception {

			APIAutomationPage UNpage = new APIAutomationPage();
			UNpage.Unregisteracoursefromastudentsschedule(data);

		}
		
//Test * --*Prerequisite script*
		
		@Test(enabled = true, dataProvider = "getData", priority = 45,alwaysRun = true, description ="Test Script to Delete Course", testName = "DeleteCreatedCourse")
		@TestCaseFields(testCaseName = "DeleteCreatedCourse")
		public void DeleteCreatedCourse(StringHash data) throws Exception {

			APIAutomationPage DCpage = new APIAutomationPage();
			DCpage.DeleteAddedCourse(data);

		}

//Test 46 - Add Degrees to a Student

		@Test(enabled = true, dataProvider = "getData", priority = 46,alwaysRun = true, description ="Test Script to Add Degrees to a Student", testName = "AddDegreestoaStudent")
		@TestCaseFields(testCaseName = "AddDegreestoaStudent")
		public void AddDegreestoaStudent(StringHash data) throws Exception {

			APIAutomationPage DPpage = new APIAutomationPage();
			DPpage.AddDegreestoaStudent(data);

		}

//Test 47 - Add Honors to a Student

		@Test(enabled = true, dataProvider = "getData", priority = 47,alwaysRun = true, description ="Test Script to Add Honors to a Student", testName = "AddHonorstoaStudent")
		@TestCaseFields(testCaseName = "AddHonorstoaStudent")
		public void AddHonorstoaStudent(StringHash data) throws Exception {

			APIAutomationPage DPpage = new APIAutomationPage();
			DPpage.AddHonorstoaStudent(data);

		}

//Test 48 - Add Term Honer and Badges to a Student.
		@Test(enabled = true, dataProvider = "getData", priority = 48,alwaysRun = true, description ="Test Script to Add Term Honer and Badges to a Student", testName = "AddTermHonerandBadgestoaStudent")
		@TestCaseFields(testCaseName = "AddTermHonerandBadgestoaStudent")
		public void AddTermHonerandBadges(StringHash data) throws Exception {

			APIAutomationPage DPpage = new APIAutomationPage();
			DPpage.AddTermHonerandBadges(data);

		}

//Test 49 - Record batch Mid term Grades for a course. 

		@Test(enabled = true, dataProvider = "getData", priority = 49,alwaysRun = true, description ="Test Script to RecordbatchMidtermGradesforacourse", testName = "RecordbatchMidtermGradesforacourse")
		@TestCaseFields(testCaseName = "RecordbatchMidtermGradesforacourse")
		public void RecordbatchMidtermGradesforacourse(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.RecordbatchMidtermGradesforacourse(data);

		}

//Test 50 - Confirm documents have been created and associated with the Career Services module_New Document.

		@Test(enabled = true, dataProvider = "getData", priority = 50,alwaysRun = true, description ="Test Script to ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule", testName = "ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocument")
		@TestCaseFields(testCaseName = "ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocument")
		public void ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocument(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocument(data);

		}

//Test 51 - Confirm documents have been created and associated with the Career Services module_New Document List.

		@Test(enabled = true, dataProvider = "getData", priority = 51,alwaysRun = true, description ="Test Script to ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule", testName = "ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocumentList")
		@TestCaseFields(testCaseName = "ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocumentList")
		public void ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocumentList(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.ConfdoccreateassowithCarServmoduleNewDocumentList(data);

		}

//Test 52 - Tasks need to be configured to allow associating events with Students and validate the same task in the Dropdown

		@Test(enabled = true, dataProvider = "getData", priority = 52,alwaysRun = true, description ="Test Script to TasksneedtobeconfiguredtoallowassociatingeventswithStudents and validate the same task in the Dropdown", testName = "TasksneedtobeconfiguredtoallowassociatingeventswithStudentsandvalidatethesametaskintheDropdown")
		@TestCaseFields(testCaseName = "TasksneedtobeconfiguredtoallowassociatingeventswithStudentsandvalidatethesametaskintheDropdown")
		public void TasktoconftoallassoevewithStudents(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.TasktoconftoallassoevewithStudents(data);

		}

//Test 53 - Confirm tasks are available in the Drop down when working with an employer record. 

		@Test(enabled = true, dataProvider = "getData", priority = 53,alwaysRun = true, description ="Test Script to Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord", testName = "Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord")
		@TestCaseFields(testCaseName = "Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord")
		public void Conftaskdropdownemployerrecord(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.Conftaskdropdownemployerrecord(data);

		}

//Test 54 - Subsidiary Ledger - Post a Charge.

		@Test(enabled = true, dataProvider = "getData", priority = 54,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaCharge", testName = "SubsidiaryLedgerPostaCharge")
		@TestCaseFields(testCaseName = "SubsidiaryLedgerPostaCharge")
		public void SubsidiaryLedgerPostaCharge(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.SubsidiaryLedgerPostaCharge(data);

		}

//Test 55 - Subsidiary Ledger - Post a Payment. 

		@Test(enabled = true, dataProvider = "getData", priority = 55,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaPayment", testName = "SubsidiaryLedgerPostaPayment")
		@TestCaseFields(testCaseName = "SubsidiaryLedgerPostaPayment")
		public void SubsidiaryLedgerPostaPayment(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.SubsidiaryLedgerPostaPayment(data);

		}

//Test 56 - Perform a Program Transfer for a Student

		@Test(enabled = true, dataProvider = "getData", priority = 56,alwaysRun = true, description ="Test Script to PerformaProgramTransferforaStudent", testName = "PerformaProgramTransferforaStudent")
		@TestCaseFields(testCaseName = "PerformaProgramTransferforaStudent")
		public void PerformaProgramTransferforaStudent(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.PerformaProgramTransferforaStudent(data);

		}

//Test 57 - Subsidiary Ledger - Adjust Transaction - Delete  

		@Test(enabled = true, dataProvider = "getData", priority = 57,alwaysRun = true, description ="Test Script to SubsidiaryLedgerAdjustTransactionDelete", testName = "SubsidiaryLedgerAdjustTransactionDelete")
		@TestCaseFields(testCaseName = "SubsidiaryLedgerAdjustTransactionDelete")
		public void SubsidiaryLedgerAdjustTransactionDelete(StringHash data) throws Exception {

			APIAutomationPage BRpage = new APIAutomationPage();
			BRpage.SubsidiaryLedgerAdjustTransactionDelete(data);

		}
				
//Test 58	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="LedgerCardPostaCharge", testName = "LedgerCardPostaCharge")
		@TestCaseFields(testCaseName = "LedgerCardPostaCharge")
		public void LedgerCardPostaCharge(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.LedgerPostCharge(data);
		}
//Test 59
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="LedgerAdjustTransaction", testName = "LedgerAdjustTransaction")
		@TestCaseFields(testCaseName = "LedgerAdjustTransaction")
		public void LedgerCardAdjustTransaction(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.LedgerAdjustTransaction(data);
		}
//Test 60	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="LedgerChargeDelete", testName = "LedgerChargeDelete")
		@TestCaseFields(testCaseName = "LedgerChargeDelete")
		public void LedgerChargeDelete(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.LedgerChargeDelete(data);
		}
//Test 61	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="AddLettertoEmp", testName = "AddLettertoEmp")
		@TestCaseFields(testCaseName = "AddLettertoEmp")
		public void AddLettertoEmp(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddLettertoEmp(data);
		}
//Test 62	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="CreateSubsidiary", testName = "CreateSubsidiary")
		@TestCaseFields(testCaseName = "CreateSubsidiary")
		public void CreateSubsidiary(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.CreateSubsidiary(data);
		}
//Test 63	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="AddSubsidiary", testName = "AddSubsidiary")
		@TestCaseFields(testCaseName = "AddSubsidiary")
		public void AddSubsidiary(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddSubsidiary(data);
		}
//Test 64	
		@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="AddSubsidiary", testName = "SubPostACharge")
		@TestCaseFields(testCaseName = "SubPostACharge")
		public void SubPostACharge(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.SubPostCharge(data);
		}
//Test 65
		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="AddSubsidiary", testName = "SubAdjustTransaction")
		@TestCaseFields(testCaseName = "SubAdjustTransaction")
		public void SubAdjustTransaction(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.SubAdjustTransaction(data);
		}
//Test 66	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="AddSubsidiary", testName = "DocumentCreation")
		@TestCaseFields(testCaseName = "DocumentCreation")
		public void DocumentCreation(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.DocumentCreation(data);
		}
//Test 67	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="AddSubsidiary", testName = "DocumentScheduleCreation")
		@TestCaseFields(testCaseName = "DocumentScheduleCreation")
		public void DocumentScheduleCreation(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.DocumentSchedule(data);
		}
/*Test 68	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="AddSubsidiary", testName = "DocumentPolicyCreation")
		@TestCaseFields(testCaseName = "DocumentPolicyCreation")
		public void DocumentPolicyCreation(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.DocumentPolicy(data);
		}*/
//Test 69
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="AddSubsidiary", testName = "AddDocToStudent")
		@TestCaseFields(testCaseName = "AddDocToStudent")
		public void AddDocToStudent(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddDocumentToStudent(data);
		}
//Test 70	
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="AddSubsidiary", testName = "AddDocListToStudent")
		@TestCaseFields(testCaseName = "AddDocListToStudent")
		public void AddDocListToStudent(StringHash data) throws Exception {
			APIAutomationPage Spage = new APIAutomationPage();
			Spage.AddDocumentListToStudent(data);
		}


		@DataProvider
		public Object[][] getData(Method method) {

			return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
		}

}