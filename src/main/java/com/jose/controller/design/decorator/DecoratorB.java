package com.jose.controller.design.decorator;

/**
 * 装饰者B
 */
public class DecoratorB extends Decorator{

    public void eat() {
        super.eat();
        System.out.println("B在吃饭");
    }
}
