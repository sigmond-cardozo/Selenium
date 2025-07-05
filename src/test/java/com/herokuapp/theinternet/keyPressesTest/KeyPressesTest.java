package com.herokuapp.theinternet.keyPressesTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTest extends TestUtilities {

    @Test
    public void keyPressesTest(){

        WelcomePage welcomePage = new WelcomePage(driver,log);

        welcomePage.openPage();

        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        keyPressesPage.clickKeyUsingLocator(Keys.ARROW_UP);

        Assert.assertTrue(keyPressesPage.getResultText().equals("You entered: UP"));

    }

    @Test
    public void keyPressesTestWithAction(){

        WelcomePage welcomePage = new WelcomePage(driver,log);

        welcomePage.openPage();

        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        keyPressesPage.clickKeysUsingAction(Keys.NUMPAD6);

        Assert.assertTrue(keyPressesPage.getResultText().equals("You entered: NUMPAD6"));

    }
}
