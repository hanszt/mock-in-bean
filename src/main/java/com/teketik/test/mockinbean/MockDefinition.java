package com.teketik.test.mockinbean;

import org.mockito.Mockito;
import org.springframework.core.ResolvableType;

import static org.mockito.Mockito.mock;

class MockDefinition extends Definition {

    MockDefinition(String name, ResolvableType type) {
        super(name, type);
    }

    @Override
    <T> T create(Object originalValue) {
        //noinspection unchecked
        return (T) mock(resolvableType.resolve(), Mockito.withSettings().name(name));
    }

}
