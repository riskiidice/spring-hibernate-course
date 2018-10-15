package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpression {
	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// Pointcut declaration for getter method
	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
	public void getter() {}
	
	// Pointcut declaration for getter method
	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
	public void setter() {}
		
	// Pointcut declaration for package ...exclude setter and getter
	@Pointcut("forDaoPackage() && !(getter() || setter()) ")
	public void forDaoPackageNoGetterSetter() {}
		

	
}
