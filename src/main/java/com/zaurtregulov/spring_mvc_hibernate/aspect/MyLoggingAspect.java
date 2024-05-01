package com.zaurtregulov.spring_mvc_hibernate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.zaurtregulov.spring_mvc_hibernate.dao.*.*(..))")

    public Object aroundAllRepositoryMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String name = methodSignature.getName();

        System.out.println("Begin of method: " + name);
        Object methodResult = proceedingJoinPoint.proceed();
        System.out.println("End of method: " + name);

        return methodResult;
    }
}
