package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;

import src.amazon.qa.pages.HomePage;
import src.amazon.qa.pages.ProductListingPage;
import src.amazon.qa.pages.SigninPage;

public class HomeTest extends TestBase{
	
	HomePage homePage;
	SigninPage signinPage;
	ProductListingPage plp;
	
	HomeTest(){
		super();
	}
	
	@BeforeMethod
	void setUp() {
		initialize();
		homePage=new HomePage();
		signinPage=homePage.clickLogin();
		homePage =signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(enabled=false)
	void searchBoxTest() {
		homePage.clickCategory("Books");
	    plp = homePage.searchItem("qa testing for beginners");
		Assert.assertEquals(driver.getTitle(), "Amazon.com : qa testing for beginners");
	}
	
	
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
