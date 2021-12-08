package org.ghy.multiThreadFrame.ch07.ch03_01;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallableA begin "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        for (int i = 0; i < 123456; i++) {
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableA 在运行中"+(i+1));
        }
        System.out.println("MyCallableA end "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        return "returnA";
    }
}
