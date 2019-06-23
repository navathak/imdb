package imdb.modules.createIMDBAccount;

import org.apache.log4j.Logger;

import imdb.common.util.ReadConfig;
import imdb.common.util.Utility;

public class EmailLoginPage {

	private Logger logger = Logger.getLogger(EmailLoginPage.class);
	private ReadConfig readConfig;
	// Properties prop;
	private Utility util;

	public EmailLoginPage() {
		util = new Utility();
		readConfig = new ReadConfig();
		logger.info("Loading email Page Locator property file");
		readConfig.readFromProp_Locators("email");
		logger.info("Loading email Test Data property file");
		readConfig.readFromProp_TestData("emailTestData");
	}

	/*
	 * Method Name: verifyLoginPage Author : Navatha Kannadi Purpose: Verifies the
	 * launched Application is Expected Application
	 */

	public void enteremail() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("gmail.txt.emailid"),
				readConfig.prop_TestData.getProperty("gmailEmail"), "Successfully Entered email");
	}

	public void clickOnNext() {
		util.click(readConfig.prop_Loc.getProperty("gmail.btn.next"));
	}

	public void enterPassword() {
		util.enterTextWithClear(readConfig.prop_Loc.getProperty("gmail.txt.password"),
				readConfig.prop_TestData.getProperty("password"), "Successfully Entered password");
	}

	public void clickOnPasswordNext() {
		util.click(readConfig.prop_Loc.getProperty("gmail.btn.passwordnext"));
	}

	public void clickOnEmail() {
		// util.clickonWebtable();
	}

	public void clickOnVerificationEmail() {
		util.click(readConfig.prop_Loc.getProperty("gmail.link.verification"));
	}

	public Utility getUtil() {
		return util;
	}
}
