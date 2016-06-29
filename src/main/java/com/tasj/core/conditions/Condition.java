package com.tasj.core.conditions;

import com.tasj.core.entities.ProxyEntity;

public interface Condition<T> extends Matcher<T> {
    T apply(ProxyEntity entity);
}
