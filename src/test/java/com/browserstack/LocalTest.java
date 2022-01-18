package com.browserstack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalTest extends BrowserStackTestNGTest {

    
	@Test
	public void Usecase1() throws InterruptedException

	{
        driver.get("http://bs-local.com:45691/check");
        Assert.assertTrue(driver.getPageSource().contains("Up and running"));
		System.out.print("\nLaunching Browser\n");
		driver.get("https://www.browserstack.com/");
		driver.navigate().to("https://www.browserstack.com//users/sign_in");
//		driver.findElement(By.xpath("(//a[text()='Sign in'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='user_email_login']")).sendKeys("arpit+demo@browserstack.com");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Sign me in']")).click();
		driver.navigate().to("https://live.browserstack.com/dashboard");
		driver.findElement(By.xpath("//a[text()='Live']")).click();
		driver.findElement(By.xpath("//div[@data-test-ositem='android']")).click();
		driver.findElement(By.xpath("//span[text()='Samsung']")).click();
		driver.findElement(By.xpath("//span[text()='Galaxy S21']")).click();
		driver.findElement(By.xpath("(//div[@data-test-device-browser='chrome'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		 
        //Calculate position canvas button
		WebElement canvasElement = driver.findElement(By.id("flashlight-overlay-native"));
		Actions builder = new Actions(driver);
		builder.moveToElement(canvasElement,80,20).doubleClick().sendKeys("browserstack.com").perform();	
		
	}
}
