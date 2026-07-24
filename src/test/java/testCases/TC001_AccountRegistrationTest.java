package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(priority=1)
	public void verify_account_registration()
	{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickRegister();
		
		System.out.println("registration page is opened....");
		
		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
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
	
	
}
