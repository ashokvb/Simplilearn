package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.Button;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;

public class StudentTransferTypesPage extends BasePage{
	
	static String TranferTypeName = AppendValue.apendString();
	static String TranferTypeCode = AppendValue.apendString();	
	//Tranfer Types Web Elements
	static Link Confi= new Link("Click Configuration", byXPath("//a[@title=\"Configuration\"]"));
	static TextField searchconfigText = new TextField("Search Configuration", byXPath("//input[@placeholder=\"Search Configuration\"]"));
	static Link ClickTrnaferTypes = new Link("Click Transfer Types", byXPath("//span[text()=\"Transfer Types\"]"));
	static Link ClickNew = new Link("Click New", byId("newButton"));
	static TextField Name = new TextField("Enter Name", byId("name"));
	static TextField Code = new TextField("Enter Code", byId("code"));
	static Button SaveAndClose = new Button("Click Save and Close", byXPath("//button[@aria-label=\"Save & Close\"]"));
	
	public StudentTransferTypesPage CreateTransferTypes(StringHash data) throws Exception {
		
		waitForPageToLoad();
		Thread.sleep(3000);
		searchconfigText.clearAndType("Transfer Types");
		ClickTrnaferTypes.click();
		waitForPageToLoad();
		ClickNew.click();
		Thread.sleep(4000);
		waitForPageToLoad();
		Name.clearAndType(TranferTypeName);
		wait(1);
		Code.clearAndType(TranferTypeCode);
		SaveAndClose.click();
		wait(10);
		return this;		
	}
}
