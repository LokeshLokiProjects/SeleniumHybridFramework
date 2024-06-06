package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import frameconstans.ConfigFileKeys;
import utlis.PropUtils;

public class BaseTest {

	protected BaseTest() {
		
	}
	
	@Parameters("browsername")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) {
		DriverFactory.initDriver(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
	
}