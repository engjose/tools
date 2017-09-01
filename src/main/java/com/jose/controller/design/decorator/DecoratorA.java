package com.jose.controller.design.decorator;

/**
 * 装饰者A
 */
public class DecoratorA extends Decorator{

    public void eat() {
        super.eat();
        System.out.println("A在吃饭");
    }
}
