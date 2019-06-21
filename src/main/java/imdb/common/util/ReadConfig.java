package imdb.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ReadConfig {
	
	public Properties prop_Loc;
	public Properties prop_TestData;
	private static Logger logger = Logger.getLogger(ReadConfig.class);
	private String methodName;
	
	private static Properties allProps = new Properties();
	
	public void readFromProp_Locators(String propFileName) {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing the Method:::" + methodName);
		String fp= System.getProperty("user.dir")+"/src/main/resources/"+propFileName+".properties";
		try {
			prop_Loc = new Properties();
			FileInputStream ip = new FileInputStream(fp);
			prop_Loc.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFromProp_TestData(String propFileName) {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		logger.info("Executing the Method:::" + methodName);
		String fp= System.getProperty("user.dir")+"/src/main/resources/"+propFileName+".properties";
		try {
			prop_TestData = new Properties();
			FileInputStream ip = new FileInputStream(fp);
			prop_TestData.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Generic method to read all the properties 
	 * 
	 */
	/*public void readDate() {
		//logger.info("Executing the Method:::" + getClass().getEnclosingMethod().getName());
		List<String> fileList = new ArrayList<String>();
		fileList.add("homePageRepo");
		fileList.add("homePageTestData");
		
		StringBuffer sb = new StringBuffer();
		for(String fileName: fileList) {
			String fileLoc = System.getProperty("user.dir")+"/src/main/resources/"+fileName+".properties";
			logger.info("TestData property file Path:::::::::" +sb);
			try {
				FileInputStream ip = new FileInputStream(fileLoc);
				allProps.load(ip);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			allProps.
		}
	}
	
	public static void main(String args[]) {
		ReadConfig config = new ReadConfig();
		config.readDate();
		System.out.println("Properties loaded : " + allProps.size());
		
	}*/
	
	
}
