package com.tasj.core.entities.element;

import com.tasj.core.conditions.ElementCondition;
import com.tasj.core.entities.ProxyCollection;
import com.tasj.core.exceptions.ElementNotFoundException;
import org.openqa.selenium.WebElement;

public class ProxyCollectionFoundByConditionElement extends AbstractProxyElement {

    private ProxyCollection parentCollection;
    private ElementCondition condition;

    public ProxyCollectionFoundByConditionElement(ProxyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public WebElement fetchWrappedEntity() {

        while (true) {
            for (WebElement element : parentCollection.getWrappedEntity()) {

                if (condition.check(element)) {
                    return element;
                }
            }
            throw new ElementNotFoundException("element matching condition is not found");
        }
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition.getClass().getSimpleName() + ")";
    }
}
