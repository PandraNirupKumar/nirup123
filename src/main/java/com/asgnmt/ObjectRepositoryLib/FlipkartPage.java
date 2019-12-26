package com.asgnmt.ObjectRepositoryLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartPage {

	@FindBy(xpath = "//button[text()='✕']")
	private WebElement closeBtn;
	
	@FindBy(name = "q")
	private WebElement flipkartSearch;
	
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	private WebElement appleIphone;
	
	@FindBy(xpath = "//span[text()='Apple iPhone XR (Yellow, 64 GB)']/../../../div[3]/div[1]")
	private WebElement price;
	
	
	
	public WebElement getAppleIphone() {
		return appleIphone;
	}
	
	
	public WebElement getPrice() {
		return price;
	}


	public void closeButton() {
		closeBtn.click();
	}
	public void flipkartSearch(String data) {
		flipkartSearch.sendKeys(data,Keys.ENTER);
	}
	
	public void ClickOnAppleIphone() {
		appleIphone.click();
	}
	
	public String getFlipkartIphonePrice() {
		String iphonePrice = price.getText();
		return iphonePrice;
	}
}
