package com.java.accountapi;

public class TaskTest {
	
	public static void main(String[] args) {
		
		TaskDefinition def=new TaskDefinition();
		
		Thread t1=new Thread(new Task2Play("Playing Cricket",def));
		Thread t2=new Thread(new Task2Study("Studying",def));
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
	}

}
