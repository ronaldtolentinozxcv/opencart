package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePage;



public class HomePage extends BasePage {
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	//Elements
	@FindBy(xpath="//span[text()='My Account']")
	WebElement btn_myaccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement btn_register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement btn_login;
	
	
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	WebElement btn_desktop;
	
	//Actions
	public  void clickMyAccount(){
		btn_myaccount.click();
	}
	
	public void clickRegister(){
		btn_register.click();
	}
	
	public void clickDesktop(){
		btn_desktop.click();
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	
}

