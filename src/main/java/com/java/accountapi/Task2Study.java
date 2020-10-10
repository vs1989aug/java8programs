package com.java.accountapi;

public class Task2Study implements Runnable {
	

	String task2;
	TaskDefinition def;
	
	public Task2Study(String task2, TaskDefinition def) {
		this.task2=task2;
		this.def=def;
	}
	

	@Override
	public void run() {
		def.displayTask(this.task2);


	}


}
