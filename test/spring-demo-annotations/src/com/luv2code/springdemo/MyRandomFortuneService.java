package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRandomFortuneService implements FortuneService {
	
	@Value("${listOfValues}")
	String[] randomFortunes;
	Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int rndIdx = myRandom.nextInt(randomFortunes.length);
		return randomFortunes[rndIdx];
	}

}
