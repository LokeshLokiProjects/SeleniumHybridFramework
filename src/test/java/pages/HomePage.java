package pages;

import org.openqa.selenium.By;

import utlis.ElementUtils;

public class HomePage {

	private By myAccountButton = By.cssSelector("a[title='My Account']");
	private By loginButton = By.cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/login']");
	private By registerButton = By
			.cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/register']");

	public HomePage myAccountButtonClick() {
		ElementUtils.click(myAccountButton);
		return this;
	}

	public LoginPage ClickOnLoginOption() {
		ElementUtils.click(loginButton);
		return new LoginPage();
	}

	public RegisterPage ClickOnRegister() {
		ElementUtils.click(registerButton);
		return new RegisterPage();
	}

}
