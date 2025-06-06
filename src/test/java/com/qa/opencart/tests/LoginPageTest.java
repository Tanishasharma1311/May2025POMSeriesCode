package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("EPIC - 100: Design of the login page for open cart app")
@Story("US - 200: implement login page features for open cart app")

public class LoginPageTest extends BaseTest {
	@Description("login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		
	String actTitle = loginPage.getLoginPageTitle();
	Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Description("login page url test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageURLTest() {
		
	String actURL = loginPage.getLoginPageURL();
	Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("check forgot pwd link exist on login page")
	@Severity(SeverityLevel.NORMAL)
	
	@Test(priority = 3)
	public void isForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Description("check user is able to login to open cart with valid credentials")
	@Severity(SeverityLevel.NORMAL)
	
	@Test(priority = 4)
	public void loginTest() {
	accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertEquals(accPage.isLogoutLinkExist(), true);
		
	}

}
