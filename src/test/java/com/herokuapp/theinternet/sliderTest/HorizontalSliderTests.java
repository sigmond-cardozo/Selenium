package com.herokuapp.theinternet.sliderTest;

import base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestUtilities {

	@Test
	public void sliderTest() {

		WelcomePage welcomePage = new WelcomePage(driver,log);

		welcomePage.openPage();

		HorizontalSliderPage horizontalSliderPage = welcomePage.clickSliderPageLink();

		String value = "3.5";

		horizontalSliderPage.setSliderTo(value);

		String sliderValue = horizontalSliderPage.getSliderValue();
		Assert.assertTrue(horizontalSliderPage.getSliderValue().equals(value), "Range is not correct. It is: " + sliderValue);
	}
}
