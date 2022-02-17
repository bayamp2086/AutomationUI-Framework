package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
	}
	
	@Test(priority=4)
	public void loginTest()
	{
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		boolean homeLink=homePage.verifyHomeLink();
		Assert.assertTrue(homeLink);
	}
	
	@Test(priority=3)
	public void loginTitleTest()
	{
		String title=loginPage.loginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=1)
	public void validateLoginBtnTest()
	{
		boolean actualLogin=loginPage.validateLoginBtn();
		Assert.assertTrue(actualLogin);
	}
	
	@Test(priority=2)
	public void validateSignUpTest()
	{
		boolean signUp=loginPage.validateSignUpBtn();
		Assert.assertTrue(signUp);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
