package com.jose.controller.design.strategy;

/**
 * 策略模式的测试类
 *
 */
public class MainTest {

    public static void main(String[] args) {
        MemberStrategy memberStrategy = new AdvancedMemberStrategy();
        Price price = new Price(memberStrategy);
        double finalPrice = price.getPrice(100);
        System.out.println(finalPrice);
    }
}
