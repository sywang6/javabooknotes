package org.ghy.multiThreadFrame.ch06.ch05_01;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        System.out.println("MyCallableB"+System.currentTimeMillis());
        return "returnB";
    }
}
