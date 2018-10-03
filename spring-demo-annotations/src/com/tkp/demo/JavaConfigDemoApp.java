package com.tkp.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
	// read spring config file
	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(SportConfig.class);
	//  get bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
	// call a method 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
	// close container
		context.close();
	}

}
