package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class OrderPage extends TestBase{
	
	//Page Factory-OR
		@FindBy(xpath="//input[@name='username']")
		WebElement userName;

		@FindBy(xpath="//input[@name='password']")
		WebElement password;

		@FindBy(xpath="//input[@value='Login']")
		WebElement loginBtn;

}
