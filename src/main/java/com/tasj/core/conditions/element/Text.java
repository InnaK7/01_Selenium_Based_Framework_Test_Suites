package com.tasj.core.conditions.element;


import com.tasj.core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {

    public String expectedText;
    public String elementText;

    public Text(String expectedText) {
        this.expectedText = expectedText;
    }

    public boolean check(WebElement element) {
        elementText = element.getText();
        return elementText.contains(expectedText);
    }

    public String expected() {
        return expectedText;
    }

    public String actual() {
        return elementText;
    }
}
