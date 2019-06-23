package imdb.moduletestcase.createaccountsignin;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.createIMDBAccount.CreateAccountPage;
import imdb.modules.createIMDBAccount.MailHelper;
import imdb.modules.home.HomePage;

public class CreateNewAccountPageTrailAndRun {

	private static Logger logger = Logger.getLogger(IMDBTestScripts.class);

	private CreateAccountPage createAccountPage;

	private DriverManager dm;
	private String methodName;
	HomePage homePage = new HomePage();
	private MailHelper mailHelper = new MailHelper();
	/**
	 * No arg constructor
	 */
	public CreateNewAccountPageTrailAndRun() {
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
	@Test(priority = 1)
	public void TC_01_verifyHomePage() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		String actTitle = homePage.actTitle();
		String expTitle = homePage.expTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	/*
	 * Test Case Summary: This Test Case navigates to signin and then Create Account
	 * Page Expected Result: The automated browser should be on Create new Account
	 * Page Author: Navatha Kannadi
	 */
	@Test(priority = 2)
	public void TC_02_clickOnSignIn() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
	}
	/*
	 * Test Case Summary: This Test Case creates new account for IMDB Expected
	 * Result: A new account should be created and the user should be signin Author:
	 * Navatha Kannadi
	 */

	@Test(priority = 3)
	public void TC_03_createAccount() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.launchUrl();
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
		createAccountPage.enterUserName();
		createAccountPage.enteremail();
		createAccountPage.enterPassword();
		createAccountPage.reenterPassword();
		createAccountPage.clickOnCreateAccount();

	}
	
	/*
	 * Test Case Summary: This Test Case verifies and clicks on verification email
	 * Result: The account is confirmed by clicking on verification email. 
	 * Author: Navatha Kannadi
	 */
	public void TC_04_confirmEmail() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
	}
	

	@AfterClass
	public void tearBrowser() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.closeBrowser();
	}

}
