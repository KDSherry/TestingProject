package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	
	By heading = By.className("page-heading");
	By signInButton = By.id("SubmitLogin");
	By usernameField = By.name("email");
	By passwordField = By.name("passwd");
	
	public Login(WebDriver driver) { 
 		this.driver = driver; 
	} 
	
	public String getHeading(){
		return driver.findElement(heading).getText();
	}
	
	public void clickSignIn(){
		driver.findElement(signInButton).click();
	}
	
	public void enterUsername(String username){
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password){
		driver.findElement(passwordField).sendKeys(password);
	}
}
