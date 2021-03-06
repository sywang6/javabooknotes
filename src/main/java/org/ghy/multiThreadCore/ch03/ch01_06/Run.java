package org.ghy.multiThreadCore.ch03.ch01_06;

public class Run {
    public static void main(String[] args) {
        try{
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
