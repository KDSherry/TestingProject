package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Advert {
	
	WebDriver driver;
	By title = By.xpath("//*[@id=\"header\"]/div/div[1]/a/img[2]");
	
	public Advert(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public WebElement getTitle() { 
		return driver.findElement(title); 
	} 
	
}
