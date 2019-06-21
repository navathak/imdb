package imdb.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
	
	//Initializing classes and declaration of Variables
	private static Logger logger = Logger.getLogger(DriverManager.class);
	//private static long WAIT = 60;
	private static WebDriver webDriver;
	protected WebDriverWait webDriverWait;
	protected CustomReport customReport;
	
	private Properties prop;
	private String filePath;
	private String browsertype;
	private String readfile;
	private static String methodName;
	
	private static DriverManager driverManager = new DriverManager();
	
	public  DriverManager()  {
		//Loading the Environment.properties file
		/*methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Method::"+methodName);*/
		readfile= System.getProperty("user.dir")+"/src/main/resources"+"/Environment.properties";
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources"+"/Environment.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Reading file path of drivers
		 filePath = new File("").getAbsolutePath();
		 browsertype = prop.getProperty("browser");
		 logger.info("The type of the browser passed is ::" +browsertype);
		 char cforwardslash = (char) 47;
		 char cbackslash = (char) 92;
		 String basePath=filePath.replace(cbackslash,cforwardslash);
		 logger.info(basePath);
		if (browsertype.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",basePath+"./ExecutableDrivers/geckodriver.exe");
			webDriver  = new FirefoxDriver();
			logger.info("Initializing firefox webDriver");
			/*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette",true);
			webDriver= new FirefoxDriver(capabilities);
*/
		} else if (browsertype.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",basePath+"./ExecutableDrivers/chromedriver_win32/chromedriver.exe");
			webDriver = new ChromeDriver();
			logger.info("Initializing chrome webDriver");

		} else if (browsertype.equalsIgnoreCase("iexplorer")) {

			//DesiredCapabilities capabilities =DesiredCapabilities.internetExplorer();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
			System.setProperty("webdriver.ie.driver",basePath+"./ExecutableDirvers/IEDriverServer_Win32_2.45.0/IEDriverServer.exe");
			webDriver = new InternetExplorerDriver();

			logger.info("Initializing iexplorer webDriver");
		}
		logger.info("Web Driver initializer:: " +webDriver);
		webDriver.manage().window().maximize();
		//return webDriver;
	}
	
	public void launchUrl() {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Method::"+methodName);
		logger.info("Launching the URL ::::" +  prop.getProperty("url"));
		webDriver.get(prop.getProperty("url"));
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	}

	
	public void closeBrowser() {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Method::"+methodName);
		webDriver.close();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public static WebDriver getDriver() {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing Method::"+methodName);
		logger.info("Driver::::" + webDriver);
		return webDriver;
		
	}
	
	public static DriverManager getDriverManager() {
		return driverManager;
	}
	 

}
