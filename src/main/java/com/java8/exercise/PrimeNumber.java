package com.java8.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
	
	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
		System.out.println("Please provide a number:");
		long num=sc.nextLong();
		printPrimeNumbers(num);}
		
	}
	
	public static void printPrimeNumbers(Long num)
	{
		boolean isPrime=false;
		List<Long> primes=new ArrayList<Long>();
		if(num<=0)
			System.out.println("Invalid number.");
		else {
		if(num==1 || num==2)
		{
			primes.add(num);
		}
		else
		{
			primes.add(new Long(2));
			for(long i=3;i<num;i++)
			{
				for(long j=2;j<i;j++)
				{
					if(i%j==0)
					{						
						isPrime=false;
						break;
					}
					else
					{
						isPrime=true;
					}
				}
				if(isPrime)
					primes.add(i);
			}
		}
		
	}
		System.out.println("Prime numbers lesser than "+num+" are: \n"+primes);
	}
}
