package com.excel.examples;

public class ExcelTest {

	public static void main(String[] args) {

		String readFile = "C:\\test\\Students.xlsx";
		String writeFile = "C:\\test\\StudentsNew.xlsx";

		readFile(readFile);
		
		try {
			System.out.println("Waiting for write operation.....");
		Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		writeFile(writeFile);

	}

	private static void writeFile(String writeFile) {
		System.out.println("Writing data to file: "+writeFile);
		new StudentExcelWriter().writeDataToExcel(new StudentsProvider().getStudents(10), writeFile);

	}

	private static void readFile(String readFile) {
		System.out.println("Reading data from file: "+readFile);
		new StudentExcelReader().readDataFromExcel(readFile).forEach(student -> System.out.println(student));
	}

}
