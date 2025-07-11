package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/";

//	enable commented line in BasePageObject
//	@FindBy(linkText="Checkboxes")
//	private WebElement checkboxLinkLocator;

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkboxLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javascriptalertsLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
	private By iframeLinkLocator = By.linkText("WYSIWYG Editor");
	private By keyPressesLinkLocator = By.linkText("Key Presses");
	private By fileUploadLinkLocator = By.linkText("File Upload");
	private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
	private By hoverLinkLocator = By.linkText("Hovers");
	private By sliderLinkLocator = By.linkText("Horizontal Slider");
	private By jsErrorLinkLocator = By.linkText("JavaScript onload event error");


	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Open LoginPage by clicking on Form Authentication Link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}

	public CheckboxesPage clickCheckboxesLink(){
		log.info("Clicking Checkboxes link on Welcome Page");

		//enable this when using private By locator
		click(checkboxLinkLocator);

		//enable this when using @FindBy
		//checkboxLinkLocator.click();

		return new CheckboxesPage(driver, log);
	}

	public DropdownPage clickDropdownLink (){
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}

	public JavaScriptAlertsPage clickJavascriptAlertsLink(){
		click(javascriptalertsLinkLocator);
		return new JavaScriptAlertsPage(driver,log);
	}

	public NewWindowPage clickMultipleWindowsLink(){
		click(multipleWindowsLinkLocator);
		return new NewWindowPage(driver, log);
	}

	public IframePage clickIFrameLink(){
		click(iframeLinkLocator);
		return new IframePage(driver,log);
	}

	public KeyPressesPage clickKeyPressesLink(){
		click(keyPressesLinkLocator);
		return new KeyPressesPage(driver,log);
	}

	public FileUploadPage clickFileUploadLink(){
		click(fileUploadLinkLocator);
		return new FileUploadPage(driver,log);
	}

	public DragAndDropPage clickDragAndDropLink(){
		click(dragAndDropLinkLocator);
		return new DragAndDropPage(driver,log);
	}

	public HoverPage clickHoverPageLink(){
		click(hoverLinkLocator);
		return new HoverPage(driver,log);
	}

	public HorizontalSliderPage clickSliderPageLink(){
		click(sliderLinkLocator);
		return new HorizontalSliderPage(driver,log);
	}

	public JsErrorPage clickJsErrorPageLink(){
		click(jsErrorLinkLocator);
		return new JsErrorPage(driver,log);
	}

	public void scrollToBottom(){
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
