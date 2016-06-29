package com.tasj.core.entities;

public interface ProxyEntity<TypeOfWrappedEntity> {
    TypeOfWrappedEntity getWrappedEntity();
}
