package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;


public class TShirts {
	
	WebDriver driver;
	
	By title = By.xpath("//*[@id=\"center_column\"]/h1/span[1]");
	By item = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]");
	
	public TShirts(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public String getTitle() { 
		return driver.findElement(title).getText(); 
	} 
	
	public void clickTSItem(){
		driver.get(driver.findElement(item).getAttribute("href"));
	}
}