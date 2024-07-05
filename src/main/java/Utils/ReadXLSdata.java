package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {
	
	@DataProvider(name="testdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		
		String excelSheetName = m.getName();
		String filePath = "C:\\Users\\shrutisachan\\OneDrive - Nagarro\\Documents\\Automation\\exit-test\\ExitAssignment\\testdata.xlsx";
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		DataFormatter format = new DataFormatter();
		
		String testData[][]= new String[totalRows][totalCols];
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		
		return testData;
	}
}
