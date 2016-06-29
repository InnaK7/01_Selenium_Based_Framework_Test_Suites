package com.tasj.core.conditions;

import org.openqa.selenium.WebElement;

public abstract class ElementCondition extends AbstractCondition<WebElement> {

    public String entity() {
        return "element";
    }

}
