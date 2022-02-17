package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	
	//Initializing the page objects
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public boolean mouseOverContacts()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLabel).build().perform();
		newContact.click();
		return firstName.isDisplayed();
	}
	
	public boolean addNewContact(String fname,String lname)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		save.click();
		boolean contactSaved=driver.findElement(By.xpath("//td[contains(text(),'"+fname+" "+lname+"')]")).isDisplayed();
		return contactSaved;
	}

}
