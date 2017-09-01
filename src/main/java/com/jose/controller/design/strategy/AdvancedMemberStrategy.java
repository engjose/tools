package com.jose.controller.design.strategy;

/**
 * 高级会员的策略
 *
 */
public class AdvancedMemberStrategy implements MemberStrategy{

    @Override
    public double calcPrice(double bookPrice) {
        System.out.println("高级会员优惠20%");
        return bookPrice * 0.8;
    }
}
