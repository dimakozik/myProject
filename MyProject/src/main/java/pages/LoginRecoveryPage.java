package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRecoveryPage {
	
public LoginRecoveryPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="#id_username_or_email")
	public WebElement emailField;
	
	@FindBy(css="[type='submit']")
	public WebElement sendButton;
	
}
