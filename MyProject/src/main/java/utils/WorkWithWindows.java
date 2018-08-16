package utils;

import org.openqa.selenium.WebDriver;

public class WorkWithWindows {
	
	public void navigateToURL(WebDriver driver,String url) {
		
		driver.navigate().to(url);
		
	}
	
	public void goToSecondTab(WebDriver driver) {
		String handleHost = driver.getWindowHandle();
	try {
		for (String handle : driver.getWindowHandles()) {
			if (handle != handleHost) {
				driver.switchTo().window(handle);
				driver.switchTo().activeElement();

			}
		}
	} catch (Exception e) {
		System.err.println("Couldn’t get to second page");
	}
	}
}


