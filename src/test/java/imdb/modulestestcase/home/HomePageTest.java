package imdb.modulestestcase.home;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import imdb.common.util.DriverManager;
import imdb.modules.home.HomePage;

public class HomePageTest {

	private static Logger logger=Logger.getLogger(HomePageTest.class);
	
	//LoginPage loginPage = new LoginPage();
	private HomePage homePage;
	public  DriverManager dm = DriverManager.getDriverManager();
	
	private String methodName;
	//LogOut logout = new LogOut();
	
	//private DriverManager dm;
	
	
	public HomePageTest() {
		super();
		homePage = new HomePage();
		//loginPage = homePage.getLoginPage();
		//dm = loginPage.getUtil().getDm();
		//dm.launchUrl();
		//logintest = new LoginPageTest_TestNG(loginPage);
		//logintest.setLoginPage(loginPage);
	}
	
	
	//TestNG Testsh

	@BeforeClass
	public void LaunchBrowser() throws InterruptedException {
		
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
	
	
	/*@Test
	public void TC_04_logOut() {
		//logger.info("Executing Test Case::"+ getClass().getEnclosingMethod().getName());
		loginPage.clickOnLogout();
	}*/

	@AfterClass
	public void tearBrowser() {
		
		//logger.info("Executing Test Case::" + getClass().getEnclosingMethod().getName());
		dm.closeBrowser();
	}
}
