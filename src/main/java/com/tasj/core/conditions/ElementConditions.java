package com.tasj.core.conditions;

import com.tasj.core.conditions.element.*;

public class ElementConditions {

    //public static ElementCondition visible = new Visible();

    //public static ElementCondition present = new Present();

    public static ElementCondition cssClass(String cssClass) {
        return new CssClass(cssClass);
    }

    public static ElementCondition exactText(String text) {
        return new ExactText(text);
    }

    public static ElementCondition text(String text) {
        return new Text(text);
    }

    public static ElementCondition visible() {
        return new Visible();
    }

    public static ElementCondition present() {
        return new Present();
    }
}
