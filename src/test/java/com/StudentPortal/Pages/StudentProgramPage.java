package com.StudentPortal.Pages;

import org.elasticsearch.search.Scroll;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;

import com.framework.base.BasePage;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import java.awt.ScrollPane;
import java.awt.Window;

import static com.framework.elements.Locator.byLinkText;

public class StudentProgramPage extends BasePage{
	//Program Page Web Elements
	static String ProgramName = AppendValue.apendString();
	static String ProgramCode = AppendValue.apendString();	
	static Link configuration = new Link("Click Configuration", byXPath("//a[.=\"Configuration\"]"));
	static TextField SearchInConfiguration = new TextField("Search in Configuration" , byXPath("//input[@placeholder=\"Search Configuration\"]"));
	static Link ClickProgram = new Link("Click Program", byXPath("//span[text()=\"Programs\"]"));
	static Link ClickNew = new Link("Click New", byId("newButton"));
	static TextField Name = new TextField("Enter Name", byId("name"));
	static TextField Code = new TextField("Enter Code", byId("code"));
	static Link clickProgrField = new Link("Click Program Groups", byId("search_display_programGroupSearchControl"));
	static TextField clickPG =  new TextField("Search Program Group", byId("search"));
	static Button select = new Button("Click Select", byXPath("//button[@ng-click=\"$ctrl.onSubmit()\"]"));
	static Button SaveAndClose = new Button("Click Save and Close", byXPath("//button[@aria-label=\"Save & Close\"]"));
	
	
	public StudentProgramPage CreateProgram(StringHash data) throws Exception {
		
		 Checkbox checkbox=new Checkbox("Select Program Group", byXPath("//input[@aria-label='"+StudentProgramGroupCreation.ProgramGroupName+"']"));
		waitForPageToLoad();
		SearchInConfiguration.clearAndType("Programs");
		ClickProgram.click();
		waitForPageToLoad();
		wait(2);
		ClickNew.click();
		wait(8);
		waitForPageToLoad();    
		Name.waitTillElementFound();
		Name.clearAndType(ProgramName);
		wait(1);
		Code.waitTillElementFound();
		Code.clearAndType(ProgramCode);
	    scrollPage(0, 250);
	    clickProgrField.click();
	    clickPG.waitTillElementFound();
	    clickPG.clearAndType(StudentProgramGroupCreation.ProgramGroupName);
		wait(3);
	    checkbox.click();
	    wait(1);
	    select.click();
	    scrollPage(0, -250);
	    SaveAndClose.click();
	    wait(10);
	    return this; 
	    
	}
}
