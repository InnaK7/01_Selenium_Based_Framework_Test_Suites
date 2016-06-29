package com.tasj.core.entities.collection;

import com.tasj.core.conditions.ElementCondition;
import com.tasj.core.entities.ProxyCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProxyFilteredCollection extends AbstractProxyCollection {

    private ProxyCollection parentCollection;
    private ElementCondition condition;

    public ProxyFilteredCollection(ProxyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public List<WebElement> fetchWrappedEntity() {

        List<WebElement> filteredCollection = new ArrayList<>();

        for (WebElement element : parentCollection.getWrappedEntity()) {
            if (condition.check(element)) {
                filteredCollection.add(element);
            }
        }
        return filteredCollection;
    }

    public String toString() {
        return parentCollection.toString() + " findAll(" + condition.getClass().getSimpleName() + ")";
    }
}
