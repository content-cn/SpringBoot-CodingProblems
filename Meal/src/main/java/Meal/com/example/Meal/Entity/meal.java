package Meal.com.example.Meal.Entity;

public class meal {
	public long id;
	public long pnr;
	public String mealType;
	public boolean premium;
	public String mealTime;
	

	
	public meal(long id, long pnr, String mealType, boolean premium, String mealTime) {
		super();
		this.id = id;
		this.pnr = pnr;
		this.mealType = mealType;
		this.premium = premium;
		this.mealTime = mealTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public String getMealTime() {
		return mealTime;
	}
	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}
	
	
	

}
