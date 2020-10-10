package com.java8.exercise;

import java.util.Scanner;

public class Rental {
	
	public static void main(String[] args) {
		
		double estFare, distance;
		
		System.out.println("How many KMs do you want to travel?");
		try(Scanner sc=new Scanner(System.in);)
		{
			distance=sc.nextDouble();
			System.out.println("Calculating estimated fare.....");
			estFare=calculateFare(distance);
		}
		if(estFare<0)
		{
			System.out.println("Invalid distance entered.. Exiting...");
			System.exit(-1);
		}
		System.out.println("Estimated Fare is: "+estFare);
	}
	/**
	 * This method calculates and returns the estimated fare based on the distance(in Km) passed.
	 * @param distance
	 * @return
	 */
	public static double calculateFare(double distance)
	{
		//5 Rs/km upto 10 km and after that 2.5 Rs/km
		if(distance<0)
			return -1;
		if(distance==0)
			return 0;
		if(distance<=10)
			return distance*5;
		else
		{
			return (5*10+((distance-10)*2.5));
		}
	}
}
