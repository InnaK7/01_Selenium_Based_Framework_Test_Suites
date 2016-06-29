package com.tasj.core.entities.collection;

import com.tasj.core.entities.ProxyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProxyElementInnerCollection extends AbstractProxyCollection {

    private ProxyElement parentElement;
    private By locator;

    public ProxyElementInnerCollection(ProxyElement parentElement, By locator) {
        this.parentElement = parentElement;
        this.locator = locator;
    }

    public List<WebElement> fetchWrappedEntity() {
        return parentElement.getWrappedEntity().findElements(locator);
    }

    public String toString() {
        return parentElement.toString() + " findAll(" + locator.toString() + ")";
    }
}
