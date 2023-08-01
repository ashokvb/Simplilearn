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

public class StudentGradesPage extends BasePage {
	
	static TextField SearchConfig = new TextField("Search Configuration", byCSSSelector("#lists-treeview-filter"));
	static Link GradeScaleSpan = new Link("GradeScaleSpan", byXPath("//span[. = 'Grade Scales']"));

public StudentGradesPage AddLetterGradeUnderGradeScale(StringHash data) throws Exception{
	
	Link GradeScaleName = new Link("GradeScaleName", byXPath("//a[text()='"+data.get("GradeScaleName")+"']"));
	Link New = new Link("New", byXPath("//a[@id='NewLetterGrade']"));
	TextField LetterGradeBox = new TextField("LetterGradeBox", byXPath("//input[@aria-label='Letter Grade']"));
	TextField LetterNameBox = new TextField("LetterNameBox", byXPath("(//input[@aria-label='Name'])[1]"));
	Button Save = new Button("Save", byXPath("(//button[text()='Save'])[1]"));
	
	waitForPageToLoad();
	SearchConfig.waitTillElementClickable();
	SearchConfig.click();
	SearchConfig.clearAndType("grade");
	GradeScaleSpan.waitTillElementClickable();
	GradeScaleSpan.click();
	wait(5);
	GradeScaleName.waitTillElementClickable();
	GradeScaleName.click();
	waitForPageToLoad();
	scrollPage(0, 500);
	New.waitTillElementClickable();
	New.click();
	wait(6);
	LetterGradeBox.waitTillElementClickable();
	LetterGradeBox.click();
	LetterGradeBox.clearAndType(data.get("LetterGrade").toString());
	LetterNameBox.waitTillElementClickable();
	LetterNameBox.click();
	wait(3);
	LetterNameBox.clearAndType(data.get("LetterName").toString());
	Save.waitTillElementClickable();
	Save.click();
	
	return this;

}

}
