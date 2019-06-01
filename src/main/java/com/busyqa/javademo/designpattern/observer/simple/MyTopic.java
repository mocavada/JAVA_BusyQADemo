package com.busyqa.javademo.designpattern.observer.simple;

import java.util.ArrayList;
import java.util.List;

interface Subject {

    //methods to resolveMain and unregister observers
    void register(Observer obj);


    //method to notify observers of change
    void notifyObservers();

    //method to get updates from subject
    Object getUpdate(Observer obj);

}

public class MyTopic implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String message;

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : this.observers) {
            obj.update();                       // <========callback
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        notifyObservers();
    }

}