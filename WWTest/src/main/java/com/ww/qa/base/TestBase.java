package com.ww.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ww.qa.util.TestUtil;

public class TestBase {
	//Initializing webdriver
	 static public WebDriver driver;
	 //Initializing Properties
	 static public Properties prop;
	 /** Loding config file
	  * 
	  */
	public TestBase(){
		//Loading config file
		try{
			prop=new Properties();
			FileInputStream ip= new FileInputStream("src//main//java//com//ww//qa//config//config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e){
			System.out.println("File is not avialable in the specified location "+e);
			
		}
		catch(IOException e){
			System.out.println("Unable to access the file  in the specified location "+e);
		}
		catch(Exception e){
			System.out.println("Unable to access the file  in the specified location "+e);
		
		}
		
	}
    /**Launching the browser
     * 
     ****/
	public static void intialization(){
		String browser=prop.getProperty("browser");
		String baseUrl=prop.getProperty("url");
		if(browser.equals("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver","src\\main\\java\\com.ww.qa.software\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver(options);
		}
    	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implictwait, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
    }	

}
