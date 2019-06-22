package imdb.moduletestcase.createaccountsignin;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.createaccountsignIn.CreateAccountPage;
import imdb.modules.home.HomePage;

public class CreateAccountPageValidations {

	private static Logger logger = Logger.getLogger(CreateAccountPageTest.class);

	private CreateAccountPage createAccountPage;

	private DriverManager dm;
	private String methodName;
	HomePage homePage = new HomePage();

	/**
	 * No arg constructor
	 */
	public CreateAccountPageValidations() {
		createAccountPage = new CreateAccountPage();
		dm = createAccountPage.getUtil().getDm();
	}

	@BeforeClass
	public void LaunchBrowser() throws InterruptedException {
		logger.info("Launching the IMDB website");
		dm.launchUrl();
	}

	/*
	 * Test Case Summary: This Test Case Verifies the launching of correct IMDB Page
	 * Expected Result: The title of the page must be matched. Author: Navatha
	 * Kannadi
	 */
	@Test(priority=1)
	public void TC_01_verifyHomePage() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		String actTitle = homePage.actTitle();
		String expTitle = homePage.expTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	
	/* * Test Case Summary: This Test Case navigates to signin and then Create Account
	 * Page Expected Result: The automated browser should be on Create new Account
	 * Page Author: Navatha Kannadi */
	 
	@Test(priority=2)
	public void TC_02_clickOnSignInWithOutEnteringanyValues() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
		createAccountPage.clickOnCreateAccount();
		String actText = createAccountPage.getActualErrorforEmptyValues();
		String expText = createAccountPage.getExpectedErrorforEmptyValues();
		Assert.assertEquals(actText, expText);
	}

	
	/* * Test Case Summary: This Test Case Verifies the validation for enter password
	 * and reenter password registered for IMDB Expected Result: An error message
	 * "You indicated you are a new customer, but an account already exists with the e-mail "
	 * should be thrown 
	 * Author: Navatha Kannadi */
	 

	@Test(priority=3)
	public void TC_03_verifyWithMisMatchPassword() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.launchUrl();
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
		createAccountPage.enterUserName();
		createAccountPage.enteremail();
		createAccountPage.enterPassword();
		createAccountPage.reenterwrongPassword();
		createAccountPage.clickOnCreateAccount();
		String actText = createAccountPage.getActualErrorTextforpasswordmismatch();
		String expText = createAccountPage.getExpectedErrorTextforpasswordMisMatch();
		Assert.assertEquals(actText, expText);

	}

	
	 /* * Test Case Summary: This Test Case Verifies whether the email id is already
	 * registered for IMDB Expected Result: An error message
	 * "You indicated you are a new customer, but an account already exists with the e-mail "
	 * should be thrown 
	 * Author: Navatha Kannadi */
	 

	@Test(priority=4)
	public void TC_04_VerifyExistingEmailAccount() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.launchUrl();
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
		createAccountPage.enterexistingUserName();
		createAccountPage.enterexistingemail();
		createAccountPage.enterPassword();
		createAccountPage.reenterPassword();
		createAccountPage.clickOnCreateAccount();
		String actText = createAccountPage.getActualErrorforEmptyValues();
		String expText = createAccountPage.getExpectedErrorforEmptyValues();
		Assert.assertEquals(actText, expText);

	}

	@Test(priority=5)
	public void TC_05_VerifyInvalidEmail() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.launchUrl();
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
		createAccountPage.enterUserName();
		createAccountPage.enterInvalidemail();
		createAccountPage.enterPassword();
		createAccountPage.reenterPassword();
		createAccountPage.clickOnCreateAccount();
		String actText = createAccountPage.getActualErrorTextforInvalidEmail();
		String expText = createAccountPage.getExpectedErrorTextforInvalidEmail();
		Assert.assertEquals(actText, expText);

	}
	/*
	 * Test Case Summary: This Test Case tries to signin with existing valid account
	 * Challenge: When signing in getting screen to enter captcha which is difficult to Automate
	 * Author: Navatha Kannadi
	 */
	@Test(priority=6)
	public void TC_06_signInWithExistingUser() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.launchUrl();
		homePage.clickOnSignIn();
		createAccountPage.clickOnSignInWithIMDB();
		createAccountPage.enterexistingemail();
		createAccountPage.enterPassword();
		createAccountPage.clickOnSignIntoIMDB();
		String actText = createAccountPage.getActualErrorforsignIn();
		String expText = createAccountPage.getExpectedErrorforsignIn();
		Assert.assertEquals(actText, expText);
	}

	
	 @AfterClass 
	 public void tearBrowser() { methodName = new Object() {
	 }.getClass().getEnclosingMethod().getName();
	 logger.info("Executing Test Case::" + methodName); dm.closeBrowser(); }
	 

}
