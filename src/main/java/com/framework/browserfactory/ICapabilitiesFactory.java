package com.framework.browserfactory;


import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.driver.DriverConfig;

public interface ICapabilitiesFactory {

    DesiredCapabilities createCapabilities(DriverConfig cfg);

}
