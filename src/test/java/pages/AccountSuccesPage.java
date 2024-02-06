package pages;

import org.openqa.selenium.By;

import utlis.ElementUtils;

public class AccountSuccesPage {
	

	private By verifyAccountCreationMessage = By.cssSelector("div[id='content'] h1");
	
	
	public String verifyAccountCreationMessage() {
		return ElementUtils.getLocatorText(verifyAccountCreationMessage);
	}
	
}
