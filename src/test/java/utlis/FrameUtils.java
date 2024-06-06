package utlis;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.DriverFactory;
import frameconstans.BrowserType;

public final class FrameUtils {
	
	private FrameUtils() {}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	
	public static String browserUtils(BrowserType browser) {
		
		return browser.toString().toLowerCase();
	}
}
