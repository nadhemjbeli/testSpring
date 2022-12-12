package com.example.nadhem_jbeli_2.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {



    @After("execution(void com.example.nadhem_jbeli_2.Controller.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        log.info( name );
    }
}
