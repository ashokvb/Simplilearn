package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byXPath;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextBulletColorFollowTextImpl;
import static com.framework.elements.Locator.byName;
import static com.framework.elements.Locator.byId;
import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
import net.bytebuddy.asm.Advice.Exit;

public class StudentGroupPage extends BasePage{
		//Login Page Web Elements
	    static String SgName = AppendValue.apendString(); 
		static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
		static Link Groups = new Link("Groups tile", byXPath("//a[text()='Groups']"));
	    //static TextField SearchGroups = new TextField("Search Groups", byXPath("//input[@placeholder='Search Configuration']"));
	    //static Link ResidencyTypes = new Link("Residency Types", byXPath("//span[text()='Residency Types']"));	
		//Group Creation Web Elements
		static Button NewButton = new Button("New Student Group", byXPath("//a[@id='listAddButton']"));
		static TextField Name = new TextField("Student Group Name", byXPath("//input[@id='name']"));
	    //static TextField Code = new TextField("Residency Type Code", byXPath("//input[@id='code']"));
		static TextField GroupVisibility = new TextField("Enter Group Visibility", byName("visibilityType_input"));
		static Button SaveAndClose = new Button("Save and Close", byXPath("//button[@aria-label= 'Save & Close']"));
		static TextField GroupOwner = new TextField("Enter Group Owner", byName("owner_input"));
		static TextField GroupExpirationDate = new TextField("Enter Group Experation Date", byId("expirationDate"));	
		//Add Student to a Group Web Elements
		static Button AddStudent = new Button("Click Add", byId("listAddButton"));
		static TextField EnterStudentNumber = new TextField("Enter Student Number", byXPath("//input[@placeholder=\"Search Name or Student Number\"]"));
		//static Checkbox CheckStudentName = new Checkbox("Check Student Number", byXPath("//input[@aria-label=\"Wolf, Timber\"]"));
		static Button Select = new Button("Click Select", byXPath("//button[.=\"Select\"]"));
		static Button GroupFilterDropDown = new Button("Click Filter Drop Down", byId("cnsGroupGridList_cnsToolbar_kendoToolBar_settingsButton"));
		static Button GroupFilterButton = new Button("Click Filter", byId("cnsGroupGridList_cnsToolbar_kendoToolBar_clearFiltersButton"));
		static AngDropDown AssignedToDropDown = new AngDropDown("Click Drop Down", byXPath("(//a[@title=\"Column Settings\"])[1]"));
		static Button AssignedToFilter = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
		static TextField AssignedToValue = new TextField("Enter Group Name", byXPath("//input[@title=\"Value\"]"));
		static Button AssignedToFilterButton = new Button("Click Filter Button", byXPath("//button[.=\"Filter\"]"));		
		//Create Registration Locks to a group
		//static Button Highlight = new Button("Highlight Group", byXPath("//td[.=\"08/15/2024\"]"));
		static Link RegistrationLocks = new Link("Click Registration Locks", byId("studentGroupsRegisterLockButton"));
		static Link NewRegLock = new Link("Click New", byId("newButton"));
		static Button TermType = new Button("Click Term Type", byXPath("//span[@aria-label=\"Term Type: Dropdown\"]"));
		//static Button SelectTermType = new Button("Select Term Type", byXPath("//li[.=\"All Terms\"]"));
		static Button LockType = new Button("Click Lock Type", byXPath("//span[@aria-label=\"Lock Type: Dropdown\"]"));
		//static Button SelectLockType = new Button("Select Lock Type", byXPath("//li[.=\"Minimum Limit Lock\"]"));
		static Button UnitTypes = new Button("Click Unit Type", byXPath("//span[@aria-label=\"Unit Type: Dropdown\"]"));
		static TextField EnterUnitType = new TextField("Enter Unit Types", byXPath("//input[@aria-owns=\"UnitTypeId_listbox\"]"));
		//static Button SelectUnitTypes = new Button("Click Unit Type", byXPath("//li[.=\"Credits\"]"));
		static TextField EnterLimit = new TextField("Enter Limit", byXPath("//input[1][@aria-label=\"Limit\"]"));
		
		
		public StudentGroupPage CreateStudentGroup(StringHash data) throws Exception {
			
			waitForPageToLoad();
			wait(20);
			MenuButton.click();
			wait(2);
			Groups.click();
			wait(2);
			NewButton.click();
			waitForPageToLoad();
			wait(2);
			scrollPage(0, -500);
			//Name.clearAndType(data.get("Name").toString());
			Name.clearAndType(SgName);
			wait(2);
			SaveAndClose.click();
			waitForPageToLoad();
			wait(2);
			return this;

		}

		public StudentGroupPage StudentGroupCreationPage(StringHash data) throws Exception {
			
			Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Group records were successfully saved.']"));
			
			NewButton.click();
			waitForPageToLoad();
			wait(10);
			Name.sendKeys(data.get("StudentGroupName"));
			wait(2);
			GroupVisibility.clearAndType(data.get("GroupVisibility"));
			wait(2);
			GroupOwner.clearAndType(data.get("GroupOwner"));
			wait(2);
			GroupExpirationDate.clearAndType(data.get("GroupExpirationDate"));
			wait(2);
			SaveAndClose.clickUsingJavaScriptExecutor();
			wait(10);
			CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
			wait(10);
			return this;
		}

		public StudentGroupPage AddStudentToGroupPage(StringHash data) throws Exception {
	
			Checkbox CheckStudentName = new Checkbox("Check Student Name", byXPath("//input[@aria-label='"+data.get("StudentName")+"']"));
			Link ClickGroupName = new Link("Click Group Name", byXPath("//a[.='"+data.get("StudentGroupName")+"']"));
			Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Student records were successfully saved.']"));
			
			GroupFilterDropDown.click();
			wait(2);
			GroupFilterButton.click();
			wait(4);
			AssignedToDropDown.click();
			wait(2);
			AssignedToFilter.click();
			wait(2);
			AssignedToValue.clearAndType(data.get("StudentGroupName"));
			wait(5);
			AssignedToFilterButton.click();
			wait(5);
			ClickGroupName.click();
			waitForPageToLoad();
			AddStudent.click();
			waitForPageToLoad();
			EnterStudentNumber.clearAndType(data.get("StudentNumber"));
			wait(5);
			CheckStudentName.check();
			wait(2);
			Select.click();
			wait(5);
			scrollPage(0, -500);
			SaveAndClose.clickUsingJavaScriptExecutor();
			wait(5);
			CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
			wait(10);
			return this;
		}

		public StudentGroupPage CreateRegistrationLocksPage(StringHash data) throws Exception {

			Button Highlight = new Button("Highlight Group", byXPath("//td[.='"+data.get("GroupExpiryDate")+"']"));
			//WebElement GetLockType = driver.findElement(byXPath("//li[@aria-label=\\\"Lock Type: Dropdown\\\"]"));
			Button SelectTermType = new Button("Select Term Type", byXPath("//li[.='"+data.get("TermType")+"']"));
			Button SelectLockType = new Button("Select Lock Type", byXPath("//li[.='"+data.get("LockType")+"']"));
			Button SelectUnitTypes = new Button("Click Unit Type", byXPath("//li[.='"+data.get("UnitType")+"']"));
			Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Registration Lock records were successfully saved.']"));

			waitForPageToLoad();
			GroupFilterDropDown.click();
			wait(2);
			GroupFilterButton.click();
			wait(4);
			AssignedToDropDown.click();
			wait(2);
			AssignedToFilter.click();
			wait(2);
			AssignedToValue.clearAndType(data.get("StudentGroupName"));
			wait(5);
			AssignedToFilterButton.click();
			wait(5);
			Highlight.clickUsingJavaScriptExecutor();
			wait(2);
			RegistrationLocks.click();
			waitForPageToLoad();
			NewRegLock.click();
			wait(20);
			TermType.click();
			wait(2);
			SelectTermType.clickUsingJavaScriptExecutor();
			wait(4);
			LockType.clickUsingJavaScriptExecutor();
			wait(2);
			SelectLockType.click();
			wait(5);
			if(SelectLockType.equals("Schedule Lock"))
			{
				SaveAndClose.clickUsingJavaScriptExecutor();
				wait(10);	
			}
			else  {
	
			UnitTypes.clickUsingJavaScriptExecutor();
			wait(4);
			EnterUnitType.sendKeys(data.get("UnitType"));
			wait(4);
			SelectUnitTypes.clickUsingJavaScriptExecutor();
			wait(2);
			EnterLimit.clearAndType(data.get("Limit"));
			wait(4);
			SaveAndClose.click();
			wait(10);
			}
			CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
			return this;
		}
}
