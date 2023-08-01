package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import org.openqa.selenium.By;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;

public class StudentGradebookPage extends BasePage{ 
	//Login Page Web Elements
	//static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	//static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	//static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	//static Link Configuration = new Link("Configuration tile", byXPath("//a[text()='Configuration']"));
	static TextField SearchProcess = new TextField("Search Process", byXPath("//input[@placeholder='Search Processes']"));
	static Link Gradebook = new Link("Grade Book", byXPath("//span[text()='Gradebook']"));
	static Button Lessons = new Button("Click Lessons", byXPath("(//button[@type=\"button\"])[3]"));
	static Link Term = new Link("Click on Term", byXPath("//div[@id='search_display_termId']"));
	static TextField EnterTerm = new TextField("Enter Term", byXPath("//input[@id='search']"));
	static Checkbox SelectTerm = new Checkbox("Select Term", byXPath("//input[@aria-label='2022 Spring R']"));
	static Button Select = new Button("Select Button", byXPath("//button[text()='Select']"));
	static Link Course = new Link("Click on Course", byXPath("//div[@id='search_display_courseSearch']"));
	static TextField EnterCourse = new TextField("Enter Course", byXPath("//input[@id='search']"));
	static Checkbox SelectCourse = new Checkbox("Select Course", byXPath("//input[@aria-label='AC103C - Accounting Principles I']"));
	static Button Select2 = new Button("Select Button", byXPath("//button[text()='Select']"));
	static Link ApplyFilter = new Link("Click On Apply Filter", byXPath("//button[@class='k-button k-primary']"));
	static TextField Lessonsgrid = new TextField("Enter Lessons Grid", byXPath("//td[@id=\"lessonsGrid_cmcGrid_active_cell\"]"));
	static Button Save = new Button("Click on Save", byXPath("//a[@id='saveButton']"));	
	static Button Midterm = new Button("Click Lessons", byXPath("//div[@id='navigationSplitter']/div[3]/div[2]/cns-gradebook/section/div/div/div[2]/cmc-tabs/div/div/ul/li[2]/button"));
	static Checkbox SelectTerm1 = new Checkbox("Select Term1", byXPath("//input[@aria-label='2021 Winter']"));
	static Checkbox SelectCourse1 = new Checkbox("Select Course", byXPath("//input[@aria-label='000.790.11A - FOUNDATIONS MATH']"));
	static Link LetterGrade = new Link("Click on Latergrade", byXPath("//td[. = '        ']"));
	static Link LetterGrade1 = new Link("Click on Latergrade1", byXPath("//td/span/span/span/span"));
	static Link SelLetterGrade = new Link("Click on SelLatergrade", byXPath("//li[. = 'P']"));
	static Button ClsFilterDropDwon = new Button("Click Filter Drop Down", byXPath("(//a[@class='k-button k-split-button-arrow'])[1]"));
	static Link ClsClearFiltersButton = new Link("Click Filter Button", byXPath("//div//a[. = 'Clear Filters']"));
	static Link TermDropDown = new Link("Click Term Number Dropdown", byXPath("(//th[2]//span)[1]"));
    static Button TerNumFilter = new Button("Click Term Num Filter", byXPath("//span[.='Filter']"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
	static TextField SearchContactManager = new TextField("Search SearchContactManager", byXPath("//input[@placeholder='Search Configuration']"));
	static Link TaskTemplets = new Link("TaskTemplets", byXPath("//div[@id='lists-treeview']/div[2]/ul/li/ul/li/div/span"));
	//Random Value
	static String RstName = AppendValue.apendString();
	static String RstCode = AppendValue.apendString();

	public  StudentGradebookPage RecordMidTermGrades(StringHash data) throws Exception{

//X-path Parameterization
			Checkbox SelectTerm1 = new Checkbox("Select Term1", byXPath("//input[@aria-label='"+data.get("Term Name")+"']"));
			Link RecordMidTermGradesSaveMessage = new Link("RecordMidTermGradesSaveMessage", byXPath("//span[. = 'The Midterm records were successfully saved.']"));			

//Method Implementation
			waitForPageToLoad();
			wait(5);
			SearchProcess.clearAndType(data.get("Search Name").toString());
			wait(2);
			Gradebook.click();
			wait(2);
			Midterm.click();
			wait(5);
			Term.click();
			wait(2);
			EnterTerm.clearAndType(data.get("Term Name").toString());
			wait(5);
			SelectTerm1.click();
			wait(2);	
			Select.click();
			wait(7);
			Course.click();
			wait(2);
			EnterCourse.clearAndType(data.get("Course Name").toString());
			wait(5);
			SelectCourse1.click();
			wait(5);
			Select2.click();
			wait(2);
			ApplyFilter.click();	
			wait(2);
			ClsFilterDropDwon.click();
			wait(2);
			ClsClearFiltersButton.click();
			wait(15);
			TermDropDown.click();
			wait(2);
			TerNumFilter.click();
			wait(2);
			value.clearAndType(data.get("Student Name"));
			wait(2);
			FilterButton.click();
			wait(5);
			LetterGrade.click();
			wait(2);
			LetterGrade1.click();
			wait(5);
			SelLetterGrade.clickUsingJavaScriptExecutor();
			wait(5);
			Save.click();
			wait(5);
			CustomAsserts.containsString(RecordMidTermGradesSaveMessage.getText(), data.get("SuccessMessage").toString());
			wait(2);
			return this;
	    }
		
}

	
