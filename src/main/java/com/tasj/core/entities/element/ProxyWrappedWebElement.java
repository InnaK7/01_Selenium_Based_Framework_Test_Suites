package com.tasj.core.entities.element;

import com.tasj.core.entities.ProxyEntity;
import org.openqa.selenium.WebElement;

public class ProxyWrappedWebElement extends AbstractProxyElement {

    private WebElement webElement;
    private ProxyEntity proxyEntity;

    public ProxyWrappedWebElement(WebElement webElement, ProxyEntity proxyEntity) {
        this.webElement = webElement;
        this.proxyEntity = proxyEntity;
    }

    public WebElement fetchWrappedEntity() {
        return webElement;
    }

    public String toString() {
        return webElement.toString() + " wrapped of" + proxyEntity.toString();
    }
}
