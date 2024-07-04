package com.metrey.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
   // @Before("execution (public void add*())")

   // @Before("execution(* add*())")
    //@Before("execution(* add*(com.metrey.aopdemo.Account,..))")
    //@Before("execution(* add*(..))")   // match all any parameter

    @Before("execution(* com.metrey.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====> Executing @Before advice");
    }
}
