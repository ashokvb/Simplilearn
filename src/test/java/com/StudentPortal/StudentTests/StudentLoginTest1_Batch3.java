package com.StudentPortal.StudentTests;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StudentPortal.Businessflow.StudentLoginTest1Flow;
import com.framework.base.constants.FrameworkConstants;
import com.framework.core.AutomationTestPlan;
import com.framework.util.DataUtil;
import com.framework.util.StringHash;
import com.framework.util.TestCaseFields;
import com.framework.util.Xls_Reader;

public class StudentLoginTest1_Batch3 extends AutomationTestPlan {
		
		public StudentLoginTest1_Batch3() {
			xls = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
		}
//Test 17 ---School Fields - Confirm new information can be added to field for Student Accounts
		@Test(enabled = true, dataProvider = "getData", priority = 25,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Student Accounts", testName = "School Fields - Confirm new information can be added to field for Student Accounts")
					@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Student Accounts")
					public void TC1747_SchooldefinedFieldStdAcct(StringHash data) throws Exception {
					StudentLoginTest1Flow.SchoolDefinedFiledStudentAccounts(data);
				}
		
//Test 18 ---School Fields - Confirm new information can be added to field for Admissions
		@Test(enabled = true, dataProvider = "getData", priority = 26,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Admissions", testName = "School Fields - Confirm new information can be added to field for Admissions")
					@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Admissions")
					public void TC1748_SchooldefinedFieldAdmission(StringHash data) throws Exception {
					StudentLoginTest1Flow.SchoolDefinedFieldAdmission(data);
				}
		
//Test 19 ---School Fields - Confirm new information can be added to field for Student Services
		@Test(enabled = true, dataProvider = "getData", priority = 27,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Student Services", testName = "School Fields - Confirm new information can be added to field for Student Services")
					@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Student Services")
					public void TC1749_SchooldefinedFieldStudServ(StringHash data) throws Exception {
					StudentLoginTest1Flow.SchoolDefinedFieldStudentServices(data);
				}
		
//Test 20 ---School Fields - Confirm new information can be added to field for Career Services
		@Test(enabled = true, dataProvider = "getData", priority = 28,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Career Services", testName = "School Fields - Confirm new information can be added to field for Career Services")
					@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Career Services")
					public void TC1750_SchooldefinedFieldCarServ(StringHash data) throws Exception {
					StudentLoginTest1Flow.SchoolDefinedFieldCareerServices(data);
				}
		
//Test 21 ---School Fields - Confirm new information can be added to field for Housing School Fields
		@Test(enabled = true, dataProvider = "getData", priority = 29,alwaysRun = true, description ="School Fields - Confirm new information can be added to field for Housing School Fields", testName = "School Fields - Confirm new information can be added to field for Housing School Fields")
					@TestCaseFields(testCaseName = "School Fields - Confirm new information can be added to field for Housing School Fields")
					public void TC1751_SchooldefinedFieldHousingStdServ(StringHash data) throws Exception {
					StudentLoginTest1Flow.SchoolDefinedFieldHousingStudentServices(data);
						
		        }
		
//Test 25 ---Ability to add document lists to individual Student record from the Financial Aid module
		@Test(enabled = true, dataProvider = "getData", priority = 30,alwaysRun = true, description ="Ability to add document lists to individual Student record from the Financial Aid module", testName = "Ability to add document lists to individual Student record from the Financial Aid module")
					@TestCaseFields(testCaseName = "Ability to add document lists to individual Student record from the Financial Aid module")
					public void TC1739_4AbilitytoadddocumentliststoindividualStudentrecordfromtheFinancialAidmodule(StringHash data) throws Exception {
					StudentLoginTest1Flow.AddingDocumentListtoStudent(data);
				}		
		
		
		@DataProvider
		public Object[][] getData(Method method) {

			return DataUtil.getData(xls, method.getAnnotation(TestCaseFields.class).testCaseName());
		}
}
