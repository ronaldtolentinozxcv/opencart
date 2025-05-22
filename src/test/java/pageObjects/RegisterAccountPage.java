package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage {

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_confirmpwd;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btn_agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement AccountHasBeenCreated;
	
	
	
	
	
	
	
	//Actions
	
	public void setFirstname(String name)
	{
		txt_firstname.sendKeys(name);
	}
	
	public void setLastname(String lastname) 
	{
		txt_lastname.sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txt_telephone.sendKeys(tel);
	}
	
	
	public void setPassword(String pwd) 
	{
		txt_pwd.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String conpwd) 
	{
		txt_confirmpwd.sendKeys(conpwd);
	}
	
	
	
	public void clickAgree()
	{
		//btn_agree.click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_agree);
	}
	
	public void clickContinue()
	{
		//btn_continue.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_continue);
	}
	
	public String registerAccountMessage()
	{
		return AccountHasBeenCreated.getText();
		 
		
	}
	
	
	
	

}
