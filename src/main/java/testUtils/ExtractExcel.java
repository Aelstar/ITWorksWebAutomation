package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractExcel {
	
	
	public static  Object[][] readExcel(String sheetName) throws IOException {
		
		
		File excelFile=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ITWebAutomation\\TestDataIn\\Extractor Data.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		
		int Rows=sheet.getLastRowNum();
		
		int Columns=sheet.getRow(0).getLastCellNum();
		
		
		Object ReadData[][]=new Object[Rows][Columns];
		
		for(int i=0; i<Rows; i++) {
			
			
			for (int j=0; j<Columns; j++) {
				ReadData[i][j]=sheet.getRow(i).getCell(j).toString();
				
			}
		}
		
		return ReadData;
	}

}
