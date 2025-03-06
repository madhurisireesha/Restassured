package com.mystore;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductDetailsTest {
	public WebDriver driver;
	public WebDriverWait wait;
	public ProductDetails productDetails;
	public Login login;
	public SearchPage searchPage;
	public LoginTest loginTest;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		login = new Login(driver);
        searchPage = new SearchPage(driver);
        productDetails = new ProductDetails(driver);
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
		Assert.assertTrue(product.contains("Clocks"), "Search result doesn't contain 'Clocks'");
	}
	
	@Test(dependsOnMethods= {"searchFunction"})
	public void productDetails() throws InterruptedException {
		productDetails.getProductImage();
		
		//new WebDriverWait(driver,Duration.ofSeconds(10));
	
		Thread.sleep(5000);
		
		String currentUrl=driver.getCurrentUrl();
		
		 Assert.assertTrue(
			        currentUrl.contains("ajio.com") && currentUrl.contains("clock"), 
			        "URL doesn't match expected product page: " + currentUrl
			    );
		
	}
	
}
