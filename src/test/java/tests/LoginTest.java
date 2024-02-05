package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.LoginSuccessPage;

public class LoginTest extends BaseTest {

	@Test
	public void validIdValidPassword() {
		new HomePage().myAccountButtonClick().ClickOnLoginOption().enterEmailId("lokesha2@yopmail.com")
				.enterPassWord("Lok999@#/").clickOnLoginButton();
		Assertions.assertThat(new LoginSuccessPage().verifyMyaccount()).isEqualTo("My Account");
	}

	@Test
	public void invalidIdValidPassword() {
		new HomePage().myAccountButtonClick().ClickOnLoginOption().enterEmailId("lokesha2xaaasx@yopmail.com")
				.enterPassWord("Lok999@#/").clickOnLoginButton();

		Assertions.assertThat(new LoginPage().verifyWarrningMessage())
				.isEqualTo("Warning: No match for E-Mail Address and/or Password.");
	}

	@Test
	public void invalidIdValidPassword2() {
		new HomePage().myAccountButtonClick().ClickOnLoginOption().enterEmailId("lokesha2xsaaax@yopmail.com")
				.enterPassWord("Lok999@#/").clickOnLoginButton();

		Assertions.assertThat(new LoginPage().verifyWarrningMessage())
				.isEqualTo("Warning: No match for E-Mail Address and/or Password.");
	}

	@Test
	public void invalidIdValidPassword3() {
		new HomePage().myAccountButtonClick().ClickOnLoginOption().enterEmailId("lokesha2xsaaax@yopmail.com")
				.enterPassWord("Lok999@#/").clickOnLoginButton();

		Assertions.assertThat(new LoginPage().verifyWarrningMessage())
				.isEqualTo("Warning: No match for E-Mail Address and/or Password.");
	}

	@Test
	public void validIdInvalidPassword() {
		new HomePage().myAccountButtonClick().ClickOnLoginOption().enterEmailId("lokesha2@yopmail.com")
				.enterPassWord("Lok999@#/xsxs").clickOnLoginButton();

		Assertions.assertThat(new LoginPage().verifyWarrningMessage())
				.isEqualTo("Warning: No match for E-Mail Address and/or Password.");
	}

}
