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

public class UserFlow3 {

	ExtentReports report; 
	ExtentTest test; 
	WebElement element;
	static WebDriver driver;
	
	Home homepage;
	Login loginpage;
	Advert advert;
	
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
		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\java\\Result\\UserFlow3Test.html", true);
		
		test = report.startTest("Test Viewing all The Ads");
		test.log(LogStatus.INFO, "Browser started");
		
		homepage = new Home(driver);
		advert = new Advert(driver);
		
		//confirm on homepage
		assertNotNull(homepage.getLogo());
		
		//click through the banner
		test.log(LogStatus.INFO, "Test Banner Functions");
		homepage.clickNextBanner();
		homepage.clickNextBanner();
		homepage.clickNextBanner();
		test.log(LogStatus.PASS, "Banner Functions Successfully");
		
		//click top advert
		test.log(LogStatus.INFO, "Test Advert1");
		homepage.clickAd1();
		
		//confirm different webpage
		assertNotNull(advert.getTitle());
		test.log(LogStatus.PASS, "Advert1 functions Successfully");
		
		//go back to home and confirm
		test.log(LogStatus.INFO, "Navigating Back to Home");
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Navigated Back Successfully");
		
		//click lower advert
		test.log(LogStatus.INFO, "Test Advert2");
		homepage.clickAd2();
		
		//confirm different webpage
		assertNotNull(advert.getTitle());
		test.log(LogStatus.PASS, "Advert2 functions Successfully");
		
		//go back to home and confirm
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		
		//view best sellers
		test.log(LogStatus.INFO, "Test Best Sellers Tab");
		homepage.viewBestSellers();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Best Sellers Tab functions Successfully");
		
		//view popular
		test.log(LogStatus.INFO, "Test Popular Tab");
		homepage.viewPopular();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Popular Tab functions Successfully");
				
		//view topTrendsAd	
		test.log(LogStatus.INFO, "Test Top Trends Advert");
		homepage.viewTopTrendsAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Top Trends Advert functions Successfully");
		
		//view mensCoatsAd		
		test.log(LogStatus.INFO, "Test Mens Coats Advert");
		homepage.viewMensCoatsAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Mens Coats Advert functions Successfully");
		
		//view womensCoatsAd		
		test.log(LogStatus.INFO, "Test Womens Coats Advert");
		homepage.viewWomensCoatsAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Womens Coats Advert functions Successfully");
		
		//view sunglassesAd	
		test.log(LogStatus.INFO, "Test Sunglasses Advert");
		homepage.viewSunglassesAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Sunglasses Advert functions Successfully");
		
		//view bagsAd
		test.log(LogStatus.INFO, "Test Bags Advert");
		homepage.ViewBagsAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		test.log(LogStatus.PASS, "Bags Advert functions Successfully");
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		test.log(LogStatus.PASS, "Successfully Tested Viewing all The Ads");
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
