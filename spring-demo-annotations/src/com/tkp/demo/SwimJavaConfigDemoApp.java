 package com.tkp.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
	// read spring config file
	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(SportConfig.class);
	//  get bean from spring container
	SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
	// call a method 
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("email :" + theCoach.getEmail());
		
		System.out.println("team :" + theCoach.getTeam());
	// close container
		context.close();
	}

}
