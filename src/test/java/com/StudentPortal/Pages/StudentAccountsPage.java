package com.StudentPortal.Pages;

import org.openqa.selenium.By.ByXPath;
import static com.framework.elements.Locator.byXPath;

import com.framework.elements.AngDropDown;
import com.framework.elements.Button;
import com.framework.elements.Link;
import com.framework.elements.TextField;

public class StudentAccountsPage {
	
	static Link LedgerCard = new Link("Leadger card", byXPath("//span[text()='Ledger Card']"));
	static Link Filtericon = new Link("Filter icon", byXPath("(//div[2]/a[2])[1]"));
	static Link ClearFilters= new Link("Clear Filters", byXPath("//div//a[. = 'Clear Filters']"));
	static AngDropDown Transactionlist = new AngDropDown("Transaction list", byXPath("//th[7]//span"));
	static Link FilterOptions = new Link("Filter options", byXPath("(//span[text()='Filter'])[2]"));
	static AngDropDown Operator = new AngDropDown("Operator dropdown", byXPath("(//form/div/span[1]/span/span/span)[2]"));
	static Link SelectingOperator = new Link("Selecting operator", byXPath("//div/div/div//li[. = 'Contains']"));
	static TextField Value = new TextField("Enter filter value", byXPath("(//input[@title='Value'])[2]"));
	//static TextField Value = new TextField("Enter filter value", byXPath("//form/div/input[1]"));
	static Button Filterbutton = new Button("Filter icon", byXPath("(//button[text()='Filter'])[2]"));
	static Link Tablevalue= new Link("Table value", byXPath("(//tr[1]/td[1])[1]"));
	static Link More= new Link("More", byXPath("//a[text()='More']"));
	static Link Void= new Link("Void", byXPath("//a[text()='Void']"));
	static TextField VoidNote = new TextField("Void note", byXPath("(//div/textarea[@aria-label='Note'])[4]"));
	static Button Voidbutton = new Button("Void button", byXPath("//button[@id='okVoidPayment']"));
	static Button Delete = new Button("Delete icon", byXPath("//a[text()='Delete']"));
	static TextField DeleteNote = new TextField("Delete note", byXPath("(//div/textarea[@aria-label='Note'])[1]"));
	static Button Deletebutton = new Button("Delete button", byXPath("//button[@id='okDelete']"));
	static Link SelectingTransaction = new Link("Selecting Student", byXPath("(//a/span[text()='Tuition '])[1]"));
	static TextField TransactionAmount = new TextField("Transaction Amount", byXPath("//input[@id='transactionAmount']"));
	static TextField TransactionNote = new TextField("Transaction note", byXPath("(//div/textarea[@aria-label='Note'])[1]"));
	static Button SaveAndClose = new Button("Save & Close", byXPath("(//button[@aria-label='Save & Close'])[2]"));
	
}
