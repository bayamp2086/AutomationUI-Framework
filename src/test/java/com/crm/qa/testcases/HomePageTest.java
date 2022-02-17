package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CalenderPage calenderPage;
	CompaniesPage companiesPage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		testUtil=new TestUtil();
		calenderPage=new CalenderPage();
		companiesPage=new CompaniesPage();
		contactsPage=new ContactsPage();
		dealsPage=new DealsPage();
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyTitleTest()
	{
		String title=homePage.verifyTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void clickOnHomeTest()
	{
		testUtil.switchToFrame();
		homePage=homePage.clickOnHome();
	}
	
	@Test(priority=3)
	public void clickOnCalenderTest()
	{
		testUtil.switchToFrame();
		calenderPage=homePage.clickOnCalender();
		boolean calender=calenderPage.verifyCalenderLabel();
		Assert.assertTrue(calender);
	}
	
	@Test(priority=4)
	public void clickOnCompaniesTest()
	{
		testUtil.switchToFrame();
		companiesPage=homePage.clickOnCompanies();
		boolean companyName=companiesPage.verifyCompanyNameLabel();
		Assert.assertTrue(companyName);
	}
	
	@Test(priority=5)
	public void clickOnContactsTest()
	{
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContacts();
		boolean contacts=contactsPage.verifyContactsLabel();
		Assert.assertTrue(contacts);
	}
	
	@Test(priority=6)
	public void clickOnDealsTest()
	{
		testUtil.switchToFrame();
		dealsPage=homePage.clickOnDeals();
		boolean deals=dealsPage.verifyDealsLabel();
		Assert.assertTrue(deals);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
