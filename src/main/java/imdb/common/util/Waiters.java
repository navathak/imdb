package imdb.common.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
private static Logger logger = Logger.getLogger(Waiters.class);
	
	private CustomReport customReport;
	private WebDriver driver;
	private WebDriverWait driverWait;
	
	public Waiters(WebDriver driver,CustomReport customReport,WebDriverWait driverWait)
	{
		this.customReport = customReport;
		this.driver = driver;
		this.driverWait = driverWait;
	}
	
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

}
