package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		
		// call method to find the accounts
		try {
			// add a boolean flag t o simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println();
		
		// close the context
		context.close();
	}

}