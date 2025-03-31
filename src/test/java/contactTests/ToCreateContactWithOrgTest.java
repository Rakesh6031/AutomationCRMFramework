package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.AnotherWindowPage;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactsPage;
import objectRepository.HomePage;
@Listeners(genericUtility.ListenersImplementations.class)
public class ToCreateContactWithOrgTest extends BaseClass {
	@Test(groups = "smoke")
	public void ToCreateContactWithOrgTest__005() throws EncryptedDocumentException, IOException {
		HomePage hpage = new HomePage(driver);
		hpage.getContactLink().click();
		ContactsPage cpage=new ContactsPage(driver);
		cpage.getCreateContactsLink().click();
		CreateContactsPage ccpage=new CreateContactsPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);
		ccpage.getLastNameTextFields().sendKeys(LASTNAME);
		ccpage.getClickingOnIconLink().click();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.toSwitchWindow(driver, "Accounts");
		AnotherWindowPage apage = new AnotherWindowPage(driver);
		apage.getOrganizationLinkClick().click();

		wutil.toSwitchWindow(driver, "Contacts");
		ccpage.getSaveButton().click();
		ContactsInfoPage cipage = new ContactsInfoPage(driver);
		String lastname = cipage.getHeaderVerificationLink().getText();

		Assert.assertTrue(lastname.contains(LASTNAME));
	}

}
