package com.java8.exercise;

public class ClassA implements Runnable{
	House h;
	public ClassA(House house) {
		h=house;
	}

	@Override
	public void run()
	{
		h.displayNum();
	}
}
