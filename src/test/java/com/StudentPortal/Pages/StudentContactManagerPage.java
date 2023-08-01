package com.StudentPortal.Pages;

import static com.framework.elements.Locator.byXPath;

import org.openqa.selenium.interactions.SendKeysAction;

import com.framework.base.BasePage;
import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Link;
import com.framework.elements.TextField;
import com.framework.util.StringHash;


import static com.framework.elements.Locator.byCSSSelector;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byName;
public class StudentContactManagerPage extends BasePage{
	
	static Link ContactManager = new Link("Click Contact Manager", byXPath("(//li[@role=\"menuitem\"])[1]"));
	static Link Tasks = new Link("Clicl Tasks", byXPath("//li[1]/div/div[1]/div"));
	static Link Documents = new Link("Click Documents", byXPath("//li[1]/div/div[2]/div"));
	static AngDropDown Taskdropdown = new AngDropDown("Click Awards Drop Down", byXPath("//div[2]/cns-grid/div[1]/cns-grid-toolbar/cmc-common-toolbar/div/div[2]/a[2]"));
	static Button TaskClearFilter = new Button("Click Clear Filter", byXPath("//div//a[. = 'Clear Filters']"));
	static AngDropDown AssignedToDropDown = new AngDropDown("Click Drop Down", byXPath("(//a[@title=\"Column Settings\"])[6]"));
	//static Link SubjectDropDown = new Link("Click Drop Down", byXPath("(//a[@title=\"Column Settings\"])[1]"));
	static Button AssignedToFilter = new Button("Click Filter", byXPath("//span[text()=\"Filter\"]"));
	static TextField AssignedToValue = new TextField("Enter value", byXPath("//input[@title=\"Value\"]"));
	static Button AssignedToFilterButton = new Button("Click Filter Button", byXPath("//button[.=\"Filter\"]"));
	//static Button HighlightTask = new Button("Highlight the task", byXPath("//td[.=\"07/15/2022 !\"]"));
	static Button CloseTask = new Button("Click Close Task", byId("closeButton"));
	static TextField Comments = new TextField("Enter Comments", byName("callScriptComments"));
	static Button TaskSaveClose = new Button("Click Save and Close", byId("studentTaskCallScriptAndFollowUpDialogButton"));
	static Button ConfirmCloseTask = new Button("Click Close Task", byId("studentTaskCloseDialogButton"));	
	//FA Document Web Elements
	static TextField DocEnterModule = new TextField("Enter Module", byName("studentDocumentModule_input"));
	static TextField DocAwardYear = new TextField("Click New Document", byName("studentDocumentAwardYear_input"));
	static Link NewDocument = new Link("Click New Document", byXPath("(//a[.=\"New Document\"])[1]"));
	static TextField DocumentModule = new TextField("Enter Document Module", byName("studentDocModule_input"));
	//static Button SelectMainModule = new Button("Select Main Module", byXPath("//span[.=\"Financial Aid\"]"));
	static TextField DocumentName = new TextField("Enter Document Name", byName("studentDocName_input"));
	static TextField DocumentAwardYear = new TextField("Enter Award Year", byName("studentDocAwardYear_input"));
	static TextField DocStatus = new TextField("Enter Document List Status", byName("studentDocStatus_input"));
	static TextField DocDateRequested = new TextField("Enter Date requested", byId("studentDocDateRequested"));
	static Button DocSaveClose = new Button("Click Save and Close", byXPath("//a[.=\"Save & Close\"]"));	
	//FA Document List Web Elements
	static TextField DLEnterModule = new TextField("Enter Module", byName("studentDocumentModule_input"));
	static TextField DLAwardYear = new TextField("Click New Document", byName("studentDocumentAwardYear_input"));
	static Link NewDocumentList = new Link("Click New Document List", byXPath("(//a[.=\"New Document List\"])[1]"));
	static TextField DLDocumentModule = new TextField("Enter Document Module", byName("studentDocModule_input"));
	static TextField DocumentListName = new TextField("Enter Document List Name", byName("studentDocName_input"));
	static TextField DLStatus = new TextField("Enter Document List Status", byName("studentDocStatus_input"));
	static TextField DLDateRequested = new TextField("Enter Date requested", byId("studentDocDateRequested"));
	static Button DLSaveClose = new Button("Click Save and Close", byId("studentDocumentListSaveAnCloseButton"));
	
	
	public StudentContactManagerPage CloseTask(StringHash data) throws Exception{
		
		Button HighlightTask = new Button("Highlight the task", byXPath("//td[.='"+data.get("TaskDueDate")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Task records were successfully closed.']"));
		
		waitForPageToLoad();
		ContactManager.waitTillElementClickable();
		ContactManager.click();
		Tasks.waitTillElementClickable();
		Tasks.click();
		waitForPageToLoad();
		wait(10);
		/*Taskdropdown.click();
		wait(4);
		TaskClearFilter.click();
		wait(5);*/
		AssignedToDropDown.click();
		wait(2);
		AssignedToFilter.click();
		wait(2);
		AssignedToValue.clearAndType(data.get("AssignedTo"));
		wait(2);
		AssignedToFilterButton.click();
		waitForPageToLoad();
		wait(10);
	    /*SubjectDropDown.click();
		wait(2);
		AssignedToFilter.click();
		wait(2);
		AssignedToValue.clearAndType(data.get("TaskSubject"));
		wait(2);
		AssignedToFilterButton.click();
	    */
		HighlightTask.click();
		wait(5);
		CloseTask.clickUsingJavaScriptExecutor();
		wait(5);
		Comments.sendKeys("Closing the task");
		wait(2);
		TaskSaveClose.click();
		waitForPageToLoad();
		wait(5);
		ConfirmCloseTask.click();
		wait(10);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;
	}
	
	public StudentContactManagerPage AddFADocumentPage(StringHash data) throws Exception{

		Button SelectDocumentName = new Button("Select Document Name", byXPath("//span[.='"+data.get("DocumentName")+"']"));
		//	Button SelectMainModule = new Button("Select Main Module", byXPath("//span[.='"+data.get("Module")+"']"));
		//	Button SelectMainAwardYear = new Button("Select Main Award Year", byXPath("//li[.='"+data.get("AwardYear")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Document records were successfully saved.']"));
		Link SelectDocModule = new Link("Select Document Module", byXPath("(//span[.='"+data.get("DocumentModule")+"'][2]"));
		
		waitForPageToLoad();
		ContactManager.click();
		wait(2);
		Documents.click();
		wait(10);
		/*	DocEnterModule.clearAndType(data.get("Module"));
		wait(2);
		SelectMainModule.click();
		wait();
		DocAwardYear.clearAndType(data.get("AwardYear"));
		wait(2);
		SelectMainAwardYear.click();
		wait(2);
		*/
		NewDocument.click();
		wait(10);
		DocumentModule.clearAndType(data.get("DocumentModule"));
		wait(4);
		//SelectDocModule.click();
		//wait(4);
		DocumentName.clearAndType(data.get("DocumentName"));
		wait(4);
		SelectDocumentName.click();
		wait(2);
		DocumentAwardYear.sendKeys(data.get("DocumentAwardYear"));
		wait(2);
		DocStatus.clearAndType(data.get("DocumentStatus"));
		wait(2);
		DocDateRequested.clearAndType(data.get("DocumentDateRequested"));
		wait(4);
		DocSaveClose.click();
		wait(5);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;	
	}
	
	public StudentContactManagerPage AddFADocumentListPage(StringHash data) throws Exception{



		Button SelectDocumentListName = new Button("Select Document List Name", byXPath("//span[.='"+data.get("DocumentListName")+"']"));
		Button SelectMainModule = new Button("Select Main Module", byXPath("//span[.='"+data.get("Module")+"']"));
		Button SelectMainAwardYear = new Button("Select Main Award Year", byXPath("//li[.='"+data.get("AwardYear")+"']"));
		Link ValidationMessage = new Link("Validation Message", byXPath("//span[. = 'The Document records were successfully saved.']"));

		waitForPageToLoad();
		wait(5);
		ContactManager.click();
		wait(2);
		Documents.click();
		wait(10);
		/*    DLEnterModule.clearAndType(data.get("Module"));
	        wait(2);
	        DLAwardYear.clearAndType(data.get("AwardYear"));
	        wait(2);
		 */
		NewDocumentList.click();
		wait(5);
		scrollPage(0, 500);
		wait(5);
		DLDocumentModule.clearAndType(data.get("DocumentListModule"));
		wait(2);
		DocumentListName.click();
		wait(2);
		DocumentListName.clearAndType(data.get("DocumentListName"));
		wait(5);
		SelectDocumentListName.click();
		wait(2);
		DLStatus.clearAndType(data.get("DocumentListStatus"));
		wait(2);
		DLDateRequested.clearAndType(data.get("DocumentListDateRequested"));
		wait(4);
		DLSaveClose.click();
		wait(10);
		CustomAsserts.containsString(ValidationMessage.getText(), data.get("SuccessMessage").toString());
		wait(10);
		return this;    
	    }    	
}
