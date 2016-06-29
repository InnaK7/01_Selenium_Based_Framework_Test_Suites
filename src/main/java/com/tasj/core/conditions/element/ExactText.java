package com.tasj.core.conditions.element;

import org.openqa.selenium.WebElement;

public class ExactText extends Text {

    public ExactText(String expectedText) {
        super(expectedText);
    }

    public boolean check(WebElement element) {
        elementText = element.getText();
        return elementText.equals(expectedText);
    }
}
