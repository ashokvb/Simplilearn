package com.framework.browserfactory;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.driver.DriverConfig;

public class SafariCapabilitiesFactory implements ICapabilitiesFactory {

    /*This method is used to set all required Capabilities to Safari Browser
     * It can enable/disable Javascript content based on requirement
     * It can set take screenshot capabilities
     * It can enable/disable SSL certs capabilityby default, It gives secure connections from a web server to a browser.
     * It can set Browser version capability as required
     * It can set platform capability as required
     * It can set proxy capability as required
     * @param:cfg
     * @return:capability
     */
	
	public DesiredCapabilities createCapabilities(final DriverConfig cfg) {
        DesiredCapabilities capability = null;
        capability = DesiredCapabilities.safari();

        if (cfg.isEnableJavascript()) {
            capability.setJavascriptEnabled(true);
        } else {
            capability.setJavascriptEnabled(false);
        }

        capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        if (cfg.getBrowserVersion() != null) {
            capability.setVersion(cfg.getBrowserVersion());
        }

        if (cfg.getWebPlatform() != null) {
            capability.setPlatform(cfg.getWebPlatform());
        }

        if (cfg.getProxyHost() != null) {
            Proxy proxy = cfg.getProxy();
            capability.setCapability(CapabilityType.PROXY, proxy);
        }

        return capability;
    }
}



