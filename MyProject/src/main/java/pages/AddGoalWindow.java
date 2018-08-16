package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGoalWindow {

	public AddGoalWindow(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".header-with-quick-add-tab-card.bs-popover-bottom.popover.ng-scope")
	public WebElement popUpWindow;

	@FindBy(css = "#header-controller-add-goal-header-create-objective-header-header")
	public WebElement addNewGoalHeader;

	@FindBy(css = "#header-controller-add-goal-header-create-objective-title-contenteditable")
	public WebElement createGoalTitleField;

	@FindBy(css = "#header-controller-add-goal-header-create-objective-submit-button")
	public WebElement buttonSave;

	@FindBy(css = "#header-controller-add-goal-header-create-objective-quarters-select-container")
	public WebElement quarterDropDawn;

	@FindBy(css = ".uib-typeahead-match.ng-scope.active")
	public WebElement chosedQuarterInQuarterDropList;

	@FindBy(css = ".error-message.ng-binding")
	public WebElement errorOnEmptyTitle;
	
	@FindBy(css = "#header-controller-add-goal-header-create-objective-toggle-custom-dates-button")
	public WebElement clickToDefineCustomDatesLink;
	
	@FindBy(css = "#header-controller-add-goal-header-create-objective-start-date-input")
	public WebElement startCustomDateField;
	
	@FindBy(css = "#header-controller-add-goal-header-create-objective-end-date-input")
	public WebElement endCustomDateField;
	
	@FindBy(xpath = "//*/span[@class='ng-binding'][contains(text(),'01')] /parent::*")
	public WebElement firstDayOfMonthButton;
	
	@FindBy(xpath = "//*/span[@class='ng-binding'][contains(text(),'30')] /parent::*")
	public WebElement thirtiethDayOfMonthButton;
	
	@FindBy(css = "button strong.ng-binding")
	public WebElement monthAndYearOfCustomDate;
	
	

}
