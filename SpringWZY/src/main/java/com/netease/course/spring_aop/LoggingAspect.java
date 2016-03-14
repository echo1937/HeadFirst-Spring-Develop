package com.netease.course.spring_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Eric on 3/11/16.
 */
@Aspect
public class LoggingAspect {
    @Before("execution(* com.netease.course.spring_aop.Caculator.*(..)) && args(a, ..)")
    private void arithmeticDoLog(JoinPoint jp, int a) {
        System.out.println(a + ": " + jp.toString());
    }
}