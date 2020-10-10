package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Anagrams {

   static boolean isAnagram(String a, String b) {
            
            if(a.length() != b.length()){
                return false;
            }
            if((a.length() == 1 && b.length() ==1) && (a.length() == b.length())
            && a.equals(b)){
                return true;
            }
            Map<Character,Integer> charFrequencyA = new HashMap<>();
            Map<Character,Integer> charFrequencyB = new HashMap<>();

            for(int i = 0; i< a.length(); i++){
                if(charFrequencyA.containsKey(a.charAt(i))){
                    charFrequencyA.put(a.charAt(i),charFrequencyA.get(a.charAt(i))+1);
                }
                else{
                    charFrequencyA.put(a.charAt(i),1);
                }
            }
            for(int i = 0; i< b.length(); i++){
                if(charFrequencyB.containsKey(b.charAt(i))){
                    charFrequencyB.put(b.charAt(i),charFrequencyB.get(b.charAt(i))+1);
                }
                else{
                    charFrequencyB.put(b.charAt(i),1);
                }
            }
            Set<Character> keys = charFrequencyA.keySet();
            for(Character c: keys){
                if(charFrequencyB.get(c) != charFrequencyA.get(c)){
                    return false;
                }
            }
            return true;
        }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
