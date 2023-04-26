package com.codingninjas.InsuranceProject;

public class Customer {
	private String name;
	private int age;
	
	private Insurance insurance; 
	
	public void setCustomerDetails(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setInsurance(Insurance insurance){
		this.insurance = insurance; 
	}

	public Insurance getInsurence(){
		return this.insurance; 
	}
	
	public String getInsuranceDetails() {

		String insuranceName= insurance.getName(); 
		return "Hi, " +name +  " You have a " + insuranceName+ " premium of " + insurance.getInsurancePremium();
	}
	
}
