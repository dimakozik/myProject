package setDataForAllUsers;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import emailsAndPasswords.LullyRoyalLoginData;
import pages.GoalDetailsPage;
import pages.GoalsLightPage;
import pages.HomePage;
import utils.StringUtils;
import utils.Methods;
import utils.SystemLogin;
import utils.WaitMethods;

public class DataForEmployeeNonAdmin {

	WebDriver driver;
	String handleHost;

	@Before
	public void beforeTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("");
		handleHost = driver.getWindowHandle();
		SystemLogin systemLogin = new SystemLogin();
		systemLogin.loginByEmployeeNonAdmin(driver);

	}

	@After
	public void afterTest() {

		driver.quit();
	}

	@Test
	public void createDraftQuarterPersonalGoalOnGl() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.mainMenu.goalsItemLink.click();
		homePage.mainMenu.goalsLightItemLink.click();

		GoalsLightPage goalsLightPage = new GoalsLightPage(driver);
		goalsLightPage.addGoalButton.click();
		StringUtils createRandomString = new StringUtils();

		String quarter = goalsLightPage.addGoalDrawer.quarterDropDownButton.getAttribute("outerText");
		String goalStatus = "Draft";
		String goalTitle = quarter + " Personal " + LullyRoyalLoginData.name + " (" + goalStatus + ") "
				+ createRandomString.createRandomString(3);

		goalsLightPage.addGoalDrawer.createGoalTitleField.sendKeys(goalTitle);

		goalsLightPage.addGoalDrawer.draftButton.click();

		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.addGoalDrawer.saveButton);

		goalsLightPage.addGoalDrawer.saveButton.click();

		waitMethods.waitUntilElementIsDisplayed(driver, goalsLightPage.tosterPopUp.toster);
		waitMethods.threadSleep(2000);

		goalsLightPage.statusDropDown.click();
		goalsLightPage.draftStatusDropDownButton.click();
		goalsLightPage.activeStatusDropDownButton.click();

		Methods methods = new Methods();
		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.goalTitleName);

		Assert.assertTrue("Personal" + goalStatus + "goal is not created",
				methods.convertListOfWEbElToStringByAttribute(goalsLightPage.listOfGoalsInTable, "outerText")
						.contains(goalTitle));
	}

	@Test
	public void createActiveQuarterPersonalGoalOnGLPage() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.mainMenu.goalsItemLink.click();
		homePage.mainMenu.goalsLightItemLink.click();

		GoalsLightPage goalsLightPage = new GoalsLightPage(driver);
		goalsLightPage.addGoalButton.click();
		StringUtils createRandomString = new StringUtils();

		String quarter = goalsLightPage.addGoalDrawer.quarterDropDownButton.getAttribute("outerText");
		String goalStatus = "Active";
		String goalTitle = quarter + " Personal " + LullyRoyalLoginData.name + " (" + goalStatus + ") "
				+ createRandomString.createRandomString(3);

		goalsLightPage.addGoalDrawer.createGoalTitleField.sendKeys(goalTitle);

		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.addGoalDrawer.saveButton);

		goalsLightPage.addGoalDrawer.saveButton.click();

		waitMethods.waitUntilElementIsDisplayed(driver, goalsLightPage.tosterPopUp.toster);
		waitMethods.threadSleep(3000);

		Methods methods = new Methods();
		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.goalTitleName);

		Assert.assertTrue("Personal" + goalStatus + "goal is not created",
				methods.convertListOfWEbElToStringByAttribute(goalsLightPage.listOfGoalsInTable, "outerText")
						.contains(goalTitle));

	}

	@Test
	public void createClosedQuarterPersonalGoalOnGLPage() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.mainMenu.goalsItemLink.click();
		homePage.mainMenu.goalsLightItemLink.click();

		GoalsLightPage goalsLightPage = new GoalsLightPage(driver);
		goalsLightPage.addGoalButton.click();
		StringUtils createRandomString = new StringUtils();

		String quarter = goalsLightPage.addGoalDrawer.quarterDropDownButton.getAttribute("outerText");
		String goalStatus = "Closed";
		String goalTitle = quarter + " Personal " + LullyRoyalLoginData.name + " (" + goalStatus + ") "
				+ createRandomString.createRandomString(3);

		goalsLightPage.addGoalDrawer.createGoalTitleField.sendKeys(goalTitle);

		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.addGoalDrawer.saveButton);

		goalsLightPage.addGoalDrawer.saveButton.click();

		waitMethods.waitUntilElementIsDisplayed(driver, goalsLightPage.tosterPopUp.toster);

		Thread.sleep(2000);

		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.goalTitleName);

		waitMethods.threadSleep(3000);

		Methods methods = new Methods();
		methods.clickOnElementInListContainsTextInAttribute(goalsLightPage.listOfGoalsInTable, "textContent",
				goalTitle);

		GoalDetailsPage goalDetailsPage = new GoalDetailsPage(driver);
		waitMethods.waitUntilElementToBeClickable(driver, goalDetailsPage.goalActionsButton);

		goalDetailsPage.goalActionsButton.click();
		goalDetailsPage.closeGoalInActionsButton.click();
		waitMethods.waitUntilElementIsDisplayed(driver, goalDetailsPage.upKrValueTo50);

		Actions actions = new Actions(driver);
		actions.moveToElement(goalDetailsPage.upKrValueTo50).click().perform();
		actions.moveToElement(goalDetailsPage.upScoreValueTo50).click().perform();

		goalDetailsPage.closeGoalInClosingPopUpButton.click();
		waitMethods.threadSleep(4000);
		Assert.assertTrue("Personal" + goalStatus + "goal is not created",
				goalDetailsPage.goalStatus.getText().equals(goalStatus));

	}

	@Test
	public void createInactiveQuarterPersonalGoalOnGLPage() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.mainMenu.goalsItemLink.click();
		homePage.mainMenu.goalsLightItemLink.click();

		GoalsLightPage goalsLightPage = new GoalsLightPage(driver);
		goalsLightPage.addGoalButton.click();
		StringUtils createRandomString = new StringUtils();

		String quarter = goalsLightPage.addGoalDrawer.quarterDropDownButton.getAttribute("outerText");
		String goalStatus = "Inactive";
		String goalTitle = quarter + " Personal " + LullyRoyalLoginData.name + " (" + goalStatus + ") "
				+ createRandomString.createRandomString(3);

		goalsLightPage.addGoalDrawer.createGoalTitleField.sendKeys(goalTitle);

		WaitMethods waitMethods = new WaitMethods();
		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.addGoalDrawer.saveButton);

		goalsLightPage.addGoalDrawer.saveButton.click();

		waitMethods.waitUntilElementIsDisplayed(driver, goalsLightPage.tosterPopUp.toster);

		waitMethods.threadSleep(2000);

		waitMethods.waitUntilElementToBeClickable(driver, goalsLightPage.goalTitleName);

		waitMethods.threadSleep(2000);

		Methods methods = new Methods();
		methods.clickOnElementInListContainsTextInAttribute(goalsLightPage.listOfGoalsInTable, "textContent",
				goalTitle);

		GoalDetailsPage goalDetailsPage = new GoalDetailsPage(driver);
		waitMethods.waitUntilElementToBeClickable(driver, goalDetailsPage.goalActionsButton);

		goalDetailsPage.goalActionsButton.click();
		goalDetailsPage.deactivateGoalInActionsButton.click();

		waitMethods.threadSleep(4000);
		Assert.assertTrue("Personal" + goalStatus + "goal is not created",
				goalDetailsPage.goalStatus.getText().equals(goalStatus));

	}

}
