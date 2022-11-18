package com.andorid.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around(value = "@annotation(Loggable)")
    public Object executeLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            message.append(" args[ | ");
            Arrays.asList(args).forEach(arg -> {
                message.append(args).append(" | ");
            });
            message.append("]");
        }

        System.out.println(message.toString());
        return joinPoint.proceed();
    }

   /* @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            message.append(" args[ | ");
            Arrays.asList(args).forEach(arg -> {
                message.append(args).append(" | ");
            });
            message.append("]");
        }

        System.out.println(message.toString());
    }*/
}
