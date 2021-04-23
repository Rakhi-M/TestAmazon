package src.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class ProductListingPage extends TestBase{
	
	@FindAll(@FindBy(xpath = "//*[@class='s-image']"))
	List<WebElement> productList;
	
	public ProductListingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductDetailPage clickFirstProduct() {
		productList.get(0).click();
		return new ProductDetailPage();
		
	}
	
	

}
