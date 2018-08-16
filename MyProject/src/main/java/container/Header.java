package container;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

	public Header(WebDriver driver) {

		PageFactory.initElements(driver, this);
		addGoalPopUp = new AddGoalPopUp(driver);
	}

	public AddGoalPopUp addGoalPopUp;

	@FindBy(css = ".navbar.fixed-top.navbar-expand-sm.navbar-dark.navbar-atiim")
	public WebElement headerBlock;

	@FindBy(css = ".user-first-name")
	public WebElement userFirstNameContainer;

	@FindBy(css = "#header-controller-add-goal-header")
	public WebElement addGoalButton;

}
