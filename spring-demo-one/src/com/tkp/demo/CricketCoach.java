package com.tkp.demo;

public class CricketCoach implements Coach {

	private FortuneService fortuneservice;
	
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	public void setFortuneservice(FortuneService fortuneservice) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneservice = fortuneservice;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFotune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}

}
