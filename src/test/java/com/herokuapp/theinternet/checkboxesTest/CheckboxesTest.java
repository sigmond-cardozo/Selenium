package com.herokuapp.theinternet.checkboxesTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends TestUtilities {

    @Test
    public void selectCheckboxesTest(){
        WelcomePage welcomePage = new WelcomePage(driver,log);

        welcomePage.openPage();

        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        checkboxesPage.clickCheckboxes();

        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"all are not checked");
    }

}
