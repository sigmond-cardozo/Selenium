package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;


	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		// Create driver
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			driver.set(new FirefoxDriver());
			break;

		case "safari":
			driver.set(new SafariDriver());
			break;

		default:
			log.info("Do not know how to start: " + browser + ", starting chrome.");
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}

	public WebDriver createChromeWithProfile(String profile) {
		log.info("Starting chrome driver with profile: " + profile);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("user-data-dir=src/main/resources/profile/" + profile);
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}

	public WebDriver createChromeWithMobileEmulation(String deviceName) {
		log.info("Starting driver with " + deviceName + " emulation]");
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}
}
