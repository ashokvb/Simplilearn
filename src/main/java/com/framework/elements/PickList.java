package com.framework.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class PickList extends Dropbox {

	protected Select select = null;
	protected List<WebElement> options = null;

	/* intializes the parent class(Base Element) variables */
	public PickList(final String text, final By by) {
		super(text, by);
	}

	public void selectByValue(final String value) {
		try {
			findElement();
			element.click();
			Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(value);
			Thread.sleep(1000);
			// driver.switchTo().activeElement().sendKeys(Keys.DOWN);
			driver.switchTo().activeElement().click();
			Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);

			TestReportsLog.log(LogStatus.INFO, "make selection using text\"" + value + "\" on " + toHTML());
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted");
		}
	}

	public void selectByValue(final String value, Integer waitTimeInSeconds) {

		try {
			findElement();
			element.click();
			Thread.sleep(waitTimeInSeconds * 1000);
			driver.switchTo().activeElement().sendKeys(value);
			Thread.sleep(waitTimeInSeconds * 1000);
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);
			// driver.switchTo().activeElement().click();
			Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);

			TestReportsLog.log(LogStatus.INFO, "make selection using text\"" + value + "\" on " + toHTML());
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted");
		}
	}

	public void selectByThirdValue(final String value, Integer waitTimeInSeconds) {

		try {
			findElement();
			element.click();
			Thread.sleep(waitTimeInSeconds * 1000);
			driver.switchTo().activeElement().sendKeys(value);
			Thread.sleep(waitTimeInSeconds * 1000);
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);
			// driver.switchTo().activeElement().click();
			Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);

			TestReportsLog.log(LogStatus.INFO, "make selection using text\"" + value + "\" on " + toHTML());
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted");
		}
	}

	public void selectVisibleText(final String value) {
		try {
			findElement();
			element.click();
			element.sendKeys(value);
			Thread.sleep(1000);
			// driver.switchTo().activeElement().sendKeys(value);
			// Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);
			// driver.switchTo().activeElement().click();
			Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.TAB);

			TestReportsLog.log(LogStatus.INFO, "make selection using text\"" + value + "\" on " + toHTML());
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted");
		}
	}

	public void selectThirdVisibleText(final String value) {
		try {
			findElement();
			element.click();
			element.sendKeys(value);
			Thread.sleep(1000);
			// driver.switchTo().activeElement().sendKeys(value);
			// Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);

			// driver.switchTo().activeElement().click();
			Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.TAB);

			TestReportsLog.log(LogStatus.INFO, "make selection using text\"" + value + "\" on " + toHTML());
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted");
		}
	}

	public void typeandSelectValue(final String value) {
		try {
			findElement();
			element.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//td[2]/div/div[2]/div/div/input")).sendKeys(value);
			// driver.switchTo().activeElement().sendKeys(value);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tbody/following::tbody/tr[1]/td[2]")).click();

			TestReportsLog.log(LogStatus.INFO, "make selection using text\"" + value + "\" on " + toHTML());
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted");
		}
	}

	public void verifyPickListOptions(List<String> picklistOptions) {

		findElement();

		List<WebElement> options = element.findElements(By.className("dx-item dx-list-item"));

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < options.size(); i++) {

			list.add(options.get(i).getText());

		}

		for (int j = 0; j < picklistOptions.size(); j++) {

			if (list.contains(picklistOptions.get(j))) {

				TestReportsLog.log(LogStatus.INFO,
						picklistOptions.get(j) + " : This Option is Present in the PickList");
			}

			else {

				TestReportsLog.log(LogStatus.FAIL, picklistOptions.get(j) + " : This Options Does not Present");
			}
		}

	}
}
