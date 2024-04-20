package com.teketik.test.mockinbean;

import static org.mockito.Mockito.mock;

import com.teketik.spring.test.mockito.MockReset;
import org.mockito.MockSettings;
import org.springframework.core.ResolvableType;

class MockDefinition extends Definition {

    MockDefinition(String name, ResolvableType type) {
        super(name, type);
    }

    @Override
    <T> T create(Object originalValue) {
        MockSettings settings = MockReset.withSettings(MockReset.AFTER);
        settings.name(name);
        return (T) mock(resolvableType.resolve(), settings);
    }

}
