package com.example.TastyTrove;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TastyTroveApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.TastyTrove");
		System.out.println("Welcome to Tasty Trove Application");

		// Enter User details
		System.out.println("Enter your name?");
		String name = scanner.nextLine();

		//Recipe Selection
		System.out.println("Select Recipe:\n1. North Indian\n2. South Indian\n3. Chinese");
		int recipeTypeChoice = scanner.nextInt();
		String recipeChoice = null;

		switch (recipeTypeChoice) {
			case 1 -> recipeChoice = "northIndian";
			case 2 -> recipeChoice = "southIndian";
			case 3 -> recipeChoice = "chinese";
			default -> {
				System.out.println("Invalid choice. Exiting...");
				System.exit(0);
			}
		}
		Recipe myRecipe = (Recipe) context.getBean(recipeChoice);
		// Ingredient Selection
		System.out.println("Select Ingredient:\n1. Lentils\n2. Rice\n3. Wheat");
		int ingredientTypeChoice = scanner.nextInt();
		String myIngredient = null;

		switch (ingredientTypeChoice) {
			case 1 -> myIngredient ="Lentils";
			case 2 -> myIngredient = "Rice";
			case 3 -> myIngredient = "Wheat";
			default -> {
				System.out.println("Invalid choice. Exiting...");
				System.exit(0);
			}
		}

		myRecipe.setIngredients(myIngredient);
		myRecipe.setUserName(name);
		myRecipe.getDetails();
		context.close();
		scanner.close();
	}

}