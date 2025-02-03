package tests;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
//		
//		WebDriverWait wh = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wh.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("inventory_item")));
		
		
		By itemName = By.cssSelector(".inventory_item_name");
		By buttonClick = By.cssSelector(".pricebar button");
		List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item"));
		String productName = "Sauce Labs Fleece Jacket";
		//productList.stream().filter(s->s.findElement(itemName).getText().equalsIgnoreCase("Sauce Labs Fleece Jacket")).map(s->s.findElement(addToCartBttn)).forEach(s->s.click());
		productList.stream().filter(s-> s.findElement(itemName).getText().equalsIgnoreCase(productName)).map(s-> s.findElement(buttonClick)).forEach(s -> s.click());
		
		
		WebElement cartBttn = driver.findElement(By.cssSelector(".shopping_cart_link"));
		cartBttn.click();
		
		List<WebElement> cartProductList = driver.findElements(By.cssSelector(".cart_item"));
		By cartProductName = By.cssSelector(".inventory_item_name");
		
		System.out.println(driver.findElement(By.cssSelector(".inventory_item_name")).getText());
		Boolean match = cartProductList.stream().anyMatch(s -> s.findElement(cartProductName).getText().equalsIgnoreCase(productName));
		

	}

}
