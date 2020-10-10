package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		Comparator<Applicant> applicantComp = (a1,a2)->{
			return a1.getEmail().compareTo(a2.getEmail());
		};
		
		PriorityQueue<Applicant> pq = new PriorityQueue<>(applicantComp);
		pq.add(new Applicant("Vivek",1L,"Sharma","vivek.sharma@email.com"));
		pq.add(new Applicant("Pawan",2L,"Gupta","pawan.gupta@email.com"));
		pq.add(new Applicant("Prince",3L,"Verma","prince.verma@email.com"));
		pq.add(new Applicant("Piyush",4L,"Garg","piyush.garg@email.com"));
		pq.add(new Applicant("Paritosh",5L,"Baranwal","pari.baranwal@email.com"));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}

class Applicant{
	
	private String fName;
	private long id;
	private String lName;
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Applicant(String fName, long id, String lName,String email) {
		super();
		this.fName = fName;
		this.id = id;
		this.lName = lName;
		this.email=email;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Applicant [fName=" + fName + ", id=" + id + ", lName=" + lName + ", email=" + email + "]";
	}
	
	
}
