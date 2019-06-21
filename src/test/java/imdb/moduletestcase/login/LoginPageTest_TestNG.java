package imdb.moduletestcase.login;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.signIn.LogOut;
import imdb.modules.home.HomePage;
import imdb.modules.signIn.CreateAccountPage;

public class LoginPageTest_TestNG {

	private static Logger logger=Logger.getLogger(LoginPageTest_TestNG.class);
	
	private CreateAccountPage createAccountPage;
	//public static DriverManager dm = DriverManager.getDriverManager();
	private DriverManager dm;
	private String methodName;
	HomePage homePage = new HomePage();
	
	/**
	 * No arg constructor
	 */
	public LoginPageTest_TestNG() {
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
		dm.launchUrl();
	}
	@Test()
	public void TC_01_verifyHomePage() {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::"+methodName);
		String actTitle = homePage.actTitle();
		String expTitle = homePage.expTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	@Test()
	public void TC_02_clickOnSignIn() {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::"+methodName);
		homePage.clickOnSignIn();
		homePage.clickOnCreateAccount();
	}
	@Test()
	public void TC_03_createAccount() {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::"+methodName);
		createAccountPage.enterUserName();
		createAccountPage.enteremail();
		createAccountPage.enterPassword();
		createAccountPage.reenterPassword();
		createAccountPage.clickOnCreateAccount();
	}
	

	/*@AfterClass
	public void tearBrowser() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.closeBrowser();
	}*/
	
	/*public CreateAccountPage getLoginPage() {
		return createAccountPage;
	}
	public void setLoginPage(CreateAccountPage loginPage) {
		this.createAccountPage = loginPage;
	}*/
	
	
}
