package Tests;


import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.*;

public class UserFlow1 {
	
	ExtentReports report; 
	ExtentTest test; 
	WebElement element;
	static WebDriver driver;
	
	Home homepage;
	Login loginpage;
	Account accountpage;
	
	@BeforeClass	
	public static void setup(){		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	} 
	

	@Test
	public void valid_Home_toLogin_andlogout_Navigation(){
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\java\\Result\\UserFlow1Test.html", true);
		
		// Initialise / start the test
		test = report.startTest("Test login and logout");
		test.log(LogStatus.INFO, "Test started");
				
		homepage = new Home(driver);
		loginpage = new Login(driver);
		accountpage = new Account(driver);
		
		
		//Confirm Homepage has been accessed
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.INFO, "Navigating to Login Page");
		homepage.clickLoginLink();	
		
		
		//On the Login Page
		assertNotNull(loginpage.getHeading());
		test.log(LogStatus.PASS, "Login page Accessed");
		
		//Enter user email
		test.log(LogStatus.INFO, "Entering User Email");
		loginpage.enterUsername("kieran.sherry@tesco.net");
		if(loginpage.getEnteredEmail().equals("kieran.sherry@tesco.net")){
			test.log(LogStatus.PASS, "User Email Entered Successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Email Entered Unsuccessfully");
		}
		
		//Enter User Password
		test.log(LogStatus.INFO, "Entering User Password");
		loginpage.enterPassword("test123");
		if(loginpage.getEnteredPassword().equals("test123")){
			test.log(LogStatus.PASS, "Password Entered Successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Password Entered Unsuccessfully");
		}
		
		
		//Signing in User
		test.log(LogStatus.INFO, "Signing in");
		loginpage.clickSignIn();
		test.log(LogStatus.PASS, "User Signed in Successfully");
		
		//On the Account page
		test.log(LogStatus.INFO, "Confirming navigation to the Account Page");
		assertNotNull(accountpage.getHeading());
		if(accountpage.getHeading() != null){
			test.log(LogStatus.PASS, "Confirmed on the Account Page");
		}
		else{
			test.log(LogStatus.FAIL, "Failure: Not on the Account Page");
		}
		
		
		//Signing out
		test.log(LogStatus.INFO, "Signing out from the Account Page");
		accountpage.clickSignOut();
		test.log(LogStatus.PASS, "User Signed Out Successfully");
		
		//Confirming back on Homepage 
		test.log(LogStatus.INFO, "Confirming navigation to the Home Page");
		assertNotNull(homepage.getLogo());
		if(homepage.getLogo() != null){
			test.log(LogStatus.PASS, "Confirmed on the Home Page");
		}
		else{
			test.log(LogStatus.FAIL, "Failure: Not on the Home Page");
		}
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());

		// report the test as a pass
		test.log(LogStatus.PASS, "Login and Logout: Successful");
		report.endTest(test);
		report.flush();

	}
	
	
	
	@AfterClass
	public static void tearDown() { 
		try { 
			driver.close(); 
		} catch (Exception ex) { 
			System.out.println(ex.toString()); 
	 	} 
	} 
}
