package com.jose.controller.design.observer;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * 定义订阅者
 */
public interface Subject {

    public List<Observer> observers = Lists.newArrayList();

    /**
     * 添加订阅者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 删除订阅者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知订阅者
     * @param message
     */
    void notify(String message);
}
