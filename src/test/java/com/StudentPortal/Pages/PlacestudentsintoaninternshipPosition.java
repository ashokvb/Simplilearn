package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import java.awt.ScrollPane;

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

public class PlacestudentsintoaninternshipPosition extends BasePage{ 
	//Login Page Web Elements
	//static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	//static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.='Filter']"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Link OLIVIAWARNER = new Link("Click on OLIVIA WARNER", byXPath("//span[text()='WARNER, OLIVIA']"));
	static Link CareerServices = new Link("Click on Career Services", byXPath("//cns-panel-bar/ul[1]/li[4]/span"));
	static Link PlacementsInternships = new Link("Click on Placements&Internships", byXPath("//*[@id='studentTilesPanelBar']/li[4]/div/div[2]/div/span"));
	static Button New = new Button("Click New", byXPath("//a[@id='studentPlacementNewButton']"));
	static Link Employer = new Link("Select Employer", byXPath("//*[@id='search_display_employerSearch']"));
	static TextField SearchEmployer = new TextField("Search Employer Name", byXPath("//*[@id='search']"));
	static Checkbox EmployerButton = new Checkbox("Select Employer Button", byXPath("(//input[@type='checkbox'])[2]"));
	static Button Select = new Button("Select Button", byXPath("//button[text()='Select']"));
	static TextField JobType = new TextField("Enter Job Type", byXPath("//input[@name='jobType_input']"));
	static Link SelJobType = new Link("Select Job Type", byXPath("//span[. ='Internship/Externship']"));
	//static TextField PlacementStatus = new TextField("Enter Job Status", byXPath("//input[@name='placementStatus_input']"));
	//static Link SelPlacementStatus = new Link("Select Job Status", byXPath("//*[@id='0884bfb5-865a-4e2f-ab5a-efd249df6840']/div/span[1]"));
	static TextField jobTitle_input = new TextField("Enter jobTitle_input'", byXPath("//input[@name='jobTitle_input']"));
	static Link SeljobTitle_input = new Link("Select jobTitle_input'", byXPath("//span[. ='Administrative']"));
	static TextField InFieldofStudy = new TextField("Enter Field od Study'", byXPath("//input[@name='inFieldOfStudy_input']"));
	static Link SelInFieldofStudy = new Link("Select Field od Study'", byXPath("//span[. ='Related']"));
	static TextField HowPlaced = new TextField("Enter HowPlaced Value'", byXPath("//input[@name='howPlaced_input']"));
	static Link SelHowPlaced = new Link("Sel HowPlaced Value'", byXPath("//span[. ='College']"));
	static TextField SalaryAmount = new TextField("Enter Salary Amount'", byXPath("(//input[@aria-label='Salary Amount'])[1]"));
	//static Link SelSalaryAmount = new Link("Select Salary Amount'", byXPath("//*[@id='salary']/.."));
	static TextField SalaryStatus = new TextField("Enter Salary Status'", byXPath("//input[@name='salaryOption_input']"));
	static Link SelSalaryStatus = new Link("Select Salary Status'", byXPath("//span[. ='Actual']"));
	static TextField SalaryType = new TextField("Enter Salary Type'", byXPath("//input[@name='salaryType_input']"));
	static Link SelSalaryType = new Link("Select Salary Type'", byXPath("//span[. ='Flat Rate']"));
	static TextField DatePlaced = new TextField("Enter Date Placed'", byXPath("//*[@id='datePlaced']"));
	static TextField StartDate = new TextField("Enter Start Date'", byXPath("//*[@id='startDate']"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("(//button[@aria-label='Save & Close'])[2]"));	
//Random Value
	static String RstName = AppendValue.apendString();
	static String RstCode = AppendValue.apendString();
	
public PlacestudentsintoaninternshipPosition PlaceInternshipPosition(StringHash data) throws Exception{
		
//X-path Parameterization
		Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
		Checkbox EmployerButton = new Checkbox("Select Employer Button", byXPath("//input[@aria-label='"+data.get("EmployerName")+"']"));
		Link SelJobType = new Link("Select Job Type", byXPath("//span[. ='"+data.get("JobType Name")+"']"));
		Link AddDegreeSaveMessage = new Link("AddDegreeSaveMessage", byXPath("//span[. = 'The Placement records were successfully saved.']"));
		Link SeljobTitle_input = new Link("Select jobTitle_input'", byXPath("//span[. ='"+data.get("jobTitle_input Name")+"']"));
		Link SelInFieldofStudy = new Link("Select Field od Study'", byXPath("//span[. ='"+data.get("InFieldofStudy Name")+"']"));
		Link SelHowPlaced = new Link("Sel HowPlaced Value'", byXPath("//span[. ='"+data.get("HowPlaced Name")+"']"));
		Link SelSalaryStatus = new Link("Select Salary Status'", byXPath("//span[. ='"+data.get("SalaryStatus Name")+"']"));
		Link SelSalaryType = new Link("Select Salary Type'", byXPath("//span[. ='"+data.get("SalaryType Name")+"']"));
		
//Method Implementation
		waitForPageToLoad();
        wait(10);
		FilterDropDwon.click();
		wait(2);
		ClearFiltersButton.click();
		wait(10);
        StuNumDropDown.click();
		wait(1);
		StuNumFilter.click();
		wait(1);
		value.clearAndType(data.get("Student Number"));
		wait(2);
		FilterButton.click();
	    wait(2);
		ClickStudentName.click();
		wait(5);
	    CareerServices.click();
		wait(3);
		PlacementsInternships.click();
		wait(2);
		New.click();
		wait(2);
		scrollPage(0, 500);
        Employer.click();
		wait(3);
		SearchEmployer.clearAndType(data.get("EmployerName").toString());
		wait(3);
		EmployerButton.click();
		wait(3);
		Select.click();
		wait(2);
		JobType.clearAndType(data.get("JobType Name").toString());
		wait(2);
		SelJobType.click();
		scrollPage(0,200);
		wait(2);
		jobTitle_input.clearAndType(data.get("jobTitle_input Name").toString());
		wait(1);
		SeljobTitle_input.click();
		scrollPage(0, 500);
		wait(2);
		SalaryAmount.sendKeys(data.get("SalaryAmount Name"));
		wait(2);
		InFieldofStudy.clearAndType(data.get("InFieldofStudy Name").toString());
		wait(1);
		SelInFieldofStudy.click();
		wait(2);
		HowPlaced.clearAndType(data.get("HowPlaced Name").toString());
		wait(2);
		SelHowPlaced.click();
		scrollPage(0,200);
		wait(3);
		SalaryStatus.clearAndType(data.get("SalaryStatus Name").toString());
		wait(2);
		SelSalaryStatus.click();
		wait(2);
		SalaryType.clearAndType(data.get("SalaryType Name").toString());
		wait(2);
		SelSalaryType.click();
		wait(2);
		DatePlaced.clearAndType(data.get("Date Placed"));
		wait(2);
		StartDate.clearAndType(data.get("Start Date"));
		wait(5);
		scrollPage(0, -1200);
		wait(2);
		SaveAndClose.waitTillElementClickable();
		SaveAndClose.click();
		wait(3);
		CustomAsserts.containsString(AddDegreeSaveMessage.getText(), data.get("SuccessMessage").toString());
		wait(2);
		return this;
    }
}

	
