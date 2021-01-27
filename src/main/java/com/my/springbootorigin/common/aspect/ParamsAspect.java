package com.my.springbootorigin.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParamsAspect {

    private Logger logger = LoggerFactory.getLogger(ParamsAspect.class);

    @Pointcut("@annotation(com.my.springbootorigin.common.annontations.DefaultParam)")
    public void pointCut() {}

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        logger.info("开始执行before");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        logger.info("开始执行around");
        return null;
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object result){
        logger.info("开始执行doAfterReturningAdvice1");
    }

    @AfterReturning(value = "pointCut()",returning = "result",argNames = "result")
    public void doAfterReturningAdvice2(String result){
        logger.info("开始执行doAfterReturningAdvice2");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        logger.info("开始执行doAfterThrowingAdvice");
    }

    @After(value = "pointCut()")
    public void doAfterAdvice(JoinPoint joinPoint){
        logger.info("开始执行doAfterAdvice");
    }
}
