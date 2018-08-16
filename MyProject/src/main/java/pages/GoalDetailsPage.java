package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import container.Header;

public class GoalDetailsPage {

	public GoalDetailsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		header = new Header(driver);
	}
	
	public Header header ;
	
	@FindBy(id="#okr-stats-title")
	public WebElement goalTitle;
	
	@FindBy(xpath="//*[@id='okr-stats-period']")
	public WebElement goalTimeFrame;
	
	@FindBy(id="#okr-stats-start-date")
	public WebElement firstCustomDate;
	
	@FindBy(xpath="//*[@id='okr-stats-goal-status']")
	public WebElement goalStatus;
	
	@FindBy(id="#okr-results-add-measurement")
	public WebElement addKRbutton;
	
	@FindBy(id="#okr-details-milestone-kr-title")
	public WebElement milestoneButton;
	
	@FindBy(id="#create-milestone-kr-title-contenteditable")
	public WebElement milestoneDescriptionField;
	
	@FindBy(id="#create-milestone-kr-submit")
	public WebElement saveMilestoneKRButton;
	
	@FindBy(id="#okr-stats-activate-it-link")
	public WebElement activateItButton;
	
	@FindBy(xpath="//*[@id=\"okr-stats-actions\"]")
	public WebElement goalActionsButton;
	
	@FindBy(xpath="//*[@id=\"okr-stats-actions-close-link\"]")
	public WebElement closeGoalInActionsButton;
	
	@FindBy(xpath="//*[@id=\"okr-stats-actions-deactivate-link\"]")
	public WebElement deactivateGoalInActionsButton;
	
	@FindBy(xpath="//*[@style='left: 50%;']")
	public WebElement upKrValueTo50;
	
	@FindBy(xpath="//*[@style='left: 90.9091%;']")
	public WebElement upScoreValueTo50;
	
	@FindBy(css=".modal-content")
	public WebElement closingPopUp;
	
	@FindBy(xpath="//*[@id=\"close-goal-save\"]")
	public WebElement closeGoalInClosingPopUpButton;
	
	
}
