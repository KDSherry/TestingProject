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

public class UserFlow2 {
	
	ExtentReports report; 
	ExtentTest test; 
	WebElement element;
	static WebDriver driver;
	
	Home homepage;
	Login loginpage;
	Account accountpage;
	Cart cart;
	
	@BeforeClass	
	public static void setup(){		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	} 
	

	@Test
	public void add_remove_fromcart(){
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\java\\Result\\UserFlow2Test.html", true);
		
		test = report.startTest("Test Adding and Removing Items from Cart");
		test.log(LogStatus.INFO, "Browser started");
		
		homepage = new Home(driver);
		loginpage = new Login(driver);
		cart= new Cart(driver);
		
		//Confirm Homepage has been accessed                      
		assertNotNull(homepage.getLogo());
		
		//add item to cart
		test.log(LogStatus.INFO, "Testing Adding Item to Cart");
		homepage.addItem1();
		System.out.println("Item selected and added to cart");
		test.log(LogStatus.PASS, "Item Added to Cart Successfully");
		homepage.continueShopping();
		
		//add second item to cart
		test.log(LogStatus.INFO, "Testing Adding Different Item to Cart");
		homepage.addItem2();
		System.out.println("Item selected and added to cart");
		test.log(LogStatus.PASS, "Item Added to Cart Successfully");
		homepage.continueShopping();
		
		//view cart
		test.log(LogStatus.INFO, "Testing Viewing the Cart");
		homepage.clickViewCart();
				
		//confirm viewing cart
		cart.getHeading();
		test.log(LogStatus.PASS, "Cart Viewed Successfully");
		
		//remove items from cart
		test.log(LogStatus.INFO, "Testing Removing Items From the Cart");
		cart.removeItem1();
		cart.removeItem2();
				
		//check cart is empty
		assertNotNull(cart.emptyCart());
		if(cart.emptyCart() != null){
			test.log(LogStatus.PASS, "Cart Emptied Successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Cart Emptied Unsuccessfully");
		}
		
		//navigate back to homepage
		cart.clickHomePageLink();
		 
		assertNotNull(homepage.getLogo());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		test.log(LogStatus.PASS, "Adding and Removing Items from Cart: Successful");
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
