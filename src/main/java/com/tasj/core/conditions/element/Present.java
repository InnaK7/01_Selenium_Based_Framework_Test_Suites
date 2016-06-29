package com.tasj.core.conditions.element;

import com.tasj.core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Present extends ElementCondition {

    private boolean isPresent;

    public boolean check(WebElement element) {
        isPresent = element.equals(null);
        return (!isPresent);
    }

    public String expected() {
        return "present";
    }

    public String actual() {
        return (isPresent) ? "present" : "not present";
    }

}
