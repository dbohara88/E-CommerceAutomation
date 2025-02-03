package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_component.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	WebElement setFirstName;
	
	@FindBy(id = "last-name")
	WebElement setLastName;
	
	@FindBy(id = "postal-code")
	WebElement setZipCode;
	
	@FindBy(id = "continue")
	WebElement continueBttn;
	
	@FindBy(id = "finish")
	WebElement finishBttn;
	
	public void setAddress(String firstName, String lastName, String zipCode) {
		setFirstName.sendKeys(firstName);
		setLastName.sendKeys(lastName);
		setZipCode.sendKeys(zipCode);
		continueBttn.click();
		finishBttn.click();
	}
	
}
