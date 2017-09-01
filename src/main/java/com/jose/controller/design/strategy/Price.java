package com.jose.controller.design.strategy;

/**
 * 真实计算价格的类
 *
 */
public class Price {

    private MemberStrategy memberStrategy;

    public Price(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    /**
     * 计算图书打折后的价格
     *
     * @param bookPrice
     * @return
     */
    public double getPrice(double bookPrice) {
        return memberStrategy.calcPrice(bookPrice);
    }
}
