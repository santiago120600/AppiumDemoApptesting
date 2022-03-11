package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	private final AppiumDriver  driver;
	private WebDriverWait wait;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Accessibility']")
	private WebElement accesibility;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Animation']")
	private WebElement animation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App']")
	private WebElement app;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Content']")
	private WebElement content;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Graphics']")
	private WebElement graphics;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Media']")
	private WebElement media;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='NFC']")
	private WebElement nfc;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='OS']")
	private WebElement os;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	private WebElement preference;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Text']")
	private WebElement text;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	private WebElement views;

	public HomePage(AppiumDriver  driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
//        PageFactory.initElements(driver,this);
	}
	
	
	
	public WebElement getAccesibility() {
		return accesibility;
	}



	public void setAccesibility(WebElement accesibility) {
		this.accesibility = accesibility;
	}



	public WebElement getAnimation() {
		return animation;
	}



	public void setAnimation(WebElement animation) {
		this.animation = animation;
	}



	public WebElement getApp() {
		return app;
	}



	public void setApp(WebElement app) {
		this.app = app;
	}



	public WebElement getContent() {
		return content;
	}



	public void setContent(WebElement content) {
		this.content = content;
	}



	public WebElement getGraphics() {
		return graphics;
	}



	public void setGraphics(WebElement graphics) {
		this.graphics = graphics;
	}



	public WebElement getMedia() {
		return media;
	}



	public void setMedia(WebElement media) {
		this.media = media;
	}



	public WebElement getNfc() {
		return nfc;
	}



	public void setNfc(WebElement nfc) {
		this.nfc = nfc;
	}



	public WebElement getOs() {
		return os;
	}



	public void setOs(WebElement os) {
		this.os = os;
	}



	public WebElement getPreference() {
		return preference;
	}



	public void setPreference(WebElement preference) {
		this.preference = preference;
	}



	public WebElement getText() {
		return text;
	}



	public void setText(WebElement text) {
		this.text = text;
	}



	public WebElement getViews() {
		return views;
	}



	public void setViews(WebElement views) {
		this.views = views;
	}


}
