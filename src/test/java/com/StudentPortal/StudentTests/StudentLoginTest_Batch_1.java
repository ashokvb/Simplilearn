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

public class StudentLoginTest_Batch_1 extends AutomationTestPlan {
	
	public StudentLoginTest_Batch_1() {
		xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
	}
  
//Test 1 - Place students into an intern ship Position.

		@Test(enabled = true, dataProvider = "getData", priority = 2,alwaysRun = true, description ="Test Script to Place students intoaninternship Position", testName = "TC56_PlacestudentsintoaninternshipPosition")
		@TestCaseFields(testCaseName = "TC56_PlacestudentsintoaninternshipPosition")
		public void TC893_2_PlacestudentsintoaninternshipPosition(StringHash data) throws Exception {

				StudentLoginFlow.PlaceStudentInternshipPosition(data);
					
				}

//Test 2 - Copy Class Schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 12,alwaysRun = true, description ="Test Script to Copy Class Schedule", testName = "TC60_CopyClassSchedule")
		@TestCaseFields(testCaseName = "TC60_CopyClassSchedule")
		public void TC908_CopyClassSchedule(StringHash data) throws Exception {

				StudentLoginFlow.CopyClassSched(data);
													
				}
		
//Test 3 - Add an enrollment for a student.

		@Test(enabled = true, dataProvider = "getData", priority = 1,alwaysRun = true, description ="Test Script to Add an enrollment for a student", testName = "TC61_Addanenrollmentforastudent")
		@TestCaseFields(testCaseName = "TC61_Addanenrollmentforastudent")
		public void TC898_Addanenrollmenttoastudent(StringHash data) throws Exception {

				StudentLoginFlow.StudentEnrollment(data);
																					
				}
		
//Test 4 - Add a course to a student's schedule.
		
		@Test(enabled = true, dataProvider = "getData", priority = 3,alwaysRun = true, description ="Test Script to Add a course to a students schedule", testName = "TC62_Addacoursetoastudentsschedule")
		@TestCaseFields(testCaseName = "TC62_Addacoursetoastudentsschedule")
		public void TC897_Addacoursetoastudentsschedule(StringHash data) throws Exception {

				StudentLoginFlow.StudentCourse(data);
															
				}
		
//Test 5 - Unregister a course from a student's schedule.

		@Test(enabled = true, dataProvider = "getData", priority = 4,alwaysRun = true, description ="Test Script to Unregister a course from a students schedule", testName = "TC64_Unregisteracoursefromastudentsschedule")
		@TestCaseFields(testCaseName = "TC64_Unregisteracoursefromastudentsschedule")
		public void TC896_Unregisteracoursefromastudentsschedule(StringHash data) throws Exception {

				StudentLoginFlow.StudentCourseUnregister(data);
																	
				}
		
//Test 6 - Edit Degree Progress Audit

		@Test(enabled = true, dataProvider = "getData", priority = 5,alwaysRun = true, description ="Test Script to Edit Degree Progress Audit", testName = "TC65_EditDegreeProgressAudit")
		@TestCaseFields(testCaseName = "TC65_EditDegreeProgressAudit")
		public void TC902_EditDegreeProgressAudit(StringHash data) throws Exception {

				StudentLoginFlow.EditDegreeProgAudit(data);
																		
				}
		
//Test 7 - Add Degrees to a Student

		@Test(enabled = true, dataProvider = "getData", priority = 6,alwaysRun = true, description ="Test Script to Add Degrees to a Student", testName = "TC66_AddDegreestoaStudent")
		@TestCaseFields(testCaseName = "TC66_AddDegreestoaStudent")
		public void TC903_1_AddDegreestoaStudent(StringHash data) throws Exception {

				StudentLoginFlow.AddDegreeToStudent(data);
																		
				}
		
//Test 8 - Add HonorstoaStudent

		@Test(enabled = true, dataProvider = "getData", priority = 7,alwaysRun = true, description ="Test Script to Add Honors to a Student", testName = "TC67_AddHonorstoaStudent")
		@TestCaseFields(testCaseName = "TC67_AddHonorstoaStudent")
		public void TC903_2_AddHonorstoaStudent(StringHash data) throws Exception {

				StudentLoginFlow.AddHonorToStudent(data);
																		
				}
		
//Test 9 - Add Term Honer and Badges to a Student.
		
		@Test(enabled = true, dataProvider = "getData", priority = 8,alwaysRun = true, description ="Test Script to Add Term Honer and Badges to a Student", testName = "TC68_AddTermHonerandBadgestoaStudent")
		@TestCaseFields(testCaseName = "TC68_AddTermHonerandBadgestoaStudent")
		public void TC903_3_AddTermHonerandBadges(StringHash data) throws Exception {

				StudentLoginFlow.AddTermHonerandBadge(data);
																		
				}
		
//Test 10 - Confirm new information can be added to Schoolfield(s)

  		@Test(enabled = true, dataProvider = "getData", priority = 9,alwaysRun = true, description ="Test Script to Confirm new information can be added to Schoolfield(s)", testName = "TC69_ConfirmnewinformationcanbeaddedtoSchoolfield(s)")
  		@TestCaseFields(testCaseName = "TC69_ConfirmnewinformationcanbeaddedtoSchoolfield(s)")
  		public void TC904_ConfirmnewinformationcanbeaddedtoSchoolfields(StringHash data) throws Exception {

  				StudentLoginFlow.ConfirmSchoolFields(data);
  																	
  				}
  		
//Test 11 - Record makeup hours for a student

  		@Test(enabled = true, dataProvider = "getData", priority = 10,alwaysRun = true, description ="Test Script to Record makeup hours for a student", testName = "TC63_Recordmakeuphoursforastudent")
  		@TestCaseFields(testCaseName = "TC63_Recordmakeuphoursforastudent")
  		public void TC901_Recordmakeuphoursforastudent(StringHash data) throws Exception {

  				StudentLoginFlow.RecordMakeupHourStudent(data);
  								
  				}
  		
//Test 12 - Perform a Program Transfer for a Student

  		@Test(enabled = true, dataProvider = "getData", priority = 11,alwaysRun = true, description ="Test Script to PerformaProgramTransferforaStudent", testName = "TC79_PerformaProgramTransferforaStudent")
  		@TestCaseFields(testCaseName = "TC79_PerformaProgramTransferforaStudent")
  		public void TC900_PerformaProgramTransferforaStudent(StringHash data) throws Exception {

  				StudentLoginFlow.ProgrameTransferForStudent(data);
														
				}
  	@DataProvider
  	public Object[][] getData(Method method) {

  	return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
  		
  	}
}
