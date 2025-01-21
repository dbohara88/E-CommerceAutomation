package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstract_component.AbstractComponent;

public class LandingPage extends AbstractComponent{

	private WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void url() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void loginApp() {
		
	}
}
