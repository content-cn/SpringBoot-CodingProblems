package codingninjas.WeatherForecast;

public interface User {
    void setUserDetails(String name, int age);

    void setLocationDetails(String city, String state, String country);

    void getWeatherForecastForLocation();
}
