package codingninjas.VaccineWithAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class VaccineWithAnnotationApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(VaccineWithAnnotationApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Vaccination Application");
        while (true) {
            System.out.println("Whom do you want to vaccinate");
            System.out.println("1. Father\n2. Mother\n3. Self\n4. Spouse\n5. Exit");
            String userType;
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1 -> userType = "Father";
                case 2 -> userType = "Mother";
                case 3 -> userType = "Self";
                case 4 -> userType = "Spouse";
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }
            User user = (User) context.getBean(userType);
            if (user.IsVaccinated()) {
                System.out.println("User is already Vaccinated");
            } else {
                System.out.println("Please choose your vaccine type:");
                System.out.println("1. Covaxin\n2. Covishield\n3. Moderna");
                int vaccineChoice = scanner.nextInt();
                scanner.nextLine();

                String myVaccine;
                switch (vaccineChoice) {
                    case 1 -> myVaccine = "Covaxin";
                    case 2 -> myVaccine = "Covishield";
                    case 3 -> myVaccine = "Moderna";
                    default -> {
                        System.out.println("Invalid choice.");
                        return;
                    }
                }
                user.setVaccine(myVaccine);
                System.out.println("Please enter " + userType + " details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

//		        Getting appointment details
                System.out.print("Appointment date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Appointment time (HH:MM AM/PM): ");
                String time = scanner.nextLine();
                System.out.print("Appointment location: ");
                String location = scanner.nextLine();

                TimeAndLocation timeAndLocation = context.getBean(TimeAndLocation.class);
                timeAndLocation.setDetails(time, date, location);
                user.setUserDetails(name, age, timeAndLocation);
                user.setAppointment();
            }
            System.out.println("Do you want to register for someone Else");
            System.out.println("1. Yes\n2. No");
            int input = scanner.nextInt();
            if (input == 2){
				System.out.println("Exiting Application...");
            	break;
            }
        }
        scanner.close();
    }

}
