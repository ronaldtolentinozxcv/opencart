package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@Parameters({"os","browser"})
	@BeforeClass (groups= {"Regression", "Master", "Sanity", "DataDrive"})
	public void setup(String os, String br) throws IOException {
		
		logger = LogManager.getLogger(this.getClass()); //for logs
		
		//for getting the data from config.properties
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//for running tests on different environment
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("Windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("Mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("Linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching operating system");
				return;
			}
				
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("Firefox"); break;
			default: System.out.println("No matching browser");
			}
			driver=new RemoteWebDriver(new URL("http://192.168.100.44:4444/wd/hub"), capabilities);
			
			
			//for running tests on local	
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default: System.out.print("Invalid Browser"); return;
			}
		}
		
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL2"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		
		
		
	}
	@AfterClass (groups= {"Regression", "Master", "Sanity", "DataDrive"})
	public void teardown() throws InterruptedException {
	Thread.sleep(2000);
	driver.quit();
	}	
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String tagetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp +".png";
		File tagetFile=new File(tagetFilePath);
		sourceFile.renameTo(tagetFile);
		return tagetFilePath;
				
		
		
	}


}
