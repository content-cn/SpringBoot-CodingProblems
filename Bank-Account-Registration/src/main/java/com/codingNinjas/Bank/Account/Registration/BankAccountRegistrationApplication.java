package com.codingNinjas.Bank.Account.Registration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("Welcome to Account Registration Application!");
		Scanner scanner = new Scanner(System.in);

		User user = (User) context.getBean("user");
		System.out.println("Please enter Your name?");
		String name = scanner.nextLine();
		user.setUserDetails(name);
		System.out.println("Do you want to add account \n1. Yes \n2. No");
		int choice = scanner.nextInt();
		if(choice == 2){
			System.exit(0);
		}
		else {
			while (true) {
				System.out.println("Please select the account type \n1. Current \n2. Savings");
				int accountChoice = scanner.nextInt();
				String accountType = "";
				switch (accountChoice) {
					case 1 -> accountType = "currentAccount";
					case 2 -> accountType = "savingsAccount";
					default -> {
						System.out.println("Invalid choice...");
						return;
					}
				}
				Account account = (Account) context.getBean(accountType);
				System.out.println("Enter the opening balance");
				double balance = scanner.nextDouble();
				account.addBalance(balance);
				user.addAccount(account);
				System.out.println("Do you want to add more accounts\n1. Yes\n2. No");
				int userChoice = scanner.nextInt();
				if(userChoice == 2) break;
			}
		}
		System.out.println("Hi " + user.getName() +", here is the list of your accounts:");
		for(Account account : user.getAllAccounts()){
			System.out.println(account.getAccountType() + " : opening balance - " + account.getBalance() + " Reference Id " + account.toString().substring(57 , 66));
		}
	}

}
