package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePageObject{

    private By newWindowBtnLocator = By.cssSelector("#content > div > a");

    public NewWindowPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickNewWindowBtn(){
        click(newWindowBtnLocator);
    }

    public NewWindowAfterClick switchToNewWindowPage(){
        switchToNewPageWithTitle("New Window");
        return new NewWindowAfterClick(driver,log);
    }

}
