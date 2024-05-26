package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import enums.ConfigFileKeys;
import factory.DriverFactory;
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