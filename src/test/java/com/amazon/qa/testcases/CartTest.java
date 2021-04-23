package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;

import src.amazon.qa.pages.CartDetailPage;
import src.amazon.qa.pages.CartPage;
import src.amazon.qa.pages.HomePage;
import src.amazon.qa.pages.ProductDetailPage;
import src.amazon.qa.pages.ProductListingPage;
import src.amazon.qa.pages.SigninPage;

public class CartTest extends TestBase {
	HomePage homePage;
	SigninPage signinPage;
	ProductListingPage plpPage;
	ProductDetailPage pdpPage;
	CartPage cartPage;
	CartDetailPage cartDetailPage;
	CartTest(){
		super();
	}
	
	@BeforeMethod
	void setUp() {
		initialize();
		homePage=new HomePage();
		signinPage=homePage.clickLogin();
		homePage =signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
		if(homePage.getCartCount()>0) {
			cartDetailPage =homePage.clickCart();
			cartDetailPage.clearCart();
			homePage=cartDetailPage.clickOnContinue();	
		}
		homePage.clickCategory("Books");
		plpPage = homePage.searchItem("qa testing for beginners");
		pdpPage=plpPage.clickFirstProduct();
		cartPage=pdpPage.clickOnAddToCart();
		
		
	}
	
	@Test
	void cartTest() {
		Assert.assertEquals(cartPage.getcartPrice(), prop.getProperty("price"));
    }
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}


}
