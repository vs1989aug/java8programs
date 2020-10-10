package com.java8.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {
	  
	  Map<Integer, Integer> userWithMessages=new HashMap<Integer,Integer>();
	  Map<Integer, Integer> userWithHashTags=new HashMap<Integer,Integer>();
	 
	  public   Map<Integer, Integer> getUserWithMessages()
	  {
	    return this.userWithMessages;
	  }
	  
	  public   Map<Integer, Integer> getUserWithHashTags()
	  {
	    return this.userWithHashTags;
	  }
	  
	  static Solution sol = new Solution();
	  
	  public static void main(String[] args) {
	    
	   /* User user1=new User(1);
	    User user2=new User(2);
	    User user3=new User(3);
	    User user4=new User(4);
	    User user5=new User(5);
	    
	    Message mes1=new Message(1,"mesg1");
	    Message mes2=new Message(2,"mesg2");
	    Message mes3=new Message(3,"mesg3");
	    Message mes4=new Message(4,"mesg4");
	    Message mes5=new Message(5,"mesg5");
	    
	    HashTag tag1=new HashTag(1);
	    HashTag tag2=new HashTag(2);
	    HashTag tag3=new HashTag(3);
	    HashTag tag4=new HashTag(4);
	    HashTag tag5=new HashTag(5);
	    
	    sol.saveMessage(user1,mes1);
	    sol.saveMessage(user3,mes2);
	    sol.saveMessage(user3,mes3);
	    sol.saveMessage(user2,mes1);
	    sol.saveMessage(user2,mes2);
	    sol.saveMessage(user3,mes1);
	    
	    
	    List<Integer> list = sol.getTopNUsers(2);
	    System.out.println(list);
	    */
		  try{
		        Stream<String> lines=Files.lines(Paths.get("C:/Users/vivsharm7/Desktop","c1.txt"));
		    Optional<String> hasPassword=lines.filter(i-> i.contains("Password")).findFirst();
		    
		    System.out.println(hasPassword.get()); 
		    lines.close();
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
	   
	  }
	  
	  public void saveMessage(User user,MessageTaker mesg)
	  {
	    
	    if(sol.getUserWithMessages().containsKey(user.getUserId()))
	    sol.getUserWithMessages().put(user.getUserId(), sol.getUserWithMessages().get(user.getUserId())+1);
	    else
	     sol.getUserWithMessages().put(user.getUserId(),1); 
	  }
	  
	  public void saveHashTags(User user,HashTag tag)
	  {
	    if(sol.getUserWithHashTags().containsKey(user.getUserId()))
	    sol.getUserWithHashTags().put(user.getUserId(), sol.getUserWithHashTags().get(user.getUserId())+1);
	    else
	     sol.getUserWithHashTags().put(user.getUserId(),1); 
	  }
	  
	  public List<Integer> getTopNUsers(int N)
	  {
	    Set<Map.Entry<Integer,Integer>> entries=sol.getUserWithMessages().entrySet();
	    List<Map.Entry<Integer,Integer>> list=new ArrayList<Map.Entry<Integer,Integer>>(entries);
	    Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>()
	    {
	      public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2)
	      {
	        return (o2.getValue().compareTo(o1.getValue()));
	      }
	    
	    });
	  
	    List<Integer> userIDList=new LinkedList<Integer>();
	    int count =1;
	    for(Map.Entry<Integer,Integer> entry:list)
	    {
	      if(count<=N)
	      {
	        userIDList.add(entry.getKey());
	        count++;
	      }
	    }
	    return userIDList;
	  }
	  
	  public List<Integer> getTopNHashTags(int N)
	  {
	    Set<Map.Entry<Integer,Integer>> entries=sol.getUserWithHashTags().entrySet();
	    List<Map.Entry<Integer,Integer>> list=new ArrayList<Map.Entry<Integer,Integer>>(entries);
	    Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>()
	    {
	      public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2)
	      {
	        return (o2.getValue().compareTo(o1.getValue()));
	      }
	    
	    });
	    Set<Integer> keySet=sol.getUserWithHashTags().keySet();
	  
	    List<Integer> userIDList=new LinkedList<Integer>();
	    int count =1;
	    for(Integer key:keySet)
	    {
	      if(count<=N)
	      {
	        userIDList.add(key);count++;
	      }
	    }
	    return userIDList;
	  }
	  
	}
	      
	final class User
	{
	  private Integer userId;
	  
	  User(Integer id)
	  {
	    userId=id;
	  }
	  
	  public Integer getUserId()
	  {
	    return userId;
	  }
	}
	class Message
	{
	  Integer mesgId;
	  String mesgBody;
	  
	  Message(Integer id, String text)
	  {
	    mesgId=id;
	    mesgBody=text;
	  }
	  
	  public Integer getMesgId()
	  {
	    return this.mesgId;
	  }
	  public String getMesgBody()
	  {
	    return this.mesgBody;
	  }
	}

	class HashTag
	{
	  Integer tagId;
	  
	  HashTag(Integer id)
	  {
	    tagId=id;
	  }
	  
	  public Integer getTagId()
	  {
	    return this.tagId;
	  }
	}