package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// Pointcut declaration for getter method
	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
	private void getter() {}
	
	// Pointcut declaration for getter method
	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
	private void setter() {}
		
	// Pointcut declaration for package ...exclude setter and getter
	@Pointcut("forDaoPackage() && !(getter() || setter()) ")
	private void forDaoPackageNoGetterSetter() {}
		
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting=====> @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytic() {
		System.out.println("\n=========>>> Performing API analytic");
	}
	
}
