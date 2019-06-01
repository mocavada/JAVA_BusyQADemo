package com.busyqa.javademo.purejdbc.coursework;

import java.util.Scanner;


public class MainCourseWork {
	public static void main(String arg[]) {
		c();
	}

	public static void c() {

		String cityName = getUserInput("Please enther your city name:");
		String population = getUserInput("Please enter the poppucation of the city:");
		System.out.println("===write to database===");
		
		System.out.println("===read from database===");
		DBService.jdbc_insert(cityName, population);
	}

	public static void r() {

		String cityName = getUserInput("Please enther your city name to search:");

		System.out.println("===read from database===");
		DBService.read_prep(cityName);
	}

	public static void u() {

		int id = Integer.parseInt(getUserInput("Please enther your city id to update:"));
		DBService.searchCityByID(id);

		int population = Integer.parseInt(getUserInput("Please enther the population to update:"));
		System.out.println("===write to database===");
		DBService.jdbc_update(id, population);

	}
	
	
	public static void d() {

		int id = Integer.parseInt(getUserInput("Please enther your city id to delete:"));
		DBService.searchCityByID(id);

		String comfirm = getUserInput("Comfirm delete (Y/N):");
		
		if(comfirm.contains("Y")) {
			System.out.println("===write to database===");
			DBService.jdbc_delete(id);
		}else {
			DBService.searchCityByID(id);
		}


	}
	
	public static String getUserInput(String prompt) {
		System.out.println(prompt);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	
}
