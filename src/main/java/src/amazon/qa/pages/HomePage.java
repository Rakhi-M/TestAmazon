package src.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[normalize-space()='Account & Lists']")
	WebElement account;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="searchDropdownBox")
	WebElement searchCategory;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(id="nav-cart-count")
	WebElement cartIcon;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public SigninPage clickLogin() {
		account.click();
		return new SigninPage();
	}
	
	public int getCartCount() {
		int cartCount=Integer.valueOf(cartIcon.getText());
		return cartCount;
		
		}
	
	public CartDetailPage clickCart() {
		cartIcon.click();
		return new CartDetailPage();
	}
	
	
	public void clickCategory(String catName) {
		Select category=new Select(searchCategory);
		category.selectByVisibleText(catName);
		
	}
	public ProductListingPage searchItem(String itemName) {
		searchBox.click();
		searchBox.sendKeys(itemName);
		searchButton.click();
		return new ProductListingPage();
	}
}
