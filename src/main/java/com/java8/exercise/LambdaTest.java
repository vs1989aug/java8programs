package com.java8.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LambdaTest {
	
	
	public static void main(String[] args) {
		
		Function1 f1= (x,y) -> {return x+y;};
		System.out.println(f1.add("a", "b"));
		
		Function2 f2=new Function2();
		
		Function1 f3 = f2::add;
		System.out.println(f3.add("3", "4"));
		
		
		StringJoiner st=new StringJoiner(".");
		st.add("A");
		st.add("B");
		st.add("A");
		st.add("C");
		st.add("D");
		st.add("B");
		
	System.out.println(st);
	
	st.setEmptyValue("1");
	System.out.println(st);
	
	List<String> names=Arrays.asList("A","B","A","D","C","E");
	Map<String,Long> map=names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(map);
	
	
	}

	
	
	
	
}
