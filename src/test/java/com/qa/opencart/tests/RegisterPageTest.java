package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void regSetup() {
	regPage = loginPage.navigateToRegisterPage();
		
	}
	
	public String getRandomEmailId() {
		return "opencartnsj"+System.currentTimeMillis()+"@ope.com";
	}
	@DataProvider
	public Object[][] getUserRegData() {
		return new Object[][] {
			{"Himachal","Pradesh","9988998898","Tanishasharma13@", "yes"},
			{"Uttar","Pradesh","9988998818","Tanishasharma13@", "yes"},
			{"Bihar","Pradesh","9988998818","Tanishasharma13@", "yes"},
			{"Jharkhand","Pradesh","9988998818","Tanishasharma13@", "yes"},
		};
	}
	
	@DataProvider
	public Object[][] getUserRegSheetData() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}
	@Test(dataProvider = "getUserRegSheetData")
	public void userRegisterTest(String fn, String ln, String pn,String password, String subscribe) {
		Assert.assertTrue(regPage.registerUser(fn, ln, getRandomEmailId(), pn, password, subscribe)); 
	}

}
