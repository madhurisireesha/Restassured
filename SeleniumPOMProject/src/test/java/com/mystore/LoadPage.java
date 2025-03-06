package com.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoadPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public Login login;
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		login=new Login(driver);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void loadPage() {
		String pageUrl=driver.getCurrentUrl();
		String originalUrl="https://www.ajio.com/";
		
		Assert.assertEquals(pageUrl,originalUrl);
		
	}

}
