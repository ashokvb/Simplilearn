package com.framework.browserfactory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.driver.DriverConfig;
import com.framework.base.constants.DriverMode;
import com.framework.util.FileUtility;
import com.framework.util.OSUtility;


public class IECapabilitiesFactory implements ICapabilitiesFactory {

	/*This method is used to extract all IE resources into required directory
     * And Extracting IE Driver path based on Operating Syatem specified
     */
    private void handleExtractResources() throws IOException {
        String dir = this.getClass().getResource("/").getPath();
        dir = FileUtility.decodePath(dir);
        if (!new File(dir).exists()) {
            FileUtility.extractJar(dir, WebDriverExternalResources.class);
        }

        if (!new File(dir + "\\IEDriverServer.exe").exists()) {
            if (OSUtility.getIEVersion() < 10) {
                FileUtility.copyFile(dir + "\\IEDriverServer_x64.exe", dir + "\\IEDriverServer.exe");
            } else {
                FileUtility.copyFile(dir + "\\IEDriverServer_Win32.exe", dir + "\\IEDriverServer.exe"); // Win32
            }
        }

        System.setProperty("webdriver.ie.driver", dir + "\\IEDriverServer.exe");
        System.out.println(dir + "\\IEDriverServer.exe");
    }
/* In this method the driver mode is checked and according to the driver mode the method is executed
 * This method is to get the IE driver path 
 * In this method the capabilites are also set are assinged.
 * @return ---- capabilities object
 * @param --- cfg(driver mode)
 */
    public DesiredCapabilities createCapabilities(final DriverConfig cfg) {

        // Set IEDriver for Local Mode
        if (cfg.getMode() == DriverMode.LOCAL) {
            if (cfg.getIeDriverPath() != null) {
                System.setProperty("webdriver.ie.driver", cfg.getIeDriverPath());
            } else {
                if (System.getenv("webdriver.ie.driver") != null) {
                    System.out.println("Get IE Driver from property:" + System.getenv("webdriver.ie.driver"));
                    System.setProperty("webdriver.ie.driver", System.getenv("webdriver.ie.driver"));
                } else {
                    try {
                        handleExtractResources();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }else{
        	System.setProperty("webdriver.ie.driver", cfg.getIeDriverPath());
        }

        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();

        capability.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());

        if (cfg.isEnableJavascript()) {
            capability.setJavascriptEnabled(true);
        } else {
            capability.setJavascriptEnabled(false);
        }

        capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability("ignoreZoomSetting", true);

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

        capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        return capability;
    }
}
