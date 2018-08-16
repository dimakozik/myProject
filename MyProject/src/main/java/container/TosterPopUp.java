package container;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TosterPopUp {

	public TosterPopUp(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
	}

	

	@FindBy(css = ".toast-top-right")
	public WebElement toster;
	
	
}
