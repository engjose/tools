package com.jose.controller.design.strategy;

/**
 * 中级会员优惠10%
 *
 */
public class MediateMemberStrategy implements MemberStrategy{

    @Override
    public double calcPrice(double bookPrice) {
        System.out.println("中级会员优惠10%!");
        return bookPrice * 0.9;
    }
}
