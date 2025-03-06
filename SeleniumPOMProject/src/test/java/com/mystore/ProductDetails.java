package com.mystore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetails {
	public WebDriver driver;
	public WebDriverWait wait;
	
	ProductDetails(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
//	@FindBy(css=".rilrtl-lazy-img.rilrtl-lazy-img-loaded")
//    WebElement productImage;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div[3]/div/a/div/div[1]/div[1]/div/img")
	WebElement productImage;
	
	public void getProductImage() {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(productImage));
		element.click();
	}
	
	
}
