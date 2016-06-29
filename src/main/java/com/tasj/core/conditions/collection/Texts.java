package com.tasj.core.conditions.collection;

import com.tasj.core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tasj.core.Helpers.getElementsTexts;

public class Texts extends CollectionCondition {

    public String[] expectedTexts;
    public List<String> elementsTexts = new ArrayList<String>();

    public Texts(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
        if (expectedTexts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty");
        }
    }

    public boolean check(List<WebElement> elements) {

        if (elements.size() != expectedTexts.length) {
            return false;
        }

        elementsTexts = getElementsTexts(elements);
        for (int j = 0; j < expectedTexts.length; j++) {
            if (!checkText(elementsTexts.get(j), expectedTexts[j])) {
                return false;
            }
        }
        return true;
    }

    public boolean checkText(String elementText, String expectedText) {
        return elementText.contains(expectedText);
    }

    public String expected() {
        return Arrays.toString(expectedTexts);
    }

    public String actual() {
        return elementsTexts.toString();
    }
}
