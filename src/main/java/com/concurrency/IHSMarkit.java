package com.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * This Code behaves inconsistently since if main thread finishes before background thread starts, this program terminates
 * But if main thread could not finish before background thread starts execution, program will go in infinite loop
 * @author vivsharm7
 *
 */
public class IHSMarkit {
	private static boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {

	Thread backgroundThread = new Thread(() -> {

	int i = 0;

	while (!stopRequested)

	i++;
	System.out.println(i);

	});
	
	backgroundThread.start();

	TimeUnit.SECONDS.sleep(1);

	stopRequested = true;

	}
}
