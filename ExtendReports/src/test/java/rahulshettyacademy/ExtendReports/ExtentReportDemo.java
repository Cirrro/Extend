package rahulshettyacademy.ExtendReports;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;
	@BeforeTest
	public void config()
	{
	//	ExtentReports , ExtentSparkReporter - expect path where report should be created
		//creating report folder dynamically
		String path = System.getProperty("user.dir") + "//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		//ExtentReport - the one responsible to drive all report execution, responsible to create and consolidate report execution
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul Shetty");
		
	}
	
	
	@Test
	public void initialDemo()
	
	{
		ExtentTest test = extent.createTest("Initial Demo"); //ExtentTest - responsible for listening and what are the happenings back to extentreports
		System.setProperty("webdriver.chrome.driver", "/Users/mikkobadillo/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Result do not match"); //example failing test
		extent.flush(); //flush - notify the test is done and will stop monitoring, mandatory to add this flush method at the end of execution
		
		
	}
	
	
}
