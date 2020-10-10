package com.java.accountapi;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
   volatile static Map<Long, Account> accountInfo = new HashMap<Long, Account>();
  
  
  public static void main(String[] args) {
    
    Account acc1 = new Account(10003400L,10000,"Vivek");
    Account acc2 = new Account(10003401L,10000,"Sharma");
    Account acc3 = new Account(10003402L,10000,"Spient");
    Account acc4 = new Account(10003403L,10000,"Raja");
    Account acc5 = new Account(10003404L,10000,"Hero");
    
    accountInfo.put(acc1.getAccountNumber(), acc1);
    accountInfo.put(acc2.getAccountNumber(), acc2);
    accountInfo.put(acc3.getAccountNumber(), acc3);
    accountInfo.put(acc4.getAccountNumber(), acc4);
    accountInfo.put(acc5.getAccountNumber(), acc5);
    
    Admin admin=new Admin();
    Transaction trans = admin.transferAmount(acc1,acc2,200);
    
    if(null!=trans)
    {
       System.out.println("Transaction is successful!");
       System.out.println("Below are the transaction details: ");
       System.out.println(trans.toString());
       
    }
    else
    {
      System.out.println("Something went wrong.");
    }
    
  }
  
  
}
class Admin
{
  String name;
  
  public String getName()
  {
    return this.name;
  }
  
  public Transaction transferAmount(Account from, Account to, double amount)
  {
    if(Solution.accountInfo.containsKey(from.getAccountNumber()))
    {
      if(Solution.accountInfo.containsKey(to.getAccountNumber()))
      {
        //Check the amount in source and target before performing transaction
        
        Account fromAccount= Solution.accountInfo.get(from.getAccountNumber());
        Account toAccount =  Solution.accountInfo.get(to.getAccountNumber());
        
        System.out.println("Amount in source before transaction: "+ fromAccount.getAmount());
        System.out.println("Amount in target before transaction: "+ toAccount.getAmount());
        
        //update the amount details in payer and payee accounts
        fromAccount.setAmount(from.getAmount() - amount);
        toAccount.setAmount(to.getAmount() + amount);
  
        Solution.accountInfo.put(from.getAccountNumber(),fromAccount );
        Solution.accountInfo.put(to.getAccountNumber(),toAccount );
        
        Account afterFromAccount= Solution.accountInfo.get(fromAccount.getAccountNumber());
        Account afterToAccount =  Solution.accountInfo.get(toAccount.getAccountNumber());
        
        System.out.println("Amount in source after transaction: "+ afterFromAccount.getAmount());
        System.out.println("Amount in target after transaction: "+ afterToAccount.getAmount());
        
      }
    }
    //verify whether the amount was updated in both payer and paaye accounts
    // Set the transaction details and return that.
    
    Transaction transactionDetails=new Transaction((long)(Math.random() * 100000),amount,new Date() ,from.getAccountNumber(), to.getAccountNumber());
    return transactionDetails;
  }
  
  /*public Transaction editAmount()
  {
    
  }*/
  
}

class Transaction
{
  long transactionId;
  double transactionAmount;
  Date transactionDate;
  long fromAccount;
  long toAccount;
  
  Transaction(long id, double amount, Date date, long payer, long payee)
  {
    transactionId=id;
    transactionAmount=amount;
    transactionDate=date;
    fromAccount=payer;
    toAccount=payee;
  }
  
  public long getTransactionId()
  {
    return this.transactionId;
  }
  
  public double getTransactionAmount()
  {
    return this.transactionAmount;
  }
  
  public Date getTransactionDate()
  {
    return this.transactionDate;
  }
  public long getFromAccount()
  {
    return this.fromAccount;
  }
  public long getToAccount()
  {
    return this.toAccount;
  }
  
  public String toString()
  {
	  
	  return "Transaction ID\t Payer Account Number \t Payee Account Number \t Transaction Amount\t Transaction Date \n"
	  + this.getTransactionId()
	  +"\t\t "
	  +this.getFromAccount()
	  +"\t\t "
	  +this.getToAccount()
	  +"\t\t "
	  +this.getTransactionAmount()
	  +"\t\t         "
	  +this.getTransactionDate();   
  }
}

class Account
{
  long accountNumber;
  double amount;
  String accountHolderName;
  
  Account(long number, double amount, String name)
  {
    accountNumber=number;
    this.amount=amount;
    accountHolderName=name;
  }
  
  public long getAccountNumber()
  {
    return this.accountNumber;
  }
  
  public double getAmount()
  {
    return this.amount;
  }
  
  public String getAccountHolderName()
  {
    return this.accountHolderName;
  }
  
  public void setAccountNumber(long number)
  {
    this.accountNumber=number;
  }
  public void setAmount(double amount)
  {
    this.amount=amount;
  }
  public void setAccountHoldername(String name)
  {
    this.accountHolderName=name;
  }
}

final class AccountHolderKey
{

  final private Long accountNumber;
  final private String accountHolderName;
  
  AccountHolderKey(Long accNumber, String name)
  {
    accountNumber=accNumber;
    accountHolderName=name;
  }
  
  public Long getAccountNumber()
  {
    return this.accountNumber;
  }
  
  public String getAccountHolderName()
  {
    return this.accountHolderName;
  }
  
  public int hashCode()
  {
    String key=this.getAccountNumber().toString();
    return key.hashCode();
    
  }
  
  public boolean equals(Object obj)
  {
    AccountHolderKey obj1= (AccountHolderKey)obj;
    if(this.getAccountNumber() == obj1.getAccountNumber())
      return true;
      else
        return false;
  }
  
  
}
