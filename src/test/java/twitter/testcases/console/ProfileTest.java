package twitter.testcases.console;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProfileTest {
	
	
	private WebDriver driver;
	private String location = "C:\\Users\\DELL\\eclipse-workspace\\testing\\reportProfileTests.html";
	
	private static ExtentReports report;
	private static ExtentTest test;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:\\DevOps tools\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");

		driver=new ChromeDriver();  

		driver.navigate().to("https://twitter.com/");	  
		driver.manage().window().maximize();
		
		report = new ExtentReports(location);
	}
	
	@BeforeMethod
	public static void startReport(Method result){
		test = report.startTest("Profile Tests Report - " + result.getName());
	}
	
	@AfterMethod
	public void endReport(){
		report.endTest(test);
		report.flush();
	}
	
	
	//	Checking login functionality with all passing test cases
	@Test(dataProvider = "passing-login-details" , dataProviderClass = twitter.utils.ReadLoginData.class, priority=0)
	public void tc_001_Login(String username, String password) throws InterruptedException {
		
		test.log(LogStatus.INFO, "The Login test Case");
		
		try {
			Thread.sleep(3000);
			WebElement helloSignIn = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/a[2]/div"));
			helloSignIn.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[2]/div/input")).sendKeys(username);  
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[2]/label/div/div[2]/div/input")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div")).click();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "The Login test Cases Passes");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Login test Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	// To check the Profile of the in-use twitter account -- The Profile tab
	@Test(priority = 1)
	public void tc_002_Profile_Tab() throws InterruptedException {
			
		// Click the Profile tab
		
		test.log(LogStatus.INFO, "The Profile Tab Check Test Case");
		
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[7]/div/div[2]/span")).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "The Profile Tab Check Test Case passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Profile Tab Check Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	
// To check the overall Profile of the in-use twitter account -- The Profile tab
	@Test(priority = 2)
	public void tc_003_Overall_Profile_Checks() throws InterruptedException {
			
		// Check Tweets and Replies
		
		test.log(LogStatus.INFO, "The Profile Interface Check Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/nav/div/div[2]/div/div[2]/a/div/span")).click();
			Thread.sleep(4000);
			
			// Check Media
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/nav/div/div[2]/div/div[3]/a/div/span")).click();
			Thread.sleep(4000);
			
			// Check Likes
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/nav/div/div[2]/div/div[4]/a/div/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Profile Interface Check Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Profile Interface Check Test Case Failed");
			System.out.println("Error Encountered");
		}
		
	}
	
	
	
	// To check the Followers and Following of Profile of the in-use twitter account -- The Profile tab
	@Test(priority = 3)
	public void tc_004_Profile_Followers_and_Following_Checks() throws InterruptedException {
			
		// Check followers
		
		test.log(LogStatus.INFO, "The Profile folllowers-following Check Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/div[1]/div[2]/div[4]/div[2]/a/span[2]/span")).click();
			Thread.sleep(4000);
			
			// Check Following
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[2]/nav/div/div[2]/div/div[2]/a/div/span")).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "The Profile folllowers-following Check Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Profile folllowers-following Check Test Case Failed");
			System.out.println("Error Encountered");
		}
		
	}
	
	
	
	// To check the Followers and Following of Profile of the in-use twitter account -- The Profile tab
	@Test(priority = 4)
	public void tc_005_Profile_Logout() throws InterruptedException {
			
		// Click on Profile name
		
		test.log(LogStatus.INFO, "The Profile Logout Check Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/span")).click();
			Thread.sleep(4000);
			
			// Click on Logout
			
			driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/a[2]/div[1]/div/span/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Profile Logout Check Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Profile Logout Check Test Case Failed");
			System.out.println("Error Encountered");
		}
		
	}
	
	
	
	@AfterClass
	public void terminate() {
		driver.quit();
	}
}