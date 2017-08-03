package com.jose.service.impl.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类: 2017-08-03 14:24:02
 */
@Aspect
public class Audience {

    @Pointcut("execution(* com.jose.service.impl.spring.aop.AopRun.annotationRun(..))")
    public void methodPoint(){}

    @Before("methodPoint()")
    public void before() {
        System.out.println("aop before");
    }

    @After("methodPoint()")
    public void after() {
        System.out.println("aop after");
    }

    @AfterReturning("methodPoint()")
    public void afterReturning() {
        System.out.println("aop after returning");
    }

    @Around("methodPoint()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("********around before**********");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("********around after**********");
    }
}
