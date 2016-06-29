package com.tasj.core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;

public class MinimumSize extends Size {

    public MinimumSize(int expectedSize) {
        super(expectedSize);
    }

    public boolean check(List<WebElement> elements) {
        elementsSize = elements.size();
        return elementsSize >= expectedSize;
    }

}
