package com.tasj.core.entities.element;

import com.tasj.core.entities.ProxyCollection;
import com.tasj.core.exceptions.ProxyСollectionIndexOutOfBoundsException;
import org.openqa.selenium.WebElement;

public class ProxyCollectionNthElement extends AbstractProxyElement {

    private int index;
    private ProxyCollection parentCollection;

    public ProxyCollectionNthElement(int index, ProxyCollection parentCollection) {
        this.index = index;
        this.parentCollection = parentCollection;
    }

    public WebElement fetchWrappedEntity() {
        try {
            return parentCollection.getWrappedEntity().get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new ProxyСollectionIndexOutOfBoundsException(toString());
        }
    }

    public String toString() {
        return parentCollection.toString() + " [" + index + "]";
    }
}
