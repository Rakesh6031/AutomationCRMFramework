package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToSelectEnergy {

	public static void main(String[] args) {
		//Launch The Browser
		
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				//Login to the Application with valid credentials
				
				driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.id("submitButton")).click();
				
				//Navigate to Organizational Link
				
				driver.findElement(By.linkText("Organizations")).click();
				
				//Click on Create Organization look up image
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				//Create an  organization with mandatory fields
				Random r=new Random();
				int random=r.nextInt(1000);
				
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Qspider"+random);
				WebElement dropDown = driver.findElement(By.xpath("//select[@name='industry']"));
				WebElement dropDown1 = driver.findElement(By.xpath("//select[@name='accounttype']"));
				Select industry=new Select(dropDown);
				Select type=new Select(dropDown1);
				industry.selectByValue("Energy");
				type.selectByValue("Customer");
				
				//Save and verify
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String organization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(organization.contains("Jspider")) {
					System.out.println(organization+"......TestPassed");
				}else {
					System.out.println(organization+"......TestFailed");
				}
				
				//Logout From Application
				
				WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				Actions action=new Actions(driver);
				
				action.moveToElement(logout).perform();
				
				driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
				
				//Close the Browser
				
				driver.quit();
	}

}
