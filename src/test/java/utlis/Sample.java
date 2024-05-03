package utlis;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Sample {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// driver.findElement(By.cssSelector("#APjFqb")).sendKeys("Yash");
		ElementUtils.sendKeys(By.cssSelector("#APjFqb"), "Yash");
		// driver.findElement(By.cssSelector("#APjFqb")).sendKeys(Keys.RETURN);
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
