package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;
@Listeners(genericUtility.ListenersImplementations.class)
public class ToCreateOrgWithIndustryTest extends BaseClass {
	
	@Test(groups = "Regression")
	public void toCreateOrgWithIndustry__003() throws EncryptedDocumentException, IOException {
		HomePage hpage=new HomePage(driver);
		hpage.getOrganizationLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationLink().click();
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		JavaUtility ju=new JavaUtility();
		String random = ju.randomeNumber();
		ExcelFileUtility eutil=new ExcelFileUtility();
		String org = eutil.toReadDataFromExcelFile("Organization",1,2);
		cop.getOrganizationNameTextFields().sendKeys(org+random);
		WebElement indsutry = cop.getIndustryDropDown();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.toHandleDropdown(indsutry, "Chemicals");
		cop.getSaveLinkButton().click();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String name = oip.getHeaderVerificationLink().getText();
		Assert.assertTrue(name.contains(org));
	}

}
