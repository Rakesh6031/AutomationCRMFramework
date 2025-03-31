package demoScriptWithDDTAndGUAndPOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class TC_CreateContacts_001 {

	public static void main(String[] args) throws IOException {
		
		// To Read data from propertyfile
		PropertyFileUtility putil=new PropertyFileUtility();
		
		String URL=putil.toReadDataFromUtilityFile("url");
		String PASSWORD=putil.toReadDataFromUtilityFile("password");
		String USERNAME=putil.toReadDataFromUtilityFile("username");
		String BROWSER=putil.toReadDataFromUtilityFile("browser");
		
		//To Read data from ExcelFile
		ExcelFileUtility eutil=new ExcelFileUtility();
		
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);
		
		//To Read Data from WebDriverUtility File
		WebDriverUtility wutil=new WebDriverUtility();
		
		// Launch Browser
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		//To Maximize
		
		wutil.toMaximize(driver);
		
		//To Implicitly Wait
		
		wutil.toImplicitlyWait(driver);
		
		// Login to the Application with valid Credentials
		
		driver.get(URL);
		LoginPage lpage=new LoginPage(driver);
		lpage.getUsernameTextFields().sendKeys(USERNAME);
		lpage.getPasswordTextFields().sendKeys(PASSWORD);
		lpage.getLoginButton().click();
		
		//HomePage
		HomePage hpage=new HomePage(driver);
		hpage.getContactLink().click();
		
		//ContactsPage
		ContactsPage cpage=new ContactsPage(driver);
		cpage.getCreateContactsLink().click();
		
		//CreateContactsPage
		CreateContactsPage ccpage=new CreateContactsPage(driver);
		ccpage.getLastNameTextFields().sendKeys(LASTNAME);
		ccpage.getSaveButton().click();
		
		//ContactsInfoPage
		ContactsInfoPage cipage=new ContactsInfoPage(driver);
		String lastname= cipage.getHeaderVerificationLink().getText();
		
		if(lastname.contains(LASTNAME)) {
			System.out.println("Test passed......");
		}
		else {
			System.out.println("Test failed......");
		}
		
		//SignOut
		WebElement logoutlink = hpage.getLogoutLink();
		wutil.toMouseHover(driver, logoutlink);
		
		hpage.getSignoutLink().click();
		
        driver.quit();
	}

}
