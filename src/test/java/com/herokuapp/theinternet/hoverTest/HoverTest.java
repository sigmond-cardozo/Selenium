package com.herokuapp.theinternet.hoverTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestUtilities {

    @Test
    public void hoverTest(){

        WelcomePage welcomePage = new WelcomePage(driver, log);

        welcomePage.openPage();

        HoverPage hoverPage = welcomePage.clickHoverPageLink();

        hoverPage.hoverOn(2);

        Assert.assertTrue(hoverPage.getCurrentUrl().contains("/users/2"));

    }
}
