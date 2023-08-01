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
import com.framework.util.AppendValue;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class StudentTermsPage extends BasePage {
	
	AppendValue Apage = new AppendValue();
	static String TermNameValue = AppendValue.apendString();
	static String TermCodeValue = AppendValue.apendString();
	//String TermCodeValueForClassSection = TermCodeValue;	
    //Configuration -Terms Page Web Elements
	static Link Config = new Link("Click Configuration", byXPath("//a[@title='Configuration']"));																						  
	static TextField SearchConfig = new TextField("Search Configuration", byCSSSelector("#lists-treeview-filter"));
	static Link TermsSpan = new Link("Terms SPan", byXPath("//span[. = 'Terms']"));
	static Link New = new Link("New Link",byXPath("//a[5][. = 'New']"));
	static TextField TermName = new TextField("Enter term name", byCSSSelector("#name"));
	static TextField TermCode = new TextField("Enter term code", byCSSSelector("#code"));
	static TextField SelectCampuses = new TextField("click on campus", byCSSSelector("#campusesSearch"));
	static TextField SelectCampuses1 = new TextField("again click campus", byXPath("//cmc-search-display/div/div"));
	static TextField SearchCampus = new TextField("Search the campus", byXPath("//input[@placeholder = 'Search Name']"));
	static Checkbox CampusCheckbox = new Checkbox("Select campus checkbox", byXPath("//td/input"));
	static Button Select = new Button("Click select button", byXPath("//button[. = 'Select']"));
	static TextField StartDate = new TextField("Enter Start Date", byCSSSelector("#startDate"));
	static TextField EndDate = new TextField("Enter End Date", byCSSSelector("[name='endDate']"));
	static Button Save = new Button("Click Save button", byXPath("//cmc-toolbar-button-save//button"));
	static Checkbox SendCourseSections = new Checkbox("select SendCourseSections checkbox", byXPath("//div[2]/cmc-checkbox[1]//label"));
	static Checkbox SendInstructorAssignments = new Checkbox("select SendInstructorAssignments checkbox", byXPath("//cmc-checkbox[5]//label"));
	static Checkbox SendStudentRegistrations = new Checkbox("select SendStudentRegistrations checkbox", byXPath("//div[2]/cmc-checkbox[2]//label"));
	

	
public StudentTermsPage CreatingTerm(StringHash data) throws Exception {
	
	waitForPageToLoad();
	SearchConfig.waitTillElementClickable();
	//SearchConfig.clearAndType(data.get("UserName").toString());
	SearchConfig.click();
	SearchConfig.clearAndType("terms");
	TermsSpan.waitTillElementClickable();
	TermsSpan.click();
	wait(5);
	New.waitTillElementClickable();
	New.click();
	waitForPageToLoad();
	TermName.waitTillElementClickable();
	TermName.click();
	//String str = apendString();
	//TermName.clearAndType(data.get("TermName").toString());
	TermName.clearAndType(TermNameValue.toString());
	wait(3);
	TermCode.waitTillElementClickable();
	TermCode.click();
	//TermCode.clearAndType(data.get("TermCode").toString());
	TermCode.clearAndType(TermCodeValue.toString());
	wait(3);
	SelectCampuses.waitTillElementClickable();
	SelectCampuses.click();
	Thread.sleep(6000);
	SelectCampuses1.waitTillElementClickable();
	SelectCampuses1.click();
	SearchCampus.waitTillElementClickable();
	SearchCampus.click();
	SearchCampus.clearAndType(data.get("Campus").toString());
	Thread.sleep(4000);
	CampusCheckbox.click();
	Select.click();
	StartDate.waitTillElementClickable();
	StartDate.click();
	StartDate.clearAndType(data.get("StartDate").toString());
	EndDate.waitTillElementClickable();
	EndDate.click();
	EndDate.clearAndType(data.get("EndDate").toString());
	Save.waitTillElementClickable();
	Save.click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(7000);
	SendCourseSections.click();
	SendInstructorAssignments.click();
	SendStudentRegistrations.click();
	js.executeScript("window.scrollBy(0,-500)", "");
	Save.click();
    return this;
}
}


