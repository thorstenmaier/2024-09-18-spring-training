package com.accenture.spring.user.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PerformanceMonitor1 {

    @Around("@annotation(com.accenture.spring.user.aop.PerformanceAspect)")
    public Object monitor(ProceedingJoinPoint joinPoint) throws Throwable {
        long before = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long after = System.currentTimeMillis();
            System.out.println("Execution time 1: " + (after - before) + "ms");
        }
    }

}
