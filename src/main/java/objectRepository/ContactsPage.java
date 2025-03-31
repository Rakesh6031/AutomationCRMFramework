package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ContactsPage {
	
	//Constructor
	
	
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement createContactsLink;

		public WebElement getCreateContactsLink() {
			return createContactsLink;
		}
		
	

}
