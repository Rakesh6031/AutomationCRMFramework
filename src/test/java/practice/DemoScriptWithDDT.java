package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScriptWithDDT {

	public static void main(String[] args) throws IOException {
		
		//To Read Data from Property file
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop=new Properties();
		prop.load(pfis);
		String BROWSER=prop.getProperty("browser");
		String URL=prop.getProperty("url");
		String PASSWORD=prop.getProperty("password");
		String USERNAME=prop.getProperty("username");
		
		//To Read Data from Excel file
		FileInputStream efis=new FileInputStream(".\\src\\test\\resources\\vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		String LASTNAME = wb.getSheet("contacts").getRow(1).getCell(2).toString();
		
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
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
				
				Actions action=new Actions(driver);
				
				action.moveToElement(logout).perform();
				
				driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
				
				//Close the Browser
				
				driver.quit();

		
		
	}

}
