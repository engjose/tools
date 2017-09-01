package com.jose.controller.design.decorator;

/**
 * 实现Person接口
 */
public class Decorator implements Person{

    /** 将要被增强的Person */
    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void eat() {
        if (person != null) {
            person.eat();
        }
    }
}
