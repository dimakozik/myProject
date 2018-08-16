package utils;

import org.openqa.selenium.WebDriver;

import pages.MailTrapPages;

public class MailTrapLogin {

	public void mailTrapLogin(WebDriver driver) {
		MailTrapPages mailTrapPages = new MailTrapPages(driver);
		
		mailTrapPages.emailField.sendKeys("");
		
		mailTrapPages.passwordField.sendKeys("");
		
		mailTrapPages.loginButton.click();
	}
}
