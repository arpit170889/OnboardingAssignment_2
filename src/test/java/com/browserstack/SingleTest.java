package com.browserstack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    
	@Test
	public void Usecase1() throws InterruptedException

	{
		System.out.print("\nLaunching Browser\n");
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone X");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//div[@class='a-section']//span[text()='iOS']")).click();
		driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']")).click();
		driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();
		List<WebElement> myList=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("\n----SIZE---\n"+myList.size());
	     for (int i = 1; i <= myList.size(); i++)
	     {
	        String DeviceName = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])["+ i +"]")).getText();
	        String Link = driver.findElement(By.xpath("(//a[@class='a-link-normal s-link-style a-text-normal'])["+ i +"]")).getAttribute("href");
	        String Price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])["+ i +"]")).getText();	       
	    	System.out.print(i+") Device Name : "+DeviceName+" Price : "+Price+" Link: "+Link+"\n");
	     }
		
	}
}
