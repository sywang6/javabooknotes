package org.ghy.multiThreadFrame.ch04.ch03_08;

public class MyRunnable implements  Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
