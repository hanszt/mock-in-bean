package com.teketik.test.mockinbean.test;

import com.teketik.test.mockinbean.MockInBean;
import com.teketik.test.mockinbean.test.components.GenericMockableComponent;
import com.teketik.test.mockinbean.test.components.GenericTestComponent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

class GenericComponentTest extends BaseTest {

    @MockInBean(GenericTestComponent.class)
    private GenericMockableComponent<String> genericMockableComponent;

    @Autowired
    private GenericTestComponent genericTestComponent;

    @Test
    public void test() {
        Assertions.assertTrue(TestUtils.isMock(genericMockableComponent));
        Assertions.assertSame(genericMockableComponent, ReflectionTestUtils.getField(genericTestComponent, "genericMockableComponent"));
    }

}
