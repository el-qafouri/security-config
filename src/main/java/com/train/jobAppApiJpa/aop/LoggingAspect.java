package com.train.jobAppApiJpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.train.jobAppApiJpa.service.JobService.getJob(..)) || execution(* com.train.jobAppApiJpa.service.JobService.updateJob(..)) ")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    @After("execution(* com.train.jobAppApiJpa.service.JobService.getJob(..)) || execution(* com.train.jobAppApiJpa.service.JobService.updateJob(..)) ")
    public void logMethodExecute(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.train.jobAppApiJpa.service.JobService.getJob(..)) || execution(* com.train.jobAppApiJpa.service.JobService.updateJob(..)) ")
    public void logMethodExecuteSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed successfully " + jp.getSignature().getName());
    }

    

}
