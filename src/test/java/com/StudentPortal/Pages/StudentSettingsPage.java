package com.StudentPortal.Pages;

import org.apache.tools.ant.taskdefs.MacroDef.Text;
import org.openqa.selenium.By.ByXPath;
import static com.framework.elements.Locator.byXPath;

import java.util.concurrent.TimeUnit;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;

public class StudentSettingsPage extends BasePage {
	
	static String StatusNameValue = AppendValue.apendString();
	static String StatusCodeValue = AppendValue.apendString();
	static TextField SearchField = new TextField("Search Settings", byXPath("//input[@placeholder='Search Settings']"));
	static Link StatusChanges = new Link("Status changes", byXPath("//span[text()='Status Changes']"));
	static Button NewButton = new Button("New Status", byXPath("//a[@id='newButton']"));
	static TextField Name = new TextField("Status Name", byXPath("//input[@id='name']"));
	static TextField Code = new TextField("Status Code", byXPath("//input[@id='code']"));
	static TextField SystemStatusInput = new TextField("System Status",byXPath("//input[@name='SystemStatus_input']"));
	static Button SelectingSystemStatus = new Button("Selecting system status", byXPath("//li[. = 'New Lead']"));
	static TextField NSLDSStatusInput = new TextField("NSLDS Status",byXPath("//input[@name='NSLDSStatus_input']"));
	static TextField CampusGroupInput = new TextField("Campus Group",byXPath("//input[@name='campusGroupId_input']"));
	static Link SelectingCampus = new Link("Selecting Campus",byXPath("//li[. = 'DTS']"));
	static Button SaveAndClose = new Button("Save & CLose",byXPath("//button[@aria-label='Save & Close']"));
	static Button Filtericon = new Button("Filter icon", byXPath("//div[2]/a[2]"));
	static Link ClearFilters= new Link("Clear Filters", byXPath("//a[. = 'Clear Filters']"));
	static AngDropDown Statusnamedrpdwn= new AngDropDown("Column Settings Filters", byXPath("//th[2]/a/span"));
	static Button ApplFilterDropDown = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
	static Button Filteroption= new Button("Filteroption", byXPath("//span[text()='Filter']"));
	//static Link FilteroptionExpand= new Link("Filteroption expand", byXPath("//form/div/span[1]/span/span/span"));
	//static Link SelectingfilterOption= new Link("Selecting Filteroption", byXPath("//div/div/div//li[. = 'Contains']"));
	static TextField FilterValue = new TextField("Filter Value",byXPath("//input[@title='Value']"));
	static Button Filterbutton = new Button("Filter icon", byXPath("//button[. = 'Filter']"));
	static Link SchoolstatusName= new Link("Schoolstatus Name", byXPath("//td/a"));
	static Link FetchingName= new Link("Schoolstatus Name", byXPath("//td/a"));
	static Link GeneralSA = new Link("General Student Accounts", byXPath("(//span[text()='General'])[1]"));
	static Link SettingsList= new Link("Settings List", byXPath("//tr[1]/th[1]/a[1]"));
	static Link SelectingApplyPayment= new Link("Selecting apply payment flag link", byXPath("//a[text()='Apply Payment Flag']"));
	static Link ApplyPaymentFlag= new Link("Apply payment flag dropdown", byXPath("//span[@aria-label='Apply Payment Flag: Dropdown']"));
	static Link SelectingFlag= new Link("Selecting apply payment flag", byXPath("//li[text()='Yes']"));
	static Button Save = new Button("Save",byXPath("(//button[text()='Save'])[1]"));
	static Link FetchingValue= new Link("Fetching Value", byXPath("(//tr[1]/td[2])[1]"));
	static Button SettingsFilter = new Button("Click Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField SettingsValue = new TextField("Enter value", byXPath("//input[@title=\"Value\"]"));
    static Button SettingsFilterButton = new Button("Click Settings Filter", byXPath("//button[.=\"Filter\"]"));
    static Link DocumentPolicies = new Link("Document Policies", byXPath("//span[text()='Document Policies']"));
    static TextField Description = new TextField("Description", byXPath("//input[@id='name']"));
    static Link Module= new Link("Module", byXPath("//span[@aria-label='Module: Dropdown']"));
    static AngDropDown NameDrp= new AngDropDown("Name dropdown", byXPath("(//th/a/span)[1]"));
	static Link SettingsDropDown = new Link("Click Drop Down", byXPath("(//a[@title=\"Column Settings\"])[1]"));
	
	
	
//Method implementation
	//Create new school status
	public StudentSettingsPage CreateSchoolStatus(StringHash data) throws Exception {
		Button SelectingSystemStatus1 = new Button("Selecting system status", byXPath("//li[. = '"+data.get("SystemStatus")+"']"));
		Link SelectingCampus1 = new Link("Selecting Campus",byXPath("//li[. = '"+data.get("CampusGroup")+"']"));
		
		waitForPageToLoad();
		SearchField.clearAndType(data.get("Component").toString());
		StatusChanges.waitTillElementClickable();
		StatusChanges.clickUsingJavaScriptExecutor();
		wait(10);
		NewButton.clickUsingJavaScriptExecutor();
		wait(2);
		Name.waitTillElementClickable();
		//StatusName.clearAndType(data.get("Statusname").toString());
		Name.clearAndType(StatusNameValue);
		wait(2);
		Code.waitTillElementClickable();
		//StatusCode.clearAndType(data.get("Statuscode").toString());
		Code.clearAndType(StatusCodeValue);
		SystemStatusInput.clearAndType(data.get("SystemStatus").toString());
		wait(2);
		SelectingSystemStatus1.clickUsingJavaScriptExecutor();
		CampusGroupInput.waitTillElementClickable();
		wait(2);
		CampusGroupInput.clearAndType(data.get("CampusGroup").toString());
		wait(1);
		SelectingCampus1.click();
		wait(3);
		scrollPage(0, -200);
		SaveAndClose.waitTillElementClickable();
		SaveAndClose.clickUsingJavaScriptExecutor();
		wait(2);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		Statusnamedrpdwn.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(StatusNameValue);
		wait(2);
		Filterbutton.click();
		wait(2);
		String SchoolStatusName = FetchingName.getText();
		System.out.println(SchoolStatusName);
		if(SchoolStatusName.equalsIgnoreCase(StatusNameValue))
		{
			System.out.println("School Status is matching");
		}else {
			System.out.println("School Status is not matching");
		}
		wait(1);
		return this;
	//End of Menu Button	
	}


	
	public StudentSettingsPage ConfigureApplyPayment(StringHash data) throws Exception {
		Link AppPaymentMsg= new Link("Apply Payment Msg", byXPath("//span[text()='The General settings were successfully saved.']"));
		
		waitForPageToLoad();
		//waitForPageToComplete();
		SearchField.clearAndType(data.get("Component").toString());
		wait(2);
		GeneralSA.clickUsingJavaScriptExecutor();
		wait(2);
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
        SettingsList.click();
        wait(2);
        SettingsFilter.click();
        wait(2);
        SettingsValue.sendKeys("Apply Payment Flag");
        wait(2);
        SettingsFilterButton.click();
        wait(3);
		SelectingApplyPayment.clickUsingJavaScriptExecutor();
		wait(2);
		ApplyPaymentFlag.sendKeys("Flagoptions");
		wait(1);
		SelectingFlag.clickUsingJavaScriptExecutor();
		wait(2);
		Save.clickUsingJavaScriptExecutor();
		wait(2);
		CustomAsserts.containsString(AppPaymentMsg.getText(), data.get("AppPaymentMsg").toString());
		String SetValue =FetchingValue.getText();
		System.out.println(SetValue);
		if(SetValue.equalsIgnoreCase(data.get("Flagoptions")))
		{
			System.out.println("Changes are updated correctly");
		}else {
			System.out.println("Changes are not updated correctly");
		}
		return this;
		
	}

public StudentSettingsPage ConfigureDocumentPolicy(StringHash data) throws Exception {
		Link SelectingModule= new Link("Selecting Module", byXPath("//li[text()='"+data.get("ModuleName")+"']"));	
		Link DocPolicyMsg= new Link("Document Policy Msg", byXPath("//span[text()='The Document Policy records were successfully saved.']"));
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	
		waitForPageToLoad();
		//waitForPageToComplete();
		SearchField.clearAndType(data.get("Component").toString());
		wait(2);
		DocumentPolicies.clickUsingJavaScriptExecutor();
		wait(3);
		waitForPageToLoad();
		Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
        NewButton.click();
        wait(8);
        scrollPage(0, -500);
        wait(3);
        Name.clearAndType(data.get("DocumentPolicyName"));
        wait(2);
        Code.clearAndType(data.get("DocumentPolicyCode"));
        wait(2);
        Module.click();
        wait(2);
        SelectingModule.click();
        wait(2);
        SaveAndClose.click();
        wait(3);
        CustomAsserts.containsString(DocPolicyMsg.getText(), data.get("DocPolicyMsg").toString());
        Filtericon.clickUsingJavaScriptExecutor();
		wait(1);
		ClearFilters.clickUsingJavaScriptExecutor();
		wait(5);
		NameDrp.click();
		wait(2);
		Filteroption.click();
		wait(2);
		FilterValue.clearAndType(data.get("DocumentPolicyName"));
		wait(2);
		Filterbutton.click();
		wait(2);
		String DocPolicyName = FetchingName.getText();
		System.out.println(DocPolicyName);
		if(DocPolicyName.equalsIgnoreCase(data.get("DocumentPolicyName")))
		{
			System.out.println("Document Policy is matching");
		}else {
			System.out.println("Document Policy is not matching");
		}
		wait(1);
		return this;
        
}
}
	