
package com.framework.elements;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.constants.BrowserType;
import com.framework.driver.WebUIDriver;
import com.framework.util.TestLogging;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Provides methods to interact with a web page. All HTML element
 * (ButtonElement, LinkElement, TextFieldElement, etc.) extends from this class.
 */
public class BaseElement {

	private static final int EXPLICIT_WAIT_TIME_OUT = WebUIDriver.getWebUIDriver().getExplicitWait();
	protected static final Logger logger = TestLogging.getLogger(BaseElement.class);

	/*
	 * This method is used to define fixed set of constants like
	 * ID,Name,ClassName,Linktext..etc.
	 * 
	 */

	private static enum LocatorType {
		ID, NAME, CLASS_NAME, LINK_TEXT, PARTIAL_LINK_TEXT, CSS_SELECTOR, TAG_NAME, XPATH,
	}

	protected WebDriver driver = WebUIDriver.getWebDriver();
	protected WebUIDriver webUXDriver = WebUIDriver.getWebUIDriver();
	protected WebElement element = null;
	private String label = null;
	private List<String> texts;
	private String locator = null;
	private By by = null;

	/*
	 * This constructor is used to initialize class level variables as label and
	 * by
	 * 
	 * @param label-->To identify name of element
	 * 
	 * @param by-->path of the element(which contains Locator type,value)
	 * Example: {BaseElement("Username",By.name("uname") }
	 */
	public BaseElement(final String label, final By by) {
		this.label = label;
		this.by = by;
	}

	/*
	 * This constructor is used to initialize class level variables as label and
	 * by
	 * 
	 * @param label-->To identify name of element
	 * 
	 * @parm LocatorType-->To get Locator Type like
	 * id,name,xpath,linktext,className..etc
	 * 
	 * @param locator-->value of the LocatorType Example:
	 * {BaseElement("Username","uname",By.name("uname") }
	 */
	public BaseElement(final String label, final String locator, final LocatorType locatorType) {
		this.label = label;
		this.locator = locator;
		this.by = getLocatorBy(locator, locatorType);
	}

	/*
	 * This method is used to Captures snapshot of the current browser window.
	 */
	/*
	 * public void captureSnapshot() {
	 * captureSnapshot(ContextHelper.getCallerMethod() + " on "); }
	 */

	/*
	 * This method is used to captures the snapshot of the current Browser
	 * window It prefix the captured snapshot file name with given String
	 * 
	 * @param- messagePrefix
	 * 
	 */
	/*
	 * protected void captureSnapshot(final String messagePrefix) {
	 * ScreenshotUtil.captureSnapshot(messagePrefix); }
	 */

	/* This method is to identify the element and click on it */
	public void click() {
		// ** log before click of the element
		try {
			findElement();
			element.click();
		} catch (Exception e) {
			TestReportsLog.log(LogStatus.ERROR, "BaseElement ::- click() " + e.getMessage());
		}
		// ** log the element not found in the log
	}

	/*
	 * This method is used to click on required element with specified x and y
	 * cordinates.
	 * 
	 * @param-String-->("x,y")
	 */
	public void clickAt() {
		clickAt("1,1");

	}

	/*
	 * This method is used to click on required element with specified x and y
	 * cordinates.
	 * 
	 * @param-String("x,y") Convert String("x,y") cordinates to int form as
	 * xOffset, yOffset Using actions class we focus and click on element with
	 * specified x and y cordinates And verify any Alert present,if alert
	 * present switch driver to alert
	 * 
	 */
	public void clickAt(final String value) {
		TestLogging.logWebStep("click on " + toHTML(), false);
		findElement();

		final String[] parts = value.split(",");
		final int xOffset = Integer.parseInt(parts[0]);
		final int yOffset = Integer.parseInt(parts[1]);

		try {
			new Actions(driver).moveToElement(element, xOffset, yOffset).click().perform();
		} catch (final InvalidElementStateException e) {

			e.printStackTrace();
			element.click();
		}

		try {
			final BrowserType type = WebUIDriver.getWebUIDriver().getConfig().getBrowser();

			if (((type == BrowserType.Chrome) || (type == BrowserType.InternetExplore))
					&& this.getDriver().switchTo().alert().getText().contains("leave")) {
				this.getDriver().switchTo().alert().accept();
			}
		} catch (final NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// This method is used to switch to alert based on requirement.

	// Text Should be either Accept,Dismiss,get text,SendKeys

	public void alertActions(String value) {
		String sendKeysValue = null;
		Alert alert = driver.switchTo().alert();
		if (value.equalsIgnoreCase("Accept")) {
			alert.accept();
		} else if (value.equalsIgnoreCase("Dismiss")) {
			alert.dismiss();
		} else if (value.equalsIgnoreCase("GetText")) {
			alert.getText();
		} else {
			alert.sendKeys(sendKeysValue);
		}
	}

	/*
	 * This method is used to mouseover on element and click it Mouse event
	 * created using Document.createEvent() Initializes the value(mouseover) of
	 * a mouse event using MouseEvent.initMouseEvent() method The dispatchEvent
	 * method throws UNSPECIFIED_EVENT_TYPE_ERR if the event's type was not
	 * specified by initializing the event before the method was called, or if
	 * the event's type is null or an empty string
	 */
	/*
	 * public void simulateClick() { findElement();
	 * 
	 * final String mouseOverScript =
	 * "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}"
	 * ; final JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript(mouseOverScript, element); WaitHelper.waitForSeconds(2);
	 * 
	 * final String clickScript =
	 * "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('click', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onclick');}"
	 * ; js.executeScript(clickScript, element); WaitHelper.waitForSeconds(2); }
	 */

	public void simulateMoveToElement(final int x, final int y) {
		findElement();
		((JavascriptExecutor) driver).executeScript(
				"function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|errorLogger|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; "
						+ "simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]);",
				element, x, y);

	}

	/*
	 * Firstly from this method driver is invoked to perform operations like
	 * click, sendKeys, getText, etc using By type Explicit Waits is used to
	 * deal with special element which needs long time to identify. Implicit
	 * Wait is used to wait for certain time for every web element in
	 * application(It's built in createWebDriver() in WebUIDriver Class)
	 */
	protected void findElement() {
		try {
			driver = WebUIDriver.getWebDriver();
			element = driver.findElement(by);
		} catch (Exception e) {
			TestReportsLog.log(LogStatus.ERROR, "BaseElement ::- FindElement() " + e.getMessage());
		}
	}

	/*
	 * This method is used to get all elements in the current page with same
	 * locator
	 * 
	 * @return-element(All webelements in the List)
	 */
	public List<WebElement> getAllElements() {
		findElement();

		return driver.findElements(by);
	}

	public List<WebElement> getElements() {
		return driver.findElements(by);
	}

	/*
	 * This method is used to find the element and gets an attribute (using
	 * standard key-value pair) from the underlying attribute.
	 * 
	 * @param - name
	 * 
	 * @return -attribute value
	 */
	public String getAttribute(final String name) {
		findElement();

		return element.getAttribute(name);
	}

	/*
	 * This method returns the BY locator stored in the HtmlElement.
	 * 
	 * @return-by locator
	 */
	public By getBy() {
		return by;
	}

	/*
	 * This method is used to find required element and to get CSSvalue of
	 * required attribute
	 * 
	 * @param-propertyName(Attribute name)
	 * 
	 * @return-Cssvalue of required attribute
	 * 
	 */
	public String getCssValue(final String propertyName) {
		findElement();

		return element.getCssValue(propertyName);
	}

	/*
	 * This method is used to get Webdriver based on our requirement like
	 * Chrome,IE..etc. It will wait until all the webelements loaded in to web
	 * page
	 */
	protected WebDriver getDriver() {
		return WebUIDriver.getWebDriver();
	}

	/*
	 * This method is used to get required webelement by passing Locatortype
	 * which associated with value
	 * 
	 * @param-by-(By.id("uname"))
	 * 
	 * @return-element
	 */
	public WebElement getElement() {
		element = driver.findElement(by);

		return element;
	}

	/*
	 * This method is used to Executes the given JavaScript against the
	 * underlying WebElement.
	 * 
	 * @param-script(ex:Script may related to mouse events or get attribute of
	 * any element or etc.)
	 * 
	 * @return-name
	 */
	public String getEval(final String script) {
		findElement();

		final String name = (String) ((JavascriptExecutor) driver).executeScript(script, element);

		return name;
	}

	/*
	 * This method is used to get height of the required element
	 * 
	 * @return-Height property of element
	 * 
	 */
	public int getHeight() {
		findElement();

		return element.getSize().getHeight();
	}

	/*
	 * This method Returns the label used during initialization.
	 * 
	 * @return-label name
	 */
	public String getLabel() {
		return label;
	}

	/*
	 * This method is used get exact location of element
	 * 
	 * @return-Location of element(The size of the element on the page i.e width
	 * and height)
	 * 
	 * 
	 */
	public Point getLocation() {
		findElement();

		return element.getLocation();
	}

	/*
	 * This method is used to get locator to find the underlying WebElement.
	 * 
	 * @return-locator
	 */
	public String getLocator() {
		return locator;
	}

	/*
	 * This method is used to get exact path of element to identify it
	 * 
	 * @param -locator,locatorType
	 * 
	 * @locator-It's value of the locatortype to identify element ex:id="uname"
	 * 
	 * @locatorType-It's the type of locator required to identify element like
	 * as Id,Name..etc.
	 * 
	 * @return-path of element(By.id("uname"))
	 */
	private By getLocatorBy(final String locator, final LocatorType locatorType) {

		switch (locatorType) {

		case ID:
			return By.id(locator);

		case NAME:
			return By.name(locator);

		case CLASS_NAME:
			return By.className(locator);

		case LINK_TEXT:
			return By.linkText(locator);

		case PARTIAL_LINK_TEXT:
			return By.partialLinkText(locator);

		case CSS_SELECTOR:
			return By.cssSelector(locator);

		case TAG_NAME:
			return By.tagName(locator);

		default:
			return By.xpath(locator);
		}
	}

	/*
	 * This method is used to identify the element Returns the size of the
	 * underlying WebElement
	 */
	public Dimension getSize() {
		findElement();

		return element.getSize();
	}

	/*
	 * This method is used to get tagName for the underlying WebElement (div, a,
	 * input,img,select etc).
	 * 
	 * @return-tagName of specified element
	 */
	public String getTagName() {
		findElement();

		return element.getTagName();
	}

	/*
	 * This method is used to get the text body of underlying element
	 * 
	 * @return-text of the specified element
	 */
	public String getText() {
		findElement();

		return element.getText();
	}

	/*
	 * This method is used to get value of "value" attribute for specified
	 * webelement
	 * 
	 * @return-value of "value" attribute
	 */
	public String getValue() {
		findElement();

		return element.getAttribute("value");
	}

	/*
	 * This method is used to get width of the underlying WebElement
	 * 
	 * @return-width of webelemnt
	 */
	public int getWidth() {
		findElement();

		return element.getSize().getWidth();
	}

	/*
	 * Firstly from this method driver is invoked to perform operations like
	 * click, sendKeys, getText, etc using By type Explicit Waits is used to
	 * deal with special element which needs long time to identify. Implicit
	 * Wait is used to wait for certain time for every web element in
	 * application(It's built in createWebDriver() in WebUIDriver Class)
	 */
	public void init() {
		driver = WebUIDriver.getWebDriver();
		element = driver.findElement(by);
	}

	/*
	 * This method is used to verify whether the element currently displayed in
	 * the browser or not. This method only used to know element displayed or
	 * not, it didn't verify hidden elements in browser
	 * 
	 * @return-true(if element present);false(if element didn't present)
	 */
	public boolean isDisplayed() {

		try {
			findElement();

			return element.isDisplayed();
		} catch (final Exception e) {
			return false;
		}
	}
	
	public boolean isElementDisplayed() {

		try {
			//findElement();

			return element.isDisplayed();
		} catch (final Exception e) {
			return false;
		}
	}


	/*
	 * This method is used to find whether element exists in the page or not, it
	 * may be visible/hidden element
	 * 
	 * @return-true(if element present);false(if element didn't present)
	 */
	public boolean isElementPresent() {

		if (WebUIDriver.getWebDriver() == null) {
			TestReportsLog.log(LogStatus.ERROR, "Web Driver is terminated! Exception might caught in last action.");
			throw new RuntimeException("Web Driver is terminated! Exception might caught in last action.");
		}

		int count = 0;

		try {

			count = WebUIDriver.getWebDriver().findElements(by).size();
		} catch (final RuntimeException e) {

			if (e instanceof InvalidSelectorException) {
				TestReportsLog.log(LogStatus.ERROR, "Got InvalidSelectorException, retry");
				// WaitHelper.waitForSeconds(2);
				count = WebUIDriver.getWebDriver().findElements(by).size();
			} else if ((e.getMessage() != null)
					&& e.getMessage().contains("TransformedEntriesMap cannot be cast to java.util.List")) {
				TestReportsLog.log(LogStatus.ERROR, "Got CastException, retry");
				// WaitHelper.waitForSeconds(2);
				count = WebUIDriver.getWebDriver().findElements(by).size();
			} else {
				throw e;
			}
		}

		if (count == 0) {
			TestReportsLog.log(LogStatus.ERROR, "Element not present on the Page" + toHTML());

			return false;
		}
		TestReportsLog.log(LogStatus.PASS, "The Required Element Found " + toHTML());
		return true;
	}

	/*
	 * This method is Indicates whether or not the element is enabled in the
	 * browser.
	 * 
	 * @return-true(if element enabled);false(element disabled)
	 */
	public boolean isEnabled() {
		findElement();
		return element.isEnabled();
	}
	
	
	public boolean isElementEnabled() {
		//findElement();
		return element.isEnabled();
	}

	/*
	 * This method Indicates whether or not the element is disabled in the
	 * browser
	 * 
	 * @return-true(if element disabled)
	 */
	public boolean isDisabled() {
		findElement();
		boolean result = false;
		if (!element.isEnabled()) {
			result = true;
			TestReportsLog.log(LogStatus.INFO, "The Element is Disabled");
		} else {
			TestReportsLog.log(LogStatus.FAIL, "The Element Is Enabled");
		}
		return result;
	}

	/*
	 * This method Indicates whether or not the element is selected in the
	 * browser.
	 * 
	 * @return-true(if element selected);false(if element deselected)
	 */
	public boolean isSelected() {
		findElement();
		return element.isSelected();
	}

	/*
	 * This method is used to get innertext of element and return true if given
	 * text exist in the returned(innertext) text
	 * 
	 * @param-text(input to verify)
	 * 
	 * @return-true(if given text present in inner text of elemnt);false(if
	 * given text present in inner text of elemnt)
	 */
	public boolean isTextPresent(final String text) {
		findElement();
		return element.getText().contains(text);
	}

	/*
	 * This method used to find an element and to scroll the page to that elemnt
	 * using mouseDown event.
	 */
	public void mouseDown() {
		TestReportsLog.log(LogStatus.INFO, "MouseDown " + this.toString());
		findElement();
		final Mouse mouse = ((HasInputDevices) driver).getMouse();
		mouse.mouseDown(null);
	}

	/*
	 * This method used to find and mousehover on element with specified
	 * cordinates
	 */

	public void mouseOver() {
		TestReportsLog.log(LogStatus.INFO, "MouseOver " + this.toString());
		findElement();
		// build and perform the mouseOver with Advanced User Interactions API
		// Actions builder = new Actions(driver);
		// builder.moveToElement(element).build().perform();
		final Locatable hoverItem = (Locatable) element;
		final Mouse mouse = ((HasInputDevices) driver).getMouse();
		mouse.mouseMove(hoverItem.getCoordinates());
	}

	/*
	 * /*This method is used to mouseover on element. Mouse event created using
	 * Document.createEvent() Initializes the value(mouseover) of a mouse event
	 * using MouseEvent.initMouseEvent() method The dispatchEvent method throws
	 * UNSPECIFIED_EVENT_TYPE_ERR if the event's type was not specified by
	 * initializing the event before the method was called, or if the event's
	 * type is null or an empty string
	 */

	public void simulateMouseOver() {
		findElement();
		final String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(mouseOverScript, element);
	}

	public void scroll(int x, int y) {
		Actions dragger = new Actions(driver);
		findElement();
		// int numberOfPixelsToDragTheScrollbarDown = 5000;
		dragger.moveToElement(element).clickAndHold().moveByOffset(x, y).release().perform();
	}

	/*
	 * This method is used to smouseUp event on the WebElement
	 */
	public void mouseUp() {
		TestReportsLog.log(LogStatus.INFO, "MouseUp " + this.toString());
		findElement();

		final Mouse mouse = ((HasInputDevices) driver).getMouse();
		mouse.mouseUp(null);
	}

	/*
	 * This method is used to enter indicated CharSequence to the WebElement.
	 * 
	 * @param-arg0
	 */
	public void sendKeys(final CharSequence arg0) {
		findElement();
		element.sendKeys(arg0);
	}

	/* Method not required */

	protected void sleep(final int waitTime) throws InterruptedException {
		Thread.sleep(waitTime);
	}

	/*
	 * This method Converts the Type, Locator and LabelElement attributes of the
	 * HtmlElement into a readable and report-friendly string.
	 *
	 * @return
	 */
	public String toHTML() {
		/*
		 * return getClass().getSimpleName().toLowerCase() +
		 * " <a style=\"font-style:normal;color:#8C8984;text-decoration:none;\" href=# \">"
		 * + getLabel() + ",: " + getBy().toString() + "</a>";
		 */

		return getClass().getSimpleName().toLowerCase() + " " + getLabel();

	}

	/*
	 * This method is used to represent the HtmlElement's Type, LabelElement and
	 * Locator in readable format.
	 * 
	 * @param-String
	 */
	public String toString() {
		return getClass().getSimpleName().toLowerCase() + " " + getLabel() + ", by={" + getBy().toString() + "}";
	}

	/*
	 * This method is used to Wait element to present using Explicit Waits with
	 * default EXPLICIT_WAIT_TIME_OUT = 15 seconds.
	 */
	public void waitForPresent() {
		waitForPresent(EXPLICIT_WAIT_TIME_OUT);
	}

	/**
	 * Wait element to present using Explicit Waits with timeout in seconds.
	 * This method is used for special element which needs long time to present.
	 */
	/*
	 * This method is used to Wait element to present using Explicit Waits with
	 * timeout in seconds. This method is used for special element which needs
	 * long time to present.
	 */
	public void waitForPresent(final int timeout) {
		/*
		 * TestLogging.logWebStep("wait for " + this.toString() +
		 * " to present.", false);
		 */
		/*
		 * final Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
		 * wait.until(new ExpectedCondition<WebElement>() { public WebElement
		 * apply(final WebDriver driver) { return driver.findElement(by); });
		 */

	}

	/*
	 * This method is used to add given text to the actual text of webelement
	 * 
	 */
	public String append(By by, String val, String description) throws Exception {
		String text1;
		try {
			findElement();
			text1 = element.getText();
			StringBuffer sb = new StringBuffer(text1);
			String s = sb.append(val).toString();

			TestReportsLog.log(LogStatus.INFO, "Given text added to the actual text of webelement: " + s + toHTML());

		} catch (Exception e) {
			e.printStackTrace();
			TestLogging.log("Got Element not found Exception, retry");
			throw e;
		}
		return text1;
	}

	/* This method is used to get title from the driver page */
	public String getTitle() {
		driver = WebUIDriver.getWebDriver();
		String title = driver.getTitle();
		TestReportsLog.log(LogStatus.INFO, "Title: " + title + toHTML());
		return title;
	}

	/* This method is used to move the driver focus/switch to Frame */
	public void switchtoFrame() {
		try {
			findElement();

			driver.switchTo().frame(element);
			TestReportsLog.log(LogStatus.INFO, "Switched To Frame");
		}

		catch (Exception e) {
			e.printStackTrace();
			TestReportsLog.log(LogStatus.ERROR, "Got InvalidException, retry");

		}

	}

	/* This method is used reset the driver focus to default Content */
	public void switchtoDefaultContent() {
		try {
			driver = WebUIDriver.getWebDriver();
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			e.printStackTrace();
			TestReportsLog.log(LogStatus.ERROR, "Got Exception in switchtoDefaultContent , retry");
		}
	}

	/* This method is used to press space through Keyboard */
	public static void space() {
		org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(
				WebUIDriver.getWebDriver());
		action.sendKeys(Keys.SPACE).build().perform();
	}

	/* This method is used to press Enter through Keyboard */
	public static void enter() {
		org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(
				WebUIDriver.getWebDriver());
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	/* This method is used to press Arrow Down through Keyboard */
	public static void arrowDown() {
		org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(
				WebUIDriver.getWebDriver());
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
	}
	

	/* This method is used to press Escape through Keyboard */
	public static void esc() {
		org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(
				WebUIDriver.getWebDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public static void tab() {

		Actions action = new Actions(WebUIDriver.getWebDriver());

		action.sendKeys(Keys.TAB).build().perform();
	}

	/* This method is used for drag and drop functionality */
	public void dragAndDrop(By singleLineText, By singleLineTextDestination, String desc) throws Exception {
		try {
			driver = WebUIDriver.getWebDriver();
			WebElement source = driver.findElement(singleLineText);
			WebElement destination = driver.findElement(singleLineTextDestination);
			org.openqa.selenium.interactions.Actions builder = new org.openqa.selenium.interactions.Actions(driver);
			Action dragAndDrop = builder.clickAndHold(source).moveToElement(destination).release(destination).build();
			dragAndDrop.perform();
			TestLogging.log(LogStatus.INFO + desc);
			TestLogging.logInfo(this.getClass().getName() + ":" + desc);
		} catch (Exception e) {
			// TODO: handle exception
			// TestLogging.error(this.getClass().getName() + ":" + desc + "
			// ->:Exception is
			// :" + e + Utility.appendScreenshot());
			TestReportsLog.log(LogStatus.ERROR, LogStatus.FAIL + desc + " ->:Exception is :" + e);

			throw e;
		}

	}

	/*
	 * This method is used to read the data or values from the properties file
	 */
	public static String getValuesFromPropertiesFile(String propertiesFileName, String key) {
		try {
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "\\" + propertiesFileName + ".properties"));
			Properties prop = new Properties();
			prop.load(fis);
			fis.close();
			return prop.get(key).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getOptions(String name) {

		findElement();
		List<WebElement> list = element.findElements(by.tagName(name));
		List<String> names = null;

		for (int i = 0; i <= list.size(); i++) {

			names.add(list.get(i).getText());
		}
	}

	public void mouseHover() {
		findElement();
		Actions a = new Actions(WebUIDriver.getWebDriver());
		// WebElement element = WebUIDriver.getWebDriver().findElement(by);
		a.moveToElement(element).build().perform();

	}

	public void mouseHoverToHomeAndClickOnElement() {
		findElement();
		Actions a = new Actions(WebUIDriver.getWebDriver());
		// WebElement element = WebUIDriver.getWebDriver().findElement(by);
		a.moveToElement(element).build().perform();

	}
	

	public void mouseHoverClick() {
		findElement();
		Actions a = new Actions(WebUIDriver.getWebDriver());
		// WebElement element = WebUIDriver.getWebDriver().findElement(by);
		a.moveToElement(element).click().build().perform();

	}

	public void mouseHoverDoubleClick() {
		findElement();
		Actions a = new Actions(WebUIDriver.getWebDriver());
		a.moveToElement(element).doubleClick().build().perform();
	}

	public boolean notDisplayed() {
		try {
			findElement();
			if (!element.isDisplayed()) {
				TestReportsLog.log(LogStatus.INFO, "Element Not Present on the Page");
			}
		} catch (final Exception e) {
			return false;
		}
		return true;
	}

	public void dragScrollbar(int dragrange) {
		Actions dragger = new Actions(WebUIDriver.getWebDriver());
		findElement();
		/*
		 * WebElement element = driver.findElement(locator);
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[dragrange].scrollIntoView(true);",
		 * element);
		 */

		int numberOfPixelsToDragTheScrollbarDown = dragrange;
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release()
				.perform();

	}

	public void scrollwithJavaExecutor() {

		findElement();

		((JavascriptExecutor) WebUIDriver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void clickUsingJavaScriptExecutor() {
		findElement();
		((JavascriptExecutor) WebUIDriver.getWebDriver()).executeScript("arguments[0].click();", element);
	}

	public void waitTillElementClickable() {

		findElement();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		System.out.println("This is =" + by);
		wait.until(ExpectedConditions.elementToBeClickable(by));

	}

	public void waitTillElementSelected() {

		findElement();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		System.out.println("This is =" + by);
		wait.until(ExpectedConditions.elementToBeSelected(by));
	}

	public void waitTillElementFound() {

		findElement();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		TestReportsLog.log(LogStatus.INFO, "Wait Till Element Found, Field Name - " + label + " defination " + by);
		System.out.println("This is =" + by);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitTillTextFound(String text) {

		findElement();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		System.out.println("This is =" + by);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void backSpace() {

		findElement();

		element.sendKeys(Keys.BACK_SPACE);

	}

	public static void openNewTab() {

		((JavascriptExecutor) WebUIDriver.getWebDriver()).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(WebUIDriver.getWebDriver().getWindowHandles());

		WebUIDriver.getWebDriver().switchTo().window(tabs.get(1));

	}

	// public static void switchWindow(int windowIndex) {
	//
	// ArrayList<String> tabs = new
	// ArrayList<String>(WebUIDriver.getWebDriver().getWindowHandles());
	//
	// WebUIDriver.getWebDriver().switchTo().window(tabs.get(windowIndex));
	//
	// }

	public static void closeTab() {

		((JavascriptExecutor) WebUIDriver.getWebDriver()).executeScript("window.close()");

	}
	

	public void findAlertOptions(List<String> dropdownOption) {

		findElement();

		List<WebElement> options = element.findElements(By.tagName("li"));

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