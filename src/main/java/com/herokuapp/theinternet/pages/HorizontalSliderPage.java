package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePageObject {

	private By rangeLocator = By.id("range");
	private By sliderLocator = By.tagName("input");

	public HorizontalSliderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void setSliderTo(String value) {
		log.info("Moving slider to " + value);

		// Move slider normal method
		// Find the xOffset using given value
//		 int width = find(sliderLocator).getSize().getWidth();
//		 log.info(width);
//		 double percent = Double.parseDouble(value) / 5;
//		 log.info(percent);
//		 double xMove = percent * width;
//		 log.info(xMove);
//		 int xOffset = (int) (xMove - width/2);
//		 log.info(xOffset);
//
//		 Actions action = new Actions(driver);
//		 action.dragAndDropBy(find(sliderLocator), xOffset, 0).build().perform();

		// Workaround method
		// Calculate number of steps
		int steps = (int) (Double.parseDouble(value) * 2);

		// Perform steps
		find(sliderLocator).sendKeys(Keys.ENTER);

		for (int i = 0; i < steps; i++) {
			find(sliderLocator).sendKeys(Keys.ARROW_RIGHT);
		}
	}

	public String getSliderValue() {
		String value = find(rangeLocator).getText();
		log.info("Slider value is " + value);
		return value;
	}
}
