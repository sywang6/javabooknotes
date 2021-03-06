package org.ghy.multiThreadFrame.ch01.ch01_01;

import java.util.concurrent.Semaphore;

public class Service {

    private Semaphore semaphore = new Semaphore(2);
    public void  testMethod(){

        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" begin timer "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" end timer "+System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
