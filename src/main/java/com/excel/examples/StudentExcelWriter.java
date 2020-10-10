package com.excel.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentExcelWriter implements ExcelWriter<Student>{

	public void writeDataToExcel(List<Student> students, String filePath) {
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("New_Students");
		
		int rowIndex = 0;
		
		for(Iterator<Student> itr= students.iterator();itr.hasNext();) {
			Student student = itr.next();
			Row row = sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(student.getStudentName());
			row.createCell(1).setCellValue(student.getStudentId());
		}
		System.out.println("Workbook is ready to be written in file.");
		writeWorkbookToFile(workbook,filePath);
	}

	private void writeWorkbookToFile(Workbook workbook, String filePath) {
		try(FileOutputStream fos = new FileOutputStream(new File(filePath))){
			workbook.write(fos);
			System.out.println("Workbook data is written to file : "+filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
