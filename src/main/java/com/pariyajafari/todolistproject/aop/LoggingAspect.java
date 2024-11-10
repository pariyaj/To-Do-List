package com.pariyajafari.todolistproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.pariyajafari.todolistproject.service.TaskService.getAllTasks())(..))")
    public void getTaskPointcut(){ }

    @After("getTaskPointcut()")
    public void logMethodExecution(JoinPoint joinPoint){
        logger.info("Method " + joinPoint.getSignature().getName() + " executed successfully" );
    }
}
