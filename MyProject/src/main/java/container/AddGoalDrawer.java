package container;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGoalDrawer {

	public AddGoalDrawer(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".form-control.ng-untouched.ng-pristine.ng-invalid")
	public WebElement createGoalTitleField;
	
	@FindBy(xpath="//div[@class='modal-content']//div[@class='dropdown-menu-button d-flex align-items-center form-control']//button[@class='w-100']")
	public WebElement quarterDropDownButton;
	
	@FindBy(xpath="//*[@class='row mb-4']//atiim-entity-select[@class='d-block ng-untouched ng-pristine ng-valid']//div[@class='dropdown-menu-button d-flex align-items-center form-control']")
	public WebElement userSearchField;
	
	@FindBy(xpath="//*[@class='w-100 form-control ng-pristine ng-valid ng-touched']")
	public WebElement userSearchFieldAfterClick;
	
	@FindBy(css=".dropdown-menu-item")
	public WebElement firstRowInDropDownList;
	
	@FindBy(xpath="// div[@class='col-12 text-right']/button[@class='btn btn-lg btn-success']")
	public WebElement saveButton;
	
	@FindBy(css="button.close")
	public WebElement xbutton;
	
	@FindBy(css=".modal.fade.show")
	public WebElement fadeСurtain;
	
	@FindBy(xpath="//button[contains(text(),'Draft')]")
	public WebElement draftButton;
	
	@FindBy(xpath="//button[contains(text(),'Active')]")
	public WebElement activeButton;
	
	
}
