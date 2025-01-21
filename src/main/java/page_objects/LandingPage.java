package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_component.AbstractComponent;

public class LandingPage extends AbstractComponent{

	private WebDriver driver;
	
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(id="login-button")
	WebElement loginBttn;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void url() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void loginApp(String userID, String passKey) {
		userName.sendKeys(userID);
		pass.sendKeys(passKey);
		loginBttn.click();
	}
}
