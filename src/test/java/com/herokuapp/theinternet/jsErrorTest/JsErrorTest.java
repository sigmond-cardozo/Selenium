package com.herokuapp.theinternet.jsErrorTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.JsErrorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Level;

public class JsErrorTest extends TestUtilities {

    @Test
    public void jsErrorTest(){
        SoftAssert softAssert = new SoftAssert();

        WelcomePage welcomePage = new WelcomePage(driver,log);

        welcomePage.openPage();

        JsErrorPage jsErrorPage = welcomePage.clickJsErrorPageLink();

        List<LogEntry> logs=  getBrowserLogs();

        for(LogEntry logEntry:logs){
            if(logEntry.getLevel().equals(Level.SEVERE)) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();
    }

}
