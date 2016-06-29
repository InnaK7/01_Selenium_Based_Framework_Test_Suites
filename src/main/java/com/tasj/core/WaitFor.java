package com.tasj.core;

import com.tasj.core.conditions.Condition;
import com.tasj.core.entities.ProxyEntity;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class WaitFor {

    public static <T> T until(ProxyEntity proxyEntity, Condition<T> condition, long timeout) {
        final long startTime = System.currentTimeMillis();
        Throwable lastError = null;

        while (System.currentTimeMillis() - startTime < timeout) {
            try {
                return condition.apply(proxyEntity);
            } catch (WebDriverException e) {
                lastError = e;
            }
            sleep(Configuration.pollingInterval);
        }

        throw new TimeoutException
                (String.format("failed while waiting %s seconds to assert %s", timeout / 1000, condition.toString()),
                        lastError);
    }

    public static <T> T until(ProxyEntity proxyEntity, Condition<T> condition) {
        return until(proxyEntity, condition, Configuration.timeout);
    }

    public static <T> T until(ProxyEntity proxyEntity, Condition<T>... conditions) {
        T conditionResult = null;
        for (Condition<T> condition : conditions) {
            conditionResult = until(proxyEntity, condition);
        }
        return conditionResult;
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
