package com.StudentPortal.Pages;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.elements.CustomAsserts;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
import com.framework.base.BasePage;
import com.framework.base.constants.FrameworkConstants;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import com.framework.util.StringHash;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class APIAutomationPage extends BasePage {

	static String EmployerNameValue = AppendValue.apendString();
	static String EmailAddressValue = AppendValue.apendString();
	static String SectionCode = AppendValue.apendString();
	static String DocNameValue = AppendValue.apendString();
	static String DocCodeValue = AppendValue.apendString();
	static String DocSchNameValue = AppendValue.apendString();
	static String DocPolyNameValue = AppendValue.apendString();
	static String DocPolyCodeValue = AppendValue.apendString();
	static String SubNameValue = AppendValue.apendString();
	static String SubCodeValue = AppendValue.apendString();
//Test 1 - Place students into a job
	@Test(priority=1)
	public void PlaceStudentsintoJob(StringHash data) throws Exception {
		
		String token = ""+data.get("Token")+"";
		Response res = given()
				.header("Authorization","Basic "+token)
				.body("{\r\n"
						+ "    \"payload\": {\r\n"
						+ "        \"PlacementID\": "+data.get("PlacementID")+",\r\n"
						+ "        \"Descrip\": \"\",\r\n"
						+ "        \"PlStudentID\": \""+data.get("PlStudentID")+"\",\r\n"
						+ "        \"EmployerID\": "+data.get("EmployerID")+",\r\n"
						+ "        \"JobID\": "+data.get("JobID")+",\r\n"
						+ "        \"PlRepID\": "+data.get("PlRepID")+",\r\n"
						+ "        \"UserID\": "+data.get("UserID")+",\r\n"
						+ "        \"Supervisor\": \"\",\r\n"
						+ "        \"Comment\": \"\",\r\n"
						+ "        \"HowPlacedId\": "+data.get("HowPlacedId")+",\r\n"
						+ "        \"SalaryType\": \"\",\r\n"
						+ "        \"Salary\": "+data.get("Salary")+",\r\n"
						+ "        \"InFieldOfStudy\": \""+data.get("InFieldOfStudy")+"\",\r\n"
						+ "        \"FromInterview\": true,\r\n"
						+ "        \"Benefits\": false,\r\n"
						+ "        \"Fee\": false,\r\n"
						+ "        \"JobSchedule\": \""+data.get("JobSchedule")+"\",\r\n"
						+ "        \"Current\": true,\r\n"
						+ "        \"SchedFrom\": \"\",\r\n"
						+ "        \"SchedTo\": \"\",\r\n"
						+ "        \"EndDate\": \""+data.get("EndDate")+"\",\r\n"
						+ "        \"JobTypeID\": "+data.get("JobTypeID")+",\r\n"
						+ "        \"DatePlaced\": \""+data.get("DatePlaced")+"\",\r\n"
						+ "        \"StartDate\": \""+data.get("StartDate")+"\",\r\n"
						+ "        \"PlJobTitleID\": "+data.get("PlJobTitleID")+",\r\n"
						+ "        \"PlacementStatusID\": "+data.get("PlacementStatusID")+",\r\n"
						+ "        \"PlJobSourceID\": "+data.get("PlJobSourceID")+",\r\n"
						+ "        \"SupervisorPhone\": \"\",\r\n"
						+ "        \"EnrollSchID\": "+data.get("EnrollSchID")+",\r\n"
						+ "        \"ExactJobTitle\": \"\",\r\n"
						+ "        \"PlJobCategoryID\": "+data.get("PlJobCategoryID")+",\r\n"
						+ "        \"TermDate\": \""+data.get("TermDate")+"\",\r\n"
						+ "        \"TermReason\": \"\",\r\n"
						+ "        \"Converted\": "+data.get("Converted")+",\r\n"
						+ "        \"Status\": \""+data.get("Status")+"\",\r\n"
						+ "        \"OldPlacementID\": "+data.get("OldPlacementID")+"\r\n"
						+ "    }\r\n"
						+ "}")
				.when().contentType(ContentType.JSON)
				.post(""+data.get("URI")+"");
					
		int StatusCode = res.getStatusCode();
		
		String Statusline = res.getStatusLine();
		
		TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
		
		TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
		
		TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
		
		if(StatusCode==200) {
			TestReportsLog.log(LogStatus.PASS, "The Placement records were successfully saved");
		}
		else {
			TestReportsLog.log(LogStatus.FAIL, "The Placement records Not Saved successfully");
			
		}
		
		/*String responseBodyAsString = res.getBody().asString();
		CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
  }
	
//Test 2 - Place students into a Internship
		@Test(priority=1)
		public void PlacementStudentsintoInternship(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Placement records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Placement records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
			CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 3 - Place students into a Externship
		@Test(priority=1)
		public void PlacementStudentsIntoExternship(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"PlacementID\": 0,\r\n"
							+ "        \"Descrip\": \"\",\r\n"
							+ "        \"PlStudentID\": \""+data.get("PlStudentID")+"\",\r\n"
							+ "        \"EmployerID\": "+data.get("EmployerID")+",\r\n"
							+ "        \"JobID\": 0,\r\n"
							+ "        \"PlRepID\": 0,\r\n"
							+ "        \"UserID\": "+data.get("UserID")+",\r\n"
							+ "        \"Supervisor\": \"\",\r\n"
							+ "        \"Comment\": \"\",\r\n"
							+ "        \"HowPlacedId\": "+data.get("HowPlacedId")+",\r\n"
							+ "        \"SalaryType\": \"\",\r\n"
							+ "        \"Salary\": 0,\r\n"
							+ "        \"InFieldOfStudy\": \""+data.get("InFieldOfStudy")+"\",\r\n"
							+ "        \"FromInterview\": true,\r\n"
							+ "        \"Benefits\": false,\r\n"
							+ "        \"Fee\": false,\r\n"
							+ "        \"JobSchedule\": \"F\",\r\n"
							+ "        \"Current\": true,\r\n"
							+ "        \"SchedFrom\": \"\",\r\n"
							+ "        \"SchedTo\": \"\",\r\n"
							+ "        \"EndDate\": \"1900/01/01 00:00:00\",\r\n"
							+ "        \"JobTypeID\": "+data.get("JobTypeID")+",\r\n"
							+ "        \"DatePlaced\": \""+data.get("DatePlaced")+"\",\r\n"
							+ "        \"StartDate\": \""+data.get("StartDate")+"\",\r\n"
							+ "        \"PlJobTitleID\": "+data.get("PlJobTitleID")+",\r\n"
							+ "        \"PlacementStatusID\": "+data.get("PlacementStatusID")+",\r\n"
							+ "        \"PlJobSourceID\": 0,\r\n"
							+ "        \"SupervisorPhone\": \"\",\r\n"
							+ "        \"EnrollSchID\": 0,\r\n"
							+ "        \"ExactJobTitle\": \"\",\r\n"
							+ "        \"PlJobCategoryID\": 0,\r\n"
							+ "        \"TermDate\": \"1900/01/01 00:00:00\",\r\n"
							+ "        \"TermReason\": \"\",\r\n"
							+ "        \"Converted\": 0,\r\n"
							+ "        \"Status\": \""+data.get("Status")+"\",\r\n"
							+ "        \"OldPlacementID\": 0\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Placement records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Placement records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
					CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 4 - Add FA Documents
		@Test(priority=1)
		public void AddFADocuments(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"studentId\": "+data.get("StudentId")+",\r\n"
							+ "        \"moduleId\": "+data.get("ModuleId")+",\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"requestedDate\": \""+data.get("RequestedDate")+"\",\r\n"
							+ "        \"documentTypeId\": "+data.get("DocumentTypeId")+",\r\n"
							+ "        \"documentStatusId\": "+data.get("DocumentStatusId")+",\r\n"
							+ "        \"awardYear\": \""+data.get("AwardYear")+"\",\r\n"
							+ "        \"studentPlacementId\": null,\r\n"
							+ "        \"createdByUserId\": 3503\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "FA Documents were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "FA Documents records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
			CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 5 - Add FA Document List
		@Test(priority=1)
		public void AddFADocumentList(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
							+ "        \"ModuleId\": "+data.get("ModuleId")+",\r\n"
							+ "        \"EnrollmentId\": "+data.get("EnrollmentId")+",\r\n"
							+ "        \"DateRequested\": \""+data.get("DateRequested")+"\",\r\n"
							+ "        \"DocumentTypeListId\": "+data.get("DocumentTypeListId")+",\r\n"
							+ "        \"DateApproved\": null,\r\n"
							+ "        \"DocumentStatusId\": "+data.get("DocumentStatusId")+",\r\n"
							+ "        \"AwardYear\": null,\r\n"
							+ "        \"StudentPlacementId\": null\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "FA Document List records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "FA Document List records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
					CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}
		//Test 6 - Student Application Creation
		@Test(priority=1)
		public void StudentApplicationCreation(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"accountReceivableBalance\": 0,\r\n"
							+ "        \"admissionsRegionId\": null,\r\n"
							+ "        \"applicantProgress\": 0,\r\n"
							+ "        \"applicantTypeId\": "+data.get("applicantTypeId")+",\r\n"
							+ "        \"applicationReceivedDate\": \""+data.get("applicationReceivedDate")+"\",\r\n"
							+ "        \"assignedAdmissionsRepId\": "+data.get("assignedAdmissionsRepId")+",\r\n"
							+ "        \"billingMethodId\": null,\r\n"
							+ "        \"campusId\": "+data.get("campusId")+",\r\n"
							+ "        \"catalogYearId\": 0,\r\n"
							+ "        \"clockHoursRequired\": 0,\r\n"
							+ "        \"createdDateTime\": \""+data.get("createdDateTime")+"\",\r\n"
							+ "        \"creditHoursRequired\": 0,\r\n"
							+ "        \"enrollmentDate\": null,\r\n"
							+ "        \"enrollmentNumber\": null,\r\n"
							+ "        \"enrollmentStatusId\": null,\r\n"
							+ "        \"expectedCreditsHoursPerTerm\": 0,\r\n"
							+ "        \"expectedHoursPerWeekForExternship\": 0,\r\n"
							+ "        \"expectedStartDate\": null,\r\n"
							+ "        \"externshipBeginDate\": null,\r\n"
							+ "        \"faEntranceInterviewDate\": null,\r\n"
							+ "        \"gradeLevelId\": null,\r\n"
							+ "        \"gradeScaleId\": null,\r\n"
							+ "        \"graduationDate\": null,\r\n"
							+ "        \"ipedsState\": null,\r\n"
							+ "        \"isApplicant\": true,\r\n"
							+ "        \"isTransfer\": false,\r\n"
							+ "        \"lastActivityDate\": null,\r\n"
							+ "        \"lastModifiedDateTime\": \""+data.get("lastModifiedDateTime")+"\",\r\n"
							+ "        \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
							+ "        \"midpointDate\": null,\r\n"
							+ "        \"note\": \"\",\r\n"
							+ "        \"originalAssignedAdmissionsRepId\": null,\r\n"
							+ "        \"originalExpectedStartDate\": null,\r\n"
							+ "        \"previousEducationId\": null,\r\n"
							+ "        \"programId\": \""+data.get("programId")+"\",\r\n"
							+ "        \"programVersionId\": \"\",\r\n"
							+ "        \"programVersionName\": null,\r\n"
							+ "        \"rowVersion\": null,\r\n"
							+ "        \"schoolStatusChangeDate\": null,\r\n"
							+ "        \"schoolStatusChangeReasonId\": null,\r\n"
							+ "        \"schoolStatusId\": "+data.get("schoolStatusId")+",\r\n"
							+ "        \"shiftId\": null,\r\n"
							+ "        \"startDateId\": null,\r\n"
							+ "        \"startTermId\": null,\r\n"
							+ "        \"statChangeType\": 0,\r\n"
							+ "        \"studentId\": "+data.get("studentId")+",\r\n"
							+ "        \"transcriptIssued\": null,\r\n"
							+ "        \"transferCreditHours\": null,\r\n"
							+ "        \"applicantAreasOfStudy\": [],\r\n"
							+ "        \"overrideWithProgramVersionDates\": 2,\r\n"
							+ "        \"modifiedPropertiesForEdit\": null,\r\n"
							+ "        \"isProgramVersionDifferent\": 0,\r\n"
							+ "        \"originalState\": \"H4sIAAAAAAAEALWTy2rDQAxFfyV4X4/T7IxjCM0mNA9o0tKtGMuJYB5mpMR1v771pHTnLgqz1ZXOvSCpWoUAw6F9xuENzBUPLUsgdwY3nIYOZx/WOF5mF5GuVIr1BS1wbkkHz76VXHurHotioeaFOmIgMPQJQt6pCObsTijpl9H3fd4vch/O4+Bcve+2x4h9IMcCTmNWVxNxolBveNV1hjQ4qdRYqGLvjEpHZplJuGKm6ihNQqbpW2DZ+YZawuaVMWyaxCZrEDyRxQQ2SbI/BfxOnDL2z3rHM3pBjXS7uyVw2vv/YtXfj1N/Ad6XdddZAwAA\",\r\n"
							+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "        \"extendedProperties\": [],\r\n"
							+ "        \"entityState\": 0\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Student Application records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Student Application records Not Saved successfully");
			}

			/*String responseBodyAsString = res.getBody().asString();
							CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 7 - Enter Transfer Credits
		@Test(priority=1)
		public void TransferCredits(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"studentTransferCreditId\": -1,\r\n"
							+ "        \"studentId\": "+data.get("studentId")+",\r\n"
							+ "        \"studentEnrollmentPeriodId\": "+data.get("studentEnrollmentPeriodId")+",\r\n"
							+ "        \"transferCreditTypeId\": "+data.get("transferCreditTypeId")+",\r\n"
							+ "        \"approvedDate\": null,\r\n"
							+ "        \"transferCreditStatusId\": \""+data.get("transferCreditStatusId")+"\",\r\n"
							+ "        \"isApproved\": false,\r\n"
							+ "        \"termId\": null,\r\n"
							+ "        \"grade\": \"\",\r\n"
							+ "        \"studentTransferCreditExternalCourseList\": [\r\n"
							+ "            {\r\n"
							+ "                \"id\": -1,\r\n"
							+ "                \"uid\": \"2f184953-41f3-4b2b-9fdf-cf9c684f8d48\",\r\n"
							+ "                \"collegeId\": "+data.get("collegeId")+",\r\n"
							+ "                \"collegeCourseCredits\": 0,\r\n"
							+ "                \"collegeCourseClockHours\": null,\r\n"
							+ "                \"collegeCourseGrade\": \""+data.get("collegeCourseGrade")+"\",\r\n"
							+ "                \"collegeCourseId\": "+data.get("collegeCourseId")+",\r\n"
							+ "                \"completionDate\": \""+data.get("completionDate")+"\",\r\n"
							+ "                \"collegeCourseStartDate\": null,\r\n"
							+ "                \"highSchoolCourseId\": null,\r\n"
							+ "                \"highSchoolId\": null,\r\n"
							+ "                \"entityState\": 0,\r\n"
							+ "                \"collegeCourseClockHoursAttempted\": null,\r\n"
							+ "                \"collegeCourseClockHoursEarned\": null,\r\n"
							+ "                \"collegeCourseCreditHoursAttempted\": 0,\r\n"
							+ "                \"collegeCourseCreditHoursEarned\": 0,\r\n"
							+ "                \"collegeCourseGradePoints\": 0\r\n"
							+ "            }\r\n"
							+ "        ],\r\n"
							+ "        \"studentTransferCreditInternalCourseList\": [\r\n"
							+ "            {\r\n"
							+ "                \"id\": -1,\r\n"
							+ "                \"uid\": \"a1025b22-91e0-4f65-aa2b-2f5c236909ea\",\r\n"
							+ "                \"courseId\": "+data.get("courseId")+",\r\n"
							+ "                \"credits\": "+data.get("credits")+",\r\n"
							+ "                \"hours\": "+data.get("hours")+",\r\n"
							+ "                \"entityState\": 0\r\n"
							+ "            }\r\n"
							+ "        ],\r\n"
							+ "        \"collegeCourseClockHoursAttempted\": null,\r\n"
							+ "        \"collegeCourseClockHoursEarned\": null,\r\n"
							+ "        \"collegeCourseCreditHoursAttempted\": \"0.00\",\r\n"
							+ "        \"collegeCourseCreditHoursEarned\": \"0.00\",\r\n"
							+ "        \"collegeCourseGradePoints\": 0,\r\n"
							+ "        \"rowVersion\": null\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Transfer credit records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Transfer credit records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
						CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 8 - Post a Charge to Student Ledger
		@Test(priority=1)
		public void PostCharge(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"BillingTransactionCodeId\": "+data.get("BillingTransactionCodeId")+",\r\n"
							+ "        \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
							+ "        \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
							+ "        \"TermId\": "+data.get("TermId")+",\r\n"
							+ "        \"StudentAccountClassSectionId\": null,\r\n"
							+ "        \"StudentAcademicYearPaymentPeriodId\": null,\r\n"
							+ "        \"TransactionDate\": \""+data.get("TransactionDate")+"\",\r\n"
							+ "        \"Description\": \""+data.get("Description")+"\",\r\n"
							+ "        \"Reference\": \"\",\r\n"
							+ "        \"IsChargeAdjustment\": true,\r\n"
							+ "        \"IgnoreTermRequired\": false,\r\n"
							+ "        \"OverrideBilledDate\": null,\r\n"
							+ "        \"AllowProcessByAutomation\": null,\r\n"
							+ "        \"StudentEnrollmentPeriodFeeId\": null,\r\n"
							+ "        \"PaymentDueDate\": null\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Transaction records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Transaction records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 9 - Post a payment
		@Test(priority=1)
		public void PostPayment(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
							+ "        \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
							+ "        \"TermId\": "+data.get("TermId")+",\r\n"
							+ "        \"StudentAcademicYearPaymentPeriodId\": 0,\r\n"
							+ "        \"TransactionDate\": \""+data.get("TransactionDate")+"\",\r\n"
							+ "        \"Description\": \"Student Payment\",\r\n"
							+ "        \"Reference\": \"\",\r\n"
							+ "        \"IgnoreTermRequired\": false,\r\n"
							+ "        \"IsStudentPayment\": true,\r\n"
							+ "        \"AcademicYearSequence\": \""+data.get("AcademicYearSequence")+"\",\r\n"
							+ "        \"PaymentMode\": 0,\r\n"
							+ "        \"FundSourceId\": 0,\r\n"
							+ "        \"ScheduledPaymentId\": 0,\r\n"
							+ "        \"PaymentType\": \"C\",\r\n"
							+ "        \"BankAccountId\": "+data.get("BankAccountId")+",\r\n"
							+ "        \"PaidByUserId\": 0,\r\n"
							+ "        \"StudentCreditCardId\": 0,\r\n"
							+ "        \"AuthorizationNumber\": \"\",\r\n"
							+ "        \"CheckNumber\": \"\",\r\n"
							+ "        \"CashDrawerId\": "+data.get("CashDrawerId")+",\r\n"
							+ "        \"CashDrawerSessionId\": "+data.get("CashDrawerSessionId")+",\r\n"
							+ "        \"CashierUserId\": "+data.get("CashierUserId")+",\r\n"
							+ "        \"ActualSource\": \"\",\r\n"
							+ "        \"IsStudentCreditCardAuthorizeRequired\": false,\r\n"
							+ "        \"OpeningBalance\": \"\",\r\n"
							+ "        \"OverrideDisbursementAssociation\": false,\r\n"
							+ "        \"AgencyBranchId\": 0,\r\n"
							+ "        \"PayWithExistingCreditCard\": true,\r\n"
							+ "        \"IsSaveAndNew\": false,\r\n"
							+ "        \"BaseURI\": \"https://sisclientweb-900070.campusnexus.cloud/\",\r\n"
							+ "        \"AgencyCreditCardId\": 0,\r\n"
							+ "        \"IsApplyPayment\": false,\r\n"
							+ "        \"ClassSectionId\": null,\r\n"
							+ "        \"ExtendedProperties\": [],\r\n"
							+ "        \"StudentBankAccountId\": 0,\r\n"
							+ "        \"Drn\": \"\"\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Transaction records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Transaction records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 10 - Perform Status Change
		@Test(priority=1)
		public void StatusChange(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"NewSchoolStatusId\": "+data.get("NewSchoolStatusId")+",\r\n"
							+ "        \"SchoolStatusChangeReasonId\": "+data.get("SchoolStatusChangeReasonId")+",\r\n"
							+ "        \"EffectiveDate\": \""+data.get("EffectiveDate")+"\",\r\n"
							+ "        \"GraduationDate\": \""+data.get("GraduationDate")+"\",\r\n"
							+ "        \"UseEnrollmentGraduationDate\": false,\r\n"
							+ "        \"DeletePendingChanges\": false,\r\n"
							+ "        \"DeleteCourseAssociation\": false,\r\n"
							+ "        \"OverrideStatusChangeDays\": false,\r\n"
							+ "        \"IsOfficialWithdrawal\": false,\r\n"
							+ "        \"RemoveAttendanceBackToLastAttendedDate\": false,\r\n"
							+ "        \"OverrideSapEnrollmentLinking\": false\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Status Change records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Status Change records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}	

		//Test 11 - Create Student Group

		static String StudentGroupName = AppendValue.apendString();
		@Test(priority=1)
		public void CreateStudentGroup(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"campusGroupId\": "+data.get("campusGroupId")+",\r\n"
							+ "        \"code\": \"\",\r\n"
							+ "        \"createdDateTime\": \""+data.get("createdDateTime")+"\",\r\n"
							+ "        \"dataQueryIdentifier\": null,\r\n"
							+ "        \"expirationDate\": \""+data.get("expirationDate")+"\",\r\n"
							+ "        \"groupType\": \""+data.get("groupType")+"\",\r\n"
							+ "        \"isActive\": true,\r\n"
							+ "        \"isPortalGroup\": false,\r\n"
							+ "        \"isPublic\": true,\r\n"
							+ "        \"isSprocQuery\": false,\r\n"
							+ "        \"isTransferMonitoringGroup\": false,\r\n"
							+ "        \"isUsedForAutoAwardCoa\": false,\r\n"
							+ "        \"isUsedForAutoAwardRules\": false,\r\n"
							+ "        \"jobFrequency\": \"\",\r\n"
							+ "        \"lastModifiedDateTime\": \""+data.get("lastModifiedDateTime")+"\",\r\n"
							+ "        \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
							+ "        \"lastRefreshDate\": \"1901/01/01 00:00:00\",\r\n"
							+ "        \"name\": \""+StudentGroupName+"\",\r\n"
							+ "        \"ownerStaffId\": "+data.get("ownerStaffId")+",\r\n"
							+ "        \"preserveManualAddedStudentsOnRefresh\": false,\r\n"
							+ "        \"rowVersion\": null,\r\n"
							+ "        \"sqlQuery\": \"\",\r\n"
							+ "        \"viewQuery\": null,\r\n"
							+ "        \"staffAccess\": [],\r\n"
							+ "        \"originalState\": \"H4sIAAAAAAAEALWVTU/DMAyG/8rUO83GblNXaRofAjYGdENcs9RZLbVJ5yR05ddDg8RtCCH5mFh+/Oq1nWQLItlv9AP0r7IOsNHOE5qDNP22b2F0amrj5knlfTsTwqkKGunSBhVZZ7VPlW3E5Xg8FZOxKIBQ1vghPVojItgl34QZ/jC6rku7aWrpMCROxNt6VUTsBRrnpVGQ5NkZOTGQr6Tza1uiRih3DuiuzMRwn8WUEc4M1vPEU4BE5DF0lvW3IlfSwxYbYCjDon1J8KWYU/Yt2dAORw5L3EJ5fOdBP4V9jYrDc1tyKH6ULP27t/sbgmMAo3qm5XkBTeCqYQgZKhTH+jkAcYhfyqYNLk44y3ZuOgNUeKk1C/761CLFJ/j/1ovff4X8E2Hrctk2BgAA\",\r\n"
							+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "        \"extendedProperties\": [],\r\n"
							+ "        \"entityState\": 0\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Student Group Name = "+StudentGroupName);

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			System.out.println("Student Group Name: " +StudentGroupName);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Student Group records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Student Group records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}	

		//Test 12 - Add Student to a group
		@Test(priority=1)
		public void AddStudentToGroup(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentGroupId\": \""+data.get("StudentGroupId")+"\",\r\n"
							+ "        \"StudentIds\": [\r\n"
							+ "            "+data.get("StudentIds")+"\r\n"
							+ "        ],\r\n"
							+ "        \"ChangeGroupTypeToManual\": false\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 13 - Add Course To Student Courses
		@Test(priority=1)
		public void AddCourseToStudentCourses(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";

			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentCourseId\": null,\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"CampusId\": "+data.get("CampusId")+",\r\n"
							+ "        \"ClassSectionId\": 0,\r\n"
							+ "        \"CourseId\": "+data.get("CourseId")+",\r\n"
							+ "        \"RequiredCourseId\": "+data.get("RequiredCourseId")+",\r\n"
							+ "        \"ParentTermId\": null,\r\n"
							+ "        \"TermId\": null,\r\n"
							+ "        \"AcademicYearId\": 0,\r\n"
							+ "        \"Comments\": \"\",\r\n"
							+ "        \"Action\": 1,\r\n"
							+ "        \"AllowOverrideRegistrationHold\": false,\r\n"
							+ "        \"IsAllowedToOverrideRetakeAttempts\": false,\r\n"
							+ "        \"IsAllowedToAuditCourse\": false,\r\n"
							+ "        \"IsAllowedCourse\": false,\r\n"
							+ "        \"IsAllowedToOverrideLockedTermSequence\": false,\r\n"
							+ "        \"IsAllowedMaxClassSizeRegisterOverride\": false,\r\n"
							+ "        \"IsAllowedToWaitListStudent\": false,\r\n"
							+ "        \"isAllowedPostCourseStartDateRegistration\": false,\r\n"
							+ "        \"IsWaitlistStudentNotified\": false,\r\n"
							+ "        \"IsSubstituteCourse\": false,\r\n"
							+ "        \"SubstituteCourseId\": 0,\r\n"
							+ "        \"IsAudit\": false,\r\n"
							+ "        \"StudentCourseFeeScheduleId\": 0,\r\n"
							+ "        \"Description\": \"\",\r\n"
							+ "        \"StartDate\": null,\r\n"
							+ "        \"EndDate\": null,\r\n"
							+ "        \"IsRetakeOverride\": false,\r\n"
							+ "        \"RetakeID\": 0,\r\n"
							+ "        \"ReturnCode\": 0,\r\n"
							+ "        \"IsPassFail\": 0,\r\n"
							+ "        \"UseFeeSchedule\": false,\r\n"
							+ "        \"RetakeFee\": \"o\",\r\n"
							+ "        \"ClassCount\": 0,\r\n"
							+ "        \"IsAllowStudentAcademicYearPaymentPeriod\": false,\r\n"
							+ "        \"IsAllowedRegisterAsAuditClass\": false,\r\n"
							+ "        \"IsAllowedDateTimeConflict\": false,\r\n"
							+ "        \"Status\": \"F\",\r\n"
							+ "        \"AllowClassSection\": false,\r\n"
							+ "        \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
							+ "        \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
							+ "        \"SkipPrereqCheck\": false,\r\n"
							+ "        \"SkipCoreqCheck\": false,\r\n"
							+ "        \"IgnoreMultiCourseDependency\": false,\r\n"
							+ "        \"IsReservedStatus\": false,\r\n"
							+ "        \"IsAllowedToOverrideStudentIntoCourse\": false,\r\n"
							+ "        \"IsAllowedToWaitlistAvailableStudentIntoCourse\": false,\r\n"
							+ "        \"IsAllowedToWaitlistStudentIntoCourse\": false,\r\n"
							+ "        \"IsRegistrationRetake\": false,\r\n"
							+ "        \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
							+ "        \"IsAllowedToOverrideClosedTerm\": false,\r\n"
							+ "        \"IsAllowedToOverrideRegistrationGroup\": false,\r\n"
							+ "        \"IsOverlapWithParentTermAllowed\": false,\r\n"
							+ "        \"IsEnrollmentAdjusted\": false,\r\n"
							+ "        \"IsGlobalCumulativeIncluded\": true\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("ADDURI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);


			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Course records were successfully Saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Course records were not Saved");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 14 - Register a student for a course  
		@Test(priority=1)
		public void RegisterStudent(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentCourseId\": "+data.get("StudentCourseId")+",\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"CampusId\": "+data.get("CampusId")+",\r\n"
							+ "        \"ClassSectionId\": "+data.get("ClassSectionId")+",\r\n"
							+ "        \"CourseId\": "+data.get("CourseId")+",\r\n"
							+ "        \"RequiredCourseId\": "+data.get("RequiredCourseId")+",\r\n"
							+ "        \"ParentTermId\": "+data.get("ParentTermId")+",\r\n"
							+ "        \"TermId\": "+data.get("TermId")+",\r\n"
							+ "        \"AcademicYearId\": "+data.get("AcademicYearId")+",\r\n"
							+ "        \"Hours\": "+data.get("Hours")+",\r\n"
							+ "        \"Comments\": \"\",\r\n"
							+ "        \"Credits\": "+data.get("Credits")+",\r\n"
							+ "        \"Action\": 2,\r\n"
							+ "        \"AllowOverrideRegistrationHold\": false,\r\n"
							+ "        \"IsAllowedToOverrideRetakeAttempts\": false,\r\n"
							+ "        \"IsAllowedToAuditCourse\": false,\r\n"
							+ "        \"IsAllowedCourse\": false,\r\n"
							+ "        \"IsAllowedToOverrideLockedTermSequence\": false,\r\n"
							+ "        \"IsAllowedMaxClassSizeRegisterOverride\": false,\r\n"
							+ "        \"IsAllowedToWaitListStudent\": false,\r\n"
							+ "        \"IsAllowedPostCourseStartDateRegistration\": false,\r\n"
							+ "        \"isRetakeValidationDisplayed\": false,\r\n"
							+ "        \"IsSubstituteCourse\": false,\r\n"
							+ "        \"SubstituteCourseId\": 0,\r\n"
							+ "        \"IsAudit\": false,\r\n"
							+ "        \"StudentCourseFeeScheduleId\": -1,\r\n"
							+ "        \"IsCrossReferencedCourse\": false,\r\n"
							+ "        \"IsCrsg\": false,\r\n"
							+ "        \"Description\": \"\",\r\n"
							+ "        \"StartDate\": \"2022-01-01T00:00:00\",\r\n"
							+ "        \"EndDate\": \"2025-07-13T23:59:59\",\r\n"
							+ "        \"IsRetakeOverride\": false,\r\n"
							+ "        \"RetakeID\": 0,\r\n"
							+ "        \"ReturnCode\": 0,\r\n"
							+ "        \"IsPassFail\": 0,\r\n"
							+ "        \"UseFeeSchedule\": true,\r\n"
							+ "        \"RetakeFee\": \"O\",\r\n"
							+ "        \"ClassCount\": 0,\r\n"
							+ "        \"IsAllowStudentAcademicYearPaymentPeriod\": false,\r\n"
							+ "        \"IsAllowedRegisterAsAuditClass\": false,\r\n"
							+ "        \"IsAllowedDateTimeConflict\": true,\r\n"
							+ "        \"Status\": \"F\",\r\n"
							+ "        \"AllowClassSection\": false,\r\n"
							+ "        \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
							+ "        \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
							+ "        \"SkipPrereqCheck\": false,\r\n"
							+ "        \"SkipCoreqCheck\": false,\r\n"
							+ "        \"IgnoreMultiCourseDependency\": false,\r\n"
							+ "        \"IsReservedStatus\": false,\r\n"
							+ "        \"IsAllowedToOverrideStudentIntoCourse\": false,\r\n"
							+ "        \"IsAllowedToWaitlistAvailableStudentIntoCourse\": false,\r\n"
							+ "        \"IsAllowedToWaitlistStudentIntoCourse\": false,\r\n"
							+ "        \"IsRegistrationRetake\": false,\r\n"
							+ "        \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
							+ "        \"IsAllowedToOverrideClosedTerm\": false,\r\n"
							+ "        \"IsAllowedToOverrideRegistrationGroup\": false,\r\n"
							+ "        \"IsOverlapWithParentTermAllowed\": false,\r\n"
							+ "        \"IsAllowedToWaitListForDifferentSection\": false,\r\n"
							+ "        \"IsAllowedToOverrideCourseStatus\": false\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Course records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Course records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
						CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 15 - Drop a course from a students schedule 
		@Test(priority=1)
		public void DropCourseFromStudentSchedule(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentEnrollmentScheduleId\": "+data.get("StudentEnrollmentScheduleId")+",\r\n"
							+ "        \"DropDate\": \""+data.get("DropDate")+"\",\r\n"
							+ "        \"LetterGrade\": \""+data.get("LetterGrade")+"\",\r\n"
							+ "        \"DropReasonId\": "+data.get("DropReasonId")+",\r\n"
							+ "        \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
							+ "        \"SkipCoreqCheck\": false,\r\n"
							+ "        \"SkipPrereqCheck\": false,\r\n"
							+ "        \"IgnoreMultiCourseDependency\": false,\r\n"
							+ "        \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
							+ "        \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
							+ "        \"PrereqCoreqFailureMesssageType\": null,\r\n"
							+ "        \"AllowOverrideClosedTerm\": false,\r\n"
							+ "        \"AllowLdwOverride\": false,\r\n"
							+ "        \"IsAuditCourse\": false,\r\n"
							+ "        \"ImpactedStudentCourseIds\": [],\r\n"
							+ "        \"AllowedOnlyParent\": false\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Course was dropped successfully");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Course was not dropped");

			}

			/*String responseBodyAsString = res.getBody().asString();
						CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 15 - Delete Course from Student Schedule
		@Test(priority=1)
		public void DeleteCoursefromStudentCourses(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentCourseId\": "+data.get("StudentCourseId")+",\r\n"
							+ "        \"MinutesAttended\": 0,\r\n"
							+ "        \"MinutesAbsent\": 0,\r\n"
							+ "        \"AllowDeleteAttendanceHistory\": false,\r\n"
							+ "        \"AllowDeletePendingCharges\": false,\r\n"
							+ "        \"IsPendingCharges\": false,\r\n"
							+ "        \"TermId\": "+data.get("TermId")+",\r\n"
							+ "        \"IsAllowedToOverrideClosedTerm\": false,\r\n"
							+ "        \"Action\": "+data.get("Action")+",\r\n"
							+ "        \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
							+ "        \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
							+ "        \"CourseStatusChangeReasonId\": "+data.get("CourseStatusChangeReasonId")+",\r\n"
							+ "        \"SkipCoreqCheck\": false,\r\n"
							+ "        \"SkipPrereqCheck\": false,\r\n"
							+ "        \"FailureMessageType\": 0,\r\n"
							+ "        \"IgnoreMultiCourseDependency\": false,\r\n"
							+ "        \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
							+ "        \"TermCode\": \""+data.get("TermCode")+"\",\r\n"
							+ "        \"Section\": \"\",\r\n"
							+ "        \"CampusId\": "+data.get("CampusId")+",\r\n"
							+ "        \"NotifyStudent\": false\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Course was Deleted successfully");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Course was not Deleted");

			}

			/*String responseBodyAsString = res.getBody().asString();
						CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 17 - Create Registration locks
		@Test(priority=1)
		public void CreateRegistrationlocks(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"createdDateTime\": \""+data.get("createdDateTime")+"\",\r\n"
							+ "        \"isDropCoursesIncludedInNumberLimit\": false,\r\n"
							+ "        \"isLoaCoursesIncludedInNumberLimit\": false,\r\n"
							+ "        \"lastModifiedDateTime\": \""+data.get("lastModifiedDateTime")+"\",\r\n"
							+ "        \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
							+ "        \"numberLimit\": \"\",\r\n"
							+ "        \"rowVersion\": null,\r\n"
							+ "        \"ruleType\": \""+data.get("ruleType")+"\",\r\n"
							+ "        \"studentGroupId\": "+data.get("studentGroupId")+",\r\n"
							+ "        \"studentId\": null,\r\n"
							+ "        \"termId\": null,\r\n"
							+ "        \"termType\": \""+data.get("termType")+"\",\r\n"
							+ "        \"unitType\": null,\r\n"
							+ "        \"originalState\": \"H4sIAAAAAAAEALWSQWvCQBCF/4rs3UystxADRS+lige19DokkziQ3ZWZkTT99dUt9KYIxes83ve+w5SvIjhu23caP7A/07ZVEw4dhnE/nmjy5fugC3c0OxUAWh/Jo2aea4kaW8vq6OElz+cwy2FHwtjzNxrHAAms7pdQ8B9jGIZsmGdRumtxBp+b9S5hpxzUMNTkqvKGTgqqNaptYsMtU3NQkremhOu9TJUJF4H7hTM5k4MqRTdZj42s0GjPnp4w8xT3pdDF+J/acP8zqh9MEFNEOgIAAA==\",\r\n"
							+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "        \"extendedProperties\": [],\r\n"
							+ "        \"entityState\": 0\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Course was dropped successfully");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Course was not dropped");

			}

			/*String responseBodyAsString = res.getBody().asString();
						CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 18 - FA Reassignment To AY
		@Test(priority=1)
		public void FAReassignmentToAY(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
							+ "        \"StudentAwardIds\": [\r\n"
							+ "            "+data.get("StudentAwardIds")+"\r\n"
							+ "        ],\r\n"
							+ "        \"FundSourceIds\": [\r\n"
							+ "            "+data.get("FundSourceIds")+"\r\n"
							+ "        ],\r\n"
							+ "        \"IsAdmin\": false\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Course was dropped successfully");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Course was not dropped");

			}

			/*String responseBodyAsString = res.getBody().asString();
						CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 19 - Record individual final grades for a student 

		@Test(priority=1)
		public void RecordIndividualFinalGrades(StringHash data) throws Exception {

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"PostFinalGradeForExistingGrade\": false,\r\n"
							+ "        \"AllowOverrideExpectedDeadlineDate\": true,\r\n"
							+ "        \"CampusId\": "+data.get("CampusId")+",\r\n"
							+ "        \"StudentCourse\": {\r\n"
							+ "            \"transcripNote\": \"\",\r\n"
							+ "            \"isCrsg\": false,\r\n"
							+ "            \"studentEnrollmentPeriodIdList\": null,\r\n"
							+ "            \"studentEnrollmentDpaCourseCategoryId\": 0,\r\n"
							+ "            \"campusId\": "+data.get("CampusId")+",\r\n"
							+ "            \"studentTransferCreditMultipleCourseAssociationId\": null,\r\n"
							+ "            \"studentTransferCreditMultipleId\": null,\r\n"
							+ "            \"id\": "+data.get("id")+",\r\n"
							+ "            \"academicYear\": 0,\r\n"
							+ "            \"adEnrollRegistrationId\": null,\r\n"
							+ "            \"advisedDate\": null,\r\n"
							+ "            \"appealType\": null,\r\n"
							+ "            \"auditEffectiveDate\": null,\r\n"
							+ "            \"averageBestOfPercentFinal\": null,\r\n"
							+ "            \"billedDate\": null,\r\n"
							+ "            \"classSectionId\": "+data.get("classSectionId")+",\r\n"
							+ "            \"clockHours\": "+data.get("clockHours")+",\r\n"
							+ "            \"clockHoursAttempted\": "+data.get("clockHoursAttempted")+",\r\n"
							+ "            \"clockHoursEarned\": 0,\r\n"
							+ "            \"collegeId\": null,\r\n"
							+ "            \"consecutiveMinutesAbsent\": 0,\r\n"
							+ "            \"cost\": 0,\r\n"
							+ "            \"courseAddedFrom\": \"0\",\r\n"
							+ "            \"courseFeeScheduleId\": null,\r\n"
							+ "            \"courseId\": "+data.get("courseId")+",\r\n"
							+ "            \"courseName\": \""+data.get("courseName")+"\",\r\n"
							+ "            \"createdDateTime\": \"2022/07/14 13:31:15\",\r\n"
							+ "            \"creditHours\": "+data.get("creditHours")+",\r\n"
							+ "            \"creditHoursAttempted\": "+data.get("creditHoursAttempted")+",\r\n"
							+ "            \"creditHoursEarned\": 0,\r\n"
							+ "            \"crossReferenceCourseId\": null,\r\n"
							+ "            \"dateReqMet\": null,\r\n"
							+ "            \"dependentClassSectionId\": null,\r\n"
							+ "            \"dropDate\": null,\r\n"
							+ "            \"endDate\": \"2025/07/13 00:00:00\",\r\n"
							+ "            \"enrollmentStatusClockHours\": "+data.get("enrollmentStatusClockHours")+",\r\n"
							+ "            \"enrollmentStatusCreditHours\": "+data.get("enrollmentStatusCreditHours")+",\r\n"
							+ "            \"examRegistrationComments\": null,\r\n"
							+ "            \"examStatus\": null,\r\n"
							+ "            \"expectedDeadlineDate\": null,\r\n"
							+ "            \"expectedEndDate\": \"2025/07/13 23:59:59\",\r\n"
							+ "            \"facultyPostedLda\": null,\r\n"
							+ "            \"faStudentAyPaymentPeriodId\": null,\r\n"
							+ "            \"finalGradeReasonId\": null,\r\n"
							+ "            \"gradePoints\": 0,\r\n"
							+ "            \"gradePostedDate\": \""+data.get("gradePostedDate")+"\",\r\n"
							+ "            \"gradeScaleId\": "+data.get("gradeScaleId")+",\r\n"
							+ "            \"highSchoolId\": null,\r\n"
							+ "            \"include\": false,\r\n"
							+ "            \"incompleteGradeNote\": null,\r\n"
							+ "            \"inProgressGrade\": null,\r\n"
							+ "            \"isAfterAddDrop\": false,\r\n"
							+ "            \"isAuditCourse\": false,\r\n"
							+ "            \"isAutoDrop\": false,\r\n"
							+ "            \"isCostScheduled\": false,\r\n"
							+ "            \"isCourseRefundPolicyUsed\": false,\r\n"
							+ "            \"isCrossReferencedCourse\": false,\r\n"
							+ "            \"isEnrollmentAdjusted\": false,\r\n"
							+ "            \"isExtended\": false,\r\n"
							+ "            \"isExtensionBilled\": null,\r\n"
							+ "            \"isFromPortal\": null,\r\n"
							+ "            \"isGlobalCumulativeIncluded\": true,\r\n"
							+ "            \"isHalfTicketGenerated\": null,\r\n"
							+ "            \"isIncludedInGpaCalc\": true,\r\n"
							+ "            \"isIncompleteGradeReplaced\": false,\r\n"
							+ "            \"isOnlyRateScheduleUsed\": true,\r\n"
							+ "            \"isPassFail\": false,\r\n"
							+ "            \"isSpecialExam\": null,\r\n"
							+ "            \"isStudentDegreePathwayCourse\": false,\r\n"
							+ "            \"isSubstitute\": false,\r\n"
							+ "            \"isTransferCredit\": false,\r\n"
							+ "            \"lastModifiedDateTime\": \"2022/08/19 06:19:40\",\r\n"
							+ "            \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
							+ "            \"lda\": \"2022/03/19 00:00:00\",\r\n"
							+ "            \"letterGrade\": \""+data.get("letterGrade")+"\",\r\n"
							+ "            \"lmsExtractStatus\": \"R\",\r\n"
							+ "            \"makeUpMinutes\": 0,\r\n"
							+ "            \"midTermGradeNote\": null,\r\n"
							+ "            \"midTermGradePostedDate\": null,\r\n"
							+ "            \"midTermLetterGrade\": null,\r\n"
							+ "            \"midTermNumericGrade\": null,\r\n"
							+ "            \"minutesAbsent\": 45,\r\n"
							+ "            \"minutesAttended\": 2909,\r\n"
							+ "            \"modFlag\": \"A\",\r\n"
							+ "            \"note\": \"Registering a Student\",\r\n"
							+ "            \"numericGrade\": \""+data.get("numericGrade")+"\",\r\n"
							+ "            \"outsideCourseWorkHours\": 0,\r\n"
							+ "            \"overrideCourseProgression\": null,\r\n"
							+ "            \"payStatus\": \"Y\",\r\n"
							+ "            \"previousStatus\": \"C\",\r\n"
							+ "            \"qualityPoints\": 0,\r\n"
							+ "            \"requiredCourseId\": null,\r\n"
							+ "            \"retakeFeeWaived\": \"O\",\r\n"
							+ "            \"retakeFlag\": null,\r\n"
							+ "            \"retakeOverride\": false,\r\n"
							+ "            \"retakeTiv2CredEarnValue\": null,\r\n"
							+ "            \"retakeTiv2CredEarnZeroed\": false,\r\n"
							+ "            \"revenueReferenceNumber\": null,\r\n"
							+ "            \"rosterFlag\": null,\r\n"
							+ "            \"rowVersion\": \"AAAAAAsxpY4=\",\r\n"
							+ "            \"speed\": null,\r\n"
							+ "            \"startDate\": \"2022/01/01 00:00:00\",\r\n"
							+ "            \"status\": \"P\",\r\n"
							+ "            \"studentEnrollmentPeriodId\": 499,\r\n"
							+ "            \"studentId\": 496,\r\n"
							+ "            \"studentTransferCreditId\": null,\r\n"
							+ "            \"substituteCourseId\": null,\r\n"
							+ "            \"supplementaryStatus\": null,\r\n"
							+ "            \"termId\": "+data.get("termId")+",\r\n"
							+ "            \"testingScheduleId\": null,\r\n"
							+ "            \"transcriptNote\": \"\",\r\n"
							+ "            \"transferredCourseCode\": null,\r\n"
							+ "            \"transferredCourseDescrip\": null,\r\n"
							+ "            \"transferTypeId\": 1,\r\n"
							+ "            \"originalState\": \"H4sIAAAAAAAEAM1bbU/jOBD+K6jfaZO+sFABUimURUdpri27x30z8bT41rGzttOS+/Vnpy2w0LAqto+gSEik9Twej595ZmyOe0KgfDT7A/JviGYwmkklCJsjlk/zFPYeE8rkSe1BqbTbaMj4ARIk6wmJBZd8puoxTxrNIGg1wqAxAUEQJf8iRThrFAPL2mqELnkaY7lc1petOhdz88Ww8dfwelIMu0+YVIjFUDs9LoFTvDi9wscN8/u4+Mge6Sr96qSGuoSpjT30e3u103b7sHPYOW4U45wWg5ZaLYfTixEG7ZE7QKIEWMYkmTPAZ7mCnRAG1uDwBROc0jHMiX5dLM0b/zFCT2pKZFBrWBhaEAn4HCnwMXqGibqYzSBWZAGejJwRSr3NoE+RlBODf8sCfDSADzvNsGUbIn3K4x9feSZkCSoMMUkQ3W1rHdYD6+B9RtZTCpJUQZnjKgDxAgnmFF/gAp7e+jAHLzu+z5mEODMbckhYpkD27iUw5dIF9vOXTvHoJXGxKDpcoIcx4IHgSQm+1Rf/b3cZZAMAMyLOqK/AMVackWCz1Wy6mfgNSl5Tv8VqRNe3w7Orm8u9XjTeG/X7t1Hvpn9njVSATlBFlpqSUrh4/Xo3RwbN5n7wZT9sT8NWtxV2w079y4F9fhGgk7fzBOOCHZ+ReUkwbiFWM8HoOkCOYQYCtHIv2dkuSMME/Bh+DuE1nzsZHFJgWOeud1WaE0uCp54U5gXbpl1tGaFTMEJrGgTd4rENmFU5kmhfTxRSmfSnPj1g9cZkDrA+pjpsdWIAhClhvmqkjRm/wdZsdTtH+rF1ygDFGVV5pFUg4GuMPDhkgCYqM9TRyyOUm1iJQBCOvbDHgDBELwXCmgqR9ERRxfgR1zLMZZS7SDZrZFJtrdIdaJ/D/fBoGhx0w6NuO6h3vlhrnwLxJEZblPRH5W5oi+krmT/owTinXsLnisVUb4iS2d5rs4DYTjOeISrBdtYaFk9SCgqKNbnhXujxikWCzwVIWVjxYUH2ZgqErh6NlKicl2XRqVvpwCqCU7yabjONik3RXcYUnwrPLKjW+RnDEackzm9lJXH+Uo7gqsbhs7Ds4X8yWV52fibGR2Vqoqoik7pCWzXsvZDsJeX3iPazJKPIdDjXWc2lNwxGe2dsgF2xyxT1EY2riPBl5h1DSlFcxbgaMZqPtXjc8LBjinPjzQhJOUCEVs996zroHLT+gQiphyXKq0rAk+xeKqKy0iLiE7FNBWJSZ7BVt6Fq+K6RVEOOyYz4bEI7L8Rewtb7Wjgrx1qdwB7cm86EAxe2Chc66tpdg9JFx7aaxuKAZGCNKjFaQKB43Z9zB21sC22IfsBtuj4XdRRq1qs4JHgKIvFZAL80UdqpcWioPDAdGrnJEhAk9mfl96fnO19tsr7WtEGl3i0Ddj6sPQqsu7qaxwcUzd3t9p4toi2byYZ8irtaYL63h/bWssoaYnkM27R1O6srEfYZZpQpSfD6BPE7F87PhFw0oEcLEOIJ5abVpytRD6wQodx1VrO+fBAJWBCeSdfA+rbA/swQJeagp4KnFmP4mRGxaUZ56bmPQWm9MQD4jsiilKs/sDAj+8kXyN7StbtpbzZl1SqlFbopWTRNJWdubxSf9eaHl5b+BsGr12IZwwJYBk/9WZ2T7uH1nWknDjHKU/iKOr78BmIL6z/5F0k4aJ8RhkS+mw4pfuRjetc+sfX1JAUvrVFN/UL5OX0N9eOsYnWdoiJ7QIWOe279l9wT+LDiP7IW1muIDiEdOIL0a0/MSw59bgl6TNSmmnTn3tB6lxR+jQVJldMSxsJB64V+0kt97qXmfmPnHAo/eDRl/vLRoGq8/29ap/8Byg0MNsc1AAA=\",\r\n"
							+ "            \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "            \"extendedProperties\": [\r\n"
							+ "                {\r\n"
							+ "                    \"name\": \"testing 222\",\r\n"
							+ "                    \"value\": null,\r\n"
							+ "                    \"id\": -1,\r\n"
							+ "                    \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
							+ "                    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                    \"extendedProperties\": [],\r\n"
							+ "                    \"entityState\": 3\r\n"
							+ "                }\r\n"
							+ "            ],\r\n"
							+ "            \"entityState\": 2\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "Final Grade posted successfully");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "Final Grade not posted");

			}

			/*String responseBodyAsString = res.getBody().asString();
						CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}


		//Test 21 - Post FA Disbursement
		@Test(priority=1)
		public void PostFADisbursement(StringHash data) throws Exception {

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = new Date();   
			String CurrentDate = formatter.format(date);

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
							+ "        \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
							+ "        \"TermId\": "+data.get("TermId")+",\r\n"
							+ "        \"StudentAcademicYearPaymentPeriodId\": 0,\r\n"
							+ "        \"TransactionDate\": \"2022/08/24 00:00:00\",\r\n"
							+ "        \"Description\": \""+data.get("Description")+"\",\r\n"
							+ "        \"Reference\": \"\",\r\n"
							+ "        \"IgnoreTermRequired\": false,\r\n"
							+ "        \"IsStudentPayment\": true,\r\n"
							+ "        \"AcademicYearSequence\": "+data.get("AcademicYearSequence")+",\r\n"
							+ "        \"PaymentMode\": "+data.get("PaymentMode")+",\r\n"
							+ "        \"FundSourceId\": "+data.get("FundSourceId")+",\r\n"
							+ "        \"ScheduledPaymentId\": "+data.get("ScheduledPaymentId")+",\r\n"
							+ "        \"PaymentType\": \""+data.get("PaymentType")+"\",\r\n"
							+ "        \"BankAccountId\": "+data.get("BankAccountId")+",\r\n"
							+ "        \"PaidByUserId\": 0,\r\n"
							+ "        \"StudentCreditCardId\": 0,\r\n"
							+ "        \"AuthorizationNumber\": \"\",\r\n"
							+ "        \"CheckNumber\": \"\",\r\n"
							+ "        \"CashDrawerId\": "+data.get("CashDrawerId")+",\r\n"
							+ "        \"CashDrawerSessionId\": "+data.get("CashDrawerSessionId")+",\r\n"
							+ "        \"CashierUserId\": "+data.get("CashierUserId")+",\r\n"
							+ "        \"ActualSource\": \""+data.get("ActualSource")+"\",\r\n"
							+ "        \"IsStudentCreditCardAuthorizeRequired\": false,\r\n"
							+ "        \"OpeningBalance\": \"\",\r\n"
							+ "        \"OverrideDisbursementAssociation\": false,\r\n"
							+ "        \"AwardYear\": \"\",\r\n"
							+ "        \"AgencyBranchId\": "+data.get("AgencyBranchId")+",\r\n"
							+ "        \"PayWithExistingCreditCard\": true,\r\n"
							+ "        \"IsSaveAndNew\": false,\r\n"
							+ "        \"BaseURI\": \"https://sisclientweb-900070.campusnexus.cloud/\",\r\n"
							+ "        \"AgencyCreditCardId\": 0,\r\n"
							+ "        \"IsApplyPayment\": false,\r\n"
							+ "        \"ClassSectionId\": null,\r\n"
							+ "        \"ExtendedProperties\": [],\r\n"
							+ "        \"StudentBankAccountId\": 0,\r\n"
							+ "        \"Drn\": null\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Transaction records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Transaction records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}

		//Test 22 - Post Refund - Directly to Ledger Card
		@Test(priority=1)
		public void PostRefund(StringHash data) throws Exception {

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = new Date();   
			String CurrentDate = formatter.format(date);

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
							+ "        \"TermId\": "+data.get("TermId")+",\r\n"
							+ "        \"CampusId\": "+data.get("CampusId")+",\r\n"
							+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
							+ "        \"PaidDisbursementId\": 0,\r\n"
							+ "        \"StudentAwardId\": "+data.get("StudentAwardId")+",\r\n"
							+ "        \"AcademicYearSequence\": "+data.get("AcademicYearSequence")+",\r\n"
							+ "        \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
							+ "        \"FundSourceId\": "+data.get("FundSourceId")+",\r\n"
							+ "        \"IsPostedToLedger\": true,\r\n"
							+ "        \"ReturnMethod\": \""+data.get("ReturnMethod")+"\",\r\n"
							+ "        \"BankAccountId\": "+data.get("BankAccountId")+",\r\n"
							+ "        \"AddressType\": \"\",\r\n"
							+ "        \"SyAddressId\": null,\r\n"
							+ "        \"StudentAcademicYearPaymentPeriodId\": null,\r\n"
							+ "        \"Description\": \""+data.get("Description")+"\",\r\n"
							+ "        \"TransactionDate\": \"2022/08/24 00:00:00\",\r\n"
							+ "        \"SentDate\": \"2022/08/24 00:00:00\",\r\n"
							+ "        \"Reference\": \"\",\r\n"
							+ "        \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
							+ "        \"StudentCreditCardId\": \"\",\r\n"
							+ "        \"StudentBankAccountId\": null,\r\n"
							+ "        \"CheckNumber\": \"\",\r\n"
							+ "        \"IsAwardAmountPostedAndScheduledOverride\": false,\r\n"
							+ "        \"IsAwardAmountOverride\": false,\r\n"
							+ "        \"IsReadytoSendFlagOverride\": false,\r\n"
							+ "        \"IsReadytoSend\": false,\r\n"
							+ "        \"IsPaidDisbursementAmountOverride\": false,\r\n"
							+ "        \"IgnoreTermRequired\": false,\r\n"
							+ "        \"IsReleasedToGreatPlain\": false,\r\n"
							+ "        \"IsSubsidiary\": false,\r\n"
							+ "        \"ApplyRefund\": false,\r\n"
							+ "        \"EditPayeeAfterSave\": false,\r\n"
							+ "        \"DisbursementAmountDistributionList\": null,\r\n"
							+ "        \"StudentAccountTransactionId\": \"\",\r\n"
							+ "        \"IsPreviousYear\": false,\r\n"
							+ "        \"ActualAcademicYearId\": "+data.get("ActualAcademicYearId")+"\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Transaction records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Transaction records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}
		//Test 23 - Program Change
		@Test(priority=1)
		public void ProgramChange(StringHash data) throws Exception {

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = new Date();   
			String CurrentDate = formatter.format(date);

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"IsChangeDateApplicable\": true,\r\n"
							+ "        \"IsDegreeProgramType\": false,\r\n"
							+ "        \"IsReEntryApplicable\": false,\r\n"
							+ "        \"ProgramVersionAreaOfStudyConfigList\": [],\r\n"
							+ "        \"IsOverriddeEnrollmentStatusCategory\": false,\r\n"
							+ "        \"IsBudgetApplicable\": false,\r\n"
							+ "        \"IsBillMethodChange\": false,\r\n"
							+ "        \"FaaNotificationStaffId\": 0,\r\n"
							+ "        \"FaaNotificationMessage\": \"\",\r\n"
							+ "        \"PreviousProgramVersionId\": 0,\r\n"
							+ "        \"PreviousStudentEnrollmentPeriodId\": 0,\r\n"
							+ "        \"LoaStart\": null,\r\n"
							+ "        \"LoaReturn\": null,\r\n"
							+ "        \"entity\": {\r\n"
							+ "            \"isExcludedCrmIntegration\": false,\r\n"
							+ "            \"statusColor\": \""+data.get("statusColor")+"            \",\r\n"
							+ "            \"systemStatusCategory\": \"E\",\r\n"
							+ "            \"registeredCreditHours\": 0,\r\n"
							+ "            \"registeredClockHours\": 0,\r\n"
							+ "            \"nsldsStatusName\": null,\r\n"
							+ "            \"isLastStatusTransfer\": false,\r\n"
							+ "            \"isTermAggregateRegisteredCredits\": false,\r\n"
							+ "            \"previousTransferStudentEnrollmentPeriodId\": null,\r\n"
							+ "            \"previousSchoolStatusId\": 0,\r\n"
							+ "            \"studentAdvisorList\": [],\r\n"
							+ "            \"academicAdvisor\": {\r\n"
							+ "                \"id\": 26572,\r\n"
							+ "                \"studentId\": 0,\r\n"
							+ "                \"staffGroupId\": 9,\r\n"
							+ "                \"studentEnrollmentPeriodId\": 61892,\r\n"
							+ "                \"advisorModule\": \"AD\",\r\n"
							+ "                \"createdDateTime\": \"2020/11/24 09:00:02\",\r\n"
							+ "                \"lastModifiedDateTime\": \"2022/08/19 07:52:52\",\r\n"
							+ "                \"lastModifiedUserId\": 3503,\r\n"
							+ "                \"rowVersion\": \"AAAAAAsoylc=\",\r\n"
							+ "                \"staffId\": 2,\r\n"
							+ "                \"originalState\": \"H4sIAAAAAAAEAL2TQWvDMAyF/0rJfXG63kIaKNsYYy0da1d2NbHcCmwryMqy7NcvzWC39jDwLkLw0PceSKpWzHrY2mcYDtp1sLVRGMNRh2E/tDD79C7EZXYSaUulYnMCr2PusWGKZCVvyKvbolioeaF2wKgdfmlBCmoCx+yHUOIvo+/7vF/kxMfz4Fy9b9a7CXuDIYoODWR1dSHOJNQ76QwEeQhMzvmxexmNyTyZSp3lapqcYRnQLTPhDjJVT9JF5DUvbe0jU9cmwSeBrswHRuINmc5BAv4dgxYw92PZo0/hsNZRxvho8d9s3iJwkm28Un8AjuNLpDrPv8ZW13+//gaXmVnvHAQAAA==\",\r\n"
							+ "                \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                \"extendedProperties\": [],\r\n"
							+ "                \"entityState\": 0\r\n"
							+ "            },\r\n"
							+ "            \"isBatchCatalogAssignment\": false,\r\n"
							+ "            \"isUpdateStudentEnrollmentPeriod\": false,\r\n"
							+ "            \"message\": null,\r\n"
							+ "            \"isDocumentDelete\": false,\r\n"
							+ "            \"id\": 61892,\r\n"
							+ "            \"academicAdvisorId\": 2,\r\n"
							+ "            \"accountReceivableBalance\": 0,\r\n"
							+ "            \"actualStartDate\": null,\r\n"
							+ "            \"admissionsRegionId\": null,\r\n"
							+ "            \"agencyBranchId\": null,\r\n"
							+ "            \"aosTransferDate\": null,\r\n"
							+ "            \"applicantProgress\": 0,\r\n"
							+ "            \"applicantTypeId\": null,\r\n"
							+ "            \"applicationReceivedDate\": \"2020/11/21 00:00:00\",\r\n"
							+ "            \"assignedAdmissionsRepId\": 2,\r\n"
							+ "            \"autoChargesTermId\": null,\r\n"
							+ "            \"billedDate\": null,\r\n"
							+ "            \"billingMethodId\": "+data.get("billingMethodId")+",\r\n"
							+ "            \"campusId\": 5,\r\n"
							+ "            \"catalogYearId\": "+data.get("catalogYearId")+",\r\n"
							+ "            \"clockHoursAttempted\": 44,\r\n"
							+ "            \"clockHoursEarned\": 44,\r\n"
							+ "            \"clockHoursRequired\": 0,\r\n"
							+ "            \"clockHoursScheduled\": 0,\r\n"
							+ "            \"coreCreditHoursAttempted\": null,\r\n"
							+ "            \"coreCreditHoursEarned\": null,\r\n"
							+ "            \"coreGpa\": null,\r\n"
							+ "            \"coreNumericAvg\": null,\r\n"
							+ "            \"createdDateTime\": \"2020/11/21 17:14:05\",\r\n"
							+ "            \"creditHoursAttempted\": 4,\r\n"
							+ "            \"creditHoursEarned\": 4,\r\n"
							+ "            \"creditHoursRequired\": "+data.get("creditHoursRequired")+",\r\n"
							+ "            \"creditHoursScheduled\": 0,\r\n"
							+ "            \"cumGpaPoints\": 4,\r\n"
							+ "            \"daysAbsent\": 0,\r\n"
							+ "            \"degreeAudit\": \"\",\r\n"
							+ "            \"dropDate\": null,\r\n"
							+ "            \"dropEarn\": 0,\r\n"
							+ "            \"dropType\": null,\r\n"
							+ "            \"enrollmentDate\": \"2020/11/21 00:00:00\",\r\n"
							+ "            \"enrollmentNumber\": \"00\",\r\n"
							+ "            \"enrollmentStatusId\": 1,\r\n"
							+ "            \"expectedCreditsHoursPerTerm\": 0,\r\n"
							+ "            \"expectedHoursPerWeekForExternship\": 0,\r\n"
							+ "            \"expectedRefundProcessDate\": null,\r\n"
							+ "            \"expectedStartDate\": \"2022-01-03T00:00:00\",\r\n"
							+ "            \"externshipBeginDate\": null,\r\n"
							+ "            \"faEntranceInterviewDate\": null,\r\n"
							+ "            \"faExitInterviewDate\": null,\r\n"
							+ "            \"financialAidCredits\": 0,\r\n"
							+ "            \"gpa\": 1,\r\n"
							+ "            \"gpaCreditHours\": 4,\r\n"
							+ "            \"gradeLevelId\": 2,\r\n"
							+ "            \"gradeScaleId\": "+data.get("gradeScaleId")+",\r\n"
							+ "            \"graduationDate\": \"2024-01-01T00:00:00\",\r\n"
							+ "            \"ipedsState\": \"OR\",\r\n"
							+ "            \"isApplicant\": false,\r\n"
							+ "            \"isAttendanceArchived\": false,\r\n"
							+ "            \"isIpedsTransfer\": false,\r\n"
							+ "            \"isReenrollment\": 0,\r\n"
							+ "            \"isTransfer\": false,\r\n"
							+ "            \"isUiUpdate\": false,\r\n"
							+ "            \"lastActivityDate\": null,\r\n"
							+ "            \"lastModifiedDateTime\": \"2022/08/19 07:52:53\",\r\n"
							+ "            \"lastModifiedUserId\": 3503,\r\n"
							+ "            \"lda\": null,\r\n"
							+ "            \"linkedSapStudentEnrollmentPeriodId\": 59342,\r\n"
							+ "            \"midpointDate\": \"2023-01-02T00:00:00\",\r\n"
							+ "            \"minutesAbsent\": 0,\r\n"
							+ "            \"minutesAttended\": 0,\r\n"
							+ "            \"minutesMakeUp\": 0,\r\n"
							+ "            \"note\": \"\",\r\n"
							+ "            \"nsldsWithdrawalDate\": null,\r\n"
							+ "            \"numericAverage\": 0,\r\n"
							+ "            \"originalAssignedAdmissionsRepId\": null,\r\n"
							+ "            \"originalExpectedStartDate\": \"2021/01/05 00:00:00\",\r\n"
							+ "            \"originalGraduationDate\": \"2024/06/17 00:00:00\",\r\n"
							+ "            \"outsideCourseWorkHours\": 0,\r\n"
							+ "            \"previousEducationId\": 0,\r\n"
							+ "            \"previousGradDate\": null,\r\n"
							+ "            \"programId\": "+data.get("programId")+",\r\n"
							+ "            \"programVersionId\": "+data.get("programVersionId")+",\r\n"
							+ "            \"programVersionName\": \""+data.get("programVersionName")+"\",\r\n"
							+ "            \"recalculateTermSequence\": true,\r\n"
							+ "            \"reenrollDate\": null,\r\n"
							+ "            \"reentryAfter180Date\": null,\r\n"
							+ "            \"rightsResponsibilitiesAck\": false,\r\n"
							+ "            \"rowVersion\": \"AAAAAAsoylk=\",\r\n"
							+ "            \"sapCheckpoint\": 0,\r\n"
							+ "            \"sapFlag\": \"\",\r\n"
							+ "            \"sapStatusId\": null,\r\n"
							+ "            \"schoolStatusChangeDate\": \"2020/11/21 17:14:06\",\r\n"
							+ "            \"schoolStatusChangeReasonId\": null,\r\n"
							+ "            \"schoolStatusId\": 5,\r\n"
							+ "            \"shiftId\": 2,\r\n"
							+ "            \"speProgression\": null,\r\n"
							+ "            \"startDateId\": "+data.get("startDateId")+",\r\n"
							+ "            \"startTermId\": 0,\r\n"
							+ "            \"statusChangeType\": 0,\r\n"
							+ "            \"studentId\": 4,\r\n"
							+ "            \"transcriptIssued\": null,\r\n"
							+ "            \"transferCreditHours\": 0,\r\n"
							+ "            \"transferInDate\": null,\r\n"
							+ "            \"student\": {\r\n"
							+ "                \"isExcludedCrmIntegration\": false,\r\n"
							+ "                \"addressTypeId\": 0,\r\n"
							+ "                \"studentInquiryRequired\": true,\r\n"
							+ "                \"extraCurricularsList\": [],\r\n"
							+ "                \"programsList\": [],\r\n"
							+ "                \"enrolledProgramIdList\": [],\r\n"
							+ "                \"ethnicitiesList\": [],\r\n"
							+ "                \"leadSourcesList\": [],\r\n"
							+ "                \"deleteVeteranDetails\": false,\r\n"
							+ "                \"vendors\": [],\r\n"
							+ "                \"studentAddressAssociation\": 0,\r\n"
							+ "                \"newAssignedAdmissionsRepId\": 0,\r\n"
							+ "                \"assignedAdmissionsRepReassignedDate\": \"0001/01/01 00:00:00\",\r\n"
							+ "                \"studentRelationshipAddress\": null,\r\n"
							+ "                \"lastFourSsn\": \"\",\r\n"
							+ "                \"customProperties\": {},\r\n"
							+ "                \"multiValueCustomProperties\": {},\r\n"
							+ "                \"originalCustomPropertiesValues\": null,\r\n"
							+ "                \"originalMultiValueCustomPropertiesValues\": null,\r\n"
							+ "                \"genderPronounList\": [],\r\n"
							+ "                \"overridePrevEducAltPellValidation\": false,\r\n"
							+ "                \"id\": 4,\r\n"
							+ "                \"acgEligReasonCode\": null,\r\n"
							+ "                \"agencyId\": 0,\r\n"
							+ "                \"alienNumber\": \"\",\r\n"
							+ "                \"arAccountStatus\": \"X\",\r\n"
							+ "                \"arBalance\": 200,\r\n"
							+ "                \"arNextTransactionNumber\": 42,\r\n"
							+ "                \"assignedAdmissionsRepId\": 2,\r\n"
							+ "                \"athleticIdentifier\": null,\r\n"
							+ "                \"bestTimeToContact\": \"Anytime\",\r\n"
							+ "                \"campusId\": 5,\r\n"
							+ "                \"citizenId\": 1,\r\n"
							+ "                \"city\": \"Timbertown               \",\r\n"
							+ "                \"collegeId\": null,\r\n"
							+ "                \"countryId\": 1,\r\n"
							+ "                \"countyId\": 3,\r\n"
							+ "                \"createdDateTime\": \"2019/12/18 05:50:05\",\r\n"
							+ "                \"cumulativeGpa\": 1,\r\n"
							+ "                \"cumulativeGpaPoints\": 4,\r\n"
							+ "                \"currencyCodeId\": null,\r\n"
							+ "                \"currentLda\": \"2020/08/27 00:00:00\",\r\n"
							+ "                \"dataBlockIndicator\": true,\r\n"
							+ "                \"dateOfBirth\": \"1939/01/01 00:00:00\",\r\n"
							+ "                \"dbiModifiedDate\": null,\r\n"
							+ "                \"defaultAddressCode\": null,\r\n"
							+ "                \"defaultMasterStudentAddressId\": null,\r\n"
							+ "                \"defaultStudentAddressId\": null,\r\n"
							+ "                \"disabled\": \"N\",\r\n"
							+ "                \"driverLicenseNumber\": \"\",\r\n"
							+ "                \"driverLicenseState\": \"\",\r\n"
							+ "                \"emailAddress\": \"xyz@campusmgmt.com\",\r\n"
							+ "                \"employabilityAboutInfo\": null,\r\n"
							+ "                \"employerId\": 0,\r\n"
							+ "                \"employmentStatusId\": 0,\r\n"
							+ "                \"externalStudentIdentifier\": null,\r\n"
							+ "                \"extraCurricularActivityId\": 0,\r\n"
							+ "                \"facebookUrl\": null,\r\n"
							+ "                \"faGradPlusCounselingDate\": null,\r\n"
							+ "                \"faRigorousHighSchoolProgramCodeId\": null,\r\n"
							+ "                \"firstName\": \"Timber                   \",\r\n"
							+ "                \"genderId\": 5,\r\n"
							+ "                \"gpaCredits\": 4,\r\n"
							+ "                \"hispanicLatino\": null,\r\n"
							+ "                \"hsAcademicGpa\": null,\r\n"
							+ "                \"instagramUrl\": null,\r\n"
							+ "                \"isActive\": true,\r\n"
							+ "                \"isAllowedBulkRegistrationByTrack\": null,\r\n"
							+ "                \"isBadAddress\": false,\r\n"
							+ "                \"isBadPhone\": false,\r\n"
							+ "                \"isDdVeteran\": false,\r\n"
							+ "                \"isEftDefaultForStipends\": false,\r\n"
							+ "                \"isInDistrict\": false,\r\n"
							+ "                \"isSscrError11Received\": false,\r\n"
							+ "                \"lastActivityDate\": \"2022/08/05 07:55:07\",\r\n"
							+ "                \"lastInterestDate\": null,\r\n"
							+ "                \"lastModifiedDateTime\": \"2022/08/19 07:52:50\",\r\n"
							+ "                \"lastModifiedUserId\": 3503,\r\n"
							+ "                \"lastName\": \"Wolf                     \",\r\n"
							+ "                \"lastNameFirstFour\": \"Wolf\",\r\n"
							+ "                \"lastStatementBeginDate\": null,\r\n"
							+ "                \"lastStatementCloseDate\": null,\r\n"
							+ "                \"lastStatementDate\": null,\r\n"
							+ "                \"leadDate\": \"2019/12/18 05:49:00\",\r\n"
							+ "                \"leadSourceId\": 680,\r\n"
							+ "                \"leadTypeId\": 0,\r\n"
							+ "                \"linkedInUrl\": null,\r\n"
							+ "                \"maidenName\": \"\",\r\n"
							+ "                \"maritalStatusId\": 0,\r\n"
							+ "                \"mi\": \"\",\r\n"
							+ "                \"middleName\": \"\",\r\n"
							+ "                \"mobilePhoneNumber\": \"(111)545-1211   \",\r\n"
							+ "                \"nationalityId\": 22,\r\n"
							+ "                \"nickName\": \"\",\r\n"
							+ "                \"niStudent\": false,\r\n"
							+ "                \"note\": \"\",\r\n"
							+ "                \"originalAssignedAdmissionsRepId\": null,\r\n"
							+ "                \"originalExpectedStartDate\": \"2020/09/23 00:00:00\",\r\n"
							+ "                \"originalStartDate\": \"2021/01/05 00:00:00\",\r\n"
							+ "                \"otherEmailAddress\": \"123@campusmgmt.com\",\r\n"
							+ "                \"otherPhoneNumber\": \"\",\r\n"
							+ "                \"personId\": 1097,\r\n"
							+ "                \"phoneNumber\": \"(541)278-5759\",\r\n"
							+ "                \"pin\": null,\r\n"
							+ "                \"postalCode\": \"97202\",\r\n"
							+ "                \"postalCodeFirstThree\": \"972\",\r\n"
							+ "                \"preferredContactType\": null,\r\n"
							+ "                \"preferredName\": null,\r\n"
							+ "                \"previousEducationGpa\": null,\r\n"
							+ "                \"previousEducationId\": 0,\r\n"
							+ "                \"programGroupId\": 0,\r\n"
							+ "                \"programId\": 66,\r\n"
							+ "                \"rawFirstName\": \"Timber\",\r\n"
							+ "                \"rawLastName\": \"Wolf\",\r\n"
							+ "                \"rawPhoneNumber\": \"5412785759\",\r\n"
							+ "                \"rowVersion\": \"AAAAAAsoygc=\",\r\n"
							+ "                \"schoolStatusId\": 13,\r\n"
							+ "                \"shiftId\": 2,\r\n"
							+ "                \"smsServiceProviderId\": null,\r\n"
							+ "                \"sourceSystem\": \"C\",\r\n"
							+ "                \"ssn\": \"                \",\r\n"
							+ "                \"startDate\": \"2021/01/05 00:00:00\",\r\n"
							+ "                \"state\": \"OR\",\r\n"
							+ "                \"statementComment\": \"\",\r\n"
							+ "                \"streetAddress\": \"TEST                                                                                                                                                                                                                                                           \",\r\n"
							+ "                \"streetAddress2\": null,\r\n"
							+ "                \"studentFullName\": null,\r\n"
							+ "                \"studentIdentifier\": null,\r\n"
							+ "                \"studentNumber\": \"0000005\",\r\n"
							+ "                \"subscribeToSms\": false,\r\n"
							+ "                \"suffix\": null,\r\n"
							+ "                \"suffixId\": null,\r\n"
							+ "                \"titleId\": 0,\r\n"
							+ "                \"twitterUrl\": null,\r\n"
							+ "                \"veteran\": \"N\",\r\n"
							+ "                \"workPhoneNumber\": \"\",\r\n"
							+ "                \"workPhoneNumberExtension\": \"\",\r\n"
							+ "                \"originalState\": \"H4sIAAAAAAAEAOVbbXPaOBD+K5l8un4AbBOXwCTMASUp04RkMNf2q5AX0FSWGEkOob/+ZAOdtsG5C1onvjkPk5cxaB9rtfs8uxIXPaXI5m7+CTafCU/hbq6NYmJBxGa6WcHJY8KFvjxdGrPqNBqaLiEhup4wqqSWc1OnMmkEntds+F4jAsUIZ9+JYVI08oH16XaEDvsxxnq9rq+bdakW2Qf9xtfbmygftsaENkRQOO1eFMDJb3RH8UUj+32Rv+WEdYy9dXlKOkyYvT3yz/ZOu2cXjXyIbj5eocFiJDdEmyuZqkiLAkjbD70EVeNoND26GHK2mADRUgxkDL9hEoxfnhqVgouNBQi6QfOA5+qBHmcgxmkyA1UFD6gepTIVJjLEpBoNUfer8zypPuFZcBVgioGyhPAXgbL/1z17uWMbw6OZKiI0oVnueN6fS6leGOaBM0Kt2UJA3IsTZv+UQk9ghRYE7vDMkoNhdBSDMGzOnswdRuT3QZspS2AqB1IY6yi81d0TG2NHdp2GAUlWqUZzS+iMhxn2HQQaIB8B0AbPa3Yx2Cg1ci1Ofr2cYUrOYQFP5g1jFQ+y7KzwCMzdJxkgPDxNZzwKiIH4g/0xzWPyMF3sbr+QL/x2zQ9q/vnUCzuh1/HcQyxNUm715gNcrwgitfk5sblT2y/47qX1ZpEoOAblGQr9DlKlLG/cxIUTeJyzA6/mndeC1tSzns5erkDtmiR9Lum3kYgZJUYWSYSZlByIeBHeLK8gALQ3+kyZJeZU+u1mu+b59oU3lTN2K+NMKuSRXkKi/QBzknLTi2MFWpdUjeyM3NoyDFRk0kz/7CyWwh47e69hiWky41BEC0fQ9dh5zSibxtQNoyA0VKbk+gVVVnYVUdZrghomhPHd8sDz4OPm+58017jJIslbL64uHSYrLjegqlPPbxElsC+hK4Ts0eYYQfgu+EuttawtRTJeZtTKB9WzVfEDQ1SJzpNxRa4Vie95qjP9qoHbN5REJFdkwhZSyVR/ZIulfQJL7vdKLhRJMlYpJfteMaXNmBTK36OrpZOnl6srrkHEiBHsLMmt0LU1RMwqqHQ/Mr0igtEbq8iFLGHdfNQ9SmJIGH1ajmCMP9J5Kihalm+le0e6T+Ln6e4YaHPCNQ62+6UUmJOGhOxD/BksqZCizYM3hDacm53YvZJWWbOVzTIV9O1IWKFsbxR2I98QW6SpGiolle9PgIIN26Ic/WYgs/2rvbg4QN+uDYAgawB44dRrdcKw47XqftDCgDwSNmpAm5IUR2bi5+oYvw+2nRm/nc9M0Am9uuc7d+5+hv2XRpQEzdBDAYcrqL5IPj8gp9wF1R5qLgKz3V1czBjw8jo3K5L6sGCixDD4YWjApYbXMFSWDSCHOl2I/eyzNkJfLoMZ2SVHn9Y1x0bv+3MUVNl/1ak/bwmz9TdqQjl+bd0SxUzWGKhWw+KWVWFuWBxzqIqj5IxxyIsB5P5l9w/f99+FZ6HNB76PQELj/BAV4Zhdn8D5oMGY0W8V8eWY7RpxVdPUY1mJFvSdYlYaEP7vjq5gUOze4vBxBdRAbPOhOkTnrtrZq3ntWtBE2wvb4y4Lr5/v3YV4eM0SVDk7DH7QRN5hyMGWkXGPX6f3oLREPJXjtZ2L2nIoKTzz3wWt81rYCtvOCNnvTSqMlHEvtRVOBzaHHR673bIx5/y4P4DlVeB0qQAXojNABXNQCuLdYbzsThkO2ps5wPpI4z8wmephnNJc8ZTTN39ipjoqfbeVda1kineiFAsVXhH63hXRhKxL25VDwFZOfwsBWCnUYpnFEgsGr0zk+rPlYxuSRTqeaHh/1rcCTW1edqg4v7TcLOilK8rtrjNyge/e8Y2WbG6qcww9SnQE6oFRsOnjgR3alcZI5tv+WLTRBhK8JT1wfnrE7wB1sXva/5XaBvcAV/duggIob4DLJCnuNrxm/RIZK0YNeu03HUbTg/sp/4/LfaH85JWgjLT3CufOdjaw5cL2LL3zyaIonWmq2Aym0lJN1fp+UTqfs8cynJIPXAqVTpnhFdrVef40zBELz/nM8xepvlWre/UbouxUqnhGPiNDazz/dfHu332+MHVPPgAA\",\r\n"
							+ "                \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                \"extendedProperties\": [],\r\n"
							+ "                \"entityState\": 3\r\n"
							+ "            },\r\n"
							+ "            \"originalState\": \"H4sIAAAAAAAEANWbbVPqOBSA/4rDd6DlRZRRZgp67zor6gBedz/G9gAZ0qQ3SUH2129SLLpidSHJtZdhBm0l52lyct5yPAs4R+vb6Z+w/oFICrdTITmmM0TXk3UCR08xoeK8Mpcy6dbrIpxDjEQtxiFngk1lLWRxveF5zbrv1cfAMSL4HyQxo/VsYFHZjNDF2zFWq1Vt1awxPtNf9Ot/Da/H2bBVTIVENIRK76wAJ7vRu4rO6vrzLPuTI9yV6tZ5BXUxlbk89Lm8Su/YPzltnNWzYXrZmIVCi2mCEEWgJiSIllgwbg3OAljIUipHEAJeokcCfUT09BbwRRDiGJG9GL2ap17moDJFZCwRlxdIvuWjmJxXJE+hUj9cQhRjIZRWihHM1MfOIlkRwsSEIyqmwF09RpIQHCIq7zibcRDCkqqZr2AOpi+5mdyNBG1ZNgoN0TuTvNVldWuCY9hvw3kNr+r71YY/8bxu9jaeF6V0MwrRa/1LSmQhUskGc8RnICbAYycL18eEvLtWtgZX14Yg5yyyNq8t03kdoDhJhTWetjmPRITN/gZkzz01O8ZUhIWLP1jKRSAlxImEIrZDXFOrVTPfvy+Il4jTMvON4GeKuVVCO879BVGPG6WkjIyMw0BNHpYfqqMNi/VG1LtqZUvO9wQ5GvkmjVWsHwbLmQsBHJS3yFyG9uGOXLzf6fqtrmduWz/XGyMzYUfBP9G4UhE6MGV+w5KheKEssTVLY7Xz75jy6EUJwtet8wVai+BRAJWlm7cLUDkVBKla4QK2zZf2QTvcCl5wljiKmvXQ2gyUbwUUmP7NwTNfUs4IiZXe/QZp4wuscrSPwK2pY88m21giaTHL8Y3JnhIIlffdGGmRWek74DqztazptkhzxAeAxTfGL58kcCrmOCkp7wimKY3uOAtBCEfGKZdVVA403auNqndS9dv29up20foww9TRrHxDl1RyXb29okreEsPKnaQnLJ1LwVQ9DEYkwPl+LZnO7yZPRgFo5h+tUL2KQUsX3X3nKIJrWAIpT5EzYxqHiOwWpg92VVag0qya7cDEtarecdXvWDNxVwlEQnv7ItADApHbkTGV2J46FGA9MkYA0b24pogIsIAmJdBI2+uAh3N9WlE+xmxZ8xOr8uGNALahZgFdSjfHK/213G+TmG+JEk/cPb5PouLN+mVk10jIIJR4ieXaUVihRQxZhKfYWf1wEz+eTrxOt93otpu1RtPGxOTU9wIsntG0PXO4yEUR+RrThYrxUTKWaaQ2+EtWqdIhbPEsr33abBl76yGOEl1Oc+Crm1WvY9NXDzFNJXxcYvvl7QE5VOYUS1gxfeYbogXcF+Xev3zSbpjFeOvwnXojSCQesJxHHK0QcWS4twdKwNHMfoeSuYrccqyye5Wv/q+ODhtTkkt0XRDxq5562yuI5Ny/VYpzm0qBIxjorBoeGF/Yzq9tlCTuOCwxS8VllG46oax5SWtoetEdmYis5w3tNikd+szHx+YPnRH9AC5sLkajY9xa81+yG1QYBR+QufeR+oEwfsSmRwGXonvUTwWmWTeiGfUIQkTClGibADwew88UivtVD8ljtAqaU27yUkdqroeXfB1MJXD/xHMlBc/mUrkukSgPhh8xwRKrAC1clC1pHLHVsxYXkSEBx62+8jh8vRdekL0EW5PFuSmlSmQGcwgXWZZQumKFovtG0NtWna8IJrOE791TQxtKrfCUmm4EDOaIzsDhWe9z/5CxE9mFHgESjlrUXwsrT3vqeI6nsjwHBuME8v76XbNjZRXySN7egcTpibmV0FTvtoEfvBLmIdbrfaGvliXefS5blaflPCtHhxwn8kqI1ElLaV7xdnMAaaeSkzNeGRzE1z/+l7jev3YUkeYzNwAA\",\r\n"
							+ "            \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "            \"extendedProperties\": [\r\n"
							+ "                {\r\n"
							+ "                    \"name\": \"Program Designator\",\r\n"
							+ "                    \"value\": null,\r\n"
							+ "                    \"id\": -1,\r\n"
							+ "                    \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
							+ "                    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                    \"extendedProperties\": [],\r\n"
							+ "                    \"entityState\": 3\r\n"
							+ "                },\r\n"
							+ "                {\r\n"
							+ "                    \"name\": \"A Graduation Ceremony Participation\",\r\n"
							+ "                    \"value\": null,\r\n"
							+ "                    \"id\": -1,\r\n"
							+ "                    \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
							+ "                    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                    \"extendedProperties\": [],\r\n"
							+ "                    \"entityState\": 3\r\n"
							+ "                },\r\n"
							+ "                {\r\n"
							+ "                    \"name\": \"B Graduation Ceremony Gown size\",\r\n"
							+ "                    \"value\": null,\r\n"
							+ "                    \"id\": -1,\r\n"
							+ "                    \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
							+ "                    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                    \"extendedProperties\": [],\r\n"
							+ "                    \"entityState\": 3\r\n"
							+ "                },\r\n"
							+ "                {\r\n"
							+ "                    \"name\": \"C Graduation Ceremony Cap Size\",\r\n"
							+ "                    \"value\": null,\r\n"
							+ "                    \"id\": -1,\r\n"
							+ "                    \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
							+ "                    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                    \"extendedProperties\": [],\r\n"
							+ "                    \"entityState\": 3\r\n"
							+ "                },\r\n"
							+ "                {\r\n"
							+ "                    \"name\": \"D Graduation Ceremony additional Regalia\",\r\n"
							+ "                    \"value\": null,\r\n"
							+ "                    \"id\": -1,\r\n"
							+ "                    \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
							+ "                    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                    \"extendedProperties\": [],\r\n"
							+ "                    \"entityState\": 3\r\n"
							+ "                }\r\n"
							+ "            ],\r\n"
							+ "            \"entityState\": 2,\r\n"
							+ "            \"ProgramVersionAreaOfStudyConfigList\": null\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Transaction records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Transaction records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}		
		//Test 24 - Academic Year Creation
		@Test(priority=1)
		public void AcademicYear(StringHash data) throws Exception {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"studentAwardPellId\": "+data.get("studentAwardPellId")+",\r\n"
							+ "        \"originationStatus\": null,\r\n"
							+ "        \"financialAidAdvisorId\": "+data.get("financialAidAdvisorId")+",\r\n"
							+ "        \"financialAidStaffGroupId\": "+data.get("financialAidStaffGroupId")+",\r\n"
							+ "        \"isAcademicYearDateReview\": false,\r\n"
							+ "        \"dependencyStatus\": \""+data.get("dependencyStatus")+"\",\r\n"
							+ "        \"sendChangesToCod\": false,\r\n"
							+ "        \"isUserAllowedToApproveDirectLoan\": false,\r\n"
							+ "        \"proceedAfterDatesModifiedValidation\": false,\r\n"
							+ "        \"isProceedAfterDatesModifiedValidation\": false,\r\n"
							+ "        \"proceedAfterCalculateCreditValidation\": false,\r\n"
							+ "        \"isProceedAfterCalculateCreditValidation\": false,\r\n"
							+ "        \"remainingCredits\": null,\r\n"
							+ "        \"remainingWeeks\": null,\r\n"
							+ "        \"proceedAfterCalculateHoursValidation\": false,\r\n"
							+ "        \"isProceedAfterCalculateHoursValidation\": false,\r\n"
							+ "        \"proceedAfterCreditDefinitiontValidation\": false,\r\n"
							+ "        \"isProceedAfterCreditDefinitiontValidation\": false,\r\n"
							+ "        \"proceedAfterHoursDefinitiontValidation\": false,\r\n"
							+ "        \"isProceedAfterHoursDefinitiontValidation\": false,\r\n"
							+ "        \"proceedAfterMoreCreditsValidation\": false,\r\n"
							+ "        \"isProceedAfterMoreCreditsValidation\": false,\r\n"
							+ "        \"proceedAfterMoreHoursValidation\": false,\r\n"
							+ "        \"isProceedAfterMoreHoursValidation\": false,\r\n"
							+ "        \"canProceedToSave\": false,\r\n"
							+ "        \"isDdVeteran\": false,\r\n"
							+ "        \"rightsResponsibilitiesAck\": false,\r\n"
							+ "        \"faGradPlusCounselingDate\": null,\r\n"
							+ "        \"faEntranceInterviewDate\": null,\r\n"
							+ "        \"savePackageMethodOrTermToPackage\": false,\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"academicYearId\": "+data.get("academicYearId")+",\r\n"
							+ "        \"acYrNote\": \"\",\r\n"
							+ "        \"autoAwardConfigurationId\": null,\r\n"
							+ "        \"autoAwardEnrollmentStatusId\": null,\r\n"
							+ "        \"autoAwardEvaluationType\": \"\",\r\n"
							+ "        \"autoAwardInitialCalculationDate\": null,\r\n"
							+ "        \"autoAwardRepackageCalculationDate\": null,\r\n"
							+ "        \"autoAwardRequestProcess\": \"\",\r\n"
							+ "        \"awardNoticePrintedDate\": null,\r\n"
							+ "        \"awardNoticeSigned\": null,\r\n"
							+ "        \"billedDate\": null,\r\n"
							+ "        \"booksSupplies\": "+data.get("booksSupplies")+",\r\n"
							+ "        \"budgetId\": "+data.get("budgetId")+",\r\n"
							+ "        \"budgetRecordIdentifier\": null,\r\n"
							+ "        \"costOfAttendance\": "+data.get("costOfAttendance")+",\r\n"
							+ "        \"counselingCompleteDate\": null,\r\n"
							+ "        \"counselingType\": \"\",\r\n"
							+ "        \"createdDateTime\": \"0001/01/01 00:00:00\",\r\n"
							+ "        \"creditHoursExpectedToComplete\": "+data.get("creditHoursExpectedToComplete")+",\r\n"
							+ "        \"creditHoursInAcademicYear\": "+data.get("creditHoursInAcademicYear")+",\r\n"
							+ "        \"endDate\": \""+data.get("endDate")+"\",\r\n"
							+ "        \"faAdvisorId\": null,\r\n"
							+ "        \"firstAwardYear\": \""+data.get("firstAwardYear")+"\",\r\n"
							+ "        \"gradeLevelId\": "+data.get("gradeLevelId")+",\r\n"
							+ "        \"housingStatusCode\": \""+data.get("housingStatusCode")+"\",\r\n"
							+ "        \"hppaLevel\": \""+data.get("hppaLevel")+"\",\r\n"
							+ "        \"institutionalCharges\": "+data.get("institutionalCharges")+",\r\n"
							+ "        \"isAutoAwardBudgetLock\": false,\r\n"
							+ "        \"isAutoAwardPackageLock\": false,\r\n"
							+ "        \"isBankFeesLocked\": false,\r\n"
							+ "        \"isBooksSuppliesInstitutional\": true,\r\n"
							+ "        \"isBooksSuppliesLocked\": false,\r\n"
							+ "        \"isEndDateExcluded\": false,\r\n"
							+ "        \"isExcludedFromMtf\": false,\r\n"
							+ "        \"isFirstTimeBorrower\": false,\r\n"
							+ "        \"isHybridDates\": false,\r\n"
							+ "        \"isOther10Locked\": false,\r\n"
							+ "        \"isOther11Locked\": false,\r\n"
							+ "        \"isOther1Locked\": false,\r\n"
							+ "        \"isOther2Locked\": false,\r\n"
							+ "        \"isOther3Locked\": false,\r\n"
							+ "        \"isOther4Locked\": false,\r\n"
							+ "        \"isOther5Locked\": false,\r\n"
							+ "        \"isOther6Locked\": false,\r\n"
							+ "        \"isOther7Locked\": false,\r\n"
							+ "        \"isOther8Locked\": false,\r\n"
							+ "        \"isOther9Locked\": false,\r\n"
							+ "        \"isOtherCostInstitutional10\": false,\r\n"
							+ "        \"isOtherCostInstitutional11\": false,\r\n"
							+ "        \"isOtherCostInstitutional9\": false,\r\n"
							+ "        \"isOtherCostInstitutionalCharge1\": true,\r\n"
							+ "        \"isOtherCostInstitutionalCharge2\": false,\r\n"
							+ "        \"isOtherCostInstitutionalCharge3\": false,\r\n"
							+ "        \"isOtherCostInstitutionalCharge4\": false,\r\n"
							+ "        \"isOtherCostInstitutionalCharge5\": false,\r\n"
							+ "        \"isOtherCostInstitutionalCharge6\": false,\r\n"
							+ "        \"isOtherCostInstitutionalCharge7\": false,\r\n"
							+ "        \"isOtherCostInstitutionalCharge8\": false,\r\n"
							+ "        \"isPackageRevised\": false,\r\n"
							+ "        \"isProrateDlAllowed\": false,\r\n"
							+ "        \"isReentryAcademicYear\": false,\r\n"
							+ "        \"isRoomBoardInstitutional\": false,\r\n"
							+ "        \"isRoomBoardLocked\": false,\r\n"
							+ "        \"isStartDateExcluded\": false,\r\n"
							+ "        \"isSummerPackagingExcluded\": false,\r\n"
							+ "        \"isTravelInstitutional\": false,\r\n"
							+ "        \"isTravelLocked\": false,\r\n"
							+ "        \"isTuitionLocked\": false,\r\n"
							+ "        \"isUnsubEligibilityUpToHeal\": false,\r\n"
							+ "        \"isUnsupportedDependent\": false,\r\n"
							+ "        \"iwinAy\": "+data.get("iwinAy")+",\r\n"
							+ "        \"iwMonths\": "+data.get("iwMonths")+",\r\n"
							+ "        \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "        \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
							+ "        \"lenderFees\": "+data.get("lenderFees")+",\r\n"
							+ "        \"monthsIncademicYear\": "+data.get("monthsIncademicYear")+",\r\n"
							+ "        \"note\": \"\",\r\n"
							+ "        \"otherCostAmount1\": 164,\r\n"
							+ "        \"otherCostAmount10\": 0,\r\n"
							+ "        \"otherCostAmount11\": 0,\r\n"
							+ "        \"otherCostAmount2\": 0,\r\n"
							+ "        \"otherCostAmount3\": 0,\r\n"
							+ "        \"otherCostAmount4\": 0,\r\n"
							+ "        \"otherCostAmount5\": 0,\r\n"
							+ "        \"otherCostAmount6\": 0,\r\n"
							+ "        \"otherCostAmount7\": 0,\r\n"
							+ "        \"otherCostAmount8\": 0,\r\n"
							+ "        \"otherCostAmount9\": 0,\r\n"
							+ "        \"otherCostDescription1\": \"Tech Fee\",\r\n"
							+ "        \"otherCostDescription10\": null,\r\n"
							+ "        \"otherCostDescription11\": null,\r\n"
							+ "        \"otherCostDescription2\": null,\r\n"
							+ "        \"otherCostDescription3\": null,\r\n"
							+ "        \"otherCostDescription4\": null,\r\n"
							+ "        \"otherCostDescription5\": null,\r\n"
							+ "        \"otherCostDescription6\": null,\r\n"
							+ "        \"otherCostDescription7\": null,\r\n"
							+ "        \"otherCostDescription8\": null,\r\n"
							+ "        \"otherCostDescription9\": null,\r\n"
							+ "        \"packageDate\": \""+currentDate+"\",\r\n"
							+ "        \"packagedToEnrollmentStatusId\": 0,\r\n"
							+ "        \"packagingMethodId\": "+data.get("packagingMethodId")+",\r\n"
							+ "        \"packagingStatusId\": "+data.get("packagingStatusId")+",\r\n"
							+ "        \"pellCostOfAttendance\": null,\r\n"
							+ "        \"plusCreditDecisionStatus\": null,\r\n"
							+ "        \"programVersionAcademicYearId\": "+data.get("programVersionAcademicYearId")+",\r\n"
							+ "        \"programVersionPellCoaDetailId\": null,\r\n"
							+ "        \"refCreditHoursInAcademicYear\": null,\r\n"
							+ "        \"refWeeksInAcademicYear\": null,\r\n"
							+ "        \"revisedAwardNoticePrinted\": null,\r\n"
							+ "        \"revisedAwardNoticeSigned\": null,\r\n"
							+ "        \"roomBoard\": "+data.get("roomBoard")+",\r\n"
							+ "        \"rowVersion\": null,\r\n"
							+ "        \"secondAwardYear\": \"\",\r\n"
							+ "        \"secondAwardYearPackagingStatusId\": null,\r\n"
							+ "        \"sequence\": "+data.get("sequence")+",\r\n"
							+ "        \"startDate\": \""+data.get("startDate")+"\",\r\n"
							+ "        \"studentEnrollmentPeriodId\": "+data.get("studentEnrollmentPeriodId")+",\r\n"
							+ "        \"teachCounselingDate\": null,\r\n"
							+ "        \"termsToPackageDirectLoan\": \"X\",\r\n"
							+ "        \"travel\": "+data.get("travel")+",\r\n"
							+ "        \"tuition\": "+data.get("tuition")+",\r\n"
							+ "        \"weeksEnrolledInAcademicYear\": "+data.get("weeksEnrolledInAcademicYear")+",\r\n"
							+ "        \"weeksInAcademicYear\": "+data.get("weeksInAcademicYear")+",\r\n"
							+ "        \"weeksNonEnrollment\": "+data.get("weeksNonEnrollment")+",\r\n"
							+ "        \"comments\": [],\r\n"
							+ "        \"originalState\": \"H4sIAAAAAAAEAL2ZX1PiMBTFv4rD+1LQ/esgM4C4MAvi0Oquj7G9QIY26d6kVvbTb1IUtTv6sDOnrw09vyb33pyb0Bswi91i9YN2NyItaLEylqVaC7WLdjkdPWSpMmetjbX5aRCYeEOZMO1MxqyNXtl2rLPguNM5CbqdICSWIpV/hJVaBZWwae0VTuVBoyzLdnnS1rz2L3aDX/NZWMl+kMpYoWJq9XtvfE410F/YDfFIG3tOJmaZe1y3F/ihXvXWkTxVMj1rWS6oFfSroTfl3uZMzVDrrQmLPE8lman7PGkLTxMpBLfUOhtqwQkeFbG4pxTPOcTqFWq0EbwmTMzeIx43TjxpnPixceKnxomfGyd+aZz4tUHitwZZ3U6TMMQeExXSqwOUX/kNQP9gMIhVqRwFIDwjlRBfEGRFDmkzyHShLCJdagiEB9UQCNOpIRAuU0MgbKWGQPhIDYEwjhoC4RQ1BMIg6qWH8IU6A1HfXn6xGljr9il/fEHY27/tAWIzHBbJmuwU4Q4Q0UEsEnJn0VsSDALc8qW2iJAOCqsHpbPi8b37TXVk9oNI0pJ+F2TsFeuYDCJ/Rq7GDKXuMWgqU3OYzD5XZzreYjlXIt6KNcFAY5WcC0vjhzgtEoKUnrmQbGwkMxpqZl0SQyiT3R3LajKI3Jqax0gs6V4a0EItiZTl3ct9BcIJrWALD3tYZBnxftncKJR1rUxxN07lWt7JVNrddR7pCYEulTwszzVbSs4p98cDZRGgcq6V3UCyuZRqsAMIg9zqsfZ8yuLUk0iPFes0zVw8XYnYwkBc/VARc7IbnUAYEXFmIv20bpIpdmYlEJcGM2HsXCdyJSm5NoTphCa6MO7ZPiojnSDSILSFr+TnHLgilqD4uCZozSK7ITau84I3kpM8FzPC3I8c0hlYMt/ZLVA1AYh86DtTzNGp6n2qTg7k5iHFWiVQwlO3ANB+bD/B25JH+P4TgNlb9FRhW7afRFsHATeGFWW//VHSDO1Sq+f9FnEkZEqkde7B+OV7wRo/5M5wfUcx0lme0v9mePD+3+P9v0VVHxM/HwAA\",\r\n"
							+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "        \"extendedProperties\": [],\r\n"
							+ "        \"entityState\": 0\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Academic Year records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Academic Year records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
				CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}			

		//Test 24 - Fund Source Award Creation
		@Test(priority=1)
		public void FundSource(StringHash data) throws Exception {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);

			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "    \"payload\": {\r\n"
							+ "        \"updatePellOriginationStatus\": false,\r\n"
							+ "        \"updateCodGrantOriginationStatus\": false,\r\n"
							+ "        \"pellHasDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "        \"codGrantHasDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "        \"continuePellDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "        \"continueCodGrantDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "        \"scheduledlDisbursements\": [\r\n"
							+ "            {\r\n"
							+ "                \"academicYearSequence\": "+data.get("academicYearSequence")+",\r\n"
							+ "                \"paymentPeriodSequence\": null,\r\n"
							+ "                \"loanPaymentPeriodSequence\": null,\r\n"
							+ "                \"termCode\": null,\r\n"
							+ "                \"termStartDate\": null,\r\n"
							+ "                \"courseCode\": null,\r\n"
							+ "                \"disbursementPercentage\": 0,\r\n"
							+ "                \"isAuditDisbursement\": false,\r\n"
							+ "                \"balance\": 0,\r\n"
							+ "                \"isUsePaymentPeriod\": false,\r\n"
							+ "                \"isUseLoanPeriod\": false,\r\n"
							+ "                \"studentLoanPeriodId\": null,\r\n"
							+ "                \"fundSource\": null,\r\n"
							+ "                \"studentName\": null,\r\n"
							+ "                \"fundSourceType\": null,\r\n"
							+ "                \"isTitle4\": false,\r\n"
							+ "                \"studentEnrollmentPeriodId\": 0,\r\n"
							+ "                \"isContinueForDateWithinLoanPaymentPeriod\": false,\r\n"
							+ "                \"isContinueForDateWithinPaymentPeriod\": false,\r\n"
							+ "                \"isContinueForDisbursementWithinPaymentPeriod\": false,\r\n"
							+ "                \"courseDescription\": null,\r\n"
							+ "                \"id\": 0,\r\n"
							+ "                \"actualDisbursementDate\": null,\r\n"
							+ "                \"auditString\": null,\r\n"
							+ "                \"clockHours\": null,\r\n"
							+ "                \"commonLineDisbReleaseCode\": null,\r\n"
							+ "                \"commonLineStatus\": null,\r\n"
							+ "                \"createdDateTime\": \"0001/01/01 00:00:00\",\r\n"
							+ "                \"createdUserId\": 0,\r\n"
							+ "                \"directLoanDisbPercentage\": null,\r\n"
							+ "                \"directLoanDisbStatus\": null,\r\n"
							+ "                \"disbursementEligibilityStageId\": null,\r\n"
							+ "                \"disbursementNumber\": null,\r\n"
							+ "                \"eligibilityCheckDate\": null,\r\n"
							+ "                \"eligibilityStatus\": 0,\r\n"
							+ "                \"enrollmentStatus\": null,\r\n"
							+ "                \"faExportImportFileId\": null,\r\n"
							+ "                \"fulltimeAwardAmount\": 0,\r\n"
							+ "                \"grossAmount\": 0,\r\n"
							+ "                \"interestAmount\": 0,\r\n"
							+ "                \"interestRebateAmount\": null,\r\n"
							+ "                \"isPaymentPlan\": null,\r\n"
							+ "                \"isSpeUpdate\": null,\r\n"
							+ "                \"lastModifiedDateTime\": \"0001/01/01 00:00:00\",\r\n"
							+ "                \"lastModifiedUserId\": 0,\r\n"
							+ "                \"lenderFee\": 0,\r\n"
							+ "                \"netAmount\": "+data.get("netAmount")+",\r\n"
							+ "                \"overrideDisbursementDate\": null,\r\n"
							+ "                \"paidDisbursementId\": null,\r\n"
							+ "                \"paymentPeriodBeginDate\": null,\r\n"
							+ "                \"paymentPeriodId\": null,\r\n"
							+ "                \"paymentPeriodNumber\": null,\r\n"
							+ "                \"pellGrantDisbStatus\": null,\r\n"
							+ "                \"previousStatus\": null,\r\n"
							+ "                \"principalAmount\": "+data.get("principalAmount")+",\r\n"
							+ "                \"rowVersion\": null,\r\n"
							+ "                \"scheduledDate\": \""+data.get("scheduledDate")+"\",\r\n"
							+ "                \"status\": \""+data.get("status")+"\",\r\n"
							+ "                \"studentAcademicYearId\": "+data.get("studentAcademicYearId")+",\r\n"
							+ "                \"studentAcademicYearLoanPaymentPeriodId\": null,\r\n"
							+ "                \"studentAcademicYearPaymentPeriodId\": null,\r\n"
							+ "                \"studentAwardId\": "+data.get("studentAwardId")+",\r\n"
							+ "                \"studentCourseId\": null,\r\n"
							+ "                \"studentId\": 0,\r\n"
							+ "                \"termId\": "+data.get("termId")+",\r\n"
							+ "                \"thirdPartyInvoiceNumber\": null,\r\n"
							+ "                \"unroundedGrossAmount\": 0,\r\n"
							+ "                \"originalState\": \"H4sIAAAAAAAEALWSTWvDMAyG/0rxfVG63kIaCOxS9tFBxtiOwlFagy0HWybLfv1SD3ZrLyM3oVd6XkmobkPA+Tg80vyONtFxiBIMn5Dnt3mkzZezHPfqLDJWAFGfyWEsnNHBRz9Iob2D+7LcwbaEjoJBa75RjGfI4Kh+CZX5Y0zTVEy7wofTpXELH89PXcbeGY6CrEk19ZVxstB0gpJiDZe4zmUbU7GxeyUhkYImS1f7b4CXOfpkqX9AoTX4knpiaTX2tJzwkzAc+hV8Xkha5xPLCuzXJaPNiHY1hwMLBYr/WgFuv3XzA2LWgN/3AgAA\",\r\n"
							+ "                \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "                \"extendedProperties\": [],\r\n"
							+ "                \"entityState\": 0,\r\n"
							+ "                \"Id\": 0\r\n"
							+ "            }\r\n"
							+ "        ],\r\n"
							+ "        \"specialDisbursementEntity\": null,\r\n"
							+ "        \"nonTitleIvPaymentPeriods\": null,\r\n"
							+ "        \"paidDisbursements\": null,\r\n"
							+ "        \"refunds\": null,\r\n"
							+ "        \"studentAwardLoanEntity\": null,\r\n"
							+ "        \"studentAwardPellEntity\": null,\r\n"
							+ "        \"studentAcademicYears\": null,\r\n"
							+ "        \"costOfAttendance\": "+data.get("costOfAttendance")+",\r\n"
							+ "        \"efc\": \"0.00\",\r\n"
							+ "        \"needBasedAmountPackaged\": 0,\r\n"
							+ "        \"nonNeedBasedAmountPackaged\": "+data.get("nonNeedBasedAmountPackaged")+",\r\n"
							+ "        \"needBasedGrossAmount\": \"0.00\",\r\n"
							+ "        \"nonNeedBasedGrossAmount\": \"0.00\",\r\n"
							+ "        \"isLimitPackagingToCoa\": false,\r\n"
							+ "        \"isRecalculatedEfc\": false,\r\n"
							+ "        \"studentAcademicYearSequence\": "+data.get("studentAcademicYearSequence")+",\r\n"
							+ "        \"campusId\": "+data.get("campusId")+",\r\n"
							+ "        \"isScheduledAmountMisMatchWithDisbursementAmount\": false,\r\n"
							+ "        \"continueScheduledAmountMisMatchWithDisbursementAmount\": false,\r\n"
							+ "        \"preventAwardingWhenAuthorizationNotExpended\": false,\r\n"
							+ "        \"continueAwardingWhenAuthorizationNotExpended\": false,\r\n"
							+ "        \"glAuthorizationId\": 0,\r\n"
							+ "        \"isPreventSaveForGrant\": false,\r\n"
							+ "        \"isStateAdd\": false,\r\n"
							+ "        \"recalculateCashPlan\": false,\r\n"
							+ "        \"updateAmountPackagedWithPrincipal\": false,\r\n"
							+ "        \"isAdjustPackageInEditMode\": false,\r\n"
							+ "        \"adjustPackagedAmountMessage\": null,\r\n"
							+ "        \"paymentAmountSplit\": 0,\r\n"
							+ "        \"isPaymentAmountSplitBasedOnNoOfPayments\": true,\r\n"
							+ "        \"allowOriginationChanged\": false,\r\n"
							+ "        \"isAllowOriginationChanged\": false,\r\n"
							+ "        \"isOriginationStatusReadyToSend\": false,\r\n"
							+ "        \"originationStatusReadyToSend\": false,\r\n"
							+ "        \"grossAmount\": "+data.get("grossAmount")+",\r\n"
							+ "        \"originalGrossAmount\": "+data.get("originalGrossAmount")+",\r\n"
							+ "        \"isAddlEligibilityIndicator\": false,\r\n"
							+ "        \"resetGrossAmount\": false,\r\n"
							+ "        \"lessGrossAmount\": false,\r\n"
							+ "        \"isGrossAmountExeed\": false,\r\n"
							+ "        \"grossAmountExeed\": false,\r\n"
							+ "        \"isCampusAutoUpdatePellOriginationStatus\": false,\r\n"
							+ "        \"isAllowInformtionNotChange\": false,\r\n"
							+ "        \"isAllowInformtionChange\": false,\r\n"
							+ "        \"allowInformtionChange\": false,\r\n"
							+ "        \"isAllowAdvisor\": false,\r\n"
							+ "        \"allowAdvisor\": false,\r\n"
							+ "        \"isCommitLevelAmountChange\": false,\r\n"
							+ "        \"commitLevelAmountChange\": false,\r\n"
							+ "        \"isPreventPackaging\": false,\r\n"
							+ "        \"refundedGrossAmount\": 0,\r\n"
							+ "        \"netAmount\": "+data.get("netAmount")+",\r\n"
							+ "        \"isStudentLoanNetAmountNotEqualToDisbursementNetAmount\": false,\r\n"
							+ "        \"continueStudentLoanNetAmountNotEqualToDisbursementNetAmount\": false,\r\n"
							+ "        \"isStudentLoanPaidDisbursementBankFeeMoreThanLoanBankFee\": false,\r\n"
							+ "        \"continueStudentLoanPaidDisbursementBankFeeMoreThanLoanBankFee\": false,\r\n"
							+ "        \"isStudentLoanPaidDisbursementBankFeeLessThanLoanBankFee\": false,\r\n"
							+ "        \"continueStudentLoanPaidDisbursementBankFeeLessThanLoanBankFee\": false,\r\n"
							+ "        \"isAddBankFeeToCostOfAttendance\": false,\r\n"
							+ "        \"isAddBankFeeToCostOfAttendanceUserConfirmationIsYes\": false,\r\n"
							+ "        \"continueAfterConfirmationForAddBankFeeToCostOfAttendance\": false,\r\n"
							+ "        \"isStudentLoanReadyToSendValidationExists\": false,\r\n"
							+ "        \"isStudentLoanPaidDisbursementExists\": false,\r\n"
							+ "        \"disbursedAmount\": 0,\r\n"
							+ "        \"refundedAmount\": 0,\r\n"
							+ "        \"expectedAmount\": 0,\r\n"
							+ "        \"totalNetAmount\": 0,\r\n"
							+ "        \"originalAmountPackaged\": 0,\r\n"
							+ "        \"readyToSendValidationMessages\": null,\r\n"
							+ "        \"isUsePaymentPeriod\": false,\r\n"
							+ "        \"isSaveNonTitleIvPaymentPeriods\": false,\r\n"
							+ "        \"firstReferenceAddress\": null,\r\n"
							+ "        \"secondReferenceAddress\": null,\r\n"
							+ "        \"studentAwardLoanChangeEntity\": null,\r\n"
							+ "        \"isLoanDetailsChanged\": false,\r\n"
							+ "        \"isUseBorrowerSsn\": false,\r\n"
							+ "        \"isDirectLoanReCalculate\": false,\r\n"
							+ "        \"directLoanReCalculate\": false,\r\n"
							+ "        \"isEarlyDisbursementRulesFsaHandbook\": false,\r\n"
							+ "        \"earlyDisbursementRulesFsaHandbook\": false,\r\n"
							+ "        \"isDisbursmentAmountMissMatch\": false,\r\n"
							+ "        \"disbursmentAmountMissMatch\": false,\r\n"
							+ "        \"isAllowApprove\": false,\r\n"
							+ "        \"allowApprove\": false,\r\n"
							+ "        \"isMaxLimit\": false,\r\n"
							+ "        \"maxLimit\": false,\r\n"
							+ "        \"isAdjustLoanEndDate\": false,\r\n"
							+ "        \"adjustLoanEndDate\": false,\r\n"
							+ "        \"progVerTermAssocExist\": false,\r\n"
							+ "        \"isProgVerTermAssocExist\": false,\r\n"
							+ "        \"countDisburseMentAmount\": 0,\r\n"
							+ "        \"codGrantOrigination\": null,\r\n"
							+ "        \"codGrantDisbursements\": null,\r\n"
							+ "        \"isMultipleTeachGrant\": false,\r\n"
							+ "        \"isSavingAwardInCanceledStatusCodGrant\": false,\r\n"
							+ "        \"continueSavingAwardInCanceledStatusCodGrant\": false,\r\n"
							+ "        \"isChangingOriginationStatusCodGrant\": false,\r\n"
							+ "        \"isChangingOriginationStatusCodGrantCanceledByUser\": false,\r\n"
							+ "        \"continueChangingOriginationStatusCodGrant\": false,\r\n"
							+ "        \"isCodGrantAmountPackagedGreaterThanOriginationAmountAllowed\": false,\r\n"
							+ "        \"isCodGrantAmountPackagedGreaterThanOriginationAmount\": false,\r\n"
							+ "        \"continueSaveTeacherExpertIndicator\": false,\r\n"
							+ "        \"isTeacherExpertIndicator\": false,\r\n"
							+ "        \"isNonTitleIvPaymentPeriodCreated\": false,\r\n"
							+ "        \"isCodGrantIsirOnFile\": false,\r\n"
							+ "        \"isCodGrantTotalDisbAmtNotEqualToAwardAmount\": false,\r\n"
							+ "        \"continueCodGrantTotalDisbAmtNotEqualToAwardAmount\": false,\r\n"
							+ "        \"isGrossAmontExceeded\": false,\r\n"
							+ "        \"continueGrossAmontExceeded\": false,\r\n"
							+ "        \"isCodGrantChangesToGradeLevel\": false,\r\n"
							+ "        \"continueCodGrantChangesToGradeLevel\": false,\r\n"
							+ "        \"isCampusAutoUpdateOriginationStatusCodGrant\": false,\r\n"
							+ "        \"graduateStudentsNoLongerEligible\": false,\r\n"
							+ "        \"isGraduateStudentsNoLongerEligible\": false,\r\n"
							+ "        \"isirMustFileBeforeLoan\": false,\r\n"
							+ "        \"isIsirMustFileBeforeLoan\": false,\r\n"
							+ "        \"isRequiredField\": false,\r\n"
							+ "        \"requiredField\": false,\r\n"
							+ "        \"isValidateSpecialProgramIsN\": false,\r\n"
							+ "        \"validateSpecialProgramIsN\": false,\r\n"
							+ "        \"isValidateSpecialProgramIsNotABNPT\": false,\r\n"
							+ "        \"validateSpecialProgramIsNotABNPT\": false,\r\n"
							+ "        \"isValidateSpecialProgramIsNotABN\": false,\r\n"
							+ "        \"validateSpecialProgramIsNotABN\": false,\r\n"
							+ "        \"isValidateSpecialProgramIsNotABUN\": false,\r\n"
							+ "        \"validateSpecialProgramIsNotABUN\": false,\r\n"
							+ "        \"isAllowOriginationWithEstAward\": false,\r\n"
							+ "        \"allowOriginationWithEstAward\": false,\r\n"
							+ "        \"isMaxLimitForSubDirSub\": false,\r\n"
							+ "        \"maxLimitForSubDirSub\": false,\r\n"
							+ "        \"nonTitleIvAcademicYearPamentPeriodList\": null,\r\n"
							+ "        \"remainingNeed\": null,\r\n"
							+ "        \"addAgencyToStudentAgency\": false,\r\n"
							+ "        \"isAdjustPackagedAmountHasNotPreventAwardWarningMessage\": false,\r\n"
							+ "        \"continueAdjustPackagedAmountHasNotPreventAwardWarningMessage\": false,\r\n"
							+ "        \"adjustPackagedAmountNotPreventAwardWarningMessage\": null,\r\n"
							+ "        \"isLoanBeginDateChanged\": false,\r\n"
							+ "        \"isLoanEndDateChanged\": false,\r\n"
							+ "        \"originalLoanPeriodBeginDate\": \"0001/01/01 00:00:00\",\r\n"
							+ "        \"originalLoanPeriodEndDate\": \"0001/01/01 00:00:00\",\r\n"
							+ "        \"isPellExists\": false,\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"accruedInterestAmount\": 0,\r\n"
							+ "        \"agencyBranchId\": 0,\r\n"
							+ "        \"amountCanceled\": 0,\r\n"
							+ "        \"amountDisbursed\": 0,\r\n"
							+ "        \"amountPackaged\": "+data.get("amountPackaged")+",\r\n"
							+ "        \"amountRefunded\": 0,\r\n"
							+ "        \"applicationReceivedDate\": null,\r\n"
							+ "        \"applicationSentDate\": null,\r\n"
							+ "        \"awardLevelAmount\": 0,\r\n"
							+ "        \"awardYear\": \""+data.get("awardYear")+"\",\r\n"
							+ "        \"batchPackagingProcessId\": null,\r\n"
							+ "        \"calculationDate\": null,\r\n"
							+ "        \"codGrantOriginationId\": null,\r\n"
							+ "        \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "        \"creditCardEffectiveDate\": null,\r\n"
							+ "        \"downPaymentAmount\": null,\r\n"
							+ "        \"effectiveDate\": null,\r\n"
							+ "        \"emailNotification\": null,\r\n"
							+ "        \"faLenderId\": null,\r\n"
							+ "        \"firstPaymentDate\": \""+data.get("firstPaymentDate")+"\",\r\n"
							+ "        \"fundSourceId\": "+data.get("fundSourceId")+",\r\n"
							+ "        \"guarantorLendingInstitutionId\": null,\r\n"
							+ "        \"interestBalance\": 0,\r\n"
							+ "        \"interestOnlyUntilDate\": null,\r\n"
							+ "        \"interestRate\": \""+data.get("interestRate")+"\",\r\n"
							+ "        \"interestRebateAmount\": "+data.get("interestRebateAmount")+",\r\n"
							+ "        \"isAutoCredit\": false,\r\n"
							+ "        \"isAutoDraft\": false,\r\n"
							+ "        \"isAxLinkedFws\": false,\r\n"
							+ "        \"isBankFeeIncludedInCoa\": false,\r\n"
							+ "        \"isCoaRecalculated\": null,\r\n"
							+ "        \"isEstimatedAward\": false,\r\n"
							+ "        \"isLocked\": false,\r\n"
							+ "        \"isReAllocated\": false,\r\n"
							+ "        \"isT4BalanceEvaluated\": false,\r\n"
							+ "        \"lastInterestDate\": null,\r\n"
							+ "        \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "        \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
							+ "        \"lastPromNotePrintDate\": null,\r\n"
							+ "        \"lastStatementPrintDate\": null,\r\n"
							+ "        \"lenderFee\": "+data.get("lenderFee")+",\r\n"
							+ "        \"loanAcademicYearEndDate\": null,\r\n"
							+ "        \"loanAcademicYearStartDate\": null,\r\n"
							+ "        \"loanIdentificationNumber\": null,\r\n"
							+ "        \"loanPeriodBeginDate\": null,\r\n"
							+ "        \"loanPeriodEndDate\": null,\r\n"
							+ "        \"lockedByUserId\": null,\r\n"
							+ "        \"nextPaymentDate\": \""+data.get("nextPaymentDate")+"\",\r\n"
							+ "        \"note\": null,\r\n"
							+ "        \"numberPayments\": \""+data.get("numberPayments")+"\",\r\n"
							+ "        \"paymentAmount\": "+data.get("paymentAmount")+",\r\n"
							+ "        \"paymentDay\": "+data.get("paymentDay")+",\r\n"
							+ "        \"paymentFrequency\": -1,\r\n"
							+ "        \"paymentPlanId\": null,\r\n"
							+ "        \"paymentPlanTermId\": null,\r\n"
							+ "        \"principalBalance\": "+data.get("principalBalance")+",\r\n"
							+ "        \"promNoteDocumentId\": null,\r\n"
							+ "        \"rep9010CollectionRate\": null,\r\n"
							+ "        \"rep9010DiscountRate\": null,\r\n"
							+ "        \"rep9010NumberOfYears\": null,\r\n"
							+ "        \"rowVersion\": null,\r\n"
							+ "        \"secondaryInterestRate\": \"\",\r\n"
							+ "        \"secondaryInterestRateEffectiveDate\": null,\r\n"
							+ "        \"servicerLendingInstitutionId\": null,\r\n"
							+ "        \"servicerRecordIdentifier\": null,\r\n"
							+ "        \"source\": \""+data.get("source")+"\",\r\n"
							+ "        \"status\": \""+data.get("status")+"\",\r\n"
							+ "        \"studentAcademicYearId\": "+data.get("studentAcademicYearId")+",\r\n"
							+ "        \"studentAwardNonTitleIvRuleId\": null,\r\n"
							+ "        \"studentAwardPellId\": null,\r\n"
							+ "        \"studentBankAccountId\": null,\r\n"
							+ "        \"studentCreditCardId\": null,\r\n"
							+ "        \"studentEnrollmentPeriodId\": "+data.get("studentEnrollmentPeriodId")+",\r\n"
							+ "        \"studentId\": "+data.get("studentId")+",\r\n"
							+ "        \"studentLoanPeriodId\": null,\r\n"
							+ "        \"studentRelationshipAddressId\": 0,\r\n"
							+ "        \"totalAmountPaid\": "+data.get("totalAmountPaid")+",\r\n"
							+ "        \"webAlertNotification\": null,\r\n"
							+ "        \"loanDetail\": [],\r\n"
							+ "        \"originalState\": \"H4sIAAAAAAAEANWY32+bMBDH/5WK9wQD+VFQEom0yRQtVasmm7bHK74kVowd2aY0++trSLansS2FdewNYfvuw9fnuzOjWCk43m8+4vEz8AzvN9ooJrYgjuvjAa9eUi702NkZc4hcVyc7TEF3U5YoqeXGdBOZuj4hgesRd4WKAWffwDAp3NKwdk4WIvbDRp7n3TzoSrUtFnrul7vlqjTbYUIbEAk6k1EFTjkwWYI2d5KyDUP6SaNa0JFbvB+VS65YZOzUsQMRE+a7f/i9f2cS9Ekwcksrk9JkJcOfwd2CwTVLsQKPnocvYvSJ73dI2CHemgwjEkYk6PaJNwx7QYf0IkLqfkBjana8uig3Cq1E/6eMZ/bpsdEIrb+7Os6MtHCUmQqmJyk5griIawNcYzNstwo2bUR7WTKxRzrPdfvgpiD2c8SFSHhGkS7EjYT2Uc60YWlxKOIcVNWJ+Id8S5nYDW4f1yPGnMukUK59cOveFHhRtWfPdlYbGVfGnglhHpGXjYnesUNMqUKt25OWyxPxFUFVAJ2WXF7h/Nr9zFm9xqQKB8PaTHEqM2EeINnDtjLeKCY22/CL4DxSv/DPM0FXMlMJNqaZT64b2sY4AYq2ey9CrTE8Lwj969rN3sqAyapq6xviP25IsplQkvPUPj3Y+42kjcnWD3uDQUOQSwmiAk8wPnaMytBx3+zlQwYKhJFqiYLawYW9qTGTFen0r/ibQ+HoJ31zE8btNfWZJfhe37IQBm2xsfXnyVbHU+pqMGXVzlcnpW33+M5Q7q//PExeAW+64amaEAAA\",\r\n"
							+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "        \"extendedProperties\": [],\r\n"
							+ "        \"entityState\": 0\r\n"
							+ "    }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");

			int StatusCode = res.getStatusCode();

			String Statusline = res.getStatusLine();

			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);

			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());

			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);

			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Fund Source records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Fund Source records Not Saved successfully");

			}

			/*String responseBodyAsString = res.getBody().asString();
	CustomAsserts.assertString(responseBodyAsString.contains(data.get("id").toString()));*/
		}	




		@Test(priority=1)
		public String AddTasksToAStudent_API(StringHash data) throws IOException
		{	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isRequestFromMessage\": false,\r\n"
							+ "    \"taskStatusCode\": null,\r\n"
							+ "    \"crmSuppressFlag\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"assignedToStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"attachments\": null,\r\n"
							+ "    \"attachmentsId\": null,\r\n"
							+ "    \"classSectionId\": null,\r\n"
							+ "    \"completedByStaffId\": 0,\r\n"
							+ "    \"createdByStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"emailSubject\": null,\r\n"
							+ "    \"employerContactId\": null,\r\n"
							+ "    \"employerId\": null,\r\n"
							+ "    \"employerJobId\": null,\r\n"
							+ "    \"isActivityNotViewed\": false,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"lockedByUserId\": null,\r\n"
							+ "    \"note\": \"\",\r\n"
							+ "    \"organizationContactId\": null,\r\n"
							+ "    \"organizationId\": null,\r\n"
							+ "    \"previouslyAssignedToStaffId\": null,\r\n"
							+ "    \"priority\": \""+data.get("Priority")+"\",\r\n"
							+ "    \"prospectInquiryId\": null,\r\n"
							+ "    \"reassignedDate\": null,\r\n"
							+ "    \"remindDate\": null,\r\n"
							+ "    \"resultText\": \"\",\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"sessionSyCampusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"sourceRecordId\": 0,\r\n"
							+ "    \"sourceSystem\": \"X\",\r\n"
							+ "    \"sourceTable\": \"\",\r\n"
							+ "    \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentID")+",\r\n"
							+ "    \"studentId\": "+data.get("StudentID")+",\r\n"
							+ "    \"subject\": \""+data.get("TaskTemplate")+"\",\r\n"
							+ "    \"taskDueDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskEndDate\": null,\r\n"
							+ "    \"taskResultId\": 0,\r\n"
							+ "    \"taskStartDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusId\": "+data.get("TaskStatusID")+",\r\n"
							+ "    \"taskTemplateId\": "+data.get("TaskTemplateID")+",\r\n"
							+ "    \"taskTypeId\": "+data.get("TaskTypeID")+",\r\n"
							+ "    \"templateTextFile\": \"\",\r\n"
							+ "    \"workflowInstanceIdentifier\": null,\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEALVVTUvDQBD9K5K72dbeShqoFkFsrTRRvK7JpB3cj7IzIV1/vUkq3iqCzHWHfe/tezOz2TIEHbfNI8RXbVrYNsQB3V67WMYjXJ2scbRIDszHuVJUHcBqSi1WwZNvOK28VTeTyUxNJ6qAgNrgp2b0To3AlJwR5viD0XVd2s1SH/bDxal626yLEfYaHbF2FSR5dkHOWMjXmnjja2wQ6heC8FBnajjPxitXOHdoFgmHFhKVj6WLWH8jWWmGEi0I0IhovwvQK5aU/eRZArbwbaigiMRgJXzx9migd+Y2FqybRsT8UtPHDqg1LAMP/RuGYOHE92gkUjirHwjEIt5B5UMtYtCZoNTvIt48B/QBOQo1zqqFYWqF0Pum55bECURiXRLh3kFdernR/d6b/9wO6vcvNf8CjMk0+3MHAAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String taskID = path.getString("payload.data.id");	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Task iD "+taskID);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Task Template is successfully added to Student");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Task Template is not added to Student");
			}

			return taskID;
		}

		@Test(priority=2)
		public void ConfirmPendingTasksToAStudent_API(StringHash data) throws IOException
		{	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.when().contentType(ContentType.JSON)
					.get(""+data.get("EndPointURL")+"/ds/campusnexus/Tasks/CampusNexus.GetCurrentTasksForStudents(studentId="+data.get("StudentID")+",studentEnrollmentPeriodId="+data.get("StudentEnrollmentID")+",prospectInquiryId=0)?%24format=json&%24top=50&%24orderby=TaskDueDate%20desc&%24count=true");

			int code = res.getStatusCode();
			String responseBodyAsString = res.getBody().asString();
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Status Code is successfully validated");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Wrong status code is displayed");
			}

			if(responseBodyAsString.contains(data.get("TaskTemplate").toString()) && responseBodyAsString.contains(data.get("TaskStatusName").toString())) {
				TestReportsLog.log(LogStatus.PASS, "Pending Tasks exists for student");	
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "Pending Tasks does not exist for student");
			}

			// CustomAsserts.assertString(responseBodyAsString.contains(data.get("TaskTemplate").toString()));
			//	CustomAsserts.assertString(responseBodyAsString.contains(data.get("TaskStatusName").toString()));

		}


		@Test(priority=3)
		public void ConfirmPendingTasksForStaff_API(StringHash data) throws IOException
		{	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.when().contentType(ContentType.JSON)
					.get(""+data.get("EndPointURL")+"/ds/campusnexus/Tasks/CampusNexus.GetCurrentTasksForStudents(studentId="+data.get("StudentID")+",studentEnrollmentPeriodId="+data.get("StudentEnrollmentID")+",prospectInquiryId=0)?%24format=json&%24top=50&%24orderby=TaskDueDate%20desc&%24count=true");

			int code = res.getStatusCode();
			String responseBodyAsString = res.getBody().asString();
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Status Code is successfully validated");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Wrong status code is displayed");
			}

			if(responseBodyAsString.contains(data.get("TaskTemplate").toString()) && responseBodyAsString.contains(data.get("TaskStatusName").toString())) {
				TestReportsLog.log(LogStatus.PASS, "Pending Tasks exists for student");	
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "Pending Tasks does not exist for student");
			}

			// CustomAsserts.assertString(responseBodyAsString.contains(data.get("TaskTemplate").toString()));
			//	CustomAsserts.assertString(responseBodyAsString.contains(data.get("TaskStatusName").toString()));

		}


		@Test(priority=1)
		public String EditPendingTasksByStudent_API(StringHash data) throws IOException
		{	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isRequestFromMessage\": false,\r\n"
							+ "    \"taskStatusCode\": null,\r\n"
							+ "    \"crmSuppressFlag\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"assignedToStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"attachments\": null,\r\n"
							+ "    \"attachmentsId\": null,\r\n"
							+ "    \"classSectionId\": null,\r\n"
							+ "    \"completedByStaffId\": 0,\r\n"
							+ "    \"createdByStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"emailSubject\": null,\r\n"
							+ "    \"employerContactId\": null,\r\n"
							+ "    \"employerId\": null,\r\n"
							+ "    \"employerJobId\": null,\r\n"
							+ "    \"isActivityNotViewed\": false,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"lockedByUserId\": null,\r\n"
							+ "    \"note\": \"\",\r\n"
							+ "    \"organizationContactId\": null,\r\n"
							+ "    \"organizationId\": null,\r\n"
							+ "    \"previouslyAssignedToStaffId\": null,\r\n"
							+ "    \"priority\": \""+data.get("Priority")+"\",\r\n"
							+ "    \"prospectInquiryId\": null,\r\n"
							+ "    \"reassignedDate\": null,\r\n"
							+ "    \"remindDate\": null,\r\n"
							+ "    \"resultText\": \"\",\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"sessionSyCampusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"sourceRecordId\": 0,\r\n"
							+ "    \"sourceSystem\": \"X\",\r\n"
							+ "    \"sourceTable\": \"\",\r\n"
							+ "    \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentID")+",\r\n"
							+ "    \"studentId\": "+data.get("StudentID")+",\r\n"
							+ "    \"subject\": \""+data.get("TaskTemplate")+"\",\r\n"
							+ "    \"taskDueDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskEndDate\": null,\r\n"
							+ "    \"taskResultId\": 0,\r\n"
							+ "    \"taskStartDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusId\": "+data.get("TaskStatusID")+",\r\n"
							+ "    \"taskTemplateId\": "+data.get("TaskTemplateID")+",\r\n"
							+ "    \"taskTypeId\": "+data.get("TaskTypeID")+",\r\n"
							+ "    \"templateTextFile\": \"\",\r\n"
							+ "    \"workflowInstanceIdentifier\": null,\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEALVVTUvDQBD9K5K72dbeShqoFkFsrTRRvK7JpB3cj7IzIV1/vUkq3iqCzHWHfe/tezOz2TIEHbfNI8RXbVrYNsQB3V67WMYjXJ2scbRIDszHuVJUHcBqSi1WwZNvOK28VTeTyUxNJ6qAgNrgp2b0To3AlJwR5viD0XVd2s1SH/bDxal626yLEfYaHbF2FSR5dkHOWMjXmnjja2wQ6heC8FBnajjPxitXOHdoFgmHFhKVj6WLWH8jWWmGEi0I0IhovwvQK5aU/eRZArbwbaigiMRgJXzx9migd+Y2FqybRsT8UtPHDqg1LAMP/RuGYOHE92gkUjirHwjEIt5B5UMtYtCZoNTvIt48B/QBOQo1zqqFYWqF0Pum55bECURiXRLh3kFdernR/d6b/9wO6vcvNf8CjMk0+3MHAAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String taskID = path.getString("payload.data.id");	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Task iD "+taskID);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Task Template is successfully edited by Student");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Task Template is not edited by Student");
			}

			return taskID;
		}



		@Test(priority=5)
		public void GetPendingTasksByStudent_API(StringHash data) throws IOException
		{	

			APIAutomationPage sTest = new APIAutomationPage();
			//String id = sTest.taskID;
			//String taskID = sTest.AddTasksToAStudent_API(data);
			wait(15);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.when().contentType(ContentType.JSON)
					.get("https://sisclientweb-900070.campusnexus.cloud/ds/campusnexus/Tasks/CampusNexus.GetCurrentTasks(studentId=18712,enrollmentId=0,inquiryId=0)?$select=Id&$expand=TaskTemplate($select=Id;$expand=TaskType($select=Code))&$filter=Id%20eq%20106003");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			//TestReportsLog.log(LogStatus.INFO, "Task iD "+taskID);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Task Template is successfully added to Student");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Task Template is not added to Student");
			}

			//  return taskID;

		}

		@Test(priority=1)
		public String EditPendingTasksByStaff_API(StringHash data) throws IOException
		{	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isRequestFromMessage\": false,\r\n"
							+ "    \"taskStatusCode\": null,\r\n"
							+ "    \"crmSuppressFlag\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"assignedToStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"attachments\": null,\r\n"
							+ "    \"attachmentsId\": null,\r\n"
							+ "    \"classSectionId\": null,\r\n"
							+ "    \"completedByStaffId\": 0,\r\n"
							+ "    \"createdByStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"emailSubject\": null,\r\n"
							+ "    \"employerContactId\": null,\r\n"
							+ "    \"employerId\": null,\r\n"
							+ "    \"employerJobId\": null,\r\n"
							+ "    \"isActivityNotViewed\": false,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"lockedByUserId\": null,\r\n"
							+ "    \"note\": \"\",\r\n"
							+ "    \"organizationContactId\": null,\r\n"
							+ "    \"organizationId\": null,\r\n"
							+ "    \"previouslyAssignedToStaffId\": null,\r\n"
							+ "    \"priority\": \""+data.get("Priority")+"\",\r\n"
							+ "    \"prospectInquiryId\": null,\r\n"
							+ "    \"reassignedDate\": null,\r\n"
							+ "    \"remindDate\": null,\r\n"
							+ "    \"resultText\": \"\",\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"sessionSyCampusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"sourceRecordId\": 0,\r\n"
							+ "    \"sourceSystem\": \"X\",\r\n"
							+ "    \"sourceTable\": \"\",\r\n"
							+ "    \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentID")+",\r\n"
							+ "    \"studentId\": "+data.get("StudentID")+",\r\n"
							+ "    \"subject\": \""+data.get("TaskTemplate")+"\",\r\n"
							+ "    \"taskDueDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskEndDate\": null,\r\n"
							+ "    \"taskResultId\": 0,\r\n"
							+ "    \"taskStartDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusId\": "+data.get("TaskStatusID")+",\r\n"
							+ "    \"taskTemplateId\": "+data.get("TaskTemplateID")+",\r\n"
							+ "    \"taskTypeId\": "+data.get("TaskTypeID")+",\r\n"
							+ "    \"templateTextFile\": \"\",\r\n"
							+ "    \"workflowInstanceIdentifier\": null,\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEALVVTUvDQBD9K5K72dbeShqoFkFsrTRRvK7JpB3cj7IzIV1/vUkq3iqCzHWHfe/tezOz2TIEHbfNI8RXbVrYNsQB3V67WMYjXJ2scbRIDszHuVJUHcBqSi1WwZNvOK28VTeTyUxNJ6qAgNrgp2b0To3AlJwR5viD0XVd2s1SH/bDxal626yLEfYaHbF2FSR5dkHOWMjXmnjja2wQ6heC8FBnajjPxitXOHdoFgmHFhKVj6WLWH8jWWmGEi0I0IhovwvQK5aU/eRZArbwbaigiMRgJXzx9migd+Y2FqybRsT8UtPHDqg1LAMP/RuGYOHE92gkUjirHwjEIt5B5UMtYtCZoNTvIt48B/QBOQo1zqqFYWqF0Pum55bECURiXRLh3kFdernR/d6b/9wO6vcvNf8CjMk0+3MHAAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String taskID = path.getString("payload.data.id");	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Task iD "+taskID);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Task Template is successfully edited by Staff");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Task Template is not edited by Staff");
			}

			return taskID;
		}


		@Test(priority=4)
		public void ReleaseToGeneralLedger_API(StringHash data) throws IOException
		{	
			APIAutomationPage sTest = new APIAutomationPage();
			sTest.CreateGeneralLedger_API(data);
			wait(15);
			String BatchNumber = sTest.GetGeneralLedger_API(data);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"batchType\": \"Cmc.Nexus.StudentAccounts.Jobs.PostGeneralLedgerBatch, Cmc.Nexus.StudentAccounts\",\r\n"
							+ "    \"parameters\": {\r\n"
							+ "      \"batchName\": \"Release to General Ledger - "+currentDate+" PM\",\r\n"
							+ "      \"params\": {\r\n"
							+ "        \"IsNewBatch\": true,\r\n"
							+ "        \"StaffId\": "+data.get("StaffID")+",\r\n"
							+ "        \"CampusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "        \"BatchNumber\": \""+BatchNumber+"\",\r\n"
							+ "        \"BatchId\": -1,\r\n"
							+ "        \"CampusGroupId\": "+data.get("CampusGroupID")+",\r\n"
							+ "        \"LowDate\": \""+data.get("StartDate")+" 00:00:00\",\r\n"
							+ "        \"HighDate\": \""+data.get("EndDate")+" 00:00:00\",\r\n"
							+ "        \"CampusGroupName\": \""+data.get("Campus")+"\",\r\n"
							+ "        \"CampusName\": null,\r\n"
							+ "        \"GLCompanyNumber\": null\r\n"
							+ "      }\r\n"
							+ "    },\r\n"
							+ "    \"description\": \"Release to General Ledger - "+currentDate+" PM\",\r\n"
							+ "    \"notificationOption\": \"Always\",\r\n"
							+ "    \"submitAsync\": true\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL1")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Release to General ledger batch is successfully posted");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Release to General Ledger batch is failed");
			}

		}


		@Test(priority=4)
		public void CreateGeneralLedger_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"batchType\": \"Cmc.Nexus.StudentAccounts.Jobs.CreateGeneralLedgerBatch, Cmc.Nexus.StudentAccounts\",\r\n"
							+ "    \"parameters\": {\r\n"
							+ "      \"batchName\": \"Generate GL Batch - "+currentDate+" PM\",\r\n"
							+ "      \"params\": {\r\n"
							+ "        \"IsNewBatch\": true,\r\n"
							+ "        \"StaffId\": "+data.get("StaffID")+",\r\n"
							+ "        \"CampusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "        \"BatchNumber\": \"\",\r\n"
							+ "        \"BatchId\": 0,\r\n"
							+ "        \"CampusGroupId\": "+data.get("CampusGroupID")+",\r\n"
							+ "        \"LowDate\": \""+data.get("StartDate")+"\",\r\n"
							+ "        \"HighDate\": \""+data.get("EndDate")+"\",\r\n"
							+ "        \"GLCompanyNumber\": \"\",\r\n"
							+ "        \"CampusName\": \"\",\r\n"
							+ "        \"CampusGroupName\": \""+data.get("Campus")+"\"\r\n"
							+ "      }\r\n"
							+ "    },\r\n"
							+ "    \"description\": \"Generate GL Batch - "+currentDate+" PM\",\r\n"
							+ "    \"notificationOption\": \"Always\",\r\n"
							+ "    \"submitAsync\": true\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL1")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Release to General ledger batch is successfully Created");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Release to General Ledger batch is not Created");
			}

		}


		@Test(priority=4)
		public String GetGeneralLedger_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.when().contentType(ContentType.JSON)
					.get(""+data.get("EndPointURL2")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String batchNum = path.getString("value.BatchNo[1]");
			//int oDataCountID=Integer.parseInt(oDataCount);
			//String batchNum = path.getString("value.BatchNo[oDataCountID-1]");	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Batch Num is "+batchNum);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Release to General ledger batch num is fetched successfully");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Release to General Ledger batch is not fetched");
			}
			return batchNum;
		}



		@Test(priority=4)
		public void PerformRevenueRecognition_API(StringHash data) throws IOException
		{	
			APIAutomationPage sTest = new APIAutomationPage();
			sTest.CreateRevenueRecognitionBatch_API(data);
			wait(10);
			String BatchNum = sTest.GetRevenueRecognitionBatch_API(data);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"batchType\": \"Cmc.Nexus.StudentAccounts.Jobs.PostRevenueBatch, Cmc.Nexus.StudentAccounts\",\r\n"
							+ "    \"parameters\": {\r\n"
							+ "      \"batchName\": \"Revenue Batch - Queue Batch  "+currentDate+" PM\",\r\n"
							+ "      \"batchId\": 0,\r\n"
							+ "      \"params\": {\r\n"
							+ "        \"OpenBatchList\": [\r\n"
							+ "          {\r\n"
							+ "            \"ReferenceNumber\": \""+BatchNum+"\",\r\n"
							+ "            \"UserId\": "+data.get("StaffID")+",\r\n"
							+ "            \"EndDate\": \""+data.get("EndDate")+" 00:04:00\",\r\n"
							+ "            \"CampusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "            \"BatchAmount\": -1\r\n"
							+ "          }\r\n"
							+ "        ]\r\n"
							+ "      }\r\n"
							+ "    },\r\n"
							+ "    \"description\": \"Revenue Batch - Queue Batch  "+currentDate+" PM\",\r\n"
							+ "    \"notificationOption\": \"Always\"\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL1")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Perform Revenue Recognition is successfully posted");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Perform Revenue Recognition is failed");
			}
		}

		@Test(priority=4)
		public void CreateRevenueRecognitionBatch_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"batchType\": \"Cmc.Nexus.StudentAccounts.Jobs.CalculateRevenue, Cmc.Nexus.StudentAccounts\",\r\n"
							+ "    \"parameters\": {\r\n"
							+ "      \"batchName\": \"Revenue Recognition Batch\",\r\n"
							+ "      \"batchId\": 0,\r\n"
							+ "      \"params\": \"{\\\"RevenueRecognitionCalculateList\\\":[{\\\"CampusId\\\":"+data.get("SessionSyCampusID")+",\\\"StartDate\\\":\\\""+data.get("StartDate")+" 00:04:00\\\",\\\"EndDate\\\":\\\""+data.get("EndDate")+" 00:04:00\\\"}]}\"\r\n"
							+ "    },\r\n"
							+ "    \"description\": \"Revenue Recognition Batch\",\r\n"
							+ "    \"notificationOption\": \"Always\",\r\n"
							+ "    \"submitAsync\": true\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)			
					.post(""+data.get("EndPointURL1")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Perform Revenue Recognition batch is successfully created");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Perform Revenue Recognition is failed");
			}
		}


		@Test(priority=4)
		public String GetRevenueRecognitionBatch_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.when().contentType(ContentType.JSON)			
					.get(""+data.get("EndPointURL2")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String batchNumText = path.getString("value.ReferenceNumber");
			String batchNum=batchNumText.substring(1, batchNumText.length()-1);
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Batch Num is "+batchNum);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Perform Revenue Recognition batch num is successfully fetched");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Perform Revenue Recognition batch num is not fetched");
			}
			return batchNum;
		}


		@Test(priority=4)
		public String AddNewEmployers_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"campusIdList\": [\r\n"
							+ "      "+data.get("SessionSyCampusID")+"\r\n"
							+ "    ],\r\n"
							+ "    \"locationIdList\": [],\r\n"
							+ "    \"softSkillIdList\": null,\r\n"
							+ "    \"careerFieldsIdList\": null,\r\n"
							+ "    \"createdByUserName\": null,\r\n"
							+ "    \"employerGroupIdList\": null,\r\n"
							+ "    \"isExcludedCrmIntegration\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"campusGroupId\": "+data.get("CampusGroupID")+",\r\n"
							+ "    \"city\": \""+data.get("City")+"\",\r\n"
							+ "    \"code\": \""+EmployerNameValue+"\",\r\n"
							+ "    \"corporationId\": null,\r\n"
							+ "    \"countryId\": "+data.get("CountryID")+",\r\n"
							+ "    \"countyId\": \"\",\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"emailAddress\": \""+EmailAddressValue+"@EDU.com\",\r\n"
							+ "    \"employerType\": \"\",\r\n"
							+ "    \"externType\": \"0\",\r\n"
							+ "    \"faxnumber\": \"\",\r\n"
							+ "    \"feeAmount\": \"0\",\r\n"
							+ "    \"feeDescription\": null,\r\n"
							+ "    \"industryId\": null,\r\n"
							+ "    \"isActive\": true,\r\n"
							+ "    \"isValidated\": false,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"name\": \""+EmployerNameValue+"\",\r\n"
							+ "    \"note\": \""+data.get("Note")+"\",\r\n"
							+ "    \"organizationId\": null,\r\n"
							+ "    \"phoneExtension\": null,\r\n"
							+ "    \"phoneNumber\": \""+data.get("PhoneNum")+"\",\r\n"
							+ "    \"pin\": null,\r\n"
							+ "    \"placementAdvisorId\": null,\r\n"
							+ "    \"postalCode\": \""+data.get("PostalCode")+"\",\r\n"
							+ "    \"practicumSite\": false,\r\n"
							+ "    \"primaryEmployerLocationId\": null,\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"staffId\": null,\r\n"
							+ "    \"state\": \"\",\r\n"
							+ "    \"streetAddress\": \""+data.get("StreetAddress")+"\",\r\n"
							+ "    \"url\": null,\r\n"
							+ "    \"campusGroup\": null,\r\n"
							+ "    \"employerLocations\": [],\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEALWVUUvDQAzHv4r03d7m3kZXKHXKcHODTvH17KVboHdXcqlt/fSuFXybiJDXhPzyP/5JLsmI9LCvnmB41XUL+yowoTtpNxyHBm56W7uwis7MzVKpUJ7B6hBbLMkHX3FceqvuZrOFms9UAYS6xk/N6J2awCH6Jizxh9F1XdwtYk+nsXCu3nbbYsLeogusXQlRmlyRMyXSrQ688wYrBPMSgDYmUWM8mUpucOmwXkVMLUQqnVJXWX9rcq8ZjmhBoI2I9pzgolhSdq5t04ZH8m0j8wLkQQC7tk3tB6AxIoB/0L1r7TuQxKCErGT8EJnBsO7LujVgcrIbx3CiaYVFWl1yaMbpFKAfzt7Bs5QDB385T3XujYQHB9IXe8vWFsgS/IK1EJcAODOGIASJlQLIrG8dS1yDnoHc/2+B+v3vTL8Au08031wHAAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL1")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String EmployerID = path.getString("payload.data.id");
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Employer ID "+EmployerID);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "New Employer is successfully created");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Creation of New employer is failed");
			}
			return EmployerID;
		}


		@Test(priority=4)
		public void PlaceStudentsIntoExternship_API(StringHash data) throws IOException
		{	
			APIAutomationPage sTest = new APIAutomationPage();
			String EmployerID = sTest.AddNewEmployers_API(data);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"PlacementID\": 0,\r\n"
							+ "    \"Descrip\": \"\",\r\n"
							+ "    \"PlStudentID\": \""+data.get("PlStudentID")+"\",\r\n"
							+ "    \"EmployerID\": "+EmployerID+",\r\n"
							+ "    \"JobID\": 0,\r\n"
							+ "    \"PlRepID\": 0,\r\n"
							+ "    \"UserID\": "+data.get("StaffID")+",\r\n"
							+ "    \"Supervisor\": \"\",\r\n"
							+ "    \"Comment\": \"\",\r\n"
							+ "    \"HowPlacedId\": "+data.get("HowPlacedId")+",\r\n"
							+ "    \"SalaryType\": \"\",\r\n"
							+ "    \"Salary\": "+data.get("Salary")+",\r\n"
							+ "    \"InFieldOfStudy\": \""+data.get("InFieldOfStudy")+"\",\r\n"
							+ "    \"FromInterview\": "+data.get("FromInterview")+",\r\n"
							+ "    \"Benefits\": false,\r\n"
							+ "    \"Fee\": false,\r\n"
							+ "    \"JobSchedule\": \""+data.get("JobSchedule")+"\",\r\n"
							+ "    \"Current\": "+data.get("Current")+",\r\n"
							+ "    \"SchedFrom\": \"\",\r\n"
							+ "    \"SchedTo\": \"\",\r\n"
							+ "    \"EndDate\": \""+data.get("TermDate")+" 00:00:00\",\r\n"
							+ "    \"JobTypeID\": "+data.get("JobTypeID")+",\r\n"
							+ "    \"DatePlaced\": \""+data.get("DatePlaced")+" 00:00:00\",\r\n"
							+ "    \"StartDate\": \""+data.get("StartDate")+" 00:00:00\",\r\n"
							+ "    \"PlJobTitleID\": "+data.get("PlJobTitleID")+",\r\n"
							+ "    \"PlacementStatusID\": "+data.get("PlacementStatusID")+",\r\n"
							+ "    \"PlJobSourceID\": 0,\r\n"
							+ "    \"SupervisorPhone\": \"\",\r\n"
							+ "    \"EnrollSchID\": 0,\r\n"
							+ "    \"ExactJobTitle\": \"\",\r\n"
							+ "    \"PlJobCategoryID\": 0,\r\n"
							+ "    \"TermDate\": \""+data.get("TermDate")+" 00:00:00\",\r\n"
							+ "    \"TermReason\": \"\",\r\n"
							+ "    \"Converted\": 0,\r\n"
							+ "    \"Status\": \"A\",\r\n"
							+ "    \"OldPlacementID\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "New Employer is successfully added tp student");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "New Employer is not added to student");
			}
		}


		@Test(priority=4)
		public void UpdateAdminRepForStudent_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isExcludedCrmIntegration\": false,\r\n"
							+ "    \"addressTypeId\": 0,\r\n"
							+ "    \"studentInquiryRequired\": true,\r\n"
							+ "    \"extraCurricularsList\": [],\r\n"
							+ "    \"programsList\": [\r\n"
							+ "      31,\r\n"
							+ "      17,\r\n"
							+ "      1\r\n"
							+ "    ],\r\n"
							+ "    \"enrolledProgramIdList\": [],\r\n"
							+ "    \"ethnicitiesList\": [\r\n"
							+ "      6\r\n"
							+ "    ],\r\n"
							+ "    \"leadSourcesList\": [\r\n"
							+ "      727\r\n"
							+ "    ],\r\n"
							+ "    \"deleteVeteranDetails\": false,\r\n"
							+ "    \"vendors\": [\r\n"
							+ "      {\r\n"
							+ "        \"LeadSourceId\": 727,\r\n"
							+ "        \"SyOrganizationId\": -1\r\n"
							+ "      }\r\n"
							+ "    ],\r\n"
							+ "    \"studentAddressAssociation\": 2,\r\n"
							+ "    \"newAssignedAdmissionsRepId\": 1124,\r\n"
							+ "    \"assignedAdmissionsRepReassignedDate\": \"2022/08/17 00:00:00\",\r\n"
							+ "    \"studentRelationshipAddress\": null,\r\n"
							+ "    \"lastFourSsn\": \"7757\",\r\n"
							+ "    \"customProperties\": {\r\n"
							+ "      \"CAR\": \"Fuchsia\",\r\n"
							+ "      \"VTP\": \"Exotic \",\r\n"
							+ "      \"BREWPUB\": \"Testing\",\r\n"
							+ "      \"NYTP\": \"Testing\"\r\n"
							+ "    },\r\n"
							+ "    \"multiValueCustomProperties\": {\r\n"
							+ "      \"LeftHand\": [\r\n"
							+ "        \"Yes\"\r\n"
							+ "      ]\r\n"
							+ "    },\r\n"
							+ "    \"originalCustomPropertiesValues\": \"H4sIAAAAAAAEAKXRzQrCMAwA4FeR3V2mu0kdqMyLv8z/YyndFthaaSpzPr3agaCoCF5C0iYfgbCBMbxepBNZb3lxkouUrEGVNbF1LgtFfS+39tgDIJHLkpNfojCadGp9oUvoBkEInQBW0iAv8MItagXOJa8Revgwqqryq9DXJrsPdmA/m64c20ZFlishvYi938a9R6NBwuCeMNcSjU8iJ+QMmtL9fRr+iG7Xyyc0PmuLovUfOkzi3XIzfILXkuyt4T94fnhZ92cVvp47ugIrZCAjDgIAAA==\",\r\n"
							+ "    \"originalMultiValueCustomPropertiesValues\": \"H4sIAAAAAAAEAJWQwQrCMBBEf0V6N9taUCgxICgIVnooiB5DTNpAk5QkEuvXS9Piud52dmcew+KDtXSoxIUPN9q9eCWct1I383oSftid+u0xW71Vp90+ab3vCwDHWq6oQ0oya5wRHjGjYJOmOWQp1NxK2skP9dJoiDyXTIRC/hghBBRyZGwzBjO4X8s6YtdSO0814wnBi8pFGym58GeqnxhGhWOM4MlJHtxhmGcM8w0W0uGfT5EvyEXct1gBAAA=\",\r\n"
							+ "    \"genderPronounList\": [],\r\n"
							+ "    \"overridePrevEducAltPellValidation\": false,\r\n"
							+ "    \"id\": 18712,\r\n"
							+ "    \"acgEligReasonCode\": null,\r\n"
							+ "    \"agencyId\": 0,\r\n"
							+ "    \"alienNumber\": \"\",\r\n"
							+ "    \"arAccountStatus\": \"\",\r\n"
							+ "    \"arBalance\": 1370,\r\n"
							+ "    \"arNextTransactionNumber\": 36,\r\n"
							+ "    \"assignedAdmissionsRepId\": 2,\r\n"
							+ "    \"athleticIdentifier\": null,\r\n"
							+ "    \"bestTimeToContact\": \"\",\r\n"
							+ "    \"campusId\": 5,\r\n"
							+ "    \"citizenId\": 1,\r\n"
							+ "    \"city\": \"MILTON FREEWATER\",\r\n"
							+ "    \"collegeId\": null,\r\n"
							+ "    \"countryId\": 1,\r\n"
							+ "    \"countyId\": 1,\r\n"
							+ "    \"createdDateTime\": \"2020/07/26 16:31:51\",\r\n"
							+ "    \"cumulativeGpa\": 1.903,\r\n"
							+ "    \"cumulativeGpaPoints\": 59,\r\n"
							+ "    \"currencyCodeId\": null,\r\n"
							+ "    \"currentLda\": \"2022/02/02 00:00:00\",\r\n"
							+ "    \"dataBlockIndicator\": false,\r\n"
							+ "    \"dateOfBirth\": \"1986/09/17 00:00:00\",\r\n"
							+ "    \"dbiModifiedDate\": null,\r\n"
							+ "    \"defaultAddressCode\": null,\r\n"
							+ "    \"defaultMasterStudentAddressId\": null,\r\n"
							+ "    \"defaultStudentAddressId\": null,\r\n"
							+ "    \"disabled\": \"X\",\r\n"
							+ "    \"driverLicenseNumber\": \"\",\r\n"
							+ "    \"driverLicenseState\": \"\",\r\n"
							+ "    \"emailAddress\": \"xyz@campusmgmt.com\",\r\n"
							+ "    \"employabilityAboutInfo\": null,\r\n"
							+ "    \"employerId\": 0,\r\n"
							+ "    \"employmentStatusId\": 0,\r\n"
							+ "    \"externalStudentIdentifier\": null,\r\n"
							+ "    \"extraCurricularActivityId\": 0,\r\n"
							+ "    \"facebookUrl\": null,\r\n"
							+ "    \"faGradPlusCounselingDate\": null,\r\n"
							+ "    \"faRigorousHighSchoolProgramCodeId\": null,\r\n"
							+ "    \"firstName\": \"NICOLE\",\r\n"
							+ "    \"genderId\": 5,\r\n"
							+ "    \"gpaCredits\": 31,\r\n"
							+ "    \"hispanicLatino\": \"N\",\r\n"
							+ "    \"hsAcademicGpa\": null,\r\n"
							+ "    \"instagramUrl\": null,\r\n"
							+ "    \"isActive\": true,\r\n"
							+ "    \"isAllowedBulkRegistrationByTrack\": null,\r\n"
							+ "    \"isBadAddress\": false,\r\n"
							+ "    \"isBadPhone\": false,\r\n"
							+ "    \"isDdVeteran\": false,\r\n"
							+ "    \"isEftDefaultForStipends\": false,\r\n"
							+ "    \"isInDistrict\": false,\r\n"
							+ "    \"isSscrError11Received\": false,\r\n"
							+ "    \"lastActivityDate\": \"2022/08/04 09:40:21\",\r\n"
							+ "    \"lastInterestDate\": null,\r\n"
							+ "    \"lastModifiedDateTime\": \"2022/08/16 14:24:49\",\r\n"
							+ "    \"lastModifiedUserId\": 3501,\r\n"
							+ "    \"lastName\": \"AMBS\",\r\n"
							+ "    \"lastNameFirstFour\": null,\r\n"
							+ "    \"lastStatementBeginDate\": null,\r\n"
							+ "    \"lastStatementCloseDate\": null,\r\n"
							+ "    \"lastStatementDate\": null,\r\n"
							+ "    \"leadDate\": \"2010/06/24 00:00:00\",\r\n"
							+ "    \"leadSourceId\": 727,\r\n"
							+ "    \"leadTypeId\": 2,\r\n"
							+ "    \"linkedInUrl\": null,\r\n"
							+ "    \"maidenName\": \"WATSON\",\r\n"
							+ "    \"maritalStatusId\": 0,\r\n"
							+ "    \"mi\": \"E\",\r\n"
							+ "    \"middleName\": \"E\",\r\n"
							+ "    \"mobilePhoneNumber\": \"\",\r\n"
							+ "    \"nationalityId\": 20,\r\n"
							+ "    \"nickName\": \"\",\r\n"
							+ "    \"niStudent\": false,\r\n"
							+ "    \"note\": \" \",\r\n"
							+ "    \"originalAssignedAdmissionsRepId\": 0,\r\n"
							+ "    \"originalExpectedStartDate\": \"2002/04/02 00:00:00\",\r\n"
							+ "    \"originalStartDate\": \"2002/04/02 00:00:00\",\r\n"
							+ "    \"otherEmailAddress\": \"123@campusmgmt.com\",\r\n"
							+ "    \"otherPhoneNumber\": null,\r\n"
							+ "    \"personId\": 26145,\r\n"
							+ "    \"phoneNumber\": \"(509)386-9414\",\r\n"
							+ "    \"pin\": null,\r\n"
							+ "    \"postalCode\": \"97862\",\r\n"
							+ "    \"postalCodeFirstThree\": null,\r\n"
							+ "    \"preferredContactType\": \"Ph\",\r\n"
							+ "    \"preferredName\": null,\r\n"
							+ "    \"previousEducationGpa\": null,\r\n"
							+ "    \"previousEducationId\": 2,\r\n"
							+ "    \"programGroupId\": 0,\r\n"
							+ "    \"programId\": 31,\r\n"
							+ "    \"rawFirstName\": null,\r\n"
							+ "    \"rawLastName\": null,\r\n"
							+ "    \"rawPhoneNumber\": null,\r\n"
							+ "    \"rowVersion\": \"AAAAAAsiQEA=\",\r\n"
							+ "    \"schoolStatusId\": 13,\r\n"
							+ "    \"shiftId\": 10,\r\n"
							+ "    \"smsServiceProviderId\": 97,\r\n"
							+ "    \"sourceSystem\": \"C\",\r\n"
							+ "    \"ssn\": \"537-02-7757\",\r\n"
							+ "    \"startDate\": \"2020/09/23 00:00:00\",\r\n"
							+ "    \"state\": \"OR\",\r\n"
							+ "    \"statementComment\": \"\",\r\n"
							+ "    \"streetAddress\": \"84357 POVERTY LANE\",\r\n"
							+ "    \"streetAddress2\": null,\r\n"
							+ "    \"studentFullName\": null,\r\n"
							+ "    \"studentIdentifier\": \"5370277571986-09-17AMBS\",\r\n"
							+ "    \"studentNumber\": \"4521269\",\r\n"
							+ "    \"subscribeToSms\": true,\r\n"
							+ "    \"suffix\": null,\r\n"
							+ "    \"suffixId\": null,\r\n"
							+ "    \"titleId\": 0,\r\n"
							+ "    \"twitterUrl\": null,\r\n"
							+ "    \"veteran\": \"N\",\r\n"
							+ "    \"workPhoneNumber\": \"\",\r\n"
							+ "    \"workPhoneNumberExtension\": \"\",\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEANVbW3PaOBT+Kxmedh8ItrkFJmEWKEmZ5bbYm3YfhX0ATW2JkeQk9Nev5EC7beJ0go4TL8PkMgbps87tOxdf9oUg+/n6T9jfkjiF+VoqQdmGsH2w38HZQxIzeVXZKrXr1moy3EJC5HlCQ8ElX6vzkCc1z3HqNdep+SAoielXoihntWxhWXlcoUu/rXF/f39+Xz/nYmO+6NY+Tyd+tmyVMqkIC6HSu8yBk13ojaPLmvl9mX3kjHaVvnRVIV3K1HE/8uv9Kj33ou16l7VsmV62Zu6m+WgmRKprngpfshxYj196FbJ2u9m2BdYPN6OYbpZAJGdDHsFP8BiNrypKpFCpnb7HBli4RxOIY33PMQU2S5MVCDRhWJyO6IchT5nyFVGpLAWiAYmNjeVgiSCkCYlfZ0X1tnPu6Je18MQMHlQgCJMkND7kZUFuuXiddtVb1gilpBsGUT9KqP6TM7mEHZr2W7uivtrGoGg4joApuqZPzg7D5AcgVUATCPiQM6UFVQK1HpJkl0o0QTRtBTGkin4FhheoEADt8aLTdDwJ5rOz6+Vo9KkfjJbW6HgcwwaeHBeGug6N/xV4IcpeFAZQmfAIIAqiD/qHMeu8wHC4/DqH5nhO1WlXvVbgtrp1t9u0R5smaawJ5h3c7AhmEDvvOHWEGPYDvgXX0swL+6egbHZQAu0wFUJHiEmUe4InSturOuYdOE43e9sC1UpJBjEPv4xZREOieB4ZWHEeA2GvwrsmsQQEhPrCgAq1xTxLt3PRqjqdqtvGO8sVnfLIsILM1gtwtR9gTdJY9aNIgJQFZRyHTaY66wLhq9RQncOOhcSPw35vsROVZBVDXmA4IU5/ttYZoR2ZmNAQmITSpFU/oDKpVV7QektQo4TQ+KAeeBJ82H/9I8zIbbJJsmqLrUhHyS7mexDlydkfESVwTJNLhOxB+xhG4oPxF5pW6b0EMYGZhppAiL5OgO8oIk+0PoxrciNItIhTaRishFh/oKBAck2WdMMFT+VHutnqO9DRfSH4RpDERJVCvO81FVLNSC4BPsF4Z+PhfDKyPfcbYBGiuVrntprX6pQhoqjEtu6iENuPVO4Io+FEM3DGESVpDUz2QxJBQsOnaQuG9o5l5jDylPcUemwQ2d72WA5I9HJQfDfmnmFbbDnDPDQkZB+iW9Chh+R1FN4R2mitDpT4mmv+TXfaPZVQtmOm6bS+kFuefEdsvgzFSAguXHcJIWizzXPu7wbSNLWOFOSZII9QJ7ioOo3A6XQbTtezrgoZuGOmLQakKoiTmC3+mz8XUCvLTsVtBW6j6zW6jc6516pjnMwR9t8SkUfUmw6K2HApV3868LFQZYzQdHYL0qYsczVpzwA2lBWott82GsZcwltsVNQeQJ6rXVnanetUnVbVa6BV2gxMX+tN+DRTOdXa2p71OIBBZf4rT7tySqjOqHEdwKd+4M+t6fqUCKpM3l+uesSU4h2UdV46pVEUA6707EHxFY0hY/WlKVfOsnkoEmNWczxrXZrR8Auq8CwOiB4KbGVjwTOOWFrundnCmQuqiQKJi51CsdasI8zRww5CBZH2ouI5RmAZtk2nsYHZbDzi/t/gVVsQxbQdXK+O3HbIwOb7ZQx2uAAhOd7MjddyG9bF0iIiUe+3ptP5vX7RqnYabsMaIf25yIQiCy41f3qmBWxx2532Rcuac34HlqV3wVZAEZnKQsAahIDoMCNnruCdxGJrfQxHfM9QAKT7v6M8laMoDTP6U0zZ+8k25UluDv2qG8HTEsXmAyq8KpB1DWhJ7vNabxgaopfPqTIhrV5sTFvy+1sd1rRm53FjIqHVGGjeIvavq5RlL0n/GvWvbGX42KFFzpZd69qnv6VrhYfH2vj8RPog7mgI2gzvKGZXt2NdHnosWPl7qSDBi1RDa1iYT9U0620zoIjxcE1BSYKZl+1UvTpakoA7HtWbW896fy9G8yTJz/nfsv7gK00CFXoSddGoN9tni/ntaBn8czbpz6yrWz8A9QoIN78adLKzPcczlvd9tBWjWXNAjJ1iNZqe67U61ujSlQwFXUHAtfMv2XCGn67X9KEILcoWLmRKK6AqxutgWHvXl6c0TtA7687FJy6+lKv8/RMiM1PJXiC0yNBqLz/f3PsX5s4NWQA9AAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 2,\r\n"
							+ "    \"_isNew\": false,\r\n"
							+ "    \"_lastModifiedDate\": 1660640089000,\r\n"
							+ "    \"age\": 35,\r\n"
							+ "    \"leadTime\": \"12:00 AM\",\r\n"
							+ "    \"ethnicity\": [\r\n"
							+ "      6\r\n"
							+ "    ],\r\n"
							+ "    \"extraCurricular\": [],\r\n"
							+ "    \"oldAssignedAdmissionsRepId\": 2,\r\n"
							+ "    \"oldSchoolStatusId\": 13,\r\n"
							+ "    \"deleteInquiryDetails\": true,\r\n"
							+ "    \"fullName\": \"NICOLE AMBS\",\r\n"
							+ "    \"niStudentEnabled\": false,\r\n"
							+ "    \"leadSourceLeadVendorColl\": [\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"College Fair\",\r\n"
							+ "        \"LeadSourceId\": 693,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"Community Education\",\r\n"
							+ "        \"LeadSourceId\": 703,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"Early College Credit\",\r\n"
							+ "        \"LeadSourceId\": 723,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"Family/Friend Referral\",\r\n"
							+ "        \"LeadSourceId\": 701,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"High School Visit\",\r\n"
							+ "        \"LeadSourceId\": 721,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"ISIR Lead\",\r\n"
							+ "        \"LeadSourceId\": 727,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": 18584,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": true\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"On-line Web Form\",\r\n"
							+ "        \"LeadSourceId\": 680,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"Social Media\",\r\n"
							+ "        \"LeadSourceId\": 717,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"LeadSourceName\": \"Walls Test\",\r\n"
							+ "        \"LeadSourceId\": 728,\r\n"
							+ "        \"LeadSourceLeadVendorId\": 1,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": false,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"SyOrganizationId\": -2,\r\n"
							+ "        \"LeadVendorList\": [\r\n"
							+ "          {\r\n"
							+ "            \"LeadSourceId\": 728,\r\n"
							+ "            \"NodeSyOrganizationId\": null,\r\n"
							+ "            \"OrganizationName\": \"TEST\",\r\n"
							+ "            \"ParentSyOrganizationId\": null,\r\n"
							+ "            \"SyOrganizationId\": 10231,\r\n"
							+ "            \"SubVendorList\": [\r\n"
							+ "              {\r\n"
							+ "                \"LeadSourceId\": 728,\r\n"
							+ "                \"NodeSyOrganizationId\": null,\r\n"
							+ "                \"OrganizationName\": \"WALLS\",\r\n"
							+ "                \"ParentSyOrganizationId\": 10231,\r\n"
							+ "                \"SyOrganizationId\": 10232,\r\n"
							+ "                \"checked\": false\r\n"
							+ "              }\r\n"
							+ "            ],\r\n"
							+ "            \"HasSubVendors\": true,\r\n"
							+ "            \"checked\": false\r\n"
							+ "          }\r\n"
							+ "        ],\r\n"
							+ "        \"HasLeadVendors\": true,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      },\r\n"
							+ "      {\r\n"
							+ "        \"SyOrganizationId\": null,\r\n"
							+ "        \"OrganizationName\": null,\r\n"
							+ "        \"ParentSyOrganizationId\": null,\r\n"
							+ "        \"NodeSyOrganizationId\": null,\r\n"
							+ "        \"LeadSourceName\": \"Website\",\r\n"
							+ "        \"LeadSourceId\": 714,\r\n"
							+ "        \"LeadSourceLeadVendorId\": null,\r\n"
							+ "        \"NodeProspectInquiryLeadSourceId\": null,\r\n"
							+ "        \"IsDefault\": null,\r\n"
							+ "        \"Code\": null,\r\n"
							+ "        \"OverrideDefaultVendor\": false,\r\n"
							+ "        \"checked\": false\r\n"
							+ "      }\r\n"
							+ "    ],\r\n"
							+ "    \"isSaveAndClose\": false,\r\n"
							+ "    \"ProgramsList\": [\r\n"
							+ "      31,\r\n"
							+ "      17,\r\n"
							+ "      1\r\n"
							+ "    ],\r\n"
							+ "    \"EthnicitiesList\": [\r\n"
							+ "      6\r\n"
							+ "    ],\r\n"
							+ "    \"LeadSourcesList\": [\r\n"
							+ "      727\r\n"
							+ "    ],\r\n"
							+ "    \"Vendors\": [\r\n"
							+ "      {\r\n"
							+ "        \"LeadSourceId\": 727,\r\n"
							+ "        \"SyOrganizationId\": -1\r\n"
							+ "      }\r\n"
							+ "    ],\r\n"
							+ "    \"DeleteVeteranDetails\": false,\r\n"
							+ "    \"StudentInquiryRequired\": true\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Admin Rep is updated successfully");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Admin Rep is not updated");
			}
		}


		@Test(priority=4)
		public void ScheduleStudentPaymentPlan_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"updatePellOriginationStatus\": false,\r\n"
							+ "    \"updateCodGrantOriginationStatus\": false,\r\n"
							+ "    \"pellHasDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "    \"codGrantHasDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "    \"continuePellDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "    \"continueCodGrantDisbursementGrantInRejectedStatus\": false,\r\n"
							+ "    \"scheduledlDisbursements\": [\r\n"
							+ "      {\r\n"
							+ "        \"academicYearSequence\": "+data.get("academicYearSequence")+",\r\n"
							+ "        \"paymentPeriodSequence\": null,\r\n"
							+ "        \"loanPaymentPeriodSequence\": null,\r\n"
							+ "        \"termCode\": null,\r\n"
							+ "        \"termStartDate\": null,\r\n"
							+ "        \"courseCode\": null,\r\n"
							+ "        \"disbursementPercentage\": 0,\r\n"
							+ "        \"isAuditDisbursement\": false,\r\n"
							+ "        \"balance\": 0,\r\n"
							+ "        \"isUsePaymentPeriod\": false,\r\n"
							+ "        \"isUseLoanPeriod\": false,\r\n"
							+ "        \"studentLoanPeriodId\": null,\r\n"
							+ "        \"fundSource\": null,\r\n"
							+ "        \"studentName\": null,\r\n"
							+ "        \"fundSourceType\": null,\r\n"
							+ "        \"isTitle4\": false,\r\n"
							+ "        \"studentEnrollmentPeriodId\": 0,\r\n"
							+ "        \"isContinueForDateWithinLoanPaymentPeriod\": false,\r\n"
							+ "        \"isContinueForDateWithinPaymentPeriod\": false,\r\n"
							+ "        \"isContinueForDisbursementWithinPaymentPeriod\": false,\r\n"
							+ "        \"courseDescription\": null,\r\n"
							+ "        \"id\": 0,\r\n"
							+ "        \"actualDisbursementDate\": null,\r\n"
							+ "        \"auditString\": null,\r\n"
							+ "        \"clockHours\": null,\r\n"
							+ "        \"commonLineDisbReleaseCode\": null,\r\n"
							+ "        \"commonLineStatus\": null,\r\n"
							+ "        \"createdDateTime\": \"0001/01/01 00:00:00\",\r\n"
							+ "        \"createdUserId\": 0,\r\n"
							+ "        \"directLoanDisbPercentage\": null,\r\n"
							+ "        \"directLoanDisbStatus\": null,\r\n"
							+ "        \"disbursementEligibilityStageId\": null,\r\n"
							+ "        \"disbursementNumber\": null,\r\n"
							+ "        \"eligibilityCheckDate\": null,\r\n"
							+ "        \"eligibilityStatus\": 0,\r\n"
							+ "        \"enrollmentStatus\": null,\r\n"
							+ "        \"faExportImportFileId\": null,\r\n"
							+ "        \"fulltimeAwardAmount\": 0,\r\n"
							+ "        \"grossAmount\": 0,\r\n"
							+ "        \"interestAmount\": 0,\r\n"
							+ "        \"interestRebateAmount\": null,\r\n"
							+ "        \"isPaymentPlan\": null,\r\n"
							+ "        \"isSpeUpdate\": null,\r\n"
							+ "        \"lastModifiedDateTime\": \"0001/01/01 00:00:00\",\r\n"
							+ "        \"lastModifiedUserId\": 0,\r\n"
							+ "        \"lenderFee\": 0,\r\n"
							+ "        \"netAmount\": "+data.get("netAmount")+",\r\n"
							+ "        \"overrideDisbursementDate\": null,\r\n"
							+ "        \"paidDisbursementId\": null,\r\n"
							+ "        \"paymentPeriodBeginDate\": null,\r\n"
							+ "        \"paymentPeriodId\": null,\r\n"
							+ "        \"paymentPeriodNumber\": null,\r\n"
							+ "        \"pellGrantDisbStatus\": null,\r\n"
							+ "        \"previousStatus\": null,\r\n"
							+ "        \"principalAmount\": "+data.get("netAmount")+",\r\n"
							+ "        \"rowVersion\": null,\r\n"
							+ "        \"scheduledDate\": \"2022/03/04 00:00:00\",\r\n"
							+ "        \"status\": \""+data.get("status")+"\",\r\n"
							+ "        \"studentAcademicYearId\": "+data.get("studentAcademicYearId")+",\r\n"
							+ "        \"studentAcademicYearLoanPaymentPeriodId\": null,\r\n"
							+ "        \"studentAcademicYearPaymentPeriodId\": null,\r\n"
							+ "        \"studentAwardId\": 0,\r\n"
							+ "        \"studentCourseId\": null,\r\n"
							+ "        \"studentId\": 0,\r\n"
							+ "        \"termId\": 0,\r\n"
							+ "        \"thirdPartyInvoiceNumber\": null,\r\n"
							+ "        \"unroundedGrossAmount\": 0,\r\n"
							+ "        \"originalState\": \"H4sIAAAAAAAEALWSTWvDMAyG/0rxfVG63kIaCOxS9tFBxtiOwlFagy0HWybLfv1SD3ZrLyM3oVd6XkmobkPA+Tg80vyONtFxiBIMn5Dnt3mkzZezHPfqLDJWAFGfyWEsnNHBRz9Iob2D+7LcwbaEjoJBa75RjGfI4Kh+CZX5Y0zTVEy7wofTpXELH89PXcbeGY6CrEk19ZVxstB0gpJiDZe4zmUbU7GxeyUhkYImS1f7b4CXOfpkqX9AoTX4knpiaTX2tJzwkzAc+hV8Xkha5xPLCuzXJaPNiHY1hwMLBYr/WgFuv3XzA2LWgN/3AgAA\",\r\n"
							+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "        \"extendedProperties\": [],\r\n"
							+ "        \"entityState\": 0,\r\n"
							+ "        \"Id\": 0\r\n"
							+ "      }\r\n"
							+ "    ],\r\n"
							+ "    \"specialDisbursementEntity\": null,\r\n"
							+ "    \"nonTitleIvPaymentPeriods\": null,\r\n"
							+ "    \"paidDisbursements\": null,\r\n"
							+ "    \"refunds\": null,\r\n"
							+ "    \"studentAwardLoanEntity\": null,\r\n"
							+ "    \"studentAwardPellEntity\": null,\r\n"
							+ "    \"studentAcademicYears\": null,\r\n"
							+ "    \"costOfAttendance\": 440,\r\n"
							+ "    \"efc\": \"0.00\",\r\n"
							+ "    \"needBasedAmountPackaged\": 10,\r\n"
							+ "    \"nonNeedBasedAmountPackaged\": 430,\r\n"
							+ "    \"needBasedGrossAmount\": \"0.00\",\r\n"
							+ "    \"nonNeedBasedGrossAmount\": \"10.00\",\r\n"
							+ "    \"isLimitPackagingToCoa\": false,\r\n"
							+ "    \"isRecalculatedEfc\": false,\r\n"
							+ "    \"studentAcademicYearSequence\": "+data.get("academicYearSequence")+",\r\n"
							+ "    \"campusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"isScheduledAmountMisMatchWithDisbursementAmount\": false,\r\n"
							+ "    \"continueScheduledAmountMisMatchWithDisbursementAmount\": false,\r\n"
							+ "    \"preventAwardingWhenAuthorizationNotExpended\": false,\r\n"
							+ "    \"continueAwardingWhenAuthorizationNotExpended\": false,\r\n"
							+ "    \"glAuthorizationId\": 0,\r\n"
							+ "    \"isPreventSaveForGrant\": false,\r\n"
							+ "    \"isStateAdd\": false,\r\n"
							+ "    \"recalculateCashPlan\": false,\r\n"
							+ "    \"updateAmountPackagedWithPrincipal\": false,\r\n"
							+ "    \"isAdjustPackageInEditMode\": false,\r\n"
							+ "    \"adjustPackagedAmountMessage\": null,\r\n"
							+ "    \"paymentAmountSplit\": 0,\r\n"
							+ "    \"isPaymentAmountSplitBasedOnNoOfPayments\": true,\r\n"
							+ "    \"allowOriginationChanged\": false,\r\n"
							+ "    \"isAllowOriginationChanged\": false,\r\n"
							+ "    \"isOriginationStatusReadyToSend\": false,\r\n"
							+ "    \"originationStatusReadyToSend\": false,\r\n"
							+ "    \"grossAmount\": "+data.get("netAmount")+",\r\n"
							+ "    \"originalGrossAmount\": 0,\r\n"
							+ "    \"isAddlEligibilityIndicator\": false,\r\n"
							+ "    \"resetGrossAmount\": false,\r\n"
							+ "    \"lessGrossAmount\": false,\r\n"
							+ "    \"isGrossAmountExeed\": false,\r\n"
							+ "    \"grossAmountExeed\": false,\r\n"
							+ "    \"isCampusAutoUpdatePellOriginationStatus\": false,\r\n"
							+ "    \"isAllowInformtionNotChange\": false,\r\n"
							+ "    \"isAllowInformtionChange\": false,\r\n"
							+ "    \"allowInformtionChange\": false,\r\n"
							+ "    \"isAllowAdvisor\": false,\r\n"
							+ "    \"allowAdvisor\": false,\r\n"
							+ "    \"isCommitLevelAmountChange\": false,\r\n"
							+ "    \"commitLevelAmountChange\": false,\r\n"
							+ "    \"isPreventPackaging\": false,\r\n"
							+ "    \"refundedGrossAmount\": 0,\r\n"
							+ "    \"netAmount\": "+data.get("netAmount")+",\r\n"
							+ "    \"isStudentLoanNetAmountNotEqualToDisbursementNetAmount\": false,\r\n"
							+ "    \"continueStudentLoanNetAmountNotEqualToDisbursementNetAmount\": false,\r\n"
							+ "    \"isStudentLoanPaidDisbursementBankFeeMoreThanLoanBankFee\": false,\r\n"
							+ "    \"continueStudentLoanPaidDisbursementBankFeeMoreThanLoanBankFee\": false,\r\n"
							+ "    \"isStudentLoanPaidDisbursementBankFeeLessThanLoanBankFee\": false,\r\n"
							+ "    \"continueStudentLoanPaidDisbursementBankFeeLessThanLoanBankFee\": false,\r\n"
							+ "    \"isAddBankFeeToCostOfAttendance\": false,\r\n"
							+ "    \"isAddBankFeeToCostOfAttendanceUserConfirmationIsYes\": false,\r\n"
							+ "    \"continueAfterConfirmationForAddBankFeeToCostOfAttendance\": false,\r\n"
							+ "    \"isStudentLoanReadyToSendValidationExists\": false,\r\n"
							+ "    \"isStudentLoanPaidDisbursementExists\": false,\r\n"
							+ "    \"disbursedAmount\": 0,\r\n"
							+ "    \"refundedAmount\": 0,\r\n"
							+ "    \"expectedAmount\": 0,\r\n"
							+ "    \"totalNetAmount\": 0,\r\n"
							+ "    \"originalAmountPackaged\": 0,\r\n"
							+ "    \"readyToSendValidationMessages\": null,\r\n"
							+ "    \"isUsePaymentPeriod\": false,\r\n"
							+ "    \"isSaveNonTitleIvPaymentPeriods\": false,\r\n"
							+ "    \"firstReferenceAddress\": null,\r\n"
							+ "    \"secondReferenceAddress\": null,\r\n"
							+ "    \"studentAwardLoanChangeEntity\": null,\r\n"
							+ "    \"isLoanDetailsChanged\": false,\r\n"
							+ "    \"isUseBorrowerSsn\": false,\r\n"
							+ "    \"isDirectLoanReCalculate\": false,\r\n"
							+ "    \"directLoanReCalculate\": false,\r\n"
							+ "    \"isEarlyDisbursementRulesFsaHandbook\": false,\r\n"
							+ "    \"earlyDisbursementRulesFsaHandbook\": false,\r\n"
							+ "    \"isDisbursmentAmountMissMatch\": false,\r\n"
							+ "    \"disbursmentAmountMissMatch\": false,\r\n"
							+ "    \"isAllowApprove\": false,\r\n"
							+ "    \"allowApprove\": false,\r\n"
							+ "    \"isMaxLimit\": false,\r\n"
							+ "    \"maxLimit\": false,\r\n"
							+ "    \"isAdjustLoanEndDate\": false,\r\n"
							+ "    \"adjustLoanEndDate\": false,\r\n"
							+ "    \"progVerTermAssocExist\": false,\r\n"
							+ "    \"isProgVerTermAssocExist\": false,\r\n"
							+ "    \"countDisburseMentAmount\": 0,\r\n"
							+ "    \"codGrantOrigination\": null,\r\n"
							+ "    \"codGrantDisbursements\": null,\r\n"
							+ "    \"isMultipleTeachGrant\": false,\r\n"
							+ "    \"isSavingAwardInCanceledStatusCodGrant\": false,\r\n"
							+ "    \"continueSavingAwardInCanceledStatusCodGrant\": false,\r\n"
							+ "    \"isChangingOriginationStatusCodGrant\": false,\r\n"
							+ "    \"isChangingOriginationStatusCodGrantCanceledByUser\": false,\r\n"
							+ "    \"continueChangingOriginationStatusCodGrant\": false,\r\n"
							+ "    \"isCodGrantAmountPackagedGreaterThanOriginationAmountAllowed\": false,\r\n"
							+ "    \"isCodGrantAmountPackagedGreaterThanOriginationAmount\": false,\r\n"
							+ "    \"continueSaveTeacherExpertIndicator\": false,\r\n"
							+ "    \"isTeacherExpertIndicator\": false,\r\n"
							+ "    \"isNonTitleIvPaymentPeriodCreated\": false,\r\n"
							+ "    \"isCodGrantIsirOnFile\": false,\r\n"
							+ "    \"isCodGrantTotalDisbAmtNotEqualToAwardAmount\": false,\r\n"
							+ "    \"continueCodGrantTotalDisbAmtNotEqualToAwardAmount\": false,\r\n"
							+ "    \"isGrossAmontExceeded\": false,\r\n"
							+ "    \"continueGrossAmontExceeded\": false,\r\n"
							+ "    \"isCodGrantChangesToGradeLevel\": false,\r\n"
							+ "    \"continueCodGrantChangesToGradeLevel\": false,\r\n"
							+ "    \"isCampusAutoUpdateOriginationStatusCodGrant\": false,\r\n"
							+ "    \"graduateStudentsNoLongerEligible\": false,\r\n"
							+ "    \"isGraduateStudentsNoLongerEligible\": false,\r\n"
							+ "    \"isirMustFileBeforeLoan\": false,\r\n"
							+ "    \"isIsirMustFileBeforeLoan\": false,\r\n"
							+ "    \"isRequiredField\": false,\r\n"
							+ "    \"requiredField\": false,\r\n"
							+ "    \"isValidateSpecialProgramIsN\": false,\r\n"
							+ "    \"validateSpecialProgramIsN\": false,\r\n"
							+ "    \"isValidateSpecialProgramIsNotABNPT\": false,\r\n"
							+ "    \"validateSpecialProgramIsNotABNPT\": false,\r\n"
							+ "    \"isValidateSpecialProgramIsNotABN\": false,\r\n"
							+ "    \"validateSpecialProgramIsNotABN\": false,\r\n"
							+ "    \"isValidateSpecialProgramIsNotABUN\": false,\r\n"
							+ "    \"validateSpecialProgramIsNotABUN\": false,\r\n"
							+ "    \"isAllowOriginationWithEstAward\": false,\r\n"
							+ "    \"allowOriginationWithEstAward\": false,\r\n"
							+ "    \"isMaxLimitForSubDirSub\": false,\r\n"
							+ "    \"maxLimitForSubDirSub\": false,\r\n"
							+ "    \"nonTitleIvAcademicYearPamentPeriodList\": null,\r\n"
							+ "    \"remainingNeed\": null,\r\n"
							+ "    \"addAgencyToStudentAgency\": false,\r\n"
							+ "    \"isAdjustPackagedAmountHasNotPreventAwardWarningMessage\": false,\r\n"
							+ "    \"continueAdjustPackagedAmountHasNotPreventAwardWarningMessage\": false,\r\n"
							+ "    \"adjustPackagedAmountNotPreventAwardWarningMessage\": null,\r\n"
							+ "    \"isLoanBeginDateChanged\": false,\r\n"
							+ "    \"isLoanEndDateChanged\": false,\r\n"
							+ "    \"originalLoanPeriodBeginDate\": \"0001/01/01 00:00:00\",\r\n"
							+ "    \"originalLoanPeriodEndDate\": \"0001/01/01 00:00:00\",\r\n"
							+ "    \"isPellExists\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"accruedInterestAmount\": 0,\r\n"
							+ "    \"agencyBranchId\": 0,\r\n"
							+ "    \"amountCanceled\": 0,\r\n"
							+ "    \"amountDisbursed\": 0,\r\n"
							+ "    \"amountPackaged\": "+data.get("netAmount")+",\r\n"
							+ "    \"amountRefunded\": 0,\r\n"
							+ "    \"applicationReceivedDate\": null,\r\n"
							+ "    \"applicationSentDate\": null,\r\n"
							+ "    \"awardLevelAmount\": 0,\r\n"
							+ "    \"awardYear\": \""+data.get("awardYear")+"\",\r\n"
							+ "    \"batchPackagingProcessId\": null,\r\n"
							+ "    \"calculationDate\": null,\r\n"
							+ "    \"codGrantOriginationId\": null,\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"creditCardEffectiveDate\": null,\r\n"
							+ "    \"downPaymentAmount\": null,\r\n"
							+ "    \"effectiveDate\": null,\r\n"
							+ "    \"emailNotification\": null,\r\n"
							+ "    \"faLenderId\": null,\r\n"
							+ "    \"firstPaymentDate\": \"2022/03/04 00:00:00\",\r\n"
							+ "    \"fundSourceId\": "+data.get("fundSourceId")+",\r\n"
							+ "    \"guarantorLendingInstitutionId\": null,\r\n"
							+ "    \"interestBalance\": 0,\r\n"
							+ "    \"interestOnlyUntilDate\": null,\r\n"
							+ "    \"interestRate\": \"0.00\",\r\n"
							+ "    \"interestRebateAmount\": 0,\r\n"
							+ "    \"isAutoCredit\": false,\r\n"
							+ "    \"isAutoDraft\": false,\r\n"
							+ "    \"isAxLinkedFws\": false,\r\n"
							+ "    \"isBankFeeIncludedInCoa\": false,\r\n"
							+ "    \"isCoaRecalculated\": null,\r\n"
							+ "    \"isEstimatedAward\": false,\r\n"
							+ "    \"isLocked\": false,\r\n"
							+ "    \"isReAllocated\": false,\r\n"
							+ "    \"isT4BalanceEvaluated\": false,\r\n"
							+ "    \"lastInterestDate\": null,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"lastPromNotePrintDate\": null,\r\n"
							+ "    \"lastStatementPrintDate\": null,\r\n"
							+ "    \"lenderFee\": 0,\r\n"
							+ "    \"loanAcademicYearEndDate\": null,\r\n"
							+ "    \"loanAcademicYearStartDate\": null,\r\n"
							+ "    \"loanIdentificationNumber\": null,\r\n"
							+ "    \"loanPeriodBeginDate\": null,\r\n"
							+ "    \"loanPeriodEndDate\": null,\r\n"
							+ "    \"lockedByUserId\": null,\r\n"
							+ "    \"nextPaymentDate\": \"2022/03/04 00:00:00\",\r\n"
							+ "    \"note\": null,\r\n"
							+ "    \"numberPayments\": \"1\",\r\n"
							+ "    \"paymentAmount\": "+data.get("netAmount")+",\r\n"
							+ "    \"paymentDay\": 4,\r\n"
							+ "    \"paymentFrequency\": -1,\r\n"
							+ "    \"paymentPlanId\": null,\r\n"
							+ "    \"paymentPlanTermId\": null,\r\n"
							+ "    \"principalBalance\": "+data.get("netAmount")+",\r\n"
							+ "    \"promNoteDocumentId\": null,\r\n"
							+ "    \"rep9010CollectionRate\": null,\r\n"
							+ "    \"rep9010DiscountRate\": null,\r\n"
							+ "    \"rep9010NumberOfYears\": null,\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"secondaryInterestRate\": \"\",\r\n"
							+ "    \"secondaryInterestRateEffectiveDate\": null,\r\n"
							+ "    \"servicerLendingInstitutionId\": null,\r\n"
							+ "    \"servicerRecordIdentifier\": null,\r\n"
							+ "    \"source\": \"S\",\r\n"
							+ "    \"status\": \"A\",\r\n"
							+ "    \"studentAcademicYearId\": "+data.get("studentAcademicYearId")+",\r\n"
							+ "    \"studentAwardNonTitleIvRuleId\": null,\r\n"
							+ "    \"studentAwardPellId\": null,\r\n"
							+ "    \"studentBankAccountId\": null,\r\n"
							+ "    \"studentCreditCardId\": null,\r\n"
							+ "    \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentID")+",\r\n"
							+ "    \"studentId\": "+data.get("StudentID")+",\r\n"
							+ "    \"studentLoanPeriodId\": null,\r\n"
							+ "    \"studentRelationshipAddressId\": 0,\r\n"
							+ "    \"totalAmountPaid\": 0,\r\n"
							+ "    \"webAlertNotification\": null,\r\n"
							+ "    \"loanDetail\": [],\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEANWYXW/aMBSG/0qVe8gHpKQRIIUWJrRUrQqbtsvT+AQsHLuynVL26+sEtqtlG43XZXdRbJ/z5LV9PjJOpITDXf4RD5+BlXiXKy0p3wA/rA9PePFSMK4mzlbrp9h1VbbFAlS/oJkUSuS6n4nCDTxv4Pqeu0JJgdFvoKngbm1YOUcLMf1hY7/f9/eDvpCbaqHvfrlNV7XZHuVKA8/QmY4bcOqBaQpK3wpCc4rkk0K5JGO3ej+ul1zQWJupEwdiyvV3//B7/850EHre2K2tTGuTjQx/BncDGte0wAY8cho+izHwgqDnRT1/tPaCOLyKw2Hfi0aXQTToecO4/QdYU7Pnt0W5lmgk+j9lPLHPDlZPaPvdVUmphYEjVDcwPQrBEPhZXDkwhXbYbiTkXUR7SSnfIVnsVffgZsB3C8Qlz1hJkCz5tYDuUc6VpkV1KZI9yKYb8Q/5UpGZDe4e1wMmjImsUq57cOvhDFiVtefPZlYXGVfa3AmuH5DVhYna0qeEEIlKdScs1zfiK4JsADouOTfD+b0gsKSeNan8aOS3hkoKUXJ9D9kONo0HjmBmwg07j6594l+UnKxEKTO0plkUtC6lTtuYZEDQVO/VUbO3pYMoCi0Qgi6bcusbzn9iSbI5l4Kxwjzdm/5GEGuyhVd+eGkJMhXAG/A4ZRNHyxId981ePpQggWshU+TEDC5Np0Z1WYXTv+JvAZWjn9TNNoybNvWZZvhe37LkGk2yMfnn0WTHY+SyGLHaN6y10qZ6fGco99d/HqavfAqjxpoQAAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "New Payment plan is scheduled");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Scheduling of new payment is failed");
			}
		}



		@Test(priority=4)
		public void PostFederalWorkStudyDisbursements_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"campusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"fundSourceId\": "+data.get("fundSourceId")+",\r\n"
							+ "    \"transactionDate\": \""+currentDate+"\",\r\n"
							+ "    \"paidDisbursements\": [\r\n"
							+ "      {\r\n"
							+ "        \"type\": null,\r\n"
							+ "        \"dueDate\": null,\r\n"
							+ "        \"termCode\": null,\r\n"
							+ "        \"commonLineStatus\": null,\r\n"
							+ "        \"academicYearSequence\": 0,\r\n"
							+ "        \"awardYear\": \""+data.get("awardYear")+"\",\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"actualAmount\": \""+data.get("actualAmount")+"\",\r\n"
							+ "        \"checkDate\": null,\r\n"
							+ "        \"checkNumber\": null,\r\n"
							+ "        \"createdByUserId\": 0,\r\n"
							+ "        \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "        \"depositDate\": null,\r\n"
							+ "        \"disbursedDate\": \""+currentDate+"\",\r\n"
							+ "        \"disbursementBatchId\": 0,\r\n"
							+ "        \"disbursementNumber\": null,\r\n"
							+ "        \"earnedDate\": null,\r\n"
							+ "        \"endorsedDate\": null,\r\n"
							+ "        \"expectedAmount\": 0,\r\n"
							+ "        \"hoursWorked\": "+data.get("hoursWorked")+",\r\n"
							+ "        \"interestAmount\": 0,\r\n"
							+ "        \"interestRebateAmt\": null,\r\n"
							+ "        \"isAxPayment\": false,\r\n"
							+ "        \"isDisbDateAdjustmentPending\": false,\r\n"
							+ "        \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "        \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "        \"paymentPeriodId\": null,\r\n"
							+ "        \"paymentPeriodNumber\": null,\r\n"
							+ "        \"periodEndDate\": null,\r\n"
							+ "        \"pgDisbStatus\": null,\r\n"
							+ "        \"receiptPrintedDate\": null,\r\n"
							+ "        \"rowVersion\": null,\r\n"
							+ "        \"scheduledDisbursementId\": null,\r\n"
							+ "        \"status\": null,\r\n"
							+ "        \"studentAcademicYearId\": "+data.get("studentAcademicYearId")+",\r\n"
							+ "        \"studentAwardId\": "+data.get("studentAwardId")+",\r\n"
							+ "        \"studentId\": "+data.get("studentId")+",\r\n"
							+ "        \"studentPaymentPeriodId\": null,\r\n"
							+ "        \"termId\": 0,\r\n"
							+ "        \"timeCardIdentifier\": 0,\r\n"
							+ "        \"originalState\": \"H4sIAAAAAAAEALWTTU/DMAyG/8rUO03HblVXaR+Xik1D2kBcQ+OuRk0y2a5K+fUsBXEbQki5xvHzvLKTYkWkx0PzAOOz7no4NCyE7qzdeBovMHu3neNl0opccqW4bsFqTi3W5Nk3ktbeqvssW6h5po5AqDv80ILeqQnMyRchxx/GMAzpsEg9nUPjXL3sd8cJe4eORbsakrK4EWcqlDvNsvcGGwTzxECVKVQ4L6aWGeYOu2Ui1EOiyql0k/U3yVYLnNBCBE2U7BuCa+KYsb8N6zHa/LfIrz0xWHCy1lK3USwVB08Y1Mq89SzB9gjOXO9FsIVlbDSZylw14WXR/yTq909bfgJVSgn/1QMAAA==\",\r\n"
							+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "        \"extendedProperties\": [],\r\n"
							+ "        \"entityState\": 0\r\n"
							+ "      }\r\n"
							+ "    ]\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Work Study Disbursements is posted successfully");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Work study Disbursements posting is failed");
			}
		}


		@Test(priority=4)
		public void ApprovingFADisbursements_API(StringHash data) throws IOException
		{	
			APIAutomationPage sTest = new APIAutomationPage();
			String BatchNum = sTest.CreateFADisbursements_API(data);
			wait(10);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isFromDialySaveBatch\": false,\r\n"
							+ "    \"disbursementBatchDetailList\": null,\r\n"
							+ "    \"id\": "+BatchNum+",\r\n"
							+ "    \"agencyBranchId\": null,\r\n"
							+ "    \"amountApproved\": "+data.get("amountApproved")+",\r\n"
							+ "    \"batchAmount\": "+data.get("amountApproved")+",\r\n"
							+ "    \"campusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"commonLineCancelAmount\": null,\r\n"
							+ "    \"commonLineDeficitAmount\": null,\r\n"
							+ "    \"commonLineDetailRecords\": null,\r\n"
							+ "    \"commonLineNetDisbAmount\": null,\r\n"
							+ "    \"commonLineNetEftAmount\": null,\r\n"
							+ "    \"commonLineNetNonEfTAmount\": null,\r\n"
							+ "    \"commonLineReissueAmount\": null,\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"editStartTime\": \""+currentDate+"\",\r\n"
							+ "    \"faExportImportFileId\": null,\r\n"
							+ "    \"importFileCode\": \"\",\r\n"
							+ "    \"inUseByStaffId\": null,\r\n"
							+ "    \"isBatchLocked\": true,\r\n"
							+ "    \"isBatchOpen\": true,\r\n"
							+ "    \"isDepositReceived\": false,\r\n"
							+ "    \"isDepositRequired\": false,\r\n"
							+ "    \"isExtracted\": false,\r\n"
							+ "    \"isOkToPost\": true,\r\n"
							+ "    \"isRefundCriteriaChecked\": false,\r\n"
							+ "    \"isStudentsDropped\": false,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"lenderId\": 0,\r\n"
							+ "    \"numberOfDisbursements\": 1,\r\n"
							+ "    \"parentDisbursementBatchId\": null,\r\n"
							+ "    \"postedByUserId\": null,\r\n"
							+ "    \"postedDate\": null,\r\n"
							+ "    \"reviewed\": 0,\r\n"
							+ "    \"rowVersion\": \"AAAAAAsjcr0=\",\r\n"
							+ "    \"thirdPartyInvoiceNumber\": null,\r\n"
							+ "    \"transactionDate\": null,\r\n"
							+ "    \"disbursementBatchPropertySetting\": [],\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEAM2YbW/aMBDHv0qV9yXhoQ9CgMRTJTRaKsiqvXWdC7k1tjP7Upp9+jlhWyut2USTMFAUXpjc/+fz2f8jg7HWLFuFnyB7YHEKq9CQRrllMvOzBM5eRCzN0ImIkr7rGh6BYKYlkGtlVEgtroTb8byu2/bcDWhkMX5nhEq6RWDj7CP08XeM3W7X2nVbSm/zB9vul9vlpgh7jtIQkxyc0aAEpxgYLYKBm38Pip+cYZ/s0NBhfZT0S4/9W88Z9S69gVsEGRURSyXLWcZbkDybaMsd/cElMR46pFNw3I8LCJVKGieJVs9QNvEAOAoWHzT5C89reZXnP2HEoz3jybFNmUhSU1u1XFTmUUIouUQJ07zM43fTVkfNvArNIESOdBQlYhivgSsdmEaV7oBmaB6PMCerNA+PkTwrdKfkPPSPoLUGNCaF5pQ0MIJgZm8+Cig7FX4OH7QDO16nc+5dn7evfO+63+70u5dV9+Q8QNoQ09Qwa89erXb3qirvDZu/JErTQuT3G4yhEdd5DT9VQVle9s8dkpUKQPKzgUlmlyoMazvRuxfVTWZhCgtcKv5Uas+PSsXA5EFs+QLWxLZKQJ4c2QwSZZCsYQCWNzYf4QtZbOoE/JaiPkXA+QtpxukU0VZPvrpXpqwl/H9Vt4YwlcFUI+X/VaYR1Lxra8rfhtIAJJmZVklyeoBLZuhWBRjiUXy+Lu98i23dRJ+UjyxBBjUiVea5S8Uj6FWYt9qpNiDyeqwJrlMV7p5pi/MWrTC6Rlqh/ByDYJK9WzH1CeT7qIHga3hG2JUeISaybd5xC2utdg+gDarSnoQZuOxNUDKdHYQ2Lj7mK9fesCqlH6EObJlRtpDPCjns90MDK+RrJo31cZuQj9eA+/fXeKMfllQ+WecTAAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 3,\r\n"
							+ "    \"EditStartTime\": null\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL1")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Approve Disbursements is posted successfully");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Approve Disbursements is failed");
			}
		}


		@Test(priority=4)
		public String CreateFADisbursements_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"campusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"awardYearList\": [\r\n"
							+ "      \""+data.get("AwardYear1")+"\",\r\n"
							+ "      \""+data.get("AwardYear2")+"\",\r\n"
							+ "      \""+data.get("AwardYear3")+"\",\r\n"
							+ "      \""+data.get("AwardYear4")+"\"\r\n"
							+ "    ],\r\n"
							+ "    \"fundSourceType\": \"-1\",\r\n"
							+ "    \"disbursementFrom\": \""+data.get("DisbursementStartDate")+" 00:00:00\",\r\n"
							+ "    \"disbursementTo\": \""+data.get("DisbursementEndDate")+" 00:00:00\",\r\n"
							+ "    \"originationStatus\": 0,\r\n"
							+ "    \"isPromissoryNotesAcceptedLoanIncluded\": 0,\r\n"
							+ "    \"fundSourceList\": [\r\n"
							+ "      811,\r\n"
							+ "      219,\r\n"
							+ "      637,\r\n"
							+ "      837,\r\n"
							+ "      383,\r\n"
							+ "      584,\r\n"
							+ "      543,\r\n"
							+ "      433,\r\n"
							+ "      823,\r\n"
							+ "      289,\r\n"
							+ "      257,\r\n"
							+ "      558,\r\n"
							+ "      334,\r\n"
							+ "      660,\r\n"
							+ "      399,\r\n"
							+ "      765,\r\n"
							+ "      780,\r\n"
							+ "      487,\r\n"
							+ "      601,\r\n"
							+ "      428,\r\n"
							+ "      688,\r\n"
							+ "      390,\r\n"
							+ "      828,\r\n"
							+ "      827,\r\n"
							+ "      829,\r\n"
							+ "      832,\r\n"
							+ "      394,\r\n"
							+ "      699,\r\n"
							+ "      754,\r\n"
							+ "      680,\r\n"
							+ "      477,\r\n"
							+ "      761,\r\n"
							+ "      503,\r\n"
							+ "      288,\r\n"
							+ "      346,\r\n"
							+ "      329,\r\n"
							+ "      328,\r\n"
							+ "      641,\r\n"
							+ "      327,\r\n"
							+ "      413,\r\n"
							+ "      779,\r\n"
							+ "      774,\r\n"
							+ "      719,\r\n"
							+ "      775,\r\n"
							+ "      776,\r\n"
							+ "      591,\r\n"
							+ "      697,\r\n"
							+ "      524,\r\n"
							+ "      348,\r\n"
							+ "      706,\r\n"
							+ "      278,\r\n"
							+ "      275,\r\n"
							+ "      534,\r\n"
							+ "      259,\r\n"
							+ "      244,\r\n"
							+ "      443,\r\n"
							+ "      538,\r\n"
							+ "      272,\r\n"
							+ "      338,\r\n"
							+ "      801,\r\n"
							+ "      347,\r\n"
							+ "      553,\r\n"
							+ "      717,\r\n"
							+ "      552,\r\n"
							+ "      322,\r\n"
							+ "      467,\r\n"
							+ "      743,\r\n"
							+ "      515,\r\n"
							+ "      554,\r\n"
							+ "      236,\r\n"
							+ "      692,\r\n"
							+ "      768,\r\n"
							+ "      752,\r\n"
							+ "      713,\r\n"
							+ "      821,\r\n"
							+ "      208,\r\n"
							+ "      830,\r\n"
							+ "      831,\r\n"
							+ "      835,\r\n"
							+ "      771,\r\n"
							+ "      283,\r\n"
							+ "      583,\r\n"
							+ "      471,\r\n"
							+ "      436,\r\n"
							+ "      625,\r\n"
							+ "      449,\r\n"
							+ "      631,\r\n"
							+ "      403,\r\n"
							+ "      371,\r\n"
							+ "      507,\r\n"
							+ "      547,\r\n"
							+ "      674,\r\n"
							+ "      608,\r\n"
							+ "      557,\r\n"
							+ "      532,\r\n"
							+ "      773,\r\n"
							+ "      724,\r\n"
							+ "      243,\r\n"
							+ "      824,\r\n"
							+ "      517,\r\n"
							+ "      420,\r\n"
							+ "      654,\r\n"
							+ "      499,\r\n"
							+ "      657,\r\n"
							+ "      732,\r\n"
							+ "      781,\r\n"
							+ "      241,\r\n"
							+ "      356,\r\n"
							+ "      454,\r\n"
							+ "      663,\r\n"
							+ "      731,\r\n"
							+ "      238,\r\n"
							+ "      764,\r\n"
							+ "      335,\r\n"
							+ "      237,\r\n"
							+ "      247,\r\n"
							+ "      540,\r\n"
							+ "      519,\r\n"
							+ "      308,\r\n"
							+ "      277,\r\n"
							+ "      681,\r\n"
							+ "      506,\r\n"
							+ "      462,\r\n"
							+ "      452,\r\n"
							+ "      432,\r\n"
							+ "      274,\r\n"
							+ "      429,\r\n"
							+ "      437,\r\n"
							+ "      802,\r\n"
							+ "      594,\r\n"
							+ "      819,\r\n"
							+ "      815,\r\n"
							+ "      820,\r\n"
							+ "      4,\r\n"
							+ "      814,\r\n"
							+ "      2,\r\n"
							+ "      3,\r\n"
							+ "      337,\r\n"
							+ "      573,\r\n"
							+ "      603,\r\n"
							+ "      794,\r\n"
							+ "      482,\r\n"
							+ "      728,\r\n"
							+ "      520,\r\n"
							+ "      466,\r\n"
							+ "      560,\r\n"
							+ "      461,\r\n"
							+ "      411,\r\n"
							+ "      378,\r\n"
							+ "      478,\r\n"
							+ "      426,\r\n"
							+ "      536,\r\n"
							+ "      344,\r\n"
							+ "      270,\r\n"
							+ "      386,\r\n"
							+ "      325,\r\n"
							+ "      671,\r\n"
							+ "      412,\r\n"
							+ "      518,\r\n"
							+ "      445,\r\n"
							+ "      351,\r\n"
							+ "      544,\r\n"
							+ "      563,\r\n"
							+ "      353,\r\n"
							+ "      559,\r\n"
							+ "      430,\r\n"
							+ "      769,\r\n"
							+ "      620,\r\n"
							+ "      521,\r\n"
							+ "      350,\r\n"
							+ "      745,\r\n"
							+ "      840,\r\n"
							+ "      5,\r\n"
							+ "      20,\r\n"
							+ "      6,\r\n"
							+ "      574,\r\n"
							+ "      204,\r\n"
							+ "      131,\r\n"
							+ "      721,\r\n"
							+ "      589,\r\n"
							+ "      624,\r\n"
							+ "      822,\r\n"
							+ "      751,\r\n"
							+ "      141,\r\n"
							+ "      143,\r\n"
							+ "      144,\r\n"
							+ "      145,\r\n"
							+ "      146,\r\n"
							+ "      147,\r\n"
							+ "      148,\r\n"
							+ "      132,\r\n"
							+ "      149,\r\n"
							+ "      150,\r\n"
							+ "      151,\r\n"
							+ "      757,\r\n"
							+ "      152,\r\n"
							+ "      153,\r\n"
							+ "      154,\r\n"
							+ "      133,\r\n"
							+ "      134,\r\n"
							+ "      155,\r\n"
							+ "      156,\r\n"
							+ "      158,\r\n"
							+ "      157,\r\n"
							+ "      142,\r\n"
							+ "      159,\r\n"
							+ "      160,\r\n"
							+ "      161,\r\n"
							+ "      162,\r\n"
							+ "      163,\r\n"
							+ "      164,\r\n"
							+ "      165,\r\n"
							+ "      166,\r\n"
							+ "      223,\r\n"
							+ "      167,\r\n"
							+ "      168,\r\n"
							+ "      169,\r\n"
							+ "      170,\r\n"
							+ "      27,\r\n"
							+ "      171,\r\n"
							+ "      172,\r\n"
							+ "      173,\r\n"
							+ "      100,\r\n"
							+ "      101,\r\n"
							+ "      102,\r\n"
							+ "      103,\r\n"
							+ "      104,\r\n"
							+ "      105,\r\n"
							+ "      106,\r\n"
							+ "      180,\r\n"
							+ "      28,\r\n"
							+ "      98,\r\n"
							+ "      25,\r\n"
							+ "      99,\r\n"
							+ "      29,\r\n"
							+ "      181,\r\n"
							+ "      182,\r\n"
							+ "      120,\r\n"
							+ "      119,\r\n"
							+ "      107,\r\n"
							+ "      183,\r\n"
							+ "      184,\r\n"
							+ "      30,\r\n"
							+ "      220,\r\n"
							+ "      185,\r\n"
							+ "      186,\r\n"
							+ "      109,\r\n"
							+ "      174,\r\n"
							+ "      187,\r\n"
							+ "      800,\r\n"
							+ "      205,\r\n"
							+ "      108,\r\n"
							+ "      175,\r\n"
							+ "      214,\r\n"
							+ "      136,\r\n"
							+ "      188,\r\n"
							+ "      742,\r\n"
							+ "      206,\r\n"
							+ "      189,\r\n"
							+ "      225,\r\n"
							+ "      213,\r\n"
							+ "      224,\r\n"
							+ "      744,\r\n"
							+ "      190,\r\n"
							+ "      31,\r\n"
							+ "      110,\r\n"
							+ "      191,\r\n"
							+ "      192,\r\n"
							+ "      176,\r\n"
							+ "      177,\r\n"
							+ "      217,\r\n"
							+ "      212,\r\n"
							+ "      112,\r\n"
							+ "      113,\r\n"
							+ "      122,\r\n"
							+ "      111,\r\n"
							+ "      118,\r\n"
							+ "      116,\r\n"
							+ "      117,\r\n"
							+ "      115,\r\n"
							+ "      194,\r\n"
							+ "      26,\r\n"
							+ "      216,\r\n"
							+ "      195,\r\n"
							+ "      114,\r\n"
							+ "      121,\r\n"
							+ "      196,\r\n"
							+ "      197,\r\n"
							+ "      32,\r\n"
							+ "      126,\r\n"
							+ "      228,\r\n"
							+ "      198,\r\n"
							+ "      37,\r\n"
							+ "      123,\r\n"
							+ "      226,\r\n"
							+ "      34,\r\n"
							+ "      35,\r\n"
							+ "      33,\r\n"
							+ "      129,\r\n"
							+ "      125,\r\n"
							+ "      760,\r\n"
							+ "      199,\r\n"
							+ "      221,\r\n"
							+ "      200,\r\n"
							+ "      128,\r\n"
							+ "      130,\r\n"
							+ "      127,\r\n"
							+ "      222,\r\n"
							+ "      193,\r\n"
							+ "      201,\r\n"
							+ "      38,\r\n"
							+ "      39,\r\n"
							+ "      202,\r\n"
							+ "      203,\r\n"
							+ "      748,\r\n"
							+ "      218,\r\n"
							+ "      215,\r\n"
							+ "      135,\r\n"
							+ "      40,\r\n"
							+ "      137,\r\n"
							+ "      227,\r\n"
							+ "      178,\r\n"
							+ "      734,\r\n"
							+ "      179,\r\n"
							+ "      138,\r\n"
							+ "      139,\r\n"
							+ "      140,\r\n"
							+ "      750,\r\n"
							+ "      235,\r\n"
							+ "      649,\r\n"
							+ "      292,\r\n"
							+ "      710,\r\n"
							+ "      653,\r\n"
							+ "      588,\r\n"
							+ "      693,\r\n"
							+ "      418,\r\n"
							+ "      577,\r\n"
							+ "      561,\r\n"
							+ "      613,\r\n"
							+ "      647,\r\n"
							+ "      730,\r\n"
							+ "      598,\r\n"
							+ "      514,\r\n"
							+ "      785,\r\n"
							+ "      457,\r\n"
							+ "      684,\r\n"
							+ "      562,\r\n"
							+ "      245,\r\n"
							+ "      268,\r\n"
							+ "      267,\r\n"
							+ "      679,\r\n"
							+ "      310,\r\n"
							+ "      320,\r\n"
							+ "      529,\r\n"
							+ "      686,\r\n"
							+ "      727,\r\n"
							+ "      367,\r\n"
							+ "      455,\r\n"
							+ "      504,\r\n"
							+ "      404,\r\n"
							+ "      266,\r\n"
							+ "      271,\r\n"
							+ "      623,\r\n"
							+ "      317,\r\n"
							+ "      807,\r\n"
							+ "      566,\r\n"
							+ "      265,\r\n"
							+ "      299,\r\n"
							+ "      302,\r\n"
							+ "      795,\r\n"
							+ "      672,\r\n"
							+ "      658,\r\n"
							+ "      388,\r\n"
							+ "      606,\r\n"
							+ "      673,\r\n"
							+ "      381,\r\n"
							+ "      375,\r\n"
							+ "      799,\r\n"
							+ "      565,\r\n"
							+ "      354,\r\n"
							+ "      612,\r\n"
							+ "      330,\r\n"
							+ "      465,\r\n"
							+ "      632,\r\n"
							+ "      789,\r\n"
							+ "      609,\r\n"
							+ "      512,\r\n"
							+ "      392,\r\n"
							+ "      793,\r\n"
							+ "      599,\r\n"
							+ "      396,\r\n"
							+ "      548,\r\n"
							+ "      389,\r\n"
							+ "      376,\r\n"
							+ "      364,\r\n"
							+ "      541,\r\n"
							+ "      290,\r\n"
							+ "      634,\r\n"
							+ "      665,\r\n"
							+ "      254,\r\n"
							+ "      508,\r\n"
							+ "      256,\r\n"
							+ "      264,\r\n"
							+ "      617,\r\n"
							+ "      369,\r\n"
							+ "      669,\r\n"
							+ "      735,\r\n"
							+ "      53,\r\n"
							+ "      54,\r\n"
							+ "      55,\r\n"
							+ "      52,\r\n"
							+ "      763,\r\n"
							+ "      747,\r\n"
							+ "      61,\r\n"
							+ "      758,\r\n"
							+ "      759,\r\n"
							+ "      746,\r\n"
							+ "      74,\r\n"
							+ "      80,\r\n"
							+ "      64,\r\n"
							+ "      43,\r\n"
							+ "      44,\r\n"
							+ "      45,\r\n"
							+ "      48,\r\n"
							+ "      51,\r\n"
							+ "      46,\r\n"
							+ "      47,\r\n"
							+ "      49,\r\n"
							+ "      50,\r\n"
							+ "      76,\r\n"
							+ "      78,\r\n"
							+ "      57,\r\n"
							+ "      81,\r\n"
							+ "      83,\r\n"
							+ "      65,\r\n"
							+ "      90,\r\n"
							+ "      85,\r\n"
							+ "      93,\r\n"
							+ "      92,\r\n"
							+ "      84,\r\n"
							+ "      89,\r\n"
							+ "      97,\r\n"
							+ "      60,\r\n"
							+ "      56,\r\n"
							+ "      59,\r\n"
							+ "      62,\r\n"
							+ "      63,\r\n"
							+ "      58,\r\n"
							+ "      86,\r\n"
							+ "      87,\r\n"
							+ "      71,\r\n"
							+ "      72,\r\n"
							+ "      73,\r\n"
							+ "      70,\r\n"
							+ "      66,\r\n"
							+ "      67,\r\n"
							+ "      68,\r\n"
							+ "      69,\r\n"
							+ "      77,\r\n"
							+ "      96,\r\n"
							+ "      94,\r\n"
							+ "      88,\r\n"
							+ "      82,\r\n"
							+ "      79,\r\n"
							+ "      91,\r\n"
							+ "      75,\r\n"
							+ "      95,\r\n"
							+ "      207,\r\n"
							+ "      733,\r\n"
							+ "      42,\r\n"
							+ "      578,\r\n"
							+ "      497,\r\n"
							+ "      24,\r\n"
							+ "      297,\r\n"
							+ "      384,\r\n"
							+ "      358,\r\n"
							+ "      324,\r\n"
							+ "      481,\r\n"
							+ "      595,\r\n"
							+ "      459,\r\n"
							+ "      513,\r\n"
							+ "      300,\r\n"
							+ "      667,\r\n"
							+ "      279,\r\n"
							+ "      806,\r\n"
							+ "      490,\r\n"
							+ "      372,\r\n"
							+ "      602,\r\n"
							+ "      792,\r\n"
							+ "      579,\r\n"
							+ "      360,\r\n"
							+ "      439,\r\n"
							+ "      767,\r\n"
							+ "      726,\r\n"
							+ "      784,\r\n"
							+ "      473,\r\n"
							+ "      537,\r\n"
							+ "      359,\r\n"
							+ "      370,\r\n"
							+ "      405,\r\n"
							+ "      570,\r\n"
							+ "      725,\r\n"
							+ "      636,\r\n"
							+ "      326,\r\n"
							+ "      380,\r\n"
							+ "      786,\r\n"
							+ "      434,\r\n"
							+ "      451,\r\n"
							+ "      756,\r\n"
							+ "      528,\r\n"
							+ "      718,\r\n"
							+ "      690,\r\n"
							+ "      711,\r\n"
							+ "      772,\r\n"
							+ "      483,\r\n"
							+ "      516,\r\n"
							+ "      716,\r\n"
							+ "      619,\r\n"
							+ "      232,\r\n"
							+ "      533,\r\n"
							+ "      783,\r\n"
							+ "      556,\r\n"
							+ "      527,\r\n"
							+ "      472,\r\n"
							+ "      652,\r\n"
							+ "      427,\r\n"
							+ "      555,\r\n"
							+ "      605,\r\n"
							+ "      791,\r\n"
							+ "      423,\r\n"
							+ "      585,\r\n"
							+ "      610,\r\n"
							+ "      739,\r\n"
							+ "      511,\r\n"
							+ "      816,\r\n"
							+ "      666,\r\n"
							+ "      442,\r\n"
							+ "      468,\r\n"
							+ "      421,\r\n"
							+ "      510,\r\n"
							+ "      494,\r\n"
							+ "      670,\r\n"
							+ "      431,\r\n"
							+ "      414,\r\n"
							+ "      708,\r\n"
							+ "      352,\r\n"
							+ "      650,\r\n"
							+ "      260,\r\n"
							+ "      545,\r\n"
							+ "      705,\r\n"
							+ "      425,\r\n"
							+ "      770,\r\n"
							+ "      509,\r\n"
							+ "      298,\r\n"
							+ "      373,\r\n"
							+ "      546,\r\n"
							+ "      630,\r\n"
							+ "      797,\r\n"
							+ "      464,\r\n"
							+ "      523,\r\n"
							+ "      715,\r\n"
							+ "      323,\r\n"
							+ "      626,\r\n"
							+ "      677,\r\n"
							+ "      253,\r\n"
							+ "      287,\r\n"
							+ "      592,\r\n"
							+ "      269,\r\n"
							+ "      402,\r\n"
							+ "      818,\r\n"
							+ "      714,\r\n"
							+ "      251,\r\n"
							+ "      798,\r\n"
							+ "      581,\r\n"
							+ "      587,\r\n"
							+ "      349,\r\n"
							+ "      280,\r\n"
							+ "      709,\r\n"
							+ "      313,\r\n"
							+ "      285,\r\n"
							+ "      409,\r\n"
							+ "      551,\r\n"
							+ "      691,\r\n"
							+ "      355,\r\n"
							+ "      531,\r\n"
							+ "      314,\r\n"
							+ "      736,\r\n"
							+ "      295,\r\n"
							+ "      246,\r\n"
							+ "      291,\r\n"
							+ "      435,\r\n"
							+ "      491,\r\n"
							+ "      642,\r\n"
							+ "      319,\r\n"
							+ "      474,\r\n"
							+ "      493,\r\n"
							+ "      343,\r\n"
							+ "      231,\r\n"
							+ "      281,\r\n"
							+ "      616,\r\n"
							+ "      542,\r\n"
							+ "      590,\r\n"
							+ "      469,\r\n"
							+ "      211,\r\n"
							+ "      19,\r\n"
							+ "      621,\r\n"
							+ "      18,\r\n"
							+ "      393,\r\n"
							+ "      704,\r\n"
							+ "      239,\r\n"
							+ "      331,\r\n"
							+ "      333,\r\n"
							+ "      569,\r\n"
							+ "      488,\r\n"
							+ "      453,\r\n"
							+ "      229,\r\n"
							+ "      530,\r\n"
							+ "      377,\r\n"
							+ "      262,\r\n"
							+ "      597,\r\n"
							+ "      438,\r\n"
							+ "      525,\r\n"
							+ "      422,\r\n"
							+ "      646,\r\n"
							+ "      596,\r\n"
							+ "      486,\r\n"
							+ "      460,\r\n"
							+ "      808,\r\n"
							+ "      738,\r\n"
							+ "      1,\r\n"
							+ "      809,\r\n"
							+ "      401,\r\n"
							+ "      387,\r\n"
							+ "      332,\r\n"
							+ "      702,\r\n"
							+ "      701,\r\n"
							+ "      368,\r\n"
							+ "      415,\r\n"
							+ "      248,\r\n"
							+ "      233,\r\n"
							+ "      576,\r\n"
							+ "      629,\r\n"
							+ "      395,\r\n"
							+ "      296,\r\n"
							+ "      316,\r\n"
							+ "      683,\r\n"
							+ "      357,\r\n"
							+ "      385,\r\n"
							+ "      301,\r\n"
							+ "      645,\r\n"
							+ "      550,\r\n"
							+ "      790,\r\n"
							+ "      676,\r\n"
							+ "      255,\r\n"
							+ "      379,\r\n"
							+ "      21,\r\n"
							+ "      762,\r\n"
							+ "      276,\r\n"
							+ "      500,\r\n"
							+ "      778,\r\n"
							+ "      740,\r\n"
							+ "      341,\r\n"
							+ "      644,\r\n"
							+ "      476,\r\n"
							+ "      766,\r\n"
							+ "      419,\r\n"
							+ "      441,\r\n"
							+ "      572,\r\n"
							+ "      240,\r\n"
							+ "      614,\r\n"
							+ "      628,\r\n"
							+ "      505,\r\n"
							+ "      489,\r\n"
							+ "      712,\r\n"
							+ "      635,\r\n"
							+ "      336,\r\n"
							+ "      526,\r\n"
							+ "      722,\r\n"
							+ "      582,\r\n"
							+ "      362,\r\n"
							+ "      571,\r\n"
							+ "      309,\r\n"
							+ "      810,\r\n"
							+ "      567,\r\n"
							+ "      593,\r\n"
							+ "      682,\r\n"
							+ "      834,\r\n"
							+ "      841,\r\n"
							+ "      842,\r\n"
							+ "      440,\r\n"
							+ "      416,\r\n"
							+ "      492,\r\n"
							+ "      294,\r\n"
							+ "      703,\r\n"
							+ "      498,\r\n"
							+ "      458,\r\n"
							+ "      363,\r\n"
							+ "      600,\r\n"
							+ "      407,\r\n"
							+ "      659,\r\n"
							+ "      312,\r\n"
							+ "      242,\r\n"
							+ "      689,\r\n"
							+ "      782,\r\n"
							+ "      836,\r\n"
							+ "      456,\r\n"
							+ "      263,\r\n"
							+ "      664,\r\n"
							+ "      685,\r\n"
							+ "      615,\r\n"
							+ "      633,\r\n"
							+ "      318,\r\n"
							+ "      618,\r\n"
							+ "      304,\r\n"
							+ "      720,\r\n"
							+ "      796,\r\n"
							+ "      838,\r\n"
							+ "      408,\r\n"
							+ "      450,\r\n"
							+ "      788,\r\n"
							+ "      549,\r\n"
							+ "      668,\r\n"
							+ "      502,\r\n"
							+ "      258,\r\n"
							+ "      446,\r\n"
							+ "      656,\r\n"
							+ "      675,\r\n"
							+ "      22,\r\n"
							+ "      485,\r\n"
							+ "      252,\r\n"
							+ "      286,\r\n"
							+ "      586,\r\n"
							+ "      397,\r\n"
							+ "      406,\r\n"
							+ "      655,\r\n"
							+ "      365,\r\n"
							+ "      568,\r\n"
							+ "      391,\r\n"
							+ "      311,\r\n"
							+ "      495,\r\n"
							+ "      522,\r\n"
							+ "      261,\r\n"
							+ "      694,\r\n"
							+ "      306,\r\n"
							+ "      611,\r\n"
							+ "      463,\r\n"
							+ "      303,\r\n"
							+ "      678,\r\n"
							+ "      234,\r\n"
							+ "      284,\r\n"
							+ "      580,\r\n"
							+ "      753,\r\n"
							+ "      470,\r\n"
							+ "      305,\r\n"
							+ "      374,\r\n"
							+ "      417,\r\n"
							+ "      787,\r\n"
							+ "      662,\r\n"
							+ "      707,\r\n"
							+ "      10,\r\n"
							+ "      11,\r\n"
							+ "      17,\r\n"
							+ "      564,\r\n"
							+ "      447,\r\n"
							+ "      696,\r\n"
							+ "      687,\r\n"
							+ "      535,\r\n"
							+ "      833,\r\n"
							+ "      804,\r\n"
							+ "      282,\r\n"
							+ "      484,\r\n"
							+ "      639,\r\n"
							+ "      817,\r\n"
							+ "      410,\r\n"
							+ "      643,\r\n"
							+ "      345,\r\n"
							+ "      651,\r\n"
							+ "      607,\r\n"
							+ "      339,\r\n"
							+ "      448,\r\n"
							+ "      496,\r\n"
							+ "      361,\r\n"
							+ "      366,\r\n"
							+ "      321,\r\n"
							+ "      315,\r\n"
							+ "      737,\r\n"
							+ "      293,\r\n"
							+ "      398,\r\n"
							+ "      723,\r\n"
							+ "      382,\r\n"
							+ "      640,\r\n"
							+ "      250,\r\n"
							+ "      700,\r\n"
							+ "      501,\r\n"
							+ "      249,\r\n"
							+ "      230,\r\n"
							+ "      307,\r\n"
							+ "      604,\r\n"
							+ "      698,\r\n"
							+ "      695,\r\n"
							+ "      400,\r\n"
							+ "      273,\r\n"
							+ "      475,\r\n"
							+ "      480,\r\n"
							+ "      729,\r\n"
							+ "      424,\r\n"
							+ "      661,\r\n"
							+ "      622,\r\n"
							+ "      479,\r\n"
							+ "      755,\r\n"
							+ "      638,\r\n"
							+ "      627,\r\n"
							+ "      777,\r\n"
							+ "      14,\r\n"
							+ "      444,\r\n"
							+ "      575,\r\n"
							+ "      648\r\n"
							+ "    ],\r\n"
							+ "    \"lastNameCriteria\": \"\",\r\n"
							+ "    \"isBatchIntegrityEnforced\": true,\r\n"
							+ "    \"isReleasedCommonLineDisbursementExcluded\": 1,\r\n"
							+ "    \"IsInformedBorrowerIncluded\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String BatchID = path.getString("payload.data.batchId");
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Batch num is "+BatchID);		
			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Approve disbursement batch is created successfully");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Approve disbursement batch is failed");
			}
			return BatchID;
		}


		@Test(priority=4)
		public void AddEstimatedFAPackaging_API(StringHash data) throws IOException
		{	

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isDdVeteran\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"academicYearSequence\": "+data.get("academicYearSequence")+",\r\n"
							+ "    \"budgetId\": null,\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"enrollmentStatusId\": null,\r\n"
							+ "    \"estimatedCostOfAttendance\": "+data.get("estimatedCostOfAttendance")+",\r\n"
							+ "    \"estimatedEfcFirstAwardYear\": "+data.get("estimatedEfcFirstAwardYear")+",\r\n"
							+ "    \"firstAwardYear\": \""+data.get("firstAwardYear")+"\",\r\n"
							+ "    \"gradeLevelId\": null,\r\n"
							+ "    \"housingStatusCode\": \""+data.get("housingStatusCode")+"\",\r\n"
							+ "    \"hppaLevel\": \"N\",\r\n"
							+ "    \"isFirstTimeBorrower\": false,\r\n"
							+ "    \"isParentMarried\": false,\r\n"
							+ "    \"isStudentMarried\": false,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"model\": \"2\",\r\n"
							+ "    \"packagingMethodId\": null,\r\n"
							+ "    \"parentExemptions\": 0,\r\n"
							+ "    \"parentIncome\": 0,\r\n"
							+ "    \"parentIncomeTax\": 0,\r\n"
							+ "    \"parentLegalStateOfResidence\": null,\r\n"
							+ "    \"parentNumberInCollege\": 0,\r\n"
							+ "    \"parentNumberInFamily\": 0,\r\n"
							+ "    \"pellAmountFirstAwardYear\": 0,\r\n"
							+ "    \"pellAmountSecondAwardYear\": null,\r\n"
							+ "    \"printDate\": null,\r\n"
							+ "    \"programVersionId\": "+data.get("programVersionId")+",\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"startDate\": \""+data.get("startDate")+" 00:00:00\",\r\n"
							+ "    \"startDateCode\": \"\",\r\n"
							+ "    \"studentExemptions\": 0,\r\n"
							+ "    \"studentId\": "+data.get("StudentID")+",\r\n"
							+ "    \"studentIncome\": 0,\r\n"
							+ "    \"studentIncomeTax\": 0,\r\n"
							+ "    \"studentLegalStateOfResidence\": \"OR\",\r\n"
							+ "    \"studentNumberInCollege\": 1,\r\n"
							+ "    \"studentNumberInFamily\": 1,\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEALWU30+DQAzH/5WFdznm3ggjmb+iETITptHHBsrWhLvD9pDhXy8w49uMibnXNv1+vu31mmyYYdjWjzi8QNPhthbHZPZght3Q4uKoGyPr4OBcGysl5QE1SKipZCu2dmFptbqMopVaRqpAJmjoExxZo2ZhCU4KMf1o9H0f9qvQ8n4qXKrXPCtm2Qsy4sCUGKTJGTtzIs1AXG4rqgmrZ0F+qBI1xZO5ZEGxoWYdOO4wUOmcOqv1N8gNONyRRg8YL96vGUfHPm1vSqhw3II3BC7wvcPx2Txg7tsWMvzAxsfk5Y5Y3DSgK8tse2QvlCdgNC4H5nGTvBAK11VeEacWbo+o2+lriwfEdw//Zajfz1n6BcdvZXXvBAAA\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Estimated FA Packaging is successfully added to enrollment of student");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Estimated FA Packaging is not added to student");
			}
		}


		@Test(priority=1)
		public String CloseTasksByStaff_API(StringHash data) throws IOException
		{	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			String token1 =data.get("Token").toString();
			Response res = given()
					.header("Authorization","Basic "+token1)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isRequestFromMessage\": false,\r\n"
							+ "    \"taskStatusCode\": \""+data.get("taskStatusCode")+"\",\r\n"
							+ "    \"crmSuppressFlag\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"assignedToStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"attachments\": null,\r\n"
							+ "    \"attachmentsId\": null,\r\n"
							+ "    \"classSectionId\": null,\r\n"
							+ "    \"completedByStaffId\": 0,\r\n"
							+ "    \"createdByStaffId\": "+data.get("StaffID")+",\r\n"
							+ "    \"createdDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"emailSubject\": null,\r\n"
							+ "    \"employerContactId\": null,\r\n"
							+ "    \"employerId\": null,\r\n"
							+ "    \"employerJobId\": null,\r\n"
							+ "    \"isActivityNotViewed\": false,\r\n"
							+ "    \"lastModifiedDateTime\": \""+currentDate+"\",\r\n"
							+ "    \"lastModifiedUserId\": "+data.get("StaffID")+",\r\n"
							+ "    \"lockedByUserId\": null,\r\n"
							+ "    \"note\": \"\",\r\n"
							+ "    \"organizationContactId\": null,\r\n"
							+ "    \"organizationId\": null,\r\n"
							+ "    \"previouslyAssignedToStaffId\": null,\r\n"
							+ "    \"priority\": \""+data.get("Priority")+"\",\r\n"
							+ "    \"prospectInquiryId\": null,\r\n"
							+ "    \"reassignedDate\": null,\r\n"
							+ "    \"remindDate\": null,\r\n"
							+ "    \"resultText\": \"\",\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"sessionSyCampusId\": "+data.get("SessionSyCampusID")+",\r\n"
							+ "    \"sourceRecordId\": 0,\r\n"
							+ "    \"sourceSystem\": \"X\",\r\n"
							+ "    \"sourceTable\": \"\",\r\n"
							+ "    \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentID")+",\r\n"
							+ "    \"studentId\": "+data.get("StudentID")+",\r\n"
							+ "    \"subject\": \""+data.get("TaskTemplate")+"\",\r\n"
							+ "    \"taskDueDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskEndDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskResultId\": "+data.get("taskResultId")+",\r\n"
							+ "    \"taskStartDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusDate\": \""+currentDate+"\",\r\n"
							+ "    \"taskStatusId\": "+data.get("TaskStatusID")+",\r\n"
							+ "    \"taskTemplateId\": "+data.get("TaskTemplateID")+",\r\n"
							+ "    \"taskTypeId\": "+data.get("TaskTypeID")+",\r\n"
							+ "    \"templateTextFile\": \"\",\r\n"
							+ "    \"workflowInstanceIdentifier\": null,\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEALVVTUvDQBD9K5K72dbeShqoFkFsrTRRvK7JpB3cj7IzIV1/vUkq3iqCzHWHfe/tezOz2TIEHbfNI8RXbVrYNsQB3V67WMYjXJ2scbRIDszHuVJUHcBqSi1WwZNvOK28VTeTyUxNJ6qAgNrgp2b0To3AlJwR5viD0XVd2s1SH/bDxal626yLEfYaHbF2FSR5dkHOWMjXmnjja2wQ6heC8FBnajjPxitXOHdoFgmHFhKVj6WLWH8jWWmGEi0I0IhovwvQK5aU/eRZArbwbaigiMRgJXzx9migd+Y2FqybRsT8UtPHDqg1LAMP/RuGYOHE92gkUjirHwjEIt5B5UMtYtCZoNTvIt48B/QBOQo1zqqFYWqF0Pum55bECURiXRLh3kFdernR/d6b/9wO6vcvNf8CjMk0+3MHAAA=\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0,\r\n"
							+ "    \"CompletedByStaffId\": "+data.get("StaffID")+"\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("EndPointURL")+"");

			int code = res.getStatusCode();	
			String responseBody = res.getBody().asString();
			JsonPath path = new JsonPath(responseBody);
			String taskID = path.getString("payload.data.id");	
			TestReportsLog.log(LogStatus.INFO, "Status Code is "+code);
			TestReportsLog.log(LogStatus.INFO, "Response Body "+res.getBody().asString());
			TestReportsLog.log(LogStatus.INFO, "Task iD "+taskID);

			if(code==200) {
				TestReportsLog.log(LogStatus.PASS, "Task Template is successfully Closed by Staff");
			}	
			else {
				TestReportsLog.log(LogStatus.FAIL, "Task Template is not closed by Staff");
			}

			return taskID;
		}
		
		
		//Test 1 - Place students into an intern ship Position
		@Test(priority=1)
		public void PlacestudentsintoanexternshipPosition(StringHash data) throws Exception {
			
			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"PlacementID\": 0,\r\n"
							+ "    \"Descrip\": \"\",\r\n"
							+ "    \"PlStudentID\":"+data.get("PlStudentID")+",\r\n"
							+ "    \"EmployerID\": "+data.get("EmployerID")+",\r\n"
							+ "    \"JobID\": 0,\r\n"
							+ "    \"PlRepID\": 0,\r\n"
							+ "    \"UserID\":"+data.get("UserID")+",\r\n"
							+ "    \"Supervisor\": \"\",\r\n"
							+ "    \"Comment\": \"\",\r\n"
							+ "    \"HowPlacedId\":"+data.get("HowPlacedId")+",\r\n"
							+ "    \"SalaryType\": \"\",\r\n"
							+ "    \"Salary\": 0,\r\n"
							+ "    \"InFieldOfStudy\": \""+data.get("InFieldOfStudy")+"\",\r\n"
							+ "    \"FromInterview\": true,\r\n"
							+ "    \"Benefits\": false,\r\n"
							+ "    \"Fee\": false,\r\n"
							+ "    \"JobSchedule\": \""+data.get("JobSchedule")+"\",\r\n"
							+ "    \"Current\": true,\r\n"
							+ "    \"SchedFrom\": \"\",\r\n"
							+ "    \"SchedTo\": \"\",\r\n"
							+ "    \"EndDate\": \""+data.get("EndDate")+"\",\r\n"
							+ "    \"JobTypeID\": "+data.get("JobTypeID")+",\r\n"
							+ "    \"DatePlaced\": \""+data.get("DatePlaced")+"\",\r\n"
							+ "    \"StartDate\": \""+data.get("StartDate")+"\",\r\n"
							+ "    \"PlJobTitleID\": "+data.get("PlJobTitleID")+",\r\n"
							+ "    \"PlacementStatusID\": 0,\r\n"
							+ "    \"PlJobSourceID\": 0,\r\n"
							+ "    \"SupervisorPhone\": \"\",\r\n"
							+ "    \"EnrollSchID\": 0,\r\n"
							+ "    \"ExactJobTitle\": \"\",\r\n"
							+ "    \"PlJobCategoryID\": 0,\r\n"
							+ "    \"TermDate\": \""+data.get("TermDate")+"\",\r\n"
							+ "    \"TermReason\": \"\",\r\n"
							+ "    \"Converted\": 0,\r\n"
							+ "    \"Status\": \""+data.get("Status")+"\",\r\n"
							+ "    \"OldPlacementID\": 0\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");
						
			int StatusCode = res.getStatusCode();
			
			String Statusline = res.getStatusLine();
			
			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
			
			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
			
			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
			
			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Placement records were successfully saved");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Placement records Not Saved successfully");
				
			}
			
	  }
		
	//Test 2 - Ability to add a course section	
		
		@Test(priority=2)
		public void Abilitytoaddacoursesection(StringHash data) throws Exception {
			
			String token = ""+data.get("Token")+"";
			Response res = given()
					.header("Authorization","Basic "+token)
					.body("{\r\n"
							+ "  \"payload\": {\r\n"
							+ "    \"isUpdateStudentSchedules\": false,\r\n"
							+ "    \"isUpdateStudentSchedulesConfirmation\": false,\r\n"
							+ "    \"isUpdateStudentSchedulesConfirmationProvided\": false,\r\n"
							+ "    \"isSchedulePeriodDeleteConfirmation\": false,\r\n"
							+ "    \"cantDeleteTerms\": null,\r\n"
							+ "    \"updateStudentsInCourseSection\": false,\r\n"
							+ "    \"scheduleStartDate\": null,\r\n"
							+ "    \"scheduleEndDate\": null,\r\n"
							+ "    \"crsgCrossReferenceCampuses\": [],\r\n"
							+ "    \"isContactHoursConfirmed\": false,\r\n"
							+ "    \"isRequireLDAConfirmed\": false,\r\n"
							+ "    \"requireContactHoursConfirmation\": false,\r\n"
							+ "    \"requireLDAConfirmation\": false,\r\n"
							+ "    \"isRequireChangeInWlmAssignment\": false,\r\n"
							+ "    \"id\": -1,\r\n"
							+ "    \"addDropDate\": null,\r\n"
							+ "    \"addedClassSectionId\": 0,\r\n"
							+ "    \"allowCreditsHoursOverride\": false,\r\n"
							+ "    \"allowReservations\": false,\r\n"
							+ "    \"attendanceLastPostedDate\": null,\r\n"
							+ "    \"autoDropConsecutiveHoursAbsent\": null,\r\n"
							+ "    \"autoDropCumulativeHoursAbsent\": null,\r\n"
							+ "    \"autoDropPercentageHoursAbsent\": null,\r\n"
							+ "    \"autoWarningConsecutiveHoursAbsent\": null,\r\n"
							+ "    \"autoWarningCumulativeHoursAbsent\": null,\r\n"
							+ "    \"autoWarningPercentageHoursAbsent\": null,\r\n"
							+ "    \"campusId\": "+data.get("CampusId")+",\r\n"
							+ "    \"classSchedLength\": 0,\r\n"
							+ "    \"clockHours\": null,\r\n"
							+ "    \"courseCode\": "+data.get("CourseCode")+",\r\n"
							+ "    \"courseId\": "+data.get("CourseId")+",\r\n"
							+ "    \"createdDateTime\": \"2022/08/10 03:57:25\",\r\n"
							+ "    \"creditHours\": null,\r\n"
							+ "    \"daysFlag\": 0,\r\n"
							+ "    \"deliveryMethodId\": "+data.get("deliveryMethodId")+",\r\n"
							+ "    \"dropEndDate\": null,\r\n"
							+ "    \"endDate\": \""+data.get("EndDate")+"\",\r\n"
							+ "    \"enrollmentStatusClockHours\": 0,\r\n"
							+ "    \"enrollmentStatusCreditHours\": 0,\r\n"
							+ "    \"finalCountDropStudents\": 0,\r\n"
							+ "    \"finalCountRegisteredStudents\": 0,\r\n"
							+ "    \"hideFaculty\": false,\r\n"
							+ "    \"hideLocation\": false,\r\n"
							+ "    \"instructorId\": "+data.get("instructorId")+",\r\n"
							+ "    \"isActive\": true,\r\n"
							+ "    \"isAddDropDateOverride\": false,\r\n"
							+ "    \"isAuditAdvisementRequired\": false,\r\n"
							+ "    \"isAutoDropEnforcedAfterLdw\": false,\r\n"
							+ "    \"isAutoWarningOnClassRosterAfterLdw\": false,\r\n"
							+ "    \"isBlindGrading\": false,\r\n"
							+ "    \"isCancelled\": false,\r\n"
							+ "    \"isClassSectionAutoAdded\": false,\r\n"
							+ "    \"isLdwOverride\": false,\r\n"
							+ "    \"isMeetingOnIrregularDaysTimes\": false,\r\n"
							+ "    \"isStudentSpecificMeetingSchedule\": false,\r\n"
							+ "    \"isWaitlistExpiredOrCleared\": false,\r\n"
							+ "    \"isWaitListingAllowed\": false,\r\n"
							+ "    \"lastDayToWithdrawDate\": null,\r\n"
							+ "    \"lastModifiedDateTime\": \"2022/08/10 03:57:25\",\r\n"
							+ "    \"lastModifiedUserId\": 0,\r\n"
							+ "    \"lmsExtractStatus\": \""+data.get("lmsExtractStatus")+"\",\r\n"
							+ "    \"lmsVendorId\": "+data.get("lmsVendorId")+",\r\n"
							+ "    \"loadMethod\": null,\r\n"
							+ "    \"makeUpMaxType\": null,\r\n"
							+ "    \"makeUpMaxValue\": null,\r\n"
							+ "    \"maximumCredits\": null,\r\n"
							+ "    \"maximumStudents\": "+data.get("maximumStudents")+",\r\n"
							+ "    \"maxNumberAssignments\": null,\r\n"
							+ "    \"maxNumberSectionsAllowed\": "+data.get("maxNumberSectionsAllowed")+",\r\n"
							+ "    \"minimumCredits\": null,\r\n"
							+ "    \"nextAttendanceDate\": null,\r\n"
							+ "    \"note\": \"\",\r\n"
							+ "    \"numberRegisteredStudents\": 0,\r\n"
							+ "    \"passFailSetting\": "+data.get("passFailSetting")+",\r\n"
							+ "    \"postAttendanceType\": \"A\",\r\n"
							+ "    \"rowVersion\": null,\r\n"
							+ "    \"secondSectionCode\": null,\r\n"
							+ "    \"sectionCode\": \""+SectionCode+"\",\r\n"
							+ "    \"sectionName\": \""+data.get("sectionName")+"\",\r\n"
							+ "    \"sendToLms\": false,\r\n"
							+ "    \"shiftId\": null,\r\n"
							+ "    \"startDate\": \""+data.get("StartDate")+"\",\r\n"
							+ "    \"startTime\": null,\r\n"
							+ "    \"studentSpecificMeetingScheduleDefaultMinutes\": 0,\r\n"
							+ "    \"syllabusDocument\": \"\",\r\n"
							+ "    \"thresholdNumberOfSeats\": null,\r\n"
							+ "    \"thresholdType\": null,\r\n"
							+ "    \"unregisterEndDate\": null,\r\n"
							+ "    \"waitListMaximumSeats\": 0,\r\n"
							+ "    \"wlmActivityTypeId\": null,\r\n"
							+ "    \"wlmAssignmentTypeId\": null,\r\n"
							+ "    \"wlmDepartmentId\": null,\r\n"
							+ "    \"meetingPatterns\": [],\r\n"
							+ "    \"terms\": [\r\n"
							+ "      {\r\n"
							+ "        \"termId\": "+data.get("termId")+",\r\n"
							+ "        \"classSectionId\": "+data.get("classSectionId")+",\r\n"
							+ "        \"id\": -1,\r\n"
							+ "        \"entityState\": 0\r\n"
							+ "      }\r\n"
							+ "    ],\r\n"
							+ "    \"originalState\": \"H4sIAAAAAAAEAL1Y224TMRD9lSrvZFv6VqWRllxoxKZB2UJ5ndqzqSWvHexxLnw9YycFXlohpOHV1s6Z2zkz3lEdAhxX3Sc8fgWbcNVFCsZtwB0fjlu8OPTWxdvBM9H2pqqiesYe4rA3KvjoOxoq31fvLy+vq6vLqsVgwJofQMa7qhiOg5OFG/PLxn6/H+6vhz5s8odX1bdl0xaz74yLBE7hYDx6xZ1yMW4g0tJr0xnUXyKGhR5V+XxUPrkwN87Y2wGFhINqXK5etfV3IFMgfDA9CsCI+D4JyB5Lul1rjXpiIcYWVS63SBy1tX7PwWhD8c6nEFc7DMFokYgy1hq5nXalf6NEXaDfpihT8lIL5pFu0G3oWQIiVwAnXiT9J+MiqZmyDM0tbARMz40Dy647mga/bSlpdCTROb+B1rgxkZBJIQh3xxybg0qWjkLWG68KzSQklcdISIq8zGBYxJoVbycyDCLrau6krNyCWsc4iTW11jsTscfcVN+T4ZYSwiKfg5q5zgeFuu64fRu9FwN7hOD4ZuWKKK59poso6AdrnP4YQPOVCMCfkzZHWMavCBKnSLTxlohUarMIATfJQsjynLcUCR1bxLNItltUvMqpM3wZlMnKhPgIhixr9OywzZxahYlFkCJXBmsYjG/KBiMC0/RxdqAAiloCShKVWsLB9KkXnGmMcJ/6JwxnHkW5fN17kmitk/v/ZQH4zKJZE6HT+UGWzwVAzoUQ2ijP1u9B5AHUcmoePBNDwvabmjXFDngxWxqXSEQ026O18JTi1KuUlwMBiBfVemE9P1f/MZLq7f8X45/gkO4d4BAAAA==\",\r\n"
							+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
							+ "    \"extendedProperties\": [],\r\n"
							+ "    \"entityState\": 0,\r\n"
							+ "    \"instructorShowAll\": false,\r\n"
							+ "    \"scheduledHours\": null,\r\n"
							+ "    \"contactHours\": null\r\n"
							+ "  }\r\n"
							+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");
						
			int StatusCode = res.getStatusCode();
			
			String Statusline = res.getStatusLine();
			
			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
			
			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
			
			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
			
			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Documents & LMS Options records were successfully saved.");
			}
			else {
				TestReportsLog.log(LogStatus.FAIL, "The Documents & LMS Options records Not saved.");
				
			}
			
	  }
			
	//Test 3 - Copy Class Schedule.
			@Test(priority=4)
			public void CopyClassSchedule(StringHash data) throws Exception {
				
				String token = ""+data.get("Token")+"";
				Response res = given()
						.header("Authorization","Basic "+token)
						.body("{\r\n"
								+ "  \"payload\": {\r\n"
								+ "    \"SourceTermId\": 0,\r\n"
								+ "    \"Id\": "+data.get("ID")+",\r\n"
								+ "    \"NewSectionCode\": \""+data.get("NewSectionCode")+"\",\r\n"
								+ "    \"CourseId\": "+data.get("CourseId")+",\r\n"
								+ "    \"CampusId\": "+data.get("CampusId")+",\r\n"
								+ "    \"TargetTermID\": 0,\r\n"
								+ "    \"IsCopyHideFaculty\": true,\r\n"
								+ "    \"IsCopyHideLocation\": true,\r\n"
								+ "    \"IsCopyAttendanceRules\": true,\r\n"
								+ "    \"IsCopyDays\": true,\r\n"
								+ "    \"IsCopyGradeBook\": true,\r\n"
								+ "    \"IsCopySecondaryInstructor\": true,\r\n"
								+ "    \"IsCopyRooms\": true,\r\n"
								+ "    \"IsCopyTimes\": true,\r\n"
								+ "    \"IsCopyInstructor\": true,\r\n"
								+ "    \"IsCopyWaitList\": true,\r\n"
								+ "    \"IsCopyLmsVendor\": false,\r\n"
								+ "    \"IsCopyCourseFeeSchedule\": true,\r\n"
								+ "    \"IsCopyCourseSharingCampuses\": true,\r\n"
								+ "    \"IsCopyMaxCourseSections\": true,\r\n"
								+ "    \"IsCopyBookList\": true,\r\n"
								+ "    \"IsCopyDocuments\": true,\r\n"
								+ "    \"IsVariableCredits\": true,\r\n"
								+ "    \"IsInstructorAttributes\": true,\r\n"
								+ "    \"isValidationMessageDisplayed\": false,\r\n"
								+ "    \"IsOnlyValidation\": false,\r\n"
								+ "    \"ExtendedPropertyList\": []\r\n"
								+ "  }\r\n"
								+ "}")
						.when().contentType(ContentType.JSON)
						.post(""+data.get("URI")+"");
							
				int StatusCode = res.getStatusCode();
				
				String Statusline = res.getStatusLine();
				
				TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
				
				TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
				
				TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
				
				if(StatusCode==200) {
					TestReportsLog.log(LogStatus.PASS, "The class schedule records were successfully copied.");
				}
				else {
					TestReportsLog.log(LogStatus.FAIL, "The class schedule records Not copied.");
					
				}
				
		  }

	//Test 4 - Add an Enrollment for a Student
			@Test(priority=5)
			public void Addanenrollmentforastudent(StringHash data) throws Exception {
						
				String token = ""+data.get("Token")+"";
				Response res = given()
						 .header("Authorization","Basic "+token)
						 .body("{\r\n"
								  + "  \"payload\": {\r\n"
								  + "    \"IsDegreeProgramType\": true,\r\n"
								  + "    \"IsGraduationDateChanged\": false,\r\n"
								  + "    \"ProgramVersionAreaOfStudyConfigList\": null,\r\n"
								  + "    \"PreviousProgramVersionId\": 0,\r\n"
								  + "    \"PreviousStudentEnrollmentPeriodId\": 0,\r\n"
								  + "    \"entity\": {\r\n"
								  + "      \"isExcludedCrmIntegration\": false,\r\n"
								  + "      \"statusColor\": null,\r\n"
								  + "      \"systemStatusCategory\": null,\r\n"
								  + "      \"registeredCreditHours\": null,\r\n"
								  + "      \"registeredClockHours\": null,\r\n"
								  + "      \"nsldsStatusName\": null,\r\n"
								  + "      \"isLastStatusTransfer\": null,\r\n"
								  + "      \"isTermAggregateRegisteredCredits\": null,\r\n"
								  + "      \"previousTransferStudentEnrollmentPeriodId\": null,\r\n"
								  + "      \"previousSchoolStatusId\": 0,\r\n"
								  + "      \"studentAdvisorList\": [\r\n"
								  + "        {\r\n"
								  + "          \"AdvisorType\": \""+data.get("AdvisorType")+"\",\r\n"
								  + "          \"AdvisorName\": \""+data.get("AdvisorName")+"\",\r\n"
								  + "          \"StaffId\": "+data.get("StaffId")+",\r\n"
								  + "          \"StaffGroupId\": "+data.get("StaffGroupId")+",\r\n"
								  + "          \"GroupName\": \""+data.get("GroupName")+"\",\r\n"
								  + "          \"Code\": \""+data.get("Code")+"\",\r\n"
								  + "          \"Id\": 0\r\n"
								  + "        },\r\n"
								  + "        {\r\n"
								  + "          \"AdvisorType\": \""+data.get("AdvisorType")+"\",\r\n"
								  + "          \"AdvisorName\": \""+data.get("AdvisorName")+"\",\r\n"
								  + "          \"StaffId\": "+data.get("StaffId")+",\r\n"
								  + "          \"StaffGroupId\": "+data.get("StaffGroupId")+",\r\n"
								  + "          \"GroupName\": \""+data.get("GroupName")+"\",\r\n"
								  + "          \"Code\": \""+data.get("Code")+"\",\r\n"
								  + "          \"Id\": 0\r\n"
								  + "        }\r\n"
								  + "      ],\r\n"
								  + "      \"academicAdvisor\": {\r\n"
								  + "        \"id\": 0,\r\n"
								  + "        \"studentId\": 0,\r\n"
								  + "        \"staffGroupId\": 0,\r\n"
								  + "        \"studentEnrollmentPeriodId\": 0,\r\n"
								  + "        \"advisorModule\": null,\r\n"
								  + "        \"createdDateTime\": \"0001/01/01 00:00:00\",\r\n"
								  + "        \"lastModifiedDateTime\": \"0001/01/01 00:00:00\",\r\n"
								  + "        \"lastModifiedUserId\": 0,\r\n"
								  + "        \"rowVersion\": null,\r\n"
								  + "        \"staffId\": 0,\r\n"
								  + "        \"originalState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "        \"extendedProperties\": [],\r\n"
								  + "        \"entityState\": 0\r\n"
								  + "      },\r\n"
								  + "      \"isBatchCatalogAssignment\": false,\r\n"
								  + "      \"isUpdateStudentEnrollmentPeriod\": false,\r\n"
								  + "      \"message\": null,\r\n"
								  + "      \"isDocumentDelete\": false,\r\n"
								  + "      \"id\": -1,\r\n"
								  + "      \"academicAdvisorId\": null,\r\n"
								  + "      \"accountReceivableBalance\": 0,\r\n"
								  + "      \"actualStartDate\": null,\r\n"
								  + "      \"admissionsRegionId\": null,\r\n"
								  + "      \"agencyBranchId\": null,\r\n"
								  + "      \"aosTransferDate\": null,\r\n"
								  + "      \"applicantProgress\": 0,\r\n"
								  + "      \"applicantTypeId\": null,\r\n"
								  + "      \"applicationReceivedDate\": \""+data.get("applicationReceivedDate")+"\",\r\n"
								  + "      \"assignedAdmissionsRepId\": "+data.get("assignedAdmissionsRepId")+",\r\n"
								  + "      \"autoChargesTermId\": null,\r\n"
								  + "      \"billedDate\": null,\r\n"
								  + "      \"billingMethodId\": "+data.get("billingMethodId")+",\r\n"
								  + "      \"campusId\": "+data.get("CampusId")+",\r\n"
								  + "      \"catalogYearId\": "+data.get("catalogYearId")+",\r\n"
								  + "      \"clockHoursAttempted\": 0,\r\n"
								  + "      \"clockHoursEarned\": 0,\r\n"
								  + "      \"clockHoursRequired\": 0,\r\n"
								  + "      \"clockHoursScheduled\": 0,\r\n"
								  + "      \"coreCreditHoursAttempted\": null,\r\n"
								  + "      \"coreCreditHoursEarned\": null,\r\n"
								  + "      \"coreGpa\": null,\r\n"
								  + "      \"coreNumericAvg\": null,\r\n"
								  + "      \"createdDateTime\": \""+data.get("applicationReceivedDate")+"\",\r\n"
								  + "      \"creditHoursAttempted\": 0,\r\n"
								  + "      \"creditHoursEarned\": 0,\r\n"
								  + "      \"creditHoursRequired\": 0,\r\n"
								  + "      \"creditHoursScheduled\": 0,\r\n"
								  + "      \"cumGpaPoints\": null,\r\n"
								  + "      \"daysAbsent\": 0,\r\n"
								  + "      \"degreeAudit\": \"\",\r\n"
								  + "      \"dropDate\": null,\r\n"
								  + "      \"dropEarn\": 0,\r\n"
								  + "      \"dropType\": null,\r\n"
								  + "      \"enrollmentDate\": \""+data.get("applicationReceivedDate")+"\",\r\n"
								  + "      \"enrollmentNumber\": \""+data.get("enrollmentNumber")+"\",\r\n"
								  + "      \"enrollmentStatusId\": null,\r\n"
								  + "      \"expectedCreditsHoursPerTerm\": 0,\r\n"
								  + "      \"expectedHoursPerWeekForExternship\": 0,\r\n"
								  + "      \"expectedRefundProcessDate\": null,\r\n"
								  + "      \"expectedStartDate\": \""+data.get("expectedStartDate")+"\",\r\n"
								  + "      \"externshipBeginDate\": null,\r\n"
								  + "      \"faEntranceInterviewDate\": null,\r\n"
								  + "      \"faExitInterviewDate\": null,\r\n"
								  + "      \"financialAidCredits\": 0,\r\n"
								  + "      \"gpa\": 0,\r\n"
								  + "      \"gpaCreditHours\": null,\r\n"
								  + "      \"gradeLevelId\": "+data.get("gradeLevelId")+",\r\n"
								  + "      \"gradeScaleId\": null,\r\n"
								  + "      \"graduationDate\": \""+data.get("graduationDate")+"\",\r\n"
								  + "      \"ipedsState\": null,\r\n"
								  + "      \"isApplicant\": false,\r\n"
								  + "      \"isAttendanceArchived\": false,\r\n"
								  + "      \"isIpedsTransfer\": false,\r\n"
								  + "      \"isReenrollment\": 0,\r\n"
								  + "      \"isTransfer\": false,\r\n"
								  + "      \"isUiUpdate\": false,\r\n"
								  + "      \"lastActivityDate\": null,\r\n"
								  + "      \"lastModifiedDateTime\": \"2022/08/10 04:21:47\",\r\n"
								  + "      \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
								  + "      \"lda\": null,\r\n"
								  + "      \"linkedSapStudentEnrollmentPeriodId\": null,\r\n"
								  + "      \"midpointDate\": \""+data.get("midpointDate")+"\",\r\n"
								  + "      \"minutesAbsent\": null,\r\n"
							      + "      \"minutesAttended\": null,\r\n"
								  + "      \"minutesMakeUp\": null,\r\n"
								  + "      \"note\": \"\",\r\n"
								  + "      \"nsldsWithdrawalDate\": null,\r\n"
								  + "      \"numericAverage\": 0,\r\n"
								  + "      \"originalAssignedAdmissionsRepId\": null,\r\n"
								  + "      \"originalExpectedStartDate\": null,\r\n"
							      + "      \"originalGraduationDate\": null,\r\n"
							      + "      \"outsideCourseWorkHours\": 0,\r\n"
								  + "      \"previousEducationId\": "+data.get("previousEducationId")+",\r\n"
								  + "      \"previousGradDate\": null,\r\n"
								  + "      \"programId\": "+data.get("programId")+",\r\n"
								  + "      \"programVersionId\": "+data.get("programVersionId")+",\r\n"
								  + "      \"programVersionName\": null,\r\n"
								  + "      \"recalculateTermSequence\": false,\r\n"
								  + "      \"reenrollDate\": null,\r\n"
								  + "      \"reentryAfter180Date\": null,\r\n"
								  + "      \"rightsResponsibilitiesAck\": false,\r\n"
								  + "      \"rowVersion\": null,\r\n"
								  + "      \"sapCheckpoint\": 0,\r\n"
								  + "      \"sapFlag\": \"\",\r\n"
								  + "      \"sapStatusId\": null,\r\n"
								  + "      \"schoolStatusChangeDate\": null,\r\n"
								  + "      \"schoolStatusChangeReasonId\": null,\r\n"
								  + "      \"schoolStatusId\": "+data.get("schoolStatusId")+",\r\n"
							      + "      \"shiftId\": "+data.get("shiftId")+",\r\n"
								  + "      \"speProgression\": null,\r\n"
								  + "      \"startDateId\": "+data.get("startDateId")+",\r\n"
								  + "      \"startTermId\": \"\",\r\n"
								  + "      \"statusChangeType\": 0,\r\n"
								  + "      \"studentId\": "+data.get("studentId")+",\r\n"
								  + "      \"transcriptIssued\": null,\r\n"
								  + "      \"transferCreditHours\": null,\r\n"
								  + "      \"transferInDate\": null,\r\n"
								  + "      \"student\": null,\r\n"
								  + "      \"originalState\": \"H4sIAAAAAAAEALWTQUvDQBCF/0rZu5nU3kKyUCyC2NpDqngdkkk6kN0NuxNi/PW2K3qRqhRyncf75r2Bydfe47RvHml6wW6gfRPEs23RToepp8Wb6Wwo1FGkzwBCdSSDITFceRdcI0nlDNym6QqWKZTkGTt+R2FnIYKD+iRk/M0YxzEZV4nz7dm4hNfdtozYG7ZB0FakdH4hThT0FoPsXM0NU/0cyD/UOZznebQsOLPcFUr8QAp0lC6y/rdkg0IHNjTDmh/Z5SQVCjO28nU7/Pt2Sqc5RMTVSe48nWrO2fXJyRzYDbWeaD3ULDPQS+zvO2yvI8Pv36U/AJIQYLx+AwAA\",\r\n"
								  + "      \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "      \"extendedProperties\": [\r\n"
								  + "        {\r\n"
								  + "          \"name\": \"Program Designator\",\r\n"
								  + "          \"value\": null,\r\n"
								  + "          \"id\": -1,\r\n"
								  + "          \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
								  + "          \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "          \"extendedProperties\": [],\r\n"
								  + "          \"entityState\": 3\r\n"
								  + "        },\r\n"
								  + "        {\r\n"
								  + "          \"name\": \"A Graduation Ceremony Participation\",\r\n"
								  + "          \"value\": null,\r\n"
								  + "          \"id\": -1,\r\n"
								  + "          \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
								  + "          \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "          \"extendedProperties\": [],\r\n"
								  + "          \"entityState\": 3\r\n"
								  + "        },\r\n"
								  + "        {\r\n"
								  + "          \"name\": \"B Graduation Ceremony Gown size\",\r\n"
								  + "          \"value\": null,\r\n"
								  + "          \"id\": -1,\r\n"
								  + "          \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
								  + "          \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "          \"extendedProperties\": [],\r\n"
								  + "          \"entityState\": 3\r\n"
								  + "        },\r\n"
								  + "        {\r\n"
								  + "          \"name\": \"C Graduation Ceremony Cap Size\",\r\n"
								  + "          \"value\": null,\r\n"
								  + "          \"id\": -1,\r\n"
								  + "          \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
								  + "          \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "          \"extendedProperties\": [],\r\n"
								  + "          \"entityState\": 3\r\n"
								  + "        },\r\n"
								  + "        {\r\n"
								  + "          \"name\": \"D Graduation Ceremony additional Regalia\",\r\n"
								  + "          \"value\": null,\r\n"
								  + "          \"id\": -1,\r\n"
								  + "          \"originalState\": \"H4sIAAAAAAAEAH2PywrCMBREf6Vkb261u5IGXKt0URG3IaTthTxKkhLj10sjuFJ3A4c5zLCj9yL340nlm9Cr6scQPdpJ2HzNi6oeRtvQkTnGpQUIclZGBGpQehfcGKl0Bg513cC+hkF5FBqfIqKzUMSBvA0tfhwpJZoa6vy0Ffdwv5yHot2hDVFYqQhnP+YUwAthsEVWcoWtRd2R6FdFgBf0vQ7/7/IXfnmonw8BAAA=\",\r\n"
								  + "          \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								  + "          \"extendedProperties\": [],\r\n"
								  + "          \"entityState\": 3\r\n"
								  + "        }\r\n"
								  + "      ],\r\n"
								  + "      \"entityState\": 0,\r\n"
								  + "      \"isAvailable\": false,\r\n"
								  + "      \"programTypeId\": "+data.get("studentId")+",\r\n"
								  + "      \"AutoChargesTermId\": \"\",\r\n"
								  + "      \"ProgramVersionAreaOfStudyConfigList\": null\r\n"
								  + "    }\r\n"
								  + "  }\r\n"
								  + "}")
						.when().contentType(ContentType.JSON)
						.post(""+data.get("URI")+"");
									
				int StatusCode = res.getStatusCode();
				
				String Statusline = res.getStatusLine();
					
				TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
					
				TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
					
				TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
					
				if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Student was successfully enrolled.");
					}
					else {
						TestReportsLog.log(LogStatus.FAIL, "The Student Was Not Enrolled.");
						
					}
					
			  }
					
	//Test 5_1 - Add a Course to a Students schedule
			
			@Test(priority=6)
			public String AddacoursetoastudentsscheduleSave(StringHash data) throws Exception {
						
				String token = ""+data.get("Token")+"";
				Response res = given()
						.header("Authorization","Basic "+token)
						.body("{\r\n"
								+ "  \"payload\": {\r\n"
								+ "    \"StudentCourseId\": null,\r\n"
								+ "    \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
								+ "    \"CampusId\": "+data.get("CampusId")+",\r\n"
								+ "    \"ClassSectionId\": 0,\r\n"
								+ "    \"CourseId\": "+data.get("CourseId")+",\r\n"
								+ "    \"RequiredCourseId\": "+data.get("RequiredCourseId")+",\r\n"
								+ "    \"ParentTermId\": null,\r\n"
								+ "    \"TermId\": "+data.get("TermId")+",\r\n"
								+ "    \"AcademicYearId\": 0,\r\n"
								+ "    \"Comments\": \"\",\r\n"
								+ "    \"Action\": "+data.get("Action")+",\r\n"
								+ "    \"AllowOverrideRegistrationHold\": false,\r\n"
								+ "    \"IsAllowedToOverrideRetakeAttempts\": false,\r\n"
								+ "    \"IsAllowedToAuditCourse\": false,\r\n"
								+ "    \"IsAllowedCourse\": false,\r\n"
								+ "    \"IsAllowedToOverrideLockedTermSequence\": false,\r\n"
								+ "    \"IsAllowedMaxClassSizeRegisterOverride\": false,\r\n"
								+ "    \"IsAllowedToWaitListStudent\": false,\r\n"
								+ "    \"isAllowedPostCourseStartDateRegistration\": false,\r\n"
								+ "    \"IsWaitlistStudentNotified\": false,\r\n"
								+ "    \"IsSubstituteCourse\": false,\r\n"
								+ "    \"SubstituteCourseId\": 0,\r\n"
								+ "    \"IsAudit\": false,\r\n"
								+ "    \"StudentCourseFeeScheduleId\": 0,\r\n"
								+ "    \"Description\": \"\",\r\n"
								+ "    \"StartDate\": null,\r\n"
								+ "    \"EndDate\": null,\r\n"
								+ "    \"IsRetakeOverride\": false,\r\n"
								+ "    \"RetakeID\": 0,\r\n"
								+ "    \"ReturnCode\": 0,\r\n"
								+ "    \"IsPassFail\": 0,\r\n"
								+ "    \"UseFeeSchedule\": false,\r\n"
								+ "    \"RetakeFee\": \"o\",\r\n"
								+ "    \"ClassCount\": 0,\r\n"
								+ "    \"IsAllowStudentAcademicYearPaymentPeriod\": false,\r\n"
								+ "    \"IsAllowedRegisterAsAuditClass\": false,\r\n"
								+ "    \"IsAllowedDateTimeConflict\": false,\r\n"
								+ "    \"Status\": \""+data.get("Status")+"\",\r\n"
								+ "    \"AllowClassSection\": false,\r\n"
								+ "    \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
								+ "    \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
								+ "    \"SkipPrereqCheck\": false,\r\n"
								+ "    \"SkipCoreqCheck\": false,\r\n"
								+ "    \"IgnoreMultiCourseDependency\": false,\r\n"
								+ "    \"IsReservedStatus\": false,\r\n"
								+ "    \"IsAllowedToOverrideStudentIntoCourse\": false,\r\n"
								+ "    \"IsAllowedToWaitlistAvailableStudentIntoCourse\": false,\r\n"
								+ "    \"IsAllowedToWaitlistStudentIntoCourse\": false,\r\n"
								+ "    \"IsRegistrationRetake\": false,\r\n"
								+ "    \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
								+ "    \"IsAllowedToOverrideClosedTerm\": false,\r\n"
								+ "    \"IsAllowedToOverrideRegistrationGroup\": false,\r\n"
								+ "    \"IsOverlapWithParentTermAllowed\": false,\r\n"
								+ "    \"IsEnrollmentAdjusted\": false,\r\n"
								+ "    \"IsGlobalCumulativeIncluded\": true\r\n"
								+ "  }\r\n"
								+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI1")+"");
								
				int StatusCode = res.getStatusCode();
							
				String Statusline = res.getStatusLine();
				
				String responseBody = res.getBody().asString();
				
		        JsonPath path = new JsonPath(responseBody);
		        
		        String ID = path.getString("payload.data.entity.id");
				
				TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
				
				TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
				
				TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
				
				TestReportsLog.log(LogStatus.INFO, "Student Course id = "+ID);
				
				if(StatusCode==200) {
					TestReportsLog.log(LogStatus.PASS, "The Student Course records were successfully Saved.");
				}
				else {
					TestReportsLog.log(LogStatus.FAIL, "The Student Course records were not Saved.");
					
				}
				return ID;
		  }

	//Test 5_2 - Add a Course to a Students schedule
			
			@Test(priority=7)
			public String AddacoursetoastudentsscheduleRegister(StringHash data) throws Exception {
				
				APIAutomationPage Dpage = new APIAutomationPage();
			String ID = Dpage.AddacoursetoastudentsscheduleSave(data);

				String token = ""+data.get("Token")+"";
				Response res = given()
									.header("Authorization","Basic "+token)
									.body("{\r\n"
											+ "  \"payload\": {\r\n"
											+ "    \"StudentCourseId\": "+ID+",\r\n"
											+ "    \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
											+ "    \"CampusId\": "+data.get("CampusId")+",\r\n"
											+ "    \"ClassSectionId\": "+data.get("ClassSectionId")+",\r\n"
											+ "    \"CourseId\": "+data.get("CourseId")+",\r\n"
											+ "    \"RequiredCourseId\": "+data.get("RequiredCourseId")+",\r\n"
											+ "    \"ParentTermId\": 0,\r\n"
											+ "    \"TermId\": "+data.get("TermId1")+",\r\n"
											+ "    \"AcademicYearId\": 0,\r\n"
											+ "    \"Hours\": "+data.get("Hours")+",\r\n"
											+ "    \"Comments\": \"\",\r\n"
											+ "    \"Credits\": 0,\r\n"
											+ "    \"Action\": "+data.get("Action1")+",\r\n"
											+ "    \"AllowOverrideRegistrationHold\": false,\r\n"
											+ "    \"IsAllowedToOverrideRetakeAttempts\": false,\r\n"
											+ "    \"IsAllowedToAuditCourse\": false,\r\n"
											+ "    \"IsAllowedCourse\": false,\r\n"
											+ "    \"IsAllowedToOverrideLockedTermSequence\": false,\r\n"
											+ "    \"IsAllowedMaxClassSizeRegisterOverride\": false,\r\n"
											+ "    \"IsAllowedToWaitListStudent\": false,\r\n"
											+ "    \"IsAllowedPostCourseStartDateRegistration\": true,\r\n"
											+ "    \"isRetakeValidationDisplayed\": false,\r\n"
											+ "    \"IsSubstituteCourse\": false,\r\n"
											+ "    \"SubstituteCourseId\": 0,\r\n"
											+ "    \"IsAudit\": false,\r\n"
											+ "    \"StudentCourseFeeScheduleId\": -1,\r\n"
											+ "    \"IsCrossReferencedCourse\": false,\r\n"
											+ "    \"IsCrsg\": false,\r\n"
											+ "    \"Description\": \"\",\r\n"
											+ "    \"StartDate\": \""+data.get("StartDate")+"\",\r\n"
											+ "    \"EndDate\": \""+data.get("EndDate")+"\",\r\n"
											+ "    \"IsRetakeOverride\": false,\r\n"
											+ "    \"RetakeID\": 0,\r\n"
											+ "    \"ReturnCode\": 0,\r\n"
											+ "    \"IsPassFail\": 0,\r\n"
											+ "    \"UseFeeSchedule\": true,\r\n"
											+ "    \"RetakeFee\": \"O\",\r\n"
											+ "    \"ClassCount\": 0,\r\n"
											+ "    \"IsAllowStudentAcademicYearPaymentPeriod\": false,\r\n"
											+ "    \"IsAllowedRegisterAsAuditClass\": false,\r\n"
											+ "    \"IsAllowedDateTimeConflict\": false,\r\n"
											+ "    \"Status\": \""+data.get("Status1")+"\",\r\n"
											+ "    \"AllowClassSection\": false,\r\n"
											+ "    \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
											+ "    \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
											+ "    \"SkipPrereqCheck\": false,\r\n"
											+ "    \"SkipCoreqCheck\": false,\r\n"
											+ "    \"IgnoreMultiCourseDependency\": false,\r\n"
											+ "    \"IsReservedStatus\": false,\r\n"
											+ "    \"IsAllowedToOverrideStudentIntoCourse\": false,\r\n"
											+ "    \"IsAllowedToWaitlistAvailableStudentIntoCourse\": false,\r\n"
											+ "    \"IsAllowedToWaitlistStudentIntoCourse\": false,\r\n"
											+ "    \"IsRegistrationRetake\": false,\r\n"
											+ "    \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
											+ "    \"IsAllowedToOverrideClosedTerm\": false,\r\n"
											+ "    \"IsAllowedToOverrideRegistrationGroup\": false,\r\n"
											+ "    \"IsOverlapWithParentTermAllowed\": false,\r\n"
											+ "    \"IsAllowedToWaitListForDifferentSection\": false,\r\n"
											+ "    \"IsAllowedToOverrideCourseStatus\": false\r\n"
											+ "  }\r\n"
											+ "}")
									.when().contentType(ContentType.JSON)
									.post(""+data.get("URI2")+"");
										
					int StatusCode = res.getStatusCode();
							
					String Statusline = res.getStatusLine();
							
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
							
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
							
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
							
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Student Course records were successfully registered.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Student Course records were not registered.");
								
					}
					return ID;		
				}
			
			
	//Test 6 - Record makeup hours for a student
			
			@Test(priority=8)
			public void Recordmakeuphoursforastudent(StringHash data) throws Exception {
				
				/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				String currentDate = formatter.format(date);*/							
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"StudentCourseId\": "+data.get("StudentCourseId")+",\r\n"
									+ "    \"AttendId\": "+data.get("AttendId")+",\r\n"
									+ "    \"ClassSectionId\": "+data.get("ClassSectionId")+",\r\n"
									+ "    \"Hours\": "+data.get("Hours")+",\r\n"
									+ "    \"Minutes\": 0,\r\n"
									+ "    \"AttendanceDate\": \""+data.get("AttendanceDate")+"\",\r\n"
									+ "    \"Note\": \"\",\r\n"
									+ "    \"Type\": \""+data.get("Type")+"\"\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
										
				int StatusCode = res.getStatusCode();
							
				String Statusline = res.getStatusLine();
							
				TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
							
				TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
							
				TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
							
				if(StatusCode==200) {
					TestReportsLog.log(LogStatus.PASS, "The Attendance records were successfully saved.");
				}
					else {
					TestReportsLog.log(LogStatus.FAIL, "The Attendance records were Not Saved.");
								
				}
					  
		}
			
	//Test 7 -  Unregister a course from a students schedule
			
			@Test(priority=9)
			public String Unregisteracoursefromastudentsschedule(StringHash data) throws Exception {
				
				APIAutomationPage Upage = new APIAutomationPage();
			String ID = Upage.AddacoursetoastudentsscheduleRegister(data);	
			
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"IsUnregisterCall\": true,\r\n"
									+ "    \"IsMultipleUnregisterEnabled\": true,\r\n"
									//+ "    \"StudentCourseId\": "+data.get("StudentCourseId")+",\r\n"
									+ "    \"StudentCourseId\": "+ID+",\r\n"
									+ "    \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
									+ "    \"Comments\": \""+data.get("Comments")+"\",\r\n"
									+ "    \"Credits\": 0,\r\n"
									+ "    \"IsCrossReferencedCourse\": false,\r\n"
									+ "    \"CrossReferenceCourseId\": 0,\r\n"
									+ "    \"Description\": \"\",\r\n"
									+ "    \"Status\": \""+data.get("Status")+"\",\r\n"
									+ "    \"AllowClassSection\": false,\r\n"
									+ "    \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
									+ "    \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
									+ "    \"SkipPrereqCheck\": false,\r\n"
									+ "    \"SkipCoreqCheck\": false,\r\n"
									+ "    \"FailureMessageType\": 0,\r\n"
									+ "    \"IgnoreMultiCourseDependency\": false,\r\n"
									+ "    \"Hours\": "+data.get("Hours")+",\r\n"
									+ "    \"CourseStatusChangeReasonId\": "+data.get("CourseStatusChangeReasonId")+",\r\n"
									+ "    \"AllowedOnlyParent\": false,\r\n"
									+ "    \"IsAllowedToOverrideClosedTerm\": false,\r\n"
									+ "    \"ImpactedStudentCourseIds\": []\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI3")+"");
											
					int StatusCode = res.getStatusCode();
								
					String Statusline = res.getStatusLine();
								
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
								
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
								
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
								
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Student Course records were successfully unregistered.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Student Course records were not unregistered.");
									
					}
					return ID;	  
			}

	//Test 7 - Delete a Added course
			
			@Test(priority=9)
			public void DeleteAddedCourse(StringHash data) throws Exception {
				
				APIAutomationPage DLpage = new APIAutomationPage();
			String ID = DLpage.Unregisteracoursefromastudentsschedule(data);
						
					String token = ""+data.get("Token")+"";
					Response res = given()
								.header("Authorization","Basic "+token)
								.body("{\r\n"
										+ "  \"payload\": {\r\n"
										+ "    \"StudentCourseId\": "+ID+",\r\n"
										+ "    \"MinutesAttended\": 0,\r\n"
										+ "    \"MinutesAbsent\": 0,\r\n"
										+ "    \"AllowDeleteAttendanceHistory\": false,\r\n"
										+ "    \"AllowDeletePendingCharges\": true,\r\n"
										+ "    \"IsPendingCharges\": false,\r\n"
										+ "    \"TermId\": "+data.get("TermId2")+",\r\n"
										+ "    \"IsAllowedToOverrideClosedTerm\": false,\r\n"
										+ "    \"Action\": "+data.get("Action")+",\r\n"
										+ "    \"IsAddDropPeriodClassSectionAllowed\": false,\r\n"
										+ "    \"IsAllowedToOverrideRegistrationConflict\": false,\r\n"
										+ "    \"CourseStatusChangeReasonId\": "+data.get("CourseStatusChangeReasonId")+",\r\n"
										+ "    \"SkipCoreqCheck\": false,\r\n"
										+ "    \"SkipPrereqCheck\": false,\r\n"
										+ "    \"FailureMessageType\": 0,\r\n"
										+ "    \"IgnoreMultiCourseDependency\": false,\r\n"
										+ "    \"AllowOverrideRegistrationPrereqCoreqConflict\": false,\r\n"
										+ "    \"TermCode\": \"\",\r\n"
										+ "    \"Section\": \"\",\r\n"
										+ "    \"CampusId\": "+data.get("CampusId")+",\r\n"
										+ "    \"NotifyStudent\": false\r\n"
										+ "  }\r\n"
										+ "}")
									.when().contentType(ContentType.JSON)
									.post(""+data.get("URI")+"");
													
							int StatusCode = res.getStatusCode();
										
							String Statusline = res.getStatusLine();
										
							TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
										
							TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
										
							TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
										
							if(StatusCode==200) {
								TestReportsLog.log(LogStatus.PASS, "The Student Course records were successfully Deleted.");
							}
								else {
								TestReportsLog.log(LogStatus.FAIL, "The Student Course records were not Deleted.");
											
							}
								  
					}
					
	//Test 8 - Add Degrees to a Student
			
			@Test(priority=10)
			public void AddDegreestoaStudent(StringHash data) throws Exception {
												
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"id\": -1,\r\n"
									+ "    \"awardedDate\": \""+data.get("awardedDate")+"\",\r\n"
									+ "    \"clearedDate\": null,\r\n"
									+ "    \"createdDateTime\": \"2022/08/17 03:43:42\",\r\n"
									+ "    \"degreeId\": "+data.get("degreeId")+",\r\n"
									+ "    \"lastModifiedDateTime\": \"2022/08/17 03:43:42\",\r\n"
									+ "    \"lastModifiedUserId\": 3501,\r\n"
									+ "    \"note\": null,\r\n"
									+ "    \"rowVersion\": null,\r\n"
									+ "    \"studentEnrollmentPeriodId\": "+data.get("studentEnrollmentPeriodId")+",\r\n"
									+ "    \"originalState\": \"H4sIAAAAAAAEALWSQWvCQBCF/4rs3UystxADRS+lige19DokkziQ3ZWZkTT99dUt9KYIxes83ve+w5SvIjhu23caP7A/07ZVEw4dhnE/nmjy5fugC3c0OxUAWh/Jo2aea4kaW8vq6OElz+cwy2FHwtjzNxrHAAms7pdQ8B9jGIZsmGdRumtxBp+b9S5hpxzUMNTkqvKGTgqqNaptYsMtU3NQkremhOu9TJUJF4H7hTM5k4MqRTdZj42s0GjPnp4w8xT3pdDF+J/acP8zqh9MEFNEOgIAAA==\",\r\n"
									+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
									+ "    \"extendedProperties\": [],\r\n"
									+ "    \"entityState\": 0\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
													
					int StatusCode = res.getStatusCode();
										
					String Statusline = res.getStatusLine();
										
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
										
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
										
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
										
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Degrees records were successfully saved.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Degrees records were Not saved.");
											
					}
										
				}

	//Test 9 - Add Honors to a Student
			
			@Test(priority=11)
			public void AddHonorstoaStudent(StringHash data) throws Exception {
														
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"IsTermHonor\": false,\r\n"
									+ "    \"entity\": {\r\n"
									+ "      \"Id\": 0,\r\n"
									+ "      \"HonorId\": "+data.get("HonorId")+",\r\n"
									+ "      \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
									+ "      \"TermId\": 0\r\n"
									+ "    }\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
															
					int StatusCode = res.getStatusCode();
												
					String Statusline = res.getStatusLine();
												
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
												
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
												
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
												
					if(StatusCode==200) {
								TestReportsLog.log(LogStatus.PASS, "The Honors and Badges records were successfully saved.");
							}
								else {
								TestReportsLog.log(LogStatus.FAIL, "The Honors and Badges records were not saved.");
													
							}
										  
				}

	//Test 10 - Add Term Honer and Badges
			
			@Test(priority=12)
			public void AddTermHonerandBadges(StringHash data) throws Exception {
																
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"IsTermHonor\": true,\r\n"
									+ "    \"Note\": \"\",\r\n"
									+ "    \"entity\": {\r\n"
									+ "      \"Id\": 0,\r\n"
									+ "      \"HonorId\": "+data.get("HonorId")+",\r\n"
									+ "      \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
									+ "      \"TermId\": "+data.get("TermId")+"\r\n"
									+ "    }\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
																	
					int StatusCode = res.getStatusCode();
														
					String Statusline = res.getStatusLine();
														
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
														
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
														
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
														
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Term Honors and Badges records were successfully saved.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Term Honors and Badges records were not saved.");
															
					}
												  
			}

	//Test 11 - Record batch Mid term Grades for a course. 
			
			@Test(priority=13)
			public void RecordbatchMidtermGradesforacourse(StringHash data) throws Exception {
																		
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"ClassSectionRosterMidTermList\": [\r\n"
									+ "      {\r\n"
									+ "        \"StudentEnrollnmentPeriodId\": "+data.get("StudentEnrollnmentPeriodId")+",\r\n"
									+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
									+ "        \"StudentNumber\": null,\r\n"
									+ "        \"StudentCourseId\": "+data.get("StudentCourseId")+",\r\n"
									+ "        \"StudentCourseStatus\": \""+data.get("StudentCourseStatus")+"\",\r\n"
									+ "        \"MidtermLetterGrade\": \""+data.get("MidtermLetterGrade")+"\",\r\n"
									+ "        \"MidtermNumericGrade\": null,\r\n"
									+ "        \"Speed\": null,\r\n"
									+ "        \"MidtermGradeNote\": \"\",\r\n"
									+ "        \"StudentEnrollnmentPeriodGradeScaleId\": 1,\r\n"
									+ "        \"StudentName\": \""+data.get("StudentName")+" \",\r\n"
									+ "        \"Ssn\": \"\",\r\n"
									+ "        \"SchoolStatusCode\": \""+data.get("SchoolStatusCode")+" \",\r\n"
									+ "        \"IsAudit\": false,\r\n"
									+ "        \"MidtermGradePostedDate\": null,\r\n"
									+ "        \"GradeScaleId\": "+data.get("GradeScaleId")+",\r\n"
									+ "        \"CourseCode\": \""+data.get("SchoolStatusCode")+"\",\r\n"
									+ "        \"SectionCode\": \""+data.get("SectionCode")+"\"\r\n"
									+ "      }\r\n"
									+ "    ]\r\n"
									+ "  }\r\n"
									+ "}")
							 .when().contentType(ContentType.JSON)
							 .post(""+data.get("URI")+"");
																			
					int StatusCode = res.getStatusCode();
																
					String Statusline = res.getStatusLine();
																
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
																
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
																
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
																
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Midterm records were successfully saved.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Midterm records were not saved.");
																	
				    }
														  
			}

	//Test 12_1 - Confirm documents have been created and associated with the Career Services module.
			
			@Test(priority=15)
			public void ConfirmdocumentshavebeencreatedandassociatedwiththeCareerServicesmoduleNewDocument(StringHash data) throws Exception {
																						
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"id\": -1,\r\n"
									+ "    \"studentId\": "+data.get("studentId")+",\r\n"
									+ "    \"moduleId\": "+data.get("moduleId")+",\r\n"
									+ "    \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
									+ "    \"requestedDate\": \""+data.get("requestedDate")+"\",\r\n"
									+ "    \"documentTypeId\": "+data.get("documentTypeId")+",\r\n"
									+ "    \"documentStatusId\": "+data.get("documentStatusId")+",\r\n"
									+ "    \"approvedDate\": \""+data.get("approvedDate")+"\",\r\n"
									+ "    \"awardYear\": null,\r\n"
									+ "    \"studentPlacementId\": null,\r\n"
									+ "    \"createdByUserId\": "+data.get("createdByUserId")+"\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
																							
					int StatusCode = res.getStatusCode();
																				
					String Statusline = res.getStatusLine();
																				
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
																				
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
																				
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
																				
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Document records were successfully saved.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Document records were not saved.");
																					
				   }
													
																		  
			}

	//Test 12_2 - Confirm documents have been created and associated with the Career Services module.
			
			@Test(priority=16)
			public void ConfdoccreateassowithCarServmoduleNewDocumentList(StringHash data) throws Exception {
																								
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"StudentId\": "+data.get("StudentId")+",\r\n"
									+ "    \"ModuleId\": "+data.get("ModuleId")+",\r\n"
									+ "    \"EnrollmentId\": "+data.get("EnrollmentId")+",\r\n"
									+ "    \"DateRequested\": \""+data.get("DateRequested")+"\",\r\n"
									+ "    \"DocumentTypeListId\": "+data.get("DocumentTypeListId")+",\r\n"
									+ "    \"DateApproved\": \""+data.get("DateApproved")+"\",\r\n"
									+ "    \"DocumentStatusId\": "+data.get("DocumentStatusId")+",\r\n"
									+ "    \"AwardYear\": null,\r\n"
									+ "    \"StudentPlacementId\": null\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
																							
					int StatusCode = res.getStatusCode();
																				
					String Statusline = res.getStatusLine();
																				
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
																				
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
																				
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
																				
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Document records were successfully saved.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Document records were not saved.");
																					
				   }
																																	  
			}
			
	//Test 13 - Tasks need to be configured to allow associating events with Students and validate the same task in the Drop down
			
			@Test(priority=17)
			public void TasktoconftoallassoevewithStudents(StringHash data) throws Exception {
																								
				String token = ""+data.get("Token")+"";
				Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"taskTypeCode\": \""+data.get("taskTypeCode")+"\",\r\n"
									+ "    \"taskTypeCategory\": \""+data.get("taskTypeCategory")+"\",\r\n"
									+ "    \"advisorTypeList\": null,\r\n"
									+ "    \"taskTemplateDocumentTypeAttachmentList\": [],\r\n"
									+ "    \"taskTemplateDocumentTypeList\": [],\r\n"
									+ "    \"taskTemplateLinkedLetterList\": [],\r\n"
									+ "    \"taskTemplateOrganizationTypeList\": [],\r\n"
									+ "    \"isRecordInNewMode\": false,\r\n"
									+ "    \"previousTemplateCode\": null,\r\n"
									+ "    \"taskTemplateScriptQuestionList\": null,\r\n"
									+ "    \"id\": -1,\r\n"
									+ "    \"addressTypeId\": null,\r\n"
									+ "    \"advisorTypes\": null,\r\n"
									+ "    \"campusGroupId\": 0,\r\n"
									+ "    \"code\": \""+data.get("code")+"\",\r\n"
									+ "    \"createdDateTime\": \"2022/08/10 07:56:24\",\r\n"
									+ "    \"crmIntegrationEffectiveDate\": null,\r\n"
									+ "    \"crmProcess\": false,\r\n"
									+ "    \"defaultDuration\": 0,\r\n"
									+ "    \"defaultStaffStatus\": \"Unread\",\r\n"
									+ "    \"defaultTaskResultId\": 0,\r\n"
									+ "    \"defaultTaskStatusId\": 0,\r\n"
									+ "    \"defaultText\": \"\",\r\n"
									+ "    \"emailSubject\": \""+data.get("emailSubject")+"\",\r\n"
									+ "    \"employerContactActivityFlag\": \""+data.get("employerContactActivityFlag")+"\",\r\n"
									+ "    \"employerContactFlag\": \""+data.get("employerContactFlag")+"\",\r\n"
									+ "    \"eventText\": null,\r\n"
									+ "    \"incidentLocationFlag\": null,\r\n"
									+ "    \"incidentTypeId\": 0,\r\n"
									+ "    \"isActive\": true,\r\n"
									+ "    \"isCommentsDisplayedToStudent\": true,\r\n"
									+ "    \"isFollowupRequired\": false,\r\n"
									+ "    \"isIntegrated\": false,\r\n"
									+ "    \"isLastEditedInDesktop\": false,\r\n"
									+ "    \"isSmsSentAsEmail\": false,\r\n"
									+ "    \"isSystemCode\": false,\r\n"
									+ "    \"jobActivityFlag\": \""+data.get("jobActivityFlag")+"\",\r\n"
									+ "    \"lastModifiedDateTime\": \""+data.get("lastModifiedDateTime")+"\",\r\n"
									+ "    \"lastModifiedUserId\": "+data.get("lastModifiedUserId")+",\r\n"
									+ "    \"message\": null,\r\n"
									+ "    \"name\": \""+data.get("name")+"\",\r\n"
									+ "    \"organizationContactActivityFlag\": \"N\",\r\n"
									+ "    \"organizationContactFlag\": \"N\",\r\n"
									+ "    \"organizationTypeId\": null,\r\n"
									+ "    \"otherAdvisorTypes\": null,\r\n"
									+ "    \"rowVersion\": null,\r\n"
									+ "    \"sendTo\": \""+data.get("sendTo")+"\",\r\n"
									+ "    \"staffId\": 0,\r\n"
									+ "    \"studentContactFlag\": \""+data.get("studentContactFlag")+"\",\r\n"
									+ "    \"taskCategoryId\": "+data.get("taskCategoryId")+",\r\n"
									+ "    \"taskTypeId\": "+data.get("taskTypeId")+",\r\n"
									+ "    \"campusGroup\": {\r\n"
									+ "      \"id\": -1,\r\n"
									+ "      \"approverStaffId\": null,\r\n"
									+ "      \"code\": \"\",\r\n"
									+ "      \"createdDateTime\": \"0001/01/01 00:00:00\",\r\n"
									+ "      \"financialCampusGroup\": false,\r\n"
									+ "      \"isActive\": true,\r\n"
									+ "      \"isSystemCode\": true,\r\n"
									+ "      \"lastModifiedDateTime\": \"0001/01/01 00:00:00\",\r\n"
									+ "      \"lastModifiedUserId\": 0,\r\n"
									+ "      \"name\": \"\",\r\n"
									+ "      \"rowVersion\": null,\r\n"
									+ "      \"saStmtComments\": \"\",\r\n"
									+ "      \"saStmtLastCloseDate\": null,\r\n"
									+ "      \"type\": \""+data.get("type")+"\",\r\n"
									+ "      \"campusList\": [\r\n"
									+ "        {\r\n"
									+ "          \"id\": -1,\r\n"
									+ "          \"campusId\": "+data.get("campusId")+",\r\n"
									+ "          \"entityState\": 0,\r\n"
									+ "          \"campusGroupId\": "+data.get("campusGroupId")+"\r\n"
									+ "        }\r\n"
									+ "      ],\r\n"
									+ "      \"originalState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
									+ "      \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
									+ "      \"extendedProperties\": [],\r\n"
									+ "      \"entityState\": 0\r\n"
									+ "    },\r\n"
									+ "    \"originalState\": \"H4sIAAAAAAAEAL2WS0/DMAzHvwrqnWZjt6lMmrohjYeG6EBcQ+sWizxK7FLKp6ctE+LAEBIylypNlP/Pj9hJsgxBd9vyAro7bRrYlsQBXaVdt+tqOHq1xtFp9Mhcz5Wi/BGspthiHjz5kuPcW3UymczUdKIyCKgNvmlG79QoTNGHwhw/Ndq2jdtZ7EM1bJyq+6vLbJQ9RkesXQ7RIjlgzriwuNTEV77AEqG4JQibIlHDfDJuOcK5Q3MacWggUotx6aDW7yArzbBDCwIYEdvTAL3FkmanwV4HnwORgPgKSt0YXjVhPElyhIx1WfYfbgTd2Gl6ugHqRyK5/kL58ESEsra18R2E1DvWOS9zxhfk7szoSp4mRNm4HAtwPMyIBG1DY5xE2gal3treeFoh1UZ3UOx8xs3gjwjuzBvj26a+gecGA8iEa+MYqjC0LhH5zFLWx2dJa6vRyCA6YrCpLySSfu4fhAtvG/r//QX+P6X+DVGI1Ke+rxEJ4eEWEWkg+4L+c1zUz4+8xTvMTH/gBQoAAA==\",\r\n"
									+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
									+ "    \"extendedProperties\": [],\r\n"
									+ "    \"entityState\": 0,\r\n"
									+ "    \"isModal\": false\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
																							
					int StatusCode = res.getStatusCode();
																				
					String Statusline = res.getStatusLine();
																				
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
																				
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
																				
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
																				
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Task Template records were successfully saved.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Task Template records were not Saved.");
																					
				   }
																																				  
			}
			
	//Test 14 - Confirm tasks are available in the Drop down when working with an employer record.
			
			@Test(priority=18)
			public void Conftaskdropdownemployerrecord(StringHash data) throws Exception {
																						
				String token = ""+data.get("Token")+"";
				Response res = given()
						.header("Authorization","Basic "+token)
						.body("{\r\n"
								+ "  \"payload\": {\r\n"
								+ "    \"isRequestFromMessage\": false,\r\n"
								+ "    \"taskStatusCode\": null,\r\n"
								+ "    \"crmSuppressFlag\": false,\r\n"
								+ "    \"id\": -1,\r\n"
								+ "    \"assignedToStaffId\": "+data.get("assignedToStaffId")+",\r\n"
								+ "    \"attachments\": null,\r\n"
								+ "    \"attachmentsId\": null,\r\n"
								+ "    \"classSectionId\": null,\r\n"
								+ "    \"completedByStaffId\": 0,\r\n"
								+ "    \"createdByStaffId\": 3501,\r\n"
								+ "    \"createdDateTime\": \""+data.get("createdDateTime")+"\",\r\n"
								+ "    \"emailSubject\": \""+data.get("emailSubject")+"\",\r\n"
								+ "    \"employerContactId\": null,\r\n"
								+ "    \"employerId\": null,\r\n"
								+ "    \"employerJobId\": null,\r\n"
								+ "    \"isActivityNotViewed\": false,\r\n"
								+ "    \"lastModifiedDateTime\": \"2022/08/18 05:12:42\",\r\n"
								+ "    \"lastModifiedUserId\": 3501,\r\n"
								+ "    \"lockedByUserId\": null,\r\n"
								+ "    \"note\": \"\",\r\n"
								+ "    \"organizationContactId\": null,\r\n"
								+ "    \"organizationId\": null,\r\n"
								+ "    \"previouslyAssignedToStaffId\": null,\r\n"
								+ "    \"priority\": \"Normal\",\r\n"
								+ "    \"prospectInquiryId\": null,\r\n"
								+ "    \"reassignedDate\": null,\r\n"
								+ "    \"remindDate\": null,\r\n"
								+ "    \"resultText\": \"\",\r\n"
								+ "    \"rowVersion\": null,\r\n"
								+ "    \"sessionSyCampusId\": "+data.get("sessionSyCampusId")+",\r\n"
								+ "    \"sourceRecordId\": 0,\r\n"
								+ "    \"sourceSystem\": \""+data.get("sourceSystem")+"\",\r\n"
								+ "    \"sourceTable\": \"\",\r\n"
								+ "    \"studentEnrollmentPeriodId\": "+data.get("studentEnrollmentPeriodId")+",\r\n"
								+ "    \"studentId\": "+data.get("studentId")+",\r\n"
								+ "    \"subject\": \""+data.get("subject")+"\",\r\n"
								+ "    \"taskDueDate\": \""+data.get("taskDueDate")+"\",\r\n"
								+ "    \"taskEndDate\": null,\r\n"
								+ "    \"taskResultId\": 0,\r\n"
								+ "    \"taskStartDate\": \""+data.get("taskStartDate")+"\",\r\n"
								+ "    \"taskStatusDate\": \""+data.get("taskStatusDate")+"\",\r\n"
								+ "    \"taskStatusId\": "+data.get("taskStatusId")+",\r\n"
								+ "    \"taskTemplateId\": "+data.get("taskTemplateId")+",\r\n"
								+ "    \"taskTypeId\": "+data.get("taskTypeId")+",\r\n"
								+ "    \"templateTextFile\": \"\",\r\n"
								+ "    \"workflowInstanceIdentifier\": null,\r\n"
								+ "    \"originalState\": \"H4sIAAAAAAAEALVVTUvDQBD9K5K72dbeShqoFkFsrTRRvK7JpB3cj7IzIV1/vUkq3iqCzHWHfe/tezOz2TIEHbfNI8RXbVrYNsQB3V67WMYjXJ2scbRIDszHuVJUHcBqSi1WwZNvOK28VTeTyUxNJ6qAgNrgp2b0To3AlJwR5viD0XVd2s1SH/bDxal626yLEfYaHbF2FSR5dkHOWMjXmnjja2wQ6heC8FBnajjPxitXOHdoFgmHFhKVj6WLWH8jWWmGEi0I0IhovwvQK5aU/eRZArbwbaigiMRgJXzx9migd+Y2FqybRsT8UtPHDqg1LAMP/RuGYOHE92gkUjirHwjEIt5B5UMtYtCZoNTvIt48B/QBOQo1zqqFYWqF0Pum55bECURiXRLh3kFdernR/d6b/9wO6vcvNf8CjMk0+3MHAAA=\",\r\n"
								+ "    \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
								+ "    \"extendedProperties\": [],\r\n"
								+ "    \"entityState\": 0\r\n"
								+ "  }\r\n"
								+ "}")
						.when().contentType(ContentType.JSON)
						.post(""+data.get("URI")+"");
																							
				int StatusCode = res.getStatusCode();
																				
				String Statusline = res.getStatusLine();
																				
				TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
																				
				TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
																				
				TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
																				
				if(StatusCode==200) {
					 TestReportsLog.log(LogStatus.PASS, "The Task records were successfully saved.");
				}
					 else {
					 TestReportsLog.log(LogStatus.FAIL, "The Task records were Not saved.");
																					
			    }
																																				  
		}
			
	//Test 15 - Subsidiary Ledger - Post a Charge.
			
			@Test(priority=19)
			public void SubsidiaryLedgerPostaCharge(StringHash data) throws Exception {
																								
				String token = ""+data.get("Token")+"";
				Response res = given()
						.header("Authorization","Basic "+token)
						.body("{\r\n"
								+ "  \"payload\": {\r\n"
								+ "    \"StudentId\": "+data.get("StudentId")+",\r\n"
								+ "    \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
								+ "    \"BillingTransactionCodeId\": "+data.get("BillingTransactionCodeId")+",\r\n"
								+ "    \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
								+ "    \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
								+ "    \"TermId\": "+data.get("TermId")+",\r\n"
								+ "    \"TransactionDate\": \""+data.get("TransactionDate")+"\",\r\n"
								+ "    \"Description\": \""+data.get("Description")+"\",\r\n"
								+ "    \"Reference\": \"\",\r\n"
								+ "    \"IsChargeAdjustment\": true,\r\n"
								+ "    \"IgnoreTermRequired\": false,\r\n"
								+ "    \"OverrideBilledDate\": null,\r\n"
								+ "    \"AllowProcessByAutomation\": null,\r\n"
								+ "    \"SubsidiaryAccountTypeId\": "+data.get("SubsidiaryAccountTypeId")+",\r\n"
								+ "    \"PaymentDueDate\": null,\r\n"
								+ "    \"IsIncludeIn1098T\": 1\r\n"
								+ "  }\r\n"
								+ "}")
					.when().contentType(ContentType.JSON)
					.post(""+data.get("URI")+"");
																										
			int StatusCode = res.getStatusCode();
																							
			String Statusline = res.getStatusLine();
																							
			TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
																							
			TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
																							
			TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
																							
			if(StatusCode==200) {
				TestReportsLog.log(LogStatus.PASS, "The Charge records were successfully saved.");
			}
				else {
				TestReportsLog.log(LogStatus.FAIL, "The Charge records were not saved.");
																								
			}
																																										  
	   }

	//Test 16 - Subsidiary Ledger - Post a Payment. 
			
			@Test(priority=20)
			public void SubsidiaryLedgerPostaPayment(StringHash data) throws Exception {
																										
				String token = ""+data.get("Token")+"";
				Response res = given()
						.header("Authorization","Basic "+token)
						.body("{\r\n"
								+ "  \"payload\": {\r\n"
								+ "    \"StudentId\": "+data.get("StudentId")+",\r\n"
								+ "    \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
								+ "    \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
								+ "    \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
								+ "    \"TermId\": "+data.get("TermId")+",\r\n"
								+ "    \"StudentAcademicYearPaymentPeriodId\": 0,\r\n"
								+ "    \"TransactionDate\": \""+data.get("TransactionDate")+"\",\r\n"
								+ "    \"Description\": \""+data.get("Description")+"\",\r\n"
								+ "    \"Reference\": \"\",\r\n"
								+ "    \"IgnoreTermRequired\": false,\r\n"
								+ "    \"AcademicYearSequence\": "+data.get("AcademicYearSequence")+",\r\n"
								+ "    \"PaymentMode\": 0,\r\n"
								+ "    \"FundSourceId\": 0,\r\n"
								+ "    \"ScheduledPaymentId\": 0,\r\n"
								+ "    \"PaymentType\": \""+data.get("PaymentType")+"\",\r\n"
								+ "    \"BankAccountId\": "+data.get("BankAccountId")+",\r\n"
								+ "    \"PaidByUserId\": 0,\r\n"
								+ "    \"StudentCreditCardId\": 0,\r\n"
								+ "    \"AuthorizationNumber\": null,\r\n"
								+ "    \"CheckNumber\": \"\",\r\n"
								+ "    \"CashDrawerId\": "+data.get("CashDrawerId")+",\r\n"
								+ "    \"CashDrawerSessionId\": "+data.get("CashDrawerSessionId")+",\r\n"
								+ "    \"CashierUserId\": "+data.get("CashierUserId")+",\r\n"
								+ "    \"ActualSource\": \""+data.get("ActualSource")+"\",\r\n"
								+ "    \"IsStudentCreditCardAuthorizeRequired\": true,\r\n"
								+ "    \"OpeningBalance\": \"\",\r\n"
								+ "    \"OverrideDisbursementAssociation\": false,\r\n"
								+ "    \"SubsidiaryAccountTypeId\": "+data.get("SubsidiaryAccountTypeId")+",\r\n"
								+ "    \"IsIncludeIn1098T\": 0,\r\n"
								+ "    \"IsScholarshipOrGrant\": 0,\r\n"
								+ "    \"ExtendedProperties\": [],\r\n"
								+ "    \"Drn\": null\r\n"
								+ "  }\r\n"
								+ "}")
						.when().contentType(ContentType.JSON)
						.post(""+data.get("URI")+"");
																										
				int StatusCode = res.getStatusCode();
				
				String Statusline = res.getStatusLine();
													
				TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
													
				TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
													
				TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
													
				if(StatusCode==200) {
					TestReportsLog.log(LogStatus.PASS, "The Transaction records were successfully saved.");
				}
					else {
					TestReportsLog.log(LogStatus.FAIL, "The Transaction records were not saved.");
														
				}
																						  
		}
								
	//Test 17 - Subsidiary Ledger - Adjust Transaction - Delete  
			
			@Test(priority=21)
			public void SubsidiaryLedgerAdjustTransactionDelete(StringHash data) throws Exception {
																								
				String token = ""+data.get("Token")+"";
				Response res = given()
						.header("Authorization","Basic "+token)
						.body("{\r\n"
								+ "  \"payload\": {\r\n"
								+ "    \"StudentSubsidiaryAccountTransactionId\": "+data.get("StudentSubsidiaryAccountTransactionId")+",\r\n"
								+ "    \"StudentId\": "+data.get("StudentId")+",\r\n"
								+ "    \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
								+ "    \"Note\": \""+data.get("Note")+"\"\r\n"
								+ "  }\r\n"
								+ "}")
						.when().contentType(ContentType.JSON)
						.post(""+data.get("URI")+"");
																											
				int StatusCode = res.getStatusCode();
				
				String Statusline = res.getStatusLine();
													
				TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
													
				TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
													
				TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
													
				if(StatusCode==200) {
					TestReportsLog.log(LogStatus.PASS, "The Student Subsidiary records were successfully deleted.");
				}
					else {
					TestReportsLog.log(LogStatus.FAIL, "The Student Subsidiary records were not deleted.");
														
				}
																						  
		}

	//Test 18 - Perform a Program Transfer for a Student
			
				@Test(priority=22)
				public void PerformaProgramTransferforaStudent(StringHash data) throws Exception {
																										
					String token = ""+data.get("Token")+"";
					Response res = given()
							.header("Authorization","Basic "+token)
							.body("{\r\n"
									+ "  \"payload\": {\r\n"
									+ "    \"transferEnrollmentType\": 0,\r\n"
									+ "    \"isReSubmitForPostingPendingCharges\": false,\r\n"
									+ "    \"postPendingCharges\": false,\r\n"
									+ "    \"hasPendingChanges\": false,\r\n"
									+ "    \"id\": 0,\r\n"
									+ "    \"fromStudentEnrollmentPeriodId\": "+data.get("fromStudentEnrollmentPeriodId")+",\r\n"
									+ "    \"toCampusId\": 0,\r\n"
									+ "    \"toStudentEnrollmentPeriodId\": "+data.get("toStudentEnrollmentPeriodId")+",\r\n"
									+ "    \"faTaskAssignedStaffId\": null,\r\n"
									+ "    \"faTaskTemplateId\": null,\r\n"
									+ "    \"isBilledDateMoved\": true,\r\n"
									+ "    \"isBudgetMoved\": true,\r\n"
									+ "    \"isCoursesMoved\": \""+data.get("isCoursesMoved")+"\",\r\n"
									+ "    \"isDocumentReviewPerformed\": false,\r\n"
									+ "    \"isFeesModified\": false,\r\n"
									+ "    \"isLdaMoved\": false,\r\n"
									+ "    \"isPackagedFinancialAidMoved\": true,\r\n"
									+ "    \"isProcessed\": true,\r\n"
									+ "    \"isProcessedNow\": true,\r\n"
									+ "    \"isReversed\": false,\r\n"
									+ "    \"isStartDateMoved\": true,\r\n"
									+ "    \"saTaskAssignedStaffId\": null,\r\n"
									+ "    \"saTaskTemplateId\": null,\r\n"
									+ "    \"studentGroupId\": null,\r\n"
									+ "    \"documents\": [],\r\n"
									+ "    \"courses\": [],\r\n"
									+ "    \"processdate\": \""+data.get("processdate")+"\"\r\n"
									+ "  }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(""+data.get("URI")+"");
																										
					int StatusCode = res.getStatusCode();
					
					String Statusline = res.getStatusLine();
														
					TestReportsLog.log(LogStatus.INFO, "Status Code = "+StatusCode);
														
					TestReportsLog.log(LogStatus.INFO, "Response Body = "+res.getBody().asString());
														
					TestReportsLog.log(LogStatus.INFO, "Status Line = "+Statusline);
														
					if(StatusCode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Transfer Enrollment records were successfully saved.");
					}
						else {
						TestReportsLog.log(LogStatus.FAIL, "The Transfer Enrollment records were not saved.");
															
					}
																						  
			}
				
				
				@Test
				public ArrayList<Integer> LedgerPostCharge(StringHash data) throws IOException {
					
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					Response res = given()
							.header("Authorization","Basic "+data.get("Token"))
							.body("{\r\n"
									+ "    \"payload\": {\r\n"
									+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
									+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
									+ "        \"BillingTransactionCodeId\": "+data.get("BillingTransactionCodeId")+",\r\n"
									+ "        \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
									+ "        \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
									+ "        \"TermId\": "+data.get("TermId")+",\r\n"
									+ "        \"StudentAccountClassSectionId\": null,\r\n"
									+ "        \"StudentAcademicYearPaymentPeriodId\": null,\r\n"
									+ "        \"TransactionDate\": \"2023/08/16 00:00:00\",\r\n"
									+ "        \"Description\": \"Activity Fee-Baylor\",\r\n"
									+ "        \"Reference\": \"\",\r\n"
									+ "        \"IsChargeAdjustment\": true,\r\n"
									+ "        \"IgnoreTermRequired\": false,\r\n"
									+ "        \"OverrideBilledDate\": null,\r\n"
									+ "        \"AllowProcessByAutomation\": null,\r\n"
									+ "        \"StudentEnrollmentPeriodFeeId\": null,\r\n"
									+ "        \"PaymentDueDate\": null\r\n"
									+ "    }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(data.get("URI"));
							
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					//res.header("Authorization","Basic "+token);
					
					int statuscode = res.getStatusCode();
					TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
					TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//					System.out.println(res.asString());
					System.out.println(res.getBody().asString());
					String responseBody = res.getBody().asString();
					//JsonPath path = new JsonPath(responseBody);
					//String LedgerId = path.getString("payload.data.studentAccountTransaction.id");	
					int LedgerId = res.getBody().jsonPath().getInt("payload.data.studentAccountTransaction.id");
					double LedgerTransNum = (res.getBody().jsonPath().getDouble("payload.data.studentAccountTransaction.transactionNumber"));
					System.out.println(LedgerId);
					System.out.println(LedgerTransNum);
					int TransNum=(int)LedgerTransNum;
					System.out.println(TransNum);
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(LedgerId);    
				    list.add(TransNum); 
					System.out.println(list);
					TestReportsLog.log(LogStatus.INFO, "Ledger id "+LedgerId);
					TestReportsLog.log(LogStatus.INFO, "Ledger transaction number "+LedgerTransNum);
					TestReportsLog.log(LogStatus.INFO, "Ledger transaction number "+TransNum);
					if(statuscode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Ledger charge is successfull posted");
					}
					else {
						TestReportsLog.log(LogStatus.FAIL, "The Ledger charge is not added");

					}
					return list;
				}
				@Test
				public void LedgerAdjustTransaction(StringHash data) throws Exception {
					
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ="; 
					APIAutomationPage Lpage = new APIAutomationPage();
					ArrayList Ledgerdata =Lpage.LedgerPostCharge(data);
					System.out.println(Ledgerdata.get(0));
					System.out.println(Ledgerdata.get(1));
					Response res = given()
							.header("Authorization","Basic "+data.get("Token"))
							.body("{\r\n"
									+ "    \"payload\": {\r\n"
									+ "        \"id\": "+Ledgerdata.get(0)+",\r\n"
									+ "        \"academicYearSequence\": 2,\r\n"
									+ "        \"achBatchFileId\": null,\r\n"
									+ "        \"admissionsRepId\": 2,\r\n"
									+ "        \"afterTaxAmount\": null,\r\n"
									+ "        \"agencyBranchCreditCardId\": null,\r\n"
									+ "        \"amountPaid\": 0,\r\n"
									+ "        \"appliedDate\": null,\r\n"
									+ "        \"awardBursaryConfigDetailId\": null,\r\n"
									+ "        \"bankAccountId\": null,\r\n"
									+ "        \"bankDepositId\": 0,\r\n"
									+ "        \"batchNumber\": \"\",\r\n"
									+ "        \"billingTransactionCode\": \"ENR\",\r\n"
									+ "        \"campusId\": 5,\r\n"
									+ "        \"cashDrawerSessionId\": null,\r\n"
									+ "        \"checkClearedDate\": null,\r\n"
									+ "        \"checkNumber\": \"\",\r\n"
									+ "        \"checkStatus\": \"\",\r\n"
									+ "        \"classSectionId\": null,\r\n"
									+ "        \"courseAmountToRetain\": null,\r\n"
									+ "        \"courseId\": null,\r\n"
									+ "        \"courseRefundPolicyId\": null,\r\n"
									+ "        \"createdByUserId\": 3502,\r\n"
									+ "        \"createdDateTime\": \"2022/08/11 09:19:11\",\r\n"
									+ "        \"creditCardAuthorizationNumber\": null,\r\n"
									+ "        \"creditCardBatchTransactionId\": null,\r\n"
									+ "        \"creditCardDeclineCode\": null,\r\n"
									+ "        \"depositId\": null,\r\n"
									+ "        \"description\": \"Enrollment Fee\",\r\n"
									+ "        \"discountAmount\": 0,\r\n"
									+ "        \"drn\": null,\r\n"
									+ "        \"eftClearedDate\": null,\r\n"
									+ "        \"eftNumber\": null,\r\n"
									+ "        \"eftStatus\": null,\r\n"
									+ "        \"exchangeRate\": null,\r\n"
									+ "        \"foreignExchangeGainLoss\": null,\r\n"
									+ "        \"invoiceAddedDate\": null,\r\n"
									+ "        \"invoiceNumber\": null,\r\n"
									+ "        \"isAutomatedProcess\": false,\r\n"
									+ "        \"isGeneralLedgerStatusFlag\": false,\r\n"
									+ "        \"isInPendingQueue\": false,\r\n"
									+ "        \"isManualCheckExtract\": null,\r\n"
									+ "        \"isPenaltyProcessed\": false,\r\n"
									+ "        \"isPostedToGeneralLedger\": false,\r\n"
									+ "        \"isPreviousYear1098t\": false,\r\n"
									+ "        \"isReconciledInCnf\": false,\r\n"
									+ "        \"isReissued\": false,\r\n"
									+ "        \"isSentBack\": false,\r\n"
									+ "        \"isTaxIncluded\": null,\r\n"
									+ "        \"isVoidedTransaction\": null,\r\n"
									+ "        \"lastModifiedDateTime\": \"2022/08/11 09:19:11\",\r\n"
									+ "        \"lastModifiedUserId\": 3502,\r\n"
									+ "        \"merchantProcessingCode\": null,\r\n"
									+ "        \"originalStudentAccountTransactionId\": null,\r\n"
									+ "        \"paidDisbursementId\": null,\r\n"
									+ "        \"paymentDueDate\": null,\r\n"
									+ "        \"paymentPeriodId\": 0,\r\n"
									+ "        \"paymentType\": null,\r\n"
									+ "        \"postDate\": \"2022/08/11 09:19:11\",\r\n"
									+ "        \"preferredCurrencyAmount\": null,\r\n"
									+ "        \"primaryCurrencyCodeId\": null,\r\n"
									+ "        \"receiptNumber\": null,\r\n"
									+ "        \"receiptPrintedDate\": null,\r\n"
									+ "        \"reference\": \"\",\r\n"
									+ "        \"refundCalculationId\": null,\r\n"
									+ "        \"refundId\": null,\r\n"
									+ "        \"registrationTermId\": null,\r\n"
									+ "        \"rowVersion\": \"AAAAAAsaOLs=\",\r\n"
									+ "        \"sa1098T\": \"I\",\r\n"
									+ "        \"source\": \"S\",\r\n"
									+ "        \"status\": \"O\",\r\n"
									+ "        \"studentAcademicYearPaymentPeriodId\": null,\r\n"
									+ "        \"studentAccountBatchBillingId\": null,\r\n"
									+ "        \"studentAccountPendingTransactionIdReference\": null,\r\n"
									+ "        \"studentAwardId\": 0,\r\n"
									+ "        \"studentBankAccountId\": null,\r\n"
									+ "        \"studentCreditCardId\": null,\r\n"
									+ "        \"studentEnrollmentPeriodFeeId\": null,\r\n"
									+ "        \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
									+ "        \"studentId\": "+data.get("StudentId")+",\r\n"
									+ "        \"studentRevenueDetailId\": null,\r\n"
									+ "        \"syAddressId\": null,\r\n"
									+ "        \"termId\": "+data.get("TermId")+",\r\n"
									+ "        \"transactionAmount\": "+data.get("TransactionAmount1")+",\r\n"
									+ "        \"transactionCurrencyCodeId\": null,\r\n"
									+ "        \"transactionDate\": \"2022/09/06 00:00:00\",\r\n"
									+ "        \"transactionNumber\": "+Ledgerdata.get(1)+",\r\n"
									+ "        \"tuitionDiscountPolicyId\": 0,\r\n"
									+ "        \"type\": \"I\",\r\n"
									+ "        \"vendorReferenceNumber\": null,\r\n"
									+ "        \"originalState\": \"H4sIAAAAAAAEANVabW8aORD+KxHfwy6bJk0RQeIlqdAlhQMu6n2ceAew4rU5v5Tu/frzmr02vbCpYO2DIqRI6zDzeDyeeWZmOz0pIR8vfsP8EZjB8UJpSfkSeD7P13j2NWNc3TRWWq/bUaTICjNQzYwSKZRY6CYRWZTE8UXUiqMZSgqM/g2aCh45waqxldCm32RsNpvm5qIp5LL4YSv6/HA/c2LPKVcaOMFGt1MBxy10R2knKv523L+c0ba2SzcNaFOu/9UHP9fX6F4lV3Fy1YmcnK4TWqm1Gk6PQIrWIn8iyBn+ZdBuoQJgioRmwPYCmdTHt+qDJqs7yvCV6ThlNw0tDTaiwxWkGVXKnrma4trb4dTf99KeRN6X1qVWA4kp1QOQaRgLZMJwPQFatflDDj5uxvZT2wrrNaOYDkH/1yl9bLwP/LlHSLH7IIYt5A9xLRR9Lf9Qx6ptUnebPpnsCWUFpO2P9kFVw0SUMftsbv1cASlC70CkVQFof2Dd20/TugYbQLY2ytsBXtbHo1ZDCRu08doFriC+O1gheR4wmxWCXT+n4mQ80aGZadBGnQIaBkrN0N2IMOcrjFS4Df1zMUUNlAdTE3AHU1wYnk4EoyQPo0aidf+0n/+hUHqLAheXcW2KUCIrbuecZpWsrVzej77ESXIeX5+3WvP4Q7tlv61mkrz3gLgkMj2jV0KWbHtnDPB0dqU+l/VeZJlQrlKqGyKxaQ135DIfeqo4hR/Ziki6LmzkMQtzKRjLkOuzO8S6XjSkynG2bfA6Oc46lCEC6e1Ch83GVkGwe2hl78ysPmSPlI0lIisi4UQKYilRhUc8CWENyPfyiAUwVdtfR+ojcpTA7jFdWtbmLHHHYHl6QEd8gjy1z383aKoyyhHxPQA3wBxVu/2qpY3lQTxqIpR1p7n44dxOzxoTiV+oMKro3bTiD9dVsfCIEKdIBCeUYTriA744RYBUKYNVvO6IyGY2XfaBPJ8asntQ+kGkdEF/Ke75EvbJUfkHlGQFXJcZzC4Hoo5jSZeUA5tpk1r/KrtfoYlx0Vu0rO2pKNgKFhhISV7IHhoMxJBKBROUVLzuxB6toVfCKh6E2LRNhTvseYo33OYatJVLMBZbyp/YBR2Mhk9xgfKNIcz/2YTa9lYGwIhhECw4bLUEEr2k9rHDPkeZhVEiNo8oVXXB/AQKr971bdiV+V73pOc+Csb36qbu5ZhBwRDn/mr6UW1EwkiPbt6d1Qbkt/nbHdcHVCbp7yPat3OQD3f+kRm4vlk5pAmqbrNrunm0nFqiCj0gLNUEnu+WWr434bbec4dh+vIV6jy+9/AuufZ0wP7m/fHlZe13MUpQU/yC3LLYYibDwhxR3ktTaQuNINJ3ZtqDq6v3tc36orrx3jJuJX6axi8whmTbcdt9PaJ9c357mEVrozPU2bEcE1TMBo+WW3YUasekYY/IUyG/lR11qqfo7dfxuv8Af+uDtq8nAAA=\",\r\n"
									+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
									+ "        \"extendedProperties\": [],\r\n"
									+ "        \"entityState\": 3,\r\n"
									+ "        \"billingTransactionCodeId\": "+data.get("BillingTransactionCodeId")+",\r\n"
									+ "        \"IsCalculateTransactionDueDate\": true,\r\n"
									+ "        \"note\": \"update\",\r\n"
									+ "        \"studentAcademicYearId\": "+data.get("StudentAcademicYearId")+"\r\n"
									+ "    }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(data.get("URII"));
							
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					//res.header("Authorization","Basic "+token);
					int statuscode = res.getStatusCode();
					TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
					TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//					System.out.println(res.asString());
					System.out.println(res.getBody().asString());
					System.out.println(res.getStatusCode());
					System.out.println(Ledgerdata.get(0));
					System.out.println(Ledgerdata.get(1));
					if(statuscode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Ledger charge is successully updated");
					}
					else {
						TestReportsLog.log(LogStatus.FAIL, "The Ledger charge is not updated");

					}
					
				}
		@Test	
		public void LedgerChargeDelete(StringHash data) throws Exception {
					
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
			APIAutomationPage Lpage = new APIAutomationPage();
					ArrayList Ledgerdata =Lpage.LedgerPostCharge(data);
					System.out.println(Ledgerdata.get(0));
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					Response res = given()
							.header("Authorization","Basic "+data.get("Token"))
							.body("{\r\n"
									+ "    \"payload\": {\r\n"
									+ "        \"Id\": "+Ledgerdata.get(0)+",\r\n"
									+ "        \"Note\": \"Del\"\r\n"
									+ "    }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post("https://sisclientweb-900070.campusnexus.cloud/api/commands/StudentAccounts/StudentAccountTransaction/DeleteAccountTransactionCharge");
							
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					//res.header("Authorization","Basic "+token);
					int statuscode = res.getStatusCode();
					TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
					TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//					System.out.println(res.asString());
					System.out.println(res.getBody().asString());
					System.out.println(Ledgerdata.get(0));
					System.out.println(res.getStatusCode());
					if(statuscode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Ledger charge is successfully deleted");
					}
					else {
						TestReportsLog.log(LogStatus.FAIL, "The Ledger charge is not deleted");

					}
				}

		@Test	
		public void AddLettertoEmp(StringHash data) throws Exception {
					
					//String token = "c25laGF2QDkwMDA3MGN1c3QuY2FtcHVzbmV4dXMuY2xvdWQ6TWFydXRoaUAx";
					Response res = given()
							.header("Authorization","Basic "+data.get("Token"))
							.body("{\r\n"
									+ "    \"payload\": {\r\n"
									+ "        \"isRequestFromMessage\": false,\r\n"
									+ "        \"taskStatusCode\": null,\r\n"
									+ "        \"crmSuppressFlag\": false,\r\n"
									+ "        \"id\": -1,\r\n"
									+ "        \"assignedToStaffId\": "+data.get("StaffId")+",\r\n"
									+ "        \"attachments\": null,\r\n"
									+ "        \"attachmentsId\": null,\r\n"
									+ "        \"classSectionId\": null,\r\n"
									+ "        \"completedByStaffId\": 0,\r\n"
									+ "        \"createdByStaffId\": "+data.get("StaffId")+",\r\n"
									+ "        \"createdDateTime\": \"2022/08/09 06:51:30\",\r\n"
									+ "        \"emailSubject\": \"task\",\r\n"
									+ "        \"employerContactId\": null,\r\n"
									+ "        \"employerId\": "+data.get("EmployerId")+",\r\n"
									+ "        \"employerJobId\": null,\r\n"
									+ "        \"isActivityNotViewed\": false,\r\n"
									+ "        \"lastModifiedDateTime\": \"2022/08/09 06:51:30\",\r\n"
									+ "        \"lastModifiedUserId\": "+data.get("StaffId")+",\r\n"
									+ "        \"lockedByUserId\": null,\r\n"
									+ "        \"note\": \"\",\r\n"
									+ "        \"organizationContactId\": null,\r\n"
									+ "        \"organizationId\": null,\r\n"
									+ "        \"previouslyAssignedToStaffId\": null,\r\n"
									+ "        \"priority\": \"Normal\",\r\n"
									+ "        \"prospectInquiryId\": null,\r\n"
									+ "        \"reassignedDate\": null,\r\n"
									+ "        \"remindDate\": null,\r\n"
									+ "        \"resultText\": \"\",\r\n"
									+ "        \"rowVersion\": null,\r\n"
									+ "        \"sessionSyCampusId\": 5,\r\n"
									+ "        \"sourceRecordId\": 0,\r\n"
									+ "        \"sourceSystem\": \"X\",\r\n"
									+ "        \"sourceTable\": \"\",\r\n"
									+ "        \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
									+ "        \"studentId\": "+data.get("StudentId")+",\r\n"
									+ "        \"subject\": \""+data.get("TaskTemplate")+"\",\r\n"
									+ "        \"taskDueDate\": \"2022/08/09 00:00:00\",\r\n"
									+ "        \"taskEndDate\": null,\r\n"
									+ "        \"taskResultId\": 0,\r\n"
									+ "        \"taskStartDate\": \"2022/08/09 00:00:00\",\r\n"
									+ "        \"taskStatusDate\": \"2022/08/09 06:51:30\",\r\n"
									+ "        \"taskStatusId\": "+data.get("TaskStatusId")+",\r\n"
									+ "        \"taskTemplateId\": "+data.get("TaskTemplateId")+",\r\n"
									+ "        \"taskTypeId\": "+data.get("TaskTypeId")+",\r\n"
									+ "        \"templateTextFile\": \"\",\r\n"
									+ "        \"workflowInstanceIdentifier\": null,\r\n"
									+ "        \"originalState\": \"H4sIAAAAAAAEALVVTUvDQBD9K5K72dbeShqoFkFsrTRRvK7JpB3cj7IzIV1/vUkq3iqCzHWHfe/tezOz2TIEHbfNI8RXbVrYNsQB3V67WMYjXJ2scbRIDszHuVJUHcBqSi1WwZNvOK28VTeTyUxNJ6qAgNrgp2b0To3AlJwR5viD0XVd2s1SH/bDxal626yLEfYaHbF2FSR5dkHOWMjXmnjja2wQ6heC8FBnajjPxitXOHdoFgmHFhKVj6WLWH8jWWmGEi0I0IhovwvQK5aU/eRZArbwbaigiMRgJXzx9migd+Y2FqybRsT8UtPHDqg1LAMP/RuGYOHE92gkUjirHwjEIt5B5UMtYtCZoNTvIt48B/QBOQo1zqqFYWqF0Pum55bECURiXRLh3kFdernR/d6b/9wO6vcvNf8CjMk0+3MHAAA=\",\r\n"
									+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
									+ "        \"extendedProperties\": [],\r\n"
									+ "        \"entityState\": 0\r\n"
									+ "    }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(data.get("URI"));
							
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					//res.header("Authorization","Basic "+token);
					int statuscode = res.getStatusCode();
					TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
					TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//					System.out.println(res.asString());
					System.out.println(res.getBody().asString());
					System.out.println(res.getStatusCode());
					if(statuscode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Letter is successfully added");
					}
					else {
						TestReportsLog.log(LogStatus.FAIL, "The Letter is not successfully added");

					}
				}
		@Test	
		public int CreateSubsidiary(StringHash data) throws Exception {
					
					//String token = "c25laGF2QDkwMDA3MGN1c3QuY2FtcHVzbmV4dXMuY2xvdWQ6TWFydXRoaUAx";
					Response res = given()
							.header("Authorization","Basic "+data.get("Token"))
							.body("{\r\n"
									+ "    \"payload\": {\r\n"
									+ "        \"SubsidiaryAccountTypeId\": 0,\r\n"
									+ "        \"SubsidiaryAccountTypeCode\": \""+SubCodeValue+"\",\r\n"
									+ "        \"SubsidiaryAccountTypeName\": \""+SubNameValue+"\",\r\n"
									+ "        \"IsActive\": true,\r\n"
									+ "        \"ReturnMethodCode\": \"\",\r\n"
									+ "        \"BalanceTransferBillCode\": \"\",\r\n"
									+ "        \"DefaultBillCodeId\": 0,\r\n"
									+ "        \"CampusIdList\": [\r\n"
									+ "            5\r\n"
									+ "        ],\r\n"
									+ "        \"OverrideAlreadyAssignedTransactionCode\": true,\r\n"
									+ "        \"BillCodeIdList\": [\r\n"
									+ "            "+data.get("BillingTransactionCodeId")+"\r\n"
									+ "        ],\r\n"
									+ "        \"CashPaymentIdList\": [],\r\n"
									+ "        \"GLAccountDetailList\": [\r\n"
									+ "            {\r\n"
									+ "                \"CampusName\": \"SIS College of Implementation\",\r\n"
									+ "                \"CampusId\": 5,\r\n"
									+ "                \"DebitAccount\": \"\",\r\n"
									+ "                \"CreditAccount\": \"\",\r\n"
									+ "                \"DebitAccountIndex\": null,\r\n"
									+ "                \"CreditAccountIndex\": null,\r\n"
									+ "                \"TransactionType\": \"D\",\r\n"
									+ "                \"JournalEntryId\": null,\r\n"
									+ "                \"CreditCostAccount\": \"\",\r\n"
									+ "                \"DebitCostAccount\": \"\"\r\n"
									+ "            }\r\n"
									+ "        ],\r\n"
									+ "        \"RefundGLAccountDetailList\": [\r\n"
									+ "            {\r\n"
									+ "                \"CampusName\": \"SIS College of Implementation\",\r\n"
									+ "                \"CampusId\": 5,\r\n"
									+ "                \"DebitAccount\": \"\",\r\n"
									+ "                \"CreditAccount\": \"\",\r\n"
									+ "                \"DebitAccountIndex\": null,\r\n"
									+ "                \"CreditAccountIndex\": null,\r\n"
									+ "                \"TransactionType\": \"R\",\r\n"
									+ "                \"JournalEntryId\": null,\r\n"
									+ "                \"CreditCostAccount\": \"\",\r\n"
									+ "                \"DebitCostAccount\": \"\"\r\n"
									+ "            }\r\n"
									+ "        ]\r\n"
									+ "    }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(data.get("URI"));
							
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					//res.header("Authorization","Basic "+token);
					int statuscode = res.getStatusCode();
					TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
					TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
					int SubId = res.getBody().jsonPath().getInt("payload.data.id");
					//ArrayList<Integer> list = new ArrayList<Integer>();
					//list.add(SubId); 
//					FileInputStream fis = new FileInputStream(FrameworkConstants.PS_DATA_XLS_PATH_API_Output);
					File file = new File(FrameworkConstants.PS_DATA_XLS_PATH_API);
					try {
						FileInputStream fis = new FileInputStream(file);
						XSSFWorkbook wb = new XSSFWorkbook(fis); 
						XSSFSheet sh = wb.getSheetAt(2);
						sh.getRow(0).createCell(0).setCellValue(SubId);
						FileOutputStream fos = new FileOutputStream(file);
						wb.write(fos);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
					//XSSFWorkbook wb = new XSSFWorkbook(fis);
//					//XSSFSheet sh = wb.createSheet();
//					XSSFSheet sh = wb.createSheet();
//					sh.createRow(0).createCell(0).setCellValue(SubId);
//					FileOutputStream fos = new FileOutputStream(FrameworkConstants.PS_DATA_XLS_PATH_API_Output);
//					wb.write(fos);
//					fos.close();
					System.out.println(SubId);
					System.out.println(res.getBody().asString());
					System.out.println(res.getStatusCode());
					if(statuscode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Subsidiary is successfully created");
					}
					else {
						TestReportsLog.log(LogStatus.FAIL, "The Subsidiary is not created");

					}
					driver.quit();
					return SubId;
					
				}

		@Test	
		public void AddSubsidiary(StringHash data) throws Exception {
					
					//String token = "c25laGF2QDkwMDA3MGN1c3QuY2FtcHVzbmV4dXMuY2xvdWQ6TWFydXRoaUAx";
//					StudentRestApiPage Lpage = new StudentRestApiPage();
//					int SubsiData =Lpage.CreateSubsidiary(data);
//					System.out.println(SubsiData);
					File file =    new File(FrameworkConstants.PS_DATA_XLS_PATH_API);
					FileInputStream fis = new FileInputStream(file);
					XSSFWorkbook wb = new XSSFWorkbook(fis); 
					XSSFSheet sh = wb.getSheetAt(2);
					System.out.println(sh.getRow(0).getCell(0).getNumericCellValue());
					double value = sh.getRow(0).getCell(0).getNumericCellValue();
					int ivalue = (int)value;
					System.out.println(ivalue);
					Response res = given()
							.header("Authorization","Basic "+data.get("Token"))
							.body("{\r\n"
									+ "    \"payload\": {\r\n"
									+ "        \"id\": -1,\r\n"
									+ "        \"accountBalance\": 0,\r\n"
									+ "        \"createdDateTime\": \"2022/08/09 07:28:23\",\r\n"
									+ "        \"lastModifiedDateTime\": \"2022/08/09 07:28:23\",\r\n"
									+ "        \"lastModifiedUserId\": "+data.get("StaffId")+",\r\n"
									+ "        \"minimumBalance\": null,\r\n"
									+ "        \"rowVersion\": null,\r\n"
									+ "        \"studentEnrollmentPeriodId\": null,\r\n"
									+ "        \"subsidiaryAccountTypeId\": 0,\r\n"
									+ "        \"originalState\": \"H4sIAAAAAAAEALWSQWvCQBCF/4rs3UystxADRS+lige19DokkziQ3ZWZkTT99dUt9KYIxes83ve+w5SvIjhu23caP7A/07ZVEw4dhnE/nmjy5fugC3c0OxUAWh/Jo2aea4kaW8vq6OElz+cwy2FHwtjzNxrHAAms7pdQ8B9jGIZsmGdRumtxBp+b9S5hpxzUMNTkqvKGTgqqNaptYsMtU3NQkremhOu9TJUJF4H7hTM5k4MqRTdZj42s0GjPnp4w8xT3pdDF+J/acP8zqh9MEFNEOgIAAA==\",\r\n"
									+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
									+ "        \"extendedProperties\": [],\r\n"
									+ "        \"entityState\": 0,\r\n"
									+ "        \"Id\": -1,\r\n"
									+ "        \"SubsidiaryAccountTypeId\": "+ivalue+",\r\n"
									+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
									+ "        \"MinimumBalance\": -"+data.get("MinimumBalance")+",\r\n"
									+ "        \"AccountBalance\": 0\r\n"
									+ "    }\r\n"
									+ "}")
							.when().contentType(ContentType.JSON)
							.post(data.get("URII"));
							
					//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
					//res.header("Authorization","Basic "+token);
					int statuscode = res.getStatusCode();
					TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
					TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//					System.out.println(res.asString());
					System.out.println(res.getBody().asString());
					System.out.println(res.getStatusCode());
					if(statuscode==200) {
						TestReportsLog.log(LogStatus.PASS, "The Subsidiary is successfully added");
					}
					else {
						TestReportsLog.log(LogStatus.FAIL, "The Subsidiary is not successfully added");

					}
				}
			@Test	
			public String SubPostCharge(StringHash data) throws Exception {
						
						//String token = "c25laGF2QDkwMDA3MGN1c3QuY2FtcHVzbmV4dXMuY2xvdWQ6TWFydXRoaUAx";
						Response res = given()
								.header("Authorization","Basic "+data.get("Token"))
								.body("{\r\n"
										+ "    \"payload\": {\r\n"
										+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
										+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
										+ "        \"BillingTransactionCodeId\": "+data.get("BillingTransactionCodeId")+",\r\n"
										+ "        \"StudentAcademicYearId\": "+data.get("StudentAcademicYearId")+",\r\n"
										+ "        \"TransactionAmount\": "+data.get("TransactionAmount")+",\r\n"
										+ "        \"TermId\": "+data.get("TermId")+",\r\n"
										+ "        \"TransactionDate\": \"2022/08/26 00:00:00\",\r\n"
										+ "        \"Description\": \"100 Online Fee\",\r\n"
										+ "        \"Reference\": \"\",\r\n"
										+ "        \"IsChargeAdjustment\": true,\r\n"
										+ "        \"IgnoreTermRequired\": false,\r\n"
										+ "        \"OverrideBilledDate\": null,\r\n"
										+ "        \"AllowProcessByAutomation\": null,\r\n"
										+ "        \"SubsidiaryAccountTypeId\": "+data.get("SubAccountTypeId")+",\r\n"
										+ "        \"PaymentDueDate\": null,\r\n"
										+ "        \"IsIncludeIn1098T\": 1\r\n"
										+ "    }\r\n"
										+ "}")
								.when().contentType(ContentType.JSON)
								.post(data.get("URI"));
								
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						//res.header("Authorization","Basic "+token);
						int statuscode = res.getStatusCode();
						TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
						TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
						String responseBody = res.getBody().asString();
						JsonPath path = new JsonPath(responseBody);
						String SubsidiaryId = path.getString("payload.data.studentSubsidiaryAccountTransaction.id");
						//int SubsidiaryId = res.getBody().jsonPath().getInt("payload.data.studentSubsidiaryAccountTransaction.id");
						System.out.println(SubsidiaryId);
//						ArrayList<String> list = new ArrayList<String>();
//						list.add(SubsidiaryId);  
//						System.out.println(res.asString());
						System.out.println(SubsidiaryId);
						System.out.println(res.getBody().asString());
						System.out.println(res.getStatusCode());
						if(statuscode==200) {
							TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
						}
						else {
							TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");

						}
						return SubsidiaryId;
					}
			
			@Test	
			public void SubAdjustTransaction(StringHash data) throws Exception {
						
						//String token = "c25laGF2QDkwMDA3MGN1c3QuY2FtcHVzbmV4dXMuY2xvdWQ6TWFydXRoaUAx";
				APIAutomationPage Lpage = new APIAutomationPage();
				String SubsidiaryId =Lpage.SubPostCharge(data);
				System.out.println(SubsidiaryId);
						Response res = given()
								.header("Authorization","Basic "+data.get("Token"))
								.body("{\r\n"
										+ "    \"payload\": {\r\n"
										+ "        \"id\": "+SubsidiaryId+",\r\n"
										+ "        \"academicYearSequence\": null,\r\n"
										+ "        \"afterTaxAmount\": null,\r\n"
										+ "        \"amount\": "+data.get("TransactionAmount")+",\r\n"
										+ "        \"bankAccountId\": null,\r\n"
										+ "        \"bankDepositId\": null,\r\n"
										+ "        \"billingTransactionCodeId\": "+data.get("BillingTransactionCodeId")+",\r\n"
										+ "        \"campusId\": 5,\r\n"
										+ "        \"cashDrawerSessionId\": null,\r\n"
										+ "        \"checkDate\": null,\r\n"
										+ "        \"checkNumber\": \"\",\r\n"
										+ "        \"checkStatus\": \"\",\r\n"
										+ "        \"createdDateTime\": \"2022/08/16 01:31:30\",\r\n"
										+ "        \"creditCardAuthorizationNumber\": null,\r\n"
										+ "        \"creditCardDeclineCode\": null,\r\n"
										+ "        \"description\": \"100 Online Fee\",\r\n"
										+ "        \"drn\": null,\r\n"
										+ "        \"eftClearedDate\": null,\r\n"
										+ "        \"eftNumber\": null,\r\n"
										+ "        \"eftStatus\": null,\r\n"
										+ "        \"exchangeRate\": null,\r\n"
										+ "        \"foreignExchangeGainLoss\": null,\r\n"
										+ "        \"isGeneralLedgerStatusFlag\": false,\r\n"
										+ "        \"isIncludedIn1098T\": true,\r\n"
										+ "        \"isInPendingQueue\": false,\r\n"
										+ "        \"isPostedToGeneralLedger\": false,\r\n"
										+ "        \"isPreviousYear\": false,\r\n"
										+ "        \"isReconciledInCnf\": false,\r\n"
										+ "        \"isReissued\": false,\r\n"
										+ "        \"isScholarshipOrGrant\": false,\r\n"
										+ "        \"isSentBack\": false,\r\n"
										+ "        \"isTaxIncluded\": null,\r\n"
										+ "        \"lastModifiedDateTime\": \"2022/08/16 01:31:30\",\r\n"
										+ "        \"lastModifiedUserId\": 3502,\r\n"
										+ "        \"paymentDueDate\": null,\r\n"
										+ "        \"paymentType\": \"\",\r\n"
										+ "        \"preferredCurrencyAmount\": null,\r\n"
										+ "        \"primaryCurrencyCodeId\": null,\r\n"
										+ "        \"receiptNumber\": \"\",\r\n"
										+ "        \"reference\": \"\",\r\n"
										+ "        \"rowVersion\": \"AAAAAAsgLuo=\",\r\n"
										+ "        \"source\": \"S\",\r\n"
										+ "        \"studentCreditCardId\": null,\r\n"
										+ "        \"studentRelationshipAddressId\": null,\r\n"
										+ "        \"studentSubsidiaryAccountId\": "+data.get("StudentSubAccountId")+",\r\n"
										+ "        \"studentSubsidiaryAccountRefundId\": null,\r\n"
										+ "        \"termId\": null,\r\n"
										+ "        \"transactionCurrencyCodeId\": null,\r\n"
										+ "        \"transactionDate\": \"2022/08/10 00:00:00\",\r\n"
										+ "        \"transactionNumber\": "+data.get("TransactionNumber")+",\r\n"
										+ "        \"type\": \"C\",\r\n"
										+ "        \"vendorReferenceNumber\": null,\r\n"
										+ "        \"originalState\": \"H4sIAAAAAAAEANWZbW/aMBDHvwrifYmBtesQRKKwVmh0dCWrtpfGvoBVx2Z+GGOffk7KWNeSTtSOYFEkpITc/Xz+53zndPtK4fUk/QDrO8wtTFJtFBNzLNbJegm1HxkXuldfGLPsRJEmC8iwbmSMKKllahpEZlELoXbURNEUFMOc/cSGSREVhnX9wUKHbW2sVqvGqt2Qap4/2Iy+XI+nhdkTJrTBgkA97pbgFDfiEe1G+W+3+EuNdYy71avjDhPmtz/8b3/1uPn2rBsVRuLCYqnLcpY+wRRcOL4CVlP4ZsHxP6ETjPfqRlmoR693k0krTMmwKRCWYb7X0E9RA7nDd/gXWNz3Ccnhns1KiHHn9oewlJpVZJ9x7q4lCguNSa7bgaQQTmDe+hrgbGl1MKBTfx69GCq8Aqd2rV28KpmWwQLI/RCbKl6lwvZHm81AlQT14aF94upJMzXYWH0MNApc0Gke+YRlT6O/zTeb23spr4VarRN0ftI8S1Cz03YnavinXwdMmRlgRfvWLKTaLD47pzeIeLb+hkBc5oA8XVTgZwiaKLbMxxJMFnETodpE5NS1SwDf0A/VU7QQA3+fmgF3a+mDCKtxUJk6nO2dr3II2yN9BQIU5mOgc5d9Cz+XHM9L9DGT0sVR7CWQFHPtrYuRHgnCLQU6Ek307jwJCJjHMATfDQjqrn+yYMuS3AHjdyO1S8KJ/GvCjxBTwXcmrc5L3+OjuwUiBWE8l+FApMcIyLS2UFbZHZDMmZMcK71gy4m6cqVxWeNxSEYQ5gKT+2MjG2NtriVlKfufyqjH1J81qGD9RvsUtXzhbvA6c7M9tFBRSbBxkF84ghrcJS5wld/RdCi3kILasa1xEBa5ugOly6viGdZw9uaCCazWewm1Xxx6Pray5yvYqbQqYLjiqTeQceWYMH+al0qa9o2XW+BFD5YvH31KFejn2xcB3U3tTDPK3HyX7UO9evOm5Z26yhjdO2VFNbOQgMrCpW//peXR1tqO9B1mLUQJQp3iDEj7cgJeSLWnmrzRQi5P8cAX5861UFJtFwefnjp6+RtE/Av1NY+npBgAAA==\",\r\n"
										+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
										+ "        \"extendedProperties\": [],\r\n"
										+ "        \"entityState\": 3,\r\n"
										+ "        \"studentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
										+ "        \"subsidiaryAccountTypeId\": "+data.get("SubAccountTypeId")+",\r\n"
										+ "        \"termIds\": [\r\n"
										+ "            "+data.get("TermId")+"\r\n"
										+ "        ],\r\n"
										+ "        \"studentSubsidiaryAccountTypeName\": \"SubsidiaryTest2\",\r\n"
										+ "        \"staffName\": \"Sneha V\",\r\n"
										+ "        \"note\": \"update\",\r\n"
										+ "        \"IsIncludeIn1098T\": true,\r\n"
										+ "        \"transactionAmount\": "+data.get("TransactionAmount1")+"\r\n"
										+ "    }\r\n"
										+ "}")
								.when().contentType(ContentType.JSON)
								.post(data.get("URII"));
								
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						//res.header("Authorization","Basic "+token);
						int statuscode = res.getStatusCode();
						TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
						TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//						System.out.println(res.asString());
						System.out.println(res.getBody().asString());
						System.out.println(res.getStatusCode());
						Assert.assertEquals(statuscode, 200);
						if(statuscode==200) {
							TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
						}
						else {
							TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");

						}
					}
			@Test	
			public ArrayList<String> DocumentCreation(StringHash data) throws Exception {
						
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						Response res = given()
								.header("Authorization","Basic "+data.get("Token"))
								.body("{\r\n"
										+ "    \"payload\": {\r\n"
										+ "        \"documentManagementSoftwareDocumentTypeMapping\": [],\r\n"
										+ "        \"id\": -1,\r\n"
										+ "        \"calculateDueDateDays\": null,\r\n"
										+ "        \"calculateDueDateType\": \"\",\r\n"
										+ "        \"campusGroupId\": 0,\r\n"
										+ "        \"code\": \""+DocCodeValue+"\",\r\n"
										+ "        \"createdDateTime\": \"2022/08/09 08:00:51\",\r\n"
										+ "        \"defaultCmDocStatusId\": null,\r\n"
										+ "        \"directionType\": \"F\",\r\n"
										+ "        \"downloadDocumentName\": null,\r\n"
										+ "        \"imageNowDocDesc\": null,\r\n"
										+ "        \"integrateToCrm\": false,\r\n"
										+ "        \"isActive\": true,\r\n"
										+ "        \"isAwardYearSpecific\": false,\r\n"
										+ "        \"isPlacementSpecific\": false,\r\n"
										+ "        \"isSystemCode\": false,\r\n"
										+ "        \"isTranscriptRequest\": false,\r\n"
										+ "        \"lastModifiedDateTime\": \"2022/08/09 08:00:51\",\r\n"
										+ "        \"lastModifiedUserId\": 3502,\r\n"
										+ "        \"moduleId\": "+data.get("ModuleId")+",\r\n"
										+ "        \"name\": \""+DocNameValue+"\",\r\n"
										+ "        \"permitTypes\": 0,\r\n"
										+ "        \"rowVersion\": null,\r\n"
										+ "        \"transcriptRequestType\": null,\r\n"
										+ "        \"campusGroup\": {\r\n"
										+ "            \"id\": -1,\r\n"
										+ "            \"approverStaffId\": null,\r\n"
										+ "            \"code\": \"\",\r\n"
										+ "            \"createdDateTime\": \"2022/08/09 08:00:51\",\r\n"
										+ "            \"financialCampusGroup\": false,\r\n"
										+ "            \"isActive\": true,\r\n"
										+ "            \"isSystemCode\": true,\r\n"
										+ "            \"lastModifiedDateTime\": \"2022/08/09 08:00:51\",\r\n"
										+ "            \"lastModifiedUserId\": 3502,\r\n"
										+ "            \"name\": \"\",\r\n"
										+ "            \"rowVersion\": null,\r\n"
										+ "            \"saStmtComments\": null,\r\n"
										+ "            \"saStmtLastCloseDate\": null,\r\n"
										+ "            \"type\": \"G\",\r\n"
										+ "            \"campusList\": [\r\n"
										+ "                {\r\n"
										+ "                    \"id\": -1,\r\n"
										+ "                    \"campusId\": 5,\r\n"
										+ "                    \"entityState\": 0,\r\n"
										+ "                    \"campusGroupId\": -1\r\n"
										+ "                }\r\n"
										+ "            ],\r\n"
										+ "            \"originalState\": \"H4sIAAAAAAAEAL2TS2vDMAyA/0rJfVG63kIaKOslrI9DurGrcZRWENvFUpt5v36LB7tlh4F3kQSSPgk9qo33Khz7ZwyvarjhsWfxZM/KhlO44uLdDJbX2UXkWgKwvqBRnBvS3rHrJdfOwGNRrGBZQIue1EAfSshZiGDOvgkl/TDGcczHVe78eUpcwtt+10bsA1kWZTVmdTXTTnTUTVfBpKsYsqDS0rDOxN8wgzq6ZnPnoU+uwwTYgzIpsA23gQVNoq4b3mihewr0ZKVYn0cl2G2/xImSjHynWPauo57+rcwLo//rscPvj11/AvHuFVP5AwAA\",\r\n"
										+ "            \"secureState\": \"H4sIAAAAAAAEANWV30/CMBDH/xWy963dDxJYxhKiiSGCPIDG17rd4JKtJe3hnH+9Y6jhpShCNL60zd31e5/e5dJkrLVo5sUtNA+i3MK8MKRRroRsls0Gei9VKc3IWRNtYsZMtoZKGK/CTCujCvIyVbGA85D5nC1AoyjxVRAqyTph4+wVYvzUqOvaq0NP6dXuos8eZ9NFJ+uiNCRkBk6aWHA6RzrJE7bbky6khzG1rpEjYpT0kU98nc9JXT9hnUbaCVoz2lGuVA4WmH30KTzs5xgaBEF+3S5LrGxE+bv7pBoFPAhcPnD5cMkHMedx3/d41PeHUWuOWsO5JZyYcUb4bIN+UqoEIU9iJr2F87EWjSGojnT4r9CmwtBM5VjgP2354QPuDeiLDXTY58G5cHfCWs3fHOnd6WIY6c03qsKOfwXpG19mGF8rBgAA\",\r\n"
										+ "            \"extendedProperties\": [],\r\n"
										+ "            \"entityState\": 0\r\n"
										+ "        },\r\n"
										+ "        \"electronicDocs\": [],\r\n"
										+ "        \"programs\": [],\r\n"
										+ "        \"agencies\": [],\r\n"
										+ "        \"originalState\": \"H4sIAAAAAAAEALWUUUvDMBDHv8rou83m3kY3GBVkuLFhp+jjkV63gyapd1dr/fSuFXybiJDHJNzv909ySbZmhn5fPWD/DHWL+0qUyZ/A98e+wcmHq70sk7NqszBG7BkdSOrIcpBQaWqDM7fT6dzMpqZAJqjpE5SCNyNYkm/Cgn4YXdel3TwNfBoKZ+Zlty1G7A15UfAWk1V2Jc64sNqC6C6UVBGWT4K8KTMzzGdjyYQWnuplotxiYlbj0lXW3yR3oHgkhxE0UbLnjJfEMWPn4JpW7jm0TZQdbLziiYf8IWcXQyBrq/Qe5Upl3QGXrwhcNGgvHWSjWA41WHToNaql6EXR5aGMc1RHBi+WqdFHfGtRNILl8ozbGqP06QHZkQ5j+R/d/P7/rr4A/27HAaAFAAA=\",\r\n"
										+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
										+ "        \"extendedProperties\": [],\r\n"
										+ "        \"entityState\": 0,\r\n"
										+ "        \"campusIdList\": [\r\n"
										+ "            5\r\n"
										+ "        ]\r\n"
										+ "    }\r\n"
										+ "}")
								.when().contentType(ContentType.JSON)
								.post(data.get("URI"));
								
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						//res.header("Authorization","Basic "+token);
						int statuscode = res.getStatusCode();
						TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
						TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
						//int DocId = res.getBody().jsonPath().getInt("payload.data.id");
						String responseBody = res.getBody().asString();
						JsonPath path = new JsonPath(responseBody);
						String DocmtId = path.getString("payload.data.id");
						System.out.println(DocmtId);
						ArrayList<String> list = new ArrayList<String>();
						list.add(DocmtId); 
//						System.out.println(res.asString());
						System.out.println(res.getBody().asString());
						System.out.println(res.getStatusCode());
						//System.out.println(DocmtId);
						Assert.assertEquals(statuscode, 200);
						if(statuscode==200) {
							TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
						}
						else {
							TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");

						}
						return list;
					}
			@Test	
			public void DocumentSchedule(StringHash data) throws Exception {
						
				//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
				APIAutomationPage Lpage = new APIAutomationPage();
				//ArrayList DocData =Lpage.DocumentCreation(data);
				//System.out.println(DocData.get(0));
						Response res = given()
								.header("Authorization","Basic "+data.get("Token"))
								.body("{\r\n"
										+ "    \"payload\": {\r\n"
										+ "        \"id\": -1,\r\n"
										+ "        \"awardYear\": \"\",\r\n"
										+ "        \"campusGroupId\": null,\r\n"
										+ "        \"createdDateTime\": \"2022/08/09 10:21:31\",\r\n"
										+ "        \"documentTypeId\": null,\r\n"
										+ "        \"dueDateDays\": 0,\r\n"
										+ "        \"dueDateType\": \"B\",\r\n"
										+ "        \"isActive\": true,\r\n"
										+ "        \"lastModifiedDateTime\": \"2022/08/09 10:21:31\",\r\n"
										+ "        \"lastModifiedUserId\": 3502,\r\n"
										+ "        \"name\": \""+DocSchNameValue+"\",\r\n"
										+ "        \"rowVersion\": null,\r\n"
										+ "        \"taskDocumentScheduleBasedOnEntityId\": 5,\r\n"
										+ "        \"campusGroup\": {\r\n"
										+ "            \"id\": -1,\r\n"
										+ "            \"approverStaffId\": null,\r\n"
										+ "            \"code\": \"\",\r\n"
										+ "            \"createdDateTime\": \"2022/08/09 10:21:31\",\r\n"
										+ "            \"financialCampusGroup\": false,\r\n"
										+ "            \"isActive\": true,\r\n"
										+ "            \"isSystemCode\": true,\r\n"
										+ "            \"lastModifiedDateTime\": \"2022/08/09 10:21:31\",\r\n"
										+ "            \"lastModifiedUserId\": 3502,\r\n"
										+ "            \"name\": \"\",\r\n"
										+ "            \"rowVersion\": null,\r\n"
										+ "            \"saStmtComments\": null,\r\n"
										+ "            \"saStmtLastCloseDate\": null,\r\n"
										+ "            \"type\": \"H\",\r\n"
										+ "            \"campusList\": [\r\n"
										+ "                {\r\n"
										+ "                    \"id\": -1,\r\n"
										+ "                    \"campusId\": 5,\r\n"
										+ "                    \"entityState\": 0,\r\n"
										+ "                    \"campusGroupId\": 21658\r\n"
										+ "                }\r\n"
										+ "            ],\r\n"
										+ "            \"originalState\": \"H4sIAAAAAAAEAL2TS2vDMAyA/0rJfVG63kIaKOslrI9DurGrcZRWENvFUpt5v36LB7tlh4F3kQSSPgk9qo33Khz7ZwyvarjhsWfxZM/KhlO44uLdDJbX2UXkWgKwvqBRnBvS3rHrJdfOwGNRrGBZQIue1EAfSshZiGDOvgkl/TDGcczHVe78eUpcwtt+10bsA1kWZTVmdTXTTnTUTVfBpKsYsqDS0rDOxN8wgzq6ZnPnoU+uwwTYgzIpsA23gQVNoq4b3mihewr0ZKVYn0cl2G2/xImSjHynWPauo57+rcwLo//rscPvj11/AvHuFVP5AwAA\",\r\n"
										+ "            \"secureState\": \"H4sIAAAAAAAEANWVUU/CMBDHvwrZ+9ZuA6PNWEL0QSLIw9D4em4dXLK1pD2c89MLQ40vRRGi8aVtctf//fq/XJqMjIF2Vt7I9h6qtZyVlgyqBah23q5k77mulB16S6KVYMzmS1mDDWrMjba6pCDXNYs4j1nIWSYNQoUvQKgV64Stt1MQ+KHRNE3QxIE2i+3FkD1MJ1kn66OyBCqXXpo4cLpAOi4Stt2TLqWHgjahoQcCFb3Xg6/reakfJqzTSDtBZ0U3yqUupANml30ID/s5hpFAsrjaLHOsXUTFW/ggjyIeRT4/9/nFPOQiCkUcBoOzQT/msc/7gvNjLRzbUU745IJ+1LqSoA5iJrOWx2NlrSVZ7+nwX6FNwNJUF1jiP2355wfcWWlONtDxgEfHwt2C083fHOnt6WQY6fU3XGH7v4L0FarrprUrBgAA\",\r\n"
										+ "            \"extendedProperties\": [],\r\n"
										+ "            \"entityState\": 0\r\n"
										+ "        },\r\n"
										+ "        \"criterion\": [\r\n"
										+ "            {\r\n"
										+ "                \"id\": -1,\r\n"
										+ "                \"documentAddTriggerId\": -1,\r\n"
										+ "                \"entityState\": 0,\r\n"
										+ "                \"taskDocumentScheduleEventTriggerId\": "+data.get("TaskTriggerId")+",\r\n"
										+ "                \"criteriaIdValue\": 1,\r\n"
										+ "                \"criteriaCodeValue\": \"1\",\r\n"
										+ "                \"rowVersion\": null\r\n"
										+ "            }\r\n"
										+ "        ],\r\n"
										+ "        \"addDocumentTypes\": [\r\n"
										+ "            {\r\n"
										+ "                \"id\": -1,\r\n"
										+ "                \"documentTypeId\": "+data.get("DocumentTypeId")+",\r\n"
										+ "                \"documentAddTriggerId\": -1,\r\n"
										+ "                \"entityState\": 0,\r\n"
										+ "                \"rowVersion\": null\r\n"
										+ "            }\r\n"
										+ "        ],\r\n"
										+ "        \"originalState\": \"H4sIAAAAAAAEALWSTWvCQBCG/4rs3UystxADohep4sEPel02Ex3I7srMpGn666tb6M1SCrm+L/O8z2HKJbMd9s0rDmfbdrhvRJnCxYbhONxw8uHbIAtzVb0VAOKu6K1knhxHiY1mLnp4yfM5zHI4IJNt6dMqxQAJLOabUNAPo+/7rJ9nkS+Pwxm87baHhJ1SELXBoanKJzqpqLZWdBdragjrkyBv6hIeeZlOJlQEahdGuUMDVaqesv42sraKR/I4wswo7ivGu/Go2rJ0Su9joNcdJvF78D86/P7S1RcCD1qh8wIAAA==\",\r\n"
										+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
										+ "        \"extendedProperties\": [],\r\n"
										+ "        \"entityState\": 0,\r\n"
										+ "        \"isChanged\": true\r\n"
										+ "    }\r\n"
										+ "}")
								.when().contentType(ContentType.JSON)
								.post("https://sisclientweb-900070.campusnexus.cloud/api/commands/Crm/DocumentAddTrigger/SaveNew");
								
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						//res.header("Authorization","Basic "+token);
						int statuscode = res.getStatusCode();
						TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
						TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//						System.out.println(res.asString());
						//System.out.println(DocData.get(0));
						System.out.println(res.getBody().asString());
						System.out.println(res.getStatusCode());
						Assert.assertEquals(statuscode, 200);
						if(statuscode==200) {
							TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
						}
						else {
							TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");

						}
					}
//			@Test	
//			public void DocumentPolicy(StringHash data) throws Exception {
//						
//						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
//						Response res = given()
//								.header("Authorization","Basic "+data.get("Token"))
//								.body("{\r\n"
//										+ "    \"payload\": {\r\n"
//										+ "        \"isOverrideStaffMembersAssigned\": false,\r\n"
//										+ "        \"id\": -1,\r\n"
//										+ "        \"code\": \""+DocPolyCodeValue+"\",\r\n"
//										+ "        \"createdDateTime\": \"2022/08/10 03:09:40\",\r\n"
//										+ "        \"lastModifiedDateTime\": \"2022/08/10 03:09:40\",\r\n"
//										+ "        \"lastModifiedUserId\": "+data.get("StaffId")+",\r\n"
//										+ "        \"name\": \""+DocPolyNameValue+"\",\r\n"
//										+ "        \"rowVersion\": null,\r\n"
//										+ "        \"modulePolicies\": [],\r\n"
//										+ "        \"modulePolicyStatuses\": [],\r\n"
//										+ "        \"documentTypePolicies\": [\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 59,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 61,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 64,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 65,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 66,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 67,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 68,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 69,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 70,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 71,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 72,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 73,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 74,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 75,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 76,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 77,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 78,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 79,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 80,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 81,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 82,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 83,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 84,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 85,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 86,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 88,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 89,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 90,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 91,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 92,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 93,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 94,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 95,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 98,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 100,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 105,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 106,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 107,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 108,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 111,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 112,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 113,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 114,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 115,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 116,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 117,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 118,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 119,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 120,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 121,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 122,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 123,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 124,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 125,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 126,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 127,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 128,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 129,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 130,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 131,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 132,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 133,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 134,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 135,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 136,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 137,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 138,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 139,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 140,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 141,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 142,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 143,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 144,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 145,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 146,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 147,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 148,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 149,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 150,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 151,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 152,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 153,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 154,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 155,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 156,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 157,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 158,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 159,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 160,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 161,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 162,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 163,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 164,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 165,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 166,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 167,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 168,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 169,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 170,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 173,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 175,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 177,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 179,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 180,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 181,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 183,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 184,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 185,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 186,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 187,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 188,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 189,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 190,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 191,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 192,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 193,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 194,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 195,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 196,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 197,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 198,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 199,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 200,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 201,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 202,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 203,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 204,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 205,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 206,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 207,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 208,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 209,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 210,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 211,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 212,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 213,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 214,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 215,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 216,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 217,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 218,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 219,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 220,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 221,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 222,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 223,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 224,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 225,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 226,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 227,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 228,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 229,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 230,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 231,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 232,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 233,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 234,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 235,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 236,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 237,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 238,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 239,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 240,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 241,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 242,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 243,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 244,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 245,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 246,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 247,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 248,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 249,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 250,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 251,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 253,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 254,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 255,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 256,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 257,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 258,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 259,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 260,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 261,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 262,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 263,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 264,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 265,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 266,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 267,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 269,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 270,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 271,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 272,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 273,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 274,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 275,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 276,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 277,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 278,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 279,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 280,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 281,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 282,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 283,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 284,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 285,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 286,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 287,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 288,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 289,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 290,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 291,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 292,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 293,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 294,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 295,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 296,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 297,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 298,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 299,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 300,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 301,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 302,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 303,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 304,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 305,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 307,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 309,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 310,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 312,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 316,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 317,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 318,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 320,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            },\r\n"
//										+ "            {\r\n"
//										+ "                \"documentPolicyId\": -1,\r\n"
//										+ "                \"documentTypeId\": 321,\r\n"
//										+ "                \"isAllowedToAssign\": true,\r\n"
//										+ "                \"isAllowedToViewOnReports\": true,\r\n"
//										+ "                \"isAllowedToDisplayAttachment\": true,\r\n"
//										+ "                \"isAllowedToEdit\": true,\r\n"
//										+ "                \"isAllowedToDelete\": true,\r\n"
//										+ "                \"entityState\": 0\r\n"
//										+ "            }\r\n"
//										+ "        ],\r\n"
//										+ "        \"documentTypePolicyStatuses\": [],\r\n"
//										+ "        \"originalState\": \"H4sIAAAAAAAEALWSQWvCQBCF/4rs3UystxADRS+lige19DokkziQ3ZWZkTT99dUt9KYIxes83ve+w5SvIjhu23caP7A/07ZVEw4dhnE/nmjy5fugC3c0OxUAWh/Jo2aea4kaW8vq6OElz+cwy2FHwtjzNxrHAAms7pdQ8B9jGIZsmGdRumtxBp+b9S5hpxzUMNTkqvKGTgqqNaptYsMtU3NQkremhOu9TJUJF4H7hTM5k4MqRTdZj42s0GjPnp4w8xT3pdDF+J/acP8zqh9MEFNEOgIAAA==\",\r\n"
//										+ "        \"secureState\": \"H4sIAAAAAAAEAD3MQQrCMBAAwK9I7mZTeysqeFbpoSJel5C0C01Ssisxvl6s4ANm9qecsfb+7Ood56frPUumOGKst7q4zSvMkQ9qElk6ALaTC8g6kM2JkxdtU4CdMS00BgaXCWd6o1CKsMasfkNH/6OUokurUx6/sIHH9TKs7ZYiC0brFBw/juQnSpcAAAA=\",\r\n"
//										+ "        \"extendedProperties\": [],\r\n"
//										+ "        \"entityState\": 0,\r\n"
//										+ "        \"isChanged\": false\r\n"
//										+ "    }\r\n"
//										+ "}")
//								.when().contentType(ContentType.JSON)
//								.post(data.get("URI"));
//								
//						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
//						//res.header("Authorization","Basic "+token);
//						int statuscode = res.getStatusCode();
//						TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
//						TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
////						System.out.println(res.asString());
//						System.out.println(res.getBody().asString());
//						System.out.println(res.getStatusCode());
//						Assert.assertEquals(statuscode, 200);
//						if(statuscode==200) {
//							TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
//						}
//						else {
//							TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");
//
//						}
//					}
			@Test	
			public void AddDocumentToStudent(StringHash data) throws Exception {
						
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
				//StudentRestApiPage Lpage = new StudentRestApiPage();
				//ArrayList DocData =Lpage.DocumentCreation(data);
				//System.out.println(DocData.get(0));
						Response res = given()
								.header("Authorization","Basic "+data.get("Token"))
								.body("{\r\n"
										+ "    \"payload\": {\r\n"
										+ "        \"id\": -1,\r\n"
										+ "        \"studentId\": "+data.get("StudentId")+",\r\n"
										+ "        \"moduleId\": "+data.get("ModuleId")+",\r\n"
										+ "        \"StudentEnrollmentPeriodId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
										+ "        \"requestedDate\": \"2022/08/10 00:00:00\",\r\n"
										+ "        \"documentTypeId\": "+data.get("DocumentTypeId")+",\r\n"
										+ "        \"documentStatusId\": "+data.get("DocumentStatusId")+",\r\n"
										+ "        \"approvedDate\": null,\r\n"
										+ "        \"awardYear\": null,\r\n"
										+ "        \"studentPlacementId\": null,\r\n"
										+ "        \"createdByUserId\": "+data.get("StaffId")+"\r\n"
										+ "    }\r\n"
										+ "}")
								.when().contentType(ContentType.JSON)
								.post(data.get("URII"));
								
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						//res.header("Authorization","Basic "+token);
						int statuscode = res.getStatusCode();
						TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
						TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//						System.out.println(res.asString());
						System.out.println(res.getBody().asString());
						System.out.println(res.getStatusCode());
						Assert.assertEquals(statuscode, 200);
						if(statuscode==200) {
							TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
						}
						else {
							TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");

						}
					}
			@Test	
			public void AddDocumentListToStudent(StringHash data) throws Exception {
						
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						Response res = given()
								.header("Authorization","Basic "+data.get("Token"))
								.body("{\r\n"
										+ "    \"payload\": {\r\n"
										+ "        \"StudentId\": "+data.get("StudentId")+",\r\n"
										+ "        \"ModuleId\": 0,\r\n"
										+ "        \"EnrollmentId\": "+data.get("StudentEnrollmentPeriodId")+",\r\n"
										+ "        \"DateRequested\": \"2022/08/10 00:00:00\",\r\n"
										+ "        \"DocumentTypeListId\": "+data.get("DocumentTypeListId")+",\r\n"
										+ "        \"DateApproved\": null,\r\n"
										+ "        \"DocumentStatusId\": "+data.get("DocumentStatusId")+",\r\n"
										+ "        \"AwardYear\": null,\r\n"
										+ "        \"StudentPlacementId\": null\r\n"
										+ "    }\r\n"
										+ "}")
								.when().contentType(ContentType.JSON)
								.post(data.get("URI"));
								
						//String token = "Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
						//res.header("Authorization","Basic "+token);
						int statuscode = res.getStatusCode();
						TestReportsLog.log(LogStatus.INFO, "status code "+statuscode);
						TestReportsLog.log(LogStatus.INFO, "response body "+res.getBody().asString());
//						System.out.println(res.asString());
						System.out.println(res.getBody().asString());
						System.out.println(res.getStatusCode());
						Assert.assertEquals(statuscode, 200);
						if(statuscode==200) {
							TestReportsLog.log(LogStatus.PASS, "The Student were successfully added");
						}
						else {
							TestReportsLog.log(LogStatus.FAIL, "The Student were not successfully added");

						}
					}
}