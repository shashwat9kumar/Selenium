package twitter.testcases.console;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TweetTests {
	
	private WebDriver driver;
	
	private String location = "C:\\Users\\DELL\\eclipse-workspace\\testing\\reportTweetTests.html";
	private static ExtentReports report;
	private static ExtentTest test;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "D:\\DevOps tools\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");

		driver=new ChromeDriver();  

		driver.navigate().to("https://twitter.com/");	  
		driver.manage().window().maximize();
		
		report = new ExtentReports(location);
	}
	
	
	
	
	@BeforeMethod
	public static void startReport(Method result){
		test = report.startTest("Login Tests Report - " + result.getName());
	}
	
	@AfterMethod
	public void endReport(){
		report.endTest(test);
		report.flush();
	}
	
	
	@Test(priority = 0)
	public void tc_001_Login() throws InterruptedException {
		
		test.log(LogStatus.INFO, "The Login test Case");
		
		try {
			Thread.sleep(3000);
			WebElement helloSignIn = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/a[2]/div"));
			helloSignIn.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[2]/div/input")).sendKeys("TestUserA5");  
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[2]/label/div/div[2]/div/input")).sendKeys("testusera");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div")).click();
			Thread.sleep(2000);
			
			test.log(LogStatus.PASS, "The Login test Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Login test Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	// Search a famous personality
	@Test(priority = 1)
  	public void tc_002_Tweet() {
		
		test.log(LogStatus.INFO, "The Tweet test Case");
		
	  	try {
	  		WebElement x = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div"));                       
	  		x.sendKeys("Hello, World! Hope you all have a blessed day");
	  		Thread.sleep(4000);
//	  		x.submit();
	  		driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div[3]/div/span/span")).click();
	  		Thread.sleep(4000);
	  		
	  		test.log(LogStatus.PASS, "The Tweet test Case Passed");
	  	}
	  	catch(Exception e) {
			test.log(LogStatus.ERROR, "The Tweet test Case Failed");
			System.out.println("Error Encountered");
	  	}
	  
  	}
	
	
	
	// Search a famous hashtag
	@Test(priority = 2)
  	public void tc_003_Check_Recent_Tweet() {
		
		test.log(LogStatus.INFO, "The Check Recent Tweet test Case");
		
	  	try {
	  		driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[7]/div/div[2]/span")).click();
			Thread.sleep(4000);
			
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/div[2]/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span")).click();
			Thread.sleep(4000);
	  		
			test.log(LogStatus.PASS, "The Check Recent Tweet test Passed");
	  	}
	  	catch(Exception e) {
			test.log(LogStatus.ERROR, "The Check Recent Tweet test Failed");
			System.out.println("Error Encountered");
	  	}
	  
  	}
	
	
	
	@AfterClass
	public void terminate() {
//		driver.quit();
	}
}
