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

public class ConsoleTests {
	
	
	private WebDriver driver;
	
	private String location = "C:\\Users\\DELL\\eclipse-workspace\\testing\\reportConsoleTests.html";
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
		test = report.startTest("Console Tests Report - " + result.getName());
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
			
			test.log(LogStatus.PASS, "The Login test Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Login test Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	// To check the most trending topic on Twitter -- The Explore tab
	@Test (priority = 1)
	public void tc_002_Explore_Tab() throws InterruptedException {
		
		// Explore button clicked
		
		test.log(LogStatus.INFO, "The Explore Tab Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div/div[2]/span")).click();
			Thread.sleep(2000);
			
			// Most trending topic opened
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/section/div/div/div[5]/div/div/div/div[1]/div/span")).click();
			Thread.sleep(4000);
			
			// Posts related to Covid 19 opened
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[2]/nav/div/div[2]/div/div[2]/a/div/span")).click();
			Thread.sleep(4000);
			
			// Posts related to Trending tweets
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[2]/nav/div/div[2]/div/div[3]/a/div/span")).click();
			Thread.sleep(4000);
			
			// Posts related to News tweets
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[2]/nav/div/div[2]/div/div[4]/a/div/span")).click();
			Thread.sleep(4000);
			
			// Posts related to Sports tweets
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[2]/nav/div/div[2]/div/div[5]/a/div/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Explore Tab Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Explore Tab Test Case Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	
	// To check the notifications from the in-use twitter account -- The Notification tab
	@Test(priority = 2)
	public void tc_003_Notifications_Tab() throws InterruptedException {
		
		// Click the notifications tab
		test.log(LogStatus.INFO, "The Notifications Tab Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[3]/div/div[2]/span")).click();
			Thread.sleep(4000);
			
			// Check the mentioned notifications
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[2]/nav/div/div[2]/div/div[2]/a/div/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Notifications Tab Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Notifications Tab Test Case Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	
	// To check the messages from the in-use twitter account -- The Messages tab
	@Test(priority = 3)
	public void tc_004_Messages_Tab() throws InterruptedException {
			
		// Click the Messages tab
		test.log(LogStatus.INFO, "The Messages Tab Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[4]/div/div[2]/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Messages Tab Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Messages Tab Test Case Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	
	// To check the bookmarks from the in-use twitter account -- The Bookmarks tab
	@Test(priority = 4)
	public void tc_005_Bookmarks_Tab() throws InterruptedException {
			
		// Click the Bookmarks tab
		test.log(LogStatus.INFO, "The Bookmarks Tab Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[5]/div/div[2]/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Bookmarks Tab Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Bookmarks Tab Test Case Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	
	// To check the lists from the in-use twitter account -- The Lists tab
	@Test(priority = 5)
	public void tc_006_Lists_Tab() throws InterruptedException {
			
		// Click the Lists tab
		
		test.log(LogStatus.INFO, "The Lists Tab Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[6]/div/div[2]/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Lists Tab Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Lists Tab Test Case Failed");
			System.out.println("Error Encountered");
		}
	}
	
	
	
	// To check the Profile of the in-use twitter account -- The Profile tab
	@Test(priority = 6)
	public void tc_007_Profile_Tab() throws InterruptedException {
			
		// Click the Profile tab
		
		test.log(LogStatus.INFO, "The Profile Tab Test Case");
		
		try {
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[7]/div/div[2]/span")).click();
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "The Profile Tab Test Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Profile Tab Test Case Failed");
			System.out.println("Error Encountered");
		}
		
	}
	
		
	
	@AfterClass
	public void terminate() {
		driver.quit();
	}
}
