package com.tasj.core.entities.collection;

import com.tasj.core.WaitFor;
import com.tasj.core.conditions.CollectionCondition;
import com.tasj.core.conditions.ElementCondition;
import com.tasj.core.entities.ProxyCollection;
import com.tasj.core.entities.ProxyElement;
import com.tasj.core.entities.element.ProxyCollectionFoundByConditionElement;
import com.tasj.core.entities.element.ProxyCollectionNthElement;
import com.tasj.core.entities.element.ProxyWrappedWebElement;
import com.tasj.core.exceptions.ElementNotFoundException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractProxyCollection implements ProxyCollection {

    public List<WebElement> getWrappedEntity() {
        List<WebElement> collection = fetchWrappedEntity();
        if (collection != null) {
            return collection;
        }
        throw new ElementNotFoundException(toString());
    }

    public abstract List<WebElement> fetchWrappedEntity();

    public ProxyCollection should(CollectionCondition... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    public ProxyCollection shouldBe(CollectionCondition... conditions) {
        return should(conditions);
    }

    public ProxyCollection shouldHave(CollectionCondition... conditions) {
        return should(conditions);
    }

    public ProxyElement get(int index) {
        return new ProxyCollectionNthElement(index, this);
    }

    public ProxyCollection filter(ElementCondition condition) {
        return new ProxyFilteredCollection(this, condition);
    }

    public ProxyElement find(ElementCondition condition) {
        return new ProxyCollectionFoundByConditionElement(this, condition);
    }

    public Iterator<ProxyElement> iterator() {
        List<ProxyElement> proxyCollection = new ArrayList<ProxyElement>();
        List<WebElement> collection = getWrappedEntity();

        for (WebElement element : collection) {
            proxyCollection.add(new ProxyWrappedWebElement(element, this));
        }
        return proxyCollection.iterator();
    }
}
