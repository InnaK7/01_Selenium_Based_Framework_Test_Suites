package com.tasj.core.exceptions;

import org.openqa.selenium.WebDriverException;

public class ConditionNotMatchedException extends WebDriverException {

    public ConditionNotMatchedException(String message) {
        super(message);
    }
}
