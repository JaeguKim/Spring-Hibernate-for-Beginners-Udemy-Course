package com.luv2code.springdemo;

public class MyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "TODAY IS LUCKY DAY!";
	}

}
