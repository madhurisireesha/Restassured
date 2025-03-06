package com.mystore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myaccount {
	public WebDriver driver;
	public WebDriverWait wait;
	public PageFactory pagefactory;
	
	Myaccount(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}
	
	@FindBy(xpath="//*[@id=\"appContainer\"]/div[1]/div/header/div[1]/ul/li[2]/a")
	WebElement myAccount;
	
	public void myAccountBtn() {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(myAccount));
		element.click();
		
	}
	
	
}
