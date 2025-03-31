package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class CreateContactsPage {
	
	//Constructor
	
		public CreateContactsPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//input[@name='lastname']")
		private WebElement lastNameTextFields;
		
		@FindBy(xpath="//input[@class='crmButton small save']")
		private WebElement saveButton;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
		private WebElement clickingOnIconLink;

		public WebElement getClickingOnIconLink() {
			return clickingOnIconLink;
		}

		public WebElement getLastNameTextFields() {
			return lastNameTextFields;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		

}
