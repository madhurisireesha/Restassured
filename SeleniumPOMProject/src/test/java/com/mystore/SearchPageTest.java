package com.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest {
	public WebDriver driver;
	public Login login;
	public SearchPage searchPage;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		login=new Login(driver);
		searchPage=new SearchPage(driver);	
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
	public void searchFunction() throws InterruptedException {
		
		searchPage.searchFun("clocks");
		
		
		searchPage.clickSearch();
		Thread.sleep(15000);
		
		String product=searchPage.displayResults();
		System.out.print(product);
		Assert.assertTrue(product.contains("Clocks"), "Search result doesn't contain 'clocks'");
	}
	
	//@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
