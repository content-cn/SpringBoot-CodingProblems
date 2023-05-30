package codingninjas.WeatherForecast;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class myUser implements User{

    String name;
    int age;

    @Autowired
    Location location;

    @Autowired
    WeatherForecast weatherForecast;

    @PostConstruct
    void init(){
        System.out.println("The user bean has been Instantiated I am init() method");
    }

    @PreDestroy
    void destroy(){
        System.out.println("The user bean has been destroyed I am destroy() method");
    }

    @Override
    public void setUserDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void setLocationDetails(String city, String state, String country) {
        this.location.setLocation(city, state, country);
    }

    @Override
    public void getWeatherForecastForLocation() {
        System.out.println("Hi " + this.name + " weather in your city " + location.getLocation() + " is " + weatherForecast.getWeather());

    }
}
