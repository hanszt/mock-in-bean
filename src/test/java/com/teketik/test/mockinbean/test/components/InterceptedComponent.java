package com.teketik.test.mockinbean.test.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterceptedComponent {

    @Autowired
    private MockableComponent1 mockableComponent1;

    public void process() {
        mockableComponent1.doSomething();
    }

}
