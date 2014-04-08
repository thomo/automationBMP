package de.telekom.bmp.tests.tcs_04_loginAndRegistration;

import static de.telekom.testframework.Actions.click;
import static de.telekom.testframework.Actions.navigateTo;
import static de.telekom.testframework.Actions.set;
import static de.telekom.testframework.Assert.assertThat;
import static de.telekom.testframework.Assert.verifyThat;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import de.telekom.bmp.BmpApplication;
import de.telekom.bmp.data.Datapool;
import de.telekom.bmp.data.User;
import de.telekom.bmp.functional.AccountHandling;
import de.telekom.bmp.functional.GoogleMailAccount;
import de.telekom.bmp.pages.ForgotPasswordPage;
import de.telekom.bmp.pages.Home;
import de.telekom.bmp.pages.Login;
import de.telekom.bmp.pages.ResetPasswordPage;
import de.telekom.testframework.annotations.QCId;
import de.telekom.testframework.selenium.Browser;
import de.telekom.testframework.selenium.annotations.UseWebDriver;

/**
 * 
 * @author Mathias Herkt
 */

@UseWebDriver
@QCId("3566")
public class TC10_Login_forgotten {
	private static final String HTACCESS_CREDENTIALS = "toon:HullyGully";

	private static final String APP_DOMAIN = "testcloud.bmptest.de";

	private static final String MAIL_PREFIX = "mybmptestuser";

	@Inject
	Browser browser;

	@Inject
	BmpApplication app;

	@Inject
	Datapool db;

	@Inject
	AccountHandling accHandling;

	@Inject
	Login login;

	@Inject
	GoogleMailAccount mailAccount;

	@Inject
	ForgotPasswordPage forgotPwPage;

	@Inject
	ResetPasswordPage resetPwPage;

	@Inject
	Home homePage;

	private User user;

	@BeforeTest
	public void setup() {
		user = User.createUser(MAIL_PREFIX);
		assertThat("User must not be null", user != null);

		try {
			accHandling.registerAccount(user);
		} catch (InterruptedException ex) {
			Logger.getLogger(TC10_Login_forgotten.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		navigateTo(login);
	}

	@AfterTest
	public void tearDown() {
	}

	@Test
	public void askForPasswordReset() throws InterruptedException {
		click(login.forgotPasswordLnk);

		set(forgotPwPage.email, user.email);
		click(forgotPwPage.sendMailBtn);

		// wait to mail delivery
		Thread.sleep(1000);

		mailAccount.setMailAccount(user.email);

		String setNewPasswordLink = mailAccount
				.checkGoogleMailAccountAndExtractConfirmLink(APP_DOMAIN);

		assertThat(setNewPasswordLink, !setNewPasswordLink.equals(""));
		setNewPasswordLink = addHtaccessCredentials(setNewPasswordLink);

		browser.navigate().to(setNewPasswordLink);

		resetPassword();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			// do nothing
		}
	}

	private String addHtaccessCredentials(String link) {
		return link.replaceFirst("//", "//" + HTACCESS_CREDENTIALS + "@");
	}

	private void resetPassword() {
		if (user.password == null || "".equals(user.password)) {
			user.password = "1234!QAY";
		} else {
			user.password = new StringBuilder(user.password).reverse()
					.toString();
		}

		set(resetPwPage.password, user.password);
		set(resetPwPage.confirmPassword, user.password);
		click(resetPwPage.submitBtn);

		try {
			verifyThat(homePage.feedbackMessage.isDisplayed());
		} catch (NoSuchElementException e) {
			assertThat("Positiv feedback Message isn't shown.", false);
		}
	}
}
