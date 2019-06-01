package com.busyqa.javademo.designpattern.callback;

import java.util.List;

//declare an interface with the callback methods, so you can use on more than one class and just refer to the interface
interface CallBack {
    void methodToCallBack();
}

//class that implements the method to callback defined in the interface
class CallBackImpl implements CallBack {
    public void methodToCallBack() {
        System.out.println("I've been called back (Async)");
    }
}

public class CallBackExampleMain {


    public static void main(String[] args) {


        //======== (1) Implement the interface
        // Because of Polymorphism, it allows to pass different types of classes that have the implementation of Resolve interface
        Caller caller = new Caller();
        CallBack callBack = new CallBackImpl();
        caller.register(callBack);
        caller.DoingSomething();


        //======== (2-1) Anonymous - register
        Caller caller2 = new Caller();
        caller2.register(new CallBack() {
            public void methodToCallBack() {
                System.out.println("I've been called back (Async)");
            }
        });
        caller2.DoingSomething();

        //======== (2-2) Anonymous  - no register
        Caller caller3 = new Caller();
        caller3.DoingSomething(new CallBack() {
            public void methodToCallBack() {
                System.out.println("I've been called back (Async)");
            }
        });
        caller3.DoingSomething();

        //======== (2-3) two interfaces
        Caller caller4 = new Caller(new CallBack() {
            @Override
            public void methodToCallBack() {

            }
        }, new CallBack() {
            @Override
            public void methodToCallBack() {

            }
        });
        caller4.DoingSomethingZ();


        //======== (3) Anonymous lambda expression - register
        Caller caller5 = new Caller();
        caller5.register(() -> System.out.println("Lambda Exp call (Async)"));
        caller5.DoingSomething();

    }

}

class Caller {
    CallBack callback;
    CallBack callback1;
    CallBack callback2;
    List<Caller> cList;


    public Caller() {
    }

    public Caller(CallBack callback1, CallBack callback2) {
        this.callback1 = callback1;
        this.callback2 = callback2;
    }

    public void register(CallBack callback) {
        this.callback = callback;
    }



    public void DoingSomething() {

        //....
        //....

        callback.methodToCallBack();
    }

    public void DoingSomething(CallBack callback) {

        //....
        //....

        callback.methodToCallBack();
    }

    public void DoingSomethingZ() {

        //....
        //....

        callback1.methodToCallBack();
        callback2.methodToCallBack();
    }
}

