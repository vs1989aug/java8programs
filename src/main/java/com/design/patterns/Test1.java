package com.design.patterns;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

	public Lock lock = new ReentrantLock();
	boolean isThead2Completed = false;

	public static void main(String[] args) {
		Test1 t=new Test1();
		Object obj=new Object();
		Runnable R1 = new Runnable() {

			@Override
			public void run() {

				if(t.isThead2Completed)
					t.display();
				else {
					try {
						obj.wait();
						t.display();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		};
		Runnable R2 = new Runnable() {

			@Override
			public void run() {

				
				t.display();
				t.isThead2Completed = true;
				obj.notify();
				

			}
		};

		Thread t1 = new Thread(R1, "Thread1");
		Thread t2 = new Thread(R2, "Thread2");
		t1.start();
		t2.start();

	}

	public void display() {
			System.out.println("Happy Learning.");
	}
	}
