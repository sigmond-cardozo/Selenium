package com.herokuapp.theinternet.dragAndDrop;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestUtilities {

    @Test
    public void dragAndDropTest(){
        WelcomePage welcomePage = new WelcomePage(driver,log);

        welcomePage.openPage();

        DragAndDropPage dragAndDropPage= welcomePage.clickDragAndDropLink();

        dragAndDropPage.dragAtoB();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "A");

    }
}
