package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AccountSuccesPage;
import pages.HomePage;

public final class RegisterTest extends BaseTest {

	private RegisterTest() {
	}

	Faker faker = new Faker();

	@Test
	public void registerAccountTest() {

		String password = faker.internet().password();
		new HomePage().myAccountButtonClick().ClickOnRegister().enterFirstName(faker.name().firstName())
				.enterLastName(faker.name().lastName()).enterEmailAddress(faker.internet().emailAddress())
				.enterPhoneNumber(faker.phoneNumber().cellPhone()).enterPassWord(password)
				.enterConfirmPassWord(password).privacyPolicyCheckBox().continueButton();

		Assertions.assertThat(new AccountSuccesPage().verifyAccountCreationMessage())
				.isEqualTo("Your Account Has Been Created!");
	}
}
