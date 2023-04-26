package com.codingninjas.InsuranceProject;

public class TermInsurance implements Insurance {
	private boolean isMarried;
	private boolean hasChildren;
	private boolean isSalaried;
	private double insurance = 5000;
	
	public double getInsurancePremium() {
		return insurance;
	}
	
	public void setInsuranceDetails(boolean isMarried, boolean hasChildren, boolean isSalaried) {
		double premium = 0;
		
		this.isMarried = isMarried;
		this.hasChildren = hasChildren;
		this.isSalaried = isSalaried;
		
		if(isMarried)
			premium += 1.5*insurance;
		if(hasChildren)
			premium += 2*insurance;
		if(!isSalaried)
			premium += 1.5*insurance;
		
		insurance += premium;
}

	@Override
	public String getName() {
		return " Term Insurance"; 
	}

}
