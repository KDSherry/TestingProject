package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Address {
	WebDriver driver;
	
	By pageheading= By.className("page-heading");
	By signOutButton = By.className("logout");
	By proceed = By.xpath("//*[@id=\"center_column\"]/form/p/button");
	
	public Address(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public String getHeading() { 
		return driver.findElement(pageheading).getText();
	}

	public void proceedToCheckout() {
		driver.findElement(proceed).click();		
	}
}