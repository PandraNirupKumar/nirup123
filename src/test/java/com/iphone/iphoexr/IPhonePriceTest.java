package com.iphone.iphoexr;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.asgnmt.GenericLib.BaseClass;
import com.asgnmt.GenericLib.FileLib;
import com.asgnmt.GenericLib.WebDriverCommonUtils;
import com.asgnmt.ObjectRepositoryLib.AmazonPage;
import com.asgnmt.ObjectRepositoryLib.FlipkartPage;

public class IPhonePriceTest extends BaseClass {

	@Test
	public void priceTest() throws Throwable {
		FileLib flib = new FileLib();
		String URL = flib.getPropertyKeyValue("url");
		driver.get(URL);
		String searchText = flib.getExcelData("Sheet1", 1, 0);
		AmazonPage ap = PageFactory.initElements(driver, AmazonPage.class);
		ap.search(searchText);
		ap.iphone();
		WebDriverCommonUtils wdc = new WebDriverCommonUtils();
		wdc.switchToNewTab();
		String amazonIphonePrice = ap.price();
		System.out.println(amazonIphonePrice);
		char c = amazonIphonePrice.charAt(0);
		String str = Character.toString(c);
		
		String amazonprice1 = amazonIphonePrice.replace(str, "").replace(" ", "").replace(",", "");
		System.out.println(amazonprice1);
		
		double amazonIphoneXRPrice = Double.parseDouble(amazonprice1);
		String flipkartURL = flib.getPropertyKeyValue("flipkarturl");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(flipkartURL);
		FlipkartPage fp = PageFactory.initElements(driver, FlipkartPage.class);
		fp.closeButton();
		fp.flipkartSearch(searchText);
		
		wdc.explicitwait(driver, 50, fp.getAppleIphone());
		fp.ClickOnAppleIphone();
		wdc.switchToNewTab();
		wdc.explicitwait(driver, 60, fp.getPrice());
		String flipkartIphonePrice = fp.getFlipkartIphonePrice();
		System.out.println(flipkartIphonePrice);
		char c1 = flipkartIphonePrice.charAt(0);
		String str1 = Character.toString(c1);
		String flipkartPrice = flipkartIphonePrice.replace(str1, "").replace(",", "");
		System.out.println(flipkartPrice);
		double flipkartIPhoneXRPrice = Double.parseDouble(flipkartPrice);
		if(amazonIphoneXRPrice<flipkartIPhoneXRPrice) {
			System.out.println("Compare to flipkart amazon price is "+(flipkartIPhoneXRPrice-amazonIphoneXRPrice)+" rupees less");
		}else {
			System.out.println("Compare to amazon flipkart price is "+(amazonIphoneXRPrice-flipkartIPhoneXRPrice)+" rupees less");
		}
		
	}
}
