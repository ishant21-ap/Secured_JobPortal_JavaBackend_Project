package com.example.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class ValidationInspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationInspect.class);

    //Now we want to validate like when we called getJob() by passing id that is not present in database like (-4)
    // we have to pass id args using &&


    //Whatever we have passed in getJob arguement it will be stored in postId parameter and pass to our below method
    @Around("execution(* com.example.spring_boot_rest.service.JobService.getJob(..)) && args(postId)")
    public Object Validate(ProceedingJoinPoint pjs, int postId) throws Throwable {

        if(postId < 0){
            LOGGER.info("PostId is negative, updating it....");
            postId = -postId;
            LOGGER.info("PostId updated to : " + postId);
        }

        //Adding our updated postId to parameters in proceed method, actually we have two options not passing any arguement or passing object array
        Object obj = pjs.proceed(new Object[]{postId});
        return obj;
    }

}
