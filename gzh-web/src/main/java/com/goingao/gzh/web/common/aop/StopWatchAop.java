package com.goingao.gzh.web.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * FIXME
 *
 * @author goingao
 * @date 2020-04-07
 */
@Order(2)
@Aspect
@Component
@Slf4j
public class StopWatchAop {

    @Pointcut(value = "within(com.goingao.gzh.web.*.controller..*)")
    public void stopWatchPointCut() {
    }

    @Around(value = "stopWatchPointCut()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch("user 方法执行时间");
        String methodName = joinPoint.getSignature().getName();
        try {
            log.info("StopWatchAop order2 ---" + methodName + "开始计时");
            stopWatch.start(methodName);
            Object response = joinPoint.proceed();
            stopWatch.stop();
            log.info("StopWatchAop order2 ---" + methodName + "执行耗时 " + stopWatch.getTotalTimeMillis());
            return response;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
