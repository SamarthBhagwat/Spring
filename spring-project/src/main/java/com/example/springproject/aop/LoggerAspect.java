package com.example.springproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@Aspect
public class LoggerAspect{

    @Around("execution(* com.example.springproject.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("Started execution of method : " + methodName);
        long startTime = System.currentTimeMillis();
        Object returnValue = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Ended execution of method: " + methodName);
        long executionTime = (endTime - startTime)/1000;
        log.info("Time taken for method : " + methodName + " to execute is : " + executionTime);
        return returnValue;
    }
}
