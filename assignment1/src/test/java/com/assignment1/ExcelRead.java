package com.assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	
	
	
	public ArrayList<String> getdata(String testName) throws IOException{
		String filepath = System.getProperty("user.dir") + "\\testdata\\sampledata.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		
		ArrayList<String> al = new ArrayList();
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		
		for(int i =0 ; i < sheets ; i ++){
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				// scan all rows
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				int k =0 ;
				int column = 0;
				while(cells.hasNext()){
					Cell cell = cells.next();
					if(cell.getStringCellValue().equalsIgnoreCase("testcase")){
						
						column = k;
					}
					
					k++;
				}
				while(rows.hasNext()){
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testName)){
						
						// now print all data of specific testcase
						Iterator<Cell> cl = r.cellIterator();
						int m = 0;
						while(cl.hasNext()){
							Cell c = cl.next();
							//al.add(c.getStringCellValue());
							System.out.println(c.getCellTypeEnum());
							//System.out.println(c.getStringCellValue() + "  " + m);
							 if(c.getCellTypeEnum() == CellType.STRING){
								 al.add(c.getStringCellValue());
							 }
							 else{
								 
								 al.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							 }
							m++;
						}
						
					}
				}
				
				
			}
		}
		return al;
	}
	
	@Test
	public void printdata() throws IOException{
		ArrayList<String> ar = getdata("general");
		for(int a = 0; a< ar.size(); a++){
			System.out.println(ar.get(a));
		}
	}

}
