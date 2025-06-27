package com.herokuapp.theinternet.loginpagetests;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);

		welcomePage.openPage();

		takeScreenshot("welcomePg");

		// Click on Form Authentication link
		LoginPage loginPage= welcomePage.clickFormAuthenticationLink();

		Cookie ck = new Cookie("username", "tomsmith","the-internet.herokuapp.com","/",null);
		loginPage.setCookie(ck);


		// enter username and password
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith","SuperSecretPassword!");


		String username = secureAreaPage.getCookie("username");
		log.info("Cookie username"+username);

		String session = secureAreaPage.getCookie("rack.session");
		log.info("Cookie username"+session);

		// push log in button
		// verifications
		// new url
		loginPage.waitForSecurePage();
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
