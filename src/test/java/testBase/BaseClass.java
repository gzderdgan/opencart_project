package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging


public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //for logging
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Regression","Master","Sanity"})
	@Parameters("browser")
	public void setup(String br) 
	{
		rb = ResourceBundle.getBundle("config");//Load config.propertiesfile
		logger=LogManager.getLogger(this.getClass());
		
		//YOu can use below to disable the view of Chrome is controlled by automation ..
	/*	ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	*/	
	//	WebDriverManager.chromedriver().setup();
		
		if(br.equals("chrome")){
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL1"));
		//driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
			
	}
	@AfterClass(groups= {"Regression","Master","Sanity"})
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String randomString() 
	{
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
		
	}
	public String randomNumber() 
	{
		String generatedString2= RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	
	public String randomAlphaNumeric() 
	{
		String st= RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(2);
		return(st+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
		
	}

}