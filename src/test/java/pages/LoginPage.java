package pages;

import org.openqa.selenium.By;

import utlis.ElementUtils;

public final class LoginPage {
	

	private By enterEmailId = By.cssSelector("#input-email");
	private By enterPassWord = By.cssSelector("#input-password");
	private By clickOnLoginButton = By.cssSelector("input[value='Login']");
	private By verifyWarrningMessage = By.cssSelector(".alert.alert-danger.alert-dismissible");
	
	public LoginPage enterEmailId(String value) {
		ElementUtils.sendKeys(enterEmailId, value);
		return this;
	}
	public LoginPage enterPassWord(String value) {
		ElementUtils.sendKeys(enterPassWord, value);
		return this;
	}
	public void clickOnLoginButton() {
		ElementUtils.click(clickOnLoginButton);

	}
	
	public String verifyWarrningMessage() {
		return ElementUtils.getText(verifyWarrningMessage);
	}

}
