package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadPage extends BasePageObject{

    private By chooseFileLocator = By.cssSelector("#file-upload");
    private By chooseUploadBtnLocator = By.cssSelector("#file-submit");
    private By fileUploadedLocator = By.cssSelector("#uploaded-files");

    public FileUploadPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectFile(String fileName){
        String filepath = System.getProperty("user.dir")+"//src//main//resources//"+fileName;
        type(filepath,chooseFileLocator);
    }

    public void clickUploadBtn(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        click(chooseUploadBtnLocator);
    }

    public String confirmFileUpload(){
        return find(fileUploadedLocator).getText();
    }

}
