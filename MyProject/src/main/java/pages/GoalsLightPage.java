package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import container.AddGoalDrawer;
import container.MainMenu;
import container.TosterPopUp;

public class GoalsLightPage {

	public GoalsLightPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		addGoalDrawer = new AddGoalDrawer(driver);
		mainMenu = new MainMenu(driver);
		tosterPopUp = new TosterPopUp(driver);

	}

	public TosterPopUp tosterPopUp;
	public AddGoalDrawer addGoalDrawer;
	public MainMenu mainMenu;

	@FindBy(css = ".btn.btn-success.btn-lg.align-self-center")
	public WebElement addGoalButton;

	@FindBy(xpath = "//span[text()='Top Corporate']/parent ::a")
	public WebElement topCorporateTab;
	
	@FindBy(xpath = "//span[text()='My Team']/parent ::a")
	public WebElement myTeamTab;
	
	@FindBy(xpath = "//span[text()='Personal']/parent ::a")
	public WebElement personalTab;

	@FindBy(css = ".row.align-items-center.border-bottom.goals-light-table-row a")
	public WebElement goalTitleName;
	
	@FindBy(css = ".row.align-items-center.border-bottom.goals-light-table-row a")
	public List<WebElement> listOfGoalsInTable;
	
	@FindBy(xpath = "//*[@class='col-lg-4 col-sm-12']//label[contains(text(),'Goal Status')]/parent::div//div[@class='dropdown-menu-button d-flex align-items-center form-control']")
	public WebElement statusDropDown;
	
	@FindBy(xpath = "//*[@class='dropdown-menu-content w-100']//span[contains(text(),'Draft')]/parent::*")
	public WebElement draftStatusDropDownButton;	
	
	@FindBy(xpath = "//*[@class='dropdown-menu-content w-100']//span[contains(text(),'Active')]/parent::*")
	public WebElement activeStatusDropDownButton;
	
	@FindBy(xpath = "//*[@class='dropdown-menu-content w-100']//span[contains(text(),'Inactive')]/parent::*")
	public WebElement inactiveStatusDropDownButton;
	
	@FindBy(xpath = "//*[@class='dropdown-menu-content w-100']//span[contains(text(),'Closed')]/parent::*")
	public WebElement closedStatusDropDownButton;

}
