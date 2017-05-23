package Testing_05_2017;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTest {
	
	static WebDriver driver;
	
	public static void main(String[] args){
		//
		//String email = "kieran.sherry@tesco.net";
		//String password = "";
				
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		//goes to 
		driver.get("file:///C:/Users/Administrator/Desktop/HTML/HTML/Sortable.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean result = true;
		
		
		WebElement number1=null;
		WebElement number2=null;
		WebElement number3=null;
		WebElement number4=null;
		WebElement number5=null;
		WebElement number6=null;
		WebElement number7=null;
		WebElement number8=null;
		WebElement number9=null;
		WebElement number10=null;
		WebElement number11=null;
		WebElement number12=null;
		//try: to navigate the web page 
		try{
			//WebElement signInButton = driver.findElement(By.name("nav-action-inner"));
			//signInButton.click();
			 number1 = driver.findElement(By.name("one"));
			 number2 = driver.findElement(By.name("two"));
			 number3 = driver.findElement(By.name("three"));
			 number4 = driver.findElement(By.name("four"));
			 number5 = driver.findElement(By.name("five"));
			 number6 = driver.findElement(By.name("six"));
			 number7 = driver.findElement(By.name("seven"));
			 number8 = driver.findElement(By.name("eight"));
			 number9 = driver.findElement(By.name("nine"));
			 number10 = driver.findElement(By.name("ten"));
			 number11 = driver.findElement(By.name("eleven"));
			 number12 = driver.findElement(By.name("twelve"));
			
			//
		//catch detects non existent element	
		}catch(NoSuchElementException e ){
			System.out.println(e);
			result = false;
		}

		Actions builder = new Actions(driver);
		
		org.openqa.selenium.Point init1 = number1.getLocation();
		org.openqa.selenium.Point init12 = number12.getLocation();
		
		builder.dragAndDrop(number2, number3).perform();
		wait(600);
				
		builder.dragAndDrop(number12, number1).perform();
		wait(600);
		builder.dragAndDrop(number11, number1).perform();
		wait(600);
		builder.dragAndDrop(number9, number1).perform();
		wait(600);
		builder.dragAndDrop(number10, number9).perform();
		wait(600);
		builder.dragAndDrop(number8, number1).perform();
		wait(600);
		builder.dragAndDrop(number7, number1).perform();
		wait(600);
		builder.dragAndDrop(number5, number1).perform();
		wait(600);
		builder.dragAndDrop(number6, number5).perform();
		wait(600);
		builder.dragAndDrop(number4, number1).perform();
		wait(600);
		builder.dragAndDrop(number3, number1).perform();
		wait(600);
		builder.dragAndDrop(number2, number1).perform();
		
		org.openqa.selenium.Point final1 = number1.getLocation();
		org.openqa.selenium.Point final12 = number12.getLocation();
		
		if (init1.equals(final12) && init12.equals(final1)){
			System.out.println("1 and 12 moved to correct locations");
		}
		else{
			System.out.println("INCORRECT MOVE DETECTED!!!");
		}
		
		if(result){
			System.out.println("Test Passed");
		}
		else{
			System.out.println("TEST FAILURE!!!");
		}
		
	}
	
	
	
	
	
	
	
	/*
	WebDriverWait wait = new WebDriverWait(driver, 5); 
			boolean testElement = false; 
	 		try { 
	 			System.out.println("Searching..."); 
	 			testElement = wait .until(ExpectedConditions.textToBePresentInElementLocated(By.id( "ap_email"),"Success")); 
	 		} catch (Exception e) { 
				e.printStackTrace(); 
				testElement = false; 
 		} 
	 */
	
	
	
	
	
	public static void wait(int waitTimeMilli){
		try{
			Thread.sleep(600);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
}
