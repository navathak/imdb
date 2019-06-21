package imdb.modules.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import imdb.common.util.DriverManager;
import imdb.common.util.ReadConfig;
import imdb.common.util.Utility;

public class LoginPage {

	// Initializing the class objects and variables
	//public static WebDriver webDriver = DriverManager.getDriver();;
	private Logger logger = Logger.getLogger(LoginPage.class);
	private ReadConfig readConfig;
	// Properties prop;
	private Utility util;
	private String methodName;

	public LoginPage() {
		util = new Utility();
		readConfig = new ReadConfig();
		logger.info("Loading Login Page Locator property file");
		readConfig.readFromProp_Locators("loginRepo");
		logger.info("Loading LoginPage Test Data property file");
		readConfig.readFromProp_TestData("loginPageTestData");
	}

	/*
	 * Method Name: verifyLoginPage Author : Navatha Kannadi Purpose: Verifies the
	 * launched Application is Expected Application
	 */

	public void enterUserName() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.username"),readConfig.prop_TestData.getProperty("username"), "Successfully Entered USerNAme");
	}

	public void enterPassword() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.password"),readConfig.prop_TestData.getProperty("password"), "Successfully Entered password");
	}

	public void clickOnLogin() {
		util.click((readConfig.prop_Loc.getProperty("loginpage.btn.login")));
	}
	public void selectSchool_Nordwincollege() {
		util.click(readConfig.prop_Loc.getProperty("loginpage.link.sch_NordwinCollege"));
	}
	public String getActTitle() {
		String actTitle= util.getWebDriver().getTitle();
		return actTitle;
	}
	public String getExpTitle() {
		String expTitle= readConfig.prop_TestData.getProperty("loginpage.logintitle");
		return expTitle;
	}
	public void clickOnLogout() {
		util.click((readConfig.prop_Loc.getProperty("logout.btn.logoff")));
	}

	public Utility getUtil() {
		return util;
	}
	

	/*public void verifyLoginPage() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing the Method:::" + methodName);
		String loginPageTitle = webDriver.getTitle();
		logger.info("Login Page Title @ Run Time :" + loginPageTitle);
		logger.info("Loading property files");
		String actualTitle = readConfig.prop_TestData.getProperty("loginpage.logintitle");
		logger.info("Actual title :" + actualTitle);
		Assert.assertEquals(actualTitle, loginPageTitle);
	}

	
	 * Method Name: successfulLogin Author : Navatha Kannadi Purpose: makes
	 * successful login into the Application with valid credentials
	 
	public void successfulLogin() throws InterruptedException {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger.info("Executing the Method:::" + methodName);
		logger.info("Loading property files");
		// loginrepo.LoginRepoLoader_TestData();
		
		 * logger.info("Loading Environment Properties");
		 * readConfig.readFromProp_Locators("Environment");;
		 
		String school = readConfig.prop_Loc.getProperty("loginpage.link.sch_NordwinCollege");
		if (school.contains("Nordwin College")) {
			util.click(readConfig.prop_Loc.getProperty("loginpage.link.sch_NordwinCollege"));
			util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.username"),
					readConfig.prop_TestData.getProperty("username"), "Successfully Entered USerNAme");
			util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.password"),
					readConfig.prop_TestData.getProperty("password"), "Successfully Entered password");
			util.click((readConfig.prop_Loc.getProperty("loginpage.btn.login")));
		} else {
			util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.username"),
					readConfig.prop_TestData.getProperty("username"), "Successfully Entered USerNAme");
			util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.password"),
					readConfig.prop_TestData.getProperty("password"), "Successfully Entered password");
			util.click((readConfig.prop_Loc.getProperty("loginpage.btn.login")));
		}

	}*/
}