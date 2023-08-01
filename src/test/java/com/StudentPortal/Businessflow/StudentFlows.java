package com.StudentPortal.Businessflow;

import com.StudentPortal.Pages.StudentClassSchedulingPage;
import com.StudentPortal.Pages.StudentConfigurationPage;
import com.StudentPortal.Pages.StudentGradesPage;
import com.StudentPortal.Pages.StudentHomePage;
import com.StudentPortal.Pages.StudentLoginPage;
import com.StudentPortal.Pages.StudentMainPage;
import com.StudentPortal.Pages.StudentProcessessPage;
import com.StudentPortal.Pages.StudentTasksPage;
import com.StudentPortal.Pages.StudentTermsPage;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
import com.framework.base.BasePage;

//import com.StudentPortal.Pages.StudentLoginPage;

public class StudentFlows {
	public static void CreateTerm(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentTermsPage TPage = new StudentTermsPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.login(data);
			Hpage.SelectConfigurationMenu(data);
			TPage.CreatingTerm(data);
						
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
		    BPage.QuitBrowser();
		}
	}
	
	
	public static void ScheduleClass(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentClassSchedulingPage Cpage = new StudentClassSchedulingPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.login(data);
			Hpage.SelectClassSchedulingMenu(data);
			Cpage.CreatingClassSchedule(data);			
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
		   BPage.QuitBrowser();
		}
	}
	
	
	public static void RegisterCourseToStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectStudent(data);
			//Cpage.CreatingClassSchedule(data);
			Mpage.RegisterCourse(data);			
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void DropCourseFromStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.login(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectStudent(data);
			//Cpage.CreatingClassSchedule(data);
			Mpage.DropCourse(data);
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void ReinstateCourseToTheStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.login(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectStudent(data);
			//Cpage.CreatingClassSchedule(data);
			Mpage.ReinstateCourse(data);
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void UnregisterCourseFromStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.login(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectStudent(data);
			//Cpage.CreatingClassSchedule(data);
			Mpage.UnregisterCourse(data);
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void AddLetterGradeToStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.login(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectStudent(data);
			//Cpage.CreatingClassSchedule(data);
			Mpage.AddLetterGrade(data);
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void AddLetterGradeFromGradeScale(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentGradesPage Gpage = new StudentGradesPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.login(data);
			Hpage.SelectConfigurationMenu(data);
			Gpage.AddLetterGradeUnderGradeScale(data);		
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void CreateEnrollmentForStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.login(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectNewStudent(data);
			Mpage.CreateStudentAndEnrollment(data);		
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void AddTasksToAStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
    		Mpage.AddTasks(data);					
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void ConfirmPendingTasksToAStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.ConfirmPendingTasks(data);
						
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void ConfirmPendingTasksForStaff(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentTasksPage TPage = new StudentTasksPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectTasksMenu(data);			
			TPage.ConfirmPendingTasksForStaff(data);			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void EditPendingTasksByStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);	
			Mpage.EditTasks(data);
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void EditPendingTasksByStaff(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentTasksPage TPage = new StudentTasksPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectTasksMenu(data);
			TPage.EditTaskByStaff(data);
		
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void CloseTheTasksFromStaff(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);	
			Mpage.CloseTask(data);
			//TPage.ConfirmPendingTasksForStaff(data);						
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void UpdateAdminRepForStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);	
			Mpage.UpdatingAdminRep(data);
			//TPage.ConfirmPendingTasksForStaff(data);			
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void UpdateAdminRepInBatch(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentProcessessPage Ppage = new StudentProcessessPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			Ppage.UpdateAdminRepInABatch(data);			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void PerformRevenueRecognition(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentProcessessPage Ppage = new StudentProcessessPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			Ppage.QueueRevenueRecognition(data);			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void AddSMSServiceProvider(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage BPage = new BasePage();
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectConfigurationMenu(data);
			Cpage.AddSMSServiceProvider(data);
		
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void VerifySMSConfiguration(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
		
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.VerifySMSConfiguration(data);
					
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void AddSchoolFields(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
				
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.AddSchoolFields(data);
					
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void AddNewEmployers(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage BPage = new BasePage();
				
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectConfigurationMenu(data);
			Cpage.AddNewEmployer(data);
				
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void ApproveUnapprovedAid(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentProcessessPage Ppage = new StudentProcessessPage();	
		BasePage BPage = new BasePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			Ppage.ApproveUnapprovedAid(data);
		
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
		
	public static void ScheduleStudentPaymentPlan(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.ScheduleStudentPaymentPlan(data);
				
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void ConfigurePromissoryNote(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage BPage = new BasePage();
		
		
		
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectConfigurationMenu(data);
			Cpage.ConfigurePromissoryNote(data);
		
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	
	public static void AddPromissoryNoteToAStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();		
		BasePage BPage = new BasePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.AddPromissoryNote(data);		
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void PerformRefundCalculation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.PerformRefundCalculation(data);			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void PlaceStudentsIntoExternshipPosition(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
				
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.PlaceStudentsIntoExternship(data);			
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void AddEstimatedFAPackaging(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.AddEstimatedFAPackaging(data);
						
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
		
	public static void VerifyAcademicYearsInformation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.VerifyAcademicYearsInformation(data);
						
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void PostFederalWorkStudyDisbursements(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentProcessessPage Ppage = new StudentProcessessPage();
		BasePage BPage = new BasePage();
				
		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			Ppage.PostFederalWorkDisbursements(data);
					
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void EditAwardInformation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
				
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.EditAwardInformation(data);
						
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   // Lpage.logOut();
		   BPage.QuitBrowser();
		}
	}
	
	public static void VerifyAwardUpdate(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentMainPage Mpage = new StudentMainPage();
		BasePage BPage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectStudentsMenu(data);
			Hpage.SelectAStudent(data);
			Mpage.VerifyAwardUpdate(data);
						
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void ReleaseToGL(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentProcessessPage Ppage = new StudentProcessessPage();
		BasePage BPage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			Ppage.ReleaseToGeneralLedger(data);
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
	public static void ApproveFADisbursements(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentProcessessPage Ppage = new StudentProcessessPage();
		BasePage BPage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			Ppage.ApproveFADisbursements(data);
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
			BPage.QuitBrowser();
		}
	}
	
}





