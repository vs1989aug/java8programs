package com.java8.exercise;

public class ClassB implements Runnable{
	
	@Override 
	public void run()
	{
		House.display();
	}

}
