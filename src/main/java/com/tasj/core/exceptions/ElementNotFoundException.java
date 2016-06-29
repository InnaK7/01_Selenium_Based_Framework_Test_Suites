package com.tasj.core.exceptions;

import org.openqa.selenium.WebDriverException;

public class ElementNotFoundException extends WebDriverException {

    public ElementNotFoundException(String message) {
        super(message);
    }
}
