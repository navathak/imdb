package imdb.modules.home;

import org.apache.log4j.Logger;

import imdb.common.util.ReadConfig;
import imdb.common.util.Utility;
import imdb.modules.createaccountsignIn.CreateAccountPage;

public class HomePage {
	
	//public static WebDriver webDriver= DriverManager.getDriver();;
	private Logger logger=Logger.getLogger(CreateAccountPage.class);
	//public Utility util= new Utility();
	//private LoginPage loginPage;
	private Utility util;
	private String methodName;
	private ReadConfig readConfig;
	
	public HomePage() {
		logger.info("Loading HomePage Locator property file" );
		readConfig = new ReadConfig();
	//	loginPage = new LoginPage();
		util = new Utility();
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
	public void clickOnSignIn() {
		util.click(readConfig.prop_Loc.getProperty("homepage.link.signIn"));
	}
	public void clickOnCreateAccount() {
		util.click(readConfig.prop_Loc.getProperty("homepage.link.CreateAccount"));
	}
	public void SignIn() {
		util.click(readConfig.prop_Loc.getProperty("homepage.link.CreateAccount"));
	}
	

	public Utility getUtil() {
		return util;
	}
/*
	public LoginPage getLoginPage() {
		return loginPage;
	}*/
	
	

}
