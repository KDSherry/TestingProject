package Pages;

import org.openqa.selenium.*;

public class Home {
	WebDriver driver;
	
	By logo = By.className("logo img-responsive");
	By loginLink = By.className("login");
	By item1 = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]");
	By cont1 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[2]");
	By item2 = By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]");
	By cartLink = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
	By nextOnSlider = By.className("bx-next");
	By ad1 = By.xpath("//*[@id=\"htmlcontent_top\"]/ul/li[1]/a/img");
	By ad2 = By.xpath("//*[@id=\"htmlcontent_top\"]/ul/li[2]/a/img");
	By bestSellers = By.className("blockbestsellers");
	By popular = By.xpath("//*[@id=\"home-page-tabs\"]/li[1]/a");
	By topTrendsAd	= By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[1]/a/img");	
	By mensCoatsAd	= By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[2]/a/img");	
	By womensCoatsAd	= By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[3]/a/img");
	By sunglassesAd	= By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[4]/a/img");	
	By bagsAd	= By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[5]/a/img");	
	By DressesLink = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	
	
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
	
	public void addItem2(){
		driver.get(driver.findElement(item2).getAttribute("href"));
	}
	
	public void continueShopping(){
		driver.get(driver.findElement(cont1).getAttribute("href"));
	}
	
	public void clickViewCart(){
		driver.get(driver.findElement(cartLink).getAttribute("href"));
	}
	
	public void clickDresses(){
		driver.get(driver.findElement(DressesLink).getAttribute("href"));
	}
	
	
	//Ads
	public void clickNextBanner(){
		driver.findElement(nextOnSlider).click();
	}
	public void clickAd1(){
		driver.findElement(ad1).click();
	}
	public void clickAd2(){
		driver.findElement(ad2).click();
	}
	public void viewBestSellers(){
		driver.findElement(bestSellers).click();
	}
	public void viewPopular(){
		driver.findElement(popular).click();
	}	
	public void viewTopTrendsAd(){
		driver.findElement(topTrendsAd).click();
	}
	public void viewMensCoatsAd(){
		driver.findElement(mensCoatsAd).click();
	}
	public void viewWomensCoatsAd(){
		driver.findElement(womensCoatsAd).click();
	}
	public void viewSunglassesAd	(){
		driver.findElement(sunglassesAd	).click();
	}
	public void ViewBagsAd(){
		driver.findElement(bagsAd).click();
	}
}
