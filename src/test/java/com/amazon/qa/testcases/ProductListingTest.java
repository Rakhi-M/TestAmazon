package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;

import src.amazon.qa.pages.HomePage;
import src.amazon.qa.pages.ProductDetailPage;
import src.amazon.qa.pages.ProductListingPage;
import src.amazon.qa.pages.SigninPage;

public class ProductListingTest extends TestBase {
	HomePage homePage;
	SigninPage signinPage;
	ProductListingPage plpPage;
	ProductDetailPage pdpPage;
	
	ProductListingTest(){
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
	
	@Test(enabled=false)
	void productListingTest() {
		pdpPage=plpPage.clickFirstProduct();
		
		
	}
	@AfterMethod
	void tearDown() {
		driver.quit();
	}


}
