package src.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CheckoutPage extends TestBase{
	
	
	@FindBy(xpath="//span[@dir='ltr']")
	WebElement checkoutPrice;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCheckoutPrice() {
		return checkoutPrice.getText();
	}
	

}
