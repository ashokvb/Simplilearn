package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byXPath;


import java.util.concurrent.TimeUnit;


import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;

public class StudentAccountSchoolFieldsPage extends BasePage{

	static Link ContactManager = new Link("Contact Manager", byXPath("//cns-panel-bar/ul/li[1]/span"));
	static Link Admissions = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[2]/span"));
	static Link AcademicRecords = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[3]/span"));
	static Link CareerServices = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[4]/span"));
	static Link FinancialAid = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[5]/span"));
	static Link StudentAccounts = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[6]/span"));
	static Link StudentServices = new Link("Contact Manager", byXPath("//cns-panel-bar/ul/li[7]/span"));
	static Link SchoolFieldsStdAcc = new Link("School fields", byXPath("(//span[text()='School Fields'])[5]"));
	static Link SchoolFieldsAdmission = new Link("School fields", byXPath("(//span[text()='School Fields'])[1]"));
	static Link SchoolFieldsStdserv = new Link("School fields", byXPath("(//span[text()='School Fields'])[6]"));
	static Link SchoolFieldsCarserv = new Link("School fields", byXPath("(//span[text()='School Fields'])[3]"));
	static Button HousingSchoolFields = new Button("Housing School Fields", byXPath("//button[text()='Housing School Fields']"));
	static TextField InternationalStudent = new TextField("International Student", byXPath("//input[@aria-label='INTSTU']"));
	static TextField FirstGenerationStudent = new TextField("First generation Student", byXPath("//span[@aria-label='First Generation Student: Dropdown']"));
	static TextField FetchingFGS = new TextField("Fecthing First generation Student", byXPath("//div[2]/div[1]/div/div/cmc-drop-down-list-classic/div/div/span/span"));
	static TextField DisabilityRequest = new TextField("Disability request", byXPath("//span[@aria-label='Disability Request: Dropdown']"));
	static TextField GenderIdentity = new TextField("Gender Identity", byXPath("//span[@aria-label='Gender Identity: Dropdown']"));
	static TextField LeftHanded = new TextField("Left Handed", byXPath("//input[@aria-label='LeftHand']"));
	static Button Save = new Button("Save button", byXPath("(//button[@aria-label='Save'])[2]"));
	static Link Successmsg = new Link("Success message", byXPath("//div[59]//span[2]"));
	static Link Clear = new Link("Clear existing data", byXPath("//span[@aria-label='delete']"));
	static Link SelectingLeftHand= new Link("Selecting LeftHand", byXPath("(//li[text()='Yes'])[2]"));
	static Link SelectingINTSTU= new Link("Selecting INTSTU", byXPath("//li[text()='YES']"));
	static Link SelectingFGS= new Link("Selecting First Generation student", byXPath("(//li[text()='Yes'])[1]"));
	static Link SelectingDisreq= new Link("Selecting Disability request", byXPath("(//li[text()='Yes'])[3]"));
	static Link SelectingGenIden= new Link("Selecting Gender Identity", byXPath("//li[text()='Woman']"));
	//static Button Save = new Button("Save button", byXPath("(//button[@aria-label='Save'])[2]"));	
	Link SchFieldMsg= new Link("School defined filed Msg", byXPath("//span[text()='The Student records were successfully saved.']"));

	public StudentAccountSchoolFieldsPage AccountSchoolField(StringHash data) throws Exception{
		
		waitForPageToLoad();
		scrollPage(0, 100);
		SchoolFieldsStdAcc.clickUsingJavaScriptExecutor();
		wait(5);
		scrollPage(0, 500);
		wait(2);
		InternationalStudent.deleteAndType(data.get("IntStudent"));
		wait(3);
		SelectingINTSTU.click();
		wait(2);
		scrollPage(0, -800);
		wait(2);
		Save.click();
		wait(2);
		CustomAsserts.containsString(SchFieldMsg.getText(), data.get("SchFieldMsg").toString());
//		scrollPage(0, 500);
//		String INTSTU = InternationalStudent.getText();
//		System.out.println(INTSTU);
//		System.out.println("School field added successfully for Student Accounts");
		return this;
		
	}
	
    public StudentAccountSchoolFieldsPage AdmissionSchoolField(StringHash data) throws Exception{

    	Link SelectingFGS= new Link("Selecting First Generation student", byXPath("(//li[text()='"+data.get("FirstGenStudent")+"'])[1]"));
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		waitForPageToLoad();
		wait(3);
		Admissions.click();
		wait(2);
		SchoolFieldsAdmission.clickUsingJavaScriptExecutor();
		wait(5);
		FirstGenerationStudent.sendKeys(data.get("FirstGenStudent"));
		wait(2);
		SelectingFGS.click();
		wait(2);
		scrollPage(0, -300);
		wait(2);
		Save.click();
		wait(3);
		CustomAsserts.containsString(SchFieldMsg.getText(), data.get("SchFieldMsg").toString());
//		FirstGenerationStudent.waitTillElementFound();
//		String FGS = FirstGenerationStudent.getText();
//		System.out.println(FGS);
//		System.out.println("School field added successfully for Admissions");

		return this;
		
	}
    
    public StudentAccountSchoolFieldsPage StudentServiceSchoolField(StringHash data) throws Exception{

    	Link SelectingDisreq= new Link("Selecting Disability request", byXPath("(//li[text()='"+data.get("DisRequest")+"'])[3]"));
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		waitForPageToLoad();
		StudentServices.clickUsingJavaScriptExecutor();
		wait(1);
		SchoolFieldsStdserv.clickUsingJavaScriptExecutor();
		wait(5);
		scrollPage(0, 200);
		wait(2);
		scrollPage(0, -200);
		DisabilityRequest.sendKeys(data.get("DisRequest"));
		wait(2);
		SelectingDisreq.click();
		wait(2);
		scrollPage(0, -500);
		wait(2);
		Save.click();
		wait(2);
		CustomAsserts.containsString(SchFieldMsg.getText(), data.get("SchFieldMsg").toString());
//		DisabilityRequest.waitTillElementFound();
//		String DR = DisabilityRequest.getText();
//		System.out.println(DR);
//		System.out.println("School field added successfully for Student Services");
		return this;
		
	}
    
    public StudentAccountSchoolFieldsPage StudentServiceHousingSchoolField(StringHash data) throws Exception{

    	Link SelectingLeftHand= new Link("Selecting LeftHand", byXPath("(//li[text()='"+data.get("LeftHanded")+"'])[2]"));
    	Link HouSchFieldMsg= new Link("Housing School defined filed Msg", byXPath("//span[text()='The Student Services Housing School Fields were successfully saved.']"));
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		waitForPageToLoad();
		StudentServices.clickUsingJavaScriptExecutor();
		wait(1);
		SchoolFieldsStdserv.clickUsingJavaScriptExecutor();
		wait(3);
		scrollPage(0, -500);
		wait(2);
		HousingSchoolFields.clickUsingJavaScriptExecutor();
		wait(5);
		LeftHanded.deleteAndType(data.get("LeftHanded"));
		wait(1);
		SelectingLeftHand.click();
		wait(2);
		scrollPage(0, -500);
		wait(2);
		Save.click();
		wait(4);
		CustomAsserts.containsString(HouSchFieldMsg.getText(), data.get("HouSchFieldMsg").toString());
//		scrollPage(0, 200);
//		LeftHanded.waitTillElementFound();
//		String LH = LeftHanded.getText();
//		System.out.println(LH);
//		System.out.println("School field added successfully for Student Services Housing Fileds");
		return this;
		
	}
    
    	public StudentAccountSchoolFieldsPage CareerServiceSchoolField(StringHash data) throws Exception{

    	Link SelectingGenIden= new Link("Selecting Gender Identity", byXPath("//li[text()='"+data.get("GenderIdentity")+"']"));
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;	
		waitForPageToLoad();
		CareerServices.clickUsingJavaScriptExecutor();
		wait(1);
		SchoolFieldsCarserv.clickUsingJavaScriptExecutor();
		wait(6);
		scrollPage(0, -200);
		wait(1);
		GenderIdentity.sendKeys(data.get("GenderIdentity"));
		wait(2);
		SelectingGenIden.click();
		wait(2);
		scrollPage(0, -500);
		wait(2);
		Save.click();
		wait(4);
		CustomAsserts.containsString(SchFieldMsg.getText(), data.get("SchFieldMsg").toString());
//		GenderIdentity.waitTillElementFound();
//		String GI = GenderIdentity.getText();
//		System.out.println(GI);
//		System.out.println("School field added successfully for Career Services");
		return this;
    	}	
}
