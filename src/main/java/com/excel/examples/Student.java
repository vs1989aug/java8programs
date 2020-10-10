package com.excel.examples;

public class Student {
	
	private String studentName;
	private String studentId;
	
	
	public Student() {
		super();
	}

	public Student(String studentName, String studentId) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public String getStudentId() {
		return studentId;
	}


	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + "]";
	}
}
