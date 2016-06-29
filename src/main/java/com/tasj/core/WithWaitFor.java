package com.tasj.core;

import com.tasj.core.conditions.ElementCondition;
import com.tasj.core.entities.ProxyElement;
import org.openqa.selenium.WebDriverException;

public class WithWaitFor {

    private ProxyElement proxyElement;
    private ElementCondition condition;

    public WithWaitFor(ProxyElement proxyElement, ElementCondition condition) {
        this.proxyElement = proxyElement;
        this.condition = condition;
    }

    public <T> T run(Command<T> command) {
        try {
            return command.execute(proxyElement.getWrappedEntity());
        } catch (WebDriverException e) {
            return command.execute(WaitFor.until(proxyElement, condition));
        }
    }
}
