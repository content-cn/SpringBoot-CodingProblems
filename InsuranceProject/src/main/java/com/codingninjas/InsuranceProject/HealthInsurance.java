package com.codingninjas.InsuranceProject;

public class HealthInsurance implements Insurance {
	
	private boolean isDrinker;
	private boolean isSmoker;
	private boolean previousConditions;
	private double insurance = 10000;
	
	public double getInsurancePremium() {
		return insurance;
	}

	@Override
	public String getName() {
		return "Health Insurance"; 
	}
	
	public void setInsuranceDetails(boolean isDrinker, boolean isSmoker, boolean previousConditions) {
			double premium = 0;
			
			if(isDrinker)
				premium += 1.5*insurance;
			if(isSmoker)
				premium += 1.5*insurance;
			if(previousConditions)
				premium += 2*insurance;
			
			insurance += premium;
	}

	
}
