package com.StudentPortal.Businessflow;


import org.testng.Reporter;

import com.StudentPortal.Pages.StudentAcademicRecordsPage;
import com.StudentPortal.Pages.StudentAdmissionsPage;
import com.StudentPortal.Pages.StudentCareerServices;
import com.StudentPortal.Pages.StudentConfigurationPage;
import com.StudentPortal.Pages.StudentContactManagerPage;
import com.StudentPortal.Pages.StudentDegreeCreation;
import com.StudentPortal.Pages.StudentFinancialAidPage;
import com.StudentPortal.Pages.StudentGroupPage;
import com.StudentPortal.Pages.StudentHomePage;
import com.StudentPortal.Pages.StudentLoginPage;
import com.StudentPortal.Pages.StudentMainPage;
import com.StudentPortal.Pages.StudentParentChildTermPage;
import com.StudentPortal.Pages.StudentProcessesPage;
import com.StudentPortal.Pages.StudentProgramGroupCreation;
import com.StudentPortal.Pages.StudentProgramPage;
import com.StudentPortal.Pages.StudentProgramVersionPage;
import com.StudentPortal.Pages.StudentSettingsPage;
import com.StudentPortal.Pages.StudentStudentAccountsPage;
import com.StudentPortal.Pages.StudentTransferTypesPage;
import com.StudentPortal.Pages.StudentUpdateStudentApplication;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.framework.base.BasePage;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class StudentTestFlow {
	public static void DegreeCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentDegreeCreation DegreePage = new StudentDegreeCreation();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.configurationPage();
			DegreePage.CreateDegree(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}
	
	public static void CreatePG(StringHash data) throws Exception {
		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentProgramGroupCreation PGCreation = new StudentProgramGroupCreation();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.configurationPage();
			PGCreation.CreateProgramGroups(data);
		}
		catch(Exception e)
		{
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to unhandled exception" + e.getMessage());
		}
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}
	
	public static void CreateProgramFlow(StringHash data) throws Exception{
		StudentLoginPage Lpage=new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentProgramPage Ppage = new StudentProgramPage();
		BasePage Bpage = new BasePage();	
		try {
			Lpage.login(data);
			Hpage.configurationPage();
			Ppage.CreateProgram(data);
		}
		catch(Exception e)
		{
			TestReportsLog.log(LogStatus.FAIL, "Script failed due to unhandled exception" +e.getMessage());
		}
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}
	
	public static void CreateAndVerifyTheNewTransferType(StringHash data) throws Exception {
		
		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentTransferTypesPage TTpage = new StudentTransferTypesPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.configurationPage();
			TTpage.CreateTransferTypes(data);
		}
		
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
		}
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}
	
	public static void CreateParentAndChildTerm(StringHash data) throws Exception {
		
	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage Hpage = new StudentHomePage();
	StudentParentChildTermPage PTpage = new StudentParentChildTermPage();
	BasePage Bpage = new BasePage();
	try {
		Lpage.login(data);
		Hpage.configurationPage();
		PTpage.ParentAndChildTerm(data);
	}
	
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
	}
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}
	
	public static void StudentApplicationFlow(StringHash data) throws Exception {
		
		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentAdmissionsPage SApage = new StudentAdmissionsPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.StudentPage();
			SApage.CreateStudentApplication(data);
		}
		
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
		}
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}
	
	public static void UpdateStudentApplication(StringHash data) throws Exception {
		
		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentUpdateStudentApplication USA = new StudentUpdateStudentApplication();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.StudentPage();
			USA.UpdateStudentApplicationPage(data);
		}
		
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
		}
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}
	
public static void CreateProgramVersion(StringHash data) throws Exception {
		
		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentProgramVersionPage PVpage= new StudentProgramVersionPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.configurationPage();
			PVpage.ProgramVersionCreation(data);
		}
		
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
		}
	finally 
	{
	 Bpage.QuitBrowser();
	}
		/*{
	    Lpage.logOut();
	}
		 */
	}

public static void PlacementsInternships(StringHash data) throws Exception {
	
	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage Hpage = new StudentHomePage();
	StudentCareerServices PIpage= new StudentCareerServices();
	BasePage Bpage = new BasePage();
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		PIpage.AddStudentIntoJob(data);
	}
	
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
	}
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}
	public static void GraduateInternship(StringHash data) throws Exception {
		
		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentCareerServices GIpage= new StudentCareerServices();
		BasePage Bpage = new BasePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.StudentPage();
			GIpage.PlaceGraduateStudentIntoInternship(data);
		}
		
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
		}
		
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}

	public static void GraduateExternship(StringHash data) throws Exception {
		
		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentCareerServices GIpage= new StudentCareerServices();
		BasePage Bpage = new BasePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.StudentPage();
			GIpage.PlaceGraduateStudentIntoExternship(data);
		}
		
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, " Script Failed due to unhandled Exception " + e.getMessage());
		}
		
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}

public static void CreateEnrollmentForStudent(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentMainPage Mpage = new StudentMainPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.login(data);
		Hpage.SelectStudentsMenu(data);
		Hpage.SelectNewStudent(data);
		Mpage.CreateStudentAndEnrollment(data);
	}
		
	finally 
	{
		 Bpage.QuitBrowser();
		 }
	/*{
		    Lpage.logOut();
	}
	*/
}

public static void AddCourseToStudent(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.AddCourseToStudentSchedule(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}
public static void RegisterCourseToStudent(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.RegisterCourse(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void DropCourseFromStudentSchedule(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.DropCourse(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void DeleteCourse(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.DeleteCoursePage(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void RecordIndividualAttendence(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.IndividualAttendence(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void RecordIndividualFinalGrades(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.individualFinalGradesPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}
	
public static void RecordBatchAttendance(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage  Hpage = new StudentHomePage();
		StudentProcessesPage Mpage = new StudentProcessesPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.ProcessesPage();	
			Mpage.BatchAttendancePage(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		 finally 
		 {
			 Bpage.QuitBrowser();
		 }
		/*{
			    Lpage.logOut();
			}
		*/
		}

public static void RecordBatchFinalGrades(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentProcessesPage Mpage = new StudentProcessesPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.ProcessesPage();	
		Mpage.BatchFinalGradesPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void PerformStatusChanges(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.StatusChangePage(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void CloseTaskContactManager(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentContactManagerPage Mpage = new StudentContactManagerPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.CloseTask(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void PostChargeforStudent(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentStudentAccountsPage Mpage = new StudentStudentAccountsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.newLedgerCharge(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void PostRefundforStudent(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentStudentAccountsPage Mpage = new StudentStudentAccountsPage();
	BasePage Bpage = new BasePage();
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.NewLedgerRefund(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void FAReassignment(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentFinancialAidPage Mpage = new StudentFinancialAidPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.FinancialAidReassignment(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void TransferCredits(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.TransferCreditsPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void VerifySAP(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentProcessesPage Mpage = new StudentProcessesPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.ProcessesPage();
		Mpage.SAPCalculationPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void FADocument(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentContactManagerPage Mpage = new StudentContactManagerPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.AddFADocumentPage(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void FADocumentList(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentContactManagerPage Mpage = new StudentContactManagerPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.AddFADocumentListPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}


public static void ApproveDisbursementToPay(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentProcessesPage Mpage = new StudentProcessesPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.ProcessesPage();	
		Mpage.ApproveDisbursementPage(data);
		
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void AcademicYear(StringHash data) throws Exception {
	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage Hpage = new StudentHomePage();
	StudentFinancialAidPage AYCreation = new StudentFinancialAidPage();
	BasePage Bpage = new BasePage();
	try {
		Lpage.login(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		AYCreation.AcademicYearPage(data);
	}
	catch(Exception e)
	{
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to unhandled exception" + e.getMessage());
	}
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void StipedSchedule(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentStudentAccountsPage Mpage = new StudentStudentAccountsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.ScheduleStipendPage(data);
		
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}


public static void StudentGroupCreation(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentGroupPage Mpage = new StudentGroupPage();
	BasePage Bpage = new BasePage();
	try {
		Lpage.loginDCRC(data);
		Hpage.GroupPage();
		Mpage.StudentGroupCreationPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	
 finally 
 {
	 Bpage.QuitBrowser();
 }
/*{
	    Lpage.logOut();
	}
*/
}

public static void AddStudentToStudentGroup(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentGroupPage Mpage = new StudentGroupPage();
	BasePage Bpage = new BasePage();
	try {
		Lpage.loginDCRC(data);
		Hpage.GroupPage();
		Mpage.AddStudentToGroupPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	
 finally 
 {
	 Bpage.QuitBrowser();
 }
/*{
	    Lpage.logOut();
	}
*/
}

public static void RegistrationLocksCreation(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentGroupPage Mpage = new StudentGroupPage();
	BasePage Bpage = new BasePage();
	try {
		Lpage.loginDCRC(data);
		Hpage.GroupPage();
		Mpage.CreateRegistrationLocksPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	
 finally 
 {
	 Bpage.QuitBrowser();
 }
/*{
	    Lpage.logOut();
	}
*/
}

public static void LedgerPayment(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentStudentAccountsPage Mpage = new StudentStudentAccountsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.LedgerPaymentPage(data);
		
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void LedgerFADisbursement(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentStudentAccountsPage Mpage = new StudentStudentAccountsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.LedgerFADisbursementPage(data);
		
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void PrintAwardSummary(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentFinancialAidPage Mpage = new StudentFinancialAidPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.PrintAwardSummaryPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void PerformProgramChange(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.ProgramChangePage(data);
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void VerifyDisbursementData(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentFinancialAidPage Mpage = new StudentFinancialAidPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();	
		Hpage.SearchStudent(data);
		Mpage.VerifyDisbursementDataPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void VerifyMinimumRegistrationLimit(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.verifyMinimumLimitPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void VerifyMaximumRegistrationLimit(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.verifyMaximumLimitPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void VerifyScheduleRegistrationLock(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentAcademicRecordsPage Mpage = new StudentAcademicRecordsPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.StudentPage();
		Mpage.VerifyScheduleLockPage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void AddCollegeFlow(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentConfigurationPage Mpage = new StudentConfigurationPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.configurationPage();
		Mpage.AddCollegePage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}

public static void AddCollegeCourseFlow(StringHash data) throws Exception {

	StudentLoginPage Lpage = new StudentLoginPage();
	StudentHomePage  Hpage = new StudentHomePage();
	StudentConfigurationPage Mpage = new StudentConfigurationPage();
	BasePage Bpage = new BasePage();
	
	try {
		Lpage.loginDCRC(data);
		Hpage.configurationPage();
		Mpage.AddCollegeCoursePage(data);	
	} 
	catch (Exception e) {
		TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
	} 
	 finally 
	 {
		 Bpage.QuitBrowser();
	 }
	/*{
		    Lpage.logOut();
		}
	*/
	}
}
