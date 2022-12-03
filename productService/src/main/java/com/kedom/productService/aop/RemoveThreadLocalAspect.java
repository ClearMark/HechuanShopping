package com.kedom.productService.aop;

import com.kedom.productService.util.IDUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-1)
public class RemoveThreadLocalAspect {
    @Pointcut("@annotation(com.kedom.productService.aop.ann.RemoveThreadLocalAboutID)")
    public void pc1() {
    }

    @Pointcut("within(com.kedom.productService.controller..*)")
    public void pc2() {
    }

    @After("pc2()")
    public void after() {
        IDUtil.remove();
    }
}
