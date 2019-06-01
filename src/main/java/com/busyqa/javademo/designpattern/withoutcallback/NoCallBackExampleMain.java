package com.busyqa.javademo.designpattern.withoutcallback;



public class NoCallBackExampleMain {
    public static void main(String[] args) throws InterruptedException {
        Caller caller = new Caller();
        caller.DoingSomething();
        caller.caller2.DoingSomething();
    }
}

class Caller {
    Caller2 caller2 = new Caller2();
    public void DoingSomething() throws InterruptedException {
        Thread.sleep(100000);
        System.out.println("Doing something(Sync)");
    }
}

class Caller2 {
    public void DoingSomething() {
        System.out.println("Doing something(Sync)");
    }
}
