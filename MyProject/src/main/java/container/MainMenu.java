package container;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu {
	
	public MainMenu(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css ="#sidebar-wrapper")
	public WebElement mainMenuBlock;
	
	@FindBy(xpath ="//span[text()='Goals']/parent::a")
	public WebElement goalsItemLink;
	
	@FindBy(xpath ="//span[text()='Goals Light']/parent::a")
	public WebElement goalsLightItemLink;

}
