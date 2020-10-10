package com.java8.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pyramid {
	
	public static void main(String[] args) {
		
		int[] input= {1,4,5,6,7,8};
		int[] output=createPyramid(input);
		
		for(int i=0;i<output.length; i++)
		{
			System.out.print(output[i]);
			if(i<output.length-1)
				System.out.print(",");
		}
	}

	private static int[] createPyramid(int[] input) {
		
		int start=0;
		int end=3;
		
		while(start<input.length)
		{
			Map<String,Integer> m =findElements(input[start],input[start+1],input[start+2]);
			input[start]=m.get("left");
			input[start+1]=m.get("mid");
			input[start+2]=m.get("right");
			start=end;
			end=start+3;
		}
		return input;
	}

	private static Map<String,Integer> findElements(int a, int b, int c) {
		
		Map<String,Integer> m=new HashMap<String,Integer>();
		
		int middle=0,small=0,large=0;
		List<Integer> list=new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		list.add(c);
		
		IntSummaryStatistics stats=list.stream().collect(Collectors.summarizingInt(Integer::intValue));
		small=stats.getMin();
		large=stats.getMax();
		
		for(int i=0;i<3;i++)
		{
			if(!(list.get(i) == small || list.get(i) == large))
				middle=list.get(i);
		}
		m.put("mid", large);
		m.put("left", small);
		m.put("right", middle);
		
		return m;
	}

}
