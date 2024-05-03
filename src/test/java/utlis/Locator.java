package utlis;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;

public final class Locator {

	private Locator() {
	}

	public static WebElement xpath(String locator) {

		return DriverFactory.getDriver().findElement(By.xpath(locator));
	}

	public static List<WebElement> listOfXpath(String locator) {

		return DriverFactory.getDriver().findElements(By.xpath(locator));
	}

	public static List<WebElement> listOfCssSelector(String locator) {

		return DriverFactory.getDriver().findElements(By.cssSelector(locator));
	}

	public static WebElement cssSelector(String locator) {

		return DriverFactory.getDriver().findElement(By.cssSelector(locator));
	}

	public static WebElement name(String locator) {

		return DriverFactory.getDriver().findElement(By.name(locator));
	}

	public static WebElement id(String locator) {

		return DriverFactory.getDriver().findElement(By.id(locator));
	}

	public static WebElement linkText(String locator) {

		return DriverFactory.getDriver().findElement(By.linkText(locator));
	}

	public static WebElement partialLinkText(String locator) {

		return DriverFactory.getDriver().findElement(By.partialLinkText(locator));
	}
	
	public static void clickXpath(String locator) {
		xpath(locator).click();
	}
	
	public static void clickCssSelctor(String locator) {
		cssSelector(locator).click();
	}
	
	public static void clickName(String locator) {
		name(locator).click();
	}
	
	public static void clickId(String locator) {
		id(locator).click();
	}
	
	public static void clickLinkText(String locator) {
		linkText(locator).click();
	}
	
	public static void clickPartialLinkText(String locator) {
		partialLinkText(locator).click();
	}
	
	public static <T> void sendKeysXpath(String locator,T value) {
		xpath(locator).sendKeys((CharSequence[]) value);
	}
	
	public static <T> void sendKeysCssSelctor(String locator,T value) {
		cssSelector(locator).sendKeys((CharSequence[]) value);
	}
	
	public static <T> void sendKeysName(String locator,T value) {
		name(locator).sendKeys((CharSequence[]) value);
	}
	
	public static <T> void sendKeysId(String locator,T value) {
		id(locator).sendKeys((CharSequence[]) value);
	}
	public static <T> void sendKeysLinkText(String locator,T value) {
		linkText(locator).sendKeys((CharSequence[]) value);
	}
	
	public static <T> void sendKeysPartialLinkText(String locator,T value) {
		partialLinkText(locator).sendKeys((CharSequence[]) value);
	}
	

}
