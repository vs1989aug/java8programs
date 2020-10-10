package com.concurrency;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) {
		/*
		 * int numberOfThreads = 5; //or any number you'd like
		 * 
		 * List<Thread> threads = new ArrayList<>();
		 * 
		 * Barrier barrier = new Barrier(numberOfThreads); for (int i = 0; i <
		 * numberOfThreads; i++) { threads.add(new Thread(new
		 * CoordinatedWorkRunner(barrier))); }
		 * 
		 * for(Thread thread: threads) { thread.start(); }
		 */
		
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();

		User user = new User();
		UIThread ui = new UIThread(user, lock, condition);
		Authentication authentication = new Authentication(user, lock, condition);
		ui.start();
		authentication.start();
	}

	public static class User {
		private String userName;
		private String password;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

	public static class UIThread extends Thread {

		private Lock lock;
		private Condition condition;
		private User user;

		public UIThread(User user, Lock lock, Condition condition) {
			this.user = user;
			this.condition = condition;
			this.lock = lock;
		}

		@Override
		public void run() {
			lock.lock();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try (Scanner sc = new Scanner(System.in);) {
				System.out.println("User name?");
				user.setUserName(sc.next());
				System.out.println("Password?");
				user.setPassword(sc.next());
				System.out.println("Notifying authentication thread........");
				condition.signal();
			}
			lock.unlock();

		}
	}

	public static class Authentication extends Thread {

		private Lock lock;
		private Condition condition;
		private User user;

		public Authentication(User user, Lock lock, Condition condition) {
			this.user = user;
			this.condition = condition;
			this.lock = lock;
		}

		@Override
		public void run() {
			lock.lock();
			if (user.getUserName() == null || user.getPassword() == null) {
				try {
					System.out.println("Waiting for user name and password.");
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Authentication thread is authenticating credentials.....");
			if (user.getUserName().equalsIgnoreCase("test") && user.getPassword().equalsIgnoreCase("test")) {
				System.out.println("Correct user name and password.");
			}else
			System.out.println("InCorrect user name and password.");
			lock.unlock();

		}
	}
}
