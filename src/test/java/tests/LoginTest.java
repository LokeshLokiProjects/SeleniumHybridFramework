package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.LoginSuccessPage;

public final class LoginTest extends BaseTest {
	
	private LoginTest() {}
	
	Faker faker = new Faker();

	@Test
	public void validIdValidPassword() {
		new HomePage().myAccountButtonClick().ClickOnLoginOption().enterEmailId("lokesha2@yopmail.com")
				.enterPassWord("Lok999@#/").clickOnLoginButton();
		Assertions.assertThat(new LoginSuccessPage().verifyMyaccount()).isEqualTo("My Account");
	}

	@Test
	public void invalidIdValidPassword() {
		new HomePage().myAccountButtonClick().ClickOnLoginOption().enterEmailId(faker.internet().emailAddress())
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
