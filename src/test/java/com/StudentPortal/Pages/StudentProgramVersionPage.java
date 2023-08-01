package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byXPath;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;

import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byName;
import static com.framework.elements.Locator.byXPath;

public class StudentProgramVersionPage extends BasePage {
	
	static String PVName= AppendValue.apendString();
	static String PVCode = AppendValue.apendString();	
	//Program Version Web Elements
	static Link configuration = new Link("Click Configuration", byXPath("//a[.=\"Configuration\"]"));
	static TextField SearchInConfiguration = new TextField("Search in Configuration" , byXPath("//input[@placeholder=\"Search Configuration\"]"));
	static Link ClickProgram = new Link("Click Program", byXPath("//span[text()=\"Programs\"]"));
	static Button FilterButton = new Button("Click Filter Button", byXPath("//div[2]/a[2]"));
	static Link ClearFilter = new Link("Clear Filter", byXPath("//a[.=\"Clear Filters\"]"));
	static AngDropDown CodeDropDown = new AngDropDown("Click Code Drop Down", byXPath("//th[3]/a/span"));
	static Button CodeFilterButton  =  new Button("Code Filter Button", byXPath("//span[.=\"Filter\"]"));
	static TextField Value = new TextField("Click Filter", byXPath("//input[@title=\"Value\"]"));
	static Button Filter = new Button("Filter Button", byXPath("//button[text()=\"Filter\"]"));
//	static Link ClickProgramName = new Link("Click Program", byXPath("//a[.=\"Parent Program\"]"));
	static Link NewPV= new Link("Click New",byId("addProgramVersionButton"));
	static TextField Code= new TextField("Enter PV Code",byId("programVersionCodeId"));
	static TextField Name= new TextField("Enter PV Name",byId("programVersionNameId"));
	static TextField Degrees= new TextField("Enter Degrees",byName("degreeId_input"));
	static Button SelectDegrees= new Button("Select Degrees",byXPath("//span[@title=\"New\"]"));
	static Button CampusLicense = new Button("Campus License",byXPath("(//span[@unselectable=\"on\" and @class=\"k-input\"])[3]"));
	static Button SelectCampusLicense = new Button("Select Campus License", byXPath("//li[.=\"Full\"]"));
	static TextField GradeScale= new TextField("Enter Grade Scale",byName("gradeScaleId_input"));
	static Button SelectGradeScale= new Button("Select Grade Scale",byXPath("//span[.=\"Primary Grade Scale\"]"));
	static TextField ActiveUnits= new TextField("Enter Active Units",byXPath("(//input[@aria-label=\"Active Units\"])[1]"));
	static TextField ActiveUnitTypes= new TextField("Enter Active Units Types",byName("activeWhenId_input"));
	static Button SelectActiveUnitTypes= new Button("Select Active Unit Types",byXPath("//li[.=\"Credits have been Registered\"]"));
	static TextField ProgramLength= new TextField("Enter Program Length",byName("publishedProgramLengthId_input"));
	static Button SelectProgramLength= new Button("Select Program Length",byXPath("//li[.=\"Weeks\"]"));
	static TextField PublishedPLAmount = new TextField("Enter Published Program Length Amount", byXPath("(//input[@aria-label=\"Published Program Length Amount\"])[1]"));
	static TextField TotalWeeks = new TextField("Enter Total Weeks", byXPath("(//input[@aria-label=\"Total Weeks\"])[1]"));
	static Checkbox CampusSelect = new Checkbox("Select Campus", byXPath("(//input[@aria-label=\"Select All\"])[2]"));
	static Button SaveAndClose = new Button("Save and Close", byXPath("//button[@aria-label=\"Save & Close\"]"));
	
	public StudentProgramVersionPage ProgramVersionCreation(StringHash data) throws Exception {
		
		Checkbox SelectProgram = new Checkbox("Check the Campus", byXPath("//a[.='"+StudentProgramPage.ProgramName+"']"));
		waitForPageToLoad();
		SearchInConfiguration.clearAndType(StudentProgramPage.ProgramCode);
		ClickProgram.click();
		waitForPageToLoad();
		wait(6);
		FilterButton.click();
		wait(2);
		ClearFilter.click();
		wait(2);
		waitForPageToLoad();
		CodeDropDown.click();
		wait(2);
		CodeFilterButton.click();
		wait(2);
		Value.clearAndType(StudentProgramPage.ProgramCode);
		wait(2);
		Filter.click();
		wait(2);
		SelectProgram.click();
		wait(10);
		waitForPageToLoad();
		scrollPage(0, 1200);
		NewPV.click();
		waitForPageToLoad();
		wait(3);
		Code.clearAndType(PVCode);
		wait(1);
		Name.clearAndType(PVName);
		wait(1);
		Degrees.clearAndType(StudentDegreeCreation.DegreeCode);
		wait(2);
//		SelectDegrees.click();		
		CampusLicense.click();
		wait(2);
		SelectCampusLicense.click();
		wait(2);
		scrollPage(0, 600);
		GradeScale.clearAndType(data.get("Grade Scale"));
		wait(2);
//		SelectGradeScale.click();		
		ActiveUnits.clearAndType("10");
		wait(2);
		ActiveUnitTypes.clearAndType(data.get("Active Units Types"));
		wait(2);
//		SelectActiveUnitTypes.click();		
		ProgramLength.clearAndType("Weeks");
		wait(2);
//		SelectProgramLength.click();		
		PublishedPLAmount.clearAndType("10");
		wait(2);
		TotalWeeks.waitTillElementClickable();
    	TotalWeeks.clearAndType("6");
		wait(2);
		scrollPage(0, 300);
		wait(1);
		CampusSelect.click();
		wait(2);
		scrollPage(0, -1000);
		SaveAndClose.click();
		wait(15);
		return this;
			
	}	

}
