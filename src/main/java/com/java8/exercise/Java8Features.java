package com.java8.exercise;

import java.util.Arrays;
import java.util.List;

public class Java8Features {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		double start=System.currentTimeMillis();
		for(int i: list)
		{
			System.out.println(i);
		}
		System.out.println("End complete : "+ (System.currentTimeMillis()-start));
		
		double starting=System.currentTimeMillis();
		
		
		list.stream().forEach(System.out::println);
		
		System.out.println("Completing : "+ (System.currentTimeMillis()-starting));
		/*System.out.println(list.stream()
								.filter(e-> e>1)
								.map(e-> e*2)
								.findFirst());
		*/
		
		/*Stream.of("Afwew","Badsd","Cfsdf")
		.sorted(
			(o1,o2) -> o2.compareTo(o1))
		.forEach(System.out::println);*/
	}

}
