package com.framework.browserfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.framework.util.TestLogging;

import com.framework.driver.DriverConfig;
import com.framework.driver.WebUIDriver;

public abstract class AbstractWebDriverFactory {

    protected DriverConfig webDriverConfig;

    protected WebDriver driver;

    public AbstractWebDriverFactory(final DriverConfig cfg) {
        this.webDriverConfig = cfg;
    }

	    
/*This method is used to quitting webdriver and to return driver value as null 
 * @return: driver=null
 */
	    
	    public void cleanUp() {
	        try {
	            if (driver != null) {
	                try {
	                	TestLogging.log("quiting webdriver" + Thread.currentThread().getId());
	                    driver.quit();
	                } catch (WebDriverException ex) {
	                	TestLogging.log("Exception encountered when quiting driver: "
	                            + WebUIDriver.getWebUIDriver().getConfig().getBrowser().name() + ":" + ex.getMessage());
	                }

                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	    /*This method is used return webdriver value as null
	     * It states that this method will be implimented in required class by inheriting this 
	     * @return: null */

    public WebDriver createWebDriver() throws Exception {
        return null;
    }

    /**
     * Accessed by sub classes so that they don't have be declared abstract class.
     *
	   /*This method is used to return driver instance
	    * @return:driver
	    */
    public WebDriver getWebDriver() {
        return driver;
    }

	  /*This method is used to return object of DriverConfig class
	   * @return: webDriverConfig
	   */
	    public DriverConfig getWebDriverConfig() {
	        return webDriverConfig;
	    }

	    /*This method is used to wait(Implicit Waits) driver to handle dynamic elements
	     * The default value is 5 seconds
	     */
    public void setImplicitWaitTimeout(final double timeout) {
        if (timeout < 1) {
            driver.manage().timeouts().implicitlyWait((long) (timeout * 1000), TimeUnit.MILLISECONDS);
        } else {
            try {
                driver.manage().timeouts().implicitlyWait(new Double(timeout).intValue(), TimeUnit.SECONDS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

	 /*This method is used to return driver instance at class level
	  * @return:driver
	  */
	    
	    public void setWebDriver(final WebDriver driver) {
	        this.driver = driver;
	    }

	    /*This method is used to return object of DriverConfig class
		 * @return: webDriverConfig
		 */
	    public void setWebDriverConfig(final DriverConfig cfg) {
	        this.webDriverConfig = cfg;
	    }
	}


