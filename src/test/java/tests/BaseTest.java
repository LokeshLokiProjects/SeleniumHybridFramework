package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import frameconstans.ConfigFileKeys;
import utlis.PropUtils;

public class BaseTest {

	protected BaseTest() {
		
	}
	
	@BeforeMethod
	public void setUp() {
		DriverFactory.initDriver(PropUtils.getKey(ConfigFileKeys.BROWSERNAME));
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
	
}