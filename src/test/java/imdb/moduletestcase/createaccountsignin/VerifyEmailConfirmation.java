package imdb.moduletestcase.createaccountsignin;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.createaccountsignIn.CreateAccountPage;
import imdb.modules.createaccountsignIn.GmailLoginPage;
import imdb.modules.home.HomePage;

public class VerifyEmailConfirmation {

	private static Logger logger=Logger.getLogger(VerifyEmailConfirmation.class);
	
	private CreateAccountPage createAccountPage;
	//public static DriverManager dm = DriverManager.getDriverManager();
	private DriverManager dm;
	private String methodName;
	HomePage homePage = new HomePage();
	GmailLoginPage gmailLoginPage = new GmailLoginPage();
	
	/**
	 * No arg constructor
	 */
	public VerifyEmailConfirmation() {
		createAccountPage  = new CreateAccountPage();
		dm = createAccountPage.getUtil().getDm();
	}
	
	/**
	 * Constructor with LoginPage to work with other test cases
	 * @param loginPage
	 */
	/*public LoginPageTest_TestNG(CreateAccountPage newLoginPage) {
		createAccountPage = newLoginPage;
		dm = createAccountPage.getUtil().getDm();
	}*/

	//TestNG Tests

	@BeforeClass
	public void LaunchBrowser() throws InterruptedException {
		logger.info("LoginPageTest");
		dm.openNewWindow();
	}
		
	@Test
	public void TC_01_verifyAccount()
	{
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::"+methodName);
		gmailLoginPage.enteremail();
		gmailLoginPage.clickOnNext();
		gmailLoginPage.enterPassword();
		gmailLoginPage.clickOnPasswordNext();
		gmailLoginPage.clickOnEmail();
		gmailLoginPage.clickOnVerificationEmail();
		
	}

	@AfterClass
	public void tearBrowser() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.closeBrowser();
	}
	
	
	
	
}
