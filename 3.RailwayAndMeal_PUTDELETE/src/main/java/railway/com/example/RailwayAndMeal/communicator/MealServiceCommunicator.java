package railway.com.example.RailwayAndMeal.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import railway.com.example.RailwayAndMeal.Entity.Meal;

@Service
public class MealServiceCommunicator {
	
	private final RestTemplate restTemplate;
	String baseURL = "http://localhost:8081/pantry";
	
	@Autowired
	MealServiceCommunicator(RestTemplateBuilder restTemplateBuilder){
		restTemplate = restTemplateBuilder.build();
	}
	
	public Meal getMealByPnr(long pnr) {
		String url = baseURL + "/meal/" + pnr;
		Meal meal = restTemplate.getForObject(url, Meal.class);
		return meal;
	}
	
	public void setMeal(Meal meal) {
		String url = baseURL + "/meal";
		restTemplate.postForEntity(url, meal, Object.class);
	}
	
	public void deleteMeal(Long pnr) {
		//use exchange() method from the RestTemplate to make 
		//a delete call to the given url.
	}
	
	public void updateMeal(Meal meal) {
		//use exchange() method from the RestTemplate to make 
		//a update call to the given url.
	}
	
}
