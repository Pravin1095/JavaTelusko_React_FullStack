package com.teluskoLearning.demo.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.teluskoLearning.demo.service.JobService.getJob(..)) && args(postId)")  //pass the arg that we want to test at the end args(postId)
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {

         if(postId<0){
             LOGGER.info("Post Id is negative, updating it");
             postId = -postId;
             LOGGER.info("new value"+postId);
         }
         Object obj = jp.proceed(new Object[]{postId});
         return obj;
    }
}
