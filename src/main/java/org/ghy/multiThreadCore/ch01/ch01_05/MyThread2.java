package org.ghy.multiThreadCore.ch01.ch01_05;

public class MyThread2 extends Thread{


    public void run(){

        try {
            System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}