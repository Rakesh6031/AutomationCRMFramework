package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class ContactsInfoPage {
	
	//Constructor
	
		public ContactsInfoPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement headerVerificationLink;

		public WebElement getHeaderVerificationLink() {
			return headerVerificationLink;
		}

}
