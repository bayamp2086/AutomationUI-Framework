package com.crm.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase{
	
	@FindBy(xpath="//input[contains(@value,'Show Calendar for Selected User')]")
	WebElement calender;
	
	@FindBy(xpath="//td[text()='Time']")
	WebElement timeBtn;
	
	@FindBy(xpath="//div[@id='crmcalendar']")
	WebElement calenderID;
	
	public CalenderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCalenderLabel()
	{
		return calender.isDisplayed();
	}
	
	public void selectDateByJS(WebDriver driver,WebElement element,String dataVal) 
	{
	   JavascriptExecutor js=((JavascriptExecutor)driver);
	   js.executeScript("arguments[0].setAttribute('value','"+dataVal+"');",element);
	   //return timeBtn.isDisplayed();
	  
	}
	
	public boolean selectCalenderByJS(String dataVal)
	{
		selectDateByJS(driver,calenderID,dataVal);
		return timeBtn.isDisplayed();
	}
	
	public boolean selectCalender(String dateSelect)
	{
		//String dateSelect="18-October-2022";
		String[] dates=dateSelect.split("-");
		String day=dates[0];
		String month=dates[1];
		String year=dates[2];
		
		Select selectMonth=new Select(driver.findElement(By.name("slctMonth")));
		selectMonth.selectByVisibleText(month);
		
		Select selectYear=new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(year);
		
		//div[@id='crmcalendar']/table/tbody/tr/td/table/tbody/tr[2]/td[1]
		//div[@id='crmcalender']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//div[@id='crmcalender]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		//div[@id='crmcalender]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]
		
		String beforeXpath="//div[@id='crmcalendar']/table/tbody/tr/td/table/tbody/tr[";
		String afterXpath="]/td[";
		final int totalWeekDays=7;
		boolean flag=false;
		String dayVal="";
		for(int rowCount=2;rowCount<=6;rowCount++)
		{
			for(int colCount=1;colCount<=totalWeekDays;colCount++)
			{
				try
				{
					dayVal=driver.findElement(By.xpath(beforeXpath+rowCount+afterXpath+colCount+"]")).getText();
				}catch(NoSuchElementException e) {
					flag=false;
					break;
				}
				System.out.println(dayVal);
				if(dayVal.equals(day))
				{
					driver.findElement(By.xpath(beforeXpath+rowCount+afterXpath+colCount+"]")).click();
					flag=true;
					break;	
				}
				if(flag)
				{
					break;
				}
				
			}
		}return timeBtn.isDisplayed();
		
	}

}
