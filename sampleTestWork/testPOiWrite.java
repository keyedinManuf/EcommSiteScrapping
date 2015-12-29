package sampleTestWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testPOiWrite {

	public void WriteExcel(String FilePath, String Filename, String Sheetname, String[] data ) throws IOException{
		
			File file = new File(FilePath+"\\"+Filename);
			FileInputStream input = new FileInputStream(file);
			Workbook w = null;
			String fileExtension =Filename.substring(Filename.indexOf("."));
			if(fileExtension.equals(".xlsx")){
				w=new XSSFWorkbook(input);
			} else if(fileExtension.equals(".xls")){
				w=new HSSFWorkbook(input);
			}
			Sheet s = w.getSheet(Sheetname);
			int rowcount = s.getLastRowNum()-s.getFirstRowNum();
			Row row = s.getRow(0);
			Row newRow = s.createRow(rowcount+1);
			for(int j=0; j<row.getLastCellNum(); j++){
				Cell cell = newRow.createCell(j);
				cell.setCellValue(data[j]);
			}
			input.close();
			FileOutputStream out = new FileOutputStream(file);
			w.write(out);
			out.close();
		
		
		
	}
	 
	public static void main(String...strings) throws IOException{
		String[] data={"Thiru", "CGvak",""};
		testPOiWrite test = new testPOiWrite();
		String FilePath = "C:\\Users\\sakthivel\\Documents\\testdata";
		test.WriteExcel(FilePath, "Book1.xlsx", "Sheet1", data);
		System.out.println("Test Done");
		
	}
	
}
