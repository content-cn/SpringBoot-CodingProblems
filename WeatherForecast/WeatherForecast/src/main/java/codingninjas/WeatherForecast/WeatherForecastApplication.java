package codingninjas.WeatherForecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class WeatherForecastApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("codingninjas.WeatherForecast");
		System.out.println("Welcome to Weather Application");
		User user = context.getBean(User.class);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Enter your age: ");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		System.out.println("Enter your city: ");
		String city = scanner.nextLine();
		System.out.println("Enter your state: ");
		String state = scanner.nextLine();
		System.out.println("Enter your country: ");
		String country = scanner.nextLine();
		user.setUserDetails(name, age);
		user.setLocationDetails(city, state, country);
		user.getWeatherForecastForLocation();
		context.close();
		scanner.close();
	}

}
