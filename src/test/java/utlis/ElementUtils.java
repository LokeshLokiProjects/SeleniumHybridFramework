package utlis;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import factory.DriverFactory;

public final class ElementUtils {

	private ElementUtils() {
	}

	private static Actions actions = new Actions(DriverFactory.getDriver());

	public static void click(By locator) {

		DriverFactory.getDriver().findElement(locator).click();
	}

	public static void sendKeys(By locator, CharSequence... keysToSend) {

		DriverFactory.getDriver().findElement(locator).clear();
		DriverFactory.getDriver().findElement(locator).sendKeys(keysToSend);
	}

	public static String getText(By locator) {

		return DriverFactory.getDriver().findElement(locator).getText();
	}

	public static String getPageTitle() {
		return DriverFactory.getDriver().getTitle();
	}

	public static void scrollToView(By locator) {
		WebElement element = DriverFactory.getDriver().findElement(locator);
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void moveToElement(By locator) {
		WebElement element = DriverFactory.getDriver().findElement(locator);
		actions.moveToElement(element).perform();
	}

	public static void dragAndDrop(By source, By target) {
		WebElement sourceElement = DriverFactory.getDriver().findElement(source);
		WebElement targetElement = DriverFactory.getDriver().findElement(source);
		actions.dragAndDrop(sourceElement, targetElement);
	}

	public static void switchToFrameByWebelement(By locator) {
		WebElement frameElement = DriverFactory.getDriver().findElement(locator);
		DriverFactory.getDriver().switchTo().frame(frameElement);
	}

	public static void switchToFrameByNameOrId(String nameOrId) {
		DriverFactory.getDriver().switchTo().frame(nameOrId);
	}

	public static void switchToFrameByIndex(int index) {
		DriverFactory.getDriver().switchTo().frame(index);
	}

	public static void switchToParentFrame() {
		DriverFactory.getDriver().switchTo().parentFrame();
	}

	public static void switchToMainFrame() {
		DriverFactory.getDriver().switchTo().defaultContent();
	}

	public static void switchToWindow(int index) {
		Set<String> windowhandles = DriverFactory.getDriver().getWindowHandles();
		List<String> windows = new ArrayList<>(windowhandles);
		DriverFactory.getDriver().switchTo().window(windows.get(index));
	}

	public static void selectDropDownByValue(By dropDownLocator, String valueAtrribute) {
		WebElement element = DriverFactory.getDriver().findElement(dropDownLocator);
		new Select(element).selectByValue(valueAtrribute);

	}

	public static void selectDropDownByIndex(By dropDownLocator, int index) {
		WebElement element = DriverFactory.getDriver().findElement(dropDownLocator);
		new Select(element).selectByIndex(index);

	}

	public static void selectDropDownByText(By dropDownLocator, String text) {
		WebElement element = DriverFactory.getDriver().findElement(dropDownLocator);
		new Select(element).selectByVisibleText(text);

	}

	public static void getShadowRoot(By csslocator) {
		DriverFactory.getDriver().findElement(csslocator).getShadowRoot();

	}

	public static void autoDropDownClick(By locators, String value) {
		List<WebElement> webelementlist = DriverFactory.getDriver().findElements(locators);
		for (WebElement element : webelementlist) {
			if (element.getText().equals(value)) {
				element.click();
			}
		}
	}

	public static String autoDropDownGetText(By locators, String value) {
		List<WebElement> webelementlist = DriverFactory.getDriver().findElements(locators);
		String result = null;
		for (WebElement element : webelementlist) {
			if (element.getText().equals(value)) {
				result = element.getText();
			}
		}

		return result;
	}

	public static void alertAccept() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.accept();
	}

	public static void alertDismiss() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.dismiss();
	}

	public static void alertSendKeys(String value) {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.sendKeys(value);
	}

	public static String alertGetText() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		return alert.getText();
	}

	public static void uploadFile(By loactor, File filePath) {
		DriverFactory.getDriver().findElement(loactor).sendKeys((CharSequence) filePath.getAbsoluteFile());
	}
	
	public static void downloadFile() {
		ChromeOptions chromeOptions = new ChromeOptions();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("download.prompt_for_download", false);
		chromeOptions.setExperimentalOption("prefs", hashMap);
	}

}