package com.concurrency;

public class PingPong {

	static volatile boolean isPinged;
	
	static Object obj = new Object();
	
	public static void main(String[] args) {
		
		Thread pingThread = new Thread(()->{
			while(true) {
				if(isPinged) {
					isPinged = false;
					System.out.println("Ping");
					obj.notify();
				}
				try {
					obj.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		Thread pongThread = new Thread(()->{
			while(true) {
				if(!isPinged) {
					isPinged = true;
					System.out.println("Pong");
					obj.notify();
				}
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		pingThread.start();
		pongThread.start();

	}

}
