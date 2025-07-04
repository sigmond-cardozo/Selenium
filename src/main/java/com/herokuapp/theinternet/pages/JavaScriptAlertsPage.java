package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends WelcomePage {

    private By jsAlertBtnLocator = By.cssSelector("#content > div > ul > li:nth-child(1) > button");
    private By jsConfirmBtnLocator = By.cssSelector("#content > div > ul > li:nth-child(2) > button");
    private By jsPromptBtnLocator = By.cssSelector("#content > div > ul > li:nth-child(3) > button");
    private By alertResultLocator = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openJsAlert(){
        click(jsAlertBtnLocator);
    }

    public void openJsConfirm(){
        click(jsConfirmBtnLocator);
    }

    public void openJsPrompt(){
        click(jsPromptBtnLocator);
    }

    public String getAlertText(){
        Alert alert = switchToAlert();
        return alert.getText();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getResultText(){
        return find(alertResultLocator).getText();
    }

    public void enterAlertText(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
