package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class HomePage {
	
	//Constructor
	
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement contactLink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement logoutLink;
		
		@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
		private WebElement organizationLink;
		
		@FindBy(xpath="//a[normalize-space()='Sign Out']")
		private WebElement signoutLink;

		public WebElement getContactLink() {
			return contactLink;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}

		public WebElement getOrganizationLink() {
			return organizationLink;
		}

		public WebElement getSignoutLink() {
			return signoutLink;
		}
		
		
		

}
