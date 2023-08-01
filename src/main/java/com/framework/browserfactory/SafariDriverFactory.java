package com.framework.browserfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.framework.util.TestLogging;
import com.framework.driver.DriverConfig;
public class SafariDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {

	/*This Constructor is used to invoke object of DriverConfig Class
     * It will execute the Constructor of parent class(browserfactory)
     * @param:cfg
     */
    public SafariDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    /*This method will override the parent class(browserfactory) createWebDriver method and execute the same
     *It will Launch Safari browser with required Safari Capabilities enabled/disabled
     *It will wait(Implicit Waits) driver to handle dynamic elements with default timeout
     * @return:driver
     */
    
    @Override
    public WebDriver createWebDriver() {
        DesiredCapabilities cap = new SafariCapabilitiesFactory().createCapabilities(webDriverConfig);
        System.out.println("Begin Safari");
        synchronized (this.getClass()) {
            driver = new SafariDriver(cap);
        }

        System.out.println("safari started");

        this.setWebDriver(driver);

        // Implicit Waits handles dynamic element.
        setImplicitWaitTimeout(webDriverConfig.getImplicitWaitTimeout());
        if (webDriverConfig.getPageLoadTimeout() >= 0) {
            TestLogging.log("Safari doesn't support pageLoadTimeout");
        }

        return driver;
    }

}


