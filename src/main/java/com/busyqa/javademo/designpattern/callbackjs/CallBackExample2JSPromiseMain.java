package com.busyqa.javademo.designpattern.callbackjs;

//declare an interface with the resolve methods, so you can use on more than one class and just refer to the interface
interface Resolve {
    void resolveMain();
}

//interface CallBackWithArg {
//    void resolveMain(int arg1);
//}

//class that implements the method to resolve defined in the interface
class CallBackImpl implements Resolve {
    public void resolveMain() {
        System.out.println("I've been called back (Async)");
    }
}

public class CallBackExample2JSPromiseMain {


    public static void main(String[] args) {
        //======== (1) Implement the interface
        Promise caller = new Promise();
        // Because of Polymorphism, it allows to pass different types of classes that have the implementation of Resolve interface

        Resolve callBack = new CallBackImpl();
        caller.then(callBack);
        caller.DoingSomething();

        //======== (2) Anonymous
        caller.then(new Resolve() {
            @Override
            public void resolveMain() {
                System.out.println("Anonymously call (Async)");

            }
        });
        caller.DoingSomething();

        //======== (3) Anonymous lambda expression
        caller.then(() -> System.out.println("Lambda Exp call (Async)"));
        caller.DoingSomething();

    }

}

class Promise {
    Resolve resolve;

    public void then(Resolve callback) {
        this.resolve = callback;
    }

    public void DoingSomething() {
        System.out.println("Doing something first ...");
        resolve.resolveMain();
    }
}

