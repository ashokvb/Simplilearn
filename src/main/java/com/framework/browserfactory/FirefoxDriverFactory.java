package com.framework.browserfactory;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.driver.DriverConfig;
public class FirefoxDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {
    private long timeout = 60;

	 
    /*This Constructor is used to invoke object of DriverConfig Class
     * It will execute the Constructor of parent class(AbstractWebDriverFactory)
     * @param:cfg
     */
    public FirefoxDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    /*This method is used to Launch Firefox browser with required Firefox Capabilities enabled/disabled
     *@param: webDriverConfig(object of DriverConfig Class )
     */
    protected WebDriver createNativeDriver() {
        return new FirefoxDriver(new FirefoxCapabilitiesFactory().createCapabilities(webDriverConfig));
    }

    
    /*This method will override the parent class(browserfactory) createWebDriver method and execute the same
     * It invoke/create webdriver and retry with timeout specified. 
     * It wait(Implicit Waits) driver to handle dynamic elements
     * Return driver instance at class level
     * @return: driver
     */
    @Override
    public WebDriver createWebDriver() {
        DriverConfig cfg = this.getWebDriverConfig();

        System.out.println("start create firefox");
        driver = createWebDriverWithTimeout();

        System.out.println("end create firefox");

        // Implicit Waits to handle dynamic element. The default value is 5seconds.
        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
        if (cfg.getPageLoadTimeout() >= 0) {
            setPageLoadTimeout(cfg.getPageLoadTimeout());
        }

        this.setWebDriver(driver);
        return driver;
    }


    /*This method invoke/create webdriver and retry with timeout specified.
     * It will retry and run the loop until webdriver invoke/create within timeout(60seconds) specified
     * In retry process if any exception found like SocketException,Failed to connect to binary FirefoxBinary etc..it will wait for specified time and countinues the process
     * @return:driver
     */
    protected WebDriver createWebDriverWithTimeout() {
        long time = 0;
        while (time < getTimeout()) {
            try {
                driver = createNativeDriver();
                return driver;
            } catch (WebDriverException ex) {
                if (ex.getMessage().contains("SocketException")
                        || ex.getMessage().contains("Failed to connect to binary FirefoxBinary")
                        || ex.getMessage().contains("Unable to bind to locking port 7054 within 45000 ms")) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) { }

                    time++;
                } else {
                    throw new RuntimeException(ex);
                }
            }
        }

        throw new RuntimeException("Got customexception when creating webDriver with socket timeout 1 minute");
    }

    
    /*This method is used to get timeout specified 
     * @return:timeout
     */
    protected long getTimeout() {
        return timeout;
    }

   /*This method is used to wait the driver to load page elements by specifying timeout 
    * @param:timeout
    */
    protected void setPageLoadTimeout(final long timeout) {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }
}
