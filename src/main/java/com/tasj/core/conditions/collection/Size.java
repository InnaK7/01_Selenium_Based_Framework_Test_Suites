package com.tasj.core.conditions.collection;

import com.tasj.core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CollectionCondition {

    public int expectedSize;
    public int elementsSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public boolean check(List<WebElement> elements) {
        elementsSize = elements.size();
        return elementsSize == expectedSize;
    }

    public String expected() {
        return Integer.toString(expectedSize);
    }

    public String actual() {
        return Integer.toString(elementsSize);
    }
}
