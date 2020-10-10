package com.java8.exercise;

import java.util.LinkedList;
import java.util.List;

public class NumberArranger {
	
	public static void main(String[] args) {
		int[] input= {-1,-4,4,3,2,1,-3,-2};
		
		printSequence(input);
	}

	private static void printSequence(int[] input) {
		List<Integer> positive=new LinkedList<Integer>();
		List<Integer> negative=new LinkedList<Integer>();
		
		for(int i=0;i<input.length;i++)
		{
			if(input[i]>0)
				positive.add(input[i]);
			else
				negative.add(input[i]);
			
		}
		
		for(int i=0;i<input.length;i++)
		{
			if(positive.size()>i)
				System.out.print(positive.get(i)+",");
			if(negative.size()>i)
				System.out.print(negative.get(i)+",");
		}
		
	}

}
