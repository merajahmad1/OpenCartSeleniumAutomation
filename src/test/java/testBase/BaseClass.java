package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public WebDriver driver;
public Logger logger;
public Properties p;
	
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
		//Loading config.properties file
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());  // this is for Log4j
		
		
		switch(br.toLowerCase())
		{
		
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;	
			
		case "firefox":
			driver = new FirefoxDriver();
			break;	
			
		default:
			System.out.println("Driver name is Invalid...");
			logger.info("Browser is incorrect");
			return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");		
		
		driver.get(p.getProperty("appURL")); //reading URL from properties files
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String randomText = RandomStringUtils.randomAlphabetic(6);
		return randomText;
	}
	
	public String randomNumber()
	{
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String randomText = RandomStringUtils.randomAlphabetic(6);
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomText+randomNumber;
	}


}
