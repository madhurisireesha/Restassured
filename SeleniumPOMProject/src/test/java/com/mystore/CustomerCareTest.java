package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerCareTest {
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void customerTests() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[@href='/selfcare']"));
		element.click();
		Thread.sleep(4000);
		
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals("https://www.ajio.com/selfcare",currentUrl);
		
		
	}
}
