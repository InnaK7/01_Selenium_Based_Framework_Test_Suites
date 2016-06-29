package com.tasj.core;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static List<String> getElementsTexts(List<WebElement> elements) {
        List<String> elementsTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); i++) {
            elementsTexts.add(elements.get(i).getText());
        }
        return elementsTexts;
    }

    public static List<WebElement> getVisibleElements(List<WebElement> elements) {
        List<WebElement> visibleElements = new ArrayList<WebElement>();

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isDisplayed()) {
                visibleElements.add(elements.get(i));
            }
        }
        return visibleElements;
    }
}
