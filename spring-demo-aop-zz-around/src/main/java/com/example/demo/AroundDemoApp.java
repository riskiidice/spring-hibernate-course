package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.DemoConfig;
import com.example.demo.service.TrafficFortuneService;

@SpringBootApplication
public class AroundDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp ");
		
		System.out.println("Calling getFortune()");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy Fortune is :"+data);
		
		System.out.println("Finished");
		
		context.close();
	}
}
