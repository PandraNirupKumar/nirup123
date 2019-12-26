package com.asgnmt.ObjectRepositoryLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPage {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement search;
	@FindBy(xpath = "//span[text()='Apple iPhone XR (64GB) - Yellow']")
	private WebElement iphone;
	@FindBy(id = "priceblock_ourprice")
	private WebElement price;
	
	
	public void search(String data) {
		search.sendKeys(data,Keys.ENTER);
	}

	public void iphone() {
		iphone.click();
	}
	
	public String price() {
		String amazonprice = price.getText();
		return amazonprice;
	}
	
	
}
