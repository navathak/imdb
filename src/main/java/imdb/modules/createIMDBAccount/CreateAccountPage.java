package imdb.modules.createIMDBAccount;

import org.apache.log4j.Logger;

import imdb.common.util.ReadConfig;
import imdb.common.util.Utility;

public class CreateAccountPage {

	// Initializing the class objects and variables
	// public static WebDriver webDriver = DriverManager.getDriver();;
	private Logger logger = Logger.getLogger(CreateAccountPage.class);
	private ReadConfig readConfig;
	// Properties prop;
	private Utility util;

	public CreateAccountPage() {
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
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.username"),
				(readConfig.prop_TestData.getProperty("username") ), "Successfully Entered USerNAme");
	}

	public void enteremail() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.email"),
				readConfig.prop_TestData.getProperty("email"), "Successfully Entered email");
	}

	public void enterInvalidemail() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.email"),
				readConfig.prop_TestData.getProperty("invalidemail"), "Successfully Entered email");
	}

	public void enterexistingUserName() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.username"),
				readConfig.prop_TestData.getProperty("existingUsername"), "Successfully Entered USerNAme");
	}

	public void enterexistingemail() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.email"),
				readConfig.prop_TestData.getProperty("existingemail"), "Successfully Entered email");
	}

	public void enterPassword() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.password"),
				readConfig.prop_TestData.getProperty("password"), "Successfully Entered password");
	}

	public void reenterPassword() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.reenterpassword"),
				readConfig.prop_TestData.getProperty("reenterpassword"), "Successfully reEntered password");
	}

	public void reenterwrongPassword() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("loginpage.txt.reenterpassword"),
				readConfig.prop_TestData.getProperty("reenterwrongpassword"), "Successfully reEntered password");
	}

	public void clickOnCreateAccount() {
		util.click((readConfig.prop_Loc.getProperty("loginpage.btn.createaccount")));
	}

	public void clickOnSignIntoIMDB() {
		util.click((readConfig.prop_Loc.getProperty("loginpage.btn.sigin")));
	}

	public void clickOnSignInWithIMDB() {
		util.click(readConfig.prop_Loc.getProperty("loginpage.btn.sigiinwithimdb"));
	}

	public String getNewUserName() {
		String newUserName = util.getText(readConfig.prop_Loc.getProperty(("loginpage.txt.newusername")));
		return newUserName;
	}

	public String getExpUserName() {
		String ExpUserName = readConfig.prop_TestData.getProperty("username");
		util.waitForPageToLoad(10000);
		return ExpUserName;
	}

	public String getExpectedErrorText() {
		String expText = util.getText(readConfig.prop_Loc.getProperty("loginpage.txt.errortext"));
		return expText;
	}

	public String getActualErrorText() {
		String actText = util.getText(readConfig.prop_TestData.getProperty(("expextederrortext")));
		return actText;
	}

	public String getExpectedErrorTextforpasswordMisMatch() {
		String expText = readConfig.prop_TestData.getProperty(("mismatchpassworderrortext"));
		return expText;
	}

	public String getActualErrorTextforpasswordmismatch() {
		String expText = util.getText(readConfig.prop_Loc.getProperty("loginpage.txt.paswordmismatch"));
		return expText;
	}

	public void mouseHoverToUserName() {
		util.mouseHover(readConfig.prop_Loc.getProperty("loginpage.txt.newusername"),
				readConfig.prop_Loc.getProperty("loginpage.link.logout"));
	}

	public String getExpectedErrorTextforInvalidEmail() {
		String expText = readConfig.prop_TestData.getProperty(("invalidemailerrortext"));
		return expText;
	}

	public String getActualErrorTextforInvalidEmail() {
		String expText = util.getText(readConfig.prop_Loc.getProperty("loginpage.txt.paswordmismatch"));
		return expText;
	}

	public String getExpectedErrorforEmptyValues() {
		String expText = readConfig.prop_TestData.getProperty(("erroronemptyvalues"));
		return expText;
	}

	public String getActualErrorforEmptyValues() {
		String expText = util.getText(readConfig.prop_Loc.getProperty("loginpage.alert.erroronemtyvalues"));
		return expText;
	}

	public String getExpectedErrorforsignIn() {
		String expText = readConfig.prop_TestData.getProperty(("signInmessage"));
		return expText;
	}

	public String getActualErrorforsignIn() {
		String expText = util.getText(readConfig.prop_Loc.getProperty("loginpage.alert.erroronemtyvalues"));
		return expText;
	}

	public Utility getUtil() {
		return util;
	}

}