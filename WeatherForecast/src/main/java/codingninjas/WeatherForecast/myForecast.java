package codingninjas.WeatherForecast;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class myForecast implements WeatherForecast{

    @Override
    public String getWeather() {
        String forecasts[] = {"Sunny", "Cloudy", "Rainy", "Windy", "Snowy"};
        Random random = new Random();
        int index = random.nextInt(forecasts.length);
        return forecasts[index];
    }
}
