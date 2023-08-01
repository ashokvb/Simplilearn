package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byLinkText;
import static com.framework.elements.Locator.byCSSSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

import groovy.time.Duration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StudentClassSchedulingPage<WaitForPageToLoad> extends BasePage{
	 //Configuration -class scheduling Page Web Elements	
	//StudentTermsPage TPage = new StudentTermsPage();
	//String TermCodeValue =TPage.TermCodeValueForClassSection;
	static String TermCodeValueForClass = StudentTermsPage.TermCodeValue;	
	static Link New = new Link("Click on New Link", byXPath("//a[5][. = 'New']"));
	static TextField Term = new TextField("Click on term input box", byCSSSelector("[name='termId_input']"));
	static Link TermCodeSpan = new Link("Click on term code span", byXPath("//div/div/div[3]/ul//span[1]"));
	static Link SelTermCodeSpan1 = new Link("Click on term code span", byXPath("//span[@title=\"2024SPR\"]"));
	static TextField Course = new TextField("Click on course input box", byCSSSelector("[name='courseId_input']"));
	//static Link CourseSpan = new Link("Click on course span", byXPath("//div[31]/div/div[3]//span[1]"));
	static TextField SectionCode = new TextField("Section code", byCSSSelector("#sectionCode"));
	static TextField Instructor = new TextField("Instructor", byCSSSelector("[name='instructorId_input']"));
	//static Link InstructorSpan = new Link("Click on Instructor span", byXPath("//div[22]/div/div[3]//span[1]"));
	static TextField Span = new TextField("Span", byXPath("//div[4]/cmc-numeric-input-text/div/div/span/span"));
	//static TextField MaxStudents = new TextField("Maximum Students", byCSSSelector("#maximumStudents"));	
	//static TextField MaxStudents = new TextField("Maximum Students", byXPath("(//input[@type='text'])[10]"));	
	static TextField MaxStudents = new TextField("Maximum Students", byXPath("(//input[@aria-label='Max. Studs.'])[1]"));
	//static TextField MaxStudents = new TextField("Maximum Students", byXPath("//(//span[@aria-label='Maximum Students']//span//input[@aria-valuenow='0'])[1]"));	
	static TextField Span1 = new TextField("Span", byXPath("//div[5]/cmc-drop-down-list[1]/div/div/span/span/span/span"));
	static TextField Span2 = new TextField("Span", byXPath("//cmc-drop-down-list[2]/div/div/span//span[2]"));	
	static Button Save = new Button("Click Save", byXPath("//cmc-toolbar-button-save//button"));
	static Button ExSave = new Button("Click Save", byXPath("//button[@aria-label='Save']"));
	static Label DocumentsandLMSOptions = new Label("Click DocumentsandLMSOptions", byXPath("//div[. = 'Documents & LMS Options']"));
	static TextField SelDM = new TextField("Click DM", byXPath("(//span[@title=\"Online\"])[1]"));
	static Checkbox SelectVendor = new Checkbox("Select Vendor", byCSSSelector("[name='IsSelected']"));
	static TextField ExtractStatus = new TextField("ExtractStatus", byCSSSelector("[name='classExtractStatus_input']"));
	static TextField DeliveryMethodField = new TextField("Delivery Method", byXPath("//input[@name='deliveryMethodId_input']"));
	static Button Save1 = new Button("Click Save", byCSSSelector("#classSectionlmsDocumentOptionsSaveButton"));	
	static TextField StartDte = new TextField("Enter Start Date", byXPath("//input[@id='startDate']"));
	static TextField EndDte = new TextField("Enter End Date", byXPath("//input[@id='endDate']"));
	////cmc-drop-down-list[@cmc-id='deliveryMethodId']	
	static Link Term1 = new Link("Click on Term1", byXPath("//div[@aria-label=\"Term\"]"));
	static TextField SearchTerm = new TextField("Enter Term", byXPath("//input[@id='search']"));
	static Checkbox SelectTerm = new Checkbox("Select Term", byXPath("//input[@aria-label='NEW']"));
	static Button Select = new Button("Select Button", byXPath("//button[text()='Select']"));
	static Link Course1 = new Link("Click on Course", byXPath("//div[@id='search_display_courseId']"));
	static TextField EnterCourse = new TextField("Enter Course", byXPath("//input[@id='search']"));
	static Checkbox SelectCourse = new Checkbox("Select Course", byXPath("//input[@aria-label='0.694']"));
	static Button Select2 = new Button("Select Button", byXPath("//button[text()='Select']"));
	static Link ApplyFilter = new Link("Click On Apply Filter", byXPath("//button[@class='k-button k-primary']"));
	static Button ClsFilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class='k-button k-split-button-arrow'])[1]"));
	static Link ClsClearFiltersButton = new Link("Click Filter Button", byXPath("//a[. = 'Clear Filters']"));
	static AngDropDown TermDropDown = new AngDropDown("Click Term Number Dropdown", byXPath("(//tr/th[4]/a)[1]"));
    static Button TerNumFilter = new Button("Click Term Num Filter", byXPath("//span[.='Filter']"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title='Value']"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()='Filter']"));
    static Checkbox SeltermButton = new Checkbox("Click Term Button", byXPath("//input[@id='checkAll']"));
    static Link ClickCoursesec = new Link("Click on Course section", byXPath("//a[@class='cmc-link-column']"));
    static TextField UpdSecCode = new TextField("Enter Section Code", byXPath("//input[@id='sectionCode']"));
    static Button SaveandClose = new Button("Click SaveandClose ", byXPath("(//button[@class='cmc-toolbar-button ng-binding'])[2]"));
    static Link CopyClassSchedule = new Link("Click on copyclass schedule", byXPath("//a[@id='copyButton']"));
    static TextField Termfield = new TextField("Enter Term", byXPath("//input[@name='fromTermId_input']"));
    static TextField classsec = new TextField("Enter Class section", byXPath("//input[@name='classSectionId_input']"));
    static TextField SectionCod = new TextField("Enter Section", byXPath("//input[@id='sectionName']"));
    static Button CopyButton = new Button("Click on Copy ", byXPath("//button[@id='saveModelContentButton']"));   
    static String SectionCodeName = AppendValue.apendString();
    static TextField SecCode = new TextField("Enter Section", byXPath("//input[@id='sectionName']"));
  //Random Value
    static String SectionCode1 = AppendValue.apendString();
    
public StudentClassSchedulingPage CreatingClassSchedule(StringHash data) throws Exception{
	
	
	Link CourseSpan = new Link("Click on course span", byXPath("//span[. = '"+data.get("Course")+"']"));
	Link InstructorSpan = new Link("Click on Instructor span", byXPath("//span[. = '"+data.get("Instructor")+"']"));
	Dropbox DeliveryMethod = new Dropbox("DeliveryMethod", byXPath("//span[. = '"+data.get("DeliveryMethod")+"']"));	
	//span[text()='Online - Recorded']
	Dropbox Language = new Dropbox("language", byXPath("//span[. = '"+data.get("Language")+"']"));
	//setImplicitWaitTimeout(implicitWaitTimeout);
	waitForPageToLoad();
	New.waitTillElementClickable();
	New.click();
	waitForPageToLoad();
	Term.waitTillElementClickable();
	Term.click();
	wait(2);
	//Term.clearAndType(data.get("TermCode").toString());
	Term.clearAndType(TermCodeValueForClass.toString());
	TermCodeSpan.waitTillElementClickable();
	TermCodeSpan.click();
	Thread.sleep(7000);		
	//course.selectByText(data.get("Course").toString());
	Course.click();
	Course.clearAndType(data.get("Course").toString());
	Thread.sleep(5000);
	CourseSpan.waitTillElementClickable();
	CourseSpan.click();
	waitForPageToLoad();
	SectionCode.waitTillElementClickable();
	SectionCode.click();
	SectionCode.clearAndType(data.get("SectionCode").toString());
	Instructor.waitTillElementClickable();
	Instructor.click();
	Instructor.clearAndType(data.get("Instructor").toString());
	InstructorSpan.waitTillElementClickable();
	InstructorSpan.click();
	Thread.sleep(6000);
	//Span.click();
	//Thread.sleep(6000);
	//Span.clearAndType(data.get("MaxStudents").toString());
	//Thread.sleep(3000);
	//MaxStudents.waitTillElementClickable();
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();",MaxStudents);
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//MaxStudents.click();
	//MaxStudents.clear();
	
	MaxStudents.type("40");
	
//	WebDriverWait wait = new WebDriverWait(driver,20);
//	WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@aria-label='Maximum Students']//span//input[1]")));
//	ele.click();
//	
//	ele.sendKeys("40");
	//Span.clear();
	//MaxStudents.waitTillElementClickable();
	//MaxStudents.click();
	//js.executeScript("document.getElementsByXpath('//span[@aria-label='Maximum Students']//span//input[1]')[0].value= '40'");
	//MaxStudents.clearAndType(data.get("MaxStudents").toString());
	//MaxStudents.sendKeys("40");s
	DeliveryMethodField.clearAndType(data.get("DeliveryMethod").toString());
	Thread.sleep(3000);
	//Span1.click();
	//DeliveryMethod.selectByText(data.get("DeliveryMethod").toString());	
	DeliveryMethod.click();
	Thread.sleep(3000);
	Span2.click();
	Thread.sleep(2000);
	//Language.selectByText(data.get("Language").toString());
	Language.click();
	Thread.sleep(3000);
	Save.click();
	waitForPageToLoad();
	wait(5);
	DocumentsandLMSOptions.waitTillElementClickable();
	DocumentsandLMSOptions.click();
	waitForPageToLoad();
	SelectVendor.waitTillElementClickable();
	SelectVendor.click();
	//CustomAsserts.containsString(ExtractStatus.getText(), "Ready".toString());
	Save1.click();
	return this;
}

public StudentClassSchedulingPage CreatingClassScheduleUsingExistingTerm(StringHash data) throws Exception{
	
	//X-path Parameterization	
		Link SelTermCodeSpan1 = new Link("Click on term code span", byXPath("//span[@title= '"+data.get("TermCode")+"']"));
		Link CourseSpan = new Link("Click on course span", byXPath("//span[. = '"+data.get("Course")+"']"));
		Link InstructorSpan = new Link("Click on Instructor span", byXPath("//span[. = '"+data.get("Instructor")+"']"));	
		Link CreateClsSchedSaveMessage = new Link("CreateClsSchedSaveMessage", byXPath("//span[. = 'The Documents & LMS Options records were successfully saved.']"));

	//Method Implementation
		waitForPageToLoad();
		wait(5);
		New.click();	
		wait(20);
		Term.click();
		wait(2);
		Term.clearAndType(data.get("TermCode").toString());
		SelTermCodeSpan1.clickUsingJavaScriptExecutor();
		wait(2);
		Course.click();
		wait(2);
		Course.clearAndType(data.get("Course").toString());
		CourseSpan.waitTillElementClickable();
		CourseSpan.click();
		waitForPageToLoad();
		SectionCode.click();
		wait(2);
		//SectionCode.clearAndType(data.get("SectionCode").toString());
		SectionCode.clearAndType(SectionCode1);
		wait(2);
		Instructor.click();
		wait(2);
		Instructor.clearAndType(data.get("Instructor").toString());
		wait(2);
		InstructorSpan.waitTillElementClickable();
		InstructorSpan.click();
		wait(3);	
		MaxStudents.sendKeys(data.get("MaxStudents"));
		wait(3);
		DeliveryMethodField.clearAndType(data.get("DeliveryMethod").toString());
		SelDM.clickUsingJavaScriptExecutor();	
		wait(5);
		Save.click();	
		wait(15);
		DocumentsandLMSOptions.waitTillElementClickable();
		DocumentsandLMSOptions.click();	
		waitForPageToLoad();
		SelectVendor.waitTillElementClickable();
		SelectVendor.click();
		wait(10);	
		Save1.click();
		wait(3);
		CustomAsserts.containsString(CreateClsSchedSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
	}
	
public StudentClassSchedulingPage EditClassScheduleUsingExistingCourse(StringHash data) throws Exception{
	
	//X-path Parameterization		
		Checkbox SelectTerm = new Checkbox("Select Term", byXPath("//input[@aria-label='"+data.get("Term Name")+"']"));
		Checkbox SelectCourse = new Checkbox("Select Course", byXPath("//input[@aria-label='"+data.get("Course Name")+"']"));
		//Link CourseSpan = new Link("Click on course span", byXPath("//span[. = '"+data.get("Course")+"']"));
		//Link InstructorSpan = new Link("Click on Instructor span", byXPath("//span[. = '"+data.get("Instructor")+"']"));
		//Dropbox DeliveryMethod = new Dropbox("DeliveryMethod", byXPath("//span[. = '"+data.get("DeliveryMethod")+"']"));
		Link EditCreateClsSchedSaveMessage = new Link("EditCreateClsSchedSaveMessage", byXPath("//span[. = 'The Class Section records were successfully saved.']"));

	//Method Implementation
		waitForPageToLoad();
		wait(5);
		Term1.click();
		wait(2);
		SearchTerm.clearAndType(data.get("Term Name").toString());
		wait(2);
		SelectTerm.click();
		wait(2);
		Select.click();
		wait(2);
		Course1.click();
		wait(2);
		EnterCourse.clearAndType(data.get("Course Name").toString());
		wait(2);
		SelectCourse.click();
		wait(2);
		Select2.click();
		wait(2);
		ApplyFilter.click();
		wait(2);
		ClsFilterDropDwon.click();
		wait(2);
		ClsClearFiltersButton.click();
		wait(5);
		TermDropDown.click();
		wait(2);
		TerNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Term Code"));
		wait(2);
		FilterButton.click();
		wait(2);
		SeltermButton.click();
		wait(5);
		ClickCoursesec.click();
		wait(25);
		UpdSecCode.waitTillElementClickable();
		wait(7);
		UpdSecCode.clearAndType(SectionCodeName);
		wait(5);
		SaveandClose.click();
		wait(3);
		CustomAsserts.containsString(EditCreateClsSchedSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
	  }

public StudentClassSchedulingPage CopyClassSchedule(StringHash data) throws Exception{
	
	//X-path Parameterization	
		Checkbox SelectTerm = new Checkbox("Select Term", byXPath("//input[@aria-label='"+data.get("Term Name")+"']"));
		Checkbox SelectCourse = new Checkbox("Select Course", byXPath("//input[@aria-label='"+data.get("Course Name")+"']"));
		//Link CourseSpan = new Link("Click on course span", byXPath("//span[. = '"+data.get("Course")+"']"));
		//Link InstructorSpan = new Link("Click on Instructor span", byXPath("//span[. = '"+data.get("Instructor")+"']"));
		//Dropbox DeliveryMethod = new Dropbox("DeliveryMethod", byXPath("//span[. = '"+data.get("DeliveryMethod")+"']"));
		Link CopyClassScheduleSaveMessage = new Link("CopyClassScheduleSaveMessage", byXPath("//span[. = 'The class schedule records were successfully copied.']"));
		
	//Method Implementation
		waitForPageToLoad();
		wait(5);
		Term1.click();
		wait(2);
		SearchTerm.clearAndType(data.get("Term Name").toString());
		wait(2);
		SelectTerm.click();
		wait(2);
		Select.click();
		wait(2);
		Course1.click();
		wait(2);
		EnterCourse.clearAndType(data.get("Course Name").toString());
		wait(2);
		SelectCourse.click();
		wait(2);
		Select2.click();
		wait(2);
		ApplyFilter.click();
		wait(2);
		ClsFilterDropDwon.click();
		wait(2);
		ClsClearFiltersButton.click();
		wait(5);
		TermDropDown.click();
		wait(2);
		TerNumFilter.click();
		wait(2);
		value.clearAndType(data.get("Term Code"));
		wait(2);
		FilterButton.click();
		wait(2);
		SeltermButton.click();
		wait(5);
		CopyClassSchedule.click();
		wait(10);
		SecCode.clearAndType(data.get("To Section").toString());
		wait(2);
		CopyButton.click();
		wait(3);
		CustomAsserts.containsString(CopyClassScheduleSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
	  }
}