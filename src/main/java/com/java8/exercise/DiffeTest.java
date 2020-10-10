package com.java8.exercise;

import java.util.ArrayList;
import java.util.List;

public class DiffeTest {
	
	public static void main(String[] args) {
		
		int[] input= {1,4,7,9,14,19,12};
		int diff=7;
		List<String> pairs=findPairs(input, diff);
		pairs.stream().forEach(System.out::println);
	}

	private static List<String> findPairs(int[] input, int diff) {
		
		List<String> pairs=new ArrayList<String>();
		
		for(int i=0;i<input.length;i++)
		{
			for(int j=i+1;j<input.length;j++)
			{				
				if((input[i]-input[j]==diff)||(input[j]-input[i]==diff))
					pairs.add(input[i]+","+input[j]);
			}
		}
		return pairs;
	}

}
