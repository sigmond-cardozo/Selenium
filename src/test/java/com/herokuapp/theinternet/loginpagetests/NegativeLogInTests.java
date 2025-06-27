package com.herokuapp.theinternet.loginpagetests;

import base.CsvDataProviders;
import base.TestUtilities;
import com.herokuapp.theinternet.pages.BasePageObject;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLogInTests extends TestUtilities {

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeTest(Map<String, String> testData) {

		// Data
		String no = testData.get("no");
		String username  = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");


		log.info("Starting negativeTest");
		WelcomePage welcomePage = new WelcomePage(driver,log);
		BasePageObject basePageObject = new BasePageObject(driver,log);

		// open main page
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// enter username and password
		loginPage.negativeLogIn(username,password);

		// Verification
		loginPage.waitForErrorMessage();
		String actualErrorMessage = loginPage.getErrorMessageText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}
}
