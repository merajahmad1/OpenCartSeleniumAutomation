package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"Sanity", "Master"})
	public void verifyLogin() {
		logger.info("***************Starting Login Test*************");

		// Home Page
		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		hp.clickLogin();

		// Login Page
		LoginPage lp = new LoginPage(driver);

		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLoginButton();

		logger.info("succefully logged in");

		// Account Page
		MyAccountPage maccp = new MyAccountPage(driver);
		boolean myAccountPageExists = maccp.isMyAccountPageExists();
		
		Assert.assertEquals(myAccountPageExists, true, "Login Failed");

		logger.info("***************finished Login Test*************");
		
	}

}
