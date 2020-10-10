package com.java8.exercise;

import java.util.Arrays;
public class TestStudent{
		
		/*String[] a= {"a","b","c","d"};
		StringBuilder sb=new StringBuilder();
		List<String> characters= Arrays.asList(a);
		if(characters.contains("e"))
			//continue;
			;
		else 
			;
			//add charaters to Stringbuilder;
		List<Student> listStudents = new ArrayList<>();
		
		listStudents.add(new Student("Alice", 82));
		listStudents.add(new Student("Bob", 90));
		listStudents.add(new Student("Carol", 67));
		listStudents.add(new Student("David", 80));
		listStudents.add(new Student("Eric", 55));
		listStudents.add(new Student("Frank", 49));
		listStudents.add(new Student("Gary", 88));
		listStudents.add(new Student("Henry", 98));
		listStudents.add(new Student("Ivan", 66));
		listStudents.add(new Student("John", 52));
		
		
		//working with streams -> First of all get the stream from the collection, then apply filtering on the streams if you want, then perform operations
		
		//List<Student> listGoodStudents=listStudents.stream().filter(e-> e.getScore() >90).collect(Collectors.toList());
		System.out.println("Sum of scores of all the students having score greater than 60 : "+
		 listStudents.stream()
		.filter(e-> e.getScore() >60)
		.mapToInt(e->e.getScore())
		.sum());*/
		
		/*String inputString="absjjjsfsf";
	    int last=inputString.length();
	    boolean found=false;
	    for(int i=0;i<inputString.length();i++)
	    {	      
	      while(last>=i+2)
	      {
	        System.out.println("Processing substring: "+inputString.substring(i,last));
	        if(isPalindrome(inputString.substring(i,last)))
	        {
	          System.out.println("Found largest Palindrome: "+inputString.substring(i,last)+" of length: "+(last-i));
	          found = true;
	          break;
	        }
	        last--;
	      }
	      last=inputString.length(); // Reset the counter
	      if(found)
	    	  break;
	    }
	    System.out.println("Main thread ends here.");*/
		 /*ArrayList<String> strings = new ArrayList<String>();
		    strings.add("HE");
		    strings.add("HEL");
		    strings.add("HELL");
		    strings.add("HELLO");
		    
		    String pattern="H*";

		    for (String string : strings) {
		      if(Pattern.matches(pattern,string))
		        System.out.print(string+ ",");
		    }
	}*/
	/*	
	public static boolean isPalindrome(String origString)
	  {
	    StringBuilder origStringCopy=new StringBuilder(origString);
	    StringBuilder reverseStringOfOrigString=new StringBuilder(origString);
	    reverseStringOfOrigString=reverseStringOfOrigString.reverse();
	    String reverseString=new String(reverseStringOfOrigString);
	    
	    if(origString.equals(reverseString))  // we need to convert String builder to String in order to compare the origString and reverse String using equals method as equals method is not overridden in StringBuilder class. 
	      return true;
	    else
	      return false;
	    
	  }
	@Override
	public int compareTo(Object o) {
		return 0;
	}*/
	
	public static void main(String[] args) {
		int[] arr= {23,54,2,42,55,12,34};
		Arrays.parallelSort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+",");
	}
	
}
