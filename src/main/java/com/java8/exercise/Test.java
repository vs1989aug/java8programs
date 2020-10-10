//This application finds the n most frequent words in a list of words.

package com.java8.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class WordCountServer {

	static Map<String, Integer> wordsInfo = new HashMap<String, Integer>();
	static Lock lock1 = new ReentrantLock();

	/**
	 * This method manages the list of words in a map with Word as a key and word's
	 * frequency as value.
	 * 
	 * @param words
	 */
	public static void addWords(List<String> words) {
		lock1.lock();
		for (String word : words) {
			if (wordsInfo.containsKey(word)) {
				wordsInfo.put(word, wordsInfo.get(word) + 1);
			} else
				wordsInfo.put(word, 1);
		}
		lock1.unlock();
	}

	/**
	 * This method returns n most frequent words from the list of words. n represent
	 * the number of most frequent words
	 * 
	 * @param n
	 * @return
	 */
	public static List<String> getFrequentWords(int n) {
		lock1.lock();
		try {
			if (n > wordsInfo.size())
				throw new LargeNumberofRequestedWordsException(
						"Number of words requested is larger than the words present. Please request less than or equal to "
								+ wordsInfo.size() + " number of words.");
			Set<Map.Entry<String, Integer>> entrySet = wordsInfo.entrySet();
			List<String> frequentWords = new ArrayList<String>();

			List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(entrySet);

			Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {

				@Override
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			int counter = 1;
			for (Map.Entry<String, Integer> entry : entryList) {
				if (counter <= n) {
					frequentWords.add(entry.getKey());
					counter++;
				} else
					break;

			}
			lock1.unlock();
			return frequentWords;
		} catch (LargeNumberofRequestedWordsException e) {
			e.printStackTrace();
			lock1.unlock();
			return null;
		}

	}

}

public class Test {
	public static void main(String[] args) {
		List<String> words = new LinkedList<String>();
		words.add("Hello");
		words.add("Hello");
		words.add("Hi");
		words.add("He");
		words.add("Hi");
		words.add("Hel");
		words.add("Hel");
		words.add("Hi");
		words.add("Hello");
		words.add("Hellok");
		words.add("Hellok");
		words.add("Hellok");
		words.add("Hellok");
		words.add("Hellok");
		words.add("Hellok");
		words.add("Hellok");
		words.add("Hellok");

		Thread task1 = new Thread(new Runnable() {
			@Override
			public void run() {
				WordCountServer.addWords(words);
			}
		});

		Thread task2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter how many recent words you want?");
				List<String> frqWords = WordCountServer.getFrequentWords(sc.nextInt());
				if (null != frqWords) {
					for (String str : frqWords)
						System.out.println(str);
				}
				sc.close();
			}
		});
		try {
			task1.start();
			task1.join();
			task2.start();
			task2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		 * List<Runnable> jobs=new LinkedList<Runnable>(); jobs.add(task1);
		 * jobs.add(task2);
		 * 
		 * ExecutorService service=Executors.newFixedThreadPool(2); for(Runnable
		 * task:jobs) { service.submit(task); } service.shutdown();
		 */
	}
}
