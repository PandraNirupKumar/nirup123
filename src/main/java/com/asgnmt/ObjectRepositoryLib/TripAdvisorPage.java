package com.asgnmt.ObjectRepositoryLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.asgnmt.GenericLib.BaseClass;
import com.asgnmt.GenericLib.WebDriverCommonUtils;

public class TripAdvisorPage {

	@FindBy(xpath = "//button[@type='submit' and @title='Search']")
	private WebElement searchBtn;
	@FindBy(name = "q")
	private WebElement tripSearch;
	@FindBy(xpath = "//div[@title='Search']")
	private WebElement search;
	@FindBy(id = "mainSearch")
	private WebElement tripSearch1;
	@FindBy(xpath = "//span[text()='Club Mahindra Madikeri, Coorg']")
	private WebElement clubM;
	@FindBy(xpath = "//a[text()='Write a review']")
	private WebElement writeReview;
	@FindBy(id = "bubble_rating")
	private WebElement rating;
	@FindBy(xpath = "//div[@id='REVIEW_TITLE']/input")
	private WebElement reviewTitle;
	@FindBy(id = "ReviewText")
	private WebElement reviewText;
	@FindBy(xpath = "//div[text()='Hotel Ratings']")
	private WebElement hotelRatings;
	@FindBy(id = "noFraud")
	private WebElement checkbox;
	@FindBy(xpath = "//span[@data-name='Service']")
	private WebElement service;
	@FindBy(xpath = "//span[@data-name='Location']")
	private WebElement location;
	@FindBy(xpath = "//span[@data-name='Rooms']")
	private WebElement rooms;
	@FindBy(xpath = "//span[@data-name='Cleanliness']")
	private WebElement cleanliness;
	@FindBy(xpath = "//span[@data-name='Sleep Quality']")
	private WebElement sleepQuality;
	@FindBy(xpath = "//span[@data-name='Value']")
	private WebElement value;
	/*public WebElement getTripSearch() {
		return tripSearch;
	}*/
		
	public void enterData(String data) {
	boolean b =	search.isDisplayed();
	System.out.println(b);
		if(b) {
			search.click();
			tripSearch1.sendKeys(data,Keys.ENTER);
		}else {
			searchBtn.click();
			tripSearch.sendKeys(data,Keys.ENTER);
		}
	}
	
	/*public void clickOnSearch() {
		search.click();
	}*/

	/*public void enterSearchData(String data) {
		tripSearch.sendKeys(data,Keys.ENTER);
	}*/
	
	/*public void enterTripSearchData(String data) {
		tripSearch1.sendKeys(data,Keys.ENTER);
	}*/
	
	public WebElement getWriteReview() {
		return writeReview;
	}

	public WebElement getRating() {
		return rating;
		
	}
	
	public WebElement getCheckbox() {
		return checkbox;
	}

	public void clickOnRating() {
		rating.click();
	}

	public void clickOnClubMahindra() {
		clubM.click();
	}
	
	public void clickOnWriteAReview() {
		writeReview.click();
	}
	
	public void enterReviewTitle(String data) {
		reviewTitle.sendKeys(data);
	}
	
	public void enterReviewText(String data) {
		reviewText.sendKeys(data);
	}
	
	public void clickOnCheckBox() {
		checkbox.click();
	}
	
	public void hotelRatings() {
		WebDriverCommonUtils wdc = new WebDriverCommonUtils();
		boolean b =hotelRatings.isDisplayed();
		if(b) {
			if(service.isDisplayed()) {
				wdc.moveMouseCursor(BaseClass.driver, service);
			}
			if(rooms.isDisplayed()) {
			wdc.moveMouseCursor(BaseClass.driver, rooms);
			}
			if(location.isDisplayed()) {
			wdc.moveMouseCursor(BaseClass.driver, location);
			}
			if(cleanliness.isDisplayed()) {
				wdc.moveMouseCursor(BaseClass.driver, cleanliness);
			}
			if(sleepQuality.isDisplayed()) {
				wdc.moveMouseCursor(BaseClass.driver, sleepQuality);
			}
			if(value.isDisplayed()) {
				wdc.moveMouseCursor(BaseClass.driver, value);
			}
		}
	}
	
}
