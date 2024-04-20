package com.teketik.test.mockinbean.test.example;

import com.teketik.test.mockinbean.MockInBean;
import com.teketik.test.mockinbean.SpyInBean;
import com.teketik.test.mockinbean.test.SpringTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@SpringTest
public final class MyServiceTest {

    @MockInBean(MyService.class) private final ThirdPartyApiService thirdPartyApiService;
    @SpyInBean(MyService.class) private final ExpensiveProcessor expensiveProcessor;
    private final MyService myService;

    public MyServiceTest(
            ThirdPartyApiService thirdPartyApiService,
            ExpensiveProcessor expensiveProcessor,
            MyService myService
    ) {
        this.thirdPartyApiService = thirdPartyApiService;
        this.expensiveProcessor = expensiveProcessor;
        this.myService = myService;
    }

    @Test
    void test() {
        Mockito.when(expensiveProcessor.returnSomethingExpensive()).thenReturn(0);
        myService.doSomething();
        Mockito.verify(thirdPartyApiService).doSomethingOnThirdPartyApi(0);
    }
}
