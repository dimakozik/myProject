package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitMethods {

	public void waitUntilElementIsPresent(WebDriver driver, final WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return element;
			}
		});

	}


	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitUntilElementisVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitUntilElementisInvisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.invisibilityOf(element));

	}

	public void waitUntilElementNotDisplayed(WebDriver driver, final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 6);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					element.isDisplayed();
					return false;
				} catch (NoSuchElementException e) {
					return true;
				} catch (StaleElementReferenceException f) {
					return true;
				}
			}
		};
		wait.until(elementIsDisplayed);
	}

	public void waitUntilElementIsDisplayed(WebDriver driver, final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					element.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);
	}
	
	public void threadSleep(int sleepTime) throws InterruptedException {

		Thread.sleep(sleepTime);
	

}
}
