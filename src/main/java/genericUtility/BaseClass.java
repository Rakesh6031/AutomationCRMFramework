package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	PropertyFileUtility putil=new PropertyFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver; // For Listeners we are using this
	
	@BeforeSuite(groups = {"smoke","Regression"})
	public void beforeSuiteConfiguration() {
		Reporter.log("Database connection established", true);
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"smoke","Regression"})
	public void beforeClassConfiguration(/*String BROWSER*/) throws IOException {
		String BROWSER=putil.toReadDataFromUtilityFile("browser");
		String URL=putil.toReadDataFromUtilityFile("url");
		
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		sdriver=driver; // For Listeners we are using this
		driver.get(URL);
		wutil.toMaximize(driver);
		wutil.toImplicitlyWait(driver);
		wutil.toDeleteAllCookies(driver);
		
	
	}
	@BeforeMethod(groups = {"smoke","Regression"})
	public void beforeMethodConfiguration() throws IOException {
		String USERNAME = putil.toReadDataFromUtilityFile("username");
		String PASSWORD = putil.toReadDataFromUtilityFile("password");
		
		LoginPage lpage= new LoginPage(driver);
		lpage.getUsernameTextFields().sendKeys(USERNAME);
		lpage.getPasswordTextFields().sendKeys(PASSWORD);
		lpage.getLoginButton().click();
		Reporter.log("WebDriver initialized: " + (driver != null ? "Yes" : "No"));

	}
	
	@AfterMethod(groups = {"smoke","Regression"})
	public void afterMethodConfiguartion() {
		HomePage hpage=new HomePage(driver);
		wutil.toMouseHover(driver, hpage.getLogoutLink());
		hpage.getSignoutLink().click();
		
	}
	
	@AfterClass(groups = {"smoke","Regression"})
	public void afterClassConfiguation() {
		//driver.quit();
		if (driver != null) {
            driver.quit();  // Proper cleanup of WebDriver
        }
	}
	
	@AfterSuite(groups = {"smoke","Regression"})
	public void afterSuiteConfiguation() {
		
		Reporter.log("Database connection disconnect", true);
	}
		
		
		
	

}
