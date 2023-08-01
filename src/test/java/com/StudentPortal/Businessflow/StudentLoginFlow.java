package com.StudentPortal.Businessflow;

import com.StudentPortal.Pages.AddStudentToStudentGroup;
import com.StudentPortal.Pages.AddingTestScoreToStudentPage;
import com.StudentPortal.Pages.CreateResidencyTypeForStudentPage;
import com.StudentPortal.Pages.PlacestudentsintoaninternshipPosition;
import com.StudentPortal.Pages.StudentLoginPage;
import com.StudentPortal.Pages.StudentMainPage;
import com.StudentPortal.Pages.StudentProcessesPage;
import com.StudentPortal.Pages.RemoveStudentFromGroupPage;
import com.StudentPortal.Pages.StudentAcademicRecordsPage;
import com.StudentPortal.Pages.StudentAccountSchoolFieldsPage;
import com.StudentPortal.Pages.StudentClassSchedulingPage;
import com.StudentPortal.Pages.StudentAccountSchoolFieldsPage;
import com.StudentPortal.Pages.StudentClassSchedulingPage;
import com.StudentPortal.Pages.StudentConfigurationPage;
import com.StudentPortal.Pages.StudentCoursePage;
import com.StudentPortal.Pages.StudentDegreeCreation;
import com.StudentPortal.Pages.StudentGradebookPage;
import com.StudentPortal.Pages.StudentGroupPage;
import com.StudentPortal.Pages.StudentLoginPage;
import com.StudentPortal.Pages.StudentTestTypePage;
import com.StudentPortal.Pages.UpdateResidencyTypeOfStudentPage;
import com.framework.base.BasePage;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
import com.StudentPortal.Pages.StudentHomePage;
import com.StudentPortal.Pages.StudentLedgerAccountPage;
import com.StudentPortal.Pages.StudentLedgerAccountPage;
import com.StudentPortal.Pages.StudentSettingsPage;
import com.StudentPortal.Pages.StudentStudentPage;
import com.StudentPortal.Pages.StudentSubsidiaryPage;

public class StudentLoginFlow {
	
public static void CreateResidencytype(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();

		try {
			Lpage.login(data);
			Cpage.CreateResidencyType(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	/*finally {
		    Lpage.logOut();
		}*/
	}

public static void CreateStudentGroup(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentGroupPage SGpage = new StudentGroupPage();

		try {
			Lpage.login(data);
			SGpage.CreateStudentGroup(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	/*finally {
	    	Lpage.logOut();
		}*/
	}

public static void CreateTestingType(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentTestTypePage Stpage = new StudentTestTypePage();

		try {
		Lpage.login(data);
		Stpage.CreateTestType(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
		/*finally {
    		Lpage.logOut();
		}*/
	}
	
public static void AddingStudentToGroup(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		AddStudentToStudentGroup SRpage = new AddStudentToStudentGroup();

		try {
		Lpage.login(data);
		SRpage.AddStudentGroup(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
		/*finally {
    		Lpage.logOut();
		}*/
	}
	
public static void RemovingStudentFromGroup(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		RemoveStudentFromGroupPage SRpage = new RemoveStudentFromGroupPage();

		try {
		Lpage.login(data);
		SRpage.RemoveStudentGroup(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
		/*finally {
    		Lpage.logOut();
		}*/
	}
	
public static void CreatingResidencyTypeForStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		CreateResidencyTypeForStudentPage SCRpage = new CreateResidencyTypeForStudentPage();

		try {
		Lpage.login(data);
		SCRpage.CreatingResidencyTypeStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
		/*finally {
    		Lpage.logOut();
		}*/
	}
	
public static void UpdatingResidencyTypeForStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		UpdateResidencyTypeOfStudentPage SCRpage = new UpdateResidencyTypeOfStudentPage();

		try {
		Lpage.login(data);
		SCRpage.UpdatingResidencyTypeStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
		/*finally {
    		Lpage.logOut();
		}*/
	}
	
public static void AddtestscoretoStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		AddingTestScoreToStudentPage SCRpage = new AddingTestScoreToStudentPage();

		try {
		Lpage.login(data);
		SCRpage.AddtestscoreStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
		/*finally {
    		Lpage.logOut();
		}*/
	}
		
public static void PlaceStudentInternshipPosition(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		PlacestudentsintoaninternshipPosition Ipage = new PlacestudentsintoaninternshipPosition();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Ipage.PlaceInternshipPosition(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		//Lpage.logOut();
	      Bpage.QuitBrowser();
		}
	}
	
public static void CopyClassSched(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentClassSchedulingPage CCpage = new StudentClassSchedulingPage();
		try {
			Lpage.loginDCRC(data);
			Hpage.SelectClassSchedulingMenu(data);
			CCpage.CopyClassSchedule(data);
		
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
		      Bpage.QuitBrowser();
		}
	}
	
public static void StudentCourse(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentCoursePage Apage = new StudentCoursePage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Apage.AddStudentCourse(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		//Lpage.logOut();
	      Bpage.QuitBrowser();
		}
	}
	
public static void StudentCourseUnregister(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentCoursePage Upage = new StudentCoursePage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Upage.CourseUnRegistrationForStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		//Lpage.logOut();
	      Bpage.QuitBrowser();
		}
	}

public static void DeleteCourse(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage Hpage = new StudentHomePage();
	BasePage Bpage = new BasePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	try {
		Lpage.loginDCRC(data);
		Hpage.MenuButton();
		Hpage.StudentButton();
		Mpage.DeleteCoursePage(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
finally {
	//Lpage.logOut();
      Bpage.QuitBrowser();
	}
}

public static void AddCourseSec(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentClassSchedulingPage CUpage = new StudentClassSchedulingPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.SelectClassSchedulingMenu(data);
			CUpage.CreatingClassScheduleUsingExistingTerm(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		   //Lpage.logOut();
		     Bpage.QuitBrowser();
		}
	}
	
public static void SubLedgerPostaCharge(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentSubsidiaryPage CUpage = new StudentSubsidiaryPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			CUpage.SubsidiaryLedgerPostCharge(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		//Lpage.logOut();
	      Bpage.QuitBrowser();
		}
	}
	
public static void EditExistingCourseSec(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentClassSchedulingPage EUpage = new StudentClassSchedulingPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.SelectClassSchedulingMenu(data);
			EUpage.EditClassScheduleUsingExistingCourse(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
		      Bpage.QuitBrowser();
		}
	}
	
public static void StudentEnrollment(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentMainPage Mpage = new StudentMainPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Mpage.AddingEnrollmentToStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
		      Bpage.QuitBrowser();
		}
	}
	
public static void SubLedgerDelete(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentSubsidiaryPage PDpage = new StudentSubsidiaryPage();
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			PDpage.SubLedgerPostChargeDelete(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		//Lpage.logOut();
	      Bpage.QuitBrowser();
		}
	}
	
public static void RecordMakeupHourStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentCoursePage PDpage = new StudentCoursePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			PDpage.RecordMakeupHourForStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		//Lpage.logOut();
	      Bpage.QuitBrowser();
		}
	}
	
public static void BatchStudentRegestrationTrack(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentMainPage Rpage = new StudentMainPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			Rpage.BatchOfStudentRegestrationTrack(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		//Lpage.logOut();
	      Bpage.QuitBrowser();
		}
	}
		
public static void BatchStudentUnRegestrationTrack(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentMainPage URpage = new StudentMainPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			URpage.BatchOfStudentUnRegestrationTrack(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
 }
		
public static void AddDegreeToStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentDegreeCreation ADpage = new StudentDegreeCreation();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			ADpage.AddDegreeForStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	            Bpage.QuitBrowser();
		}

	}
	
public static void AddHonorToStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentDegreeCreation AHpage = new StudentDegreeCreation();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			AHpage.AddHonorForStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
	}
	
public static void SubTransactionsVoid(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentSubsidiaryPage AVpage = new StudentSubsidiaryPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			AVpage.SubTransactionVoid(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
	}
	
public static void AddTermHonerandBadge(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentDegreeCreation ATHBpage = new StudentDegreeCreation();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			ATHBpage.AddTermHonorWithBadge(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
	}
		
public static void ConfirmDocumentSchedule(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentConfigurationPage CDSpage = new StudentConfigurationPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			CDSpage.ConfirmDocumentCarrierServices(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
	}
	
public static void RecordMidTermGrades(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentGradebookPage RMpage = new StudentGradebookPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();
			RMpage.RecordMidTermGrades(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
	}
	
public static void ConfirmSchoolFields(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentMainPage CSpage = new StudentMainPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			CSpage.ConfirmInformationSchoolFields(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
    }
	
public static void StudentTaskConfiguration(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentConfigurationPage TCSpage = new StudentConfigurationPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.SelectConfigurationMenu(data);
			TCSpage.ConfirmTaskConfigurationForEmployee(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
	}

public static void ConfirmTaskConfigurationEmployeeDropdown(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentConfigurationPage TCSpage = new StudentConfigurationPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.SelectConfigurationMenu(data);
			TCSpage.ConfirmTaskConfigurationForEmployeeDropdown(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		      //Lpage.logOut();
	      	    Bpage.QuitBrowser();
		}
	}
	
public static void EditDegreeProgAudit(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentConfigurationPage TSpage = new StudentConfigurationPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			TSpage.DegreeProgressAudit(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    	//Lpage.logOut();
	      		  Bpage.QuitBrowser();
		}
	}
	
public static void ProgrameTransferForStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentMainPage PTpage = new StudentMainPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			PTpage.ProgrameTransferToStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
	      	  Bpage.QuitBrowser();
		}
	}
	
public static void SubPostRefund(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentSubsidiaryPage PRpage = new StudentSubsidiaryPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			PRpage.SubPostRefundForStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
	      	  Bpage.QuitBrowser();
		}
	}
	
public static void SubLedgerPostPayment(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		StudentSubsidiaryPage PPpage = new StudentSubsidiaryPage();

		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			PPpage.SubLedgerPostPayment(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    //Lpage.logOut();
	      	  Bpage.QuitBrowser();
		}
	}  
}





    
	
