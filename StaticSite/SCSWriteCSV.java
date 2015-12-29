package StaticSite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SCSWriteCSV {
	
	private static XSSFWorkbook ExcelBook;
	private static XSSFSheet Sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void getExcelPath(String Filename, String Sheetname) throws Exception{
		try{
			File file = new File(Filename);
			FileInputStream inputStream = new FileInputStream(file);
			ExcelBook = new XSSFWorkbook(inputStream);
			Sheet = ExcelBook.getSheet(Sheetname);
		} catch(Exception e){
			throw e;
		}
	}
	
	public static void SetExcelData(int Rownum, int Cellnum, String Result) throws Exception{
		try{
			row=Sheet.createRow(Rownum);
			cell=row.getCell(Cellnum, row.RETURN_BLANK_AS_NULL);
			if(cell == null){
				cell=row.createCell(Cellnum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}
		FileOutputStream out = new FileOutputStream("C:\\Users\\sakthivel\\Documents\\SCS\\SCS.xlsx");
		ExcelBook.write(out);
		}catch (Exception e){
			throw e;
		}
	}
	
}
