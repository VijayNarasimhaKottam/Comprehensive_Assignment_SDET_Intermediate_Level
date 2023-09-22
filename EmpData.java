package exceldataread;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmpData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("F:\\empdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet s = wb.getSheet("Sheet1");
		
		int row = s.getLastRowNum();
		int column = s.getRow(0).getLastCellNum();
		
		
		for(int i=0; i<=row; i++) {
			XSSFRow currentrow = s.getRow(i);
			for(int j=0; j<column; j++) {
				String value = currentrow.getCell(j).toString();
				System.out.print(value+"                ");
				
			}
			System.out.println();
		}
		

	}

}
