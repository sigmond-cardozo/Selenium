package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePageObject {
    private By iframeLocator = By.id("mce_0_ifr");
    private By textLocator = By.cssSelector("#tinymce > p");

    public IframePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getEditorText(){
        driver.switchTo().frame(find(iframeLocator));
        return find(textLocator).getText();
    }


}
