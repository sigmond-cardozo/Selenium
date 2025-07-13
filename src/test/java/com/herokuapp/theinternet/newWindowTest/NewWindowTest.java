package com.herokuapp.theinternet.newWindowTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowAfterClick;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWindowTest extends TestUtilities {

    @Test
    public void newWindowTest(){

        WelcomePage welcomePage = new WelcomePage(driver,log);

        welcomePage.openPage();

        NewWindowPage newWindowPage = welcomePage.clickMultipleWindowsLink();

        newWindowPage.clickNewWindowBtn();

        NewWindowAfterClick newWindowAfterClick = newWindowPage.switchToNewWindowPage();

        Assert.assertTrue( driver.getPageSource().contains("New Window"));
    }
}
