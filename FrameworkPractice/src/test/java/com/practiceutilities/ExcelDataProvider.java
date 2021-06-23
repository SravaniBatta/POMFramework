package com.practiceutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public  ExcelDataProvider() {

		File src=new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			System.out.println("Workbook loaded");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Cant load the File"+e.getMessage());
		}
	}

	public String getStringData(String sheetName,int row,int column) {
		
		System.out.println("Sheet Name::"+sheetName+"row Number::"+row+"column number::"+column);

		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();

	}
	public double getNumericData(String sheetName,int row,int column) {

		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

	}


}
