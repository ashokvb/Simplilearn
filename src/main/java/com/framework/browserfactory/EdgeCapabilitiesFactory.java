package com.framework.browserfactory;

import java.io.IOException;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.base.constants.DriverMode;
import com.framework.driver.DriverConfig;

public class EdgeCapabilitiesFactory implements ICapabilitiesFactory {
	/* This method is used to set all the capabilities related to the chrome browser
	 * Sets the  browser with the drowser mode
	 * @return --- capability object
	 */
	    public DesiredCapabilities createCapabilities(final DriverConfig webDriverConfig) {

	        DesiredCapabilities capability = null;
	        capability = DesiredCapabilities.edge();
	        capability.setBrowserName(DesiredCapabilities.edge().getBrowserName());

	        EdgeOptions options = new EdgeOptions();
	        if (webDriverConfig.getUserAgentOverride() != null) {
	           /* options.
	            addArguments("--user-agent=" + webDriverConfig.getUserAgentOverride());*/
	        }

	       // capability.setCapability(EdgeOptions.CAPABILITY, options);

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

	        if (webDriverConfig.getEdgeBinPath() != null) {
	            capability.setCapability("edge.binary", webDriverConfig.getEdgeBinPath());
	        }

	        // Set EdgeDriver for local mode
	        if (webDriverConfig.getMode() == DriverMode.LOCAL) {
	            String edgeDriverPath = webDriverConfig.getEdgeDriverPath();
	            if (edgeDriverPath == null) {
	                try {
	                    if (System.getenv("webdriver.edge.driver") != null) {
	                        System.out.println("get edge driver from property:"
	                                + System.getenv("webdriver.edge.driver"));
	                        System.setProperty("webdriver.edge.driver", System.getenv("webdriver.edge.driver"));
	                        
	                        
	                    } else {
	                        handleExtractResources();
	                    }
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	            } else {
	                System.setProperty("webdriver.edge.driver", edgeDriverPath);
	            }
	        }else{
	        	System.setProperty("webdriver.edge.driver", webDriverConfig.getEdgeDriverPath());
	        }

	        return capability;
	    }
	    /*This method is used to extract all Edge resources into required directory
	     * And Extracting Edge Driver path based on Operating System specified
	     */

	    public void handleExtractResources() throws IOException {
	        /*String dir = this.getClass().getResource("/").getPath();
	        dir = FileUtility.decodePath(dir);

	        if (!new File(dir).exists()) {
	            System.out.println("extracting Edge resources in " + dir);
	            FileUtility.extractJar(dir, WebDriverExternalResources.class);
	        }

	        if (!new File(dir + OSUtility.getSlash() + "chromedriver.exe").exists()) {
	            FileUtility.extractJar(dir, WebDriverExternalResources.class);
	        }

	        if (OSUtility.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver.exe");
	        } else {
	            System.setProperty("webdriver.chrome.driver", dir + "/chromedriver");
	            new File(dir + "/chromedriver").setExecutable(true);
	        }*/
	    }

	}