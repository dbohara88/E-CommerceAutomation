package page_objects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_component.AbstractComponent;

public class HomePage extends AbstractComponent{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".inventory_item")
	List<WebElement> productList;
	
	
	
	By prod = By.cssSelector(".inventory_item"); //item container
	By itemName = By.cssSelector(".inventory_item_name"); //item name
	By addToCartBttn = By.cssSelector(".pricebar button"); //add item
	

	public List<WebElement> productList() {
		waitForElementToAppear(prod);
		return productList;
	}


	public void getProductByName(String productName) {
		waitForElementToAppear(prod);
		WebElement product  = productList.stream().filter(s->s.findElement(itemName).getText().trim().equalsIgnoreCase(productName.trim())).findFirst().orElseThrow(() -> new RuntimeException("Product not found: " + productName));
		WebElement addToCartButtonn = product.findElement(addToCartBttn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", addToCartButtonn);
	}	
}
