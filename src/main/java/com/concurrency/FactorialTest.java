package com.concurrency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactorialTest {

	private static final int MAX = 20;
	public static void main(String[] args) {

		List<Long> numbers = numbers(MAX);
		ExecutorService executorService = Executors.newFixedThreadPool(numbers.size());
		Map<Long, Long> factorials = new HashMap<>();
		long startTime = System.currentTimeMillis();
		System.out.println("Starting program execution......"+startTime);
		factorialTasks(numbers).forEach(task -> {
			Future<Long> result = executorService.submit(task);
			if (result.isDone()) {
				try {
					factorials.put(task.getNumber(), result.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}

		});
		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Ending program execution......"+endTime);
		
		System.out.println("Total execution time: "+ (endTime-startTime));
		System.out.println("###############   Main thread finished   ############");

	}

	private static List<Long> numbers(int limit) {
		return Stream.iterate(1, i->i+1).limit(limit).map(j->new Long(j)).collect(Collectors.toList());
	}

	private static List<FactorialTask> factorialTasks(List<Long> numbers) {
		return numbers.stream().map(number -> new FactorialTask(number)).collect(Collectors.toList());
	}

}
