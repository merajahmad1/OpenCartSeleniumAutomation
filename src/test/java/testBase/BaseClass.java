package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
public WebDriver driver;
public Logger logger;
	
	
	@BeforeClass
	public void setup()
	{
		
		logger = LogManager.getLogger(this.getClass());  // this is for Log4j
		
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");		
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
