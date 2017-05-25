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

public class UserFlow3 {

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
		
		homepage = new Home(driver);
		advert = new Advert(driver);
		
		//confirm on homepage
		assertNotNull(homepage.getLogo());
		
		//click through the banner
		homepage.clickNextBanner();
		homepage.clickNextBanner();
		homepage.clickNextBanner();
		
		//click top advert
		homepage.clickAd1();
		
		//confirm different webpage
		assertNotNull(advert.getTitle());
		
		//go back to home and confirm
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		
		//click lower advert
		homepage.clickAd2();
		
		//confirm different webpage
		assertNotNull(advert.getTitle());
		
		//go back to home and confirm
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		
		//view best sellers
		homepage.viewBestSellers();
		assertNotNull(homepage.getLogo());
		
		//view popular
		homepage.viewPopular();
		assertNotNull(homepage.getLogo());
		
		//view topTrendsAd	
		homepage.viewTopTrendsAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		
		//view mensCoatsAd		
		homepage.viewMensCoatsAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		
		//view womensCoatsAd		
		homepage.viewWomensCoatsAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		
		//view sunglassesAd		
		homepage.viewSunglassesAd();
		driver.navigate().back();
		assertNotNull(homepage.getLogo());
		
		//view bagsAd
		homepage.ViewBagsAd();
		driver.navigate().back();
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
