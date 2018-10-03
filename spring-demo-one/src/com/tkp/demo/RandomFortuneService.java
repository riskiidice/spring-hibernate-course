package com.tkp.demo;
import java.util.Random;
public class RandomFortuneService implements FortuneService {
 
	private String[] fortune = {"Lucky", "Good", "The Best"};
	
	
	@Override
	public String getFortune() {
		Random r = new Random();
		int randomNum = r.nextInt(fortune.length);
		return fortune[randomNum];
	}

}
