package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg7morePmoreC4stack;

public class P {

    private MyStack myStack;
    public P(MyStack myStack){
        this.myStack = myStack;
    }
    public void pushService(){
        myStack.push();
    }

}
