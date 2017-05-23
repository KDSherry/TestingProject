package Testing_05_2017;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.*;

public class LoginCookies {

	static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)throws Exception {
		boolean result = true;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//go to the bbc website
		driver.navigate().to("http://www.bbc.co.uk/");
		Actions builder = new Actions(driver);
		
		File f = new File("C:\\Users\\Administrator\\Desktop\\HTML\\browserdata.txt");
		f.delete();
		f.createNewFile();
		BufferedWriter bos = new BufferedWriter(new FileWriter(f));
				
		
		try{
			//log in 
			WebElement signInButton = driver.findElement(By.id("idcta-link"));
			signInButton.click();		
			WebElement usernamebox = driver.findElement(By.id("username-input"));
			usernamebox.sendKeys("kieran.sherry@tesco.net");
			WebElement passwordbox = driver.findElement(By.id("password-input"));
			passwordbox.sendKeys("test0000\n");
			driver.findElement(By.id("idcta-link"));
						
			
		}catch(NoSuchElementException e ){
			System.out.println(e);
			result = false;
		}
		
		for(Cookie ck : driver.manage().getCookies()) {
			bos.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain() +";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
			bos.newLine();
		}
		bos.close();
		
		try{
			//log out 
			WebElement signInButton = driver.findElement(By.id("idcta-link"));
			signInButton.click();
			driver.findElement(By.xpath("//*[@id=\"orb-modules\"]/div[1]/div/div/div[1]/div[2]/div/div/div/h2"));
			System.out.println("Logged out   \n Gotcha : logged in");
			WebElement signOut = driver.findElement(By.xpath("//*[@id=\"orb-modules\"]/div[1]/div/div/div[1]/div[1]/div/div/div/div/nav/ul/li[3]"));
			signOut.click();
			driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div/div/h1"));
			System.out.println("Logged out");
			driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div/div/div/div/a")).click();
			
		}catch(NoSuchElementException e ){
			System.out.println(e);
			result = false;
		}
		
		File f2 = new File("C:\\Users\\Administrator\\Desktop\\HTML\\browserdata.txt");
		BufferedReader br = new BufferedReader(new FileReader(f2));
		String line;
		
		while((line=br.readLine())!=null){
			StringTokenizer str = new StringTokenizer(line,";");
		
			while(str.hasMoreTokens()){
				String name = str.nextToken();
				String value = str.nextToken();
				String domain = str.nextToken();
				String path = str.nextToken();
				Date expiry = null;
				String dt;
				
				if(!(dt=str.nextToken()).equals("null")){
					System.out.println(dt);
					SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
					expiry = sdf.parse(dt);
				}
		
				boolean isSecure = new Boolean(str.nextToken()).booleanValue();
				Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
				driver.manage().addCookie(ck);
		
			}
		
		
		}
		br.close();
		driver.navigate().refresh();
	}
}
