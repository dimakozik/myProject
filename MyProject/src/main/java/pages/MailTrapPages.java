package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailTrapPages {

	public MailTrapPages(WebDriver driver) {
		
	PageFactory.initElements(driver,this);

	}

	@FindBy(css="#user_email")
    public WebElement emailField;

	@FindBy(css="#user_password")
    public WebElement passwordField;
	
    @FindBy(css="[type='submit']")
    public WebElement loginButton;
    
    @FindBy(css=".initial [title='staging2']")
    public WebElement staging2Button;
    
    @FindBy(css=".messages_list.inbox-content.nav-list li")
    public WebElement lastMailBoxMessage;
    
    @FindBy(css=".initial [title='staging']")
    public WebElement stagingButton;
    
    @FindBy(css=".initial [title='test1']")
    public WebElement test1Button;
}
