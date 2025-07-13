package com.herokuapp.theinternet.dropdownTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends TestUtilities {
    @Test
    public void dropdownTest() {
        WelcomePage welcomePage = new WelcomePage(driver, log);

        welcomePage.openPage();
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        dropdownPage.selectOption(2);

        Assert.assertEquals(dropdownPage.getSelectedOption(),"Option 2");

    }
}
