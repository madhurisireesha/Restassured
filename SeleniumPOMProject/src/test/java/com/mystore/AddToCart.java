package com.mystore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	public WebDriverWait wait;
	public WebDriver driver;
	
	
	AddToCart(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	@FindBy(xpath="//span[@class='pdp-wishlist-desktop-icon']")
	WebElement goToBag;

	public void goToBagFun() {
		
		WebElement element=wait.until(ExpectedConditions.visibilityOf(goToBag));
		element.click();
		
	}


}
