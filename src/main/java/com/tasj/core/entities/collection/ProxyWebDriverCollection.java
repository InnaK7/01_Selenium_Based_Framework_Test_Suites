package com.tasj.core.entities.collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.tasj.core.ConciseAPI.getDriver;

public class ProxyWebDriverCollection extends AbstractProxyCollection {

    private By locator;

    public ProxyWebDriverCollection(By locator) {
        this.locator = locator;
    }

    public List<WebElement> fetchWrappedEntity() {
        return getDriver().findElements(locator);
    }

    public String toString() {
        return locator.toString();
    }
}
