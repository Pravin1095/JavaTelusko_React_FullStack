package com.teluskoLearning.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    //After gets called once the method has finished executing
    @After("execution(* com.teluskoLearning.demo.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }

    //AfterThrowing throws an error when a method is failed with some exceptions
    @AfterThrowing("execution(* com.teluskoLearning.demo.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some issues" + jp.getSignature().getName());
    }

    //AfterReturning executes only if method is success without an error whereas @After executes
    //once method has executed even with an error
    @AfterReturning("execution(* com.teluskoLearning.demo.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method has executed successfully" + jp.getSignature().getName());
    }
}
