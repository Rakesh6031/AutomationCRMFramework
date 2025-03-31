package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class DemoScriptWithgenericUtilityAndDDT {

	public static void main(String[] args) throws IOException {
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//To Read Data from Property file
		
		String BROWSER=putil.toReadDataFromUtilityFile("browser");
		String URL=putil.toReadDataFromUtilityFile("url");
		String PASSWORD=putil.toReadDataFromUtilityFile("password");
		String USERNAME=putil.toReadDataFromUtilityFile("username");
		
		//To Read Data from Excel file
		
		String LASTNAME=eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		
		//Launch browser
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")){
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		// To maximize
		wutil.toMaximize(driver);
		
		// To use implicitly wait
		
		wutil.toImplicitlyWait(driver);
		
		//Login to the Application with valid credentials
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to contacts links
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on create contact look up image
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Create contacts with mandatory fields
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		
		//save and verify
		
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		String lastName=driver.findElement(By.xpath("(//span[@class='dvHeaderText'])[1]")).getText();
		
		if(lastName.contains(LASTNAME)) {
			System.out.println(lastName+ "........Test passed");
		}else {
			System.out.println(lastName+ "........Test Failed");
		}
		
		//Logout from Application
		
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wutil.toMouseHover(driver, logout);
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		
		//Close the Browser
		
		driver.quit();
		
		
	}

}
