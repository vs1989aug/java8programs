package com.excel.examples;

import java.util.List;

public interface ExcelWriter<T> {

	void writeDataToExcel(List<T> students, String filePath);
}
