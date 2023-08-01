package com.framework.elements;

import org.openqa.selenium.By;


public class Locator {

    public static By byName(final String name) {
        return By.name(name);
    }

    public static By byId(final String id) {
        return By.id(id);
    }

    public static By byCSSSelector(final String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static By byXPath(final String xPath) {
        return By.xpath(xPath);
    }

    public static By byLinkText(final String linkText) {
        return By.linkText(linkText);
    }

    public static By byPartialLinkText(final String partialLinkText) {
        return By.partialLinkText(partialLinkText);
    }

    public static By byClassName(final String className) {
        return By.className(className);
    }

}
