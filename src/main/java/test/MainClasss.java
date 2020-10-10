package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainClasss {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee();
		e.setName("Employee One");
		employees.add(e);

		try (FileOutputStream fileOutputStream = new FileOutputStream("output\\employee.ser");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				FileInputStream fileInputStream = new FileInputStream("output\\employee.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			
			employees.stream().forEach(emp->System.out.println(emp));
			System.out.println("Serializing Employee object..");
			objectOutputStream.writeObject(employees);
			System.out.println("Employee object is serialized");

			// deserialize
			System.out.println("Deserializing Employee object..");
			@SuppressWarnings("unchecked")
			List<Employee> employeesNew = (List<Employee>) objectInputStream.readObject();
			employeesNew.stream().forEach(emp->System.out.println(emp));
			System.out.println("Employee object is de-serialized");
			
			//
			
			
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		} 

	}

}
