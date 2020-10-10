package com.java8.exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageTaker {

	private String msg;
	boolean flag = true;
	final Object obj = new Object();
	final Lock lock = new ReentrantLock();
	/*
	 * public MessageTaker(String msg) { this.msg=msg; }
	 */

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public synchronized void display(String m) {
		flag = true;

		while (flag) {
			synchronized (this) {
				if (m.equals("ping")) {
					System.out.println(m);
					obj.notify();
				} else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(m);
				}
			}

		}

	}
}
