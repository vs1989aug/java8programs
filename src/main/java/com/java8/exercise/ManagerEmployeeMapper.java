package com.java8.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerEmployeeMapper {
	
	private static Map<String,String> input=new HashMap<String,String>();
	
	public static void main(String[] args) {
		
		input.put("A","C");
		input.put("B","C");
		input.put("C","F");
		input.put("D","E");
		input.put("E","F");
		input.put("F","F");
		
		Map<String, Integer> keyMap=new HashMap<String,Integer>();
		
		Map<String, Integer> results=new HashMap<String,Integer>();
		
		List<String> keys=new ArrayList<String>(input.keySet());
		for(String k: keys)
		{

			if(keyMap.containsKey(k))
				keyMap.put(k, keyMap.get(k)+1);
			else
				keyMap.put(k, 1);
		}
		
		
		Collection<String> col=input.values();
		
		for(String key: col)
		{
			if(keyMap.containsKey(key) && results.containsKey(key))
				results.put(key, keyMap.get(key)+results.get(key)+1);
			else if(keyMap.containsKey(key))
				results.put(key, keyMap.get(key));
			else
				results.put(key, 1);
		}
		System.out.println(results);
	}
	

}
