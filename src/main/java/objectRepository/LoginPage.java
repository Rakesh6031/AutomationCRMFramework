package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class LoginPage {
	
	//Constructor
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernameTextFields;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@name='user_password']")})
	private WebElement passwordTextFields;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginButton;

	public WebElement getUsernameTextFields() {
		return usernameTextFields;
	}

	public WebElement getPasswordTextFields() {
		return passwordTextFields;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	

}
