package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class); 
		
		// get the bean from spring container
		// tennisCoach -> default bean id
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);
		
		// call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(coach.getDailyFortune());
		
		// call our new swim coach methods ... has the props values injected
		System.out.println("email: " + coach.getEmail());
		System.out.println("team: "+ coach.getTeam());
		// close the context
		context.close();
	}

}
