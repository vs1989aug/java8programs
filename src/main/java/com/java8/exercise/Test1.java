package com.java8.exercise;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {

		/*MessageTaker mt=new MessageTaker();
		Task1 task1=new Task1(mt,"ping");
		Task1 task2=new Task1(mt,"pong");
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		t1.start();
		t2.start();*/
		
		/*String[] words= {"practice", "makes", "perfect", "coding", "made"};
		Map<String, Integer> m=new HashMap<String,Integer>();
		for(int i=0;i<words.length;i++)
		{
				m.put(words[i], i);
		}
		
		int distance=findDistance(m,"makes", "perfect");*/
		
		int[] nums={2, 7, 11, 15}; int target=9;

		int[] x=twoSum(nums, target);
		
		System.out.println("Pair is : "+x[0]+","+x[1]);
	}

	/*private static int findDistance(Map<String,Integer> m,String string1, String string2) {
		
		return m.get(string2)-m.get(string1);
		
	}*/
	
	public static int[] twoSum(int[] nums, int target) {
	    if(nums==null || nums.length<2)
	        return new int[]{0,0};
	
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(map.containsKey(nums[i])){
	            return new int[]{map.get(nums[i]), i};
	        }else{
	            map.put(target-nums[i], i);
	        }
	    }
	
	    return new int[]{0,0};
	}

	/*public static String[] allSwap(String[] strings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
		String key = String.valueOf(strings[i].charAt(0));
		if (map.containsKey(key)) {
		int val = map.get(key);
		if (val == -1) {
		continue;
		}
		
		int pos = map.get(key);
		String tmp= strings[pos];
		strings[pos] = strings[i];
		strings[i] = tmp ;
		
		
		map.put(key, -1);
		
		} else {
		map.put(key, i);
		}
		
		}
		
		return strings;
		}
*/
}

class Task1 implements Runnable
{
	MessageTaker mt;
	String msg;
	
	public Task1(MessageTaker mt1,String m1) {
		mt=mt1;
		msg=m1;
	}

	@Override
	public void run() {
		mt.display(msg);
	}
	
}

class Task2 implements Runnable
{
	MessageTaker mt;
	String msg;
	
	public Task2(MessageTaker mt1,String m1) {
		mt=mt1;
		msg=m1;
	}

	@Override
	public void run() {
		mt.display(msg);
	}
	
}
