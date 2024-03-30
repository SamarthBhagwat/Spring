package com.example.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class VehicleStartCheckAspect {

    private static final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    // args is arguement of actual method
    @Before("execution(* com.example.services.*.*(..)) && args(vehicleStarted, ..)")
    public void checkVehicleStarted(JoinPoint joinPoint, boolean vehicleStarted) throws Throwable{
        if(!vehicleStarted){
            logger.info("Vehicle not started");
            throw new RuntimeException("Vehicle not started");
        }
        logger.info("Vehicle started successfully");
    }
}
