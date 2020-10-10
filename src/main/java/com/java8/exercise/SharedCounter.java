package com.java8.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedCounter {
	
	public static void main(String[] args) {
				SharedCounterResource sc=new SharedCounterResource();
/*				final Lock lock=new ReentrantLock();*/
				ExecutorService e=Executors.newFixedThreadPool(10);
				for(int i=1;i<=10;i++) {
					Runnable task= new Task(sc);
					e.submit(task);}
							
				e.shutdown();
				//Below condition will keep executor service to wait until all threads finish their jobs and terminated. This is always necessary to wait until all the jobs are finished.
				while (!e.isTerminated()) {
							}
				System.out.println("Final count value: "+sc.getCount());
	}
	
	
}

class Task implements Runnable
{
	SharedCounterResource sc;
	public Task(final SharedCounterResource sc2) {
		this.sc=sc2;
	}

	@Override
	public void run() {
		sc.increase();
		//System.out.println("Counter value: "+sc.getCount());
	}
	}
