package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By accHeaders = By.xpath("//div[@id='content']/h2");
	private By search = By.name("search");
	private By searchIcon = By.xpath("//div[@id='search']//button[@type='button']");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String getAccPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementPresence(logoutLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}

	public List<String> getAccountsPageHeader() {
		List<WebElement> headersList = eleUtil.waitForElementsVisible(accHeaders, AppConstants.MEDIUM_TIME_OUT);
		List<String> headersValList = new ArrayList<String>();
		for (WebElement e : headersList) {
			headersValList.add(e.getText());
		}
		return headersValList;
	}

	public int getAccountsPageHeaderCount() {
		List<WebElement> ele = eleUtil.waitForElementsVisible(accHeaders, AppConstants.MEDIUM_TIME_OUT);
		return ele.size();
	}
	
	public SearchResultsPage doSearch(String searchKey) {
	WebElement searchField =	eleUtil.waitForElementVisible(search, AppConstants.MEDIUM_TIME_OUT);
	searchField.clear();
	searchField.sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);
		
	}
	

}
