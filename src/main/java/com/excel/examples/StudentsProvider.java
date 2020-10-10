package com.excel.examples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsProvider {
	
	public List<Student> getStudents(int size) {
		
		return Stream.iterate(1, i->i+1).limit(size).map(j-> new Student("Student: "+j,j+""))
		.collect(Collectors.toList());
		
	}

}
