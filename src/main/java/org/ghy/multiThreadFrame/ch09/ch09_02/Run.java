package org.ghy.multiThreadFrame.ch09.ch09_02;

import java.util.concurrent.ForkJoinPool;

public class Run {
    public static void main(String[] args) {

        try {
            ForkJoinPool pool = new ForkJoinPool();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread="+Thread.currentThread().getName());
                }
            });
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
