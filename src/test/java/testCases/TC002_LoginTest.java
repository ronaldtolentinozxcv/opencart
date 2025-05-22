package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test (groups= {"Regression", "Master"})
	public void login() throws InterruptedException {
		
		
		//Homepage
		
		HomePage homepage=new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickLogin();
		
		//Loginpage
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setEmail(p.getProperty("email"));
		loginpage.setPassword(p.getProperty("password"));
		loginpage.clickLogin();
		
		
		//My accountpage
		MyAccountPage myaccount=new MyAccountPage(driver);
//		boolean status=myaccount.isMyAccountExist();
//		Assert.assertTrue(status);
		
		
		myaccount.clickLogout();
		
		
		
		
		
		
	}
	

}
