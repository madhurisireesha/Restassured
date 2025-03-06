package com.mystore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(id="loginAjio")	WebElement signIn;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@value='START SHOPPING']")
	WebElement startShoppingBtn;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[2]/a")
	WebElement myAccount;
	
	Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void clickSignIn() {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(signIn));
		element.click();
	}
	
	public void getPhoneNumber(String phno) {
		phoneNumber.sendKeys(phno);
	}
	
	public void clickLoginBtn() {
		continueBtn.click();
	}
	
	public void startShopping() {
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(startShoppingBtn));
		element.click();
	}
	
	public boolean loginSuccess() {
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(startShoppingBtn));
	
		return element.isDisplayed();
	}
	
	
}	
