package com.tkp.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
	// read spring config file
	ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
	//  get bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
	// call a method 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
	// close container
		context.close();
	}

}
