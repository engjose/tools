package com.jose.controller.design.strategy;

/**
 * 策略模式的公共接口
 *
 */
public interface MemberStrategy {

    /**
     * 计算价格
     *
     * @param bookPrice
     * @return
     */
    double calcPrice(double bookPrice);
}
