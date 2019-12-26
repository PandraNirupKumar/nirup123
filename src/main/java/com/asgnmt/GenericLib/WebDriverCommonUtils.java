package com.asgnmt.GenericLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonUtils {

	public void switchToNewTab() {
		Set<String> set = BaseClass.driver.getWindowHandles();
		//System.out.println(set.size());
		Iterator<String> it = set.iterator();
		String parentId = it.next();
		String childId = it.next();
		BaseClass.driver.switchTo().window(childId);
	}
	
	public void switchToAnotherTab() {
		Set<String> set = BaseClass.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentId = it.next();
		String childId1 = it.next();
		String childId2 = it.next();
		BaseClass.driver.switchTo().window(childId2);
	}
	
	public void explicitwait(WebDriver driver,int time,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void moveMouseCursor(WebDriver driver, WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element, 50, 0);
		action.click();
		action.perform();
		
	}
	
}
