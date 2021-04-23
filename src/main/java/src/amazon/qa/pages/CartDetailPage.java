package src.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class CartDetailPage extends TestBase{

	@FindBy(xpath="//span[@class='a-button a-button-dropdown quantity']")
	WebElement qtyDropdown;
	
	@FindBy(id="dropdown1_0")
	WebElement qty0;
	
	@FindBy(xpath="//a[normalize-space()='continue shopping']")
	WebElement contShop;
	
	public CartDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clearCart() {
		
		qtyDropdown.click();
		qty0.click();
	}
	
	public HomePage clickOnContinue() {
		contShop.click();
		return new HomePage();
	}
	
}
