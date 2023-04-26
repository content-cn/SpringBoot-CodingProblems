package com.codingninjas.InsuranceProject;

import java.util.Scanner;

import org.springframework.aot.generate.GenerationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class InsuranceProjectApplication {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
		
		System.out.println("Welcome to Insurance Application");
		
		System.out.println("What is your name?");
		String name = sc.nextLine();
		System.out.println("What is your age?");
		int age = sc.nextInt();
		
		
		
		System.out.println("Which Insurance do you want?");
		System.out.println("Select 1 or 2 from Below Options");
		System.out.println("1 - Health Insurance");
		System.out.println("2 - Term Insurance");
		int insuranceChoice = sc.nextInt();
		
		
		String insuranceName = ""; 
		boolean m1 = false; 
		boolean m2 = false; 
		boolean m3 = false; 
		
		if(insuranceChoice == 1) {
			System.out.println("You have chosen Health Insurance.");
			insuranceName = "HealthInsurance"; 
			System.out.println("Are you a Drinker? Y or N");
			boolean drinker = sc.next().charAt(0) == 'Y' ? true : false;
			System.out.println("Are you a Smoker? Y or N");
			boolean smoker = sc.next().charAt(0) == 'Y' ? true : false;
			System.out.println("Do you have any prior health conditions? Y or N");
			boolean previousConditions = sc.next().charAt(0) == 'Y' ? true : false;
			
			m1= drinker; 
			m2= smoker; 
			m3=previousConditions; 
		}
		else if(insuranceChoice == 2) {
			System.out.println("You have chosen Term Insurance.");
			insuranceName = "TermInsurance"; 
			System.out.println("Are you a Married? Y or N");
			boolean married = sc.next().charAt(0) == 'Y' ? true : false;
			System.out.println("Do you have children? Y or N");
			boolean children = sc.next().charAt(0) == 'Y' ? true : false;
			System.out.println("Are you salaried? Y or N");
			boolean isSalaried = sc.next().charAt(0)  == 'Y' ? true : false;
			
			m1= married; 
			m2= children; 
			m3=isSalaried; 
		}

		Customer customer = (Customer) context.getBean("customer"+ insuranceName);
		customer.setCustomerDetails(name, age);
		
		Insurance myInsurance = (Insurance) context.getBean(insuranceName); 
		myInsurance.setInsuranceDetails(m1, m2, m3);

		System.out.println(customer.getInsuranceDetails());
		
	}

}
