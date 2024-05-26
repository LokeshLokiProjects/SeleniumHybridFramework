package pages;

import org.openqa.selenium.By;

import utlis.ElementUtils;

public class RegisterPage {

	
	
	
	private By enterFirstName = By.cssSelector("#input-firstname");
	private By enterLastName = By.cssSelector("#input-lastname");
	private By enterEmailAddress = By.cssSelector("#input-email");
	private By enterPhoneNumber = By.cssSelector("#input-telephone");
	private By enterPassWord = By.cssSelector("#input-password");
	private By enterConfirmPassoWord = By.cssSelector("#input-confirm");
//	private By subscribeYesCheckBox = By.cssSelector("input[value='1'][name='newsletter']");
//	private By subscribeNoCheckBox = By.cssSelector("input[value='0']");
	private By privacyPolicyCheckBox = By.cssSelector("input[value='1'][name='agree']");
	private By continueButton = By.cssSelector("input[value='Continue']");
	
	
	public RegisterPage enterFirstName(String value) {
		ElementUtils.sendKeys(enterFirstName, value);
		return this;
	}
	
	public RegisterPage enterLastName(String value) {
		ElementUtils.sendKeys(enterLastName, value);
		return this;
	}
	public RegisterPage enterEmailAddress(String value) {
		ElementUtils.sendKeys(enterEmailAddress, value);
		return this;
	}
	public RegisterPage enterPhoneNumber(String value) {
		ElementUtils.sendKeys(enterPhoneNumber, value);
		return this;
	}
	public RegisterPage enterPassWord(String value) {
		ElementUtils.sendKeys(enterPassWord, value);
		return this;
	}
	public RegisterPage enterConfirmPassWord(String value) {
		ElementUtils.sendKeys(enterConfirmPassoWord, value);
		return this;
	}
	public RegisterPage privacyPolicyCheckBox() {
		ElementUtils.click(privacyPolicyCheckBox);
		return this;
	}
	public void continueButton() {
		ElementUtils.click(continueButton);
	}

}
