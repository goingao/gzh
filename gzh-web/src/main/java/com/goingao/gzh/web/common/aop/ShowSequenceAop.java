package com.goingao.gzh.web.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * FIXME
 *
 * @author goingao
 * @date 2020-04-07
 */
@Order(3)
@Aspect
@Component
@Slf4j
public class ShowSequenceAop {

    @Pointcut(value = "within(com.goingao.gzh.web.*.controller..*)")
    public void showSequenceCut() {
    }

    @Around(value = "showSequenceCut()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        try {
            log.info("ShowSequenceAop Around before order3 ---" + methodName);
            Object response = joinPoint.proceed();
            log.info("ShowSequenceAop Around after order3 ---" + methodName);
            return response;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }

    @Before("showSequenceCut()")
    public void before() {
        log.info("ShowSequenceAop Before order3 ---");
    }

    @After("showSequenceCut()")
    public void after() {
        log.info("ShowSequenceAop After order3 ---");
    }

    @AfterReturning("showSequenceCut()")
    public void afterReturning() {
        log.info("ShowSequenceAop AfterReturning order3 ---");
    }

    @AfterThrowing("showSequenceCut()")
    public void afterThrowing() {
        log.info("ShowSequenceAop AfterThrowing order3 ---");
    }

}
