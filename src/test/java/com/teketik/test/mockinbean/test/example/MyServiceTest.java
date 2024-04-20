package com.teketik.test.mockinbean.test.example;

import com.teketik.test.mockinbean.MockInBean;
import com.teketik.test.mockinbean.SpyInBean;
import com.teketik.test.mockinbean.test.SpringTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

@SpringTest
public class MyServiceTest {

    @MockInBean(MyService.class)
    private ThirdPartyApiService thirdPartyApiService;

    @SpyInBean(MyService.class)
    private ExpensiveProcessor expensiveProcessor;

    @Autowired
    private MyService myService;

    @Test
    public void test() {
        final Object somethingExpensive = new Object();
        Mockito.when(expensiveProcessor.returnSomethingExpensive()).thenReturn(somethingExpensive);
        myService.doSomething();
        Mockito.verify(thirdPartyApiService).doSomethingOnThirdPartyApi(somethingExpensive);
    }

}
