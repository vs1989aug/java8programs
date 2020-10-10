package com.java8.exercise;

public class Annotation {
	
	@TestAnnotation(message="Changed") // Testing annotation
	public void display()
	{
		System.out.println("Method is using annotation.");
	}
	
}
