package Testing_05_2017;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingDeliverable {

	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("automationpractice.com");
		
	}
	
	public static void userCase1(){
		
	}
	
	public static void userCase2(){
		
	}
	
	public static void userCase3(){
		
	}
	
	public static void userCase4(){
		
	}
}
