package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.example.demo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void logTocloudAsync() {
		System.out.println("\n=========>>> Logging to Cloud in async fashion");
	}
}
