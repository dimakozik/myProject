package methods;

import org.openqa.selenium.WebDriver;
import emailsAndPasswords.JackWelchLoginData;
import pages.LoginPage;

public class LoginByCEO {
	
	
	public void login(WebDriver driver) throws InterruptedException  {
		
		LoginPage loginPage = new LoginPage(driver);
		

		
		loginPage.emailField.sendKeys(JackWelchLoginData.email);
		
		loginPage.passwordField.sendKeys(JackWelchLoginData.password);
		
		loginPage.signInButton.click();
		
		Thread.sleep(2000);
		
	}

}
