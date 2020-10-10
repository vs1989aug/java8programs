package com.java8.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Encryption {
	
	public static void main(String[] args) {
	    
	    Scanner sc=new Scanner(System.in);
	    
	    System.out.println("Please enter the password to encrypt: ");
	   
	    String password= sc.next();
	    
	    System.out.println("Password before encryption is :" + password);
	    
	    Map<Character,Integer> passKey=new HashMap<Character,Integer>();
	    
	    for(Character ch ='A'; ch<='z'; ch++)
	    {
	      passKey.put(ch,Integer.valueOf(ch));
	    }
	    
	    StringBuilder encryptedPassword=new StringBuilder();
	    
	    for(char ch: password.toCharArray())
	    {
	        encryptedPassword.append(passKey.get(ch)+"$");
	    }
	    
	    System.out.println("Encrypted password is : "+ encryptedPassword);
	    
	    System.out.println("Decrypting the password now: ");
	    
	    String[] str=encryptedPassword.toString().split("\\$");
	    
	    StringBuilder decryptedPassword=new StringBuilder();
	    
	    for(String s: str)
	    {
	      for(Character ch: passKey.keySet())
	      {
	        if(passKey.get(ch).toString().equalsIgnoreCase(s))
	          decryptedPassword.append(ch);
	      }
	    }
	    
	    System.out.println("Decrypted password is : "+ decryptedPassword);
	    sc.close();
	  }

}
