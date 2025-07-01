package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoverPage extends BasePageObject{

    private By avatarLocator = By.className("figure");
    private By profileLinkLocator = By.xpath(".//a[contains(text(), 'View profile')]");

    public HoverPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void hoverOn(int i){
        List<WebElement> avatars = findAll(avatarLocator);
        hoverOverElement(avatars.get(i-1));
        avatars.get(i-1).findElement(profileLinkLocator).click();
    }
}
