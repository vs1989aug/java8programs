package com.java8.exercise;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Tengleton Design pattern which will return only 10 objects and after that it will return null if the eleventh request comes. Its like Singleton Design pattern in which only one object is created.
public class TengletonPattern {

	//private static volatile int counter = 0;// Take the counter as volatile so that the updated value can be read among threads
	private static AtomicInteger counter=new AtomicInteger(0); // Take the counter as Atomic Integer so that the updated value can be read among threads
	public static AtomicInteger objectValue=new AtomicInteger(0);// Take this filed in order to differentiate the different objects after object creation

	private TengletonPattern() {
		objectValue.incrementAndGet();
	}

	public static TengletonPattern getInstance() {
		final Lock lock = new ReentrantLock();
		TengletonPattern tengleton;
		lock.lock();
		if (counter.getAndIncrement() < 10) {
			lock.lock();
			tengleton = new TengletonPattern();
			//counter++;
			lock.unlock();
		} else {
			tengleton=null;
			objectValue.getAndSet(0);
		}
		lock.unlock();
		return tengleton;
	}
	
}
