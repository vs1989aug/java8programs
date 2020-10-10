package com.java8.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TengletonPatternTest {
	
	public static void main(String[] args) {

		Runnable task=new Runnable() {
			TengletonPattern t;
			
			@Override
			public void run() {
				 t=TengletonPattern.getInstance();
				System.out.println(t+": "+TengletonPattern.objectValue);
			}
		};
	
		ExecutorService service=Executors.newFixedThreadPool(11);
		for(int i=0;i<11;i++)
		{
			service.execute(task);
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		service.shutdown();
	}


}
