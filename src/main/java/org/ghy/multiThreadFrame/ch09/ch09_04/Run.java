package org.ghy.multiThreadFrame.ch09.ch09_04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Run {
    public static void main(String[] args) {

        try {
            MyRecursiveTask task = new MyRecursiveTask();
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask<String> returnTask =  pool.submit(task);
            System.out.println(" begin "+System.currentTimeMillis());
            System.out.println(returnTask.get());
            System.out.println(" end "+System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
