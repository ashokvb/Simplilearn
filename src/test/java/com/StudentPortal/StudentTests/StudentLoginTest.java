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

public class StudentLoginTest extends AutomationTestPlan {
	
	public StudentLoginTest() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  
//Test 1	
		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to Create New Residency Type", testName = "TC10_Create a new residency type")
		@TestCaseFields(testCaseName = "TC10_Create a new residency type")
		public void Createnewresidencytype(StringHash data) throws Exception {

				StudentLoginFlow.CreateResidencytype(data);
				}
		
//Test 2
		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Test Script to Verify the Student Module Login Page", testName = "TC14_Creating a student group in a configuration")
		@TestCaseFields(testCaseName = "TC14_Creating a student group in a configuration")
		public void CreateNewStudentGroup(StringHash data) throws Exception {

				StudentLoginFlow.CreateStudentGroup(data);
				}

//Test 3
		@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="Test Script to Create Test type in Configuration", testName = "TC15_Create a new test type in configuration")
		@TestCaseFields(testCaseName = "TC15_Create a new test type in configuration")
		public void CreateNewTestType(StringHash data) throws Exception {

				StudentLoginFlow.CreateTestingType(data);
				} 

//Test 4
		@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Test Script to Add student to Group", testName = "TC16_Adding student to a student group")
		@TestCaseFields(testCaseName = "TC16_Adding student to a student group")
		public void AddStudentToGroup(StringHash data) throws Exception {

				StudentLoginFlow.AddingStudentToGroup(data);
				} 
	
//Test 5
		@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Test Script to Remove Student Group", testName = "TC17_Remove student from a group")
		@TestCaseFields(testCaseName = "TC17_Remove student from a group")
		public void RemoveStudentInGroup(StringHash data) throws Exception {

				StudentLoginFlow.RemovingStudentFromGroup(data);
				} 
	
//Test 6
		@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Test Script to Create Residency Type for a Student", testName = "TC11_Create a new residency type for a student")
		@TestCaseFields(testCaseName = "TC11_Create a new residency type for a student")
		public void CreateResidencyTypeForStudent(StringHash data) throws Exception {

				StudentLoginFlow.CreatingResidencyTypeForStudent(data);
		
				} 
	
//Test 7
		@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Test Script to Update Residency Type for a Student", testName = "TC12_Update residency type of a student")
		@TestCaseFields(testCaseName = "TC12_Update residency type of a student")
		public void UpdateResidencyTypeOfStudent(StringHash data) throws Exception {

				StudentLoginFlow.UpdatingResidencyTypeForStudent(data);
			
				} 
	
//Test 8 
		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to Adding Test Score to a Student", testName = "TC13_Adding test score to a student")
		@TestCaseFields(testCaseName = "TC13_Adding test score to a student")
		public void AddingtestscoretoStudent(StringHash data) throws Exception {

				StudentLoginFlow.AddtestscoretoStudent(data);
				
				}

//Test 9 - Place students into an intern ship Position.

		@Test(enabled = true, dataProvider = "getData", priority = 56,alwaysRun = true, description ="Test Script to Place students intoaninternship Position", testName = "TC56_PlacestudentsintoaninternshipPosition")
		@TestCaseFields(testCaseName = "TC56_PlacestudentsintoaninternshipPosition")
		public void TC893_2_PlacestudentsintoaninternshipPosition(StringHash data) throws Exception {

				StudentLoginFlow.PlaceStudentInternshipPosition(data);
					
				}

//Test 10 - Ability to add a course section
 
		@Test(enabled = true, dataProvider = "getData", priority = 57,alwaysRun = true, description ="Test Script to Ability to add a course section", testName = "TC57_Abilitytoaddacoursesection")
		@TestCaseFields(testCaseName = "TC57_Abilitytoaddacoursesection")
		public void TC895_1_Abilitytoaddacoursesection(StringHash data) throws Exception {

				StudentLoginFlow.AddCourseSec(data);
																	
				}
				
//Test 11 - Edit existing course sections on the Master Schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 58,alwaysRun = true, description ="Test Script to Edit existing course sections on the Master Schedule", testName = "TC58_EditexistingcoursesectionsontheMasterSchedule")
		@TestCaseFields(testCaseName = "TC58_EditexistingcoursesectionsontheMasterSchedule")
		public void TC895_2_EditexistingcoursesectionsontheMasterSchedule(StringHash data) throws Exception {

				StudentLoginFlow.EditExistingCourseSec(data);
																			
				}
		
//Test 12 - Copy Class Schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 60,alwaysRun = true, description ="Test Script to Copy Class Schedule", testName = "TC60_CopyClassSchedule")
		@TestCaseFields(testCaseName = "TC60_CopyClassSchedule")
		public void TC908_CopyClassSchedule(StringHash data) throws Exception {

				StudentLoginFlow.CopyClassSched(data);
											
				}
		
//Test 13 - Add an enrollment for a student

		@Test(enabled = true, dataProvider = "getData", priority = 61,alwaysRun = true, description ="Test Script to Add an enrollment for a student", testName = "TC61_Addanenrollmentforastudent")
		@TestCaseFields(testCaseName = "TC61_Addanenrollmentforastudent")
		public void TC898_Addanenrollmenttoastudent(StringHash data) throws Exception {

				StudentLoginFlow.StudentEnrollment(data);
																			
				}
		
//Test 14 - Add a course to a student's schedule.
		@Test(enabled = true, dataProvider = "getData", priority = 62,alwaysRun = true, description ="Test Script to Add a course to a students schedule", testName = "TC62_Addacoursetoastudentsschedule")
		@TestCaseFields(testCaseName = "TC62_Addacoursetoastudentsschedule")
		public void TC897_Addacoursetoastudentsschedule(StringHash data) throws Exception {

				StudentLoginFlow.StudentCourse(data);
													
				}
				
//Test 15 - Record makeup hours for a student

		@Test(enabled = true, dataProvider = "getData", priority = 63,alwaysRun = true, description ="Test Script to Record makeup hours for a student", testName = "TC63_Recordmakeuphoursforastudent")
		@TestCaseFields(testCaseName = "TC63_Recordmakeuphoursforastudent")
		public void TC901_Recordmakeuphoursforastudent(StringHash data) throws Exception {

				StudentLoginFlow.RecordMakeupHourStudent(data);
							
				}
				
//Test 16 - Unregister a course from a student's schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 64,alwaysRun = true, description ="Test Script to Unregister a course from a students schedule", testName = "TC64_Unregisteracoursefromastudentsschedule")
		@TestCaseFields(testCaseName = "TC64_Unregisteracoursefromastudentsschedule")
		public void TC896_Unregisteracoursefromastudentsschedule(StringHash data) throws Exception {

				StudentLoginFlow.StudentCourseUnregister(data);
																	
				}
		
//Test * --*Prerequisite script*

		@Test(enabled = true, dataProvider = "getData", priority = 64,alwaysRun = true, description ="Test Script to DeleteCreatedCourse", testName = "DeleteCreatedCourse")
		@TestCaseFields(testCaseName = "DeleteCreatedCourse")
		public void DeleteCreatedCourse(StringHash data) throws Exception {

				StudentLoginFlow.DeleteCourse(data);
																	
				}
		
//Test 17 - EditDegreeProgressAudit

		@Test(enabled = true, dataProvider = "getData", priority = 65,alwaysRun = true, description ="Test Script to Edit Degree Progress Audit", testName = "TC65_EditDegreeProgressAudit")
		@TestCaseFields(testCaseName = "TC65_EditDegreeProgressAudit")
		public void TC902_EditDegreeProgressAudit(StringHash data) throws Exception {

				StudentLoginFlow.EditDegreeProgAudit(data);
																
				}
		
//Test 18 - Add Degrees to a Student

		@Test(enabled = true, dataProvider = "getData", priority = 66,alwaysRun = true, description ="Test Script to Add Degrees to a Student", testName = "TC66_AddDegreestoaStudent")
		@TestCaseFields(testCaseName = "TC66_AddDegreestoaStudent")
		public void TC903_1_AddDegreestoaStudent(StringHash data) throws Exception {

				StudentLoginFlow.AddDegreeToStudent(data);
																
				}
		
//Test 19 - Add HonorstoaStudent

		@Test(enabled = true, dataProvider = "getData", priority = 67,alwaysRun = true, description ="Test Script to Add Honors to a Student", testName = "TC67_AddHonorstoaStudent")
		@TestCaseFields(testCaseName = "TC67_AddHonorstoaStudent")
		public void TC903_2_AddHonorstoaStudent(StringHash data) throws Exception {

				StudentLoginFlow.AddHonorToStudent(data);
																
				}
		
//Test 20 - Add Term Honer and Badges to a Student.
		@Test(enabled = true, dataProvider = "getData", priority = 68,alwaysRun = true, description ="Test Script to Add Term Honer and Badges to a Student", testName = "TC68_AddTermHonerandBadgestoaStudent")
		@TestCaseFields(testCaseName = "TC68_AddTermHonerandBadgestoaStudent")
		public void TC903_3_AddTermHonerandBadges(StringHash data) throws Exception {

				StudentLoginFlow.AddTermHonerandBadge(data);
																
				}
		
//Test 21 - Confirm new information can be added to School field(s)

  		@Test(enabled = true, dataProvider = "getData", priority = 69,alwaysRun = true, description ="Test Script to Confirm new information can be added to Schoolfield(s)", testName = "TC69_ConfirmnewinformationcanbeaddedtoSchoolfield(s)")
  		@TestCaseFields(testCaseName = "TC69_ConfirmnewinformationcanbeaddedtoSchoolfield(s)")
  		public void TC904_ConfirmnewinformationcanbeaddedtoSchoolfields(StringHash data) throws Exception {

  				StudentLoginFlow.ConfirmSchoolFields(data);
  																	
  				}
	
//Test 22 - Batch Register students in a track

		@Test(enabled = true, dataProvider = "getData", priority = 70,alwaysRun = true, description ="Test Script to Batch Register students in a track", testName = "TC70_BatchRegisterstudentsinatrack")
		@TestCaseFields(testCaseName = "TC70_BatchRegisterstudentsinatrack")
		public void TC909_BatchRegisterstudentsinatrack(StringHash data) throws Exception {

				StudentLoginFlow.BatchStudentRegestrationTrack(data);
													
				}
		
//Test 23 - Ability to batch unregister courses

		@Test(enabled = true, dataProvider = "getData", priority = 71,alwaysRun = true, description ="Test Script to Ability to batch unregister courses", testName = "TC71_Abilitytobatchunregistercourses")
		@TestCaseFields(testCaseName = "TC71_Abilitytobatchunregistercourses")
		public void TC918_Abilitytobatchunregistercourses(StringHash data) throws Exception {

				StudentLoginFlow.BatchStudentUnRegestrationTrack(data);
															
				}
		
//Test 24 - Record batch Midterm Grades for a course. 

		@Test(enabled = true, dataProvider = "getData", priority = 73,alwaysRun = true, description ="Test Script to RecordbatchMidtermGradesforacourse", testName = "TC73_RecordbatchMidtermGradesforacourse")
		@TestCaseFields(testCaseName = "TC73_RecordbatchMidtermGradesforacourse")
		public void TC921_RecordbatchMidtermGradesforacourse(StringHash data) throws Exception {

				StudentLoginFlow.RecordMidTermGrades(data);
																
				}
		
//Test 25 - Confirm documents have been created and associated with the Career Services module.

		@Test(enabled = true, dataProvider = "getData", priority = 74,alwaysRun = true, description ="Test Script to ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule", testName = "TC74_ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule")
		@TestCaseFields(testCaseName = "TC74_ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmodule")
		public void TC922_ConfdoccreateassowithCarServmodule(StringHash data) throws Exception {

				StudentLoginFlow.ConfirmDocumentSchedule(data);
																
				}
		
//Test 26 - Tasks need to be configured to allow associating events with Students and validate the same task in the Dropdown

  		@Test(enabled = true, dataProvider = "getData", priority = 75,alwaysRun = true, description ="Test Script to TasksneedtobeconfiguredtoallowassociatingeventswithStudents and validate the same task in the Dropdown", testName = "TC75_TasksneedtobeconfiguredtoallowassociatingeventswithStudentsandvalidatethesametaskintheDropdown")
  		@TestCaseFields(testCaseName = "TC75_TasksneedtobeconfiguredtoallowassociatingeventswithStudentsandvalidatethesametaskintheDropdown")
  		public void TC919_1_TasktoconftoallassoevewithStudents(StringHash data) throws Exception {

  				StudentLoginFlow.StudentTaskConfiguration(data);
														
				}
    
//Test 27 - Confirm tasks are available in the Dropdown when working with an employer record. 

  	    @Test(enabled = true, dataProvider = "getData", priority = 76,alwaysRun = true, description ="Test Script to Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord", testName = "TC76_Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord")
  		@TestCaseFields(testCaseName = "TC76_Confirmtasksareavailableinthedropdownwhenworkingwithanemployerrecord")
  		public void TC919_2_Conftaskdropdownemployerrecord(StringHash data) throws Exception {

  				StudentLoginFlow.ConfirmTaskConfigurationEmployeeDropdown(data);
  															
  				}
		  
//Test 28 - Subsidiary Ledger - Post a Charge.

		@Test(enabled = true, dataProvider = "getData", priority = 77,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaCharge", testName = "TC77_SubsidiaryLedgerPostaCharge")
		@TestCaseFields(testCaseName = "TC77_SubsidiaryLedgerPostaCharge")
		public void TC927_SubsidiaryLedgerPostaCharge(StringHash data) throws Exception {

				StudentLoginFlow.SubLedgerPostaCharge(data);
																	
				}
		
//Test 29 - Subsidiary Ledger - Post a Payment. 

		@Test(enabled = true, dataProvider = "getData", priority = 78,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaPayment", testName = "TC78_SubsidiaryLedgerPostaPayment")
		@TestCaseFields(testCaseName = "TC78_SubsidiaryLedgerPostaPayment")
		public void TC928_SubsidiaryLedgerPostaPayment(StringHash data) throws Exception {

				StudentLoginFlow.SubLedgerPostPayment(data);
																			
				}
		
//Test 30 - Perform a Program Transfer for a Student

  		@Test(enabled = true, dataProvider = "getData", priority = 79,alwaysRun = true, description ="Test Script to PerformaProgramTransferforaStudent", testName = "TC79_PerformaProgramTransferforaStudent")
  		@TestCaseFields(testCaseName = "TC79_PerformaProgramTransferforaStudent")
  		public void TC900_PerformaProgramTransferforaStudent(StringHash data) throws Exception {

  				StudentLoginFlow.ProgrameTransferForStudent(data);
														
				}
    
//Test 31 - Subsidiary Ledger Post a Refund    

  		@Test(enabled = true, dataProvider = "getData", priority = 80,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaRefund   ", testName = "TC80_SubsidiaryLedgerPostaRefund")
  		@TestCaseFields(testCaseName = "TC80_SubsidiaryLedgerPostaRefund")
  		public void TC929_SubsidiaryLedgerPostaRefund(StringHash data) throws Exception {

  				StudentLoginFlow.SubPostRefund(data);
														
				}
											
//Test 32 - Subsidiary Ledger - Adjust Transaction - Delete  

		@Test(enabled = true, dataProvider = "getData", priority = 81,alwaysRun = true, description ="Test Script to SubsidiaryLedgerAdjustTransactionDelete", testName = "TC81_SubsidiaryLedgerAdjustTransactionDelete")
		@TestCaseFields(testCaseName = "TC81_SubsidiaryLedgerAdjustTransactionDelete")
		public void TC930_SubsidiaryLedgerAdjustTransactionDelete(StringHash data) throws Exception {

				StudentLoginFlow.SubLedgerDelete(data);
																	
				}
		
//Test 33 - Subsidiary Ledger Adjust Transaction - Void    
		
  		@Test(enabled = true, dataProvider = "getData", priority = 82,alwaysRun = true, description ="Test Script to SubsidiaryLedgerPostaRefund", testName = "TC82_SubsidiaryLedgerAdjustTransactionVoid")
  		@TestCaseFields(testCaseName = "TC82_SubsidiaryLedgerAdjustTransactionVoid")
  		public void TC931_SubsidiaryLedgerAdjustTransactionVoid(StringHash data) throws Exception {

  				StudentLoginFlow.SubTransactionsVoid(data);
														
				}
    @DataProvider
	public Object[][] getData(Method method) {

	return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
	
	}
}
