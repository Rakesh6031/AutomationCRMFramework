package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class contains all the methods related to Webdriver
 * 
 * @author Rakesh
 */

public class WebDriverUtility {
	/**
	 * This method is used to maximize the Browser
	 * 
	 * @param driver
	 */

	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This methos is used to delete All cookies provided driver
	 * 
	 * @param driver
	 */
	public void toDeleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	/**
	 * This method is used to minimize the Browser
	 * 
	 * @param driver
	 */

	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to Wait until the element is loaded in given time
	 * duartion provide driver
	 * 
	 * @param driver
	 */
	public void toImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method is used to wait until the element is clickable provided driver
	 * and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toWaitUntilElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method i used wait until the element is visible provided driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toWaitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to handle dropdown using index provided element and index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to handle dropdown using value provided element and value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle dropdown using visible text provided element
	 * and text
	 * 
	 * @param text
	 * @param element
	 */
	public void toHandleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This method is use to perform mouse hover action provided driver and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This methos is used to perform right click provided driver and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method is used to perform double click provided webdriver and webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * This method is use to perform drag and drop provided Webdriver and WebElement
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}

	/**
	 * This method is used to handle frame using driver and index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to handle frame using driver and name_id
	 * 
	 * @param driver
	 * @param name_id
	 */
	public void toHandleFrame(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}

	/**
	 * This method is used to handle frame using driver and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to come back from frame to main page using driver
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to handle alert popup by accept using webdriver
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to handle alert popup by dismissing using webdriver
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to capture text in alert popup and accept it provided
	 * driver
	 * 
	 * @param driver
	 * @return
	 */
	public String toSwitchToAlertAndCaptureMesssage(WebDriver driver) {
		Alert alertPopUp = driver.switchTo().alert();
		String message = alertPopUp.getText();
		alertPopUp.accept();
		return message;
	}

	/**
	 * This method is used to take screenshot of an entire webpage provided driver
	 * and screenshotname
	 * 
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public String toTakeSCreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/" + screenshotname + ".png");
		FileHandler.copy(temp, src);
		String path = src.getAbsolutePath();
		return path;
	}

	/**
	 * This method is used to transfer driver control to window provided driver and
	 * partialTitle
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void toSwitchWindow(WebDriver driver, String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();

		for (String id : allIds) {
			String title = driver.switchTo().window(id).getTitle();

			if (title.contains(partialTitle)) {
				break;
			}
		}
	}

}
