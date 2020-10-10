package test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PrimeTest {
	static Set<Integer> primes = new LinkedHashSet<>();
	public static void main(String[] args) {
		
		//checkPrime(7,18,2,5,10);
		/*int[] a = new int[] {1,2,3,4,5,6};
		Arrays.asList(a).stream().collect(Collectors.toList());
		int[] subArr = Arrays.copyOfRange(a, 2,a.length);
		List<Integer> numbers = Stream.iterate(0, i->i+1).limit(subArr.length)
				.map(index->subArr[index]).collect(Collectors.toList());
		System.out.println(numbers);*/
		/*Class primeTest = PrimeTest.class;
		Class[] classes = primeTest.getDeclaredClasses();
		for(Class c: classes) {
			Class[] d = c.getDeclaredClasses();
			if(d.length != 0) {
				for(Class e: d) {
					System.out.println("Class name : "+e.getClass().getCanonicalName());
				}
			}
		}*/
	}
	
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//
	
	public static void checkPrime(Integer... numbers){
        
        for(int i = 0; i< numbers.length; i++){
            if(numbers[i]==1){
                continue;
            }
            if(numbers[i] == 2){
                primes.add(2);
                continue;
            }
            boolean isPrime = true;
            for(int j=2 ; j< numbers[i]; j++){
                if((numbers[i]%j)==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.add(numbers[i]);
            }
        }
        for(Integer i : primes){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
