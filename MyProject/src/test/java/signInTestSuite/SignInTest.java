package signInTestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import container.Header;
import emailsAndPasswords.JackWelchLoginData;
import pages.LoginPage;
import pages.LoginRecoveryPage;
import pages.MailTrapPages;
import utils.MailTrapLogin;
import utils.WaitMethods;
import utils.WorkWithWindows;

public class SignInTest {

	WebDriver driver;
	String handleHost;

	@Before
	public void beforeTest() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("");
		handleHost = driver.getWindowHandle();

	}

	@After
	public void afterTest() {

		driver.quit();
	}

	@Test
	public void positiveLoginTestForCEO() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.emailField.sendKeys(JackWelchLoginData.email);

		loginPage.passwordField.sendKeys(JackWelchLoginData.password);

		loginPage.signInButton.click();

		Header header = new Header(driver);

		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementIsPresent(driver, header.headerBlock);

		Assert.assertTrue("User cannot login ",
				header.userFirstNameContainer.getText().equals(JackWelchLoginData.name));

	}

	@Test
	public void negativeLoginTest() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.emailField.sendKeys("asdasd@asdads.com");

		loginPage.passwordField.sendKeys("324234");

		loginPage.signInButton.click();

		String expectedMessage = "Sorry, we can't find an account with that email address.";

		Assert.assertTrue("Error message is not appear", loginPage.errorMessage.getText().equals(expectedMessage));

	}

	@Test
	public void checkErrorMessageAboutWrongPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

	

		loginPage.emailField.sendKeys(JackWelchLoginData.email);

		loginPage.passwordField.sendKeys("324234");

		loginPage.signInButton.click();

		String expectedMessage = "That password is incorrect. Please try again.";

		Assert.assertTrue("Error message is not appear", loginPage.errorMessage.getText().equals(expectedMessage));

	}

	@Test
	public void messageInMailTrapAfterRecoveryPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		LoginRecoveryPage loginPageRecovery = new LoginRecoveryPage(driver);
		WorkWithWindows workWithWindows = new WorkWithWindows();

		MailTrapLogin mailTrapLogin = new MailTrapLogin();
		MailTrapPages мailTrapPages = new MailTrapPages(driver);


		loginPage.forgotPasswordButton.click();
		loginPageRecovery.emailField.sendKeys(JackWelchLoginData.email);

		loginPageRecovery.sendButton.click();

		workWithWindows.navigateToURL(driver, "https://mailtrap.io/signin");

		mailTrapLogin.mailTrapLogin(driver);

		мailTrapPages.test1Button.click();

		String expectedMessage = "Password recovery on " + "atiim-test1.herokuapp.com" + "To: <vika+ceo@atiim.com>"
				+ "a few seconds ago";

		Assert.assertTrue(
				"Message is not equal expected one" + мailTrapPages.lastMailBoxMessage.getText().replaceAll("\n", ""),
				мailTrapPages.lastMailBoxMessage.getText().replaceAll("\n", "").equals(expectedMessage));

	}

}
