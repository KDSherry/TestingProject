package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shipping {
	WebDriver driver;
	
	By pageheading= By.className("page-heading");
	By signOutButton = By.className("logout");
	By proceed = By.xpath("//*[@id=\"form\"]/p/button");
	By checkbox = By.id("uniform-cgv");
	
	public Shipping(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public String getHeading() { 
		return driver.findElement(pageheading).getText();
	}

	public void proceedToCheckout() {
		driver.findElement(proceed).click();		
	}
	
	public void clickCheckBox() {
		driver.findElement(checkbox).click();		
	}
}