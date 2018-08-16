package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="#id_email")
	public WebElement emailField;
	
	@FindBy(css="#id_password")
	public WebElement passwordField;
	
	@FindBy(css="#login-submit-button")
	public WebElement signInButton;
	
	@FindBy(css=".help-block ")
	public WebElement errorMessage;
	
	@FindBy(css=".col-md-6.col-12.forgot-password a")
	public WebElement forgotPasswordButton; 
	
	
}

