package com.buddy.admin.export.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileProcessor {

	public static String process(String from, String error) throws IOException {

		File myFile = new File("D://Jayaraj/testfile.xlsx");
		FileInputStream fis = new FileInputStream(myFile);

		// Finds the workbook instance for XLSX file
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = mySheet.iterator();
		List<ScrapData> dataList = new ArrayList<>();
		// Traversing over each row of XLSX file
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getRowNum() > 0) {
				ScrapData data = new ScrapData();
				if (row.getCell(0) != null) {
					data.setCompanyName(row.getCell(0).getStringCellValue());
				} else {
					data.setCompanyName(null);
				}
				if (row.getCell(1) != null) {
					data.setAddress(row.getCell(1).getStringCellValue());
				} else {
					data.setAddress(null);
				}
				if (row.getCell(2) != null) {
					data.setState(row.getCell(0).getStringCellValue());
				} else {
					data.setState(null);
				}
				if (row.getCell(3) != null) {
					data.setZipCode(row.getCell(0).getStringCellValue());
				} else {
					data.setZipCode(null);
				}
				dataList.add(data);
			}
		}
		return "success";
	}
}
