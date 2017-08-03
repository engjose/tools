package com.jose.controller.spring.aop;

import com.jose.service.impl.spring.aop.AopRun;
import com.jose.service.impl.spring.aop.AopRunXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试aop功能Controller: 2017-08-03 14:33:48
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private AopRun aopRun;

    @Autowired
    private AopRunXml aopRunXml;

    @RequestMapping(value = "/aspectJ", method = RequestMethod.GET)
    public void aopAspectJ() {
        aopRun.annotationRun();
    }

    @RequestMapping(value = "xmlAspectJ", method = RequestMethod.GET)
    public void aopXmlAspectJ() {
        aopRunXml.runXml();
    }
}
