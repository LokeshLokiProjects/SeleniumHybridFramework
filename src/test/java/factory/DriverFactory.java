package factory;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;

import frameconstans.BrowserType;
import frameconstans.ConfigFileKeys;
import frameconstans.FrameConstants;
import utlis.FrameUtils;
import utlis.PropUtils;

public final class DriverFactory {

	private DriverFactory() {

	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverref) {
		driver.set(driverref);
	}

	public static void removeDriver() {
		driver.remove();
	}

	public static void initDriver(String browserName) {

		if (PropUtils.getKey(ConfigFileKeys.REMOTEDRIVER).equalsIgnoreCase("no") && Objects.isNull(getDriver())) {
			if (browserName.equalsIgnoreCase(FrameUtils.browserUtils(BrowserType.CHROME)))
				setDriver(ThreadGuard.protect(new ChromeDriver()));
			else if (browserName.equalsIgnoreCase(FrameUtils.browserUtils(BrowserType.FIREFOX)))
				setDriver(ThreadGuard.protect(new FirefoxDriver()));
			else if (browserName.equalsIgnoreCase(FrameUtils.browserUtils(BrowserType.EDGE)))
				setDriver(ThreadGuard.protect(new EdgeDriver()));
			else throw new RuntimeException("########### invalid browser type ############ \n");
		} else if (PropUtils.getKey(ConfigFileKeys.REMOTEDRIVER).equalsIgnoreCase("yes") && Objects.isNull(getDriver())) {
			try {
				SeleniumGrid.remoteDriver(browserName);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		getDriver().get(PropUtils.getKey(ConfigFileKeys.URL));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameConstants.IMPLICTWAIT.getIntValue()));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameConstants.PAGELOADTIME.getIntValue()));

	}

	public static void quitDriver() {
		if (Objects.nonNull(getDriver())) {
			getDriver().quit();
			removeDriver();
		}
	}

}
