package com.herokuapp.theinternet.iframe;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.IframePage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends TestUtilities {

    @Test
    public void iframeTest() {

        WelcomePage welcomePage = new WelcomePage(driver, log);

        welcomePage.openPage();

        welcomePage.scrollToBottom();

        IframePage iframePage = welcomePage.clickIFrameLink();

        Assert.assertTrue(iframePage.getEditorText().contains("Your content goes here."));

    }
}
