package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	private String[] fortunePool = {"RandomFortune-1","RandomFortune-2","RandomFortune-3"};
	@Override
	public String getFortune() {
		int rnd = new Random().nextInt(fortunePool.length);
		return fortunePool[rnd];
	}

}
