

package com.framework.base.constants;

public enum BrowserType {
	Chrome("*chrome"),
    InternetExplore("*iexplore"),
    FireFox("*firefox"),
    Safari("*safari"),
    Android("*android"),
    IPhone("*iphone"),
	EDGE("*edge");

    public static BrowserType getBrowserType(final String browserType) {
        if (browserType.equalsIgnoreCase("*firefox") || browserType.equalsIgnoreCase("firefox")) {
            return BrowserType.FireFox;
        } else if (browserType.equalsIgnoreCase("*iexplore") || browserType.equalsIgnoreCase("iexplore")) {
            return BrowserType.InternetExplore;
        } else if (browserType.equalsIgnoreCase("*chrome") || browserType.equalsIgnoreCase("chrome")) {
            return BrowserType.Chrome;
        } else if (browserType.equalsIgnoreCase("*safari") || browserType.equalsIgnoreCase("safari")) {
            return BrowserType.Safari;
        } else if (browserType.equalsIgnoreCase("*android") || browserType.equalsIgnoreCase("android")) {
            return BrowserType.Android;
        } else if (browserType.equalsIgnoreCase("*iphone") || browserType.equalsIgnoreCase("iphone")) {
            return BrowserType.IPhone;
        }else if (browserType.equalsIgnoreCase("*edge") || browserType.equalsIgnoreCase("edge")) {
            return BrowserType.EDGE;
        } else {
            return BrowserType.InternetExplore;
        }
    }

    private String browserType;

    BrowserType(final String type) {
        this.browserType = type;
    }

    public String getBrowserType() {
        return this.browserType;
    }

}
