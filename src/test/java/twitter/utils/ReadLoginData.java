package twitter.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ReadLoginData {
	
	
	@DataProvider(name="passing-login-details-excel")
	public static Object[][] passloginexcel() throws IOException{
		
		Object arr[][] = new Object[3][2];
		try {
			
				FileInputStream file= new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\testing\\Login.xlsx");
	
				XSSFWorkbook wb = new XSSFWorkbook(file);
	
				XSSFSheet sheet=wb.getSheet("Login");
	
				String username,password;
	
//				System.out.println(sheet.getLastRowNum());
	
				for(int i=1;i<=sheet.getLastRowNum();i++) {
	
					XSSFRow row=sheet.getRow(i);
					username=row.getCell(0).getStringCellValue();
//					if(row.getCell(0).getCellType() == CellType.NUMERIC) {
//						username=row.getCell(0).getRawValue().toString();
//					}
//					else {
//						username=row.getCell(0).toString();
//					}
	
					password=row.getCell(1).getStringCellValue();
					
					arr[i-1][0] = username;
					arr[i-1][1] = password;
					
				}
				return arr;

			}
		
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return arr;
	}
	
	@DataProvider(name="passing-login-details")
	  public static Object[][] passlogin() {
		  
		  Object data[][]= new Object[1][2];
		  
		  data[0][0] = "TestUserA5";
		  data[0][1] = "testusera";
		  	  
		  // TestUserA5
		  // shashwat9kumar
		  return data;
		  
	  }
	
	
	 
}
