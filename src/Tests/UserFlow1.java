package Tests;


import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.*;

public class UserFlow1 {

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
		
		homepage = new Home(driver);
		loginpage = new Login(driver);
		accountpage = new Account(driver);
		
		
		//Confirm Homepage has been accessed
		assertNotNull(homepage.getLogo());
		homepage.clickLoginLink();	
		
		
		//On the Login Page
		assertNotNull(loginpage.getHeading());
		loginpage.enterUsername("kieran.sherry@tesco.net");
		loginpage.enterPassword("test123");		
		loginpage.clickSignIn();
		
		//On the Account page
		assertNotNull(accountpage.getHeading());
		accountpage.clickSignOut();
		
		assertNotNull(homepage.getLogo());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
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
