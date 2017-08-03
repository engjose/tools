package com.jose.service.impl.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * xml的方式配置aop,切面类: 2017-08-03 18:01:49
 */
@Component
public class AudienceXml {

    public void beforeXml() {
        System.out.println("aop xml before");
    }

    public void afterXml() {
        System.out.println("aop xml after");
    }

    public void xmlAfterReturning() {
        System.out.println("aop xml after returning");
    }

    public void xmlAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("---aop xml around before---");
        point.proceed();
        System.out.println("--- aop xml around after ---");
    }
}
