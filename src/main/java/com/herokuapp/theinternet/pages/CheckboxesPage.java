package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePageObject {

    private By checkboxLocator = By.cssSelector("#checkboxes > input");

    public CheckboxesPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void clickCheckboxes(){
        List<WebElement> checkboxes = findAll(checkboxLocator);
        for(WebElement checkbox:checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
    }

    public boolean areAllCheckboxesChecked(){
        List<WebElement> checkboxes = findAll(checkboxLocator);
        for (WebElement checkbox:checkboxes){
            if(!checkbox.isSelected())
                return false;
        }
    return true;
    }

}
