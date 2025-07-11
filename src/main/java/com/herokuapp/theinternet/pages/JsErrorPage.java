package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JsErrorPage extends WelcomePage {

    private By jsErrorLinkLocator = By.linkText("JavaScript onload event error");


    public JsErrorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


}
