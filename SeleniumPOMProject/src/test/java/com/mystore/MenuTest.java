package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MenuTest {
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void menuTest() throws InterruptedException {
		Actions action=new Actions(driver);
		
		WebElement menMenu=driver.findElement(By.xpath("//span[@aria-label='MEN']"));
		action.moveToElement(menMenu).perform();
		
		Thread.sleep(5000);
		
		WebElement currentText=driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li[1]/div[1]/ul/li[1]/a"));
		Assert.assertTrue(currentText.getText().equalsIgnoreCase("Categories"));
		
		
		
	}
}
