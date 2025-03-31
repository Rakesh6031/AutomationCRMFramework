package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactsPage;
import objectRepository.HomePage;

@Listeners(genericUtility.ListenersImplementations.class)
public class ToCreateContactTest extends BaseClass {
	
	
	@Test(groups = "smoke")
	public void toCreateContact__001() throws EncryptedDocumentException, IOException {
		
		HomePage hpage = new HomePage(driver);
		hpage.getContactLink().click();
		ContactsPage cpage=new ContactsPage(driver);
		cpage.getCreateContactsLink().click();
		CreateContactsPage ccpage=new CreateContactsPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);
		ccpage.getLastNameTextFields().sendKeys(LASTNAME);
		ccpage.getSaveButton().click();
		
		// Intensely failing to see itestlistener implementation and see in errorShots folder
		
		//Assert.fail();
		ContactsInfoPage cipage=new ContactsInfoPage(driver);
		String name = cipage.getHeaderVerificationLink().getText();
		Assert.assertTrue(name.contains(LASTNAME));
		
	}

}
