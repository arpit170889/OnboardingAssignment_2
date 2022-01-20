package com.browserstack;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    
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
	
	@Test
	public void Usecase2() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException


	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		System.out.print("\nLaunching Browser\n");
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone X");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//span[text()='iOS']")).click();
		driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']")).click();
		driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();
		List<WebElement> myList=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("\n----SIZE---\n"+myList.size());
	     for (int i = 1; i <= myList.size(); i++)
	     {
	       
	    	try {
	    		String DeviceName = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])["+ i +"]")).getText();
	    		System.out.print(i+") Device Name : "+DeviceName+"\n");
	        } catch (Exception e) {
	        	System.out.print("Device Name for" +i+ "not available");
	        	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"One of the steps failed\"}}");
	        }
	    	
	    	try {
	    		String Link = driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])["+ i +"]")).getAttribute("href");
	    		System.out.print("Link : "+Link+"\n");
	        } catch (Exception e) {
	        	System.out.print("Link for" +i+ "not available");
	        	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"One of the steps failed\"}}");
	        }
	    	
	    	try {
	    		String Price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])["+ i +"]")).getText();
	    		System.out.print("Price: "+Price+"\n");
	        } catch (Exception e) {
	        	System.out.print("Price for " +i+ "th not available");
	        	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"One of the steps failed\"}}");
	        }
	     }
		
	     jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Test case executed succesfully!\"}}");
	}
}
