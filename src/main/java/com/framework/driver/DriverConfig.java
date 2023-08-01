
package com.framework.driver;

import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

//import java.util.ArrayList;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;

import com.framework.base.constants.BrowserType;
//import org.openqa.selenium.support.events.WebDriverEventListener;
import com.framework.base.constants.DriverMode;

public class DriverConfig {

	private boolean setAssumeUntrustedCertificateIssuer = true;
	private boolean setAcceptUntrustedCertificates = true;
	private boolean enableJavascript = true;
	private WebDriver driver;
	private BrowserType browser = BrowserType.InternetExplore;
	private String mode = DriverMode.LOCAL;
	private String hubUrl;
	private String url;
	private String ffProfilePath;
	private String operaProfilePath;
	private String ffDriverPath;
	private String ieDriverPath;
	private String edgeDriverPath;
	private String chromeDriverPath;
	private String chromeBinPath;
	private String edgeBinPath;
	private int webSessionTimeout = 90 * 1000;
	private static final int DEFAULT_IMPLICIT_WAIT_TIMEOUT = 30;
	private static final int DEFAULT_EXPLICIT_WAIT_TIME_OUT = 15;
	private static final int DEFAULT_PAGE_LOAD_TIMEOUT = 90;
	protected double implicitWaitTimeout = DEFAULT_IMPLICIT_WAIT_TIMEOUT;
	private int explicitWaitTimeout = DEFAULT_EXPLICIT_WAIT_TIME_OUT;
	private int pageLoadTimeout = DEFAULT_PAGE_LOAD_TIMEOUT;
	private String outputDirectory;
	private String browserVersion;
	private Platform webPlatform;
	private String userAgentOverride;
	private String ntlmAuthTrustedUris;
	private String browserDownloadDir;

	private boolean useFirefoxDefaultProfile = true;
	private int browserWindowWidth = -1;
	private int browserWindowHeight = -1;

	private boolean eventFiringWebDriver = false;

	private String proxyHost;

	private String testType;

	// appium properties
	private String automationName;

	// Use same platform property as the one used for browser
	// private String platformName;
	private String appiumServerURL;
	private String mobilePlatformName;
	private String mobilePlatformVersion;
	private String deviceName;
	private String app;

	// Name of mobile web browser to automate.
	// This is irrelevant when automating an app
	private String browserName;

	private String appPackage;
	private String appActivity;
	private String newCommandTimeout;

	private String platform;
	private String version;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BrowserType getBrowser() {
		return browser;
	}

	public String getBrowserDownloadDir() {
		return browserDownloadDir;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public String getChromeBinPath() {
		return chromeBinPath;
	}

	public String getEdgeBinPath() {
		return edgeBinPath;
	}

	public String getEdgeDriverPath() {
		return edgeDriverPath;
	}

	public String getChromeDriverPath() {
		return chromeDriverPath;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public int getExplicitWaitTimeout() {
		if (explicitWaitTimeout < getImplicitWaitTimeout()) {
			return (int) getImplicitWaitTimeout();
		} else {
			return explicitWaitTimeout;
		}
	}

	public String getFirefoxDriverPath() {
		return ffDriverPath;
	}

	public String getFirefoxProfilePath() {
		if (ffProfilePath == null && getClass().getResource("/profiles/customProfileDirCUSTFF") != null) {

			try {
				return getClass().getResource("/profiles/customProfileDirCUSTFF").toURI().getPath();
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		} else {
			return ffProfilePath;
		}
	}

	public String getHubUrl() {
		return hubUrl;
	}

	public String getIeDriverPath() {
		return ieDriverPath;
	}

	public double getImplicitWaitTimeout() {
		return implicitWaitTimeout;
	}

	public String getMode() {
		return mode;
	}

	public String getNtlmAuthTrustedUris() {
		return ntlmAuthTrustedUris;
	}

	public String getOperaProfilePath() {
		if (operaProfilePath == null && getClass().getResource("/profiles/operaProfile") != null) {

			try {
				return getClass().getResource("/profiles/operaProfile").toURI().getPath();
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}

		return operaProfilePath;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public int getPageLoadTimeout() {
		return pageLoadTimeout;
	}

	public Platform getWebPlatform() {
		return webPlatform;
	}

	public Proxy getProxy() {
		Proxy proxy = null;
		if (proxyHost != null) {
			proxy = new Proxy();
			proxy.setProxyType(ProxyType.MANUAL);
			proxy.setHttpProxy(proxyHost);
			proxy.setFtpProxy(proxyHost);
			proxy.setSslProxy(proxyHost);
		}

		return proxy;

	}

	public String getProxyHost() {
		return proxyHost;
	}

	public String getUserAgentOverride() {
		return this.userAgentOverride;
	}

	public int getWebSessionTimeout() {
		return webSessionTimeout;
	}

	public boolean isUseFirefoxDefaultProfile() {
		return this.useFirefoxDefaultProfile;
	}

	public void setUseFirefoxDefaultProfile(final boolean useFirefoxDefaultProfile) {
		this.useFirefoxDefaultProfile = useFirefoxDefaultProfile;
	}

	public boolean isEnableJavascript() {
		return enableJavascript;
	}

	public boolean isSetAcceptUntrustedCertificates() {
		return setAcceptUntrustedCertificates;
	}

	public boolean isSetAssumeUntrustedCertificateIssuer() {
		return setAssumeUntrustedCertificateIssuer;
	}

	public void setBrowser(final BrowserType browser) {
		this.browser = browser;
	}

	public void setBrowserDownloadDir(final String browserDownloadDir) {
		this.browserDownloadDir = browserDownloadDir;
	}

	public void setBrowserVersion(final String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public void setChromeBinPath(final String chromeBinPath) {
		this.chromeBinPath = chromeBinPath;
	}

	public void setChromeDriverPath(final String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}

	public void setedgeBinPath(final String edgeBinPath) {
		this.edgeBinPath = edgeBinPath;
	}

	public void setEdgeDriverPath(final String edgeDriverPath) {
		this.edgeDriverPath = edgeDriverPath;
	}

	public void setDriver(final WebDriver driver) {
		this.driver = driver;
	}

	public void setEnableJavascript(final boolean enableJavascript) {
		this.enableJavascript = enableJavascript;
	}

	public void setExplicitWaitTimeout(final int explicitWaitTimeout) {
		this.explicitWaitTimeout = explicitWaitTimeout;
	}

	public void setFfDriverPath(final String ffDriverPath) {
		this.ffDriverPath = ffDriverPath;
	}

	public void setFfProfilePath(final String ffProfilePath) {
		this.ffProfilePath = ffProfilePath;
	}

	public void setHubUrl(final String hubUrl) {
		this.hubUrl = hubUrl;
	}

	public void setIeDriverPath(final String ieDriverPath) {
		this.ieDriverPath = ieDriverPath;
	}

	public void setImplicitWaitTimeout(final double implicitWaitTimeout) {
		this.implicitWaitTimeout = implicitWaitTimeout;
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	public void setMode(final String mode) {
		this.mode = mode;
	}

	public void setNtlmAuthTrustedUris(final String ntlmAuthTrustedUris) {
		this.ntlmAuthTrustedUris = ntlmAuthTrustedUris;
	}

	public void setOperaProfilePath(final String operaProfilePath) {
		this.operaProfilePath = operaProfilePath;
	}

	public void setOutputDirectory(final String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public void setPageLoadTimeout(final int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setWebPlatform(final Platform webPlatform) {
		this.webPlatform = webPlatform;
	}

	public void setProxyHost(final String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public void setSetAcceptUntrustedCertificates(final boolean setAcceptUntrustedCertificates) {
		this.setAcceptUntrustedCertificates = setAcceptUntrustedCertificates;
	}

	public void setSetAssumeUntrustedCertificateIssuer(final boolean setAssumeUntrustedCertificateIssuer) {
		this.setAssumeUntrustedCertificateIssuer = setAssumeUntrustedCertificateIssuer;
	}

	public void setUserAgentOverride(final String userAgentOverride) {
		this.userAgentOverride = userAgentOverride;
	}

	public void setWebSessionTimeout(final int webSessionTimeout) {
		this.webSessionTimeout = webSessionTimeout;
	}

	public int getBrowserWindowWidth() {
		return browserWindowWidth;
	}

	public void setBrowserWindowWidth(final int browserWindowWidth) {
		this.browserWindowWidth = browserWindowWidth;
	}

	public int getBrowserWindowHeight() {
		return browserWindowHeight;
	}

	public void setBrowserWindowHeight(final int browserWindowHeight) {
		this.browserWindowHeight = browserWindowHeight;
	}

	public String getAutomationName() {
		return automationName;
	}

	public void setAutomationName(final String automationName) {
		this.automationName = automationName;
	}

	public String getMobilePlatformVersion() {
		return mobilePlatformVersion;
	}

	public void setMobilePlatformVersion(final String mobilePlatformVersion) {
		this.mobilePlatformVersion = mobilePlatformVersion;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(final String deviceName) {
		this.deviceName = deviceName;
	}

	public String getApp() {
		return app;
	}

	public void setApp(final String app) {
		this.app = app;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(final String browserName) {
		this.browserName = browserName;
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(final String appPackage) {
		this.appPackage = appPackage;
	}

	public String getAppActivity() {
		return appActivity;
	}

	public void setAppActivity(final String appActivity) {
		this.appActivity = appActivity;
	}

	public String getNewCommandTimeout() {
		return newCommandTimeout;
	}

	public void setNewCommandTimeout(final String newCommandTimeout) {
		this.newCommandTimeout = newCommandTimeout;
	}

	public String getAppiumServerURL() {
		return appiumServerURL;
	}

	public void setAppiumServerURL(final String appiumServerURL) {
		this.appiumServerURL = appiumServerURL;
	}

	public String getMobilePlatformName() {
		return mobilePlatformName;
	}

	public void setMobilePlatformName(final String mobilePlatformName) {
		this.mobilePlatformName = mobilePlatformName;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(final String testType) {
		this.testType = testType;
	}

	public String getPlatform() {

		return platform;
	}

	public void setPlatform(final String platform) {
		this.platform = platform;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public boolean isEventFiringWebDriver() {
		return eventFiringWebDriver;
	}

	public void setEventFiringWebDriver(boolean eventFiringWebDriver) {
		this.eventFiringWebDriver = eventFiringWebDriver;
	}
	public void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	}
}
