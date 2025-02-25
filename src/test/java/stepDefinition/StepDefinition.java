package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.CartPage;
import page_objects.CheckoutPage;
import page_objects.ConfirmationPage;
import page_objects.HomePage;
import page_objects.LandingPage;
import test_components.BaseTest;

public class StepDefinition extends BaseTest{	
	
	public LandingPage landingPage;
	public HomePage homepage;
	public CartPage cg;
	public CheckoutPage checkout;
	public ConfirmationPage confirm;
	
	@Given("I landed on E-Commerce Page")
	public void I_landed_on_ECommerce_Page() throws IOException {
		landingPage = launchApp();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		homepage = landingPage.loginApp(username, password);
	}
	
	@When("^I add the product (.+) from Cart$")
	public void I_add_the_product_from_Cart(String str1) throws InterruptedException {
		
		homepage.getProductByName(str1);
		
		cg = homepage.clickCart();
	}
	
	
	@And("^checkout the product (.+) (.+) (.+) (.+) and submit the order$")
	public void checkout_the_product_and_submit_the_order(String str1, String firstName, String lastName, String zipCode) {
		Boolean match = cg.productValue(str1);
		Assert.assertTrue(match);
		checkout = cg.clickCheckoutButton();
		checkout.setAddress(firstName, lastName, zipCode);
		confirm = checkout.placeOrder();
	}
	

	
	@Then("^I verify the (.+) text$")
	public void I_verify_the_text(String orderConfirmText) {
		String confirmMessage = confirm.thankYouText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(orderConfirmText));
		driver.close();
	}

}
