package com.goingao.gzh.web.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * FIXME
 *
 * @author goingao
 * @date 2020-04-07
 */
@Order(1)
@Aspect
@Component
@Slf4j
public class WebLogAop {

    @Pointcut(value = "within(com.goingao.gzh.web.*.controller..*)")
    public void logPointCut() {
    }

    @Around(value = "logPointCut()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        try {
            log.info("WebLogAop order1 ---" + methodName + "开始执行");
            Object response = joinPoint.proceed();
            log.info("WebLogAop order1 ---" + methodName + "执行结束");
            return response;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }

    @Before("logPointCut()")
    public void before2() {
        log.info("WebLogAop Before2 order1 ---");
    }

    @Before("logPointCut()")
    public void before3() {
        log.info("WebLogAop Before3 order1 ---");
    }

    @Before("logPointCut()")
    public void before4() {
        log.info("WebLogAop Before4 order1 ---");
    }

    @After("logPointCut()")
    public void after() {
        log.info("WebLogAop After order1 ---");
    }

    @AfterReturning("logPointCut()")
    public void afterReturning() {
        log.info("WebLogAop AfterReturning order1 ---");
    }

    @AfterThrowing("logPointCut()")
    public void afterThrowing() {
        log.info("WebLogAop AfterThrowing order1 ---");
    }
}
