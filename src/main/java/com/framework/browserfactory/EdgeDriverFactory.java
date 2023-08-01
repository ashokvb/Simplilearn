package com.framework.browserfactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.framework.driver.DriverConfig;

public class EdgeDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {
	/* This constructor is used to initialize the super class(Browserfactory) variable
	 */
	    public EdgeDriverFactory(final DriverConfig cfg) {
	        super(cfg);
	    }
	/* Gets the chrome capabilites from the 'ChromeCapabilitiesFactory
	 * @returns --- Chrome driver object with all assigned capabilities
	 */
	    protected WebDriver createNativeDriver() {
	        return new EdgeDriver(new EdgeCapabilitiesFactory().createCapabilities(webDriverConfig));
	    }
	/* This method is used to invoke the chrome driver 
	 * @return --- chrome driver
	 */
	    @Override
	    public WebDriver createWebDriver() throws IOException {
	        DriverConfig cfg = this.getWebDriverConfig();

	        driver = createNativeDriver();

	        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
	        if (cfg.getPageLoadTimeout() >= 0) {
	            setPageLoadTimeout(cfg.getPageLoadTimeout());
	        }

	        this.setWebDriver(driver);
	        return driver;
	    }
	/* This method is used to set time for the driver to wait till the page is loaded*/
	    protected void setPageLoadTimeout(final long timeout) {
	        try {
	            driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	        } catch (UnsupportedCommandException e) { }
	    }

	}
