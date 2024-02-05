package driverfactory;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;

import frameconstans.FrameConstants;
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
		
		if(Objects.isNull(getDriver())) {
		if(browserName.equalsIgnoreCase("chrome")) setDriver(ThreadGuard.protect(new ChromeDriver()));
		else if(browserName.equalsIgnoreCase("firefox")) setDriver(ThreadGuard.protect(new FirefoxDriver()));
		else if(browserName.equalsIgnoreCase("edge")) setDriver(ThreadGuard.protect(new EdgeDriver()));
		getDriver().get(PropUtils.getKey("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameConstants.getImplictwait()));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameConstants.getPageloadtime()));
		}
	
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(getDriver())) {
		getDriver().quit();
		removeDriver();
		}
	}

}
