package com.java8.exercise;

import java.util.HashMap;
import java.util.Map;

public class Testing{
	
	public static void main(String[] args) {
		
		/*System.out.println("Count "+ getCount());
		Testing t=new Testing();
		System.out.println("Count : "+getCount());*/
		
		/*String str1="ABC";
		String str2=new String("ABC");
		System.out.println(str1==str2);
		System.out.println(str1.hashCode()==str2.hashCode());
		System.out.println(str1.equals(str2));
		System.out.println(str1.matches(str2));*/
		/*Parent p=new Parent();
		p.call();*/
		/*String e="1";
		System.out.println("1" != e ? true: false);*/
		
		
		int[] a= {1,2,4,6,7,3,8,9,10};
		int diff=4,index=0;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++)
			map.put(a[i],i);// put array's elements as key and element index as value
		for(int i=0;i<9;i++)
		{
				if(map.containsKey(a[i]+diff))
				{
					index=map.get(a[i]+diff);
					System.out.println(a[i]+","+a[index]);
				}
		}
	}

}
