package com.tkp.demo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public TrackCoach() {
	
	}
	
	public  TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFotune() {
		// TODO Auto-generated method stub
		return "Just Do It: "+ fortuneService.getFortune();
	}
	// add an init method 
	public  void doMyStartupStuff() {
		System.out.println("Track Coach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	
	public  void doMyCleanup() {
		System.out.println("Track Coach: inside method doMyCleanup");
	}
}
