package page_objects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_component.AbstractComponent;

public class HomePage extends AbstractComponent{
	
	private WebDriver driver;
	
	@FindBy(id = "inventory_item")
	List<WebElement> productList;
	
	By prod = By.className("inventory_list"); //item container
	By itemName = By.className("inventory_item_name"); //item name
	By addToCartBttn = By.className(".pricebar button"); //add item
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> productList() {
		waitForElementToAppear(prod);
		return productList;
	}
	
	public void getProductByName(String productName) {
		productList.stream().filter(s -> s.findElement(itemName).getText().equalsIgnoreCase(productName)).map(s -> s.findElement(addToCartBttn)).forEach(s->s.click());
	}
}
