package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byXPath;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.framework.elements.Locator.byCSSSelector;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Dropbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;

public class StudentStudentPage extends BasePage {
	
	static String LastNameValue = AppendValue.apendString();
	static String FirstNameValue = AppendValue.apendString();
	static Link New_Prospect = new Link("New Prospect", byCSSSelector("#listAddProspectButton"));
	static TextField LastName = new TextField("Last Name Field", byCSSSelector("#LastName"));
	static TextField FirstName = new TextField("First Name Field", byXPath("//div[2]/div/div//input"));
	static TextField Zip_Code = new TextField("Zip code", byCSSSelector("[name='Zip_input']"));
	//static Link SelectingZipCode = new Link("Selecting ZipCode", byXPath("//span[. = '00501']"));
	//static TextField PhoneNumber = new TextField("Phone number", byXPath("//input[@id='Phone']"));
	static TextField PhoneNumber = new TextField("Phone number", byXPath("//input[@placeholder = '(###) ###-####']"));
	static TextField Email = new TextField("Email", byXPath("//input[@name='email']"));
	static Link SaveandClose = new Link("Save & Close", byXPath("//div/a[. = 'Save & Close']"));
	static Button Dontsave = new Button("Don't Save", byXPath("//button[. = concat('Don', \"'\", 't Save')]"));
	static TextField SearchName = new TextField("Search Name", byXPath("//input[@placeholder='Search Name']"));
	//static Link SelectingStudent = new Link("Selecting Student", byXPath("//span[text()='Testing, Regression']"));
	static Link SelectingStudent = new Link("Selecting Student", byXPath("//div[2]//td[1]"));
	static Link ContactManager = new Link("Contact Manager", byXPath("//cns-panel-bar/ul/li[1]/span"));
	static Link Admissions = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[2]/span"));
	static Link AcademicRecords = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[3]/span"));
	static Link CareerServices = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[4]/span"));
	static Link FinancialAid = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[5]/span"));
	static Link StudentAccounts = new Link("Contact Manager", byXPath("//cns-panel-bar/ul[1]/li[6]/span"));
	static Link StudentServices = new Link("Contact Manager", byXPath("//cns-panel-bar/ul/li[7]/span"));
	static Link Tasks = new Link("Tasks", byXPath("//span[text()='Tasks']"));
	static Button NewButton = new Button("New TaskTemplate", byXPath("//a[@id='newButton']"));
	static TextField TaskTemplate = new TextField("Task Template", byXPath("//input[@name='taskTemplateId_input']"));
	//static Link SelectingTaskTemplate= new Link("Selecting TaskTemplate", byXPath("//span[. = 'Duplicate Lead']"));
	static Link SaveAndCloseTask= new Link("Save and close Task", byXPath("(//button[@aria-label= 'Save & Close'])[2]"));
	static Link Documents = new Link("Documents", byXPath("//span[text()='Documents']"));
	static Link NewDocument = new Link("New Document", byXPath("//a[text()='New Document']"));
	static Link NewDocumentList = new Link("New DocumentList", byXPath("//a[text()='New Document List']"));
	static TextField Module = new TextField("Module", byXPath("//input[@name='studentDocModule_input']"));
	static Link SelectingModule= new Link("Selecting Module", byXPath("(//span[text()=\"Career Services\"])[1]"));
	static TextField DocumentList = new TextField("Document List", byXPath("//input[@name='studentDocName_input']"));
	static Link SelectingDocumentList= new Link("Selecting Document List", byXPath("//span[text()='Fakey Doc List']"));
	static TextField Document = new TextField("Document", byXPath("//input[@name='studentDocName_input']"));
	//static Link SelectingDocument= new Link("Selecting Document", byXPath("//span[text()='NewDocument']"));
	static TextField DocumentStatus = new TextField("Document Status", byXPath("//input[@name='studentDocStatus_input']"));
	static Link SelectingDocumentStatus= new Link("Selecting Document Status", byXPath("//span[text()='NOTSENT']"));
	static Link SaveAndCloseDocument= new Link("Save and close document", byXPath("//a[@id='studentDocumentSaveAnCloseButton']"));
	static Link Filter= new Link("Filter", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
	static Link ClearFilter= new Link("Clear Filters", byXPath("//a[@id='listClearFiltersButton']"));
	static Button Filtericon = new Button("Filter icon", byXPath("//div[2]/a[2]"));
	static Link ClearFilters= new Link("Clear Filters", byXPath("(//a[text()='Clear Filters'])[2]"));
	static AngDropDown TaskTemplatedrpdwn= new AngDropDown("Task template dropdown", byXPath("//th[1]/a[1]/span"));
	static Button Filteroption= new Button("Filteroption", byXPath("//span[text()='Filter']"));
	static TextField FilterValue = new TextField("Filter Value",byXPath("//input[@title='Value']"));
	static Button Filterbutton = new Button("Filter icon", byXPath("//button[. = 'Filter']"));
	static Link Tablevalue= new Link("Table value", byXPath("//td/a"));
	static AngDropDown Documentlistdrpdwn= new AngDropDown("Documentlist dropdown", byXPath("//th[2]/a[1]/span"));
	static Link saveAndCloseDocumentLisLink= new Link("Save and close document list", byXPath("//a[text()='Save & Close']"));
	
	public StudentStudentPage SelectStudent(StringHash data) throws Exception {
        Link SelectingStudent2 = new Link("Selecting Student", byXPath("//span[text()='"+LastNameValue+", "+FirstNameValue+"']"));

        Link SelectingStudent1 = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
        //setImplicitWaitTimeout(getImplicitWaitTimeout());
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
        wait(5);
        Filter.clickUsingJavaScriptExecutor();
        ClearFilter.clickUsingJavaScriptExecutor();
        wait(3);
        SearchName.waitTillElementClickable();
        SearchName.clearAndType(data.get("FullName").toString());
        wait(2);
        //SearchName.clearAndType(FirstNameValue);
        SelectingStudent1.clickUsingJavaScriptExecutor();
        wait(25);
      
        return this;        
    }
	
	public StudentStudentPage CreateProspect(StringHash data) throws Exception {
		Dropbox Location = new Dropbox("Location", byXPath("//li[1]//span[. = '"+data.get("Postalcode")+"']"));
		///Dropbox Location = new Dropbox("Location", byXPath("//input[@aria-label='"+data.get("Campus")+"']"));
		Link SelectingZipCode1 = new Link("Selecting ZipCode", byXPath("//span[. = '"+data.get("Postalcode")+"']"));
		Link SelectingStudent1 = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Link SelectingStudent2 = new Link("Selecting Student", byXPath("//span[text()='"+LastNameValue+", "+FirstNameValue+"']"));
		
		waitForPageToLoad();
		//Thread.sleep(30000);
		New_Prospect.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(8);
		//String alphabet = "abc";
		//String s = RandomStringUtils.random(8, alphabet);
		LastName.waitTillElementFound();
		//LastName.clearAndType(s);
		LastName.clearAndType(LastNameValue);
		FirstName.clearAndType(FirstNameValue);
		//PhoneNumber.waitTillElementFound();
		//PhoneNumber.clearAndType(data.get("PhoneNumber").toString());
		Email.clearAndType(FirstNameValue+"@gmail.com");
		WebElement wb = driver.findElement(By.name("Phone"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(522)222-2222';", wb);
		Zip_Code.clearAndType(data.get("Postalcode").toString());
		wait(5);
		SelectingZipCode1.click();
		wait(5);
		
		//jse.executeScript("document.getElementById('ssn').value='555-55-5555';");
		//Location.waitTillElementFound();
		//Location.click();
		SaveandClose.click();
		Dontsave.waitTillElementFound();
		Dontsave.click();
		wait(20);
		Filter.clickUsingJavaScriptExecutor();
		wait(3);
		ClearFilter.clickUsingJavaScriptExecutor();
		SearchName.clearAndType(FirstNameValue);
		wait(3);
		String FullName=LastNameValue+", "+FirstNameValue;
		System.out.println(FullName);
		//Link SelectingStudent2 = new Link("Selecting Student", byXPath("//span[text()='LastNameValue, FirstNameValue']"));
		String StudentName = SelectingStudent2.getText();
		System.out.println(StudentName);
		if(StudentName.equalsIgnoreCase(FullName))
		{
			System.out.println("Student data is matching");
		}else {
			System.out.println("Student data is not matching");
		}
		wait(1);
		
		return this;
	}
	
	public StudentStudentPage AddTaskToStudent(StringHash data) throws Exception {
		Link SelectingTaskTemplate1= new Link("Selecting TaskTemplate", byXPath("//span[. = '"+data.get("TaskTemplate")+"']"));
		Link SelectingStudent1 = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Link SelectingStudent2 = new Link("Selecting Student", byXPath("//span[text()='"+LastNameValue+", "+FirstNameValue+"']"));
		
		waitForPageToLoad();
		wait(20);
		Filter.clickUsingJavaScriptExecutor();
		ClearFilter.clickUsingJavaScriptExecutor();
		wait(3);
		SearchName.waitTillElementClickable();
		//SearchName.clearAndType(data.get("FirstName").toString());
		SearchName.clearAndType("F");
		SelectingStudent2.clickUsingJavaScriptExecutor();
		wait(15);
		ContactManager.clickUsingJavaScriptExecutor();
		Tasks.clickUsingJavaScriptExecutor();
		NewButton.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		TaskTemplate.clearAndType(data.get("TaskTemplate").toString());
		wait(3);
		SelectingTaskTemplate1.click();
		SelectingTaskTemplate1.clickUsingJavaScriptExecutor();
		wait(5);
		SaveAndCloseTask.clickUsingJavaScriptExecutor();
		wait(5);
		waitForPageToLoad();
		scrollPage(0, -300);
		wait(2);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		TaskTemplatedrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(data.get("TaskTemplate"));
		wait(2);
		Filterbutton.click();
		wait(2);
		String TaskTemplate = Tablevalue.getText();
		System.out.println(TaskTemplate);
		if(TaskTemplate.equalsIgnoreCase(data.get("TaskTemplate")))
		{
			System.out.println("Task template id is matching");
		}else {
			System.out.println("Task template id not matching");
		}
		wait(1);
		
		return null;
	}
	
	public StudentStudentPage AddDocumentToStudent(StringHash data) throws Exception {
		Link SelectingDocument1= new Link("Selecting Document", byXPath("//span[text()='"+data.get("DocumentName")+"']"));
		Link SelectingDocumentStatus1= new Link("Selecting Document Status", byXPath("//span[text()='"+data.get("DocumentStatus")+"']"));
		Link SelectingStudent1 = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Link SelectingStudent2 = new Link("Selecting Student", byXPath("//span[text()='"+LastNameValue+", "+FirstNameValue+"']"));
		Link SelectingModule= new Link("Selecting Module", byXPath("(//span[text()='"+data.get("ModuleName")+"'])[1]"));
		Link AddDocStudMsg= new Link("Add Document to Student", byXPath("//span[text()='The Document records were successfully saved.']"));
		
		waitForPageToLoad();
		wait(30);
		Filter.clickUsingJavaScriptExecutor();
		ClearFilter.clickUsingJavaScriptExecutor();
		wait(3);
		SearchName.waitTillElementClickable();
		SearchName.clearAndType(data.get("FullName").toString());
		//SearchName.clearAndType(FirstNameValue);
		//SelectingStudent2.clickUsingJavaScriptExecutor();
		SelectingStudent1.clickUsingJavaScriptExecutor();
		wait(20);
		ContactManager.clickUsingJavaScriptExecutor();
		Documents.clickUsingJavaScriptExecutor();
		wait(5);
		NewDocument.clickUsingJavaScriptExecutor();
		wait(5);
		//Module.clickUsingJavaScriptExecutor();
		Module.sendKeys(data.get("ModuleName").toString());
		wait(1);
		SelectingModule.clickUsingJavaScriptExecutor();
		wait(2);
		Document.clearAndType(data.get("DocumentName").toString());
		wait(2);
		SelectingDocument1.clickUsingJavaScriptExecutor();
		wait(6);
		DocumentStatus.clearAndType(data.get("DocumentStatus").toString());
		wait(1);
		SelectingDocumentStatus.clickUsingJavaScriptExecutor();
		wait(1);
		SaveAndCloseDocument.clickUsingJavaScriptExecutor();
		wait(5);
		CustomAsserts.containsString(AddDocStudMsg.getText(), data.get("AddDocStudMsg").toString());
		/*waitForPageToLoad();
		scrollPage(0, -300);
		wait(2);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		Documentlistdrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(data.get("DocumentName"));
		wait(2);
		Filterbutton.click();
		wait(2);
		String DocumentName = Tablevalue.getText();
		System.out.println(DocumentName);
		System.out.println(data.get("DocumentName"));
		if(DocumentName.equalsIgnoreCase(data.get("DocumentName")))
		{
			System.out.println("Document name is matching");
		}else {
			System.out.println("Document name is not matching");
		}*/
		wait(1);
		
		return null;
	}
	
	public StudentStudentPage AddDocumentListToStudent(StringHash data) throws Exception {
		
		Link SelectingDocumentStatus1= new Link("Selecting Document Status", byXPath("//span[text()='"+data.get("DocumentStatus")+"']"));
		Link SelectingStudent1 = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		//Link SelectingStudent2 = new Link("Selecting Student", byXPath("//span[text()='"+LastNameValue+", "+FirstNameValue+"']"));
		Link SelectingModule= new Link("Selecting Module", byXPath("(//span[text()='"+data.get("ModuleName")+"'])[1]"));
		Link SelectingDocumentList= new Link("Selecting Document List", byXPath("//span[text()='"+data.get("DocumentListName")+"']"));
		Link AddDocStudMsg= new Link("Add Document to Student", byXPath("//span[text()='The Document records were successfully saved.']"));
		
		waitForPageToLoad();
		wait(5);
		ContactManager.clickUsingJavaScriptExecutor();
		wait(1);
		Documents.clickUsingJavaScriptExecutor();
		wait(7);
		NewDocumentList.click();
		wait(5);
		scrollPage(0, 500);
		wait(2);
		Module.sendKeys(data.get("ModuleName").toString());
		//wait(1);
		//SelectingModule.click();
		wait(2);
		DocumentStatus.sendKeys(data.get("DocumentStatus"));
		wait(2);
		SelectingDocumentStatus1.click();
		wait(2);
		saveAndCloseDocumentLisLink.click();
		wait(2);
		CustomAsserts.containsString(AddDocStudMsg.getText(), data.get("AddDocStudMsg").toString());
		/*scrollPage(0, -300);
		wait(1);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(2);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		Documentlistdrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(data.get("DocumentType"));
		wait(2);
		Filterbutton.click();
		wait(2);
		String DocumentName = Tablevalue.getText();
		System.out.println(DocumentName);
		System.out.println(data.get("DocumentType"));
		if(DocumentName.equalsIgnoreCase(data.get("DocumentType")))
		{
			System.out.println("Document List name is matching");
		}else {
			System.out.println("Document List name is not matching");
		}*/
		wait(1);
		
		return null;
	}
	
}
