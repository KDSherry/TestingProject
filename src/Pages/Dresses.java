package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;


public class Dresses {
	
	WebDriver driver;
	
	By title = By.xpath("//*[@id=\"center_column\"]/h1/span[1]");
	By summerDresses = By.xpath("//*[@id=\"subcategories\"]/ul/li[3]/div[1]/a");
	
	
	public Dresses(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public String getTitle() { 
		return driver.findElement(title).getText(); 
	} 
	
	public void clickSummerDresses(){
		driver.findElement(summerDresses).click();
	}
}
