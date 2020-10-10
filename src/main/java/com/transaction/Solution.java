package com.transaction;
import java.io.*;
import java.util.*;
import java.util.Date;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  //this will hold the details of the customer along with account
   public static Map<Long,Customer> customerDetails = new HashMap<Long,Customer>();
    
    //this will hold the details of the accounts
   public static Map<Long,Account> accountDetails = new HashMap<Long,Account>();
    
    //this will hold the details of the transactions in the account
   public static Map<Long, Transaction> transactionDetails=new HashMap<Long,Transaction>();
  
  //Map to hold the account Number as a key and customer as value
  public static Map<Long, Customer> accountCustomerMap=new HashMap<Long,Customer>();
  
  public static void main(String[] args) {
    
    Account ac1=new Account();
    Account ac2=new Account();
    Account ac3=new Account();
    Account ac4=new Account();
    Account ac5=new Account();
    
    ac1.acccountNumber=2131241;
    ac1.amount=20000.0;
    ac1.address="Mumbai";
    
    ac2.acccountNumber=3783247;
    ac2.amount=15000.0;
    ac2.address="Delhi";
    
    ac3.acccountNumber=3243245;
    ac3.amount=10000.0;
    ac3.address="Chennai";
    
    ac4.acccountNumber=33249;
    ac4.amount=100000.0;
    ac4.address="Gujrat";
    
    ac5.acccountNumber=32478422;
    ac5.amount=10000.0;
    ac5.address="Kolkata";
    
    Solution.accountDetails.put(ac1.acccountNumber,ac1);
    Solution.accountDetails.put(ac2.acccountNumber,ac2);
    Solution.accountDetails.put(ac3.acccountNumber,ac3);
    Solution.accountDetails.put(ac4.acccountNumber,ac4);
    Solution.accountDetails.put(ac5.acccountNumber,ac5);
    
    Customer c1=new Customer();
    c1.customerId=1;
    c1.customerName="A";
    c1.account=ac1;
    
    Customer c2=new Customer();
    c2.customerId=2;
    c2.customerName="B";
    c2.account=ac2;
    
    Customer c3=new Customer();
    c3.customerId=3;
    c3.customerName="C";
    c3.account=ac3;
    
    Customer c4=new Customer();
    c4.customerId=4;
    c4.customerName="D";
    c4.account=ac4;
    
    Customer c5=new Customer();
    c5.customerId=5;
    c5.customerName="E";
    c5.account=ac5;
    
    //Put the customer details in the customerDetails map
    customerDetails.put(c1.customerId,c1);
    customerDetails.put(c2.customerId,c2);
    customerDetails.put(c3.customerId,c3);
    customerDetails.put(c4.customerId,c4);
    customerDetails.put(c5.customerId,c5);
    
    
    accountCustomerMap.put(ac1.acccountNumber,c1);
    accountCustomerMap.put(ac2.acccountNumber,c2);
    accountCustomerMap.put(ac3.acccountNumber,c3);
    accountCustomerMap.put(ac4.acccountNumber,c4);
    accountCustomerMap.put(ac5.acccountNumber,c5);
    
    
    Transaction tr1=Customer.transferAmount(ac1,ac2,500.0);
    Customer.transferAmount(ac3,ac2,5000.0);
    Customer.transferAmount(ac3,ac2,500.0);
    Customer.transferAmount(ac4,ac2,5000.0);
    Customer.transferAmount(ac4,ac2,200.0);
    Customer.transferAmount(ac4,ac2,500.0);
    Customer.transferAmount(ac5,ac1,5000.0);
    
    List<Customer> custList=Bank.getCustomersWithMaxSpends(tr1.transactionDate,3);
    
    if(custList.size()>0)
    {
      for(Customer c:custList)
      {
        System.out.println(c.customerName);
      }
    }
    
    
  }
}

class Customer
{
  public long customerId;
  public String customerName;
  public Account account; 
  
  public static Transaction transferAmount(Account from, Account to, double amount)
  {
    Transaction transaction=new Transaction();
    Account payer=null,payee=null;
    //transfer the amount from account to the account passed 
    if(Solution.accountDetails.containsKey(from.getAccountNumber()) &&         Solution.accountDetails.containsKey(to.getAccountNumber()))
    {
          payer=Solution.accountDetails.get(from.getAccountNumber());
          payee=Solution.accountDetails.get(to.getAccountNumber());
      try{
      if(payer.getAmount()>amount)
      {
        //Deduct the amount from payer and add the amount in payee account
          payer.amount=payer.getAmount()-amount;
          payee.amount=payee.getAmount()+amount;
        
        
        //Set the transaction type in both payee and payer account
          payee.type=TransactionType.CREDIT;
          payee.type=TransactionType.DEBIT;
        
         // Set the transaction details
          transaction.payer=from;
          transaction.payee=to;
          transaction.amount=amount;
          transaction.transactionId=(long)(Math.random() * 100000000);
          transaction.transactionDate=new Date();
        
        //Update the transaction details in the account and update account details in the map
        
          payer.transactionId=transaction.transactionId;
          payee.transactionId=transaction.transactionId;
        
          Solution.accountDetails.put(from.getAccountNumber(),payer);
          Solution.accountDetails.put(to.getAccountNumber(),payee);
          
        //Put the transaction details in the map
         Solution.transactionDetails.put(transaction.transactionId,transaction);
      }
      else
        throw new InsufficientBalanceException("Insufficient balance in account to perform this transaction.");
      }
      catch(InsufficientBalanceException e)
      {
        System.out.println("\n---------------------------------\n Transaction of amount "+amount+" failed due to Insufficient balance in account : "+payer.getAccountNumber()+". Available balance : "+ payer.getAmount()
                          );
        
        transaction=null;
      }
          
    }
    
    return transaction;
    
  }
  
  public static List<Transaction> viewTransactionDetailsByDate(Date transactionDate)
  {
    // get the account details of the customer account based on account number passed
    List<Transaction> list=new ArrayList<Transaction>();
    Set<Long> transactionIdSet=Solution.transactionDetails.keySet();
    for(long key: transactionIdSet)
    {
      Transaction tr=Solution.transactionDetails.get(key);
      if(tr.transactionDate.toString().equalsIgnoreCase(transactionDate.toString()))
        list.add(tr);
    }
    return list;
  }
  
  public static Transaction editTransactionAmount(long transactionId, double value)
  {
    //get the transaction details using transaction id and change the amount
    if(!Solution.transactionDetails.containsKey(transactionId))
      return null;
    else
    {
      Transaction tr=Solution.transactionDetails.get(transactionId);
      tr.amount=value;
      Solution.transactionDetails.put(transactionId,tr);
      return tr;
    }
  }
  
}

class Bank
{
  public long bankId;
  public Map<Long, Customer> customerDetails=new HashMap<Long, Customer>();
  
  //Fetch the customer records who have performed maximum amount of debit transaction
  public static List<Customer> getCustomersWithMaxSpends(Date date, int n)
  {
    // Fetch the transactions happened on the given date
      List<Transaction> transDetails=Customer.viewTransactionDetailsByDate(date);
    //This map will hold the account with their total spends i.e total debit transactions amount
    Map<Long,Double> accountWithSpends=new HashMap<Long,Double>();
    double sum=0;
      for(Transaction trans: transDetails)
      {
        
        if(accountWithSpends.containsKey(trans.payer.acccountNumber)){
          
          sum=trans.amount+accountWithSpends.get(trans.payer.acccountNumber);
          accountWithSpends.put(trans.payer.acccountNumber,sum);
        }
        else
        {
        	accountWithSpends.put(trans.payer.acccountNumber,trans.amount);
        }
      }
    
    //Now sort the accountWithSpends based on their spends
    Set<Map.Entry<Long,Double>> set=accountWithSpends.entrySet();
    List<Map.Entry<Long,Double>> list= new ArrayList<Map.Entry<Long,Double>>(set);
    Collections.sort(list, new Comparator<Map.Entry<Long,Double>>()
                     {
                       public int compare(Map.Entry<Long,Double> o1, Map.Entry<Long,Double> o2){
                         return o2.getValue().compareTo(o1.getValue());
                       }
                     });
    List<Customer> customerList=new LinkedList<Customer>();
    int count=0;
    while(count<n){
      customerList.add(Solution.accountCustomerMap.get(list.get(count).getKey()));
        count++;
    }
    return customerList;
    
  }
  
}

class Account
{
  public long acccountNumber;
  public double amount;
  public String address;
  public long transactionId;
  public TransactionType type;
  
  //getters and setter
  
  public long getAccountNumber()
  {
    return this.acccountNumber;
  }
   public double getAmount()
  {
    return this.amount;
  }
  
   public String getAddress()
  {
    return this.address;
  }
  
  public String toString()
  {
    return "Account Number: "+this.acccountNumber+
           ", \tAmount : "+this.amount;
  }
  
}
class Transaction
{
  public long transactionId;
  public Account payer;
  public Account payee;
  public Date transactionDate;
  public double amount;
  
  public String toString()
  {
    return "Transaction ID: "+this.transactionId+
           "\nPayer Account Number: "+this.payer.acccountNumber+
           "\nPayee Account Number: "+this.payee.acccountNumber+
           "\nTransaction Amount: "+this.amount+
           "\nTransaction Date: "+this.transactionDate;
  }
  
}

//Exception Class 

class InsufficientBalanceException extends RuntimeException implements Serializable
{
  public static final long serialVersionUID=3232434324L;
  public InsufficientBalanceException(String mesg)
  {
    super(mesg);
  }
}

//enum to hold the account transaction types
enum TransactionType
{
  DEBIT,CREDIT;
}
