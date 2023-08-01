package com.StudentPortal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Dropbox;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.AppendValue;
import com.framework.util.StringHash;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byXPath;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import static com.framework.elements.Locator.byLinkText;

public class StudentDegreeCreation extends BasePage {
	
	//Configuration - Degree Web Page Elements	
	static String DegreeName = AppendValue.apendString();
	static String DegreeCode = AppendValue.apendString();	
	static Link Confi= new Link("Click Configuration", byXPath("//a[@title=\"Configuration\"]"));
	static TextField searchconfigText = new TextField("Search Configuration", byXPath("//input[@placeholder=\"Search Configuration\"]"));
	static Link ClickDegrees = new Link("Click Degrees", byXPath("//span[text()=\"Degrees\"]"));
	static Link ClickNew = new Link("Click New", byId("newButton"));
	static TextField Name = new TextField("Enter Name", byId("name"));
	static TextField Code = new TextField("Enter Code", byId("code"));
//	static Dropbox ActiveNo = new Dropbox("Click Active as 'NO'", byXPath("//body/div[@id='maincontent']/div[1]/cns-treeview-detail-view-component[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[3]/div[2]/cns-term-list[1]/div[1]/div[3]/div[1]/cns-term[1]/section[1]/div[1]/cmc-collapse[1]/div[1]/div[2]/div[1]/div[1]/div[1]/cmc-drop-down-list-classic[1]/div[1]/div[1]/span[1]/span[1]/span[1]"));
//	static Dropbox ActiveYES = new Dropbox("Click Active as 'YES'", byXPath("//span[contains(text(),'Yes')]"));
	static Link Campuses = new Link("Click Campuses", byXPath("//div[@aria-label=\"Campuses\"]"));
	static TextField SearchCampusText = new TextField("Search Campus", byXPath("//input[@placeholder=\"Search Name\"]"));
//	static Checkbox CheckCampus = new Checkbox("Check the Campus", byXPath("//input[@aria-label=\"DTS\"]"));
	//static Checkbox CheckCampus = new Checkbox("Check the Campus", byXPath("//input[@aria-label='"+data.get("Campus")+"']"));
	static Button Select = new Button("Click Select", byXPath("//button[text()=\"Select\"]"));
	static Button SaveAndClose = new Button("Click Save and Close", byXPath("//button[@aria-label=\"Save & Close\"]"));	
	static Link MenuButton = new Link("Click MenuButton", byXPath("//div[@id='navbar']/ul/li[2]/a/span"));
	static Link Students = new Link("Students tile", byXPath("//a[text()=\"Students\"]"));
	static Link FilterDropDwon = new Link("Click Filter Drop Down", byXPath("//div[3]/div[3]/div/div[1]/div/div[1]/a[2]"));
    static Link ClearFiltersButton = new Link("Click Filter Button", byXPath("//a[text()='Clear Filters']"));
    static AngDropDown StuNumDropDown = new AngDropDown("Click Student Number Dropdown", byXPath("//th[2]/a/span"));
    static Button StuNumFilter = new Button("Click Stud Num Filter", byXPath("//span[.=\"Filter\"]"));
    static TextField value = new TextField("Enter Value", byXPath("//input[@title=\"Value\"]"));
    static Button FilterButton = new Button("Click Filter Button", byXPath("//button[text()=\"Filter\"]"));
    static Link AcademicRecords = new Link("CLICK ON Academic Records", byXPath("//cns-panel-bar/ul[1]/li[3]/span"));
    static Link DHB = new Link("degree,Honers,Badges", byXPath("//ul[@id='studentTilesPanelBar']/li[3]/div/div[6]/div/span"));
    static Button NewButton = new Button("New", byXPath("//a[@id='addDegreeButton']"));
    static Link Degree = new Link("Click on degree", byXPath("(//div[@id='dialogDegreePopUp']/ng-transclude/div/div[3]/div/div/ng-transclude/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static TextField EntDegree = new TextField("Enter Degree", byXPath("//div[@id='degreeDropDown-list']/span/input"));
    static Link SelDegree = new Link("select on degree", byXPath("//li[text()='Associate']"));
    static TextField DegreeDateAward = new TextField("select on degreeAward", byXPath("//input[@name=\"awardedDate\"]"));
    static Button save = new Button("save", byXPath("//button[@id='saveDegree']"));
    static Link HonerandBadge = new Link("click on HB", byXPath("//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-honors-list/section/div[2]/section[2]/cns-student-honors-enrollment/div/cmc-collapse/div/div/div[3]/cmc-integrated-collapse-button/a/div"));
    static Link HBLink = new Link("Click on HB", byXPath("(//div[@id='dialogEnrolmentHonorsPopUp']/ng-transclude/div/div[3]/div/div/ng-transclude/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static TextField EnterHB = new TextField("Enter Honerand Badge", byXPath("//div[@id='honorsDropDown-list']/span/input"));
    static Link SelectHB = new Link("Selct Honer", byXPath("//ul[@id='honorsDropDown_listbox']/li"));
    static Button NewButton2 = new Button("New", byXPath("//a[@id='addEnrollHonorButton']"));
    static Button save1 = new Button("save1", byXPath("//button[@id='saveEnrollHonor']"));
    static Link TermHonerandBadge = new Link("click on HB", byXPath("//div[@id='maincontent']/div/cns-student/div/section/div/div/div[2]/div/div/div/div/cns-student-honors-list/section/div[2]/section[3]/cns-student-honors-term/div/cmc-collapse/div/div/div[3]/cmc-integrated-collapse-button/a/div"));
    static Button NewButton3 = new Button("New", byXPath("//a[@id='addTermHonorButton']"));
    static Link THBLink = new Link("Click on THB", byXPath("(//div[@id='dialogTermHonorsPopUp']/ng-transclude/div/div[3]/div/div/ng-transclude/div/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static TextField EnterTHB = new TextField("Enter Term Honerand Badge", byXPath("//div[@id='termDropDown-list']/span/input"));
    static Link SelectTHB = new Link("Selct TermHonerBadge", byXPath("(//ul[@id='termDropDown_listbox']/li/div/span)[1]"));
    static Link ClkHonerandBadge = new Link("click on HB", byXPath("(//div[@id='dialogTermHonorsPopUp']/ng-transclude/div/div[3]/div/div/ng-transclude/div[2]/cmc-drop-down-list-classic/div/div/span/span/span)[1]"));
    static TextField EnterHBField = new TextField("Enter Term Honerand Badge Field", byXPath("//div[@id='honorsTermDropDown-list']/span/input"));
    static Link SelectTermHBField = new Link("Selct TermHonerBadge", byXPath("//ul[@id='honorsTermDropDown_listbox']/li"));
    static Button save3 = new Button("save1", byXPath("//button[@id='saveTermHonor']"));

   
    public StudentDegreeCreation CreateDegree(StringHash data) throws Exception {
		
		Checkbox CheckCampus = new Checkbox("Check the Campus", byXPath("//input[@aria-label='"+data.get("Campus")+"']"));
		//waitForPageToLoad();
		searchconfigText.clearAndType("Degrees");
		ClickDegrees.click();
		wait(5);
		waitForPageToLoad();	 
		ClickNew.click();
		waitForPageToLoad();
        Name.waitTillElementFound();
		Name.clearAndType((DegreeName));
//		Code.waitTillElementFound();
		Code.clearAndType(DegreeCode);
		Campuses.waitTillElementClickable();
		Campuses.click();
		wait(2);
		SearchCampusText.clearAndType(data.get("Campus"));
		wait(5);
		CheckCampus.click();
		wait(2);
		//js.executeScript("window.scrollBy(0,350)", "");
		//Select.sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
		Select.waitTillElementClickable();
		Select.click();
		SaveAndClose.waitTillElementClickable();
		SaveAndClose.click();
		wait(10);
		return this;
				
	}
	
public StudentDegreeCreation AddDegreeForStudent(StringHash data) throws Exception {
    	
    //X-path Parameterization
    		Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
    		Link AddDegStdSaveMessage = new Link("AddDegStdSaveMessage", byXPath("//span[. = 'The Degrees records were successfully saved.']"));			
    		Link SelDegree = new Link("select on degree", byXPath("//li[text()='"+data.get("Degree Name")+"']"));
    	
    //Method Implementation
    		waitForPageToLoad();
    		wait(10);
    		FilterDropDwon.click();
    		wait(2);
    		ClearFiltersButton.click();
    		wait(15);
    		StuNumDropDown.click();
    		wait(2);
    		StuNumFilter.click();
    		wait(2);
    		value.clearAndType(data.get("Student Number"));
    		wait(5);
    		FilterButton.click();
    		wait(5);
    		ClickStudentName.click();
    		waitForPageToLoad();
    		wait(5);
    		AcademicRecords.clickUsingJavaScriptExecutor();
    		wait(2);
    		DHB.clickUsingJavaScriptExecutor();
    		wait(20);
    		NewButton.clickUsingJavaScriptExecutor();
    		wait(7);
    		Degree.clickUsingJavaScriptExecutor();
    		wait(3);
    		EntDegree.clearAndType(data.get("Degree Name").toString());
    		wait(3);
    		SelDegree.clickUsingJavaScriptExecutor();
    		wait(3);
    		DegreeDateAward.clearAndType(data.get("Degree Award").toString());
    		wait(3);
    		save.click();
    		wait(3);
    		CustomAsserts.containsString(AddDegStdSaveMessage.getText(), data.get("SuccessMessage").toString());
    		wait(2);
    		return this;
    			
    		}
    		
   public StudentDegreeCreation AddHonorForStudent(StringHash data) throws Exception {

    	//X-path Parameterization
    			Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
    			Link SelectHB = new Link("Selct Honer", byXPath("(//li[text()='"+data.get("Honer and Badge")+"'])[1]"));
    			Link AddHonerStdSaveMessage = new Link("AddHonerStdSaveMessage", byXPath("//span[. = 'The Honors and Badges records were successfully saved.']"));			

    	//Method Implementation
    			waitForPageToLoad();
    			wait(10);
    			FilterDropDwon.click();
    			wait(2);
    			ClearFiltersButton.click();
    			wait(15);
    			StuNumDropDown.click();
    			wait(2);
    			StuNumFilter.click();
    			wait(2);
    			value.clearAndType(data.get("Student Number"));
    			wait(2);
    			FilterButton.click();
    			wait(5);
    			ClickStudentName.click();
    			waitForPageToLoad();
    			wait(5);
    			AcademicRecords.clickUsingJavaScriptExecutor();
    			wait(2);
    			DHB.clickUsingJavaScriptExecutor();
    			wait(20);
    			HonerandBadge.clickUsingJavaScriptExecutor();
    			wait(2);
    			scrollPage(0, 300);
    			wait(1);
    			NewButton2.clickUsingJavaScriptExecutor();
    			wait(5);
    			HBLink.clickUsingJavaScriptExecutor();
    			wait(10);
    			EnterHB.clearAndType(data.get("Honer and Badge").toString());
    			wait(5);
    			SelectHB.clickUsingJavaScriptExecutor();
    			wait(5);
    			save1.clickUsingJavaScriptExecutor();
    			wait(5);
    			CustomAsserts.containsString(AddHonerStdSaveMessage.getText(), data.get("SuccessMessage").toString());
    			wait(2);
    			return this;
    		}
    		
 public StudentDegreeCreation AddTermHonorWithBadge(StringHash data) throws Exception {

    	//X-path Parameterization
    			Link ClickStudentName = new Link("Selecting Student", byXPath("//span[text()='"+data.get("LastName")+", "+data.get("FirstName")+"']"));
    			Link SelectTHB = new Link("Selct TermHonerBadge", byXPath("//span[text()='"+data.get("Term Honer and Badge")+"']"));
    			Link SelectTermHBField = new Link("Selct TermHonerBadge", byXPath("(//li[text()='"+data.get("Enter Honer and Badge")+"'])[2]"));
    			Link AddTermHonorwithBadgeSaveMessage = new Link("AddTermHonorwithBadgeSaveMessage", byXPath("//span[. = 'The Term Honors and Badges records were successfully saved.']"));			

    	//Method Implementation
    			waitForPageToLoad();
    			wait(10);
    			FilterDropDwon.click();
    			wait(2);
    			ClearFiltersButton.click();
    			wait(15);
    			StuNumDropDown.click();
    			wait(2);
    			StuNumFilter.click();
    			wait(2);
    			value.clearAndType(data.get("Student Number"));
    			wait(2);
    			FilterButton.click();
    			wait(5);
    			ClickStudentName.click();
    			waitForPageToLoad();
    			wait(5);
    			AcademicRecords.clickUsingJavaScriptExecutor();
    			wait(2);
    			DHB.clickUsingJavaScriptExecutor();
    			wait(20);
    			TermHonerandBadge.clickUsingJavaScriptExecutor();
    			wait(3);
    			scrollPage(0, 300);
    			wait(3);
    			NewButton3.clickUsingJavaScriptExecutor();
    			wait(5);
    			THBLink.clickUsingJavaScriptExecutor();
    			wait(3);
    			EnterTHB.clearAndType(data.get("Term Honer and Badge").toString());
    			wait(5);
    			SelectTHB.click();
    			wait(5);
    			ClkHonerandBadge.clickUsingJavaScriptExecutor();
    			wait(3);
    			EnterHBField.clearAndType(data.get("Enter Honer and Badge").toString());
    			wait(5);
    			SelectTermHBField.click();
    			wait(3);
    			save3.click();
    			wait(5);
    			CustomAsserts.containsString(AddTermHonorwithBadgeSaveMessage.getText(), data.get("SuccessMessage").toString());
    			wait(2);
    			return this;
    	  
    		}
    	
}






