package com.browserstack.suite;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest01 extends BrowserStackTestNGTest {

	@Test
	public void Usecase1() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException

	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        try {
        
		System.out.print("\nLaunching Browser\n");
		driver.get("https://www.browserstack.com/");
		driver.navigate().to("https://www.browserstack.com//users/sign_in");
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
		WebElement canvasElement = driver.findElement(By.id("flashlight-overlay-native"));
		Actions builder = new Actions(driver);
		builder.moveToElement(canvasElement,80,20).doubleClick().sendKeys("browserstack.com").perform();
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Test case executed succesfully!\"}}");
        }
        catch (Exception e) {
        	
        	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"One of the steps failed\"}}");
        }
		
	}
}
