package com.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	public WebDriver driver;
	public Login login;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		login=new Login(driver);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void LoginTests() throws InterruptedException {
		login.clickSignIn();
		
		login.getPhoneNumber("7093227829");
		
		login.clickLoginBtn();
		
		Thread.sleep(15000);
		
		login.startShopping();
		
		Assert.assertTrue(login.loginSuccess(),"LOgin failed");
	}
	
	
}
