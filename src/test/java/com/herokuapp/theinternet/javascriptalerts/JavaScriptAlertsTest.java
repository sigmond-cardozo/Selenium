package com.herokuapp.theinternet.javascriptalerts;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertsTest extends TestUtilities {

    @Test
    public void javascriptAlertTest() {

        WelcomePage welcomePage = new WelcomePage(driver, log);

        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavascriptAlertsLink();

        javaScriptAlertsPage.openJsAlert();

        Assert.assertEquals(javaScriptAlertsPage.getAlertText(),"I am a JS Alert");
        javaScriptAlertsPage.acceptAlert();

        Assert.assertEquals(javaScriptAlertsPage.getResultText(),"You successfully clicked an alert");
    }

    @Test
    public void javascriptConfirmTestAccept(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavascriptAlertsLink();
        javaScriptAlertsPage.openJsConfirm();

        Assert.assertEquals(javaScriptAlertsPage.getAlertText(),"I am a JS Confirm");

        javaScriptAlertsPage.acceptAlert();

        Assert.assertEquals(javaScriptAlertsPage.getResultText(),"You clicked: Ok");
    }

    @Test
    public void javascriptConfirmTestDecline(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavascriptAlertsLink();
        javaScriptAlertsPage.openJsConfirm();

        Assert.assertEquals(javaScriptAlertsPage.getAlertText(),"I am a JS Confirm");

        javaScriptAlertsPage.dismissAlert();

        Assert.assertEquals(javaScriptAlertsPage.getResultText(),"You clicked: Cancel");
    }

    @Test
    @Parameters ("alertText")
    public void javascriptPromptTestAccept(String alertText){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        SoftAssert softAssert = new SoftAssert();
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavascriptAlertsLink();

        javaScriptAlertsPage.openJsPrompt();

        softAssert.assertEquals(javaScriptAlertsPage.getAlertText(),"I am a JS prompt");

        javaScriptAlertsPage.enterAlertText(alertText);
        javaScriptAlertsPage.acceptAlert();

        softAssert.assertEquals(javaScriptAlertsPage.getResultText(),"You entered: "+alertText);

        softAssert.assertAll();
    }

    @Test
    public void javascriptPromptTestDismiss(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavascriptAlertsLink();

        javaScriptAlertsPage.openJsPrompt();

        Assert.assertEquals(javaScriptAlertsPage.getAlertText(),"I am a JS prompt");

        javaScriptAlertsPage.dismissAlert();

        Assert.assertEquals(javaScriptAlertsPage.getResultText(),"You entered: null");
    }
}
