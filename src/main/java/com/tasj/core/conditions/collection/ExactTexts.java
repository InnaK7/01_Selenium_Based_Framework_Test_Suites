package com.tasj.core.conditions.collection;

public class ExactTexts extends Texts {

    public ExactTexts(String... expectedTexts) {
        super(expectedTexts);
    }

    public boolean checkText(String elementText, String expectedText) {
        return elementText.equals(expectedText);
    }
}
