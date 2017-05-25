package Tests;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
//import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.*;

public class UserFlow4 {

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
	public void valid_ad_viewer_test(){
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
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
		homepage.clickLoginLink();
		assertNotNull(loginpage.getHeading());
		
		//login
		loginpage.enterUsername("kieran.sherry@tesco.net");
		loginpage.enterPassword("test123");		
		loginpage.clickSignIn();
		accountpage.navHome();
		
		//back to homepage + confirm navigation
		assertNotNull(homepage.getLogo());
		
		//Navigate to dresses + confirm navigation
		homepage.clickDresses();
		assertEquals(dressespage.getTitle(),"DRESSES ");
		
		//Navigate to summer dresses + confirm navigation
		dressespage.clickSummerDresses();
		assertEquals(summerdressespage.getTitle(),"SUMMER DRESSES ");
		
		//add summer dress to cart
		summerdressespage.clickSDItem();
		
		//Navigate to T-shirts + confirm navigation
		cartpage.clickTShirtLink();
		assertEquals(tshirts.getTitle(), "T-SHIRTS ");
		
		//add T-shirt to cart
		tshirts.clickTSItem();
		
		//checkout
		cartpage.checkout();
		addresspage.proceedToCheckout();
		shippingpage.clickCheckBox();
		shippingpage.proceedToCheckout();
		paymentpage.proceedToCheckout();
		ordersummary.proceedToCheckout();
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
}
