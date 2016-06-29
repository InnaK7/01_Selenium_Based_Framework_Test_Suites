package com.tasj.core.conditions;

import com.tasj.core.entities.ProxyEntity;
import com.tasj.core.exceptions.ConditionNotMatchedException;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {

    private ProxyEntity proxyEntity;

    public T apply(ProxyEntity proxyEntity) {
        this.proxyEntity = proxyEntity;
        T entity = (T) proxyEntity.getWrappedEntity();
        if (check(entity)) {
            return entity;
        }
        throw new ConditionNotMatchedException(entity() + " does not match to condition " + getClass().getSimpleName());
    }

    public String toString() {
        return String.format("\n %s" +
                        "\n for %s" +
                        "\n located %s" +
                        "\n expected: %s" +
                        "\n actual: %s \n",
                getClass().getSimpleName(), entity(), proxyEntity, expected(), actual());
    }
}
