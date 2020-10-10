package com.excel.examples;

import java.util.List;

public interface ExcelReader<T> {
	
	List<T> readDataFromExcel(String fileName);

}
