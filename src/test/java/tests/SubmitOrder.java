package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page_objects.CartPage;
import page_objects.CheckoutPage;
import page_objects.ConfirmationPage;
import page_objects.HomePage;
import test_components.BaseTest;

public class SubmitOrder extends BaseTest{

	@Test(dataProvider="getData")
	public void test(HashMap<String, String> input) {
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.loginApp(input.get("userID"), input.get("pass"));
		
		HomePage homepage = landingPage.loginApp(input.get("userID"), input.get("pass"));
		
		//Adding to cart
		homepage.getProductByName(input.get("product"));
		CartPage cg = homepage.clickCart();
		
		Boolean match = cg.productValue(input.get("product"));
		Assert.assertTrue(match);
		
		CheckoutPage checkout = cg.clickCheckoutButton();
		checkout.setAddress(input.get("firstName"), input.get("lastName"), input.get("zipCode"));
		
		ConfirmationPage confirm = checkout.placeOrder();
		
		String confirmMessage = confirm.thankYouText();
		//System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/data/TestData.json");
		return new Object[][] {{data.get(0)}};
	}
}
