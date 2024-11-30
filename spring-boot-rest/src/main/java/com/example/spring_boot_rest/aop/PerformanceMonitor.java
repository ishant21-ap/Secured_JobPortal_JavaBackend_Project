package com.example.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitor.class);

//    @Around("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
//    public Object Monitor(ProceedingJoinPoint pjp) throws Throwable {
//
//        //Now here i have two steps but i want start to execute before job method called and end to be executed after job method called
//        long start = System.currentTimeMillis();
//
//        Object result = pjp.proceed();   //This proceed() method return object thats why we have to change return type of class to object
//
//        long end = System.currentTimeMillis();
//
//        LOGGER.info("Time Taken : " + (end - start) + " ms");
//
//        return result;
//    }


    //Printing method name also
    @Around("execution(* com.example.spring_boot_rest.service.JobService.*(..))")
    public Object Monitor(ProceedingJoinPoint pjp) throws Throwable {

        //Now here i have two steps but i want start to execute before job method called and end to be executed after job method called
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();   //This proceed() method return object thats why we have to change return type of class to object

        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken : " + pjp.getSignature().getName() + " :" + (end - start) + " ms");

        return result;
    }

}
