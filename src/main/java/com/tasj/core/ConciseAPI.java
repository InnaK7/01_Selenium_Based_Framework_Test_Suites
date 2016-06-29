package com.tasj.core;

import com.tasj.core.entities.ProxyCollection;
import com.tasj.core.entities.ProxyElement;
import com.tasj.core.entities.collection.ProxyWebDriverCollection;
import com.tasj.core.entities.element.ProxyWebDriverElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Quotes;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConciseAPI {

    private static Map<Thread, WebDriver> driverThreadMap = new LinkedHashMap<Thread, WebDriver>();

    public static void setDriver(WebDriver driver) {
        driverThreadMap.put(Thread.currentThread(), driver);
    }

    public static WebDriver getDriver() {
        return driverThreadMap.get(Thread.currentThread());
    }


    public static void executeJavaScript(String jsCommand) {
        ((JavascriptExecutor) getDriver()).executeScript(jsCommand);
    }

    public static void refresh() {
        getDriver().navigate().refresh();
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static By byCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static By byTitle(String title) {
        return By.cssSelector(String.format("[title^=%s]", title));
    }

    public static By byText(String elementText) {
        return By.xpath(".//*/text()[normalize-space(.) = " + Quotes.escape(elementText) + "]/parent::*");
    }

    public static ProxyElement $(By locator) {
        return new ProxyWebDriverElement(locator);
    }

    public static ProxyElement $(String cssSelector) {
        return $(byCSS(cssSelector));
    }

    public static ProxyCollection $$(By locator) {
        return new ProxyWebDriverCollection(locator);
    }

    public static ProxyCollection $$(String cssSelector) {
        return $$(byCSS(cssSelector));
    }
}

