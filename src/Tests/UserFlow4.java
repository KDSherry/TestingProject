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

public class UserFlow4 {

	ExtentReports report; 
	ExtentTest test; 
	WebElement element;
	static WebDriver driver;
	
	Home homepage;
	Dresses dressespage;
	SummerDresses summerdressespage;
	Cart cartpage;
	Login loginpage;
	TShirts tshirts;
	Account accountpage;
	Address addresspage;
	Shipping shippingpage;
	Payment paymentpage;
	OrderSummary ordersummary;
	
	@BeforeClass	
	public static void setup(){		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	} 
	
	@Test
	public void valid_purchase_of_multiple_items(){
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\java\\Result\\UserFlow4Test.html", true);
		
		test = report.startTest("Test Purchasing of Products");
		test.log(LogStatus.INFO, "Browser started");
		
		homepage = new Home(driver);
		dressespage = new Dresses(driver);
		summerdressespage = new SummerDresses(driver);
		cartpage = new Cart(driver);
		tshirts = new TShirts(driver);
		loginpage = new Login(driver);
		accountpage = new Account(driver);
		addresspage = new Address(driver);
		shippingpage = new Shipping(driver);
		paymentpage = new Payment(driver);
		ordersummary = new OrderSummary(driver);
		
		//nav to login
		test.log(LogStatus.INFO, "Logging in");
		homepage.clickLoginLink();
		assertNotNull(loginpage.getHeading());
		if(loginpage.getHeading()!= null){
			test.log(LogStatus.PASS, "Navigated to Login Page Successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Failed to Navigate to Login Page");
		}
		
		//login
		loginpage.enterUsername("kieran.sherry@tesco.net");
		loginpage.enterPassword("test123");		
		loginpage.clickSignIn();
		accountpage.navHome();
		test.log(LogStatus.PASS, "Logged in Successfully");
		
		//back to homepage + confirm navigation
		assertNotNull(homepage.getLogo());
		
		//Navigate to dresses + confirm navigation
		test.log(LogStatus.INFO, "Navigating to Dresses");
		homepage.clickDresses();
		assertEquals(dressespage.getTitle(),"DRESSES ");
		if(dressespage.getTitle().equals("DRESSES ")){
			test.log(LogStatus.PASS, "Navigated to Dresses Successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Failed to Navigate to Dresses");
		}
				
		//Navigate to summer dresses + confirm navigation
		test.log(LogStatus.INFO, "Navigating to Dresses");
		dressespage.clickSummerDresses();
		assertEquals(summerdressespage.getTitle(),"SUMMER DRESSES ");		
		if(summerdressespage.getTitle().equals("SUMMER DRESSES ")){
			test.log(LogStatus.PASS, "Navigated to Summer Dresses Successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Failed to Navigate to Summer Dresses");
		}
		
		//add summer dress to cart
		test.log(LogStatus.INFO, "Add Summer Dress to Cart");
		summerdressespage.clickSDItem();
		test.log(LogStatus.PASS, "Summer Dress added to Cart Successfully");
		
		//Navigate to T-shirts + confirm navigation
		test.log(LogStatus.INFO, "Navigating to T-Shirts");
		cartpage.clickTShirtLink();
		assertEquals(tshirts.getTitle(), "T-SHIRTS ");		
		if(tshirts.getTitle().equals("T-SHIRTS ")){
			test.log(LogStatus.PASS, "Navigated to T-Shirts Successfully");
		}
		else{
			test.log(LogStatus.FAIL, "Failed to Navigate to T-Shirts");
		}
		
		//add T-shirt to cart
		test.log(LogStatus.INFO, "Add T-Shirt to Cart");
		tshirts.clickTSItem();
		test.log(LogStatus.PASS, "T-Shirt added to Cart Successfully");
		
		//checkout
		//Cart Page
		test.log(LogStatus.INFO, "Click Checkout On Cart");
		assertNotNull(cartpage.getHeading());
		cartpage.checkout();
		test.log(LogStatus.PASS, "Checkout Clicked Successfully");
		
		//Address Page
		test.log(LogStatus.INFO, "Click 'Proceed To Checkout' On Address Page");
		assertEquals(addresspage.getHeading(),"ADDRESSES");
		addresspage.proceedToCheckout();
		test.log(LogStatus.PASS, "Proceed To Checkout Clicked Successfully");
		
		//Shipping Page
		test.log(LogStatus.INFO, "Click CheckBox On Shipping Page");
		assertEquals(shippingpage.getHeading(),"SHIPPING");
		shippingpage.clickCheckBox();
		test.log(LogStatus.PASS, "Checkbox Clicked Successfully");
		test.log(LogStatus.INFO, "Click 'Proceed To Checkout' On Shipping Page");
		shippingpage.proceedToCheckout();
		test.log(LogStatus.PASS, "Proceed To Checkout Clicked Successfully");
		
		//Payment Page
		test.log(LogStatus.INFO, "Click 'Proceed To Checkout' On Payment Page");
		assertEquals(paymentpage.getHeading(),"PLEASE CHOOSE YOUR PAYMENT METHOD");
		paymentpage.proceedToCheckout();
		test.log(LogStatus.PASS, "Proceed To Checkout Clicked Successfully");
		
		//Order Summary Page
		test.log(LogStatus.INFO, "Click 'Proceed To Checkout' On Order Summary Page");
		assertEquals(ordersummary.getHeading(),"ORDER SUMMARY");
		ordersummary.proceedToCheckout();
		test.log(LogStatus.PASS, "Proceed To Checkout Clicked Successfully");
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		test.log(LogStatus.PASS, "Test Purchasing of Products: Passed");
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
