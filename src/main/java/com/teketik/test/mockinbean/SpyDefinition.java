package com.teketik.test.mockinbean;

import org.mockito.Mockito;
import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;

import java.util.Objects;

class SpyDefinition extends Definition {

    SpyDefinition(String name, ResolvableType type) {
        super(name, type);
    }

    @Override
    <T> T create(Object originalValue) {
        Objects.requireNonNull(originalValue, "originalValue must not be null");
        Assert.isInstanceOf(Objects.requireNonNull(resolvableType.resolve()), originalValue);
        Assert.state(!Mockito.mockingDetails(originalValue).isSpy(), "originalValue is already a spy");
        //noinspection unchecked
        return (T) Mockito.mock(originalValue.getClass(), Mockito.withSettings()
                .name(name)
                .spiedInstance(originalValue)
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

}
