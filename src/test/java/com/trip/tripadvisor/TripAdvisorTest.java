package com.trip.tripadvisor;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.asgnmt.GenericLib.BaseClass;
import com.asgnmt.GenericLib.FileLib;
import com.asgnmt.GenericLib.WebDriverCommonUtils;
import com.asgnmt.ObjectRepositoryLib.TripAdvisorPage;

public class TripAdvisorTest extends BaseClass {

	@Test
	public void tripReviewTest() throws Throwable{
		FileLib flib = new FileLib();
		String tripURL = flib.getPropertyKeyValue("tripurl");
		String searchData = flib.getExcelData("Sheet1", 2, 0);
		String reviewTitle = flib.getExcelData("Sheet1", 2, 1);
		String reviewText = flib.getExcelData("Sheet1", 2, 2);
		driver.get(tripURL);
		TripAdvisorPage tp = PageFactory.initElements(driver, TripAdvisorPage.class);
		tp.enterData(searchData);
		tp.clickOnClubMahindra();
		WebDriverCommonUtils wdc = new WebDriverCommonUtils();
		wdc.switchToNewTab();
		wdc.explicitwait(driver, 80, tp.getWriteReview());
		tp.clickOnWriteAReview();
		wdc.switchToAnotherTab();
		wdc.moveMouseCursor(driver, tp.getRating());
		tp.enterReviewTitle(reviewTitle);
		tp.enterReviewText(reviewText);
		tp.hotelRatings();
		wdc.explicitwait(driver, 50, tp.getCheckbox());
		tp.clickOnCheckBox();
		
		
	}
}
