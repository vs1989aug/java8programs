package com.java8.exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapSortByValue{
	
	public static void main(String[] args) {
		
		Map<String,String> unsorted=new HashMap<String,String>();
		unsorted.put("Ca", "Raw");
		unsorted.put("Ab", "Car");
		unsorted.put("Bc", "Bed");
		unsorted.put("De", "Killer");
		unsorted.put("Ef", "Rames");
		
		System.out.println("unsorted map : \n "+unsorted);
		
		Set<Map.Entry<String, String>> entries=unsorted.entrySet();
		List<Map.Entry<String,String>> entryList=new LinkedList<Map.Entry<String,String>>(entries);
		
		Collections.sort(entryList, new Comparator<Map.Entry<String,String>>() {

			@Override
			public int compare(Map.Entry<String,String> o1, Map.Entry<String,String> o2) {
				
				return o1.getValue().compareToIgnoreCase(o2.getValue());
			}
			
		});
		System.out.print(" {");
		for(Map.Entry<String, String> entry: entryList)
		{
			System.out.print(entry.getKey()+"="+entry.getValue()+", ");
		}
		System.out.print("}");
	}

}
