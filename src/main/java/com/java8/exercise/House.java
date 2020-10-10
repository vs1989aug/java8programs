package com.java8.exercise;

public class House {
	
	public synchronized static void display()
	{
		System.out.println(Thread.currentThread().getName()+" is sleeping");
		try
		{
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" is executing");
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" is terminated.");
	}

	public synchronized void displayNum()
	{
		System.out.println(Thread.currentThread().getName()+" is executing");
		
		for(int i=1;i <15; i++)
		{
			try
			{
				Thread.sleep(1000);
				System.out.println(i);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" is terminated.");
	}
}
