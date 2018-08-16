package utils;

import org.openqa.selenium.WebDriver;
import emailsAndPasswords.JackWelchLoginData;
import emailsAndPasswords.JoeKaizenLoginData;
import emailsAndPasswords.LullyRoyalLoginData;
import emailsAndPasswords.MarshallEriksenLoginData;
import emailsAndPasswords.PaulaLightsonLoginData;
import pages.LoginPage;

public class SystemLogin {

	public void loginByCEO(WebDriver driver) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.emailField.sendKeys(JackWelchLoginData.email);

		loginPage.passwordField.sendKeys(JackWelchLoginData.password);

		loginPage.signInButton.click();

		Thread.sleep(2000);

	}

	public void loginByManagerAdmin(WebDriver driver) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.emailField.sendKeys(JoeKaizenLoginData.email);

		loginPage.passwordField.sendKeys(JoeKaizenLoginData.password);

		loginPage.signInButton.click();

		Thread.sleep(2000);

	}

	public void loginByManagerNonAdmin(WebDriver driver) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.emailField.sendKeys(PaulaLightsonLoginData.email);

		loginPage.passwordField.sendKeys(PaulaLightsonLoginData.password);

		loginPage.signInButton.click();

		Thread.sleep(2000);

	}

	public void loginByEmployeeAdmin(WebDriver driver) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.emailField.sendKeys(MarshallEriksenLoginData.email);

		loginPage.passwordField.sendKeys(MarshallEriksenLoginData.password);

		loginPage.signInButton.click();

		Thread.sleep(2000);

	}
	
	public void loginByEmployeeNonAdmin(WebDriver driver) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.emailField.sendKeys(LullyRoyalLoginData.email);

		loginPage.passwordField.sendKeys(LullyRoyalLoginData.password);

		loginPage.signInButton.click();

		Thread.sleep(2000);

	}

}
