package com.mystore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyaccountTest {
	public Myaccount account;
	public WebDriver driver;
	public WebDriverWait wait;
	public Login login;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		login = new Login(driver);
		account=new Myaccount(driver);	
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		login.clickSignIn();
		
		login.getPhoneNumber("9515643139");
		
		login.clickLoginBtn();
		
		Thread.sleep(15000);
		
		login.startShopping();
		
		Assert.assertTrue(login.loginSuccess(),"Login failed");
		Thread.sleep(5000);
	}
	
	@Test(dependsOnMethods= {"login"})
	public void myAccountTest() {
		account.myAccountBtn();
		new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String currentUrl=driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, "https://www.ajio.com/my-account/orders");
	}
}
