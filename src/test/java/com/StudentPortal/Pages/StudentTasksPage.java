package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byLinkText;
import static com.framework.elements.Locator.byCSSSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.framework.base.BasePage;
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


public class StudentTasksPage extends BasePage {
	
public StudentTasksPage ConfirmPendingTasksForStaff(StringHash data) throws Exception{
		
		//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));		
		Link TasksSpan = new Link("TasksSpan", byXPath("//li[1]/div/div[1]/div"));
		Button ApplyFilter = new Button("ApplyFilter", byXPath("//button[text()='Apply Filter']"));
		Button TaskTemplateSpan = new Button("TaskTemplateSpan", byXPath("//cns-student-task-form/div/div[2]/cmc-drop-down-list/div/div/span//span[2]"));		
		Link StatusTableCell = new Link("StatusTableCell", byXPath("(//td[text()='"+data.get("Status")+"'])[1]"));
		Link TaskSubjectTableCell = new Link("TaskSubjectTableCell", byXPath("(//td[@title='"+data.get("TaskTemplate")+"'])[1]"));
		
		waitForPageToLoad();
		ApplyFilter.waitTillElementClickable();
		ApplyFilter.click();
		wait(8);
		CustomAsserts.containsString(StatusTableCell.getText(), data.get("Status").toString());
		CustomAsserts.containsString(TaskSubjectTableCell.getText(), data.get("TaskTemplate").toString());
		return this;

	}


public StudentTasksPage EditTaskByStaff(StringHash data) throws Exception{
	
	//Link InstructorTableCell = new Link("Click on Instructor table cell", byXPath("//td[. = '"+data.get("SectionCode")+"']"));
	
	Link TasksSpan = new Link("TasksSpan", byXPath("//li[1]/div/div[1]/div"));
	Button ApplyFilter = new Button("ApplyFilter", byXPath("//button[text()='Apply Filter']"));
	Button TaskTemplateSpan = new Button("TaskTemplateSpan", byXPath("//cns-student-task-form/div/div[2]/cmc-drop-down-list/div/div/span//span[2]"));	
	Link StatusTableCell = new Link("StatusTableCell", byXPath("(//td[text()='"+data.get("Status")+"'])[1]"));	
	Link TaskSubjectCell = new Link("TaskSubjectCell", byXPath("(//a[. = '"+data.get("TaskTemplate")+"'])[1]"));
	Button StatusSpan = new Button("StatusSpan", byXPath("//div[9]/cmc-drop-down-list-classic/div/div/span//span[2]"));
	Dropbox Status = new Dropbox("Status", byXPath("//span[. = '"+data.get("Status")+"']"));
	TextField Note = new TextField("Note", byCSSSelector("[name='noteTextArea']"));
	Button SaveAndClose = new Button("SaveAndClose", byCSSSelector("#formSaveCloseButton"));
	
	waitForPageToLoad();
	ApplyFilter.waitTillElementClickable();
	ApplyFilter.click();
	wait(8);
	TaskSubjectCell.click();
	waitForPageToLoad();
	scrollPage(0, 500);
	StatusSpan.click();
	wait(2);
	Status.click();
	wait(2);
	Note.clearAndType(data.get("Note").toString());
	scrollPage(0, -500);
	SaveAndClose.click();
	waitForPageToLoad();
	CustomAsserts.containsString(TaskSubjectCell.getText(), data.get("TaskTemplate").toString());
	CustomAsserts.containsString(StatusTableCell.getText(), data.get("Status").toString());
	
	return this;

}
}
