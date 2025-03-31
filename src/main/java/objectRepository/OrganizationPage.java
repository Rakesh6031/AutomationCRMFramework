package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class OrganizationPage {
	
	//Constructor
	
		public OrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement createOrganizationLink;

		public WebElement getCreateOrganizationLink() {
			return createOrganizationLink;
		}
		
		

}
