package org.ghy.multiThreadFrame.ch09.ch08_01;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 7043842067251859542L;
    private int beginPosition;
    private  int endPosition;

    public MyRecursiveTask(int beginPosition, int endPosition) {
        this.beginPosition = beginPosition;
        this.endPosition = endPosition;
        System.out.println("# "+beginPosition+" "+endPosition);
    }

    @Override
    protected Integer compute() {
        Integer sumValue = 0;
        System.out.println("compute="+beginPosition+" "+endPosition);
        if((endPosition-beginPosition)>2){
            System.out.println("!=0");
            int middleNum = (endPosition+beginPosition)/2;
            System.out.println("left 传入的值:"+beginPosition+" "+middleNum);
            MyRecursiveTask leftTask = new MyRecursiveTask(beginPosition,middleNum);
            System.out.println("right 传入的值:"+(middleNum+1)+" "+endPosition);
            MyRecursiveTask rightTask = new MyRecursiveTask(middleNum+1,endPosition);
            ForkJoinTask.invokeAll(leftTask,rightTask);
            Integer leftValue =  leftTask.join();
            Integer rightValue =  rightTask.join();
            return leftValue + rightValue;
        }else{
            int count = 0;
            for (int i = beginPosition; i <= endPosition; i++) {
                count = count+i;
            }
            return count;
        }

    }
}
