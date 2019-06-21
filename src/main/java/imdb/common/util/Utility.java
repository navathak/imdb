package imdb.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {
	
	//Class Initializations and Variable Declarations
	private Logger logger = Logger.getLogger(Utility.class);
	protected CustomReport customReport;
	protected WebDriverWait webDriverWait;
	protected JavascriptExecutor jse;
	WebElement element;
	WebDriverWait driverWait;
	//public static WebDriver webDriver= DriverManager.getDriver();
	private DriverManager dm;
	private WebDriver webDriver;
	WebElement ele;
	private String methodName;
	final String screenshot_path=System.getProperty("user.dir")+"/screenshots.png";
	
	
	
	public Utility() {
		dm = new DriverManager();
		webDriver = dm.getWebDriver();
	}

	/* Method Name: enterTextWithClear 
	 * Author : Navatha Kannadi
	 * Purpose: Method allows you to enter text in the Text Box 
	 * Parameters to be passed : Locator of the Element , Test Data to be entered , User friendly console message
	 */	
	public void enterTextWithClear(String objectLocator, String objectData,String message)  {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Step::"+methodName);
		//webDriver = DriverManager.getDriver();
		logger.info("WebDriver value in enter method:::"+webDriver);
		String[] str = objectLocator.split(":");
		logger.info("Object Identifier " + str[0]+"\t Object Identifier Value "+str[1]);
		WebElement element = getElement(str[0],str[1]);
		logger.info("The data to be filled in the Textbox is" + objectData);
		logger.info("Element::: " +element);
		element.clear();
		element.sendKeys(objectData);
		logger.info("The data is entered in the Text Field");
	}
	/* Method Name: getElement 
	 * Author : Navatha Kannadi
	 * Purpose: This method will trim the passed Locator from enterTextWithClear method and finds the locator in the DOM and returns the found elemeny
	 * Parameters to be passed : Locator ID(ex: ID,NAME,XPATH... , Locator Name(ex: id ="id6" ,name = "wachtwoord" ...)
	 */
	
	public WebElement getElement(String locatorId, String locatorName)  {
		
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Step::"+methodName);
		try { Thread.sleep(1000); } catch(Exception e){}
		By byValue = null;
		switch (locatorId.toUpperCase()) {
		
		case "ID":
					byValue = By.id(locatorName);
					logger.info("Found Element @"+byValue);
					waitForElementVisibility(byValue);
					ele = webDriver.findElement(byValue);
					break;
					
		case "XPATH":
			
					byValue = By.xpath(locatorName);
					logger.info("Found Element @"+byValue);
					waitForElementVisibility(byValue);
					ele=webDriver.findElement(byValue);
					break;
					
		case "NAME":
			
					byValue = By.name(locatorName);
					logger.info("Found Element @"+byValue);
					ele=webDriver.findElement(byValue);
					break;
		}
		waitForElementVisibility(byValue);
		//try { Thread.sleep(5000); } catch(Exception e1){}
		return ele;
		
	}	
	
	
	public void click(String objectLocator, String message)  {
		String[] str = objectLocator.split(":");
		String objectIdentifier = str[0];
		String identifierValue = str[1];
		logger.info("The object Identifier is" + str[0]);
		logger.info("The object Identifier value is" + str[1]);
		WebElement element = getElement(objectIdentifier, identifierValue);
		element.click();
		logger.info(element+"Element is clicked successfully");
	}
	
	public void click(String locator) {
		
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Step::"+methodName);
		//customReport.reporter("Current method is",methodName);
		
		String[] str = locator.split(":");
		logger.info("Xpath for the Element is" + str);
		
		logger.info("Object Identifier " + str[0]+"\t Object Identifier Value "+str[1]);
		//customReport.reporter("Clicking on ", ""+str[1]);
		
		WebElement element = getElement(str[0], str[1]);
		element.click();
		
		//customReport.reporter("Clicked on ", ""+str[1]);
		logger.info("The Given Element is clicked");
		
		
	}
	
	public String getText(String objectLocator)
	{		
		String[] str = objectLocator.split(":");
		String objectIdentifier = str[0];
		String identifierValue = str[1];
		logger.info("The object Identifier is" + str[0]);
		logger.info("The object Identifier value is" + str[1]);
		WebElement element = getElement(objectIdentifier, identifierValue);
		String getText=element.getText();
		logger.info(getText+"is captured successfully");
		return getText;
	}

	public void clickOnSearchBTN(String locator) {
		
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Step::"+methodName);
		
		String[] str = locator.split(":");
		logger.info("Xpath for the Element is" + str);
		
		logger.info("Object Identifier " + str[0]+"\t Object Identifier Value "+str[1]);
		//customReport.reporter("Clicking on ", ""+str[1]);
		
		WebElement element = getElement(str[0], str[1]);
		element.click();
		waitForPageToLoad(1000);
		//customReport.reporter("Clicked on ", ""+str[1]);
		logger.info("The Given Element is clicked");
		
		
	}

	public static String getScreenhot(WebDriver webDriver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) webDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	            //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public void selectValueFromDD(String locator, String valueToSelect) {
		
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Test Step::"+methodName);
		
		String[] str = locator.split(":");
		logger.info("Xpath for the Element is" + str);
		
		logger.info("Object Identifier " + str[0]+"\t Object Identifier Value "+str[1]);
		//customReport.reporter("Clicking on ", ""+str[1]);
		
		WebElement element = getElement(str[0], str[1]);
		Select dd = new Select(element);
		dd.selectByVisibleText(valueToSelect);
		waitForPageToLoad(1000);
		logger.info("The Given Element is selected");
	}
	
	public String getUniqueName(String appendName) {
		Date currentDate = new Date();
		long time = currentDate.getTime();
		String uniqName=appendName + "-" + time;
		logger.info("Unique Name Generated is ::" +uniqName);
		return uniqName;
		
	}
	
	/*public String getUniqueName(String appendName) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(dateFormat);
		Calendar cal = Calendar.getInstance();
		String uniqName=appendName +dateFormat.format(cal);
		logger.info("Unique Name Generated is ::" +uniqName);
		return uniqName;
		
	}*/






// Waiter Functions

	public int i=1;
	public boolean waitForElementPresentVisible(By locator)
	{
		boolean flag = false;
		int poolFlag=10;
		try {
			while (flag == false && this.i <= poolFlag) {
				logger.info("Inside While Loop"+i);
				if (driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()) {
					logger.info("The Element is Found on the Page");
					flag = true;
					break;
				}
				this.i=1;
				break;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.info("In the Catch Block");
	        i=i+1;
	        logger.info("The Control to Catch block--"+i);
	        if(i<=poolFlag)
	        {
	        waitForElementPresentVisible(locator);
	        }
	        else
	        {
			//customReport.reporter("The Element is not found after 120 Seconds also","");
			return flag;
	        }
		}
		return flag;
	  }
	
	public void waitForElementEnabled(By locator)
	{
		boolean result = false;
		int i=4;
	    try
	    {
	    while(i<4)
	    {
		 result = driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
		 if(result==false)
		 {
			 i++;
		 }
	    }
	    logger.info("The Element is Found on the Page");
		    }
	    catch(Exception e)
	    {
	    	//customReport.reportError("The Element is not Found on the UI");
	    	e.printStackTrace();
	    }
	  }
	
	public boolean waitForTextPresent(WebElement webElement,String text)
	{
		boolean flag = false;
		int poolFlag=4;
		int i = 1;
		try {
			while (flag == false && i <= poolFlag) {
				logger.info("Inside While Loop"+i);
				logger.info("The value is--"+driverWait.until(
						ExpectedConditions.textToBePresentInElement(webElement, text)));
				if (driverWait.until(
						ExpectedConditions.textToBePresentInElement(webElement, text)))
				{
					flag = true;
					break;
				}
				else
				{	
				i+=1;
			}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.info("In the Catch Block");
			//customReport.reporter("The Element is not found after 120 Seconds also","");
		}
		return flag;	
	}
	
		public boolean waitForElementVisibility(By locator)
		{
		
		boolean flag=false;
		int iterateCount=1;
		while(!flag && iterateCount<=5){
			
			try{
				
				if(driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()){
					
					flag=true;
					break;
					
				}
			}catch(Exception e){
				
				iterateCount++;
				flag=false;
			}
		}
		
		return flag;
	}
	
	public boolean waitForElementVisibility(String locator, WebDriver webDriver)
	{
		boolean isElementVisible = false;
		String identifier[] = locator.split("===");
		
		try{
		if(identifier[0].equalsIgnoreCase("xpath"))
		{
			webDriver.findElement(By.xpath(identifier[1]));
			isElementVisible = true;
			
		}
		else{
			webDriver.findElement(By.id(identifier[1]));
			isElementVisible = true;
		}
		
		}
		catch(Exception e){
			isElementVisible = false;
		}
		return isElementVisible;
		
	}
	public void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			logger.info("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

		}
	}

	public DriverManager getDm() {
		return dm;
	}

	public void setDm(DriverManager dm) {
		this.dm = dm;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	

}
