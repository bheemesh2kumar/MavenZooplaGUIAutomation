package com.zoopla.regressiontests;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {

	@Test(dataProvider = "Testdata")
	public void printexceldata(Map<Object, Object> map) {

		System.out.println("******************************************");

		System.out.println(map.get("Dob"));

		System.out.println("******************************************");

	}

	@DataProvider(name = "Testdata")
	public Object[][] gettestdata() throws IOException {
		String excelpath = System.getProperty("user.dir") + "\\ExcelTestData\\ExcelTestdata.xlsx";
		File file = new File(excelpath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook XSSFWorkbookref = new XSSFWorkbook(fis);
		XSSFSheet XSSFSheetref = XSSFWorkbookref.getSheet("data");

		int lastrow = XSSFSheetref.getLastRowNum();
		int lastcol = XSSFSheetref.getRow(0).getLastCellNum();

		Object[][] objectarry = new Object[lastrow][1];

		for (int i = 0; i < lastrow; i++) {

			HashMap<Object, Object> hashmap = new HashMap<Object, Object>();

			for (int j = 0; j < lastcol; j++) {
				hashmap.put(XSSFSheetref.getRow(0).getCell(j).toString(), XSSFSheetref.getRow(i + 1).getCell(j).toString());
			}

			objectarry[i][0] = hashmap;

		}

		return objectarry;

	}

}
