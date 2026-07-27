package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verifyLogin_DDT(String email, String pwd, String exp) {

		logger.info("***************Starting Login Test TC003_LoginDDT*************");
		
		try {

		// Home Page
		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		hp.clickLogin();

		// Login Page
		LoginPage lp = new LoginPage(driver);

		lp.setEmailAddress(email);
		lp.setPassword(pwd);
		lp.clickLoginButton();

	

		// Account Page
		MyAccountPage maccp = new MyAccountPage(driver);
		boolean myAccountPageExists = maccp.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(myAccountPageExists == true)
			{
				Assert.assertTrue(true);
				maccp.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(myAccountPageExists == true)
			{
				maccp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("***************finishing Login Test TC003_LoginDDT*************");
	}

}
