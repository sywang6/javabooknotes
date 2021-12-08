package org.ghy.multiThreadFrame.ch09.ch09_10;

public class MyRunnable1 implements  Runnable{
    @Override
    public void run() {

        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String newString = new String();
                for (int j = 0; j < 6; j++) {
                    Math.random();
                }
               if(Thread.currentThread().isInterrupted()){
                   System.out.println("任务没有完成,就中断了!");
                   throw  new InterruptedException();
               }
            }
            System.out.println("任务成功完成!");
        } catch (InterruptedException e) {
            System.out.println("进入catch中断了任务");
            e.printStackTrace();
        }

    }
}
