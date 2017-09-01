package com.jose.controller.design.decorator;

/**
 * 装饰者设计模式测试类
 */
public class MainTest {

    public static void main(String[] args) {
        Man man = new Man();
        DecoratorA decoratorA = new DecoratorA();
        DecoratorB decoratorB = new DecoratorB();

        decoratorA.setPerson(man);
        decoratorB.setPerson(man);

        decoratorA.eat();
        decoratorB.eat();
    }
}
