package com.tasj.core.conditions.element;

import com.tasj.core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean isVisible;

    public boolean check(WebElement element) {
        isVisible = element.isDisplayed();
        return isVisible;
    }

    public String expected() {
        return "visible";
    }

    public String actual() {
        return (isVisible) ? "visible" : "not visible";
    }
}
