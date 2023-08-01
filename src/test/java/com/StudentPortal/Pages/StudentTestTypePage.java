package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.Button;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;

public class StudentTestTypePage extends BasePage{ 
	//Login Page Web Elements
	static String TstTypName = AppendValue.apendString();
	static String TstTypCode = AppendValue.apendString();	
	static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Configuration = new Link("Configuration tile", byXPath("//a[text()='Configuration']"));
	static TextField SearchConfiguration = new TextField("Search Configuration", byXPath("//input[@placeholder='Search Configuration']"));
	static Link Tests = new Link("Test Type", byXPath("//span[text()='Tests']"));
	static Button NewButton = new Button("New Residency Types ", byXPath("//a[@id='newButton']"));
	static TextField Name = new TextField("Residency Type Name", byXPath("//input[@id='name']"));
	static TextField Code = new TextField("Residency Type Code", byXPath("//input[@id='code']"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("//button[@aria-label= \"Save & Close\"]"));
		
	//Method Implementation	
	//Enter Login Credential to Get into the Student's or Any Home Page
	public StudentTestTypePage CreateTestType(StringHash data) throws Exception{
		waitForPageToLoad();
		wait(2);
		MenuButton.click();
		waitForPageToLoad();
		wait(2);
		Configuration.click();
		waitForPageToLoad();
		wait(2);
		SearchConfiguration.clearAndType(data.get("Search Name").toString());
		waitForPageToLoad();
		wait(2);
		Tests.click();
		waitForPageToLoad();
		wait(2);
		NewButton.click();
		waitForPageToLoad();
		wait(2);
		//Name.clearAndType(data.get("Name").toString());
		Name.clearAndType(TstTypName);
		waitForPageToLoad();
		wait(2);
		//Code.clearAndType(data.get("Code").toString());
		Code.clearAndType(TstTypCode);
		waitForPageToLoad();
		wait(2);
		SaveAndClose.click();
		waitForPageToLoad();
		wait(2);
		return this;
    }

}

