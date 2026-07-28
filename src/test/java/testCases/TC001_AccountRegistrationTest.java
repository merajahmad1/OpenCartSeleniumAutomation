package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups = {"Regression", "Master"})
	public void verify_account_registration()
	{
		
		
		logger.info("********** Starting test case Execution *******************");
		
		try {
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("***********clicked on my account link**************");
		
		hp.clickRegister();
		
		logger.info("***********clicked on registration link**************");
		
		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("providing registration details");
		
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString() + "@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.clickPrivacyPolicy();
		regPage.clickContinue();
		
		String confirmationMessage = regPage.getConfirmationMessage();
		
		Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
			
	}
	
	catch(Exception e)
	{
		logger.error("test is failed");
		logger.debug("Debugs log....");
		Assert.fail();
	}
		
		logger.info("********** Starting test case Execution *******************");
		
	}
	
}
