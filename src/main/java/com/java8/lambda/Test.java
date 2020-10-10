package com.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

interface Interf{
public int product(int a,int b);
}

public class Test {

	public static void main(String[] args) {
		
			List<Integer> numbers = Arrays.asList(1,6,3,4,2);
			try(Scanner sc = new Scanner(System.in)){
				System.out.println("Enter which largest element to be find.");
				int nthLargest = sc.nextInt();
				Integer seccondLargest = numbers.stream().sorted().collect(Collectors.toList()).get(numbers.size()-nthLargest);
				System.out.println(seccondLargest);
			}
			
		
	}
}
