package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstract_component.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart_item")
	List<WebElement> cartProductList;
	
	@FindBy(id = "checkout")
	WebElement checkoutBttn;
	
	By cartProductName = By.cssSelector(".inventory_item_name");
	
	public Boolean productValue(String productName){
		System.out.println(cartProductList.stream().anyMatch(s->s.findElement(cartProductName).getText().equalsIgnoreCase(productName)));
		return cartProductList.stream().anyMatch(s-> s.findElement(cartProductName).getText().equalsIgnoreCase(productName));
	}
	
	public CheckoutPage clickCheckoutButton() {
		checkoutBttn.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	
	
}
