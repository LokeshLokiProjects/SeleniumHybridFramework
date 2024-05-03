package utlis;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.DriverFactory;

public final class ScreenShotUtils {
	
	private ScreenShotUtils() {}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
