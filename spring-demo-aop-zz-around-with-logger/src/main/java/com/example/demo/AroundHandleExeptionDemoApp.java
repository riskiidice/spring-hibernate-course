package com.example.demo;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.DemoConfig;
import com.example.demo.service.TrafficFortuneService;

@SpringBootApplication
public class AroundHandleExeptionDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundDemoApp.class.getName());
	

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp ");
		
		myLogger.info("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy Fortune is :"+data);
		
		myLogger.info("Finished");
		
		context.close();
	}
}
