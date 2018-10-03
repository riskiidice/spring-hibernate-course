package com.tkp.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {
	
	public static void main(String[] args) {
		
	// read spring config file
	ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
	//  get bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
	
		boolean result = (theCoach == alphaCoach);
		
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		
		System.out.println(result);
	// close container
		context.close();
	}
	
}
