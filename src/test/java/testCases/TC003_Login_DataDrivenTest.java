package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC003_Login_DataDrivenTest extends BaseClass {
	@Test (dataProvider="LoginData", dataProviderClass=utilities.DataProviders.class, groups="DataDriven")
	public void loginDDT(String email, String pwd, String expected)
	{
		//Homepage
		HomePage homepage=new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickLogin();
		
		//Loginpage
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setEmail(email);
		loginpage.setPassword(pwd);
		loginpage.clickLogin();
		
		
		//My accountpage
		MyAccountPage myaccount=new MyAccountPage(driver);
		boolean status=myaccount.isMyAccountExist();
		
		if(expected.equalsIgnoreCase("Valid"))
		{
			if(status==true)
			{
				myaccount.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		
		if (expected.equalsIgnoreCase("Invalid"))
		{
			if(status==true)
			{
				myaccount.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
	}

}
