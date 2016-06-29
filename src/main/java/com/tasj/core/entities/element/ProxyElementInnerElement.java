package com.tasj.core.entities.element;

import com.tasj.core.entities.ProxyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProxyElementInnerElement extends AbstractProxyElement {

    private ProxyElement parentElement;
    private By locator;

    public ProxyElementInnerElement(ProxyElement parentElement, By locator) {
        this.parentElement = parentElement;
        this.locator = locator;
    }

    public WebElement fetchWrappedEntity() {
        return parentElement.getWrappedEntity().findElement(locator);
    }

    public String toString() {
        return parentElement.toString() + " find(" + locator.toString() + ")";
    }
}
