package com.java.accountapi;

public class TaskDefinition {

	public synchronized void displayTask(String taskType)
	{
		System.out.println("Executing the task: "+taskType);
	}
}
