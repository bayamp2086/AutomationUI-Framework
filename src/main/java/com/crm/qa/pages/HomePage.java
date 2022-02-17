package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	WebElement calender;
	
	@FindBy(xpath="//a[contains(text(),'Companies')]")
	WebElement companies;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyHomeLink()
	{
		return home.isDisplayed();
	}
	
	public HomePage clickOnHome()
	{
		home.click();
		return new HomePage();
	}
	
	public CalenderPage clickOnCalender()
	{
		calender.click();
		return new CalenderPage();
	}
	
	public CompaniesPage clickOnCompanies()
	{
		companies.click();
		return new CompaniesPage();
	}
	
	public ContactsPage clickOnContacts()
	{
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals()
	{
		deals.click();
		return new DealsPage();
	}

}
