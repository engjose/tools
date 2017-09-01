package com.jose.controller.design.observer;

/**
 * 订阅者的具体实现
 */
public class SubjectImpl implements Subject{

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
