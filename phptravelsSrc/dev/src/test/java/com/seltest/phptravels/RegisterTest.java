package com.seltest.phptravels;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class RegisterTest {
	
	
	WebDriver driver = null;
	
	@Test
	public void register() throws InterruptedException
	{
		
		/*System.setProperty("webdriver.chrome.driver","C:\\Users\\Anand\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();*/
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Anand\\Downloads\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://phptravels.com/demo/");
		//WebElement signin = driver.findElement(By.xpath("//*[@id='navbar']/form/a[text()='Login')]"));
		WebElement signin = driver.findElement(By.xpath("//*[@id='navbar']/form/a"));
		
		System.out.println("signin " + driver.getCurrentUrl());
	    System.out.println("signin " + driver.getTitle());
	    System.out.println("signin " + signin.getText());
		
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		if((signin.getText()).trim().equals("Login"))
		{
			signin.click();
			System.out.println(" Login in homepage clicked ");
		}
		
		System.out.println(" bef driver title " + driver.getTitle());
		
		for (String winHandle : driver.getWindowHandles()) 
		{
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		System.out.println(" aft driver title " + driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Secondary_Navbar-Account']/a")));
		
		System.out.println("Acct Reg " + driver.getCurrentUrl());
	    System.out.println("Acct Reg " + driver.getTitle());
		
	    WebElement account = driver.findElement(By.xpath("//*[@id='Secondary_Navbar-Account']/a"));
	    
	    if((account.getText()).trim().equals("Account"))
		{
	    	account.click();
		}
	    
	    WebElement login = driver.findElement(By.xpath("//*[@id='Secondary_Navbar-Account-Login']/a"));
	    if((login.getText()).trim().equals("Login"))
		{
	    	login.click();
		}
	    
	    //driver.close(); // close newly opened window when done with it
	    //driver.switchTo().window(parentHandle); // switch back to the original window
	    
	    WebElement inputEmail = driver.findElement(By.xpath("//*[@id='inputEmail']"));
	    inputEmail.sendKeys("vanand76@gmail.com");
	    WebElement inputPassword = driver.findElement(By.xpath("//*[@id='inputPassword']"));
	    inputPassword.sendKeys("Crystal123@");
	    WebElement loginSubmit = driver.findElement(By.xpath("//*[@id='login']"));
	    loginSubmit.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(.,'Welcome Back, Anand')]")));
	    WebElement elem = driver.findElement(By.xpath("//*[contains(.,'Welcome Back, Anand')]")); 
	    if (elem == null)  
	    {
	    	System.out.println("The text is not found on the page!");
	    }
	    else
	    {
	    	System.out.println("The text is found on the page!");
	    }
	    Assert.assertTrue(elem!=null);
	    
	    Set<Cookie> allCookies = driver.manage().getCookies();
	    
	    System.out.println("Number of cookies " + allCookies.size());
	    Assert.assertTrue(allCookies.size()==1);
		
	}
	
	/*@After
	public void tearDown()
	{
		driver.quit();
	}*/

}
