package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory-OR
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;

	@FindBy(xpath="//input[@name='password']")
	WebElement password;

	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	//Initializing pageObjects
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public HomePage login(String un,String pwd)
	{
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLoginBtn()
	{
		return loginBtn.isDisplayed();
	
	}
	
	public boolean validateSignUpBtn()
	{
		return signUp.isDisplayed();
	}

}
