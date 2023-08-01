
package com.framework.driver;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.base.constants.BrowserType;
import com.framework.base.constants.DriverMode;
import com.framework.base.constants.FrameworkConstants;
import com.framework.browserfactory.ChromeDriverFactory;
import com.framework.browserfactory.EdgeDriverFactory;
import com.framework.browserfactory.FirefoxDriverFactory;
import com.framework.browserfactory.IEDriverFactory;
import com.framework.browserfactory.IWebDriverFactory;
import com.framework.browserfactory.RemoteDriverFactory;
import com.framework.browserfactory.SafariDriverFactory;
import com.framework.core.SeleniumTestsContextManager;
import com.framework.util.ReadProperties;
import com.framework.util.TestLogging;

/**
 * This class provides factory to create webDriver session.
 */
public class WebUIDriver {

    private static ThreadLocal<WebDriver> driverSession = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebUIDriver> uxDriverSession = new ThreadLocal<WebUIDriver>();
    private String node;
    private DriverConfig config = new DriverConfig();
    private WebDriver driver;
    private IWebDriverFactory webDriverBuilder;

    public String getNode() {
        return node;
    }

    public void setNode(final String node) {
        this.node = node;
    }

    public static void cleanUp() {
    	
    	System.out.println("Inside CleanUp Method");
        IWebDriverFactory iWebDriverFactory = getWebUIDriver().webDriverBuilder;
        if (iWebDriverFactory != null) {
        	
            iWebDriverFactory.cleanUp();
        } else {
            WebDriver driver = driverSession.get();
            if (driver != null) {
                try {
                	
                		driver.quit();
                } catch (WebDriverException ex) {
                	System.out.println("Inside Catch:" +driverSession);
                    ex.printStackTrace();
                }

                driver = null;
            }
        }

        driverSession.remove();
        uxDriverSession.remove();
    }
    
    public void maximizeWindow() {
        try {
            BrowserType browser = BrowserType.getBrowserType(WebUIDriver.getWebUIDriver().getBrowser());
            if (browser == BrowserType.Android || browser == BrowserType.IPhone) {
                return;
            }

            driver.manage().window().maximize();
        } catch (Exception ex) {

            try {
                ((JavascriptExecutor) driver).executeScript(
                    "if (window.screen){window.moveTo(0, 0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);}");
            } catch (Exception ignore) {
                TestLogging.log("Unable to maximize browser window. Exception occured: " + ignore.getMessage());
            }
        }
    }

    /**
     * Returns native WebDriver which can be converted to RemoteWebDriver.
     *
     * @return webDriver
     */
    /*public static WebDriver getNativeWebDriver() {
        return ((CustomEventFiringWebDriver) getWebDriver(false)).getWebDriver();
    }*/

    /**
     * Get EventFiringWebDriver.
     *
     * @return webDriver
     */
    public static WebDriver getWebDriver() {
        return getWebDriver(false);
    }

    /**
     * Returns WebDriver instance Creates a new WebDriver Instance if it is null and isCreate is true.
     *
     * @param isCreate create webdriver or not
     * @return
     */
    public static WebDriver getWebDriver(final Boolean isCreate) {
        if (driverSession.get() == null && isCreate) {
            try {
                getWebUIDriver().createWebDriver();
            } catch (Exception e) {
            	//** log the exception if driver is not created
                e.printStackTrace();
            }
        }

        return driverSession.get();
    }

    /**
     * Returns WebUIDriver instance Creates new WebUIDriver instance if it is null.
     *
     * @return
     */
    public static WebUIDriver getWebUIDriver() {
        if (uxDriverSession.get() == null) {
            uxDriverSession.set(new WebUIDriver());
        }

        return uxDriverSession.get();
    }

    /**
     * Lets user set their own driver This can be retrieved as WebUIDriver.getWebDriver().
     *
     * @param driver
     */
    public static void setWebDriver(final WebDriver driver) {
        if (driver == null) {
            driverSession.remove();
        } else {
            if (getWebUIDriver() == null) {
                new WebUIDriver();
            }

            driverSession.set(driver);
        }
    }

    public WebUIDriver() {
        init();
        uxDriverSession.set(this);
    }

    public WebUIDriver(final String browser, final String mode) {
        init();
        this.setBrowser(browser);
        this.setMode(mode);
        uxDriverSession.set(this);
    }

    public WebDriver createRemoteWebDriver(final String browser, final String mode) throws Exception {
        WebDriver driver = null;
        config.setBrowser(BrowserType.getBrowserType(browser));
        config.setMode(mode);

        if (config.getMode().contentEquals(DriverMode.GRID)) {
        	System.out.println("grid");
            webDriverBuilder = new RemoteDriverFactory(this.config);
        } else {
            if (config.getBrowser() == BrowserType.FireFox) {
                webDriverBuilder = new FirefoxDriverFactory(this.config);
            }  else if (config.getBrowser() == BrowserType.InternetExplore) {
                webDriverBuilder = new IEDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.Chrome) {
                webDriverBuilder = new ChromeDriverFactory(this.config);
            }  else if (config.getBrowser() == BrowserType.Safari) {
                webDriverBuilder = new SafariDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.EDGE) {
                webDriverBuilder = new EdgeDriverFactory(this.config);
            }    else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }
        }

        synchronized (this.getClass()) {
            driver = webDriverBuilder.createWebDriver();
            driverSession.set(driver);
        }
        String browserVersion = ((RemoteWebDriver)(getWebDriverBuilder().getWebDriver())).getCapabilities().getVersion();
        SeleniumTestsContextManager.getTestLevelContext(SeleniumTestsContextManager.getGlobalContext().getTestNGContext()).setBrowserVersion(browserVersion);
        return driver;
    }

    public WebDriver createWebDriver() throws Exception {
        //change to log
    	System.out.println(Thread.currentThread() + ":" + new Date() + ":::Start creating web driver instance: "
                + this.getBrowser());
        driver = createRemoteWebDriver(config.getBrowser().getBrowserType(), config.getMode());

        driverSession.set(driver);
      //change to log
        System.out.println(Thread.currentThread() + ":" + new Date() + ":::Finish creating web driver instance: "
                + this.getBrowser());
        return driver;
    }

    public String getBrowser() {
        return config.getBrowser().getBrowserType();
    }

    public String getPlatform() {
        return config.getWebPlatform().name();
    }

    public String getBrowserVersion() {
        return config.getBrowserVersion();
    }

    public String getChromeBinPath() {
        return config.getChromeBinPath();
    }

    public String getChromeDriverPath() {
        return config.getChromeDriverPath();
    }

    public DriverConfig getConfig() {
        return config;
    }

    public int getExplicitWait() {
        return config.getExplicitWaitTimeout();
    }

    public String getFfDriverPath() {
        return config.getFirefoxDriverPath();
    }

    public String getFfProfilePath() throws URISyntaxException {
        return config.getFirefoxProfilePath();
    }

    public String getOperaProfilePath() throws URISyntaxException {
        return config.getOperaProfilePath();
    }

    public void setOperaProfilePath(final String operaProfilePath) {
        config.setOperaProfilePath(operaProfilePath);
    }

    public String getHubUrl() {
        return config.getHubUrl();
    }

    public String getIEDriverPath() {
        return config.getIeDriverPath();
    }

    public double getImplicitWait() {
        return config.getImplicitWaitTimeout();
    }

    public String getMode() {
        return config.getMode();
    }

    public String getOutputDirectory() {
        return config.getOutputDirectory();
    }

    public String getNtlmAuthTrustedUris() {
        return config.getNtlmAuthTrustedUris();
    }

    public void setNtlmAuthTrustedUris(final String url) {
        config.setNtlmAuthTrustedUris(url);
    }

    public int getPageLoadTimeout() {
        return config.getPageLoadTimeout();
    }

    public String getProxyHost() {
        return config.getProxyHost();
    }

    public void setUserAgentOverride(final String userAgentOverride) {
        config.setUserAgentOverride(userAgentOverride);
    }

    public String getUserAgentOverride() {
        return config.getUserAgentOverride();
    }

    public IWebDriverFactory getWebDriverBuilder() {
        return webDriverBuilder;
    }

    public int getWebSessionTimeout() {
        return config.getWebSessionTimeout();
    }

    private void init() {
    	//This needs to be moved to util class
    	Properties prop= ReadProperties.getConfigProp();
		
        if(null != prop.getProperty("browser")){
			String browser = prop.getProperty("browser");
	        config.setBrowser(BrowserType.getBrowserType(browser));
		}
		String browserDownloadDir=System.getProperty("user.dir")+File.separator+prop.getProperty("browserDownloadDir");
		config.setBrowserDownloadDir(browserDownloadDir);
        
        String url =  prop.getProperty("url");
        config.setUrl(url);
        
        String url2 =  prop.getProperty("url2");
        config.setUrl(url2);
        
        String mode =  prop.getProperty("mode");
        config.setMode(mode);

        String hubUrl = prop.getProperty("hubUrl");
        config.setHubUrl(hubUrl);

        //String ffProfilePath = prop.getProperty("ffProfilePath");
        //config.setFfProfilePath(ffProfilePath);

        String ffDriverPath = FrameworkConstants.FIREFOX_DRIVER_EXE;
        config.setFfDriverPath(ffDriverPath);
        /*String edgeBinPath = prop.getProperty("edgeBinPath");
        config.setEdgeBinPath(edgeBinPath);*/

        //String chromeBinPath = prop.getProperty("chromeBinPath");
        //config.setChromeBinPath(chromeBinPath);

        String chromeDriverPath = FrameworkConstants.CHROME_DRIVER_EXE;
        config.setChromeDriverPath(chromeDriverPath);
        
        String edgeDriverPath = FrameworkConstants.EDGE_DRIVER_EXE;
        config.setEdgeDriverPath(edgeDriverPath);
        
        String ieDriverPath = FrameworkConstants.IEXPLORE_DRIVER_EXE;
        config.setIeDriverPath(ieDriverPath);

        double implicitWaitTimeout = Double.parseDouble(prop.getProperty("implicitWaitTimeout"));
        config.setImplicitWaitTimeout(implicitWaitTimeout);

        config.setPageLoadTimeout(Integer.valueOf(prop.getProperty("pageLoadTimeout")));
        config.setExplicitWaitTimeout(Integer.valueOf(prop.getProperty("explicitWaitTimeout")));
    }


    public boolean isSetAcceptUntrustedCertificates() {
        return config.isSetAcceptUntrustedCertificates();
    }

    public boolean isSetAssumeUntrustedCertificateIssuer() {
        return config.isSetAssumeUntrustedCertificateIssuer();
    }

    public boolean isEnableJavascript() {
        return config.isEnableJavascript();
    }

    public void setEnableJavascript(final Boolean enableJavascript) {
        config.setEnableJavascript(enableJavascript);
    }

    public void setBrowser(final String browser) {
        config.setBrowser(BrowserType.getBrowserType(browser));

    }

    public void setBrowserVersion(final String browserVersion) {
        config.setBrowserVersion(browserVersion);
    }

    public void setPlatform(final String platform) {
        config.setWebPlatform(Platform.valueOf(platform));
    }

    public void setChromeBinPath(final String chromeBinPath) {
        config.setChromeBinPath(chromeBinPath);
    }
    

    public void setBrowserDownloadDir(final String browserDownloadDir) {
        config.setBrowserDownloadDir(browserDownloadDir);
    }

    public String getBrowserDownloadDir() {
        return config.getBrowserDownloadDir();
    }

    public void setChromeDriverPath(final String chromeDriverPath) {
        config.setChromeDriverPath(chromeDriverPath);
    }
    public void setEdgeDriverPath(final String edgeDriverPath) {
        config.setEdgeDriverPath(edgeDriverPath);
    }

    public void setConfig(final DriverConfig config) {
        this.config = config;
    }

    public void setExplicitTimeout(final int explicitWaitTimeout) {
        config.setExplicitWaitTimeout(explicitWaitTimeout);
    }

    public void setFfDriverPath(final String ffDriverPath) {
        config.setFfDriverPath(ffDriverPath);
    }

    public void setFfProfilePath(final String ffProfilePath) {
        config.setFfProfilePath(ffProfilePath);
    }

    public void setHubUrl(final String hubUrl) {
        config.setHubUrl(hubUrl);
    }
    
    public void setUrl(final String Url) {
        config.setHubUrl(Url);
    }

    public void setIEDriverPath(final String ieDriverPath) {
        config.setIeDriverPath(ieDriverPath);
    }

    public void setImplicitlyWaitTimeout(final double implicitTimeout) {
        config.setImplicitWaitTimeout(implicitTimeout);
    }

    public void setMode(final String mode) {
        config.setMode(mode);
    }

    public void setOutputDirectory(final String outputDirectory) {
        config.setOutputDirectory(outputDirectory);
    }

    public void setPageLoadTimeout(final int pageLoadTimeout) {
        config.setPageLoadTimeout(pageLoadTimeout);
    }

    public void setProxyHost(final String proxyHost) {
        config.setProxyHost(proxyHost);
    }

    public void setSetAcceptUntrustedCertificates(final boolean setAcceptUntrustedCertificates) {
        config.setSetAcceptUntrustedCertificates(setAcceptUntrustedCertificates);
    }

    public void setSetAssumeUntrustedCertificateIssuer(final boolean setAssumeUntrustedCertificateIssuer) {
        config.setSetAssumeUntrustedCertificateIssuer(setAssumeUntrustedCertificateIssuer);
    }

    public void setWebDriverBuilder(final IWebDriverFactory builder) {
        this.webDriverBuilder = builder;
    }

    public void setWebSessionTimeout(final int webSessionTimeout) {
        config.setWebSessionTimeout(webSessionTimeout);
    }
    
    public static void CloseProcess(String ProcessName) throws IOException, InterruptedException 
    {
                 
                 Process p = Runtime.getRuntime().exec("tasklist");         
                 Runtime.getRuntime().exec("taskkill /IM " +ProcessName+ " /f");
                 Thread.sleep(3000);
    }
    
    public static void  closeBrowser(){
        
        try{
               Process p = Runtime.getRuntime().exec("tasklist");
               //BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
               String browser = WebUIDriver.getWebUIDriver().getBrowser();
               String line = null;
               
               while (browser != null) {
                     if (browser.contains("chrome") ) {      
                                  System.out.println("Closing Chrome browser");
                                   CloseProcess("chromedriver.exe");
                                  CloseProcess("chrome.exe");
                                  break; }
                     else
                            if(browser.contains("iexplore") ) {
                            	System.out.println("Closing IE browser");
                                   CloseProcess("IEDriverServer.exe");
                                   CloseProcess("iexplore.exe");
                                  break;
                            }
                     else
                            if(browser.contains("firefox") ) {
                            	System.out.println("Closing Firefox browser");
                                  CloseProcess("firefox.exe");
                            	CloseProcess("geckodriver.exe");
                                  break;
                            }
                     }
               
               //driver.close();
        }catch(Exception e){
               
        }
        
  }
    
    
   /* public static void getNewTab() {
    	
    	openNewTab(true);
    }*/
}
