package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import container.Header;
import container.MainMenu;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		header = new Header(driver);
		mainMenu = new MainMenu(driver);
	}

	public MainMenu mainMenu;

	public Header header;

}
