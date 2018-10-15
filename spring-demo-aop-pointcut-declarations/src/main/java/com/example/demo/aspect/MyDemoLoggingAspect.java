package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting=====> @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytic() {
		System.out.println("\n=========>>> Performing API analytic");
	}
	
}
