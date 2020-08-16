package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class CRUDEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			/* CREATE 
			// create a student object
			System.out.println("Creating new employee object...");
			Employee tempEmployee = new Employee("Paul","wall","Google Inc");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object			
			System.out.println("Saving the employee...");
			session.save(teeeeeeeeeempEmployee);
			*/
			
			/*READ
			int id = 1;
			
			session.beginTransaction();
			Employee tempEmployee = session.get(Employee.class, id);
			System.out.println("Get Complete : "+tempEmployee);
			
			// query students: company='Google Inc'
			System.out.println("Finding Employee of Google Inc");
			List<Employee> theEmployees = session.createQuery("from Employee e where e.company='Google Inc'").getResultList();
			displayEmployees(theEmployees);
			*/
			
			int id = 1;
			session.beginTransaction();
			Employee tempEmployee = session.get(Employee.class, id);
			session.delete(tempEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}
	
	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}
}
