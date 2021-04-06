package twitter.utils;

import org.testng.annotations.DataProvider;

public class ReadLoginData {
	@DataProvider(name="passing-login-details")
	  public static Object[][] passlogin() {
		  
		  Object data[][]= new Object[1][2];
		  
		  data[0][0] = "TestUserA5";
		  data[0][1] = "testusera";
		  
//		  data[1][0] = "9839904296";
//		  data[1][1] = "@Gita24";
		  
		  
		  return data;
		  
	  }
}
