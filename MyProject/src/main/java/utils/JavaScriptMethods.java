package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptMethods {
	
	public void scrollDown1000PXOnPage(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		
	}
	
	public void scrollDown2000PXOnPage(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000)", "");
		
		
	}

}
