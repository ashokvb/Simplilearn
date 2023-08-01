package com.framework.browserfactory;


import org.openqa.selenium.WebDriver;

import com.framework.driver.DriverConfig;

public interface IWebDriverFactory {

    void cleanUp();

    WebDriver createWebDriver() throws Exception;

    WebDriver getWebDriver();

    DriverConfig getWebDriverConfig();
}
