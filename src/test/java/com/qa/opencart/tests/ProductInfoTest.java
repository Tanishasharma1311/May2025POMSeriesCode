package com.qa.opencart.tests;

import java.util.Map;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
@Epic("EPIC - 103: Design of the productInfoPage page for open cart app")
@Story("US - 203: implement productInfoPage features for open cart app")

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
    public Object[][] productTestData() {
    	return new Object[][]{{"macbook", "MacBook Pro"},
    	{"iMac", "iMac"},
    	{"samsung", "Samsung SyncMaster 941BW"},
    	};
    }
	
	@Test(dataProvider = "productTestData")
	public void productHeaderTest(String searchKey, String productName) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
	String actProductHeader =	productInfoPage.getProductHeaderValue();
	Assert.assertEquals(actProductHeader, productName);
	}
	
	@DataProvider
    public Object[][] productData() {
    	return new Object[][]{{"macbook", "MacBook Pro", 4},
    	{"iMac", "iMac", 3},
    	{"samsung", "Samsung SyncMaster 941BW", 1},
    	};
    }
	
	@Test(dataProvider = "productData")
	public void productImagesCountTest(String searchKey, String productName, int expProductImagesCount) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actProductImagesCount, expProductImagesCount);

	}
	@Test
	public void productInfoTest() {
		searchResPage = accPage.doSearch("macbook");
		productInfoPage = searchResPage.selectProduct("MacBook Pro");
		Map<String,String> productActualData = productInfoPage.getProductData();
		System.out.println("::::::::::"+productActualData);
		Assert.assertEquals(productActualData.get("Brand"), "Apple");
		Assert.assertEquals(productActualData.get("Availability"), "Out Of Stock");
		Assert.assertEquals(productActualData.get("productImages"), "4");
		
	}

}
