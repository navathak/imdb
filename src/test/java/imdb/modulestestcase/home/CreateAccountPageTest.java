package imdb.modulestestcase.home;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.signIn.CreateAccountPage;

public class CreateAccountPageTest {

	private static Logger logger=Logger.getLogger(CreateAccountPageTest.class);
	
	private CreateAccountPage loginPage;
	//public static DriverManager dm = DriverManager.getDriverManager();
	private DriverManager dm;
	private String methodName;
	//LogOut logout = new LogOut();
	private HomePageTest homePageTest = new HomePageTest();
	
	/**
	 * No arg constructor
	 */
	public CreateAccountPageTest() {
		loginPage  = new CreateAccountPage();
		dm = loginPage.getUtil().getDm();
	}
	
	/**
	 * Constructor with LoginPage to work with other test cases
	 * @param loginPage
	 */
	/*public CreateAccountPageTest(CreateAccountPage newLoginPage) {
		loginPage = newLoginPage;
		dm = loginPage.getUtil().getDm();
	}*/

	//TestNG Tests

	@BeforeClass
	public void LaunchBrowser() throws InterruptedException {
		logger.info("LoginPageTest");
		dm.launchUrl();
	}
	/*@Test(priority=1)
	public void tc_01_VerifyLoginPage() throws InterruptedException {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::"+methodName);
		String actTitle=loginPage.getActTitle();
		String expTitle=loginPage.getExpTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	@Test(priority=2)
	public void tc_02_successfulLogin() throws InterruptedException {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::"+methodName);
		loginPage.selectSchool_Nordwincollege();
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickOnLogin();
	}
	@Test(priority=3)
	public void tc_03_logOut() {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::"+methodName);
		loginPage.clickOnLogout();
	}*/

	@AfterClass
	public void tearBrowser() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.closeBrowser();
	}
	
	public CreateAccountPage getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(CreateAccountPage loginPage) {
		this.loginPage = loginPage;
	}
	
	
}
