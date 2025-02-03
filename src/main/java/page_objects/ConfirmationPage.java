package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_component.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	private WebDriver driver;
	
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".complete-header")
	WebElement thanksText;
	
	public String thankYouText() {
		return thanksText.getText();
	}
}
