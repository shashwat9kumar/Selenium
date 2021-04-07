package twitter.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_HealthCheck {
	
	private WebDriver driver;
	
	private String location = "C:\\Users\\DELL\\eclipse-workspace\\testing\\reportHealthCheck.html";
	private static ExtentReports report;
	private static ExtentTest test;
	
	@BeforeClass
	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		ChromeDriverManager.getInstance().setup();
		
//		System.setProperty("webdriver.chrome.driver", "D:\\DevOps tools\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");

//		driver=new ChromeDriver();  
//
//		driver.navigate().to("https://twitter.com/");	  
//		driver.manage().window().maximize();
		
		report = new ExtentReports(location);
	}
	
	
	
	@BeforeMethod
	public static void startReport(Method result){
		test = report.startTest("Health Check Report - " + result.getName());
	}
	
	@AfterMethod
	public void endReport(){
		report.endTest(test);
		report.flush();
	}
	
	
	
//	Checking to see if the site works fine on Chrome
	@Test
	public void tc_001_Chrome() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();  

		driver.navigate().to("https://twitter.com/");	  
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		test.log(LogStatus.WARNING, "The Health Check has started for Chrome");
		test.log(LogStatus.INFO, "The Health Check will test site availibility and reachibility");
		try {
			WebElement helloSignIn = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/a[2]"));
			helloSignIn.click();
			
			Thread.sleep(2000);
			test.log(LogStatus.WARNING, "The Health Check has successful. Progressing with further tests");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Health Check has Failed");
			System.out.println("Error Encountered");
		}
		
		driver.quit();
	}
	
	
	//Checking to see if the site works fine on Firefox
	@Test
	public void tc_002_Firefox() throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		
		driver=new FirefoxDriver();  

		driver.navigate().to("https://twitter.com/");	  
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		test.log(LogStatus.WARNING, "The Health Check has started for Firefox");
		test.log(LogStatus.INFO, "The Health Check will test site availibility and reachibility");
		try {
			WebElement helloSignIn = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/a[2]"));
			helloSignIn.click();
			
			Thread.sleep(2000);
			test.log(LogStatus.WARNING, "The Health Check has successful. Progressing with further tests");
		}
		catch(Exception e) {
			test.log(LogStatus.ERROR, "The Health Check has Failed");
			System.out.println("Error Encountered");
		}
		
		driver.quit();
	}
	
	
	
	//Checking to see if the site works fine on Edge 
		@Test
		public void tc_003_Edge() throws InterruptedException {
			
			WebDriverManager.edgedriver().setup();
			
			driver=new EdgeDriver();  

			driver.navigate().to("https://twitter.com/");	  
			driver.manage().window().maximize();
			
			Thread.sleep(2000);
			
			test.log(LogStatus.WARNING, "The Health Check has started for Edge");
			test.log(LogStatus.INFO, "The Health Check will test site availibility and reachibility");
			try {
				WebElement helloSignIn = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/a[2]"));
				helloSignIn.click();
				
				Thread.sleep(2000);
				test.log(LogStatus.WARNING, "The Health Check has successful. Progressing with further tests");
			}
			catch(Exception e) {
				test.log(LogStatus.ERROR, "The Health Check has Failed");
				System.out.println("Error Encountered");
			}
			
			driver.quit();
		}
	
	
	
	
	
	@AfterClass
	public void terminate() {
		driver.quit();
	}
}
