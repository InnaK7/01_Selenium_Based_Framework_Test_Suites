package com.tasj.core.entities.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.tasj.core.ConciseAPI.getDriver;

public class ProxyWebDriverElement extends AbstractProxyElement {

    private By locator;

    public ProxyWebDriverElement(By locator) {
        this.locator = locator;
    }

    public WebElement fetchWrappedEntity() {
        return getDriver().findElement(locator);
    }

    public String toString() {
        return locator.toString();
    }
}
