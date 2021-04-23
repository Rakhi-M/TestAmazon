package src.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class ProductDetailPage extends TestBase{
	
	@FindBy(id="productTitle")
	WebElement productTitle;
	
	@FindBy(id="newBuyBoxPrice")
	WebElement price;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartBtn;
	
	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		return price.getText();
	}
	
	public CartPage clickOnAddToCart() {
		addToCartBtn.click();
		return new CartPage();
		
	}
	
	
	

}
