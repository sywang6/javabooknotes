package org.ghy.multiThreadFrame.ch04.ch03_05;

public class MyRunnable2 implements  Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
