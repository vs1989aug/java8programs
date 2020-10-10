package test;

import java.io.IOException;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }

   // Write your code here
   public PerformOperation isOdd() {
	   return num-> (num%2)!=0;
   }

   public PerformOperation  isPrime() {
	   return num-> {
	       if(num==1){
	           return false;
	       }
	       if(num==2){
	           return true;
	       }
	       for(int i= 2; i< num ; i++){
	           if(num%2==0){
	               return false;
	           }
	       }
	       return true;
	   };
   }
   
   public PerformOperation isPalindrome() {
	   return input-> (""+input).equals(new StringBuilder(input).reverse().toString());
   }
}

public class Sol {

 public static void main(String[] args) throws IOException {
	 
 }
}
