package com.java8.exercise;

public interface IVehicle {
	
	default void move()
	{
		System.out.println("I am moving");
	}
	
	static void display()
	{
		System.out.println("Display the features.");
	}
	

}
