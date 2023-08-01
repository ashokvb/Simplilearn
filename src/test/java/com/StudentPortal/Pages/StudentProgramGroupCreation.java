package com.StudentPortal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import com.framework.base.BasePage;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Dropbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byLinkText;


public class StudentProgramGroupCreation extends BasePage {
	
	static String ProgramGroupName = AppendValue.apendString();
	static String ProgramGroupCode = AppendValue.apendString();	
	static Link Confi= new Link("Click Configuration", byXPath("//a[@title=\"Configuration\"]"));
	static TextField searchconfigText = new TextField("Search Configuration", byXPath("//input[@placeholder=\"Search Configuration\"]"));
	static Link ClickProgramGroups = new Link("Click Program Groups", byXPath("//span[text()=\"Program Groups\"]"));
	static Link ClickNew = new Link("Click New", byId("newButton"));
	static TextField Name = new TextField("Enter Name", byId("name"));
	static TextField Code = new TextField("Enter Code", byId("code"));
	static Button SaveAndClose = new Button("Click Save and Close", byXPath("//button[@aria-label=\"Save & Close\"]"));
	
	public StudentProgramGroupCreation CreateProgramGroups(StringHash data) throws Exception {
		
		waitForPageToLoad();
		searchconfigText.clearAndType("Program Groups");
		ClickProgramGroups.click();
		waitForPageToLoad();
		ClickNew.click();
		waitForPageToLoad();
		wait(5);
		Name.waitTillElementFound();
		Name.clearAndType(ProgramGroupName);
		Code.waitTillElementFound();
		Code.clearAndType(ProgramGroupCode);
		wait(3);
		SaveAndClose.click();
		wait(10);
		return this;
		
	}
}
