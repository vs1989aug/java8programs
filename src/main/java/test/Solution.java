package test;

import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */

 class Student{

     int id;
     String name;
     double cgpa;

     public Student(String name, double cgpa, int id){
         this.name= name;
         this.cgpa=cgpa;
         this.id = id;
     }

     public int getID(){
         return this.id;
     }
     public double getCGPA(){
         return this.cgpa;
     }
     public String getName(){
         return this.name;
     }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
	}
     
     
 }

 class Priorities{

	 Comparator<Student> studentComparator = (s1,s2)->{
         if(s1.getCGPA() == s2.getCGPA()){
             if(s1.getName().equals(s2.getName())){
                 return s1.getID()-s2.getID();
             }
             return s1.getName().compareTo(s2.getName());

         }
         return Double.compare(s2.getCGPA(),s1.getCGPA());
     };
     
     PriorityQueue<Student> studentsQueue = new PriorityQueue<>(studentComparator);
     
	public List<Student> getStudents(List<String> events) {
		if (events != null && events.size() > 0) {
			events.forEach(event -> {
				StringTokenizer t = new StringTokenizer(event, " ", false);
				while (t.hasMoreTokens()) {
					if (t.nextToken().equalsIgnoreCase("ENTER")) {
						studentsQueue.add(new Student(t.nextToken(), Double.valueOf(t.nextToken()),
								Integer.valueOf(t.nextToken())));
						System.out.println(studentsQueue);
					}
					if (event.equalsIgnoreCase("SERVED") && !studentsQueue.isEmpty()) {
						System.out.println("Serving : "+studentsQueue.peek());
						studentsQueue.remove();
						System.out.println(studentsQueue);
					}
				}
			});
		}
		ArrayList<Student> students = new ArrayList<>(studentsQueue);
		Collections.sort(students,studentComparator);
		return students;

	}

 }


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}