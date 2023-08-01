package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byLinkText;
import static com.framework.elements.Locator.byCSSSelector;
import java.util.ArrayList;
import java.util.List;
import com.framework.base.BasePage;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Label;
import com.framework.elements.Link;
import com.framework.elements.Table;
import com.framework.elements.TextField;
import com.framework.util.Encrypt;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class StudentLoginPage extends BasePage
{
	//Login Page Web Elements
	//static Link useanotheracct = new Link("User Name Field", byId("otherTileText"));
		static TextField userNameTxt = new TextField("User Name Field", byCSSSelector("#i0116"));
		static Button Next = new Button("Click Next", byCSSSelector("#idSIButton9"));
		static TextField passwordTxt = new TextField("Password Field", byCSSSelector("#passwordInput"));
//		static Button Next = new Button("Click Next", byXPath("//input[@type=\"submit\"]"));
		static Link SignIn = new Link("Click SignIn", byCSSSelector("#submitButton"));
////		static Link SignIn = new Link("Click SignIn", byXPath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		static Checkbox DontShowThisAgain = new Checkbox("Don't Show This Again", byCSSSelector("#KmsiCheckboxField"));
		static Link ClickYes= new Link("Click Yes", byCSSSelector("#idSIButton9"));
//		static Link ClickYes= new Link("Click Yes", byXPath("//*[@value=\"Yes\"]"));
//		static Link ClickNo= new Link("Click No", byXPath("//*[@value=\"No\"]"));	
//		static Link ClickCancel= new Link("Click Cancel", byXPath("//button[text()='Cancel']"));	
//		static Link ClickSetDefault= new Link("Click Set Default", byXPath("//button[text()='Set Default']"));
//		static Label LoginSuccess = new Label("Verify Login Success", byXPath("//*[@id=\"tile-area-title-home\"]"));
//		static Label LoginSuccess1 = new Label("Verify Login Success", byXPath("//img[@id='campusNexusImage']"));
//		static Link ClickAPITest= new Link("Click API Test", byXPath("//a[text()='API TEST']"));	
//		static Link logout = new Link("Logout action", byLinkText("Sign Out"));
//		static Link logoutUserMenu = new Link("Logout action", byLinkText("Sign Out"));
//		Label errMsgLbl = new Label("Error message", byXPath(""));
//		Label errMsgLb2 = new Label("Error message", byXPath(""));
	
	//static L
//	static Link ClickNo= new Link("Click No", byXPath("//*[@value=\"No\"]"));	
//	static Link ClickCancel= new Link("Click Cancel", byXPath("//button[text()='Cancel']"));	
//	static Link ClickSetDefault= new Link("Click Set Default", byXPath("//button[text()='Set Default']"));
//	static Label LoginSuccess = new Label("Verify Login Success", byXPath("//*[@id=\"tile-area-title-home\"]"));
//	static Label LoginSuccess1 = new Label("Verify Login Success", byXPath("//img[@id='campusNexusImage']"));
//	static Link ClickAPITest= new Link("Click API Test", byXPath("//a[text()='API TEST']"));	
//	static Link logout = new Link("Logout action", byLinkText("Sign Out"));
//	static Link logoutUserMenu = new Link("Logout action", byLinkText("Sign Out"));
//	Label errMsgLbl = new Label("Error message", byXPath(""));
//	Label errMsgLb2 = new Label("Error message", byXPath(""));
	
	
	//Method Implementation
	
	//Enter Login Credential to Get into the Student's or Any Home Page


//	public StudentLoginPage loginDCRC(StringHash data) throws Exception {
//		//setImplicitWaitTimeout(30);
//		TextField userNameTxt = new TextField("User Name Field", byXPath("//input[@id='username']"));
//		TextField passwordTxt = new TextField("Password Field", byXPath("//input[@id='password']"));
//		Link SignIn = new Link("Click SignIn", byXPath("//button[@id='btnLogin']"));
//		Checkbox DontShowThisDailogAgain = new Checkbox("Don't Show This Dailog Again", byXPath("//span[text()='Do not show me this dialog again.']"));
//		Button CloseNewFeature = new Button("Close new feature", byXPath("//button[@id='closeNewFeatureModal']"));
//		Button SetDefault = new Button("Set default", byXPath("/button[text()='Set Default']"));
//		waitForPageToLoad();
//		userNameTxt.clearAndType(data.get("UserName").toString());
//		passwordTxt.clearAndType(data.get("Password").toString());
//		SignIn.waitTillElementFound();
//		SignIn.click();
//		wait(15);
//		//DontShowThisDailogAgain.click();
//		CloseNewFeature.clickUsingJavaScriptExecutor();
//		//wait(10);
//		//SetDefault.clickUsingJavaScriptExecutor();
//		wait(5);
//		return this;
//	}

		public StudentLoginPage loginDCRC(StringHash data) throws Exception {
			//setImplicitWaitTimeout(30);
			String Password = Encrypt.decodeString(data.get("Password").toString());
			String Username = Encrypt.decodeString(data.get("UserName").toString());
			TextField userNameTxt = new TextField("User Name Field", byXPath("//input[@id='username']"));
			TextField passwordTxt = new TextField("Password Field", byXPath("//input[@id='password']"));
			Link SignIn = new Link("Click SignIn", byXPath("//button[@id='btnLogin']"));
			Checkbox DontShowThisDailogAgain = new Checkbox("Don't Show This Dailog Again", byXPath("//span[text()='Do not show me this dialog again.']"));
			Button CloseNewFeature = new Button("Close new feature", byXPath("//button[@id='closeNewFeatureModal']"));
			Button SetDefault = new Button("Set default", byXPath("/button[text()='Set Default']"));
			waitForPageToLoad();
			userNameTxt.clearAndTypeUandPwd(Username.toString());
			passwordTxt.clearAndTypeUandPwd(Password.toString());
			SignIn.waitTillElementFound();
			SignIn.click();
			wait(15);
			//DontShowThisDailogAgain.click();
			CloseNewFeature.clickUsingJavaScriptExecutor();
			//wait(10);
			//SetDefault.clickUsingJavaScriptExecutor();
			wait(5);
			return this;
		}

	
	public StudentLoginPage login(StringHash data) throws Exception {
	
		waitForPageToLoad();	
		//Thread.sleep(25000);
		//Thread.sleep(60000);
	    //useanotheracct.click();
		userNameTxt.clearAndType(data.get("UserName").toString());
		
		Next.waitTillElementFound();
		Next.click();
		passwordTxt.clearAndType(data.get("Password").toString());
		SignIn.waitTillElementFound();
		SignIn.click();
		DontShowThisAgain.waitTillElementClickable();
		DontShowThisAgain.click();
	    ClickYes.waitTillElementClickable();
	    ClickYes.click();
//		ClickNo.waitTillElementClickable();
//		ClickNo.click();
//		ClickCancel.waitTillElementClickable();
//		ClickCancel.click();
		//LoginSuccess.waitTillElementFound();
		//CustomAsserts.containsString(LoginSuccess.getText(), data.get("Page Title").toString());
		wait(2);
		return this;

	}
	
	//end of Login Page Method


	
//	public StudentLoginPage loginDCRC(StringHash data) throws Exception {
//        TextField userNameTxt = new TextField("User Name Field", byXPath("//input[@id='username']"));
//        TextField passwordTxt = new TextField("Password Field", byXPath("//input[@id='password']"));
//        Link SignIn = new Link("Click SignIn", byXPath("//*[@id='btnLogin']"));
//        Checkbox DontShowThisDailogAgain = new Checkbox("Don't Show This Dailog Again", byXPath("//span[text()='Do not show me this dialog again.']"));
//        Button CloseNewFeature = new Button("Close new feature", byXPath("//button[@id='closeNewFeatureModal']"));
//        //Button SetDefault = new Button("Set default", byXPath("/button[text()='Set Default']"));
//        waitForPageToLoad();
//        userNameTxt.clearAndType(data.get("UserName").toString());
//        passwordTxt.clearAndType(data.get("Password").toString());
//        SignIn.click();
//        wait(15);
//        //DontShowThisDailogAgain.click();
//        //wait(2);
//        CloseNewFeature.clickUsingJavaScriptExecutor();
//        wait(2);
//        waitForPageToLoad();        //SetDefault.clickUsingJavaScriptExecutor();
//        return this;
//    }
	
//	public StudentLoginPage loginDCRC(StringHash data) throws Exception {
//        TextField userNameTxt = new TextField("User Name Field", byXPath("//input[@id='username']"));
//        TextField passwordTxt = new TextField("Password Field", byXPath("//input[@id='password']"));
//        Link SignIn = new Link("Click SignIn", byId("btnLogin"));
//        Checkbox DontShowThisDailogAgain = new Checkbox("Don't Show This Dailog Again", byXPath("//span[text()='Do not show me this dialog again.']"));
//        Button CloseNewFeature = new Button("Close new feature", byXPath("//button[@id='closeNewFeatureModal']"));
//        Button SetDefault = new Button("Set default", byXPath("/button[text()='Set Default']"));
//        waitForPageToLoad();
//        userNameTxt.clearAndType(data.get("UserName").toString());
//        passwordTxt.clearAndType(data.get("Password").toString());
//        SignIn.waitTillElementFound();
//        SignIn.click();
//        waitForPageToLoad();
//  //      DontShowThisDailogAgain.click();
//        wait(2);
//        CloseNewFeature.clickUsingJavaScriptExecutor();
//        waitForPageToLoad();
//        wait(10);
//      
//        return this;
//    }


	
	/*public StudentLoginPage loginDCRC(StringHash data) throws Exception {
        TextField userNameTxt = new TextField("User Name Field", byXPath("//input[@id='username']"));
        TextField passwordTxt = new TextField("Password Field", byXPath("//input[@id='password']"));
        Link SignIn = new Link("Click SignIn", byXPath("//*[@id='btnLogin']"));
        Checkbox DontShowThisDailogAgain = new Checkbox("Don't Show This Dailog Again", byXPath("//span[text()='Do not show me this dialog again.']"));
        Button CloseNewFeature = new Button("Close new feature", byXPath("//button[@id='closeNewFeatureModal']"));
        //Button SetDefault = new Button("Set default", byXPath("/button[text()='Set Default']"));
        waitForPageToLoad();
        userNameTxt.clearAndType(data.get("UserName").toString());
        passwordTxt.clearAndType(data.get("Password").toString());
        SignIn.click();
        wait(15);
        //DontShowThisDailogAgain.click();
        //wait(2);
        CloseNewFeature.clickUsingJavaScriptExecutor();
        wait(2);
        waitForPageToLoad();        //SetDefault.clickUsingJavaScriptExecutor();
        return this;
    }*/
	
	/*public StudentLoginPage loginDCRC(StringHash data) throws Exception {

	}	//end of Login Page Method

	}
	
	//end of Login Page Method
	

	
	public StudentLoginPage loginDCRC(StringHash data) throws Exception {
        //setImplicitWaitTimeout(30);

        TextField userNameTxt = new TextField("User Name Field", byXPath("//input[@id='username']"));
        TextField passwordTxt = new TextField("Password Field", byXPath("//input[@id='password']"));
        Link SignIn = new Link("Click SignIn", byXPath("//button[@id='btnLogin']"));
        Checkbox DontShowThisDailogAgain = new Checkbox("Don't Show This Dailog Again", byXPath("//span[text()='Do not show me this dialog again.']"));
        Button CloseNewFeature = new Button("Close new feature", byXPath("//button[@id='closeNewFeatureModal']"));
        Button SetDefault = new Button("Set default", byXPath("//button[text()='Set Default']"));
        waitForPageToLoad();
        userNameTxt.clearAndType(data.get("UserName").toString());
        passwordTxt.clearAndType(data.get("Password").toString());
        SignIn.waitTillElementFound();
        SignIn.click();
        wait(15);
        //DontShowThisDailogAgain.click();
        CloseNewFeature.clickUsingJavaScriptExecutor();
        //wait(10);
        //SetDefault.clickUsingJavaScriptExecutor();
        wait(5);
        return this;
    }*/

	//Click Log Out
	public StudentLoginPage logOut() throws InterruptedException {
		wait(2);
//		ClickAPITest.waitTillElementClickable();
//		ClickAPITest.click();
//		logoutUserMenu.waitTillElementClickable();
//		logoutUserMenu.click();
		return this;
	} // end of Log Out Method


	//public StudentLoginPage loginDCRC(StringHash data) throws Exception {

	
	/*public StudentLoginPage loginDCRC(StringHash data) throws Exception {

        TextField userNameTxt = new TextField("User Name Field", byXPath("//input[@id='username']"));
        TextField passwordTxt = new TextField("Password Field", byXPath("//input[@id='password']"));
        Link SignIn = new Link("Click SignIn", byXPath("//button[@id='btnLogin']"));
        Checkbox DontShowThisDailogAgain = new Checkbox("Don't Show This Dailog Again", byXPath("//span[text()='Do not show me this dialog again.']"));
        Button CloseNewFeature = new Button("Close new feature", byXPath("//button[@id='closeNewFeatureModal']"));
        Button SetDefault = new Button("Set default", byXPath("/button[text()='Set Default']"));
        waitForPageToLoad();
        userNameTxt.clearAndType(data.get("UserName").toString());
        passwordTxt.clearAndType(data.get("Password").toString());
        SignIn.waitTillElementFound();
        SignIn.click();
        waitForPageToLoad();
        DontShowThisDailogAgain.click();
        wait(4);
        CloseNewFeature.clickUsingJavaScriptExecutor();
        //SetDefault.clickUsingJavaScriptExecutor();
        //wait(5);
        return this;

    }

    }*/

	


//	
//	

//	public StudentLoginPage verifyErrMsgs(StringHash data) {
//		waitForPageToLoad();
//	//	loginBtn.click();
//		waitForPageToLoad();
//		CustomAsserts.assertString(errMsgLb2.getText().trim(), data.get("ErrorMessage").toString().trim());
//		userNameTxt.clearAndType(data.get("UserName").toString());
//		passwordTxt.clearAndType(data.get("WrongPassword").toString());
//	//	loginBtn.click();
//		waitForPageToLoad();
//		CustomAsserts.assertString(errMsgLbl.getText().trim(), data.get("ErrorMessage1").toString().trim());
//		return this;
//	}	
//	public StudentLoginPage UseAnotherAccount() throws InterruptedException {
//		wait(1);
//		useanotheracct.waitTillElementFound();
//		useanotheracct.click();
//		return this;
//	}	
//	public StudentLoginPage userLogin(String userName, String password) throws Exception {
//		waitForPageToComplete();
//		userNameTxt.waitTillElementClickable();
//		userNameTxt.clearAndType(userName);
//		passwordTxt.clearAndType(password);
//	//	loginBtn.click();
//		wait(5);
//		waitForPageToComplete();	
//		wait(30);
//		return this;
//	}
//	public StudentLoginPage login2(StringHash data) throws Exception {
//		waitForPageToLoad();
//		userNameTxt.clearAndType(data.get("UserName2").toString());
//		passwordTxt.clearAndType(data.get("WrongPassword").toString());
//	//	loginBtn.click();
//		waitForPageToLoad();
//		return this;
//	}
//	public StudentLoginPage logOutAction() throws InterruptedException {
//		wait(1);
//		logoutUserMenu.waitTillElementFound();
//		logoutUserMenu.click();
//		wait(1);
//		logout.click();
////		CustomAsserts.assertString(logoutConfirmationLbl.getText(), "You have successfully Logged out");
//		driver.close();
//		return this;
//	}
//	
//	public StudentLoginPage SupAuditlogin(StringHash data) throws Exception {
//		waitForPageToLoad();
//		userNameTxt.clearAndType(data.get("UserSup1").toString());
//		passwordTxt.clearAndType(data.get("SupPassword").toString());
//	//	loginBtn.click();
//		waitForPageToLoad();
//		return this;
//	}
//	
//	public StudentLoginPage SupAuditlogin2(StringHash data) throws Exception {
//		waitForPageToLoad();
//		userNameTxt.clearAndType(data.get("UserSup2").toString());
//		passwordTxt.clearAndType(data.get("SupPassword2").toString());
//	//	loginBtn.click();
//		waitForPageToLoad();
//		return this;
//	}
//	
//	public StudentLoginPage verifyLoginSuccess(StringHash data) {	
//		waitForPageToComplete();
//		LoginSuccess.waitTillElementFound();
//		CustomAsserts.containsString(LoginSuccess.getText(), data.get("Title").toString());
//		return this;
//	}
	
}

