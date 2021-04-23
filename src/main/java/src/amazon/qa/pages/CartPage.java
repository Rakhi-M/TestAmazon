package src.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath="//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
	WebElement cartPrice;
	
	@FindBy(id="hlb-ptc-btn-native")
	WebElement proceedToCheckout;
	
	@FindBy(id="hlb-view-cart-announce")
	WebElement cart;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getcartPrice() {
		return cartPrice.getText();
	}
	
	public CheckoutPage clickOnCheckout() {
		proceedToCheckout.click();
		return new CheckoutPage();
	}
	
	public CartDetailPage clickOnCart() {
		cart.click();
		return new CartDetailPage();
		
	}

}
