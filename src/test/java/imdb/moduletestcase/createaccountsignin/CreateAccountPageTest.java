package imdb.moduletestcase.createaccountsignin;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.createaccountsignIn.CreateAccountPage;
import imdb.modules.home.HomePage;

public class CreateAccountPageTest {

	private static Logger logger = Logger.getLogger(CreateAccountPageValidations.class);

	private CreateAccountPage createAccountPage;

	private DriverManager dm;
	private String methodName;
	HomePage homePage = new HomePage();

	/**
	 * No arg constructor
	 */
	public CreateAccountPageTest() {
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
	 * Expected Result: The title of the page must be matched. 
	 * Author: Navatha Kannadi
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



	/*
	 * Test Case Summary: This Test Case navigates to signin and then Create Account
	 * Page Expected Result: The automated browser should be on Create new Account
	 * Page Author: Navatha Kannadi
	 */
	@Test(priority=2)
	public void TC_02_clickOnSignIn() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
	}
	/*
	 * Test Case Summary: This Test Case creates new account for IMDB Expected
	 * Result: A new account should be created and the user should be signin 
	 * Author: Navatha Kannadi
	 */

	@Test(priority=3)
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
		/*String expUserName=createAccountPage.getExpUserName();
		String newUserName=	createAccountPage.getNewUserName();
		if(expUserName.equalsIgnoreCase(newUserName)) {
			logger.info("The new user is signedin Successfully");
		}
*/
	}
	/*
	 * Test Case Summary: This Test Case creates new account for IMDB Expected
	 * Result: A new account should be created and the user should be signin 
	 * Author: Navatha Kannadi
	 */

	/*@Test()
	public void TC_04_signOut() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		createAccountPage.mouseHoverToUserName();
		//createAccountPage.clickOnLogout();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	
	
	
	@AfterClass
	public void tearBrowser() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.closeBrowser();
	}

}
