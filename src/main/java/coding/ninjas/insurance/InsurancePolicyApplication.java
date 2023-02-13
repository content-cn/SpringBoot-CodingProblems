package coding.ninjas.insurance;

import coding.ninjas.insurance.Claim.Claim;
import coding.ninjas.insurance.Claim.InstantClaim;
import coding.ninjas.insurance.Claim.ReimbursementClaim;
import coding.ninjas.insurance.PolicyHolder.User;
import coding.ninjas.insurance.PolicyType.HealthCoverage;
import coding.ninjas.insurance.PolicyType.Policy;
import coding.ninjas.insurance.PolicyType.TermCoverage;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InsurancePolicyApplication {

    public static void main(String[] args) {

        SpringApplication.run(InsurancePolicyApplication.class, args);
        AnnotationConfigApplicationContext factory =new AnnotationConfigApplicationContext();
//
        System.out.println("Welcome to the Coding Ninja's Insurance.");
        System.out.println("To get started, enter user details.");
        User user=factory.getBean(User.class);

        Scanner sc=new Scanner(System.in);

        System.out.print("Username: ");
        String name=sc.next();
        user.setName(name);

        System.out.print("Age: ");
        Integer age=sc.nextInt();
        user.setAge(age);

        //Selecting Policy Type
        System.out.println("Select policy type (Enter H for HealthCoverage and T for TermCoverage):");
        String policyChoice=sc.next();

        if(policyChoice.equalsIgnoreCase("H"))
        {
            System.out.println("You have selected HealthCoverage.");
            user.setPolicy(factory.getBean(HealthCoverage.class));
        }
        else if(policyChoice.equalsIgnoreCase("T"))
        {
            System.out.println("You have selected TermCoverage.");
            user.setPolicy(factory.getBean(TermCoverage.class));
        }

        //Selecting Claim
        System.out.println("Do u want insurance claim?(Enter Y for yes and N for no)");
        String claimRequiredChoice=sc.next();

        if(claimRequiredChoice.equalsIgnoreCase("Y"))
        {

            System.out.println("Select claim type (Enter I for InstantClaim or R for Reimbursement Claim):");
            String claimChoice=sc.next();
            if(claimChoice.equalsIgnoreCase("I"))
            {
                System.out.println("You have selected InstantClaim.");
                user.setClaim(factory.getBean(InstantClaim.class));
            }
            else
            {
                System.out.println("You have selected ReimbursementClaim.");
                user.setClaim(factory.getBean(ReimbursementClaim.class));
            }
        }

        user.printDetails();

        System.out.println("Thank you for trusting Coding Ninja's for you service.");

        //Close context
         factory.close();

    }
}

