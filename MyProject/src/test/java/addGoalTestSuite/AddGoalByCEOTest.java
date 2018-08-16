package addGoalTestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import container.AddGoalPopUp;
import container.Header;
import pages.GoalDetailsPage;
import utils.StringUtils;

import utils.SystemLogin;

import utils.WaitMethods;

public class AddGoalByCEOTest {

	WebDriver driver;
	String handleHost;

	@Before
	public void beforeTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("");
		handleHost = driver.getWindowHandle();
		SystemLogin loginByCEO = new SystemLogin();
		loginByCEO.loginByCEO(driver);

	}

	@After
	public void afterTest() {

		driver.quit();
	}

	@Test
	public void popUpAfterPressAddGoal() {

		Header header = new Header(driver);
		AddGoalPopUp addGoalWindow = new AddGoalPopUp(driver);
		header.addGoalButton.click();
		addGoalWindow.popUpWindow.isDisplayed();

		String popUpTitle = "Add a new Goal";
		Assert.assertTrue("PopUp is not shown", addGoalWindow.addNewGoalHeader.getText().equals(popUpTitle));

	}

	@Test
	public void errorMessageForEmptyTitle() throws InterruptedException {

		Header header = new Header(driver);
		AddGoalPopUp addGoalWindow = new AddGoalPopUp(driver);
		header.addGoalButton.click();

		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementIsPresent(driver, addGoalWindow.buttonSave);

		addGoalWindow.buttonSave.click();

		String errorMessage = "Title field is required.";
		Assert.assertTrue("Wrong error message is shown",
				addGoalWindow.errorOnEmptyTitle.getText().equals(errorMessage));

	}

	@Test
	public void theSameTitleAfterCreation() throws InterruptedException {

		Header header = new Header(driver);
		AddGoalPopUp addGoalWindow = new AddGoalPopUp(driver);
		header.addGoalButton.click();
		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementToBeClickable(driver, addGoalWindow.createGoalTitleField);

		StringUtils createRandomString = new StringUtils();

		String goalTitle = createRandomString.createRandomString(12);

		addGoalWindow.createGoalTitleField.sendKeys(goalTitle);
		addGoalWindow.buttonSave.click();
		GoalDetailsPage goalDetailsPage = new GoalDetailsPage(driver);

		Assert.assertTrue("Goal is not created", goalDetailsPage.goalTitle.getText().equals(goalTitle));

	}

	@Test
	public void theSameTimeFrameAfterCreation() throws InterruptedException {

		Header header = new Header(driver);
		AddGoalPopUp addGoalWindow = new AddGoalPopUp(driver);
		header.addGoalButton.click();

		StringUtils createRandomString = new StringUtils();

		String goalTitle = createRandomString.createRandomString(12);

		addGoalWindow.createGoalTitleField.sendKeys(goalTitle);
		addGoalWindow.quarterDropDawn.click();
		String quarterPeriod = addGoalWindow.chosedQuarterInQuarterDropList.getText();

		addGoalWindow.buttonSave.click();
		GoalDetailsPage goalDetailsPage = new GoalDetailsPage(driver);

		Assert.assertTrue("Goal was created with different time frame" + quarterPeriod,
				goalDetailsPage.goalTimeFrame.getText().equals(quarterPeriod));

	}

	@Test
	public void theSameCustomTimeFrameAfterCreation() throws InterruptedException {

		Header header = new Header(driver);
		AddGoalPopUp addGoalWindow = new AddGoalPopUp(driver);
		header.addGoalButton.click();
		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementToBeClickable(driver, addGoalWindow.createGoalTitleField);

		StringUtils createRandomString = new StringUtils();
		String goalTitle = createRandomString.createRandomString(12);
		addGoalWindow.createGoalTitleField.sendKeys(goalTitle);

		addGoalWindow.clickToDefineCustomDatesLink.click();

		addGoalWindow.startCustomDateField.click();
		addGoalWindow.firstDayOfMonthButton.click();
		String fullDate = addGoalWindow.startCustomDateField.getAttribute("value");

		waitMethods.waitUntilElementToBeClickable(driver, addGoalWindow.endCustomDateField);

		addGoalWindow.endCustomDateField.click();
		addGoalWindow.thirtiethDayOfMonthButton.click();

		addGoalWindow.buttonSave.click();
		GoalDetailsPage goalDetailsPage = new GoalDetailsPage(driver);

		waitMethods.waitUntilElementToBeClickable(driver, goalDetailsPage.firstCustomDate);

		Assert.assertTrue("Wrong Custom Date", goalDetailsPage.firstCustomDate.getText().equals(fullDate));

	}

}
