package com.jose.controller.design.observer;

/**
 * 观察者A
 */
public class ObserverA implements Observer{

    private String name;

    public ObserverA(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "..." + message);
    }
}
