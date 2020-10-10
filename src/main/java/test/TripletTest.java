package test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TripletTest {
	
	int i;

	public static void main(String[] args) {
		//System.out.println(countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3));
		/*String str = "abc";
		findOpCountToMakeStringAnagram(str);*/
		
		/*String cPlusVarName = "iden_sd_d_f_rr_er";
		
		String convertedJavaVarName = converVariableNameInJava(cPlusVarName);

		String convertedCPlusVarName = convertVariableNameInCPlus(convertedJavaVarName);
		
		System.out.println("Earlier C Plus var name: "+cPlusVarName);
		System.out.println("ConvertedJavaVarName: "+convertedJavaVarName);
		System.out.println("ConvertedJavaVarNameToCplusVarName: "+convertedCPlusVarName);
		
		System.out.println("Comparing earlier c plus var name and converted c plus var name from java:");
		System.out.println(cPlusVarName +" == "+ convertedCPlusVarName +" -> "+cPlusVarName.equals(convertedCPlusVarName));
*/
		/*String s = "adaadbcbb";
		char[] c = s.toCharArray();
		
		Map<Character, Long> m = Stream.iterate(0, i->i+1).limit(c.length).map(k->c[k])
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		*/
		/*Stud s1 = getStudent("Vivek", 23L, 1L);
		Stud s2 = getStudent("Pawan", 12L, 2L);
		Stud s3 = getStudent("Prince", 20L, 3L);
		Stud s4 = getStudent("Piyush", 9L, 4L);
		
		Map<String, Stud> m2 = new HashMap<>();
		m2.put(s1.getName(), s1);
		m2.put(s2.getName(), s2);
		m2.put(s3.getName(), s3);
		m2.put(s4.getName(), s4);
		m2.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
				.forEach(e -> {
					System.out.println(e.getKey() + " : " + e.getValue());
				});*/
		/*String html = "<h1>Hey html</h1>";
		String startTag = html.substring(html.indexOf("<"),html.indexOf(">")+1);
		String endTag = html.substring(html.indexOf("</"));
		System.out.println(html.replaceFirst(startTag, "").replaceFirst(endTag, ""));*/
		/*printOneToTen(1);
		
		String s1 = "abcdedcba";
		String s2 = "aabbccdde";
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(s1.toCharArray());
		Arrays.sort(s2.toCharArray());
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		
		Stream.iterate(0, i->i+1).limit(c1.length).map(j->c1[j]).forEach(c->b1.append(c));
		Stream.iterate(0, i->i+1).limit(c2.length).map(j->c2[j]).forEach(c->b2.append(c));
		System.out.println(b1.toString().equals(b2.toString()));*/
		
		//minimumBribes(new int[] {2,5,1,3,4}); // 1,2,3,4,5
		int[] ar = new int[] { 2, 2, 2, 2, 3, 4, 3, 5, 4, 5, 6, 6 };
		int n = 12;
		long collect = Stream.iterate(0, i -> i + 1).limit(n).map(j -> ar[j])
				.collect(Collectors.collectingAndThen(Collectors.groupingBy(Function.identity(), Collectors.counting()),
						m -> m.keySet().stream().map(k -> m.get(k)).filter(i -> i >= 2)
								.collect(Collectors.summingLong(j -> j / 2))));
		System.out.println(collect);
		
	}
	
	static void minimumBribes(int[] q) {
		
		List<Integer> result = Stream.iterate(0, i -> i + 1).limit(q.length).map(j -> q[j])
				.collect(Collectors.toList());

		List<Integer> orig = Stream.iterate(0, i -> i + 1).limit(q.length).map(j -> q[j]).sorted()
				.collect(Collectors.toList());

		int bribesCount = 0;
		boolean chaotic = false;
		for (int i = 0; i < result.size(); i++) {
			int n = result.get(i);
			int origIndex = i;
			for (int j = 0; j < orig.size(); j++) {
				if (orig.get(j) == n && origIndex != j) {
					if (Math.abs(origIndex - j) > 2) {
						chaotic = true;
						break;
					} else {
						orig.remove(orig.get(j));
						orig.add(i, n);
						bribesCount += Math.abs(origIndex - j);
						origIndex = j;
					}

				}
			}
			if (chaotic) {
				break;
			}

		}
		if (chaotic)
			System.out.println("Too chaotic");
		else
			System.out.println(bribesCount);

	}
	
	static void printOneToTen(int i) {
		if (i <= 10) {
			System.out.println(i);
			i++;
			printOneToTen(i);
		}
		if (i > 10)
			return;
	}

	/*private static String convertVariableNameInCPlus(String javaVarName) {
		char[] cArr = javaVarName.toCharArray();
		List<Integer> capsCharLoc = new ArrayList<>();
		for (int i = 0; i < cArr.length; i++) {
			int v = (int) cArr[i];
			if (v <= 90 && v >= 65) {
				capsCharLoc.add(i);
			}
		}
		int count=0;
		for(int index: capsCharLoc) {
			if(count >=1) {
				index = index+count;
			}
			char charAt = javaVarName.charAt(index);
			String replace = new String(""+charAt);
			String replaceable = new String("_"+charAt).toLowerCase();
			javaVarName = javaVarName.replace(replace, replaceable);
			count++;
		}
		return javaVarName;
	}

	private static String converVariableNameInJava(String s) {
		List<Integer> underscoresLoc = new ArrayList<>();
		char[] cArr = s.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == '_') {
				underscoresLoc.add(i);
			}
		}
		int count = 0;
		for (Integer index : underscoresLoc) {
			if (count >= 1) {
				index = index - count;
			}
			int newIndex = index - (s.length()); // newIndex = 0 means that underscore is the last char
			if (newIndex == 0) {
				break;
			} else if (newIndex == 1) {
				String toReplace = new String("" + s.charAt(index - 1) + s.charAt(index));
				String replaceable = new String("" + s.charAt(index)).toUpperCase();
				s = s.replaceAll(toReplace, replaceable);
			} else {
				String toReplace = new String("" + s.charAt(index) + s.charAt(index + 1));
				String replaceable = new String("" + s.charAt(index + 1)).toUpperCase();
				s = s.replaceAll(toReplace, replaceable);
			}
			count++;
		}
		return s;
	}

	private static void findOpCountToMakeStringAnagram(String str) {
		int length = str.length();
		String leftHalf;
		String rightHalf;
		int anagramOpCount = 0;
		leftHalf = str.substring(0,length/2);
		if(length%2 != 0) {
			rightHalf = str.substring((length/2)+1,length);
		}else{
			rightHalf = str.substring((length/2),length);
		}
		System.out.println("Left Half: "+leftHalf+ ", Right Half: "+rightHalf);
		int rightHalfIndex = 0;
		for (int i = leftHalf.length() - 1; i >= 0; i--) {
			System.out.println("Finding counts between: char " + leftHalf.charAt(i) + " and char " + rightHalf.charAt(rightHalfIndex));
			anagramOpCount += findCount(leftHalf.charAt(i), rightHalf.charAt(rightHalfIndex));
			rightHalfIndex++;
		}
		System.out.println("Total op count: "+anagramOpCount);
	}

	private static int findCount(char c1, char c2) {
		return Math.abs((int)c1 - (int)c2);
	}*/

	static long countTriplets(List<Long> arr, long r) {
		/*Map<Long, Integer> numOccurences = new HashMap<>();
		for (Long l : arr) {
			if (numOccurences.containsKey(l)) {
				numOccurences.put(l, numOccurences.get(l)+1);
			} else {
				numOccurences.put(l, 1);
			}
		}
		int tripletsCount = 0;
		for (Long num : arr) {
			long find = num;
			long first = find * r;
			long second = find * r * r;
			if (numOccurences.containsKey(first) && numOccurences.containsKey(second)) {
				if(numOccurences.get(first) > 1) {
					tripletsCount+=numOccurences.get(first);
				}else if(numOccurences.get(second) > 1) {
					tripletsCount+=numOccurences.get(second);
				}
				tripletsCount++;
			}
		}

		return tripletsCount;*/

		/*Map<Long, Long> numOccurences = arr.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int tripletsCount = 0;
		for (Long num : arr) {
			long find = num;
			long first = find * r;
			long second = find * r * r;
			if (numOccurences.containsKey(first) && numOccurences.containsKey(second)) {
				tripletsCount += (numOccurences.get(first) * numOccurences.get(second));
			}
		}
		return tripletsCount;*/
		
		return 0L;
	}

	public static Stud getStudent(String name, Long age, Long id) {
		return Stud.build(name, age, id);
	}
	
}

class Stud{
	
	private String name;
	private Long age;
	private Long id;
	
	
	public String getName() {
		return name;
	}



	public Long getAge() {
		return age;
	}



	public Long getId() {
		return id;
	}



	public static Stud build(String name, Long age, Long id) {
		Stud s = new Stud();
		s.name = name;
		s.age = age;
		s.id = id;
		return s;
	}



	@Override
	public String toString() {
		return "Stud [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
}
