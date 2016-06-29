package com.tasj.core.conditions.element;

import com.tasj.core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class CssClass extends ElementCondition {

    private String cssClass;
    private String[] cssClassValues;

    public CssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public boolean check(WebElement element) {

        cssClassValues = element.getAttribute("class").split(" ");

        for (int i = 0; i < cssClassValues.length; i++) {
            if (cssClassValues[i].equals(cssClass)) {
                return true;
            }
        }
        return false;
    }

    public String expected() {
        return cssClass;
    }

    public String actual() {
        return Arrays.toString(cssClassValues);
    }

}
