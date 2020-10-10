package com.java8.exercise;

public class SortingTest {
	
	public static void main(String[] args) {
		
		int[] arr= {34,56,7,75,102,12,956,3440,77,23,42,8,86,73};
		/*int temp=0;
		
		//Bubble sort
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i: arr)
		{
			System.out.println(i);
		}
		*/
		//Selection sort
		//int[] b=new int[arr.length];
		/*int max=0;
		for(int i=0;i < arr.length;i++) {
		for(int j=i+1;j < arr.length;j++)
		{
			if(arr[i]>arr[j]) {
				max=arr[i];
				arr[i]=arr[j];
				arr[j]=max;
			}
		}
		}
		for(int i: arr)
		{
			System.out.println(i);
		}*/
		
		//Insertion sort
		int max=0;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(arr[j]<arr[j-1])
				{
					max=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=max;
				}
			}
		}
		for(int i: arr)
		{
			System.out.println(i);
		}
	}
	

}
