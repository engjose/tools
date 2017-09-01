package com.jose.controller.design.strategy;

/**
 * 初级会员计算价格的策略
 */
public class PrimaryMemberStrategy implements MemberStrategy{

    @Override
    public double calcPrice(double bookPrice) {
        System.out.println("对于初级会员没有优惠!");
        return bookPrice;
    }
}
