package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class AnotherWindowPage {
	
		public AnotherWindowPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//td[@class='moduleName']")
		private WebElement Header;
		
		@FindBy(xpath="//a[@id='1']")
		private WebElement organizationLinkClick;

		public WebElement getOrganizationLinkClick() {
			return organizationLinkClick;
		}

		public WebElement getHeader() {
			return Header;
		}

	

}
