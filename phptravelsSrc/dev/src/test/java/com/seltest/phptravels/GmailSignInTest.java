package com.seltest.phptravels;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class GmailSignInTest
{
	@Test
	public void gmailLoginShouldBeSuccessful()
	{
		/*FirefoxBinary ffbinary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
		FirefoxProfile ffprofile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffbinary,ffprofile);*/
		
		/*System.setProperty("webdriver.firefox.marionette","C:\\Users\\Anand\\Downloads\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();*/
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anand\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		WebElement usernameTextbox = driver.findElement(By.id("Email"));
		usernameTextbox.clear();
		usernameTextbox.sendKeys("udemyken@gmail.com");
		
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		WebElement next = driver.findElement(By.id("next"));
		next.click();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
		passwordTextbox.clear();
		passwordTextbox.sendKeys("udemyken123");
		
		WebElement signInButton = driver.findElement(By.id("signin"));
		signInButton.click();
		
		Assert.assertTrue(driver.findElements(By.partialLinkText("Inbox")).size()>0);
	}
	
}