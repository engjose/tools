package com.jose.controller.design.observer;

/**
 * 观察者B
 */
public class ObserverB implements Observer{

    private String name;

    public ObserverB(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "..." + message);
    }
}
