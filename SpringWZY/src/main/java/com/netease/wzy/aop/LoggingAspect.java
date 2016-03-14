package com.netease.wzy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Created by Eric on 3/14/16.
 */

@Aspect
public class LoggingAspect {

    @AfterReturning("execution(* com.netease.wzy.aop.*.*(..))")
    public void normalLog(JoinPoint joinPoint) {
        printMess(joinPoint);
        System.out.println("\tevent: AfterReturning");
    }


    @AfterThrowing(value = "execution(* com.netease.wzy.aop.*.*(..))", throwing = "ex")
    public void errLog(JoinPoint joinPoint, Exception ex) {
        printMess(joinPoint);
        System.out.println("\tevent: AfterThrowing");
    }

    private void printMess(JoinPoint joinPoint) {
        String args = Arrays.toString(joinPoint.getArgs());
        if (args == "[]") {
            args = "null";
        }
        System.out.println("\tmethod: " + joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName() + "()");
        System.out.println("\targs: " + args);
    }
}
