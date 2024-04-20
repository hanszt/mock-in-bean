package com.teketik.test.mockinbean.test.example;

import org.springframework.stereotype.Component;

@Component
public class ExpensiveProcessor {

    public int returnSomethingExpensive() {
        return 42;
    }

}
