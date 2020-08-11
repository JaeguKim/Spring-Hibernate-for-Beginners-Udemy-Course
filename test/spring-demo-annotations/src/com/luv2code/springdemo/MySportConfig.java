package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;

public class MySportConfig {
	@Bean
	public FortuneService myFortuneService() {
		return new MyFortuneService();
	}
	
	@Bean
	public BaseballCoach baseballCoach() {
		return new BaseballCoach(myFortuneService());
	}
}
