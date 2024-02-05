package pages;

import org.openqa.selenium.By;

import utlis.ElementUtils;

public class LoginSuccessPage {

	
	By verifyMyAccount = By.cssSelector("h2:nth-child(1)");
	
	
	public String verifyMyaccount() {
		return ElementUtils.getLocatorText(verifyMyAccount);
	}

}
