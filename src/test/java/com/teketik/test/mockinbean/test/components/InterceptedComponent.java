package com.teketik.test.mockinbean.test.components;

import org.springframework.stereotype.Component;

@Component
public class InterceptedComponent {

    private final MockableComponent1 mockableComponent1;

    public InterceptedComponent(MockableComponent1 mockableComponent1) {
        this.mockableComponent1 = mockableComponent1;
    }

    public void process() {
        mockableComponent1.doSomething();
    }

}
