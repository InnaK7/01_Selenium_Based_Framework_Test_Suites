package com.tasj.core.conditions;

public interface Matcher<T> {
    boolean check(T entity);
}
