package railway.com.example.RailwayAndMeal.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import railway.com.example.RailwayAndMeal.Entity.meal;

@Service
public class communicator {
	
	public String url="http://localhost:8081/pantry";
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();

//	    @Autowired
//	    public communicator(RestTemplateBuilder builder) {
//	        this.restTemplate = builder.build();
//	    }
	    public meal getMealInfo(long id)
	    {

	    	String ur2=url+"/meal";
	    	meal ans =new meal();

	        try {
	  ans= restTemplate.getForObject(ur2+"/" + String.valueOf(id), meal.class);
	        }catch(Exception e) {
	        	System.out.println("error");
	        }
	        System.out.println(ans);
	        return ans;
	    }
	    public List<meal> getMealInfos()
	    {

	    	String ur2=url+"/meals";
	    	List<meal> ans=new ArrayList<>();

	        try {
	  ans= restTemplate.getForObject(ur2  , List.class);
	        }catch(Exception e) {
	        	System.out.println("error");
	        }
//	        System.out.println(ans);
	        return ans;
	    }
	    public void addMealInfo(meal obj)
	    {

	    	String ur2=url+"/meal";
	    	

	        try {
	        	restTemplate.postForObject(ur2, obj, Object.class);
	        }catch(Exception e) {
	        	System.out.println("error");
	        }
//	        System.out.println(ans);
	       
	    }
	    
	    public void updateMealInfo(meal obj,long id)
	    {

	    	String ur2=url+"/meal/"+String.valueOf(id);
	    	

	        try {
	        	HttpEntity<meal> request=new HttpEntity<>(obj);
	        	restTemplate.exchange(ur2, HttpMethod.PUT, request, Object.class);

	        }catch(Exception e) {
	        	System.out.println("error");
	        }
//	        System.out.println(ans);
	       
	    }
	    
	    
	    public void deleteMealInfo(long id)
	    {

	    	String ur2=url+"/meal/"+String.valueOf(id);
	    	

	        try {
	        	restTemplate.exchange(ur2, HttpMethod.DELETE, null, Object.class);

	        }catch(Exception e) {
	        	System.out.println("error");
	        }
//	        System.out.println(ans);
	       
	    }
	    

	
}
