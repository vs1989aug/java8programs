package com.excel.examples;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentExcelReader implements ExcelReader<Student> {

	@Override
	public List<Student> readDataFromExcel(String filePath) {

		List<Student> students = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(new File(filePath));) {

			Workbook workbook = new XSSFWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();
			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				System.out.println("Reading sheet with sheet name : " + sheet.getSheetName());
				students.addAll(parseSheetData(sheet));
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return students;
	}

	private List<Student> parseSheetData(Sheet sheet) {
		List<Student> students = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Student student = parseRowData(rowIterator.next());
			students.add(student);
		}
		return students;
	}

	private Student parseRowData(Row row) {
		Student student = new Student();
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
				student.setStudentName(cellIterator.next().getStringCellValue());
				student.setStudentId(cellIterator.next().getStringCellValue());
		}
		return student;
}

}
