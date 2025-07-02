package com.herokuapp.theinternet.fileUploadTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploadPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int i,String fileName){

        log.info("(Thread ID:" + Thread.currentThread().getId());
        WelcomePage welcomePage = new WelcomePage(driver,log);

        welcomePage.openPage();

        FileUploadPage fileUploadPage = welcomePage.clickFileUploadLink();

        fileUploadPage.selectFile(fileName);

        fileUploadPage.clickUploadBtn();

        Assert.assertEquals(fileUploadPage.confirmFileUpload(),fileName);

    }
}
