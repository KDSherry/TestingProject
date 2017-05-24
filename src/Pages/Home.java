package Pages;

import org.openqa.selenium.*;

public class Home {
	WebDriver driver;
	
	By logo = By.className("logo img-responsive");
	By loginLink = By.className("login");
	By item1 = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]");
	By cont1 = By.className("continue btn btn-default button exclusive-medium");
	
	public  Home(WebDriver driver) { 
		 		this.driver = driver; 
	} 
	
	//getter for title
	public String getLogo() { 
			return driver.getTitle(); 
 	} 
	
	public void clickLoginLink(){
		driver.get(driver.findElement(loginLink).getAttribute("href"));
	}
	
	public void addItem1(){
		driver.get(driver.findElement(item1).getAttribute("href"));
	}
	
	public void continue1(){
		driver.get(driver.findElement(cont1).getAttribute("href"));
	}
}
