
package com.framework.browserfactory;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.framework.base.constants.BrowserType;
import com.framework.driver.DriverConfig;
import com.framework.driver.ScreenShotRemoteWebDriver;
import com.framework.util.TestLogging;

public class RemoteDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {
/* This is a single parameter constructor  which initialize the DriverConfig variable in the  super class */
 
	
    public RemoteDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }
/* This method is used to get the capabilities of the selected browser
 * And pass the url in to the browser
 * Implicitly waits till the page is loaded
 * @return --- it returns driver
 *  */
    
    @Override
    public WebDriver createWebDriver() throws MalformedURLException, IllegalArgumentException, SecurityException,
        InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException,
        ClassNotFoundException {
        DriverConfig webDriverConfig = this.getWebDriverConfig();
        DesiredCapabilities capability = null;
        URL url;

        url = new URL(webDriverConfig.getHubUrl());

        switch (webDriverConfig.getBrowser()) {

            case FireFox :
            	System.setProperty("webdriver.gecko.driver", webDriverConfig.getFirefoxDriverPath());
                capability = new FirefoxCapabilitiesFactory().createCapabilities(webDriverConfig);
                break;

            case InternetExplore :
            	System.setProperty("webdriver.ie.driver", webDriverConfig.getIeDriverPath());
                capability = new IECapabilitiesFactory().createCapabilities(webDriverConfig);
                break;
			
            case Chrome :
            	System.setProperty("webdriver.chrome.driver", webDriverConfig.getChromeDriverPath());
                capability = new ChromeCapabilitiesFactory().createCapabilities(webDriverConfig);
                break;
                
            case Safari :
            	capability = new SafariCapabilitiesFactory().createCapabilities(webDriverConfig);
                break;
            case EDGE :
            	capability = new EdgeCapabilitiesFactory().createCapabilities(webDriverConfig);
                break;

            /*case Android :
                capability = new AndroidCapabilitiesFactory().createCapabilities(webDriverConfig);
                break;
			
            case IPhone :
                capability =
                    ((ICapabilitiesFactory) Class.forName("com.seleniumtests.browserfactory.IPhoneCapabilitiesFactory")
                            .getConstructor().newInstance()).createCapabilities(webDriverConfig);
                break;
            */    
            default :
                break;
        }

        switch (webDriverConfig.getBrowser()) {

            case IPhone :
            case FireFox :
                try {
                    driver = new ScreenShotRemoteWebDriver(url, capability);
                } catch (RuntimeException e) {
                    if (e.getMessage().contains(
                                "Unable to connect to host 127.0.0.1 on port 7062 after 45000 ms. Firefox console output")) {
                        TestLogging.log("Firefox Driver creation got port customexception, retry after 5 seconds");
                        //WaitHelper.waitForSeconds(5);
                        //driver = new ScreenShotRemoteWebDriver(url, capability);
                    } else {
                        throw e;
                    }
                }

                break;

            default :
            	driver = getGridCapabilites(url, capability);
        }

        setImplicitWaitTimeout(webDriverConfig.getImplicitWaitTimeout());
        if (webDriverConfig.getPageLoadTimeout() >= 0) {
            setPageLoadTimeout(webDriverConfig.getPageLoadTimeout(), webDriverConfig.getBrowser());
        }

        this.setWebDriver(driver);
        return driver;
    }
    
    private WebDriver getGridCapabilites( URL url,  DesiredCapabilities capabilities){
    	WebDriver driver=null;
    	// grid
    	try {
    			driver = new RemoteWebDriver(url, capabilities);
    	} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    	}
    	return driver;
    }

    /*  This method is used to make the browser wait till the page is loaded 
	 * @param timeout -----to give the time limit
	 * @param type ----- gives the browser type
	 */
    protected void setPageLoadTimeout(final long timeout, final BrowserType type) {
        switch (type) {

            case Chrome :
                try {
                    driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
                } catch (UnsupportedCommandException e) {
                    e.printStackTrace();
                }

                break;

            case FireFox :
            case InternetExplore :
                driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
                break;

            default :
        }
    }
}
