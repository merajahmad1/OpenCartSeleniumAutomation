package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest {
	
	public WebDriver driver;
	
	
	@BeforeClass
	public void setup()
	{
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
	
	@Test
	public void verify_account_registration()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.setFirstName(randomString().toUpperCase());
		
		
		
	}

}
