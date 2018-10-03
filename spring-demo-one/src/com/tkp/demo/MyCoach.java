package com.tkp.demo;

public class MyCoach implements Coach {

	private RandomFortuneService randomFortuneService;
	
	public MyCoach() {
		
	}
	public MyCoach(RandomFortuneService randomFortuneService) {
		this.randomFortuneService = randomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Running hard 5k";
	}

	@Override
	public String getDailyFotune() {
		// TODO Auto-generated method stub
		return randomFortuneService.getFortune();
	}

}
