package com.teketik.test.mockinbean.test.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponentInterfaceImpl implements TestComponentInterface {

    @Autowired
    private TestComponent1 testComponent1;

}
