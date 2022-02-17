package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CompaniesPage extends TestBase{
	
	@FindBy(xpath="//strong[contains(text(),'Company Name')]")
	WebElement companyNameLabel;
	
	public CompaniesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCompanyNameLabel()
	{
		return companyNameLabel.isDisplayed();
	}

}
