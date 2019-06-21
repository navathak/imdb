package imdb.moduletestcase.login;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.login.LogOut;
import imdb.modules.login.LoginPage;

public class LoginPageTest_TestNG {

	private static Logger logger=Logger.getLogger(LoginPageTest_TestNG.class);
	
	private LoginPage loginPage;
	//public static DriverManager dm = DriverManager.getDriverManager();
	private DriverManager dm;
	private String methodName;
	//LogOut logout = new LogOut();
	
	/**
	 * No arg constructor
	 */
	public LoginPageTest_TestNG() {
		loginPage  = new LoginPage();
		dm = loginPage.getUtil().getDm();
	}
	
	/**
	 * Constructor with LoginPage to work with other test cases
	 * @param loginPage
	 */
	public LoginPageTest_TestNG(LoginPage newLoginPage) {
		loginPage = newLoginPage;
		dm = loginPage.getUtil().getDm();
	}

	//TestNG Tests

	@BeforeClass
	public void LaunchBrowser() throws InterruptedException {
		logger.info("LoginPageTest");
		dm.launchUrl();
	}
	@Test(priority=1)
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
	}

	@AfterClass
	public void tearBrowser() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Case::" + methodName);
		dm.closeBrowser();
	}
	
	public LoginPage getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}
	
	
}
