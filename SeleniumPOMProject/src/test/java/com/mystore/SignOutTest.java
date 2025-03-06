package com.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignOutTest {
	public Login login;
	public WebDriverWait wait;
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		login=new Login(driver);
		
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		login.clickSignIn();
		
		login.getPhoneNumber("9515643139");
		
		login.clickLoginBtn();
		
		Thread.sleep(15000);
		
		login.startShopping();
		
		Assert.assertTrue(login.loginSuccess(),"Login failed");
		Thread.sleep(10000);
	}
	
	@Test(dependsOnMethods={"login"})
	public void signOut() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[@aria-label='Sign Out']"));
		
		element.click();
		
		Thread.sleep(4000);
		WebElement signin=driver.findElement(By.xpath("//span[@id='loginAjio']"));
		
		Assert.assertTrue(signin.isDisplayed(),"Unable to signout");
		
	}
}
