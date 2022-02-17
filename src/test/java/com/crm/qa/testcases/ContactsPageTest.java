package com.crm.qa.testcases;

import java.io.IOException;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		testUtil.switchToFrame();
		boolean contacts=contactsPage.verifyContactsLabel();
		Assert.assertTrue(contacts);
	}
	
	@Test(priority=2)
	public void verifyMouseOverContactsTest()
	{
		testUtil.switchToFrame();
		boolean firstNameLabel=contactsPage.mouseOverContacts();
		Assert.assertTrue(firstNameLabel);
	}
	
	@Test(priority=3,dependsOnMethods="verifyMouseOverContactsTest",dataProvider="addNewContact")
	public void verifyAddNewContactTest(String fname,String lname)
	{
		testUtil.switchToFrame();
		contactsPage.mouseOverContacts();
		boolean nameLabel=contactsPage.addNewContact(fname, lname);
		Assert.assertTrue(nameLabel);
	}
	
	//C:\eclipsews\FreeCRMProject\src\main\java\com\crm\qa\testdata\FreeCRMContacts.xlsx
	//@DataProvider(name="addNewContact")
	//public Object[][] getData()
	//{
		//Object[][] myData= {{"test","12"},{"test","13"},{"test","14"}};
		//return myData;
		
	//}
	
	@DataProvider(name = "addNewContact")
		public Iterator<Object[]> testData() throws IOException {
			return testUtil.parseCSVData("C:\\eclipsews\\FreeCRMProject\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMContacts.xlsx");
		}
		
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
