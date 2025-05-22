package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//h2[normalize-space()='My Account']")
	WebElement myaccount_heading;
	
	@FindBy (xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout;
	
	
	@FindBy (xpath="//a[normalize-space()='Edit Account']")
	WebElement btn_editaccount;
	
	
	
	
	
	public boolean isMyAccountExist()
	{
		try 
		{
		return myaccount_heading.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		
		btn_logout.click();
	}
	
	public void clickEditAccount()
	{
		btn_editaccount.click();
	}
	

}
