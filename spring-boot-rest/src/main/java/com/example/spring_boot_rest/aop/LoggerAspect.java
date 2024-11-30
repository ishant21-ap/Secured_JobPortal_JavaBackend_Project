package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect    //This is your aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);


    //This is your advice and whatever is in bracket is your pointcut
//    @Before("execution(* com.example.spring_boot_rest.service.JobService.*(..))")
//    public void logMethodCalled(){
//        LOGGER.info("Method called");
//    }


    //Now what if we want to target particular method so we will use jointpoint
//    @Before("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
//    public void logMethodCalled(JoinPoint jp){
//        LOGGER.info("Method called " + jp.getSignature().getName());
//    }

    //Now if want to club many methods together then we can do in this way
    @Before("execution(* com.example.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.example.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }


    //Use of After (After will execute finally, with or without expection no matter)
    @After("execution(* com.example.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.example.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }


    //After throwing will execute when there is error (it will execute when there is error or exception)
    @AfterThrowing("execution(* com.example.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.example.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has exception " + jp.getSignature().getName());
    }


    //After Returning will execute when there is no exception
    @AfterReturning("execution(* com.example.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.example.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodEcecutedSucessfully(JoinPoint jp){
        LOGGER.info("Method has executed Sucessfully " + jp.getSignature().getName());
    }


    //@Around - you want it to be there before and after both
}
