package com.java8.exercise;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Task3 {
	
	static ScheduledExecutorService service = Executors
            .newSingleThreadScheduledExecutor();
	static int i=0;
  public static void main(String[] args) {
	  
    Runnable runnable = new Runnable() {
      public void run() {
        // task to run goes here
        System.out.println("Executing.");
        i++;
        if(i==3)// Put any condition to prevent infinite loop of running this task
        service.shutdown();
      }
    };
    service.scheduleWithFixedDelay(runnable, 0, 2, TimeUnit.SECONDS);
    
  }
}