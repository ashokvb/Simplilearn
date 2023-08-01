package com.StudentPortal.Pages;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.ClickAction;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byLinkText;
import static com.framework.elements.Locator.byCSSSelector;
import java.util.ArrayList;
import java.util.List;
import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Dropbox;
import com.framework.elements.Label;
import com.framework.elements.Link;
import com.framework.elements.Table;
import com.framework.elements.TextField;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import com.framework.driver.DriverConfig;
import org.openqa.selenium.internal.FindsByCssSelector;

public class StudentHomePage extends BasePage{
	
	//Login Page Web Elements
	static Link MenuButton = new Link("Click Menu Button", byXPath("//span[@title=\"Menu Button\"]"));
	static Link TasksButton = new Link("TasksButton", byXPath("(//a[@title='Tasks'])[1]"));
	//static Link TasksButton = new Link("TasksButton", byXPath("(//a[@title='Tasks'])[1]"));
	static Link Configuration = new Link("Click Configuration", byXPath("//a[@title=\"Configuration\"]"));
	//static Link Students = new Link("Click Students", byXPath("//a[@title=\"Students\"]"));
	static Link Processes =  new Link("Click Processes",byXPath("//a[@title=\"Processes\"]"));
	static Link  Menu = new Link("Main Menu", byXPath("//div/ul/li[2]/a/span"));
	static Link subMenuConfiguration = new Link("Sub Menu Configuration", byXPath("//a[. = 'Configuration']"));
	static Link subMenuClassScheduling = new Link("Sub Menu Class Scheduling", byXPath("//a[. = 'Class Scheduling']"));
	static Link subMenuStudents = new Link("Sub Menu Students", byXPath("//a[. = 'Students']"));
	static Link Span8 = new Link("Click on student status span", byXPath("//div[2]/cmc-drop-down-list-classic/div/div/span/span"));
	static Link Span9 = new Link("Click on student status span", byXPath("//div[1]/cmc-drop-down-list-classic/div/div/span/span"));
	static Button ApplyFilters = new Button("Apply filters button", byXPath("//button[. = 'Apply Filter']"));
	static TextField SearchName = new TextField("Search Name", byXPath("//input[@placeholder = 'Search Name']"));
	static Link StudentSpan = new Link("Click on student span", byXPath("//td/span"));
	static Link Students = new Link("Student tile", byXPath("//a[. = 'Students']"));
	static Link Settings = new Link("Settings tile", byXPath("//a[text()='Settings']"));
	static Button FilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
	static Button ClearFiltersButton = new Button("Click Filter Button", byId("listClearFiltersButton"));
	static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
	static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
	static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
	static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
	static AngDropDown Role = new AngDropDown("Role Dropdown", byXPath("(//span[@aria-label=\"select\"])[1]"));
	static TextField GlobalSearch = new TextField("Global Search", byXPath("//input[@id='globalSearchSearchField']"));
	static Link Search = new Link("Search", byXPath("//i[@title='Search Button']"));
	static Link Task = new Link("Tasks", byXPath("//div[text()='Tasks']"));
	static Button NewButton = new Button("New button", byXPath("//a[@id='newButton']"));
	static TextField TaskTemplate = new TextField("Task Template", byXPath("(//input[@aria-label='taskTemplateId'])[1]"));
	static Link Student = new Link("Student", byXPath("//div[@aria-label='Student']"));
	static Button SelectButton = new Button("Select button", byXPath("//button[text()='Select']"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("//button[@aria-label = 'Save & Close']"));
	static Link Groups = new Link("Click Groups", byXPath("//a[.=\"Groups\"]"));
	

public StudentHomePage SelectConfigurationMenu(StringHash data) throws Exception {
	
	//Login Page Web Elements
	waitForPageToLoad();
	//setImplicitWaitTimeout(implicitWaitTimeout);	
	//setImplicitWaitTimeout();
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(25000);
	//setImplicitWaitTimeout(implicitWaitTimeout);
	//setImplicitWaitTimeout();
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(25000);
	//setImplicitWaitTimeout(implicitWaitTimeout);
	//setImplicitWaitTimeout();
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(25000);
	Menu.waitTillElementClickable();
	Menu.click();
	wait(5);
	//js.executeScript("arguments[0].click();",Menu);
	subMenuConfiguration.waitTillElementClickable();
	//js.executeScript("arguments[0].click();",subMenuConfiguration);
	wait(5);
	subMenuConfiguration.click();
	return this;
}

public StudentHomePage SelectClassSchedulingMenu(StringHash data) throws Exception {
	
	//Login Page Web Elements
	waitForPageToLoad();	
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(25000);
	Menu.waitTillElementClickable();
	Menu.click();
	wait(2);
	wait(2);
	//js.executeScript("arguments[0].click();",Menu);
	subMenuClassScheduling.waitTillElementClickable();
	//js.executeScript("arguments[0].click();",subMenuConfiguration);
	subMenuClassScheduling.click();	
	return this;
}



public StudentHomePage SelectStudentsMenu(StringHash data) throws Exception {
	
	//Login Page Web Elements
	waitForPageToLoad();	
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(20000);
	//Menu.waitTillElementFound();
	Menu.waitTillElementClickable();
	Menu.click();
	//js.executeScript("arguments[0].click();",Menu);
	subMenuStudents.waitTillElementClickable();
	//js.executeScript("arguments[0].click();",subMenuConfiguration);
	subMenuStudents.click();
	//waitForPageToLoad();
	return this;
}


public StudentHomePage SelectStudent(StringHash data) throws Exception {
		
	Dropbox StudentStatus = new Dropbox("Student Status", byXPath("//li[. = '"+data.get("StudentStatus")+"']"));
	Dropbox Campus = new Dropbox("Campus", byXPath("//li[. = '"+data.get("Campus")+"']"));
		
	//Login Page Web Elements
	waitForPageToLoad();
	wait(5);
	wait(5);
	Span8.waitTillElementClickable();
	Span8.click();
	wait(2);
	//StudentStatus.click();
	Span9.waitTillElementClickable();
	Span9.click();
	wait(2);
	Campus.click();
	ApplyFilters.waitTillElementClickable();
	ApplyFilters.click();
	wait(6);
	waitForPageToComplete();
	wait(10);
	FilterDropDwon.click();
	wait(2);
	ClearFiltersButton.click();
	wait(2);
	StuNumDropDown.click();
	wait(2);
	StuNumFilter.click();
	wait(2);
	value.clearAndType(data.get("Student Number"));
	wait(2);
	FilterButton.click();
	wait(2);
/*	SearchName.clearAndType(data.get("StudentName").toString());
	wait(2);
*/
	StudentSpan.click();	
	return this;

}


public StudentHomePage SelectNewStudent(StringHash data) throws Exception {
	
	
	Link  NewStudent = new Link("New Student link", byCSSSelector("#listAddButton"));	
	//Login Page Web Elements
	waitForPageToLoad();
	//wait(35);
	NewStudent.click();
	return this;
}


public StudentHomePage configurationPage(){
 
	waitForPageToLoad();						 
	MenuButton.click();
	waitForPageToComplete();																												  
	Configuration.click();						  
	waitForPageToLoad();							
	return this;	
	}
	
public StudentHomePage StudentPage() {
				  
	waitForPageToLoad();								  
	MenuButton.click();
	wait(3);
	waitForPageToComplete();								  
	Students.click();
	wait(10);
	waitForPageToLoad();
	return this;
	}

public StudentHomePage SearchStudent(StringHash data)throws Exception {
//StudentHomePage SearchStudent(StringHash data)throws Exception {
	 
	Link ClickStudent = new Link("Click Student Name",byXPath("//span[.='"+data.get("StudentName")+"']"));
	Link StudentCourses = new Link("Click on Student Courses span", byXPath("//li[3]/div/div[3]/div"));
	Button FilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class=\"k-button k-split-button-arrow\"])[1]"));
	Button ClearFiltersButton = new Button("Click Filter Button", byId("listClearFiltersButton"));
	AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
	Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
    TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
	
    waitForPageToLoad();
	FilterDropDwon.click();
	wait(2);
	ClearFiltersButton.click();
	wait(2);
	StuNumDropDown.click();
	wait(2);
	StuNumFilter.click();
	wait(2);
	value.clearAndType(data.get("StudentNumber"));
	wait(2);
	FilterButton.click();
	wait(2);
	ClickStudent.click();
	wait(10);						
	return this;	
}
	

public StudentHomePage ProcessesPage() {

	wait(5);
	waitForPageToLoad();
	MenuButton.click();
	waitForPageToComplete();						 
	Processes.click();
	waitForPageToLoad();
	wait(5);				 
	return this;
	}


public StudentHomePage MenuButton() throws Exception {


		waitForPageToLoad();	   
		Menu.waitTillElementClickable();
		Menu.clickUsingJavaScriptExecutor();
		wait(5);
		return this;
	//End of Menu Button	
	}

public StudentHomePage StudentButton() throws Exception{
		Students.clickUsingJavaScriptExecutor();
		waitForPageToLoad();
		wait(5);
		return this;
		//return this;
    }
		
public StudentHomePage SettingsButton() throws Exception{
		Settings.click();
		wait(2);
		return this;
	}

public StudentHomePage ConfigurationButton() throws Exception{
		//wait(5);
		Configuration.click();
		return this;
		//return this;
	}

public StudentHomePage ProcessesButton() throws Exception{
	//wait(5);
	Processes.click();
	return this;
}
public StudentHomePage SelectAStudent(StringHash data) throws Exception {
	
	
	Dropbox StudentStatus = new Dropbox("Student Status", byXPath("//li[. = '"+data.get("StudentStatus")+"']"));
	Dropbox Campus = new Dropbox("Campus", byXPath("//li[. = '"+data.get("Campus")+"']"));	
	//Login Page Web Elements
	waitForPageToLoad();
	wait(5);
	Span8.waitTillElementClickable();
	Span8.click();
	wait(2);
	StudentStatus.click();
	Span9.waitTillElementClickable();
	Span9.click();
	wait(2);
	Campus.click();
	ApplyFilters.waitTillElementClickable();
	ApplyFilters.click();
	wait(6);
	SearchName.clearAndType(data.get("StudentName").toString());
	wait(7);
	StudentSpan.click();	
	return this;
}


public StudentHomePage SelectTasksMenu(StringHash data) throws Exception {
	
	//Login Page Web Elements
	wait(10);
	waitForPageToLoad();	
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(20000);
	//Menu.waitTillElementFound();
	Menu.waitTillElementClickable();
	Menu.click();
	//js.executeScript("arguments[0].click();",Menu);
	TasksButton.waitTillElementClickable();
	//js.executeScript("arguments[0].click();",subMenuConfiguration);
	TasksButton.click();
	return this;
}

public StudentHomePage CreateLetter(StringHash data) throws Exception {

	Link TaskMsg = new Link("TaskMsg", byXPath("//span[text()='The Task records were successfully saved.']"));
	Link RoleSelect = new Link("Role", byXPath("//li[text()='"+data.get("Role")+"']"));
	Link SelectingEmployer = new Link("Selecting searched employer", byXPath("//a[text()='"+data.get("EmpName")+"']"));
	Link SelectingTaskTemp = new Link("Selecting task template", byXPath("//a[text()='//span[text()='"+data.get("TaskTemplate")+"']']"));
	Checkbox SelectingStudent = new Checkbox("Selecting Student", byXPath("//input[@aria-label = '"+data.get("LastName")+", "+data.get("FirstName")+"']"));
	//waitForPageToLoad();
	wait(5);
	Role.click();
	wait(2);
	RoleSelect.click();
	wait(2);
	GlobalSearch.sendKeys(data.get("EmpName"));
	wait(2);
	Search.click();
	wait(5);
	SelectingEmployer.click();
	wait(15);
	Task.click();
	wait(5);
	NewButton.click();
	wait(8);
	TaskTemplate.clearAndType(data.get("TaskTemplate"));
	wait(1);
	//SelectingTaskTemp.click();
	wait(8);
	Student.clickUsingJavaScriptExecutor();
	wait(4);
	SearchName.clearAndType(data.get("FullName"));
	wait(3);
	SelectingStudent.click();
	wait(2);
	SelectButton.click();
	wait(3);
	SaveAndClose.click();
	wait(2);
	CustomAsserts.containsString(TaskMsg.getText(), data.get("TaskMsg").toString());
	return this;
//End of Menu Button	

}


public StudentHomePage GroupPage() {
	
	waitForPageToLoad();
	Menu.click();
	wait(10);
	Groups.click();
	waitForPageToLoad();
	wait(10);
	return this;
}
}

