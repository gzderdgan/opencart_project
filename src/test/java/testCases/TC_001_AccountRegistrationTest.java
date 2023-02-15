package testCases;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import pageObject.HomePage;
import pageObject.AccountRegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	{
		//All < Trace < Debug < Info < Warn < Error < Fatal < Off
		logger.info("***************START TC_001_AccountRegistrationTest ************ ");

		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		logger.info("Providing Customer Data");
		AccountRegistrationPage rp=new AccountRegistrationPage(driver);
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");	
		rp.setTelephone(randomNumber());
		String s= randomAlphaNumeric();
		rp.setPassword(s);
		rp.setPasswordConfirm(s);
		rp.clickPolicy();
		rp.clickContinue();
		logger.info("Clicked on Continue");
		
		String confmsg=rp.getConfirmationMsg();

		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","ERROR: not geetting expected message----TEST FAILED");
		logger.info("TEST PASSED");
		
		}
		catch(Exception e) {
			logger.info("TEST FAILED");
			AssertJUnit.fail();
						
		}
		logger.info("***************FINISH TC_001_AccountRegistrationTest ************ ");
	}
	
	
}
