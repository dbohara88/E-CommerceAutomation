package abstract_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

	private WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
