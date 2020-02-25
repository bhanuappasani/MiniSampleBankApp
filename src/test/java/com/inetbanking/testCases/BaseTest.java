package com.inetbanking.testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

	public static WebDriver driver;
	public static Logger log;
	
	ReadConfig rConfig = new ReadConfig();
	
	public String baseUrl = rConfig.getApplicationURL();
    public String userName = rConfig.getUserName();
    public String passWord = rConfig.getPassword();

    //public static Logger log;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br){

    	if(br.equals("chrome")) {
        	System.setProperty("webdriver.chrome.driver",rConfig.getChromePath())  ;
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox")){
        	System.setProperty("webdriver.chrome.driver",rConfig.getChromePath())  ;
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie")) {
        	System.setProperty("webdriver.chrome.driver",rConfig.getChromePath())  ;
            driver = new InternetExplorerDriver();
        }
    	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
        log = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    
    public void captureScreen(WebDriver driver, String tname) throws IOException {
    	TakesScreenshot tScreenshot = (TakesScreenshot) driver;
    	File source = tScreenshot.getScreenshotAs(OutputType.FILE);
    	File target = new File(System.getProperty("user.dir") + "/Screenshots" + tname + ".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot Taken");
    }
    
	public String randomestring() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return(generatedString);
	}
     
}
