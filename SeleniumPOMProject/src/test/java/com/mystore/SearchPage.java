package com.mystore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	SearchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")
	WebElement searchBar;
	
	@FindBy(xpath="//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/button/span")
	WebElement searchSymbol;
	
	@FindBy(xpath="//*[@id=\"products\"]/div[1]/h1/div[2]")
	WebElement searchResults;
	
	public void searchFun(String product) {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(searchBar));
		element.sendKeys(product);
	}
	
	public void clickSearch() {
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(searchSymbol));
		element.click();
	}
	
	public String displayResults() {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(searchResults));
		return element.getText();
	}
	
}
