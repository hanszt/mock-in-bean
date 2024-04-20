package com.teketik.test.mockinbean.test;

import com.teketik.test.mockinbean.MockInBean;
import com.teketik.test.mockinbean.SpyInBean;
import com.teketik.test.mockinbean.test.components.MockableComponent1;
import com.teketik.test.mockinbean.test.components.MockableComponent2;
import com.teketik.test.mockinbean.test.components.TestComponent1;
import com.teketik.test.mockinbean.test.components.TestComponent2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

abstract class TestInheritanceBaseTest extends BaseTest {

    @MockInBean(TestComponent1.class)
    @MockInBean(TestComponent2.class)
    protected MockableComponent1 mockableComponent1;

    @SpyInBean(TestComponent1.class)
    protected MockableComponent2 mockableComponent2;

    @Autowired
    private TestComponent1 testComponent1;

    @Autowired
    private TestComponent2 testComponent2;

    @Test
    public void test() {
        Assertions.assertTrue(TestUtils.isMock(mockableComponent1));
        Assertions.assertSame(mockableComponent1, ReflectionTestUtils.getField(testComponent1, "mockableComponent1"));
        Assertions.assertSame(mockableComponent1, ReflectionTestUtils.getField(testComponent2, "mockableComponent1"));

        Assertions.assertTrue(TestUtils.isSpy(mockableComponent2));
        Assertions.assertSame(mockableComponent2, ReflectionTestUtils.getField(testComponent1, "mockableComponent2"));
        Assertions.assertNotSame(mockableComponent2, ReflectionTestUtils.getField(testComponent2, "mockableComponent2"));
        Assertions.assertFalse(TestUtils.isMockOrSpy(ReflectionTestUtils.getField(testComponent2, "mockableComponent2")));
    }

}
