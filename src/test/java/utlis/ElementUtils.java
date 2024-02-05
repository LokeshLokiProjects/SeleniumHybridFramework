package utlis;

import org.openqa.selenium.By;

import driverfactory.DriverFactory;

public class ElementUtils {

	public static void click(By by) {
	
		DriverFactory.getDriver().findElement(by).click();
	}

	public static void sendKeys(By by, String value) {
		
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(value);
	}

	public static String getLocatorText(By by) {
		
		return DriverFactory.getDriver().findElement(by).getText();
	}
	
	
//	private static void explictWaitForElementToBeVisible(By by) {
//		new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameConstants.getWebdriverwait()))
//		.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}
//	
//	private static void explictWaitForElementToBePresent(By by) {
//		new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameConstants.getWebdriverwait()))
//		.until(ExpectedConditions.presenceOfElementLocated(by));
//	}
//	
//	private static void explictWaitForElementToBeClickable(By by) {
//		new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameConstants.getWebdriverwait()))
//		.until(ExpectedConditions.elementToBeClickable(by));
//	}

}
