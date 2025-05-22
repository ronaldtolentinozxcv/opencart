package testCases;

import org.apache.commons.lang3.RandomStringUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;
import java.util.logging.LogManager;

public class TC001_ValidateRegistration  extends BaseClass {
	

	
	
	@Test (groups= {"Regression", "Master", "Sanity"})
	public void register() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		
		LogManager.getLogManager().reset(); // disable default JUL handlers
		org.apache.logging.log4j.jul.LogManager.getLogManager(); // enable Log4j2 bridge
		logger.info("Initializing test");
		
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Creating account");
		logger.debug("This is a debug message - should appear in automation.log");
		RegisterAccountPage register=new RegisterAccountPage(driver);
		register.setFirstname(randomString());
		register.setLastname(randomString());
		register.setEmail("test_"+randomString()+"@gmail.com");
		register.setTelephone(randomNumber());
		
		
		String pwd=randomString();
		
		register.setPassword("test_"+pwd);
		register.setConfirmPassword("test_"+pwd);
		register.clickAgree();
		register.clickContinue();
		
		if(register.registerAccountMessage().equals("Your Account Has Been Created!"))
	
		{
			Assert.assertTrue(true);
			logger.info("Test Passed");
		}
		else 
		{
			Assert.assertTrue(false);
			logger.info("Test failed");
		}
		
		
		
	
		
	
		
		
		
	}
	
	public String randomString() 
	{
		return RandomStringUtils.randomAlphabetic(5);
		
					
	}
	
	
	public String randomNumber() 
	{
		return RandomStringUtils.randomNumeric(7);
		
					
	}
	
	
		
	
	


}
