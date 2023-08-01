package com.framework.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import com.framework.driver.WebUIDriver;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class Dropbox extends BaseElement {

	protected Select select = null;
	protected List<WebElement> options = null;

	/* intializes the parent class(Base Element) variables */
	public Dropbox(final String text, final By by) {
		super(text, by);
	}

	/*
	 * This method is used to identify the element Verify multiple options selected
	 * in list or not De-selects all selected options in a multi-select list
	 * element.
	 */

	public void deselectAll() {
		TestReportsLog.log(LogStatus.INFO, "deselect all options on  " + toHTML());
		// TestLogging.logWebStep("deselect all options on " + toHTML(), false);
		findElement();
		if (!isMultiple()) {
			TestReportsLog.log(LogStatus.ERROR, "You may only deselect all options of a multi-select  " + toHTML());
			throw new UnsupportedOperationException("You may only deselect all options of a multi-select");
		}

		for (WebElement option : options) {
			if (option.isSelected()) {
				option.click();
			}
		}
	}

	/*
	 * This method is used to identify the element Take number of options available
	 * in list using index Verify each option selected or not, de select it if
	 * option is selected
	 * 
	 * @param-index
	 */
	public void deselectByIndex(final int index) {
		TestReportsLog.log(LogStatus.INFO, "deselect index\"" + index + "\" on " + toHTML());
		// TestLogging.logWebStep("deselect index\"" + index + "\" on " + toHTML(),
		// false);
		findElement();

		WebElement option = options.get(index);
		if (option.isSelected()) {
			option.click();
		}
	}

	/*
	 * This method is used to identify the element Compare text of each option with
	 * given text and deselect the selected option if text matches
	 * 
	 * @param-text
	 */

	public void deselectByText(final String text) {
		TestReportsLog.log(LogStatus.INFO, "deselect text\"" + text + "\" on " + toHTML());
		// TestLogging.logWebStep("deselect text\"" + text + "\" on " + toHTML(),
		// false);
		findElement();
		for (WebElement option : options) {
			if (option.getAttribute("text").equals(text)) {
				if (option.isSelected()) {
					option.click();
				}

				break;
			}
		}
	}

	/*
	 * This method is used to identify the element Compare value of each option with
	 * given value and deselect the selected option if value matches
	 * 
	 * @param-value
	 */

	public void deselectByValue(final String value) {
		TestReportsLog.log(LogStatus.INFO, "deselect value\"" + value + "\" on " + toHTML());
		// TestLogging.logWebStep("deselect value\"" + value + "\" on " + toHTML(),
		// false);
		findElement();
		for (WebElement option : options) {
			if (option.getAttribute("value").equals(value)) {
				if (option.isSelected()) {
					option.click();
				}

				break;
			}
		}

	}

	/*
	 * This method is used to find the element by passing 'by' locator To get count
	 * of no.of items in list
	 */

	protected void findElement() {
		driver = WebUIDriver.getWebDriver();
		element = driver.findElement(this.getBy());
		try {
			select = getNewSelectElement(element);
			options = select.getOptions();
		} catch (UnexpectedTagNameException e) {
			if (element.getTagName().equalsIgnoreCase("ul")) {
				options = element.findElements(By.tagName("li"));
			}
		}
	}

	/*
	 * This method returns the new selected element(created to facilitate unit
	 * testing).
	 * 
	 * @return-Select(webelemnt)
	 */
	protected Select getNewSelectElement(final WebElement element) {
		return new Select(element);
	}

	/*
	 * This method is used to find the element by passing 'by' locator To get count
	 * of no.of items in list
	 * 
	 * @return-options in list
	 */
	public List<WebElement> getOptions() {
		findElement();
		return options;
	}

	/*
	 * This method is used to identify the element and get no.of options in it
	 * Verify each option selected or not, if selected get text of each option
	 * 
	 * @return-text attribute of each option will be returned
	 */

	public String getSelectedText() {
		findElement();
		for (WebElement option : options) {
			if (option.isSelected()) {
				return option.getAttribute("text");
			}
		}

		return null;
	}

	/*
	 * This method is used to identify the element and get no.of options in it in a
	 * arraylist Verify each option selected or not, if selected get text of each
	 * option
	 * 
	 * @return-returns selected options in dropbox as list
	 */

	public String[] getSelectedTexts() {
		findElement();

		List<String> textList = new ArrayList<String>();
		for (WebElement option : options) {
			if (option.isSelected()) {
				textList.add(option.getAttribute("text"));
			}
		}

		String[] texts = new String[textList.size()];
		return textList.toArray(texts);
	}

	/*
	 * This method is used to identify the element and get no.of options in it
	 * Verify each option selected or not, if selected get value of each option
	 * 
	 * @return-value attribute of each option
	 */

	public String getSelectedValue() {
		findElement();
		for (WebElement option : options) {
			if (option.isSelected()) {
				return option.getAttribute("value");
			}
		}

		return null;
	}

	/*
	 * This method is used to identify the element and get no.of options in it in a
	 * arraylist Verify each option selected or not, if selected get value of each
	 * option
	 * 
	 * @return-returns selected options in dropbox as list
	 */
	public String[] getSelectedValues() {
		findElement();

		List<String> valueList = new ArrayList<String>();
		for (WebElement option : options) {
			if (option.isSelected()) {
				valueList.add(option.getAttribute("value"));
			}
		}

		String[] values = new String[valueList.size()];
		return valueList.toArray(values);
	}

	/*
	 * 
	 * 
	 */

	public void init() {
		super.init();
		try {
			select = getNewSelectElement(element);
			options = select.getOptions();
		} catch (UnexpectedTagNameException e) {
			if (element.getTagName().equalsIgnoreCase("ul")) {
				options = element.findElements(By.tagName("li"));
			}
		}
	}

	/*
	 * This method is used to find the element and verify multiple options selected
	 * in Dropbox or not
	 * 
	 * @return-no.of options selected in list
	 */
	public boolean isMultiple() {
		findElement();

		String value = element.getAttribute("multiple");
		return value != null && !"false".equals(value);
	}

	/*
	 * This method is used to find element and get option in it using index Select
	 * option from the list based on index
	 */

	public void selectByIndex(final int index) {
		TestReportsLog.log(LogStatus.INFO, "make selection using index\"" + index + "\" on " + toHTML());
		// TestLogging.logWebStep("make selection using index\"" + index + "\" on " +
		// toHTML(), false);
		findElement();

		WebElement option = options.get(index);
		setSelected(option);
	}

	/*
	 * This method is used to find element and get options in it using index. Select
	 * multiple options from the list based on index.
	 */

	public void selectByIndex(final int[] indexs) {
		TestReportsLog.log(LogStatus.INFO, "make selection using indexs\"" + indexs.toString() + "\" on " + toHTML());
		// TestLogging.logWebStep("make selection using indexs\"" + indexs.toString() +
		// "\" on " + toHTML(), false);
		findElement();
		for (int i = 0; i < indexs.length; i++) {
			WebElement option = options.get(indexs[i]);
			setSelected(option);
		}
	}

	/**
	 * Select standard select by attribute text, and select fake select with ul and
	 * li by attribute title.
	 *
	 * @param text
	 */

	
    
	public void selectByTextvalue(final String text) {
		boolean valueSelected = false;
		findElement();
		if (options == null) {
			driver.findElement(By.xpath("//li[text()='" + text + "']")).click();
			return;
		}

		for (WebElement option : options) {
			String selectedText = null;
			if (option.getTagName().equalsIgnoreCase("li")) {
				selectedText = option.getAttribute("title");
			} else {
				selectedText = option.getAttribute("text");
			}

			if (selectedText.equals(text)) {
				setSelected(option);
				valueSelected = true;
				TestReportsLog.log(LogStatus.INFO, "Selected dropdown value as \"" + text + "\" on " + toHTML());
				break;
			}
		}

		if (!valueSelected) {
			TestReportsLog.log(LogStatus.FAIL, "Unable to find value in the dropdown \"" + text + "\" on " + toHTML());
		}

	}

	public void selectByText(final String text) {
		boolean valueSelected = false;
        findElement();
        if (options == null) {
           
             String xPath1 = "//*[contains(text(),";
             String xPath2 = ")]";
             String xPathFinal = xPath1+"'"+text+"'"+xPath2;
            
            driver.findElement(By.xpath(xPathFinal)).click();
           
            return;
		}

		for (WebElement option : options) {
			String selectedText = null;
			if (option.getTagName().equalsIgnoreCase("li")) {
				selectedText = option.getAttribute("title");
			} else {
				selectedText = option.getAttribute("text");
			}

			if (selectedText.equals(text)) {
				setSelected(option);
				valueSelected = true;
				TestReportsLog.log(LogStatus.INFO, "Selected dropdown value as \"" + text + "\" on " + toHTML());
				break;
			}
		}

		if (!valueSelected) {
			TestReportsLog.log(LogStatus.FAIL, "Unable to find value in the dropdown \"" + text + "\" on " + toHTML());
		}

	}

	/*
	 * This method is used to find the element and get options in it Compare text
	 * attribute of each option in list with list of items in texts array select
	 * multiple options in list if both text matches in same manner
	 * 
	 * @param-texts
	 */
	public void selectByText1(final String[] texts) {
		TestReportsLog.log(LogStatus.INFO, "make selection using texts\"" + texts + "\" on " + toHTML());
		// TestLogging.logWebStep("make selection using texts\"" + texts + "\" on " +
		// toHTML(), false);
		findElement();
		for (int i = 0; i < texts.length; i++) {
			for (WebElement option : options) {
				if (option.getAttribute("text").equals(texts[i])) {
					setSelected(option);
					break;
				}
			}
		}
	}

	/*
	 * This method is used to find the element and get options in it Compare value
	 * attribute of each option with given value If value matches select the option
	 * 
	 * @param-value
	 */

	public void selectByValue(final String value) {
		TestReportsLog.log(LogStatus.INFO, "make selection using value\"" + value + "\" on " + toHTML());
		// TestLogging.logWebStep("make selection using value\"" + value + "\" on " +
		// toHTML(), false);
		findElement();
		for (WebElement option : options) {
			if (option.getAttribute("value").equals(value)) {
				setSelected(option);
				break;
			}
		}
	}

	/*
	 * This method is used to find the element and get options in it Compare value
	 * attribute of each option with given values array select multiple options in
	 * list if both values matches in same manner
	 * 
	 * @param-values
	 */

	public void selectByValue(final String[] values) {
		TestReportsLog.log(LogStatus.INFO, "make selection using values\"" + values + "\" on ");
		// TestLogging.logWebStep("make selection using values\"" + values + "\" on " +
		// toHTML(), false);
		findElement();
		for (int i = 0; i < values.length; i++) {
			for (WebElement option : options) {
				if (option.getAttribute("value").equals(values[i])) {
					setSelected(option);
					break;
				}
			}
		}
	}

	/*
	 * This method is used to select the element if it's not selected
	 * 
	 * @param=option
	 */
	private void setSelected(final WebElement option) {
		if (!option.isSelected()) {
			option.click();
		}
	}

	public void findOptions(List<String> dropdownOption) {

		findElement();

		List<WebElement> options = element.findElements(By.tagName("option"));

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < options.size(); i++) {

			list.add(options.get(i).getText());

		}

		for (int j = 0; j < dropdownOption.size(); j++) {

			if (list.contains(dropdownOption.get(j))) {

				TestReportsLog.log(LogStatus.INFO, dropdownOption.get(j) + " : This Option is Present in the Dropdown");
			}

			else {

				TestReportsLog.log(LogStatus.FAIL, dropdownOption.get(j) + " : This Options Does not Present");
			}
		}

	}

}
