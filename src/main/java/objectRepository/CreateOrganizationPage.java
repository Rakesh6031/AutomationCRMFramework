package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class CreateOrganizationPage {
	
	//Constructor
	
		public CreateOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//input[@name='accountname']")
		private WebElement organizationNameTextFields;
		
		@FindBy(xpath="//select[@name='industry']")
		private WebElement industryDropDown;
		
		@FindBy(xpath="//select[@name='accounttype']")
		private WebElement accountTypeDropDown;
		
		@FindBy(xpath="//img[@title='Select']")
		private WebElement createOrganizationLookUpImage;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveLinkButton;

		public WebElement getOrganizationNameTextFields() {
			return organizationNameTextFields;
		}

		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}

		public WebElement getAccountTypeDropDown() {
			return accountTypeDropDown;
		}

		public WebElement getCreateOrganizationLookUpImage() {
			return createOrganizationLookUpImage;
		}

		public WebElement getSaveLinkButton() {
			return saveLinkButton;
		}
		
		

}
