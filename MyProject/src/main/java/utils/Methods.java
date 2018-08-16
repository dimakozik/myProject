package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods {

	public List<String> convertListOfWEbElToStringByLocator(WebDriver driver,By locator, String attribute) {

		List<WebElement> webElementsList = driver.findElements(locator);
		List<String> values = new ArrayList<String>();
		for (WebElement e : webElementsList) {
			values.add(e.getAttribute(attribute));

		}
		return values;
	}
	
	public List<String> convertListOfWEbElToStringByAttribute(List<WebElement> webElementsList, String attribute) {

		
		List<String> values = new ArrayList<String>();
		for (WebElement e : webElementsList) {
			values.add(e.getAttribute(attribute));
			

		}
		return values;
	}
	
	public void clickOnElementInListContainsTextInAttribute(List<WebElement> webElementsList, String attribute, String containsText) {
		
	
		
		for (WebElement e : webElementsList) {
			try {
				if(e.getAttribute(attribute).contains(containsText)) {
					e.click();}
			} catch (StaleElementReferenceException e2) {
				
			}
			}
	}

}
