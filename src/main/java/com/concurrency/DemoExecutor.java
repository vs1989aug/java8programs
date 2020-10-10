package com.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
 
public class DemoExecutor
{
   public static void main(String[] args)
   {
      Integer threadCounter = 0;
      BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
      BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS, blockingQueue);
   
      // Let start all core threads initially
      executor.prestartAllCoreThreads();
      while (true)
      {
         threadCounter++;
         // Adding threads one by one
         System.out.println("Adding Demo Task: "+threadCounter);
         executor.execute(new DemoTask(threadCounter.toString()));
 
      }
   }
}