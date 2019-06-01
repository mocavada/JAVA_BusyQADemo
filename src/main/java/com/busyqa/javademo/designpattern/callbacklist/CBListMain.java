package com.busyqa.javademo.designpattern.callbacklist;


import java.util.ArrayList;
import java.util.List;

//declare an interface with the callback methods, so you can use on more than one class and just refer to the interface
interface CallBack {
    void methodToCallBack(String msg);
}


public class CBListMain {

    public static void main(String[] args) {
        Caller c = new Caller();
        c.subscribe((m) -> System.out.println("observer 1: " + m));
        c.subscribe((m) -> System.out.println("observer 2: " + m));
        c.subscribe((m) -> System.out.println("observer 3: " + m));


        c.next("news 1");

        c.subscribe((m) -> System.out.println("observer 4: " + m));
        c.subscribe((m) -> {

            System.out.println("observer 5: " + m);
            if(m.contains("crossword")){
                System.out.println("play: ");

            }else {
                System.out.println("read: ");
            }
        });

        c.next("news 2");
        c.next("news 3: crossword");
    }


}


class Caller {

    List<CallBack> cList = new ArrayList<>();

    public void subscribe(CallBack cb) {
        cList.add(cb);
    }

    public void next(String message) {
        for (CallBack obj : this.cList) {
            obj.methodToCallBack(message);
        }
    }

}