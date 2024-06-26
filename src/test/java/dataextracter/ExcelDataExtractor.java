package dataextracter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import frameconstans.FrameConstants;

public final class ExcelDataExtractor {
	
	private ExcelDataExtractor() {}

	@DataProvider
	public Object[] excelLoginTestDataExtractor() throws FileNotFoundException, IOException {
		
		try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FrameConstants.LOGINTESTDATAEXCELPATH.getStringValue()))) {
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rownum = sheet.getLastRowNum();
			int columnnum = sheet.getRow(0).getLastCellNum();

			Object[] data = new Object[rownum];
			HashMap<String, String> loginData = null;
			
			for(int i=1;i<=rownum;i++) {
				loginData = new HashMap<String, String>();
				for(int j=0;j<columnnum;j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					loginData.put(key, value);
					data[i-1] = loginData;
				}
			}

			
			return data;
		}
	}
	
	@DataProvider
	public Object[] excelRegisterTestDataExtractor() throws FileNotFoundException, IOException {
		
		try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FrameConstants.REGISTERDATAEXCELPATH.getStringValue()))) {
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			DataFormatter formatter = new DataFormatter();
			int rownum = sheet.getLastRowNum();
			int columnnum = sheet.getRow(0).getLastCellNum();

			Object[] data = new Object[rownum];
			HashMap<String, String> loginData = null;
			
			for(int i=1;i<=rownum;i++) {
				loginData = new HashMap<String, String>();
				for(int j=0;j<columnnum;j++) {
					String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
					String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
					loginData.put(key, value);
					data[i-1] = loginData;
				}
			}

			
			return data;
		}
	}
	
	

	
	
	
}
