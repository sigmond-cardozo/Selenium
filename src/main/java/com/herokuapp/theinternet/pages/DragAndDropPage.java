package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject{

    private By columnALocator = By.id("column-a");
    private By columnBLocator = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void dragAtoB(){
        performDragAndDrop(columnALocator,columnBLocator);
    }

    public String getColumnAText(){
        return find(columnALocator).getText();
    }

    public String getColumnBText(){
        return find(columnBLocator).getText();
    }
}
