package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountLoginPage;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void test_Login() {
		logger.info("*************Starting TC_002_LoginTest*********************");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickLogin();
		logger.info("Clicked on Login Link");
		
		
		AccountLoginPage lp= new AccountLoginPage(driver);
		logger.info("Providing user details");
		
		lp.setEmailAddress(rb.getString("email"));//valid email, get it from config.properties
		lp.setPassword(rb.getString("password"));//valid email, get it from config.properties
		lp.clickLogin();
		logger.info("Clicked on login button");
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
	}catch(Exception e) {
		Assert.fail();
	}
		logger.info("*************Finish TC_002_LoginTest*********************");
}}
