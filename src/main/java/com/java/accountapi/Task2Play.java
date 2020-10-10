package com.java.accountapi;

public class Task2Play implements Runnable {
	
	String task1;
	TaskDefinition def;
	
	public Task2Play(String task1, TaskDefinition def) {
		this.task1=task1;
		this.def=def;
	}
	

	@Override
	public void run() {
		def.displayTask(this.task1);
		

	}

}
