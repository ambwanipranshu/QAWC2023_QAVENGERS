package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//rahulonlinetutor@gmail.com
public class LoginPage2 {

	
	public WebDriver driver;
	
	//By email=By.cssSelector("[id='user_email']");
	//By password=By.cssSelector("[type='password']");
	//By login=By.cssSelector("[value='Log In']");
	//By forgotPassword = By.cssSelector("[href*='password/new']");
	
	@FindBy(css="[type='password']")
	WebElement email;
	
	@FindBy(css="[value='Log In']")
	WebElement login;
	
	@FindBy(css="[type='password']")
	WebElement password;
	
	@FindBy(css="[href*='password/new']")
	WebElement forgotPassword;
	
	
	
	public LoginPage2(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void setemail()
	{
		email.sendKeys("abhay");
	}



	
	
	
}
