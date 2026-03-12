package com.teluskoLearning.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //execution(return-type class-name.method-name(args)
// Star represents all return types (*) of all classes and all its methods(*.*) with all its arguments (* *.*(..))
//    @Before("execution(* com.teluskoLearning.demo.service.JobService.*(..))")

    //If you want to get hold of the object, use JoinPoint and that gets your method name

    @Before("execution(* com.teluskoLearning.demo.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }
}
