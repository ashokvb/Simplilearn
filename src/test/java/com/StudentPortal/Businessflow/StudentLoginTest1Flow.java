package com.StudentPortal.Businessflow;

import com.StudentPortal.Pages.StudentAccountSchoolFieldsPage;
import com.StudentPortal.Pages.StudentConfigurationPage;
import com.StudentPortal.Pages.StudentFinancialAidPage;
import com.StudentPortal.Pages.StudentHomePage;
import com.StudentPortal.Pages.StudentLedgerAccountPage;
import com.StudentPortal.Pages.StudentLoginPage;
import com.StudentPortal.Pages.StudentProcessesPage;
import com.StudentPortal.Pages.StudentSettingsPage;
import com.StudentPortal.Pages.StudentStudentAccountsPage;
import com.StudentPortal.Pages.StudentStudentPage;
import com.StudentPortal.Pages.StudentSubsidiaryPage;
import com.framework.base.BasePage;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class StudentLoginTest1Flow {
	
	public static void AdjustingSubsidiaryTransaction(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		StudentSubsidiaryPage SBpage = new StudentSubsidiaryPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SBpage.AdjustSubTransaction(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    Bpage.QuitBrowser();
		}
	}
	public static void PrintingSubsidiaryLedger(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		StudentSubsidiaryPage SBpage = new StudentSubsidiaryPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SBpage.PrintSubsidiaryLedger(data);
			//SBpage.Ad
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void AddingNewSubsidiary(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		StudentSubsidiaryPage SBpage = new StudentSubsidiaryPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SBpage.AddSubsidiary(data);
			//SBpage.Ad
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void SubLedgerPostCharge(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentSubsidiaryPage SBpage = new StudentSubsidiaryPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SBpage.SubsidiaryPostCharge(data);
			//SBpage.Ad
			
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void AdjustingLedgerTransaction(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.AdjustLedgerTransaction(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void AdjustingLedgerTransactionVoid(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.AdjustLedgerTransactionVoid(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void LedgerCardPostingCharge(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.LedgerCardPostCharge(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void AdjustingLedgerTransactionDelete(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.AdjustLedgerTransactionDelete(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void SchedulingLedgerCardRefund(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.ScheduleRefundLedgerCard(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void SchedulingStipend(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.ScheduleStipend(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void ProcessingScheduledRefund(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentProcessesPage Ppage = new StudentProcessesPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.ProcessesButton();
			Ppage.ProcessRefund(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void ProcessingScheduledStipend(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentProcessesPage Ppage = new StudentProcessesPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.ProcessesButton();
			Ppage.ProcessStipend(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void PrintingLedgerCard(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.LedgerCardPrinting(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void PrintingLedgerCardDetail(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.LedgerCardPrintDetail(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}	
	
	public static void PrintingLedgerCardSummary(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.LedgerCardPrintSummary(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}	
	
	public static void CreatingLetterForEmployer(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.CreateLetter(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void PrintingEmployerLetter(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentProcessesPage Ppage = new StudentProcessesPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.ProcessesButton();
			Ppage.ProcessLetters(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void ConfiguringApplyPaymentFlag(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentSettingsPage SEpage = new StudentSettingsPage();
		BasePage Bpage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.SettingsButton();
			SEpage.ConfigureApplyPayment(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
			Bpage.QuitBrowser();
		}
	}
	public static void LedgerCardApplyingCredit(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentLedgerAccountPage LApage = new StudentLedgerAccountPage();
		BasePage Bpage = new BasePage();
			
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			LApage.ApplyCreditLedger(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
			Bpage.QuitBrowser();
		}
	}
	
	public static void SchoolDefinedFiledStudentAccounts(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentAccountSchoolFieldsPage SFSpage = new StudentAccountSchoolFieldsPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SFSpage.AccountSchoolField(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void SchoolDefinedFieldAdmission(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentAccountSchoolFieldsPage SFSpage = new StudentAccountSchoolFieldsPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SFSpage.AdmissionSchoolField(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void SchoolDefinedFieldStudentServices(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentAccountSchoolFieldsPage SFSpage = new StudentAccountSchoolFieldsPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SFSpage.StudentServiceSchoolField(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void SchoolDefinedFieldHousingStudentServices(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentAccountSchoolFieldsPage SFSpage = new StudentAccountSchoolFieldsPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SFSpage.StudentServiceHousingSchoolField(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	public static void SchoolDefinedFieldCareerServices(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentAccountSchoolFieldsPage SFSpage = new StudentAccountSchoolFieldsPage();
		BasePage Bpage = new BasePage();
		
		try {
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			SFSpage.CareerServiceSchoolField(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void PSStudentLogin(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		BasePage Bpage = new BasePage();

		try {
			Lpage.login(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.CreateProspect(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
	finally {
		    Lpage.logOut();
		}
	}
	
	
	
public static void SchoolStatusCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		StudentSettingsPage Sepage = new StudentSettingsPage();
		BasePage Bpage = new BasePage();

		try {
			Lpage.login(data);
			Hpage.MenuButton();
			Hpage.SettingsButton();
			Sepage.CreateSchoolStatus(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	

	public static void TaskTemplateCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.MenuButton();
			Hpage.ConfigurationButton();
			Cpage.CreateTaskTemplate(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void TaskScheduleCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.MenuButton();
			Hpage.ConfigurationButton();
			Cpage.CreateTaskSchedule(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void DocumentTypeCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);---this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.ConfigurationButton();
			Cpage.CreateDocumetType(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void AddingTasktoStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		BasePage Bpage = new BasePage();
		try {
			Lpage.login(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.AddTaskToStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void AddingDocumenttoStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);--this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.AddDocumentToStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void AddingDocumentListtoStudent(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Spage = new StudentStudentPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);--this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Spage.SelectStudent(data);
			Spage.AddDocumentListToStudent(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
 
	public static void DocumentScheduleCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);---this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.ConfigurationButton();
			Cpage.CreateDocumetSchedule(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void DocumentPolicyCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentSettingsPage Spage = new StudentSettingsPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);---this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.SettingsButton();
			Spage.ConfigureDocumentPolicy(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	public static void SubsidiaryCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentConfigurationPage Cpage = new StudentConfigurationPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);---this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.ConfigurationButton();
			Cpage.CreateSubsidiary(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void FundSourceCreation(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Cpage = new StudentStudentPage();
		StudentFinancialAidPage Fpage = new StudentFinancialAidPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);---this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Cpage.SelectStudent(data);
			Fpage.CreatingFundSource(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}
	
	public static void PostAPayment(StringHash data) throws Exception {

		StudentLoginPage Lpage = new StudentLoginPage();
		StudentHomePage Hpage = new StudentHomePage();
		StudentStudentPage Cpage = new StudentStudentPage();
		StudentStudentAccountsPage Spage = new StudentStudentAccountsPage();
		BasePage Bpage = new BasePage();
		try {
			//Lpage.login(data);---this is used for DTS
			Lpage.loginDCRC(data);
			Hpage.MenuButton();
			Hpage.StudentButton();
			Cpage.SelectStudent(data);
			Spage.LedgerPaymentPage(data);
		} 
		catch (Exception e) {
			TestReportsLog.log(LogStatus.FAIL, "Script Failed due to Unhandled Exception " + e.getMessage());
		} 
		finally {
		    Bpage.QuitBrowser();
		}
	}

}
