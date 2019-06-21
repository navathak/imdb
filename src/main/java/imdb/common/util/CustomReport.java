package imdb.common.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomReport {
	public ExtentReports report;
	public ExtentTest logmsg;
	//public static WebDriver webDriver = DriverManager.webDriver;
	final String reportFile= System.getProperty("user.dir")+"/report.html";
	public ITestResult result;
	public String image;
	Utility util = new Utility();
	String screenshot_path;
	private Logger logger = Logger.getLogger(CustomReport.class);
	
	/* ** Failure Results ** */
	public void Failureresults(String consoleMsg) {
		if(result.getStatus()==ITestResult.FAILURE) {
			try {
				//screenshot_path=Utility.getScreenhot(webDriver, result.getName());
			} catch (Exception e) {
				logger.info("Test Case is failed because of:" + e.getMessage());
			}
			image=logmsg.addScreenCapture(screenshot_path);
			logmsg.log(LogStatus.INFO, consoleMsg);
		}else if(result.getStatus()==ITestResult.SKIP) {
			logmsg.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		/*report.endTest(logmsg);
		report.flush();*/
	}
	/* ** Passed Results ** */
	public void passTest(String testCaseName){
		logmsg = report.startTest("passTest");
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		logmsg.log(LogStatus.PASS, testCaseName);
	}
	/* ** Start Report ** */
	public void init(String testDescription) {
		report = new ExtentReports (reportFile, true);
		//report.startTest(testDescription);
	}
	/* ** Capture Logs ** */
	public void logmessage(String logMessage) {
		logmsg.log(LogStatus.INFO, logMessage);
	}
	/* ** End Report ** */
	public void endReport() {
		report.endTest(logmsg);
		/*report.flush();
		report.close();*/
	}
	
}
