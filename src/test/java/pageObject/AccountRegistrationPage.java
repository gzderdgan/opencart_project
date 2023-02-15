package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public  AccountRegistrationPage(WebDriver driver) {
		super(driver);
	} 
	
	//Elements
	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtPasswordConfirm;
	
	
	@FindBy(name="agree")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement msgConfirmation;
	
	
	//actions
	
	public void setFirstName(String fname) 
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone) 
	{
		txtTelephone.sendKeys(phone);
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setPasswordConfirm(String pwdConfirm) 
	{
		txtPasswordConfirm.sendKeys(pwdConfirm);
	}
	
	public void clickPolicy() 
	{
		chkPolicy.click();
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg() 
	{
		try 
		{
			return(msgConfirmation.getText());
			
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}
