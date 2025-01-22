package abstract_component;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_objects.CartPage;

public class AbstractComponent {

	private WebDriver driver;
	
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartBttn;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CartPage clickCart() {
		cartBttn.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wh = new WebDriverWait(driver, Duration.ofSeconds(5));
		wh.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
}
