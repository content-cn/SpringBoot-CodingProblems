package codingninjas.WeatherForecast;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class myLocation implements Location{

    private String city;
    private String state;
    private String country;

    @PostConstruct
    void init(){
        System.out.println("The location bean has been Instantiated I am init() method");
    }

    @Override
    public void setLocation(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String getLocation() {
        return this.city;
    }


}
