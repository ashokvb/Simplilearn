package com.framework.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.driver.DriverConfig;
import com.framework.driver.WebUIDriver;
//import com.framework.util.ReadProperties;
import com.framework.util.ReadProperties;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage extends DriverConfig  {

	public WebDriver driver;
	public ExtentTest test;
	public Properties config;
	private DriverConfig webDriverconfig = new DriverConfig();

	public BasePage() {
		this.driver = WebUIDriver.getWebDriver();
		this.test = TestReportsLog.getReportLogSession();
	}

	public boolean verifyTitle(String expTitle) {
		test.log(LogStatus.INFO, "Verifying the title " + expTitle);
		// webdriver code
		if (driver.getTitle().equals(expTitle))
			return true;

		return false;
	}

	public String verifyText(String locator, String expText) {
		return "";
	}

	public boolean isElementPresent(String locator) {
		test.log(LogStatus.INFO, "Trying to find element -> " + locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {
			test.log(LogStatus.INFO, "Element not found");
			return false;
		} else {
			test.log(LogStatus.INFO, "Element found");
			return true;
		}

	}

	public WebElement isElementLoaded(WebElement elementToBeLoaded) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;

	}

	public void waitForPageToLoad() {
		Integer timeToWaitInSec = Integer
				.parseInt(ReadProperties.getConfigProp().getProperty("timeToWaitInSec").toString());

		wait(timeToWaitInSec.intValue());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript("return document.readyState");

		while (!state.equals("complete")) {
			wait(timeToWaitInSec.intValue() + 1);
			state = (String) js.executeScript("return document.readyState");
		}
	}

	public void wait(int timeToWaitInSec) {
		try {
			Thread.sleep(timeToWaitInSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			TestReportsLog.log(LogStatus.ERROR, "BasePage wait(timeToWaitInSec) :-" + e.getMessage());
			// e.printStackTrace();
		}
	}

	public void scrollPage(int x, int y) {
		//waitForPageToLoad();
		driver = WebUIDriver.getWebDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}

	public static void zoom() {
		try {
			Robot robot = new Robot();
			System.out.println("About to zoom in");

			for (int i = 0; i < 3; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
		} catch (Exception e) {

			System.out.println("not zooming");
		}
	}

	public void goback() {

		waitForPageToLoad();
		driver = WebUIDriver.getWebDriver();
		driver.navigate().back();

		TestReportsLog.log(LogStatus.INFO, "Clicked on Back Navigation");

	}

	public boolean verifyElementNot(String locator) {
		test.log(LogStatus.INFO, "Trying to find element -> " + locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {
			test.log(LogStatus.INFO, "Element not found");
			return false;
		} else {
			test.log(LogStatus.INFO, "Element found");
			return true;
		}

	}

	public String convertDateFormat(String oldformat) throws ParseException {
		String newDateString;

		String browser = WebUIDriver.getWebUIDriver().getBrowser();
		if (browser.contains("firefox")) {
			final String OLD_FORMAT = "MM/dd/yyyy";
			final String NEW_FORMAT = "yyyy-MM-dd";

			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(oldformat);
			sdf.applyPattern(NEW_FORMAT);
			newDateString = sdf.format(d);
		} else {

			newDateString = oldformat;
		}

		return newDateString;
	}

	public String splitString(String StringValue) {

		String array[] = StringValue.split("\\n");

		return array[0];
	}

	public void switchWindow(int index) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[index]);
		TestReportsLog.log(LogStatus.INFO, "Switching window");
	}

	public void switchWindow(String pageTitle) {
		waitForPageToLoad();
		String currentWindow = driver.getWindowHandle(); // will keep current window to switch back

		for (String winHandle : driver.getWindowHandles()) {
			String title = driver.switchTo().window(winHandle).getTitle();
			if (title.equals(pageTitle)) {
				TestReportsLog.log(LogStatus.INFO, "Switching window to: " + title);
				break;
			} else {
				driver.switchTo().window(currentWindow);
			}
		}
	}

	public void switchWindowWithOutWait(String pageTitle) {
		String currentWindow = driver.getWindowHandle(); // will keep current window to switch back

		for (String winHandle : driver.getWindowHandles()) {
			String title = driver.switchTo().window(winHandle).getTitle();
			if (title.equals(pageTitle)) {
				TestReportsLog.log(LogStatus.INFO, "Switching window to: " + title);
				break;
			} else {
				driver.switchTo().window(currentWindow);
			}
		}
	}

	// This function is used to retrieve latest download file
	public File getLatestFile(String filePath, String ext) {
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		File[] files = dir.listFiles(fileFilter);
		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}
		return theNewestFile;
	}

	/*
	 * This function is used to verify whether the latest download file is existed
	 * in download directory or not
	 */
	public boolean isFileDownloaded(String fileName) {
		config = ReadProperties.getConfigProp();

		String downloadDir = System.getProperty("user.dir") + File.separator + config.getProperty("browserDownloadDir");
		File file = new File(downloadDir);
		File[] dirContents = file.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				TestReportsLog.log(LogStatus.PASS,
						"Recenctly downloaded file is existed" + dirContents[i] + " with file name as " + fileName);
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}

		}
		return false;
	}

	/*
	 * This function is used to retrieve latest download file from local system and
	 * move to target path
	 */
	public boolean moveFileToDirectory(String filePath, String ext, String targetPath) {
		File tDir = new File(targetPath);
		File sourceFile = getLatestFile(filePath, ext);
		if (tDir.exists()) {
			String newFilePath = targetPath + File.separator + sourceFile.getName();
			File movedFile = new File(newFilePath);
			if (movedFile.exists())
				movedFile.delete();
			return sourceFile.renameTo(new File(newFilePath));
		} else {
			return false;
		}
	}

	// This function is used to move the download file to project folder
	public String moveLatestFileToProjectDirectory(String filepath, String ext) {
		String path = System.getProperty("user.home") + filepath;
		String targetfolderPath = System.getProperty("user.dir") + "//ViewAuditPacketData";
		moveFileToDirectory(path, ext, targetfolderPath);
		String targetFilePath = getLatestFile(targetfolderPath, ext).getAbsolutePath();
		return targetFilePath;
	}

	public void refresh() {
		driver.navigate().refresh();
		TestReportsLog.log(LogStatus.INFO, "Refreshing the Web Page");

	}
	
	
	public void QuitBrowser() {
		driver.quit();
		TestReportsLog.log(LogStatus.INFO, "Closing all the browser windows");

	}
	
	
	public void waitForPageToComplete() {
		Integer timeToWaitInSec = Integer
				.parseInt(ReadProperties.getConfigProp().getProperty("timeToWaitInSec").toString());
		wait(1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript("return document.readyState");
		System.out.println("State of page :"+ state);
		while (!state.equals("complete")) {
			wait(timeToWaitInSec.intValue());
			state = (String) js.executeScript("return document.readyState");
		}
		
		
	
	}
}
