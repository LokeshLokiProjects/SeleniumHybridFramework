package factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import frameconstans.BrowserType;
import utlis.FrameUtils;

public final class SeleniumGrid {

	private SeleniumGrid() {
	}

	public static void remoteDriver(String browser) throws MalformedURLException {

		if (browser.equalsIgnoreCase(FrameUtils.browserUtils(BrowserType.CHROME))) {
			ChromeOptions co = new ChromeOptions();
			DriverFactory.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), co));
		} else if (browser.equalsIgnoreCase(FrameUtils.browserUtils(BrowserType.FIREFOX))) {
			FirefoxOptions fo = new FirefoxOptions();
			DriverFactory.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), fo));
		} else if (browser.equalsIgnoreCase(FrameUtils.browserUtils(BrowserType.EDGE))) {
			EdgeOptions eo = new EdgeOptions();
			DriverFactory.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), eo));
		} else {
			throw new RuntimeException("######## invalid browser type ######### \n");
		}

	}

}
