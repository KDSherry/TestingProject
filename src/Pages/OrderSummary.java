package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummary {
	WebDriver driver;
	
	By pageheading= By.className("page-heading");
	By signOutButton = By.className("logout");
	By proceed = By.xpath("//*[@id=\"cart_navigation\"]/button");
		
	public OrderSummary(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public String getHeading() { 
		return driver.findElement(pageheading).getText();
	}

	public void proceedToCheckout() {
		driver.findElement(proceed).click();		
	}
}