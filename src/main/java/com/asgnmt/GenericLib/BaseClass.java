package com.asgnmt.GenericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	public static WebDriver driver;
	FileLib flib = new FileLib();
	@BeforeClass
	public void configBC() throws Throwable {
		
		String BROWSER = flib.getPropertyKeyValue("browser");
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}

	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
			
	}
	
	@AfterMethod
	public void configAM() {
		
	}
	
	@AfterClass
	public void configAC() {
		
		//driver.quit();
	}
}


