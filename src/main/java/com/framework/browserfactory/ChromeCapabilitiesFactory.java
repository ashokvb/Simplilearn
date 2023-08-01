package com.framework.browserfactory;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.driver.DriverConfig;
import com.framework.base.constants.DriverMode;
import com.framework.base.constants.FrameworkConstants;

/*import com.seleniumtests.helper.FileUtility;
import com.seleniumtests.helper.OSUtility;*/

//import com.seleniumtests.resources.WebDriverExternalResources;

public class ChromeCapabilitiesFactory implements ICapabilitiesFactory {
	/*
	 * This method is used to set all the capabilities related to the chrome browser
	 * Sets the browser with the drowser mode
	 * 
	 * @return --- capability object
	 */
	public DesiredCapabilities createCapabilities(final DriverConfig webDriverConfig) {
		File folder;
		DesiredCapabilities capability = null;
		capability = DesiredCapabilities.chrome();
		capability.setBrowserName(DesiredCapabilities.chrome().getBrowserName());

		ChromeOptions options = new ChromeOptions();
		if (webDriverConfig.getUserAgentOverride() != null) {
			options.addArguments("--user-agent=" + webDriverConfig.getUserAgentOverride());
		}

		capability.setCapability(ChromeOptions.CAPABILITY, options);

		if (webDriverConfig.isEnableJavascript()) {
			capability.setJavascriptEnabled(true);
		} else {
			capability.setJavascriptEnabled(false);
		}

		capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		if (webDriverConfig.getBrowserVersion() != null) {
			capability.setVersion(webDriverConfig.getBrowserVersion());
		}

		if (webDriverConfig.getWebPlatform() != null) {
			capability.setPlatform(webDriverConfig.getWebPlatform());
		}

		if (webDriverConfig.getProxyHost() != null) {
			Proxy proxy = webDriverConfig.getProxy();
			capability.setCapability(CapabilityType.PROXY, proxy);
		}

		if (webDriverConfig.getChromeBinPath() != null) {
			capability.setCapability("chrome.binary", webDriverConfig.getChromeBinPath());
		}

		// Set ChromeDriver for local mode
		String chromeDriverPath = webDriverConfig.getChromeDriverPath();
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		if (webDriverConfig.getBrowserDownloadDir() != null) {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", webDriverConfig.getBrowserDownloadDir());
			options.setExperimentalOption("prefs", chromePrefs);
			capability.setCapability(ChromeOptions.CAPABILITY, options);
			System.out.println(options.getExperimentalOption("prefs"));
		}

		return capability;
	}

}
