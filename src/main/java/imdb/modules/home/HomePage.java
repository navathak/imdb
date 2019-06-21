package imdb.modules.home;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import imdb.common.util.DriverManager;
import imdb.common.util.ReadConfig;
import imdb.common.util.Utility;
import imdb.modules.login.LoginPage;

public class HomePage {
	
	//public static WebDriver webDriver= DriverManager.getDriver();;
	private Logger logger=Logger.getLogger(LoginPage.class);
	//public Utility util= new Utility();
	private LoginPage loginPage;
	private Utility util;
	private String methodName;
	private ReadConfig readConfig;
	
	public HomePage() {
		logger.info("Loading HomePage Locator property file" );
		readConfig = new ReadConfig();
		loginPage = new LoginPage();
		util = loginPage.getUtil();
		readConfig.readFromProp_Locators("homePageRepo");
		logger.info("Loading HomePage Test Data property file" );
		readConfig.readFromProp_TestData("homePageTestData");
	}
	
	public String actTitle() {
		String actHPtitle= util.getWebDriver().getTitle();
		return actHPtitle;
	}
	public String expTitle() {
		String expHPtitle=  readConfig.prop_TestData.getProperty("homePage.homePageTitle");
		return expHPtitle;
	}
	public void clickOnHomePage() {
		util.click(readConfig.prop_Loc.getProperty("homepage.link.hometab"));
	}

	public Utility getUtil() {
		return util;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	

}
