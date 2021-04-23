package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;

import src.amazon.qa.pages.HomePage;
import src.amazon.qa.pages.ProductDetailPage;
import src.amazon.qa.pages.ProductListingPage;
import src.amazon.qa.pages.SigninPage;

public class ProductDetailTest extends TestBase{

	HomePage homePage;
	SigninPage signinPage;
	ProductListingPage plpPage;
	ProductDetailPage pdpPage;
	
	ProductDetailTest(){
		super();
	}
	
	@BeforeMethod
	void setUp() {
		initialize();
		homePage=new HomePage();
		signinPage=homePage.clickLogin();
		homePage =signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickCategory("Books");
		plpPage = homePage.searchItem("qa testing for beginners");		
	}
	
	@Test
	void productDetailTest() {
		pdpPage=plpPage.clickFirstProduct();
		Assert.assertEquals(pdpPage.getPrice(), prop.getProperty("price"));
    }
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}