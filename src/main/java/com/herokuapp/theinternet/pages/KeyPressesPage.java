package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage extends BasePageObject{

    private By bodyLocator = By.cssSelector("body");
    private By resultLocator = By.cssSelector("#result");

    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickKeyUsingLocator(Keys key){
        find(bodyLocator).sendKeys(key);
    }

    public void clickKeysUsingAction(Keys key){
        Actions actions = new Actions(driver);
        actions.sendKeys(key).build().perform();
    }

    public String getResultText(){
        return find(resultLocator).getText();
    }

}
