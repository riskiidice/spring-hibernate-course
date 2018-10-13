package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Before("execution(* com.example.demo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting=====> @Before advice on addAccount()");
	}
}
