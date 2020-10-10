package com.java8.exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounterResource {

	int count=0;
	final Lock lock=new ReentrantLock();
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static SharedCounter getSc() {
		return sc;
	}
	final static SharedCounter sc=new SharedCounter();
	public void increase()
	{
		lock.lock();
		this.count=this.getCount()+10;
		lock.unlock();
	}

}
