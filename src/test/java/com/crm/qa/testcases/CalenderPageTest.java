package com.crm.qa.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalenderPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CalenderPage calenderPage;
	TestUtil testUtil;

	public CalenderPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		calenderPage=new CalenderPage();
		testUtil=new TestUtil();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(dataProvider="addCalenderData")
	public void selectCalenderTest(String input)
	{
		testUtil.switchToFrame();
		boolean timeBtn=calenderPage.selectCalender(input);
		Assert.assertTrue(timeBtn);
	}
	
	@Test
	public void selectCalenderByJSTest(String dataVal)
	{
		dataVal="32-October-2022";
		testUtil.switchToFrame();
		boolean timeBtn=calenderPage.selectCalenderByJS(dataVal);
		Assert.assertTrue(timeBtn);
	}
	
	
	@Test(expectedExceptions=NoSuchElementException.class)
	public void selectCalenderExceptionTest()
	{
		testUtil.switchToFrame();
		calenderPage.selectCalender("32-October-2022");
	}
	
	@DataProvider(name="addCalenderData")
	public Object[][] getData()
	{
		Object[][] myData= {{"18-October-2022"},{"11-November-2022"},{"8-March-2022"}};
		return myData;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
