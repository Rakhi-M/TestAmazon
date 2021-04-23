package src.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SigninPage extends TestBase {
	HomePage homePage;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signInBtn;
	
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String userName, String passwd) {
		email.click();
		email.sendKeys(userName);
		continueBtn.click();
		password.click();
		password.sendKeys(passwd);
		signInBtn.click();
		return new HomePage();
		
	}

}
