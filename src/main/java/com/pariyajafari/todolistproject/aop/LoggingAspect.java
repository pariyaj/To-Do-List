package com.pariyajafari.todolistproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.pariyajafari.todolistproject.service.TaskService.getAllTasks())(..))")
    public void getTaskPointcut(){ }

    @After("getTaskPointcut()")
    public void logMethodExecution(JoinPoint joinPoint){
        LOGGER.info("Method " + joinPoint.getSignature().getName() + " executed successfully" );
    }

    @Pointcut("execution(* com.pariyajafari.todolistproject.service.TaskService.getTaskById())(..))")
    public void getTaskByIdPointcut(){ }

    @AfterThrowing("getTaskByIdPointcut()()")
    public void logMethodExecutionCrashed(JoinPoint joinPoint){
        LOGGER.info("Method " + joinPoint.getSignature().getName() + " threw an exception" );
    }
}
