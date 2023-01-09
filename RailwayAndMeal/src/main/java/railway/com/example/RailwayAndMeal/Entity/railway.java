package railway.com.example.RailwayAndMeal.Entity;

public class railway {
	public long id;
	public String name;
	public long age;
	public long pnr;
	public String birth;
	public meal mealEntity;
	
	public railway(long id, String name, long age, long pnr, String birth) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.pnr = pnr;
		this.birth = birth;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
}
