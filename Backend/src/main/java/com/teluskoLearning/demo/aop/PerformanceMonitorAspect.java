package com.teluskoLearning.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);


    //Around is used whenever we want a method to be called during the start as well as the end
    //Suppose we want to find how long does it take for a method to execute, We can use Around

    //It is mandatory to return object while using Around. To have the method to be called between
    //we use ProceedingJoinPoint


    @Around("execution(* com.teluskoLearning.demo.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = jp.proceed();
        long end = System.currentTimeMillis();

        LOGGER.info("Time taken : "+ (end-start) +" ms");
        return obj;
    }
}
