package twitter.testcases.console;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class EngagementTest {
private WebDriver driver;
	
	private String location = "/Users/isshu/eclipse-workspace/Twitter_Testing/CommentFunctionalityTest.html";
	private static ExtentReports report;
	private static ExtentTest test;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "/Users/isshu/Desktop/Test_Automation/Selenium_Drivers/chromedriver");

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
	@Test
	(dataProvider = "passing-login-details" , dataProviderClass = twitter.utils.ReadLoginData.class, priority=0)
	public void tc_001_Login(String username, String password) throws InterruptedException {
		
		test.log(LogStatus.INFO, "The Login test Case");
		
		try {
			Thread.sleep(3000);
			WebElement helloSignIn = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/a[2]/div"));
			helloSignIn.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[2]/div/input")).sendKeys(username);  
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[2]/label/div/div[2]/div/input")).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div")).click();
			Thread.sleep(1000);
			
			test.log(LogStatus.PASS, "The Login test Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Login test Failed");
			System.out.println("Error Encountered");
		}
	}
	
	// Searching of the article or post on Twitter related to "COVID-19"
	@Test(priority=1)
	public void tc_002_Search_article() throws InterruptedException {
		test.log(LogStatus.INFO, "The Search Article Test Case");
		
		try {
			
			WebElement Search_article = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/div/div/form/div[1]/div/div/div[2]/input"));
			Search_article.sendKeys("COVID-19" + Keys.RETURN);
			Thread.sleep(3000);
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,1000)");
			
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/section/div/div/div[17]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div")).click();
			Thread.sleep(3000);
			
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,700)");
			 
//			 Comment the searched article or post 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/section/div/div/div[1]/div/div/article/div/div/div/div[3]/div[5]/div[1]/div/div/div")).click();
			
			Thread.sleep(3000);
			WebElement Tweet_reply = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div"));
			Tweet_reply.sendKeys("This is comment");
			
			driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/span/span")).click();
			
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "The Search Article Case Passed");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Search Article Test Case Failed");
			System.out.println("Error Encountered");
		}
		
	}
		
	
	@AfterClass
	public void terminate() {
		driver.quit();
	}
}
