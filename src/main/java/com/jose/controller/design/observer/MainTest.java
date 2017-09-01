package com.jose.controller.design.observer;

/**
 * 观察者模式测试
 */
public class MainTest {

    public static void main(String[] args) {
        Observer observerA = new ObserverA("A");
        Observer observerB = new ObserverB("B");
        Subject subjec = new SubjectImpl();
        subjec.attach(observerA);
        subjec.attach(observerB);

        subjec.notify("你好!");
    }
}
