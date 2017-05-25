package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	WebDriver driver;
	
	By pageheading= By.id("cart_title");
	By signOutButton = By.className("logout");
	By Item1Deletion = By.id("1_1_0_0");
	By Item2Deletion = By.id("2_7_0_0");
	By emptyCartAlert = By.xpath("//*[@id=\"center_column\"]/p");
	By homePageLink = By.xpath("//*[@id=\"header_logo\"]/a/img");
	By TShirtLink = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
	By checkout = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
	
	public Cart(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public void clickSignOut(){
		driver.get(driver.findElement(signOutButton).getAttribute("href"));
	}
	
	public WebElement getHeading() { 
		return driver.findElement(pageheading);
	}
	
	public WebElement emptyCart() { 
		return driver.findElement(emptyCartAlert);
	}
	
	public void removeItem1(){
		driver.get(driver.findElement(Item1Deletion).getAttribute("href"));
	}
	
	public void removeItem2(){
		driver.get(driver.findElement(Item2Deletion).getAttribute("href"));
	}
	
	public void clickHomePageLink(){
		driver.findElement(homePageLink).click();
	}
	
	public void clickTShirtLink(){
		driver.findElement(TShirtLink).click();
	}
	
	public void checkout(){
		driver.findElement(checkout).click();
	}
}