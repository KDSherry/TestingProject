package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {
	WebDriver driver;
	
	By pageheading= By.className("page-heading");
	By signOutButton = By.className("logout");
	By home = By.xpath("//*[@id=\"center_column\"]/ul/li/a");
	
	public Account(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public void clickSignOut(){
		driver.get(driver.findElement(signOutButton).getAttribute("href"));
	}
	
	public String getHeading() { 
		return driver.findElement(pageheading).getText();
	}

	public void navHome() {
		driver.findElement(home).click();		
	}
}
